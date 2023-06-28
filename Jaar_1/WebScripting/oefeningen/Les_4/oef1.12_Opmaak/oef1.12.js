window.addEventListener("load", handleLoad);

function handleLoad() {
    let opmaakEen = document.getElementById("knopOpmaak1");
    opmaakEen.addEventListener("click",handleClick );

    let opmaakTwee = document.getElementById("knopOpmaak2");
    opmaakTwee.addEventListener("click",handleClick );
}

function handleClick(event) {
    let style = document.getElementById("stylesheet")
    if (event.target.id === "knopOpmaak1") {
        style.href = "style/opmaak1.css"
    } else {
        style.href = "style/opmaak2.css"
    }
}