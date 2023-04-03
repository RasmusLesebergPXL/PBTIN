//naam: Rasmus Leseberg
'use strict';

class RekeningError extends Error {}

class Bankrekening {
    constructor(rekeningnummer, bedrag, klantnummer) {
        if (Bankrekening.controleerRekeningnummer(rekeningnummer)) {
            this._rekeningnummer = rekeningnummer;
        }
        if (!(Number.isInteger(bedrag)) || bedrag < 0) {
            throw new RekeningError("het bedrag moet een psotief getal zijn");
        }
        this._bedrag = bedrag;
        this._klantnummer = klantnummer;
    }
    get rekeningnummer() {
        return this._rekeningnummer;
    }

    get bedrag() {
        return this._bedrag;
    }

    get klantnummer() {
        return this._klantnummer;
    }

    wijzigSaldo(getal) {
        if (!(Number.isInteger(getal))) {
            throw new RekeningError("Enkel getallen meegeven");
        }
        if (getal < 0 && this._bedrag - getal < 0) {
            throw new RekeningError("Saldo is ontoereikend");
        }
        this._bedrag += getal;
    }

    overschrijving(bankrekening, bedrag) {
        if (!(bankrekening instanceof Bankrekening)) {
            throw new RekeningError("Dit is geen juist rekeningnummer");
        }
        bankrekening.wijzigSaldo(bedrag);
    }
    static controleerRekeningnummer(rekeningnummer) {
        if (!(/[A-Z]/.test(rekeningnummer.charAt(0))) && !(/[A-Z]/.test(rekeningnummer.charAt(1)))) {
            throw new RekeningError("landcode is niet juist");
        }
        let getal1 = parseInt(rekeningnummer.slice(14,16));
        let getal2 = parseInt(rekeningnummer.slice(4, 14));
        if (!(typeof rekeningnummer === 'string') || getal2 % 97 !== getal1) {
            throw new RekeningError("Dit is geen geldig rekeningnummer");
        }
        return true;
    }
}

class Zichtrekening extends Bankrekening {
    constructor(rekeningnummer, saldo, klantnummer, limiet) {
        super(rekeningnummer, saldo, klantnummer);
        if (limiet === null) {
            this._limiet = 1500;
        } else if (limiet < 500) {
            throw new RekeningError("te kleine limiet");
        }
        this._limiet = limiet;
    }
    overschrijving(rekeningnummer, bedrag) {
        super.overschrijving(rekeningnummer, bedrag);
        if (this._bedrag - bedrag < 0) {
            throw new RekeningError("Saldo is ontoereikend");
        }
        if (bedrag > this._limiet) {
            throw new RekeningError("te groot bedrag");
        }
    }
}

class Persoon {
    constructor(naamVoornaam, klantnummer) {
        this._naamVoornaam = naamVoornaam;
        this._klantnummer = klantnummer;
        this._rekeningen = [];
    }

    get naamVoornaam() {
        return this._naamVoornaam;
    }

    get klantnummer() {
        return this._klantnummer;
    }

    voegRekeningToe(bankrekening) {
        if (!(bankrekening instanceof Bankrekening)) {
            throw new RekeningError("dit is geen rekening");
        }
        if (bankrekening.klantnummer !== this._klantnummer) {
            throw new RekeningError("Deze rekening is niet van deze klant");
        }
        this._rekeningen.push(bankrekening);
    }
}



try {
    let persoon1= new Persoon('DerkoningenCarine',4567);
    let persoon2= new Persoon('WillekensJan',1234);
    let persoon3= new Persoon('DoumenLuc',3698);
    let zichtrekening1 = new Zichtrekening('BE12564897128940',0,4567);
    let zichtrekening2= new Zichtrekening('BE96369852147031',50,1234);
    let zichtrekening3=new Zichtrekening('BE56741258963077',500,3698);

    persoon1.voegRekeningToe(zichtrekening1);
    persoon2.voegRekeningToe(zichtrekening2);
    persoon3.voegRekeningToe(zichtrekening3);
    zichtrekening3.overschrijving(zichtrekening1,250);
}
    catch (error) {
        console.log(error.toString());
}

try {
    let rekening = new Bankrekening('BE12564897128920',0,4567) //Rekeningerror: Dit is geen juist rekeningnummer
} catch (error) {
    console.log(error.toString());
}

try {
    let persoon1= new Persoon('DerkoningenCarine',4567);
    let zichtrekening3=new Zichtrekening('BE56741258963077',500,3698);
    persoon1.voegRekeningToe(zichtrekening3); //Rekeningerror: Deze rekening is niet van deze klant
} catch (error) {
    console.log(error.toString());
}

try {
    let zichtrekening3=new Zichtrekening('BE56741258963077',500,3698);
    let zichtrekening2= new Zichtrekening('BE96369852147031',50,1234);
    zichtrekening2.overschrijving(zichtrekening3,100);//Rekeningerror: Saldo is ontoereikend
} catch (error) {
    console.log(error.toString());
}