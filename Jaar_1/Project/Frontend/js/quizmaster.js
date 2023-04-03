window.addEventListener("load", loaded);
let selector1 = document.getElementById("selector1");
let selector2 = document.getElementById('selector2');
let postbutton = document.getElementById('post');
let filterBox = document.getElementById("Filter");
let userlist;
selector1.addEventListener("change", select1);
selector2.addEventListener("change", select2);
postbutton.addEventListener("click", post);
filterBox.addEventListener("input", makeFilter);


function makeFilter() {
    console.log(filterBox.value);
    let newUrl = 'https://localhost:5001/api/Quizmaster/users?filter=' + filterBox.value;
    createLists(newUrl)
}

function loaded() {
    let url = 'https://localhost:5001/api/Quizmaster/users';//users?filter=r%40k op die manier wordt op users gefiltered.
    createLists(url)
}


function createLists(url) {
    fetch(url,
        {
            headers: {
                'Accept': 'application/json',
                'Content-Type': 'application/json',
                'Authorization': 'Bearer ' + sessionStorage.getItem("quizmasterToken")
            }
        })
        .then((response) => {
            if (response.ok) {
                return response.json();
            } else {
                throw `error with status ${response.status}`;
            }
        })
        .then((users) => {
            let output = document.getElementById("player_list");
            makeElementEmpty(selector1);
            makeElementEmpty(selector2);
            makeElementEmpty(output);
            for (let i of users) {
                let li = document.createElement("li");
                let div = document.createElement("div");
                let div2 = document.createElement("div");
                div.id = "partLi";
                div2.id = "partLi";
                div.appendChild(document.createTextNode(i.nickName));
                div2.appendChild(document.createTextNode(i.email));
                li.appendChild(div2);
                li.appendChild(div);
                console.log(li);
                output.appendChild(li);

                //add options to the 2 selects
                let option1 = document.createElement("option");
                let option2 = document.createElement("option");
                option1.value = i.id;
                option1.text = i.nickName;
                option2.value = i.id;
                option2.text = i.nickName;
                selector1.add(option1);
                selector2.add(option2);
            }
            let option = selector2.lastChild;
            selector2.value = option.value;
            userlist = users;
            select1();
            select2();
        })
}


function select1() {
    let speler1 = document.getElementById("selector1").value;
    for (let options of selector2.options) {
        options.hidden = options.value === speler1;
    }
}


function select2() {
    let speler2 = document.getElementById("selector2").value;
    for (let options of selector1.options) {
        options.hidden = options.value === speler2;
    }
}


function post() {
    let url = 'https://localhost:5001/api/Quizmaster/create-game';
    let speler1 = document.getElementById("selector1").value;
    let speler2 = document.getElementById("selector2").value;
    if (speler1 === speler2) {
        throw 'speler 1 = speler 2'
    }
    let NOSWP = parseInt(document.getElementById("numberOfStandardWordPuzzles").value);
    let minWordLength = 5 //parseInt(document.getElementById("minimumWordLength").value);
    let maxWordlength = 5 //parseInt(document.getElementById("maximumWordLength").value);
    let register = {
        "user1Id": speler1,
        "user2Id": speler2,
        "settings": {
            "numberOfStandardWordPuzzles": NOSWP,
            "minimumWordLength": minWordLength,
            "maximumWordLength": maxWordlength
        }
    }

    fetch(url,
        {
            method: "POST",
            body: JSON.stringify(register),
            headers: {
                'Accept': 'application/json',
                'Content-Type': 'application/json',
                'Authorization': 'Bearer ' + sessionStorage.getItem("quizmasterToken")
            }
        })
        .then((response) => {
        if (response.ok) {
            window.alert("registration succes");

        } else {
            window.alert("registration failed");
        }
    })
}


function makeElementEmpty(element) {
    while (element.hasChildNodes()) {
        element.removeChild(element.firstChild);
    }
}

