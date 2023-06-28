window.addEventListener("load", handleLoad);

function handleLoad() {
    const dieren = document.querySelectorAll("img")
    for (let dier of dieren) {
        dier.addEventListener("dblclick", handleDouble);
    }
}

function handleDouble(event) {
    const dieren = document.querySelectorAll("img")
    for (let dier of dieren) {
        dier.style.width = "200px";
    }
    let dier = event.target;
    dier.style.width = "400px";
    let bijschrijft = document.getElementById("bijschrift")
    bijschrijft.value = dier.target.id;
}


