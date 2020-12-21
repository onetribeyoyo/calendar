class Main {

    static void main(String[] args) {

        def years = []
        args.each { yearStr ->
            try {
                years += yearStr.toInteger()
            } catch (NumberFormatException ignore) { }
        }
        if (!years) {
            // nothing provided on the command line, so default to the current year
            years += new Date().getYear() + 1900
        }
        years = years.sort()

        CalendarPrinter printer = new CalendarPrinter()
        printer.startDocument(years)
        years.each { year ->
            String dataClassName = "CalendarData${year}"
            CalendarData data = Class.forName(dataClassName).newInstance()
            printer.print(data)
        }
        printer.closeDocument()
    }

}
