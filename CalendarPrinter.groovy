import java.time.DayOfWeek
import java.time.LocalDate
import java.time.LocalTime
import java.time.Month
import java.time.format.TextStyle
import java.time.temporal.TemporalAdjusters

class CalendarPrinter {

    LocalDate printDate = LocalDate.now()
    LocalTime printTime = LocalTime.now()

    Map dayCounts = [:]

    void print(CalendarData data) {
        startDocument(data.YEAR)

        def weekend = data.YEARS_FIRST_WEEKEND

        // for each month
        (1..12).each { int month ->
            startMonth(data.YEAR, month)
            weekend = printWeeks(data.YEAR, month, weekend, data)
            finishMonth(month)
        }

        printAmmendments(data.AMMENDMENTS)

        printSummary()

        closeDocument()
    }

    void countDay(int month, String cssClass) {
        Map monthCounts = dayCounts[month]
        if (monthCounts == null) {
            monthCounts = [:]
            dayCounts[month] = monthCounts
        }

        int classCount = monthCounts[cssClass] ?: 0
        monthCounts[cssClass] = classCount + 1
    }

    void startDocument(Integer year) {
        println "<?xml version='1.0' encoding='utf-8'?>"
        println ""
        println "<html>"
        println ""
        println "  <head>"
        println "    <meta http-equiv='content-type' content='text/html; charset=UTF-8'/>"
        println "    <title>calendar-${year}</title>"
        println "    <link rel='stylesheet' type='text/css' href='css/calendar.css' />"
        println "  </head>"
        println ""
        println "  <body>"
    }

    void startMonth(int year, int month) {
        String monthLabel = Month.of(month).getDisplayName(TextStyle.FULL, Locale.US)

        println ""
        println "    <section>"
        println "      <h2>${monthLabel} ${year}</h2>"
        println "      <ul class='month-header'>"
        println "        <li class='day-of-week'>Sunday</li>"
        println "        <li class='day-of-week'>Monday</li>"
        println "        <li class='day-of-week'>Tuesday</li>"
        println "        <li class='day-of-week'>Wednesday</li>"
        println "        <li class='day-of-week'>Thursday</li>"
        println "        <li class='day-of-week'>Friday</li>"
        println "        <li class='day-of-week'>Saturday</li>"
        println "      </ul>"
    }

    def printWeeks(int year, int month, def weekend, CalendarData data) {

        LocalDate firstDate = new LocalDate(year, month, 1)
        LocalDate lastDate = firstDate.with(TemporalAdjusters.lastDayOfMonth())
        int daysInMonth = lastDate.dayOfMonth
        int monthStartsOnDay = (firstDate.dayOfWeek.value % 7) // Sunday == 0

        int day = 1 // counts up as we welk through the month
        int dayOfWeek = 0 // Sunday == 0

        println "      <ul class='row'>"
        // keep a counter of weeks, so we can pad all months to 6 weeks
        int numberOfWeeks = 1

        // if necessary, pad first week with blanks
        if (monthStartsOnDay != 0) {
            (1..monthStartsOnDay).each {
                println "        <li class='blank'></li>"
                dayOfWeek++
            }
        }

        // print the days of the month
        while (day <= daysInMonth) {

            String dateKey = "${year}-${month}-${day}"

            String parrentClass = generateParentCssClass(year, dayOfWeek, weekend, data, dateKey)
            String schoolClass = generateNoSchoolCssClasses(data, dateKey)
            String cssClass = "${parrentClass} ${schoolClass}"

            countDay(month, parrentClass)

            String notes = generateNotes(data, dateKey)

            // print the day
            println "        <li class='${cssClass}'>${day}<span class='notes'>${notes}</span></li>"

            if (dayOfWeek == 0) {
                weekend = nextWeekend(weekend, data, dateKey)
            }

            // if the current day is saturday, finish the week
            if (dayOfWeek == 6) {
                println "      </ul>"
                // if there are more days in the month, start another week
                if (day < daysInMonth) {
                    println "      <ul class='row'>"
                    numberOfWeeks++
                }

            } else if (day == daysInMonth) { // if it's the end of the month
                println "      </ul>"
            }

            dayOfWeek = (dayOfWeek + 1) % 7
            day++
        }

        while (numberOfWeeks < 6) {
            println "      <ul class='row'>"
            println "        <li class='blank'>"
            println "          <span class='notes'></span>"
            println "        </li>"
            println "      </ul>"
            numberOfWeeks++
        }

        return weekend
    }

    String generateParentCssClass(int year, int dayOfWeek, def weekend, CalendarData data, String dateKey) {
        String cssClass = ""

        // 1st check changes
        def change = data.CHANGES[dateKey]
        if (!cssClass && change) {
            cssClass = change.cssClass
        }

        // 2nd check holidays
        def holiday = data.HOLIDAYS[dateKey]
        if (!cssClass && holiday) {
            cssClass = ( (year % 2) ? holiday.odd : holiday.even )
        }

        // 3rd check weeks
        def week = data.WEEKS[dateKey]
        if (!cssClass && week) {
            cssClass = week
        }

        // finally check defaults
        if (!cssClass) {
            if (dayOfWeek in [0, 5, 6]) {
                cssClass = weekend
            } else {
                cssClass = data.DAY_OF_WEEK_DEFAULTS[dayOfWeek]
            }
        }

        return cssClass
    }

    String generateNoSchoolCssClasses(CalendarData data, String dateKey) {
        // check for no school
        return data.NO_SCHOOL_DATES[dateKey] ?: ""
    }

    String generateNotes(CalendarData data, String dateKey) {
        String notes = ""

        // 1st check holidays
        def holiday = data.HOLIDAYS[dateKey]
        if (holiday?.label) {
            notes += "<br />${holiday.label}"
        }

        // 2nd check changes
        def change = data.CHANGES[dateKey]
        if (change?.label) {
            notes += "<br />${change.label}"
        }

        // finally add additional notes
        def note = data.NOTES[dateKey]
        if (note) {
            notes += "<br />${note}"
        }

        return notes
    }

    // swap weekend, but only if this isn't one of those altered weekends
    def nextWeekend(def lastWeekend, CalendarData data, String dateKey) {
        if (dateKey in data.WEEKEND_ALTERATIONS) {
            // don't switch weekends
            return lastWeekend
        } else {
            // swap weekends
            return ( (lastWeekend == CalendarConstants.DAD) ? CalendarConstants.MOM : CalendarConstants.DAD )
        }
    }

    void finishMonth(int month) {
        println "      <br />"
        print "      <small>"
        print printTimestamp()
        print " ( ${dayCounts[month].dad}:${dayCounts[month].mom} )"
        println "</small>"
        println "    </section>"
    }

    void printAmmendments(List<String> ammendments) {
        if (ammendments) {
            println "    <section>"
            println "      <h2> Ammendments </h2>"
            println "      <ul>"
            ammendments.each { ammendment ->
                println "        <li>${ammendment}</li>"
            }
            println "      </ul>"
            println "      <br /> ${printTimestamp()}"
            println "    </section>"
        }
    }

    void printSummary() {

        int total = 0
        int dadTotal = 0
        int momTotal = 0

        println "    <section>"
        println "    </section>"
        println "    <section>"
        println "      <h2> Summary </h2>"

        println "      <table>"

        println "        <tr>"
        println "          <th class='centered'> </th>"
        println "          <th class='centered'> dad </th>"
        println "          <th class='centered'> + </th>"
        println "          <th class='centered'> mom </th>"
        println "          <th class='centered'> = </th>"
        println "          <th class='centered'> total </th>"
        println "        </tr>"
        dayCounts.each { month, counts ->
            String monthLabel = Month.of(month).getDisplayName(TextStyle.FULL, Locale.US)

            dadTotal += counts.dad
            momTotal += counts.mom

            int monthTotal = counts.dad + counts.mom

            total += monthTotal

            println "        <tr>"
            println "          <th class='centered'> ${monthLabel} </th>"
            println "          <td class='centered'> ${counts.dad} </td>"
            println "          <td class='centered'> + </td>"
            println "          <td class='centered'> ${counts.mom} </td>"
            println "          <td class='centered'> = </td>"
            println "          <td class='centered'> ${monthTotal} </td>"

            int dadPercent = (100 * counts.dad / monthTotal)
            //println "          <td class='centered'> ( ${dadPercent}% dad ) </td>"

            println "        </tr>"
        }
        println "        <tr>"
        println "          <th class='centered'> </th>"
        println "          <td class='centered'> ${dadTotal} </td>"
        println "          <td class='centered'> + </td>"
        println "          <td class='centered'> ${momTotal} </td>"
        println "          <td class='centered'> = </td>"
        println "          <td class='centered'> ${total} </td>"
        println "        </tr>"

        println "        <tr>"
        println "          <th class='centered'> </th>"
        println "          <td class='centered'> ${dadTotal - momTotal} </td>"
        println "          <td class='centered'> </td>"
        println "          <td class='centered'> ${momTotal - dadTotal} </td>"
        println "          <td class='centered'> </td>"
        println "          <td class='centered'> </td>"
        println "        </tr>"

        int percentagePrecision = 1
        println "        <tr>"
        println "          <th class='centered'> </th>"
        println "          <td class='centered'> ${((double)((dadTotal / total) * 100)).round(percentagePrecision)}% </td>"
        println "          <td class='centered'> </td>"
        println "          <td class='centered'> ${((double)((momTotal / total) * 100)).round(percentagePrecision)}% </td>"
        println "          <td class='centered'> </td>"
        println "          <td class='centered'> </td>"
        println "        </tr>"

        println "      </table>"

        println "      <br /> ${printTimestamp()}"
        println "    </section>"
    }

    String printTimestamp() {
        "${printDate} ${printTime.hour}:${printTime.minute}"
    }

    void closeDocument() {
        println ""
        println "  </body>"
        println ""
        println "</html>"
    }

}
