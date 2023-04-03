let size=0;
window.addEventListener("load", getGames);
function getGames(){
    let url = 'https://localhost:5001/api/Game/my-scheduled-games';
    fetch(url,
        {
            headers: {
                'Accept': 'application/json',
                'Content-Type': 'application/json',
                'Authorization': 'Bearer ' + sessionStorage.getItem("playerToken")
            }
        })
        .then((response) => {
            if (response.ok) {
                return response.json();
            } else {
                throw `error with status ${response.status}`;
            }
        })
        .then((games) => {
            for (let i = 0; i < games.length; i++){
                getInfo(games[i].id);
            }
        })
        .catch((error) => {
            window.alert(error);
        });
}
function getInfo(key) {
    let gameDump = document.getElementById("gamedump");
    gameDump.addEventListener(`change`, selectMatch);
    size++;
    let option1 = document.createElement("option");
    option1.value = key;
    option1.text = key;
    gameDump.add(option1);
    gameDump.size ++
}

function selectMatch(){
    let gameDump = document.getElementById("gamedump");
    let url = 'https://localhost:5001/api/Game';
    let key = gameDump.value;
    sessionStorage.setItem("gameID", key);

    fetch(`${url}/${key}`,
        {
            headers: {
                'Accept': 'application/json',
                'Content-Type': 'application/json',
                'Authorization': 'Bearer ' + sessionStorage.getItem("playerToken")
            }
        })
        .then((response) => {
            if (response.ok) {
                return response.json();
            } else {
                throw new `error with status ${response.status}`;
            }
        })
        .then((info) => {
            let infoBlock = document.getElementById("info");
            makeElementEmpty(infoBlock);

            infoBlock.appendChild(document.createTextNode(`puzzel id: ${info.currentPuzzle.id}`));
            infoBlock.appendChild(document.createElement("br"));
            infoBlock.appendChild(document.createTextNode(`puzzel type: ${info.currentPuzzle.type}`));
            infoBlock.appendChild(document.createElement("br"));
            infoBlock.appendChild(document.createTextNode(`puzzel length: ${info.currentPuzzle.wordLength}`));
            infoBlock.appendChild(document.createElement("br"));
            infoBlock.appendChild(document.createTextNode(`player 1 id: ${info.player1.id}`));
            infoBlock.appendChild(document.createElement("br"));
            infoBlock.appendChild(document.createTextNode(`player 1 name: ${info.player1.name}`));
            infoBlock.appendChild(document.createElement("br"));
            infoBlock.appendChild(document.createTextNode(`player 2 id: ${info.player2.id}`));
            infoBlock.appendChild(document.createElement("br"));
            infoBlock.appendChild(document.createTextNode(`player 2 name: ${info.player2.name}`));
        })
        .catch((error) => {
            window.alert(error);
        });

}

/*
function getInfo(key){
    console.log(key);
    let gameDump = document.getElementById("gamedump");
    gameDump.addEventListener(`change`, selectMatch);
    let url = 'https://localhost:5001/api/Game';
    console.log('has reached GetInfoFunction');
    size++;
    console.log(`${url}/${key}`);
    fetch(`${url}/${key}`,
        {
            headers: {
                'Accept': 'application/json',
                'Content-Type': 'application/json',
                'Authorization': 'Bearer ' + sessionStorage.getItem("playerToken")
            }
        })
        .then((response) => {
            if (response.ok) {
                return response.json();
            } else {
                throw new `error with status ${response.status}`;
            }
        })
        .then((info) => {
            let text = `${info.player1.name} VS. ${info.player2.name}`;
            let option1 = document.createElement("option");
            option1.value = JSON.stringify(info);
            option1.text = text;
            gameDump.add(option1);
            gameDump.size = size
        })
        .catch((error) => {
            window.alert(error);
        });
}

function selectMatch(){
    let gameDump = document.getElementById("gamedump");
    let infoBlock = document.getElementById("info");
    makeElementEmpty(infoBlock);
    console.log(JSON.parse(gameDump.value));
    let info = JSON.parse(gameDump.value);


    infoBlock.appendChild(document.createTextNode(`puzzel id: ${info.currentPuzzle.id}`));
    sessionStorage.setItem("gameID", info.currentPuzzle.id);
    infoBlock.appendChild(document.createElement("br"));
    infoBlock.appendChild(document.createTextNode(`puzzel type: ${info.currentPuzzle.type}`));
    infoBlock.appendChild(document.createElement("br"));
    infoBlock.appendChild(document.createTextNode(`puzzel length: ${info.currentPuzzle.wordLength}`));
    infoBlock.appendChild(document.createElement("br"));
    infoBlock.appendChild(document.createTextNode(`player 1 id: ${info.player1.id}`));
    infoBlock.appendChild(document.createElement("br"));
    infoBlock.appendChild(document.createTextNode(`player 1 name: ${info.player1.name}`));
    infoBlock.appendChild(document.createElement("br"));
    infoBlock.appendChild(document.createTextNode(`player 2 id: ${info.player2.id}`));
    infoBlock.appendChild(document.createElement("br"));
    infoBlock.appendChild(document.createTextNode(`player 2 name: ${info.player2.name}`));
}
*/

function makeElementEmpty(element) {
    while (element.hasChildNodes()) {
        element.removeChild(element.firstChild);
    }
}