class CalendarData {

    static final int YEAR = 2019

    static final def DAY_OF_WEEK_DEFAULTS = [
        0: "",
        1: CalendarConstants.SPLIT,
        2: CalendarConstants.SPLIT,
        3: CalendarConstants.SPLIT,
        4: CalendarConstants.SPLIT,
        5: CalendarConstants.SPLIT,
        6: "",
    ]

    static final def YEARS_FIRST_WEEKEND = CalendarConstants.DAD // start the first weekend of the year

    static final def WEEKEND_ALTERATIONS = [ // a list of Sundays when the weekend schedule is altered; an entry "stutters" the normal rotation.
        //"2019-4-1",
    ]

    static final def HOLIDAYS = [
        "2019-1-1":   [ odd: CalendarConstants.MOM, even: CalendarConstants.DAD, label: "New Years Day" ],

        "2019-1-21":  [ odd: CalendarConstants.DAD, even: CalendarConstants.MOM, label: "MLK Day" ],

        "2019-1-28":  [ odd: CalendarConstants.DAD, even: CalendarConstants.DAD, label: "Dad's Birthday" ],

        "2019-3-7":   [ odd: CalendarConstants.DAD, even: CalendarConstants.MOM, label: "Abner's Birthday" ],

        "2019-4-19":  [ odd: CalendarConstants.MOM, even: CalendarConstants.DAD, label: "Easter Weekend" ],
        "2019-4-20":  [ odd: CalendarConstants.MOM, even: CalendarConstants.DAD, label: "Easter Weekend" ],
        "2019-4-21":  [ odd: CalendarConstants.MOM, even: CalendarConstants.DAD, label: "Easter" ],

        "2019-5-12":  [ odd: CalendarConstants.MOM, even: CalendarConstants.MOM, label: "Mother's Day" ],

        "2019-5-28":  [ odd: CalendarConstants.MOM, even: CalendarConstants.DAD, label: "Geo's Birthday" ],

        "2019-5-24":  [ odd: CalendarConstants.DAD, even: CalendarConstants.MOM, label: "Memorial Day Weekend" ],
        "2019-5-25":  [ odd: CalendarConstants.DAD, even: CalendarConstants.MOM, label: "Memorial Day Weekend" ],
        "2019-5-26":  [ odd: CalendarConstants.DAD, even: CalendarConstants.MOM, label: "Memorial Day Weekend" ],
        "2019-5-27":  [ odd: CalendarConstants.DAD, even: CalendarConstants.MOM, label: "Memorial Day" ],

        "2019-6-16":  [ odd: CalendarConstants.DAD, even: CalendarConstants.DAD, label: "Father's Day" ],

        "2019-7-4":   [ odd: CalendarConstants.DAD, even: CalendarConstants.MOM, label: "4th of July" ],

        "2019-8-30":  [ odd: CalendarConstants.MOM, even: CalendarConstants.DAD, label: "Labour Day Weekend" ],
        "2019-8-31":  [ odd: CalendarConstants.MOM, even: CalendarConstants.DAD, label: "Labour Day Weekend" ],
        "2019-9-1":   [ odd: CalendarConstants.MOM, even: CalendarConstants.DAD, label: "Labour Day Weekend" ],
        "2019-9-2":   [ odd: CalendarConstants.MOM, even: CalendarConstants.DAD, label: "Labour Day" ],

        "2019-10-31": [ odd: CalendarConstants.DAD, even: CalendarConstants.MOM, label: "Halloween" ],

        "2019-11-28": [ odd: CalendarConstants.DAD, even: CalendarConstants.MOM, label: "Thanksgiving Day" ],
        "2019-11-29": [ odd: CalendarConstants.DAD, even: CalendarConstants.MOM, label: "Day After Thanksgiving" ],

        "2019-11-30": [ odd: CalendarConstants.MOM, even: CalendarConstants.DAD, label: "Thanksgiving Weekend" ],
        "2019-12-1":  [ odd: CalendarConstants.MOM, even: CalendarConstants.DAD, label: "Thanksgiving Weekend" ],

        "2019-12-21": [ odd: CalendarConstants.MOM, even: CalendarConstants.MOM, label: "Mom's Birthday" ],

        "2019-12-24": [ odd: CalendarConstants.DAD, even: CalendarConstants.MOM, label: "Christmas Eve" ],
        "2019-12-25": [ odd: CalendarConstants.MOM, even: CalendarConstants.DAD, label: "Christmas Day" ],

        "2019-12-31": [ odd: CalendarConstants.DAD, even: CalendarConstants.MOM, label: "New Years Eve" ],
    ]

    static final def CHANGES = [ // vacations, swaps, ...
        "2019-1-18": [ cssClass: CalendarConstants.DAD, label: "Mom Out of Town" ],
        "2019-1-19": [ cssClass: CalendarConstants.DAD, label: "Mom Out of Town" ],
        "2019-1-20": [ cssClass: CalendarConstants.DAD, label: "Mom Out of Town" ],
        "2019-1-21": [ cssClass: CalendarConstants.DAD, label: "Mom Out of Town" ],
        "2019-1-22": [ cssClass: CalendarConstants.DAD, label: "Mom Out of Town" ],
        "2019-1-23": [ cssClass: CalendarConstants.DAD, label: "Mom Out of Town" ],
        "2019-1-24": [ cssClass: CalendarConstants.DAD, label: "Mom Out of Town" ],
        "2019-1-25": [ cssClass: CalendarConstants.DAD, label: "Mom Out of Town" ],
        "2019-1-26": [ cssClass: CalendarConstants.DAD, label: "Mom Out of Town" ],
        "2019-1-27": [ cssClass: CalendarConstants.DAD, label: "Mom Out of Town" ],

        "2019-3-7": [ cssClass: CalendarConstants.MOM ],

        "2019-4-17": [ cssClass: CalendarConstants.DAD, label: "Mom Out of Town" ],
        "2019-4-18": [ cssClass: CalendarConstants.DAD, label: "Mom Out of Town" ],

        "2019-5-20": [ cssClass: CalendarConstants.MOM ],

        "2019-5-22": [ cssClass: CalendarConstants.DAD ],
        "2019-5-23": [ cssClass: CalendarConstants.MOM, label: "Dad Out of Town" ],
        "2019-5-24": [ cssClass: CalendarConstants.MOM, label: "Dad Out of Town" ],
        "2019-5-25": [ cssClass: CalendarConstants.MOM, label: "Dad Out of Town" ],
        "2019-5-26": [ cssClass: CalendarConstants.MOM, label: "Dad Out of Town" ],
        "2019-5-27": [ cssClass: CalendarConstants.MOM, label: "Dad Out of Town" ],
        "2019-5-28": [ cssClass: CalendarConstants.MOM, label: "Dad Out of Town" ],
        "2019-5-29": [ cssClass: CalendarConstants.MOM, label: "Dad Out of Town" ],
        "2019-5-30": [ cssClass: CalendarConstants.MOM, label: "Dad Out of Town" ],
        "2019-5-31": [ cssClass: CalendarConstants.MOM, label: "Dad Out of Town" ],

        "2019-6-1": [ cssClass: CalendarConstants.MOM, label: "Dad Out of Town" ],
        "2019-6-2": [ cssClass: CalendarConstants.MOM, label: "Dad Out of Town" ],
        "2019-6-3": [ cssClass: CalendarConstants.MOM, label: "Dad Out of Town" ],
        "2019-6-4": [ cssClass: CalendarConstants.MOM, label: "Dad Out of Town" ],
        "2019-6-5": [ cssClass: CalendarConstants.MOM, label: "Dad Out of Town" ],
        "2019-6-6": [ cssClass: CalendarConstants.MOM, label: "Dad Out of Town" ],
        "2019-6-7": [ cssClass: CalendarConstants.MOM, label: "Dad Out of Town" ],
        "2019-6-15": [ cssClass: CalendarConstants.DAD ],

        "2019-10-2": [ cssClass: CalendarConstants.MOM, label: "Dad Out of Town" ],
        "2019-10-3": [ cssClass: CalendarConstants.MOM, label: "Dad Out of Town" ],
        "2019-10-4": [ cssClass: CalendarConstants.MOM, label: "Dad Out of Town" ],
        "2019-10-5": [ cssClass: CalendarConstants.MOM, label: "Dad Out of Town" ],
        "2019-10-6": [ cssClass: CalendarConstants.MOM, label: "Dad Out of Town" ],

        "2019-10-13": [ cssClass: CalendarConstants.MOM, label: "Dad Out of Town" ],
        "2019-10-14": [ cssClass: CalendarConstants.MOM, label: "Dad Out of Town" ],

        "2019-11-2": [ cssClass: CalendarConstants.MOM, label: "PA trip" ],
        "2019-11-3": [ cssClass: CalendarConstants.MOM, label: "PA trip" ],
        "2019-11-4": [ cssClass: CalendarConstants.MOM, label: "PA trip" ],
        "2019-11-5": [ cssClass: CalendarConstants.MOM, label: "PA trip" ],
        "2019-11-6": [ cssClass: CalendarConstants.MOM, label: "PA trip" ],

        "2019-11-10": [ cssClass: CalendarConstants.DAD, label: "Mom Out of Town" ],
        "2019-11-11": [ cssClass: CalendarConstants.DAD, label: "Mom Out of Town" ],
        "2019-11-12": [ cssClass: CalendarConstants.DAD, label: "Mom Out of Town" ],
        "2019-11-13": [ cssClass: CalendarConstants.DAD, label: "Mom Out of Town" ],
        "2019-11-14": [ cssClass: CalendarConstants.DAD, label: "Mom Out of Town" ],
        "2019-11-15": [ cssClass: CalendarConstants.DAD, label: "Mom Out of Town" ],
        "2019-11-16": [ cssClass: CalendarConstants.DAD, label: "Mom Out of Town" ],
        "2019-11-17": [ cssClass: CalendarConstants.DAD, label: "Mom Out of Town" ],

        "2019-12-20": [ cssClass: CalendarConstants.MOM ],
    ]

    static final def NO_SCHOOL_DATES = [ // a list of dates without school
        "2019-1-1": CalendarConstants.NO_SCHOOL,
        "2019-1-21": CalendarConstants.NO_SCHOOL,
        "2019-1-25": CalendarConstants.NO_SCHOOL,

        "2019-2-18": CalendarConstants.NO_SCHOOL,

        "2019-3-1": CalendarConstants.NO_SCHOOL,

        "2019-4-1": CalendarConstants.NO_SCHOOL,
        "2019-4-2": CalendarConstants.NO_SCHOOL,
        "2019-4-3": CalendarConstants.NO_SCHOOL,
        "2019-4-4": CalendarConstants.NO_SCHOOL,
        "2019-4-5": CalendarConstants.NO_SCHOOL,
        "2019-4-19": CalendarConstants.NO_SCHOOL,

        "2019-5-27": CalendarConstants.NO_SCHOOL,
    ]

    static final def NOTES = [ // a list dates with of notes
        "2019-4-1": "Spring Break",
        "2019-4-2": "Spring Break",
        "2019-4-3": "Spring Break",
        "2019-4-4": "Spring Break",
        "2019-4-5": "Spring Break",

        "2019-6-7": "Last Day of School",
    ]

    static final List<String> AMMENDMENTS = [ // a list of ammendment notes
        "We amend our holiday agreement such that the boys are at the same location for both New Year's Eve and New Year's Day.",
        "With memorial day weekend being coincident with Alex's birthday, we modify our agreement to have the holiday and birthday always be spent with the same parent.",
        "Weekend of Mother's day be spent with Mom.",
        "Weekend of Father's day be spent with Dad.",
        "When Mom's birthday falls on a weekend the boys spend the entire weekend with Mom.",
        "When Dad's birthday falls on a weekend the boys spend the entire weekend with Dad.",
    ]

}
