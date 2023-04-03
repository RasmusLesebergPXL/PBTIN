class InputError extends Error {}

class Vec {
    constructor(xDimensie, yDimensie) {
        if (typeof xDimensie != 'number' || typeof yDimensie != 'number') {
            throw new InputError("constructor heeft een of meerdere argumenten die niet instance of getal zijn");
        }
        this._x = xDimensie;
        this._y = yDimensie;
    }
    plus(vec) {
        if (!(vec instanceof Vec)) {
            throw new InputError("the object trying to be added is not instance of Vec");
        }
        return (this._x + vec._x) + (this._y + vec._y);
    }
    minus(vec) {
        if (!(vec instanceof Vec)) {
            throw new InputError("the object trying to be subtracted is not instance of Vec");
        }
        return (this._x - vec._x) + (this._y - vec._y);
    }
    get length() {
        return Math.sqrt(Math.pow(this._x, 2) + Math.pow(this._y, 2)).toFixed(2);
    }
    toString() {
        return `(${this._x}, ${this._y})`;
    }
}

class PolyLine{
    constructor() {
        this._vecs = [];
    }
    addVec(vec){
        if( !(vec instanceof Vec)) {
            throw new InputError("the object from the parameter is not a Vec object");
        }
        this._vecs.push(vec);
    }
    toString() {
        return this._vecs.join(", ");
    }
}

try{
    let polyLine=new PolyLine();
    polyLine.addVec(new Vec(1,2));
    polyLine.addVec(new Vec(2,3));
    polyLine.addVec(new Vec(5,7));
    console.log(polyLine.toString());
    polyLine.addVec("oops");
} catch(error){
    console.log(error.toString());
}