class Date {
    constructor(day, month, year) {
        this._day = day;
        this._month = month;
        this._year = year;
    }
    print() {
        console.log(`${this._day}/${this._month}/${this._year}`)
    }
    static make(day, month, year) {
        return new Date(day, month, year);
    }
    static get MONTHS() {
        return ['jan', 'feb', 'mar', 'apr', 'may', 'jun', 'jul', 'aug', 'sep', 'oct', 'nov', 'dec']
    }
    printMonth() {
        this._month = Date.MONTHS[this._month - 1];
        this.print()
    }
}

let date1 = Date.make(1, 2, 2001)
date1.print();
date1.printMonth();