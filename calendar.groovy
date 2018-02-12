import java.time.DayOfWeek
import java.time.LocalDate
import java.time.Month
import java.time.format.TextStyle
import java.time.temporal.TemporalAdjusters

int year = 2018

String pageTitle = "calendar-${year}"

def DAD = "dad" // css class for nights spent with Dad
def MOM = "mom" // css class for nights spent with Mom

def DAY_OF_WEEK_DEFAULTS = [ // unless otherwise specified
    0: "",
    1: DAD,
    2: DAD,
    3: MOM,
    4: MOM,
    5: "",
    6: "",
]
def YEARS_FIRST_WEEKEND = MOM // start the first weekend of the year
def WEEKEND_ALTERATIONS = [ // a list of Sundays when the weekend schedule is altered; an entry "stutters" the normal rotation.
]

def HOLIDAYS = [
    "2018-1-1":   [ odd: MOM, even: DAD, label: "New Years Day" ],

    "2018-1-15":  [ odd: DAD, even: MOM, label: "MLK Day" ],

    "2018-3-30":  [ odd: MOM, even: DAD, label: "Easter Weekend" ],
    "2018-3-31":  [ odd: MOM, even: DAD, label: "Easter Weekend" ],
    "2018-4-1":   [ odd: MOM, even: DAD, label: "Easter" ],

    "2018-5-13":  [ odd: MOM, even: MOM, label: "Mother's Day" ],

    "2018-5-25":  [ odd: MOM, even: DAD, label: "Memorial Day Weekend" ],
    "2018-5-26":  [ odd: MOM, even: DAD, label: "Memorial Day Weekend" ],
    "2018-5-27":  [ odd: MOM, even: DAD, label: "Memorial Day Weekend" ],
    //"2018-5-28":  [ odd: MOM, even: DAD, label: "Memorial Day" ],

    "2018-6-17":  [ odd: DAD, even: DAD, label: "Father's Day" ],

    "2018-7-4":   [ odd: DAD, even: MOM, label: "4th of July" ],

    "2018-8-31":  [ odd: MOM, even: DAD, label: "Labour Day Weekend" ],
    "2018-9-1":   [ odd: MOM, even: DAD, label: "Labour Day Weekend" ],
    "2018-9-2":   [ odd: MOM, even: DAD, label: "Labour Day Weekend" ],
    "2018-9-3":   [ odd: MOM, even: DAD, label: "Labour Day" ],

    "2018-10-31": [ odd: DAD, even: MOM, label: "Halloween" ],

    "2018-11-22": [ odd: DAD, even: MOM, label: "Thanksgiving Day" ],
    "2018-11-23": [ odd: DAD, even: MOM, label: "Day After Thanksgiving" ],

    "2018-11-24": [ odd: MOM, even: DAD, label: "Thanksgiving Weekend" ],
    "2018-11-25": [ odd: MOM, even: DAD, label: "Thanksgiving Weekend" ],

    "2018-12-24": [ odd: DAD, even: MOM, label: "Christmas Eve" ],
    "2018-12-25": [ odd: MOM, even: DAD, label: "Christmas Day" ],

    "2018-12-31": [ odd: DAD, even: MOM, label: "New Years Eve" ],
]
def VACATIONS = [
]

def NO_SCHOOL = "no-school" // css class for no school
def NO_SPPS   = "no-spps"   // css class for no spps
def NO_UMA    = "no-uma"    // css class for no uma
def NO_SCHOOL_DATES = [     // a list of dates without school
]

def NOTES = [ // a list dates with of notes
]

def AMMENDMENTS = [
]

// start the document

println "<?xml version='1.0' encoding='utf-8'?>"
println ""
println "<html>"
println ""
println "  <head>"
println "    <meta http-equiv='content-type' content='text/html; charset=UTF-8'/>"
println "    <title>${pageTitle}</title>"
println "    <link rel='stylesheet' type='text/css' href='css/calendar.css' />"
println "  </head>"
println ""
println "  <body>"

def weekendAt = YEARS_FIRST_WEEKEND

// for each month
(1..12).each { month ->

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
                weekendAt = ( (weekendAt == DAD) ? MOM : DAD )
            }
        }

        // check for no school
        def noSchool = NO_SCHOOL_DATES[dateKey]
        if (noSchool) {
            cssClass += " ${noSchool}"
        }

        // add additional notes
        def note = NOTES[dateKey]
        if (note) {
            notes += "<br />${note}"
        }


        // print the day
        println "        <li class='${cssClass}'>${day}<span class='notes'>${notes}</span></li>"

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
AMMENDMENTS.each { ammendment ->
    println "        <li>${ammendment}</li>"
}
println "      </ul>"
println "    </section>"

// close the document

println ""
println "  </body>"
println ""
println "</html>"
