// naam: Rasmus Leseberg

window.addEventListener("load", handleLoad);

function handleLoad() {
    let button_start_rekenen = document.getElementById("button_start_rekenen");
    button_start_rekenen.addEventListener("click", handleClick);
}


function handleClick() {
    let entry = document.getElementById("input_aantal").value;
    let output = document.getElementById("vermenigvuldigingen");
    makeElementEmpty(output);

    if (!/^\d+$/.test(entry)) {
        output.appendChild(document.createTextNode("misse ingave voor aantal"));
    } else {
        for (let i = 0; i <= entry -1; i++) {
            let getal1 = parseInt(10 * Math.random());
            let getal2 = parseInt(10 * Math.random());
            output.appendChild(document.createTextNode( getal1 + " * " + getal2 + " ="));
            let input = document.createElement("input");
            input.id = 'input';
            input.addEventListener("keyup", handleKeyupInput);
            output.appendChild(input);
            output.appendChild(document.createElement("hr"));
        }
    }
}

function handleKeyupInput(event) {
    let input = document.getElementById('input');
    if (isNaN(input)) {
        input.style.color = "red";
    }
}

function makeElementEmpty(element) {
    while (element.hasChildNodes()) {
        element.removeChild(element.firstChild);
    }
}

