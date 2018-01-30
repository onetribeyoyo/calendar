import java.time.DayOfWeek
import java.time.LocalDate
import java.time.Month
import java.time.format.TextStyle
import java.time.temporal.TemporalAdjusters

int year = 2018

def DAY_OF_WEEK_DEFAULTS = [ // unless otherwise specified
    0: "",
    1: "dad", 2: "dad",
    3: "mom", 4: "mom",
    5: "",
    6: "",
]
def YEARS_FIRST_WEEKEND = "mom" // for first weekend of the year
def HOLIDAYS = [
]
def VACATIONS = [
]
def WEEKEND_ALTERATIONS = [ // a list of saturdays when the weekend schedule is altered
]

// start the document

println "<?xml version='1.0' encoding='utf-8'?>"
println ""
println "<html>"
println ""
println "  <head>"
println "    <meta http-equiv='content-type' content='text/html; charset=UTF-8'/>"
println "    <title>grid</title>"
println "    <link rel='stylesheet' type='text/css' media='screen' href='css/amiller.css' />"
println "    <link rel='stylesheet' type='text/css' media='screen' href='css/amiller-bb.css' />"
println "    <link rel='stylesheet' type='text/css' media='screen,print' href='css/calendar-grid.css' />"
println "  </head>"
println ""
println "  <body>"


def weekendAt = YEARS_FIRST_WEEKEND

// for each month
(1..11).each { month ->

    String monthLabel = Month.of(month).getDisplayName(TextStyle.FULL, Locale.US)

    LocalDate firstDate = new LocalDate(year, month, 1)
    LocalDate lastDate = firstDate.with(TemporalAdjusters.lastDayOfMonth())
    int daysInMonth = lastDate.dayOfMonth
    int monthStartsOnDay = (firstDate.dayOfWeek.value % 7) // Sunday == 0

    int day = 1 // counts up as we welk through the month
    int dayOfWeek = 0 // Sunday == 0

    /*
    println "    <section>"
    println "      <h2>data for ${monthLabel} ${year}</h2>"
    println "      <ul>"
    println "        <li> monthLabel: ${monthLabel} </li>"
    println "        <li> firstDate: ${firstDate} </li>"
    println "        <li> lastDate: ${lastDate} </li>"
    println "        <li> daysInMonth: ${daysInMonth} </li>"
    println "        <li> monthStartsOnDay: ${monthStartsOnDay} </li>"
    println "        <li> day: ${day} </li>"
    println "        <li>dayOfWeek: ${dayOfWeek} </li>"
    println "      </ul>"
    println "    </section>"
    */

    // start the month
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

    println "      <ul class='row'>"

    // if necessary, pad first week with blanks
    if (monthStartsOnDay != 0) {
        (1..monthStartsOnDay).each {
            println "        <li class='blank'></li>"
            dayOfWeek++
        }
    }

    // print the days of the month
    while (day <= daysInMonth) {

        String cssClass = ""
        String notes = ""

        String dateKey = "${year}-${month}-${day}"

        // 1st check holidays
        def holiday = HOLIDAYS[dateKey]
        if (holiday) {
            cssClass = ( (year % 2) ? holiday.odd : holiday.even )
            if (holiday.label) {
                notes += "<br />${holiday.label}"
            }
        }

        // 2nd check vacations
        def vacation = VACATIONS[dateKey]
        if (!cssClass && vacation) {
            cssClass = vacation.cssClass
            if (vacation.label) {
                notes += "<br />${vacation.label}"
            }
        }

        // 3rd check defaults
        if (!cssClass) {
            if (dayOfWeek in [0, 5, 6]) {
                cssClass = weekendAt
            } else {
                cssClass = DAY_OF_WEEK_DEFAULTS[dayOfWeek]
            }
        }
        if (dayOfWeek == 0) {
            // after each Sunday, swap weekendAt, but only if this isn't one of those altered weekends
            if (!(dateKey in WEEKEND_ALTERATIONS))  {
                weekendAt = ( (weekendAt == "dad") ? "mom" : "dad" )
            }
        }

        // print the day
        println "        <li class='${cssClass}'>${day}${notes}</li>"

        // if the current day is saturday, finish the week
        if (dayOfWeek == 6) {
            println "      </ul>"
            // if there are more days in the month, start another week
            if (day < daysInMonth) {
                println "      <ul class='row'>"
            }

        } else if (day == daysInMonth) { // if it's the end of the month
            println "      </ul>"
        }

        dayOfWeek = (dayOfWeek + 1) % 7
        day++
    }

    // finish the month
    println "    </section>"
}

// display the ammendments


println "    <section>"
println "      <h2> Ammendments </h2>"
println "      <ul>"
println "      <li>We amend our holiday agreement such that the boys are at the same location for both New Year's Eve and New Year's Day.</li>"
println "      <li>With memorial day weekend being coincident with Alex's birthday, I suggest we modify our agreement to have the two always be spent with the same parent.</li>"
println "      <li>Weekend of Mother's day be spent with Mom.</li>"
println "      <li>Weekend of Father's day be spent with Dad.</li>"
println "      <li>When Mom's birthday falls on a weekend the boys spend the entire weekend with Mom.</li>"
println "      <li>When Dad's birthday falls on a weekend the boys spend the entire weekend with Dad.</li>"
println "      </ul>"
println "    </section>"

// close the document

println ""
println "  </body>"
println ""
println "</html>"
