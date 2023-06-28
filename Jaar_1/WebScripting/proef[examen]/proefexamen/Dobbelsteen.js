
class SpeelbaarObject {
    get waarde() {
        return 0;
    }

    isGelijkAan(speelbaarObject) {
        if (!(speelbaarObject instanceof SpeelbaarObject)) {
            throw new Error("misse ingave: geen SpeelbaarObject opgewporpen");
        }
        return true;
    }

    genereerWillekeurigGetal(min, max) {
        if (!(Number.isInteger(min)) || !(Number.isInteger(max)) || min < 0 || max < 0 || max < min) {
            throw new Error("misse ingave voor min of max")
        }
        return Math.floor(min +Math.random() * (1+max-min) );
    }
}

class Dobbelsteen extends SpeelbaarObject {
    constructor() {
        super();
        let r = this.genereerWillekeurigGetal(1, 6);
        if (r === 6) {
            this._zijde = '*';
        } else {
            this._zijde = String(r);
        }
    }
    get zijde() {
        return this._zijde;
    }
    get waarde() {
        if (this._zijde === '*') {
            return 0
        }
        return parseInt(this._zijde)
    }
    isGelijkAan(speelbaarObject) {
        if (!(speelbaarObject instanceof SpeelbaarObject)) {
            throw new Error("misse ingave: geen SpeelbaarObject");
        }
        if (!(speelbaarObject instanceof Dobbelsteen)) {
            throw new Error("misse ingave: geen Dobbelsteen");
        }
        if (this._zijde === speelbaarObject._zijde) {
            return true;
        }
        return this._zijde === '*' || speelbaarObject._zijde === '*';
    }
}

class Worp {
    constructor(aantalDobbelsteen) {
        if (!(Number.isInteger(aantalDobbelsteen)) || aantalDobbelsteen < 2) {
            throw new Error("misse ingave voor aantalDobbelstenen")
        }
        this._dobbelstenen = [];
        for (let i = 0; i < aantalDobbelsteen; i++) {
            this.voegDobbelsteenToe(new Dobbelsteen());
        }
    }

    voegDobbelsteenToe(dobbelsteen) {
        if (!(dobbelsteen instanceof Dobbelsteen)) {
            throw new Error("Het meegegeven Object is geen Dobbelsteen");
        }
        this._dobbelstenen.push(dobbelsteen)
    }

    get resultaat() {
        let som = 0;
        let nummers = [];
        let hoogsteZijde = this._dobbelstenen[0].waarde();

        for (let i = 0; i < this._dobbelstenen.length; i++) {
            if (this._dobbelstenen[i].waarde() > hoogsteZijde) {
                hoogsteZijde = this._dobbelstenen[i].waarde();
                nummers.push(this._dobbelstenen[i].waarde());
            }
        }
        for (let i = 0; i < this._dobbelstenen.length; i++) {
            if (this._dobbelstenen[i].waarde() === 0) {
                som = hoogsteZijde
                return som;
            }
        }
        let nummer = Frequency(nummers);
        som = nummer * 2;
        return som;
    }
}

function Frequency(array) {
    const s = {};
    array.map((x) => {
        s[x] = s[x] + 1 || 1;
    });
    let k = Object.keys(s);
    let v = Object.values(s);
    let max = Math.max(...v);
    let i = v.findIndex((x) => {
        return x === max;
    });
    return k[i]
}

try {
    let dobbelsteen1 = new Dobbelsteen();
    let dobbelsteen2 = new Dobbelsteen();
    let dobbelsteen3 = new Dobbelsteen();
    let dobbelsteen4 = new Dobbelsteen();
    console.log(dobbelsteen1.zijde);    /* 3 */
    console.log(dobbelsteen2.zijde);    /* 5 */
    console.log(dobbelsteen3.zijde);    /* 1 */
    console.log(dobbelsteen4.zijde);    /* * */
    console.log(dobbelsteen1.waarde);   /* 3 */
    console.log(dobbelsteen2.waarde);   /* 5 */
    console.log(dobbelsteen3.waarde);   /* 1 */
    console.log(dobbelsteen4.waarde);   /* 0 */
    console.log(dobbelsteen1.isGelijkAan(dobbelsteen2)); //false
    console.log(dobbelsteen1.isGelijkAan(dobbelsteen3)); //false
    console.log(dobbelsteen1.isGelijkAan(dobbelsteen4)); //true
    console.log(dobbelsteen4.isGelijkAan(dobbelsteen1)); //true

} catch(error){
    console.log(error.toString());
}

try {
    let worp = new Worp(4);
    console.log(worp.resultaat);
} catch(error){
    console.log(error.toString());
}