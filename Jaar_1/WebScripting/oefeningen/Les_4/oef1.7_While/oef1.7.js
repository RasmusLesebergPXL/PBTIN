window.addEventListener("load", handleLoad);

function handleLoad() {
    let genereerOneven = document.getElementById("genereer_oneven");
    genereerOneven.addEventListener("click",handleClick );
}

function handleClick() {
    let getal = document.getElementById("getal");
    let uitkomst = document.getElementById("oneven_uitkomst");
    let getal1 = parseInt(getal.value);

    let output = document.getElementById("output");
    output.appendChild(document.createTextNode("hallo"))

    if (isNaN(getal1)) {
        uitkomst.value = "Ongeldige invoer"
    } else {
        const isPrime = num => {
            for(let i = 2, s = Math.sqrt(num); i <= s; i++)
                if(num % i === 0) return false;
            return num > 1;
        }
        let i = 0;
        while (i <= getal1) {
            if (isPrime(i))
            uitkomst.value += i + " ";
            i++;
        }
    }
}
