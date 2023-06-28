let person = {
    firstname:"Tim",
    lastname:"Geyskens",
    dateOfBirth: new Date(2011,6,16),
    calculateAge: function(){
        let today = new Date();
        let birthDate = person.dateOfBirth;
        let age = today.getFullYear() - birthDate.getFullYear();
        let month = today.getMonth() - birthDate.getMonth();
        if (month < 0) {
            age--;
        } else if (month === 0 && today.getDate() < birthDate.getDate()) {
            age--;
        }
        return age;
    } ,
    print(){
        console.log(`Naam: ${person.firstname} ${person.lastname}`,
        `Date of Birth: ${person.dateOfBirth.getDate()}/${person.dateOfBirth.getMonth()}/${person.dateOfBirth.getFullYear()}`)
    }
}

console.log(`Age of ${person.firstname} ${person.lastname} is: ${person.calculateAge()} years old`);
person.print();
