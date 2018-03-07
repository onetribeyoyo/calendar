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
        // for example
        "2018-4-1",
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
        // for example
        "2018-6-20": [ cssClass: CalendarConstants.MOM, label: "What's going on" ],
    ]

    static final def NO_SCHOOL_DATES = [ // a list of dates without school
        "2018-1-1": CalendarConstants.NO_SCHOOL,
        "2018-1-2": CalendarConstants.NO_SCHOOL,
        "2018-1-12": CalendarConstants.NO_UMA,
    ]

    static final def NOTES = [ // a list dates with of notes
        "2018-4-2": "Spring Break",
    ]

    static final List<String> AMMENDMENTS = [ // a list of ammendment notes
        "something of note",
    ]

}
