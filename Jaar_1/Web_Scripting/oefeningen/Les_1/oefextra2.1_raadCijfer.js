let max = 10;
let min = 0;
let teller = 1;
let prompt = require('prompt-sync')();
let randomNumber = parseInt((Math.random() * (max - min + 1)), 10) + min;
let theNumber = prompt("Pick a number: ");
console.log(theNumber);
while (teller <= 3) {
    if ((theNumber <= 10 && theNumber >= 0 && typeof theNumber == "number")) {
        if (theNumber === randomNumber) {
            console.log("proficiat!")
            break;
        } else if (teller < 3) {
            let theNumber = Number(prompt("Nog een kans: "));
            teller++;
        } else {
            console.log("sorry, niet geraden");
        }
    }
}