window.addEventListener("load", handleLoad);

function handleLoad() {
    let buttonGenereer = document.getElementById("genereer_melding");
    buttonGenereer.addEventListener("click",handleClick );
}

function handleClick() {
    let voornaam = document.getElementById("voornaam");
    let achternaam = document.getElementById("achternaam");
    let melding = document.getElementById("melding_uitkomst");

    if (voornaam.value.length === 0 || achternaam.value.length === 0) {
        melding.value = "Vul alle velden in, a.u.b"
    } else{
        melding.value = voornaam.value + " " + achternaam.value;
    }
}

