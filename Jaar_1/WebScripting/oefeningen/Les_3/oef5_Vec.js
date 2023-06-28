
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

try {
    let v1 = new Vec(1, 2);
    let v2 = new Vec(2, 5);
    v1.plus(v2);
    console.log(v1.toString());
    console.log(v1.length);
} catch (error) {
    console.log(error.toString());
}

try {
    new Vec('x', 'y')
} catch (error) {
    console.log(error.toString());
}
try {
    let newVec = new Vec(1, 2)
    newVec.minus('vec')
} catch (error) {
    console.log(error.toString());
}
try {
    let newVec = new Vec(1, 2)
    newVec.plus(new Vec(1, '1'))
} catch (error) {
    console.log(error.toString());
}


