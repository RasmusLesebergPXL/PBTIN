window.addEventListener("load", handleLoad);

function handleLoad() {
    let button = document.getElementById("buttonFilter");
    button.addEventListener("click", handleClick);
}

function handleClick() {
    let phrase = document.getElementById("phrase").value;
    let filter = document.getElementById("filter").value;
    let aantalGefilterdeWoorden = document.getElementById("gefilterde_woorden");
    let output = document.getElementById("output")

    while (output.hasChildNodes()) {
        output.removeChild(output.firstChild)
    }
    if (aantalGefilterdeWoorden.hasChildNodes()) {
        aantalGefilterdeWoorden.removeChild(aantalGefilterdeWoorden.firstChild)
    }

    let teller = 0;
    let splitString = phrase.split(" ");
    splitString.reverse();
    let newArray = [];

    for (let i = 0; i < splitString.length; i++) {
        if (splitString[i].includes(filter)) {
            teller++;
        } else {
            newArray.push(splitString[i]);
        }
    }

    for (let word of newArray) {
        let span = document.createElement("span");
        span.className = "redbox";
        span.appendChild(document.createTextNode(word));
        output.appendChild(span);
    }
    let woorden = document.createElement("span");
    woorden.className = "woordenGefilterd";
    aantalGefilterdeWoorden.appendChild(document.createTextNode(teller + "word(s) filtered"));
}
