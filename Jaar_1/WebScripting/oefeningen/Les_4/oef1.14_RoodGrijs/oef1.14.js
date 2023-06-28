window.addEventListener("load", handleLoad);

function handleLoad() {
    let buttonVerzenden = document.getElementById("wissen");
    buttonVerzenden.addEventListener("click", handleClick);

    let buttonWissen = document.getElementById("verzenden");
    buttonWissen.addEventListener("click", handleClick);

    let textInputs = document.querySelectorAll("input[type=text]");
    for (let textInput of textInputs) {
        textInput.addEventListener("focus", handleTextInputFocus)
        textInput.addEventListener("blur", handleTextInputBlur)
    }
}

function handleClick(event){
    if (event.target.id === "wissen") {
        let textInputs = document.querySelectorAll("input[type=text]");
        for (let textInput of textInputs) {
            textInput.value = "";
            textInput.style.backgroundColor = "lightgray";
        }
        window.alert("Alles is gewist");
    } else {
        window.alert("Bedankt voor het verzenden");
    }
}

function handleTextInputFocus(event) {
    let element = event.target;
    element.style.backgroundColor = "white";
    element.style.color = "red";
    element.value = "";
}

function handleTextInputBlur(event) {
    let element = event.target;
    element.style.backgroundColor = "lightgray";
    element.style.color = "black";
}
