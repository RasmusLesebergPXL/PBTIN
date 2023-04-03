function telB(tekst) {
    return telChar(tekst.toUpperCase(), 'B');
}

function telChar(tekst, symbool) {
    let teller = 0;
    for (let i = 0; i < tekst.length; i++) {
        if (tekst[i] == symbool) {
            teller += 1;
        }
    }
    return teller;
}

console.log(telB('BaaaB BbcbBC'))
