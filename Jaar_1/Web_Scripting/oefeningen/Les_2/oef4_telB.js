function telB(woord) {
    let teller = 0;
    for (const letter of woord) {
        if (letter == "B") {
            teller++;
        }
    }
    return teller;
}

function telChar(symbool, tweedeWoord) {
    let teller = 0;
    for (let i = 0; i < tweedeWoord.length; i++) {
        if (tweedeWoord.charAt(i) == symbool) {
            teller += 1;
        }
    }
    return teller;
}

let woord = "aaabBbbbBahjdhjd";
let tweedeWoord = "@hj#khkjh@kjh@jhh@@"
let splitWoord = woord.toUpperCase().split("");
console.log("aantal B's in woord: " + telB(splitWoord));
console.log("aantal @ in tweede woord: " + telChar("@", tweedeWoord));