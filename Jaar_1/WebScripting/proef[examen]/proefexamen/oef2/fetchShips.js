// naam: Rasmus Leseberg

window.addEventListener("load", handleWindowload);

function handleWindowload() {
    let url = 'http://localhost:3000/country';
    let divOutput = document.getElementById("div_output");
    let divSelect = document.getElementById("div_select");

    let buttonGetShips = document.getElementById('get_ships');
    buttonGetShips.addEventListener("click", handleGetShips);

    fetch(url)
        .then((response) => {
            if (response.ok) {
                return response.json();
            } else {
                throw `error with status ${response.status}`;
            }
        })
        .then((country) => {
            let select = makeSelect(country);
            divSelect.appendChild(select);
        })
        .catch((error) => {
            divOutput.appendChild(document.createTextNode(error));
        });
}

function handleGetShips() {
    let url = 'http://localhost:3000/ship/';
    let id = document.getElementById("select_country").value;
    let output = document.getElementById("div_output");
    makeElementEmpty(output);

    if (id.trim()!=''){
        fetch(url + "?country_id=" + id)
            .then((response) => {
                if (response.ok) {
                    return response.json();
                } else {
                    throw `error with status ${response.status}`;
                }
            })
            .then((ships) => {
                let table = makeList(ships);
                output.appendChild(table);
            })
            .catch((error) => {
                output.appendChild(document.createTextNode(error));
            });
    }
}


function makeElementEmpty(element) {
    while (element.hasChildNodes()) {
        element.removeChild(element.firstChild);
    }
}

function makeSelect(country) {
    let select = document.createElement('select');
    select.setAttribute('id', 'select_country');
    for (let land of country) {
        let option = document.createElement("option");
        let textnode = document.createTextNode(land.name);
        option.appendChild(textnode);
        option.value = land.id;
        select.appendChild(option);
    }
    return select;
}

function makeList(amountShips) {
    let list = document.createElement("ul");
    let fastestShip = amountShips[0].speed;
    for (let i = 0; i < amountShips.length; i++) {
        if (amountShips[i].speed > fastestShip) {
            fastestShip = amountShips[i].speed;
        }
    }

    for (let i = 0; i < amountShips.length; i++) {
        let listItem = document.createElement("li");
        listItem.appendChild(document.createTextNode(amountShips[i].name));
        if (amountShips[i].speed === fastestShip) {
            listItem.style.color = "red";
        }
        list.appendChild(listItem);
    }
    return list;
}