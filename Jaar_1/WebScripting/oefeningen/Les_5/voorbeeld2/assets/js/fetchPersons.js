window.addEventListener("load", loaded);

function loaded() {
    let buttonGetNext = document.getElementById('button_get_ids');
    buttonGetNext.addEventListener("click", handleGetIds);
}

function handleGetIds() {
    let url = 'http://localhost:3000/persons/';
    let id = document.getElementById("txt_id").value;
    let output = document.getElementById("div_output");
    makeElementEmpty(output);
    fetch(`${url}${id}`)
        .then((response) => {
            if (response.status == 200) {
                return response.json();
            } else {
                throw `error with status ${response.status}`;
            }
        })
        .then((person) => {
            let name = person.name;
            output.appendChild(document.createTextNode(
                `Id ${id} heeft name ${name}. De name ${name} komt voor op de volgende id's: `));
            return fetch( `${url}?name=${name}`);
        })
        .then((response) => {
            if (response.status == 200) {
                return response.json();
            } else {
                throw `error with status ${response.status}`;
            }
        })
        .then((persons) => {
            for(let person of persons){ 
                let id = person.id;
                let name = person.name;
               output.appendChild(document.createTextNode(` ${id}`));
            }
        })
        .catch((error) => {
            output.appendChild(document.createTextNode(error));
        });
}

function makeElementEmpty(element) {
    while (element.hasChildNodes()) {
        element.removeChild(element.firstChild);
    }
}

