function calculateAge(){
    let today = new Date();
    let birthDate = persoonTim.dateOfBirth;
    let age = today.getFullYear() - birthDate.getFullYear();
    let month = today.getMonth() - birthDate.getMonth();
    if (month < 0 || (month === 0 && today.getDate() < birthDate.getDate())) {
        age--;
    }
    return age;
}
function print(){
    console.log(`Naam: ${persoonTim.firstname} ${persoonTim.lastname},
Date of Birth: ${persoonTim.dateOfBirth.getDate()}/${persoonTim.dateOfBirth.getMonth()}/${persoonTim.dateOfBirth.getFullYear()}`)
}

class Person {
    constructor(firstname, lastname) {
        this.firstname = firstname;
        this.lastname = lastname;
    }

    set firstname(firstname) {
        this._firstname = firstname;
    }

    get firstname() {
        return this._firstname;
    }

    set lastname(lastname) {
        this._lastname = lastname;
    }

    get lastname() {
        return this._lastname;
    }

    set dateOfBirth(dateOfBirth) {
        this._dateOfBirth = dateOfBirth;
    }

    get dateOfBirth() {
        return this._dateOfBirth;
    }
    toString() {
        console.log(`Age of ${persoonTim.firstname} ${persoonTim.lastname} is: ${calculateAge()} years old`);
    }
}
let persoonTim = new Person("Tim", "Geyskens");
persoonTim.dateOfBirth = new Date('1 March, 2011');     //month 1 = Feb?
print();
persoonTim.toString();



