function controleGetal(banknummer) {
    return banknummer % 97;
}


class Account{
    constructor(landcode, banknummer, tienPosities) {
        this.landcode = landcode;
        this.banknummer = banknummer;
        this.tienPosities = tienPosities;
    }
    print() {
        let legeString = "";
        legeString += this.landcode;
        legeString += this.banknummer + "-";
        legeString += this.tienPosities + "-";
        legeString += controleGetal(this.tienPosities);
        console.log(legeString);
    }
}

let timsAccount = new Account("BE", 51, 2735261343);
timsAccount.print();