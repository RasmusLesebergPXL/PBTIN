function controleGetal(banknummer) {
    return banknummer % 97;
}

class Account{
    constructor(landcode, banknummer, tienPosities) {
        this.landcode = landcode;
        this.banknummer = banknummer;
        this.tienPosities = tienPosities;
    }
    set saldo (saldo) {
        this._saldo = saldo;
    }
    get saldo() {
        return this._saldo;
    }
    stort(bedrag) {
        this._saldo += bedrag;
    }
    verwijder(minBedrag) {
        if ((this._saldo - minBedrag) > 0) {
            this._saldo -= minBedrag;
        } else {
            console.log("U kunt dat bedrag niet opnemen")
        }
    }
    print() {
        let legeString = ""
        legeString += this.landcode;
        legeString += this.banknummer + "-";
        legeString += this.tienPosities + "-";
        legeString += controleGetal(this.tienPosities);
        console.log(legeString);
    }
    printBedrag() {
        console.log(`Bedrag op rekening: ${this._saldo}`);
    }
}

let timsAccount = new Account("BE", 51, 2735261343);
timsAccount.print();
timsAccount.saldo = 22000;
timsAccount.stort(2398);
timsAccount.printBedrag();
timsAccount.verwijder(398);
timsAccount.printBedrag();
timsAccount.verwijder(26000);

