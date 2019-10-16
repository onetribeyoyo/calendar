class CalendarData {

    static final int YEAR = 2018

    static final def DAY_OF_WEEK_DEFAULTS = [
        0: "",
        1: CalendarConstants.DAD,
        2: CalendarConstants.DAD,
        3: CalendarConstants.MOM,
        4: CalendarConstants.MOM,
        5: "",
        6: "",
    ]

    static final def YEARS_FIRST_WEEKEND = CalendarConstants.MOM // start the first weekend of the year

    static final def WEEKEND_ALTERATIONS = [ // a list of Sundays when the weekend schedule is altered; an entry "stutters" the normal rotation.
        "2018-4-1",
        "2018-5-6",
        //"2018-5-27",
        //"2018-6-10",
        //"2018-9-2",
        "2018-11-25",
        "2018-12-2",
    ]

    static final def HOLIDAYS = [
        "2018-1-1":   [ odd: CalendarConstants.MOM, even: CalendarConstants.DAD, label: "New Years Day" ],

        "2018-1-15":  [ odd: CalendarConstants.DAD, even: CalendarConstants.MOM, label: "MLK Day" ],

        "2018-3-30":  [ odd: CalendarConstants.MOM, even: CalendarConstants.DAD, label: "Easter Weekend" ],
        "2018-3-31":  [ odd: CalendarConstants.MOM, even: CalendarConstants.DAD, label: "Easter Weekend" ],
        "2018-4-1":   [ odd: CalendarConstants.MOM, even: CalendarConstants.DAD, label: "Easter" ],

        "2018-5-13":  [ odd: CalendarConstants.MOM, even: CalendarConstants.MOM, label: "Mother's Day" ],

        "2018-5-25":  [ odd: CalendarConstants.MOM, even: CalendarConstants.DAD, label: "Memorial Day Weekend" ],
        "2018-5-26":  [ odd: CalendarConstants.MOM, even: CalendarConstants.DAD, label: "Memorial Day Weekend" ],
        "2018-5-27":  [ odd: CalendarConstants.MOM, even: CalendarConstants.DAD, label: "Memorial Day Weekend" ],
        //"2018-5-28":  [ odd: CalendarConstants.MOM, even: CalendarConstants.DAD, label: "Memorial Day" ],

        "2018-6-17":  [ odd: CalendarConstants.DAD, even: CalendarConstants.DAD, label: "Father's Day" ],

        "2018-7-4":   [ odd: CalendarConstants.DAD, even: CalendarConstants.MOM, label: "4th of July" ],

        "2018-8-31":  [ odd: CalendarConstants.MOM, even: CalendarConstants.DAD, label: "Labour Day Weekend" ],
        "2018-9-1":   [ odd: CalendarConstants.MOM, even: CalendarConstants.DAD, label: "Labour Day Weekend" ],
        "2018-9-2":   [ odd: CalendarConstants.MOM, even: CalendarConstants.DAD, label: "Labour Day Weekend" ],
        "2018-9-3":   [ odd: CalendarConstants.MOM, even: CalendarConstants.DAD, label: "Labour Day" ],

        "2018-10-31": [ odd: CalendarConstants.DAD, even: CalendarConstants.MOM, label: "Halloween" ],

        "2018-11-22": [ odd: CalendarConstants.DAD, even: CalendarConstants.MOM, label: "Thanksgiving Day" ],
        "2018-11-23": [ odd: CalendarConstants.DAD, even: CalendarConstants.MOM, label: "Day After Thanksgiving" ],

        "2018-11-24": [ odd: CalendarConstants.MOM, even: CalendarConstants.DAD, label: "Thanksgiving Weekend" ],
        "2018-11-25": [ odd: CalendarConstants.MOM, even: CalendarConstants.DAD, label: "Thanksgiving Weekend" ],

        "2018-12-24": [ odd: CalendarConstants.DAD, even: CalendarConstants.MOM, label: "Christmas Eve" ],
        "2018-12-25": [ odd: CalendarConstants.MOM, even: CalendarConstants.DAD, label: "Christmas Day" ],

        "2018-12-31": [ odd: CalendarConstants.DAD, even: CalendarConstants.MOM, label: "New Years Eve" ],
    ]

    static final def CHANGES = [ // vacations, swaps, ...
        "2018-2-7": [ cssClass: CalendarConstants.MOM, label: "Grandma's B-day" ],
        "2018-2-8": [ cssClass: CalendarConstants.MOM, label: "Grandma's B-day" ],
        "2018-2-9": [ cssClass: CalendarConstants.MOM, label: "Grandma's B-day" ],
        "2018-2-10": [ cssClass: CalendarConstants.MOM, label: "Grandma's B-day" ],
        "2018-2-11": [ cssClass: CalendarConstants.MOM, label: "Grandma's B-day" ],

        "2018-4-25": [ cssClass: CalendarConstants.DAD, label: "Mom Out of Town" ],
        "2018-4-26": [ cssClass: CalendarConstants.DAD, label: "Mom Out of Town" ],

        "2018-5-23": [ cssClass: CalendarConstants.DAD, label: "Mom Out of Town" ],
        "2018-5-24": [ cssClass: CalendarConstants.DAD, label: "Mom Out of Town" ],
        "2018-5-25": [ cssClass: CalendarConstants.DAD, label: "Mom Out of Town" ],
        "2018-5-26": [ cssClass: CalendarConstants.DAD, label: "Mom Out of Town" ],
        "2018-5-27": [ cssClass: CalendarConstants.DAD, label: "Mom Out of Town" ],
        "2018-5-28": [ cssClass: CalendarConstants.DAD, label: "Mom Out of Town" ],
        "2018-5-29": [ cssClass: CalendarConstants.DAD, label: "Mom Out of Town" ],
        //"2018-5-30": [ cssClass: CalendarConstants.DAD, label: "Mom Out of Town" ], // back early tht day

        "2018-6-20": [ cssClass: CalendarConstants.MOM, label: "Dad Out of Town" ],
        "2018-6-21": [ cssClass: CalendarConstants.MOM, label: "Dad Out of Town" ],
        "2018-6-22": [ cssClass: CalendarConstants.MOM, label: "Dad Out of Town" ],
        "2018-6-23": [ cssClass: CalendarConstants.MOM, label: "Dad Out of Town" ],

        "2018-6-25": [ cssClass: CalendarConstants.MOM, label: "Dad Out of Town" ],
        "2018-6-26": [ cssClass: CalendarConstants.MOM, label: "Dad Out of Town" ],
        "2018-6-27": [ cssClass: CalendarConstants.MOM, label: "Dad Out of Town" ],

        "2018-8-6": [ cssClass: CalendarConstants.MOM ],
        "2018-8-7": [ cssClass: CalendarConstants.MOM ],
        "2018-8-8": [ cssClass: CalendarConstants.DAD ],
        "2018-8-9": [ cssClass: CalendarConstants.DAD ],

        "2018-8-10": [ cssClass: CalendarConstants.DAD, label: "Woodward" ],
        "2018-8-11": [ cssClass: CalendarConstants.DAD, label: "Woodward" ],
        "2018-8-12": [ cssClass: CalendarConstants.DAD, label: "Woodward" ],
        "2018-8-13": [ cssClass: CalendarConstants.DAD, label: "Woodward" ],
        "2018-8-14": [ cssClass: CalendarConstants.DAD, label: "Woodward" ],
        "2018-8-15": [ cssClass: CalendarConstants.DAD, label: "Woodward" ],
        "2018-8-16": [ cssClass: CalendarConstants.DAD, label: "Woodward" ],
        "2018-8-17": [ cssClass: CalendarConstants.DAD, label: "Woodward" ],

        "2018-8-18": [ cssClass: CalendarConstants.MOM, label: "PA trip" ],
        "2018-8-19": [ cssClass: CalendarConstants.MOM, label: "PA trip" ],
        "2018-8-20": [ cssClass: CalendarConstants.MOM, label: "PA trip" ],
        "2018-8-21": [ cssClass: CalendarConstants.MOM, label: "PA trip" ],
        "2018-8-22": [ cssClass: CalendarConstants.MOM, label: "PA trip" ],

        "2018-10-26": [ cssClass: CalendarConstants.DAD, label: "(home security?)" ],

        "2018-12-25": [ cssClass: CalendarConstants.DAD, label: "Mom Out of Town" ],
        "2018-12-26": [ cssClass: CalendarConstants.DAD, label: "Mom Out of Town" ],
        "2018-12-27": [ cssClass: CalendarConstants.DAD, label: "Mom Out of Town" ],
        "2018-12-28": [ cssClass: CalendarConstants.DAD, label: "Mom Out of Town" ],
        "2018-12-29": [ cssClass: CalendarConstants.DAD, label: "Mom Out of Town" ],
        "2018-12-30": [ cssClass: CalendarConstants.DAD, label: "Mom Out of Town" ],
    ]

    static final def NO_SCHOOL_DATES = [ // a list of dates without school
        "2018-1-1": CalendarConstants.NO_SCHOOL,
        "2018-1-2": CalendarConstants.NO_SCHOOL,
        "2018-1-12": CalendarConstants.NO_UMA,
        "2018-1-15": CalendarConstants.NO_SCHOOL,
        "2018-1-26": CalendarConstants.NO_SPPS,

        "2018-2-16": CalendarConstants.NO_UMA,
        "2018-2-19": CalendarConstants.NO_SCHOOL,

        "2018-3-16": CalendarConstants.NO_UMA,
        "2018-3-30": CalendarConstants.NO_SPPS,

        "2018-4-2": CalendarConstants.NO_SCHOOL,
        "2018-4-3": CalendarConstants.NO_SCHOOL,
        "2018-4-4": CalendarConstants.NO_SCHOOL,
        "2018-4-5": CalendarConstants.NO_SCHOOL,
        "2018-4-6": CalendarConstants.NO_SCHOOL,
        "2018-4-20": CalendarConstants.NO_UMA,

        "2018-5-4": CalendarConstants.NO_UMA,
        "2018-5-25": CalendarConstants.NO_UMA,
        "2018-5-28": CalendarConstants.NO_SCHOOL,

        "2018-10-18": CalendarConstants.NO_SCHOOL,
        "2018-10-19": CalendarConstants.NO_SCHOOL,

        "2018-11-16": CalendarConstants.NO_SCHOOL,
        "2018-11-22": CalendarConstants.NO_SCHOOL,
        "2018-11-23": CalendarConstants.NO_SCHOOL,

        "2018-12-21": CalendarConstants.NO_SCHOOL,
        "2018-12-24": CalendarConstants.NO_SCHOOL,
        "2018-12-25": CalendarConstants.NO_SCHOOL,
        "2018-12-26": CalendarConstants.NO_SCHOOL,
        "2018-12-27": CalendarConstants.NO_SCHOOL,
        "2018-12-28": CalendarConstants.NO_SCHOOL,
        "2018-12-31": CalendarConstants.NO_SCHOOL,
    ]

    static final def NOTES = [ // a list dates with of notes
        "2018-4-2": "Spring Break",
        "2018-4-3": "Spring Break",
        "2018-4-4": "Spring Break",
        "2018-4-5": "Spring Break",
        "2018-4-6": "Spring Break",

        "2018-6-8": "Last Day of School",

        "2018-7-23": "La Semana",
        "2018-7-24": "La Semana",
        "2018-7-25": "La Semana",
        "2018-7-26": "La Semana",
        "2018-7-27": "La Semana",

        "2018-5-9": "<strong>~Abner~</strong>",
        "2018-5-10": "<strong>~Abner~</strong>",
        "2018-5-16": "<strong>~Abner~</strong>",
        "2018-5-17": "<strong>~Abner~</strong>",
        "2018-5-30": "<strong>~Abner~</strong>",
        "2018-5-31": "<strong>~Abner~</strong>",
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
