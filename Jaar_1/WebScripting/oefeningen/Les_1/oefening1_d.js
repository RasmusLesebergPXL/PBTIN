let aantalLijnen = 7;
let teller = 0;

for (let i = 0; i < aantalLijnen; i++) {
    let lijn = "";
    for (let j = 0; j < 1 + 2 * i; j++) {
        lijn += teller % 5 == 0 ? "@" : "#";
        teller++;
    }
    console.log(" ".repeat(aantalLijnen - i) + lijn)
}