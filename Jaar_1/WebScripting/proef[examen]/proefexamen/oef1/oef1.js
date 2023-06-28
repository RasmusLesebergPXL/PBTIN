// naam: Rasmus Leseberg

class Persoon {
    constructor(id, naam) {
        if (id <= 0) {
            throw new Error("de Id van deze Persoon moet groter zijn dan 0");
        }
        if (typeof naam !== 'string') {
            throw new Error("Geen geldige invoer voor naam");
        }
        this._id = id;
        this._naam = naam;
    }
    toString() {
        return `[${this._id}] ${this._naam}`;
    }
}

class Loonwerker extends Persoon {
    constructor(id, naam, loonPerUur, aantalUrenGewerkt) {
        super(id, naam);
        if (!(Number.isInteger(loonPerUur)) || loonPerUur < 0) {
            throw new Error("foute ingave voor LoonperUur");
        }
        if (!(Number.isInteger(aantalUrenGewerkt)) || aantalUrenGewerkt < 0) {
            throw new Error("foute ingave voor aantal Uren gewerkt");
        }
        this._loonPerUur = loonPerUur;
        this._aantalUrenGewerkt = aantalUrenGewerkt;
    }
    berekenLoon() {
        return this._aantalUrenGewerkt * this._loonPerUur;
    }
    toString() {
        return super.toString() + ` = ${this.berekenLoon()}`;
    }
}

class Manager extends Persoon {
    constructor(id, naam, loonWerkers) {
        super(id, naam);
        loonWerkers = [];
        this._loonWerkers = loonWerkers;
    }
    voegLoonWerkerToe(loonwerker) {
        if (!(loonwerker instanceof Loonwerker)) {
            throw new Error("het meegegeven Object is niet van de type Loonwerker")
        }
        this._loonWerkers.push(loonwerker)
    }
    berekenLoon() {
        let som = 0;
        for (let i = 0; i < this._loonWerkers.length; i++) {
            som += this._loonWerkers[i].berekenLoon() * 0.2;
        }
        return Math.round(som);
    }
    toString() {
        return super.toString() + ` = ${this.berekenLoon()}`;
    }
}

try {
    let persoon = new Persoon(1,"mieke");
    let manager=new Manager(2,"jan");
    let werker1=new Loonwerker(3,"tim",11,13);
    let werker2=new Loonwerker(4,"sofie",2,50);
    manager.voegLoonWerkerToe(werker1);
    manager.voegLoonWerkerToe(werker2);
    console.log(persoon.toString());
// [1] mieke
    console.log(werker1.toString());
// [3] tim = 143
    console.log(werker2.toString());
// [4] sofie = 100
    console.log(manager.toString());
// [2] jan = 49
}
catch (error) {
    console.log(error.toString());
}