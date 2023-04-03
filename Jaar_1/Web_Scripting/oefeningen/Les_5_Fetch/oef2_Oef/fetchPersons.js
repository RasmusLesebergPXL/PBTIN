window.addEventListener("load", loaded);

function loaded() {
    let divOutput = document.getElementById("div_output");
    let divSelect = document.getElementById("div_select");
    let urlPersons = 'http://localhost:3000/persons/';

    let buttonGetFriends = document.getElementById('get_friends');
    buttonGetFriends.addEventListener("click", handleGetFriends);

    let buttonPost = document.getElementById('button_post_person');
    buttonPost.addEventListener("click", handlePostPerson);

    fetch(urlPersons)
        .then((response) => {
            if (response.ok) {
                return response.json();
            } else {
                throw `error with status ${response.status}`;
            }
        })
        .then((persons) => {
            let select = makeSelect(persons);
            divSelect.appendChild(select);
            // ...
        })
        .catch((error) => {
            divOutput.appendChild(document.createTextNode(error));
        });
}


function makeSelect(persons) {
    let select = document.createElement('select');
    select.setAttribute('id', 'select_id');
    for (let person of persons) {
        let option = document.createElement("option");
        let textnode = document.createTextNode(person.name);
        option.appendChild(textnode);
        option.value = person.id;
        select.appendChild(option);
    }
    return select;
}

function handleGetFriends() {
    let url = 'http://localhost:3000/persons/';
    let id = document.getElementById("select_id").value;
    let output = document.getElementById("div_output");

    makeElementEmpty(output);
    fetch(`${url}${id}`)
        .then((response) => {
            if (response.ok) {
                return response.json();
            } else {
                throw `error with status ${response.status}`;
            }
        })
        .then((person) => {
            let friends = person.friends;
            let ids = friends.join("&id=");    // [1,2,3] --> 1&id=2&id=3
            return fetch(url + `?id=${ids}`);  // .../?id=1&id=2&id=3
        })
        .then((response) => {
            if (response.ok) {
                return response.json();
            } else {
                throw `error with status ${response.status}`;
            }
        })
        .then((persons) => {
            for(let person of persons){
                let name = person.name;
                output.appendChild(document.createTextNode(` ${name}`));
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

function handlePostPerson() {
    let url = 'http://localhost:3000/persons/';
    let output = document.getElementById("div_output");
    let name = document.getElementById("txt_name").value;
    let person = {name: name};

    makeElementEmpty(output);
    fetch(url,
        {
            method: "POST",
            body: JSON.stringify(person),
            headers: {
                'Accept': 'application/json',
                'Content-Type': 'application/json'
            }
        })
        .then((response) => {
            if (response.ok) {
                return response.json();
            } else {
                throw `error with status ${response.status}`;
            }
        })
        .then((person) => {
            let data = [];
            data.push([person.id, person.name]);
            let table = makeTable(data);
            output.appendChild(table);
        })
        .catch((error) => {
            output.appendChild(document.createTextNode(error));
        });
}

function makeTable(matrix) {
    let table = document.createElement("table");
    for (let i = 0; i < matrix.length; i++) {
        let tr = document.createElement("tr");
        for (let j = 0; j < matrix[i].length; j++) {
            let td = document.createElement("td");
            td.appendChild(document.createTextNode(matrix[i][j]));
            tr.appendChild(td);
        }
        table.appendChild(tr);
    }
    return table;
}
