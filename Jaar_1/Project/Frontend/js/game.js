window.addEventListener("load", loaded);
window.addEventListener("load", Main);

//This function is responsible for: --> loading the js
function loaded() {
    let submitPostButton = document.getElementById('submit_button');
    submitPostButton.addEventListener("click", PostAnswer);
}

//This function is responsible for: --> Fetching the game from the server
function Main() {
    let url = 'https://localhost:5001/api/Game';
    let id = sessionStorage.getItem("gameID");
    let output = document.getElementById("output");
    let errorOutput = document.getElementById("errorSection");
    let gameSize = 5;

    makeElementEmpty(errorOutput);

    fetch(`${url}/${id}`,
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
        .then((game) => {
            if(game.finished === true){
                Finished(game);
            }
            checkHasLingo(game);
            if (game.currentPuzzle.isFinished && sessionStorage.getItem("PlayerID") === game.playerToPlayId) {
                let submit = document.getElementById('submit_button');
                let input = document.getElementById("submitString");
                submit.hidden = true;
                input.hidden = true;
                let grabBallButton = document.getElementById("grabBall_button");
                grabBallButton.hidden = false;
                grabBallButton.addEventListener("click", () => { handleGrabBall(game);})
            }
            playerToPlay(game);
            makeTable(gameSize, game);
            makeLingoBoard(game);
            makeInfoBlock(game);
        })
        .catch((error) => {
            output.appendChild(document.createTextNode(error));
        });
}

//This function is responsible for: --> Switching turns
function playerToPlay(game) {
    let input = document.getElementById("submitString");
    let button = document.getElementById("submit_button");

    if (sessionStorage.getItem("PlayerID") === game.playerToPlayId) {
    } else {
        input.hidden = true;
        button.hidden = true;
        setTimeout(function () {
            window.location.reload(1);
        }, 1000);
    }
}

//This function is responsible for: --> Submitting an answer
function PostAnswer() {
    let id = sessionStorage.getItem("gameID")
    let input = document.getElementById("submitString").value
    let resultOutput = document.getElementById("errorSection");
    let url = 'https://localhost:5001/api/Game';
    let answer = {answer: input};

    makeElementEmpty(resultOutput);

    fetch(`${url}/${id}/submit-answer`,
        {
            method: "POST",
            body: JSON.stringify(answer),
            headers: {
                'Accept': 'application/json',
                'Content-Type': 'application/json',
                'Authorization': 'Bearer ' + sessionStorage.getItem("playerToken")
            }
        })
        .then((response) => {
            if (response.status === 200) {
                return response.json();

            } else if (response.status === 400) {
                throw `Vul een antwoord in het input veld`;
            }
        })
        .then((jsonResponse) => {

            if (jsonResponse.lostTurn === false) {
                resultOutput.appendChild(document.createTextNode("U bent nog steeds aan de beurt"));
            }
            resultOutput.appendChild(document.createTextNode(jsonResponse.reason));

            setTimeout(function () {
                window.location.reload(1);
            }, 1500);
        })
        .catch((error) => {
            resultOutput.appendChild(document.createTextNode(error));
        });
}

//This function is responsible for: --> Grabs ball correct amount of times
function handleGrabBall(game) {
    let grab = document.getElementById("grabBall_button");
    grab.hidden = true;

    grabBall(game);
}

//This function is responsible for: --> Checking and displaying Lingo
function checkHasLingo(game){
    if (parseInt(game.player1.score) === 0 && parseInt(game.player2.score) === 0) {
        return;
    } else {
        if (parseInt(sessionStorage.getItem("player1Score")) + 100 === parseInt(game.player1.score)) {
            window.alert(game.player1.name + " has Lingo!");
        }
        else if (parseInt(sessionStorage.getItem("player2Score")) + 100 === parseInt(game.player2.score)) {
            window.alert(game.player2.name + " has Lingo!");
        }
        sessionStorage.setItem("player1Score", game.player1.score);
        sessionStorage.setItem("player2Score", game.player2.score);
    }
}

//This function is responsible for: --> Grab Ball
function grabBall(game) {

    let url = 'https://localhost:5001/api/Game';
    let id = sessionStorage.getItem("gameID");
    let resultOutput = document.getElementById("errorSection");

    makeElementEmpty(resultOutput);

    fetch(`${url}/${id}/grab-ball`,
        {
            method: "POST",
            headers: {
                'Accept': 'application/json',
                'Content-Type': 'application/json',
                'Authorization': 'Bearer ' + sessionStorage.getItem("playerToken")
            }
        })
        .then((response) => {
            if (response.status === 200) {
                return response.json();

            } else if (response.status === 400) {
                throw `error with status ${response.message}`;
            }
        })
        .then((ballGrab) => {
            if (ballGrab.type == 1) {
                resultOutput.appendChild(document.createTextNode("Rode bal geraapt"));
                setTimeout(function() {
                    location.reload();
                }, 2000);
                return ballGrab;

            } else {
                resultOutput.appendChild(document.createTextNode("Blauwe bal geraapt, getal:  " + ballGrab.value));
                setTimeout(function() {
                    location.reload();
                }, 2500);
                sessionStorage.setItem("player1Score", game.player1.score);
                sessionStorage.setItem("player2Score", game.player2.score);
                return ballGrab;
            }
        })
        .catch((error) => {
            resultOutput.appendChild(document.createTextNode(error));
        });
}

//#region Display LingoBoard, InfoBlock, GameTable
//#region make Table
//This function is responsible for: --> Making the game Table
function makeTable(size, game) {
    let placement = document.getElementById("output");
    let table = placement.appendChild(document.createElement("table"));

    for (let i = 0; i < game.currentPuzzle.guesses.length; i++) {
        let tr = document.createElement("tr");

        for (let j = 0; j < size; j++) {
            let td = document.createElement("td");
            //letter add
            td.appendChild(document.createTextNode(game.currentPuzzle.guesses[i].word[j]));

            //change color
            if (game.currentPuzzle.guesses[i].letterMatches[j] == 1) {
                td.style.backgroundColor = "red"
            } else if (game.currentPuzzle.guesses[i].letterMatches[j] == 0) {
                td.style.backgroundColor = "yellow"
            }
            tr.appendChild(td);
        }
        table.appendChild(tr);
    }

    if(!game.currentPuzzle.isFinished){
        revealPlusFil(game, table, size);
    }
}

//This function is responsible for: --> Revealing letters in Table
function revealPlusFil(game, table, size) {
    let tr = document.createElement("tr");

    //fil with reveald letters
    for (let j = 0; j < size; j++) {
        let td = document.createElement("td");
        //letter add
        td.appendChild(document.createTextNode(game.currentPuzzle.revealedLetters[j]));

        if (td.textContent !== ".") {
            td.style.backgroundColor = "red";
        }
        tr.appendChild(td);
    }
    table.appendChild(tr);


    for (let i = 0; i < (4 - game.currentPuzzle.guesses.length); i++) {

        let tr = document.createElement("tr");

        for (let j = 0; j < size; j++) {
            let td = document.createElement("td");
            //letter add
            td.appendChild(document.createTextNode("."));
            tr.appendChild(td);
        }
        table.appendChild(tr);
    }
    return table;
}
//#endregion

//This function is responsible for: --> making the lingoBoard
function makeLingoBoard(game) {
    let placement = document.getElementById("LingoBoard");
    let table = placement.appendChild(document.createElement("table"));
    let spelerLingocard;


    if (sessionStorage.getItem("PlayerID") == game.player1.id) {
        spelerLingocard = game.player1;
        document.title = "Player 1";
    } else {
        spelerLingocard = game.player2;
        document.title = "Player 2";
    }

    for (let i = 0; i < 5; i++) {
        let tr = document.createElement("tr");

        for (let j = 0; j < 5; j++) {
            let td = document.createElement("td");
            td.appendChild(document.createTextNode(JSON.stringify(spelerLingocard.card.cardNumbers[i][j].Value)));
            tr.appendChild(td);

            if (spelerLingocard.card.cardNumbers[i][j].CrossedOut == true) {
                td.style.textDecoration = "line-through";
                td.style.backgroundColor = "blue";
            }
        }
        table.appendChild(tr);
    }
}

//This function is responsible for: --> the info block on the top left
function makeInfoBlock(game) {

    let infoBlock = document.getElementById("info");
    makeElementEmpty(infoBlock);

    infoBlock.appendChild(document.createTextNode(`Player 1: ${game.player1.name}`));
    infoBlock.appendChild(document.createElement("br"));
    infoBlock.appendChild(document.createTextNode(`${game.player1.name}'s score: ${game.player1.score}`));
    infoBlock.appendChild(document.createElement("br"));
    infoBlock.appendChild(document.createElement("br"));
    infoBlock.appendChild(document.createTextNode(`Player 2: ${game.player2.name}`));
    infoBlock.appendChild(document.createElement("br"));
    infoBlock.appendChild(document.createTextNode(`${game.player2.name}'s score: ${game.player2.score}`));
    infoBlock.appendChild(document.createElement("br"));
    infoBlock.appendChild(document.createElement("br"));

    if (game.player1.id == game.playerToPlayId) {
        infoBlock.appendChild(document.createTextNode(game.player1.name + "'s turn"));
    } else {
        infoBlock.appendChild(document.createTextNode(game.player2.name + "'s turn"));
    }
}

//This function is responsible for: --> finish screen
function Finished(game) {
    let speler;
    let tegenSpeler;

    if (sessionStorage.getItem("PlayerID") == game.player1.id) {
        speler = game.player1;
        sessionStorage.setItem("player1Score", game.player1.score);
        sessionStorage.setItem("player1Name", game.player1.name);
        tegenSpeler = game.player2;
        sessionStorage.setItem("player2Score", game.player2.score);
        sessionStorage.setItem("player2Name", game.player2.name);
    } else {
        speler = game.player2;
        sessionStorage.setItem("player2Score", game.player2.score);
        sessionStorage.setItem("player2Name", game.player2.name);
        tegenSpeler = game.player1;
        sessionStorage.setItem("player1Score", game.player1.score);
        sessionStorage.setItem("player1Name", game.player1.name);

    }
    if (speler.score > tegenSpeler.score) {
        window.location.href = '../Frontend/winningscreen.html';
    } else {
        window.location.href = '../Frontend/losingscreen.html';
    }

}
//#endregion

//general functions:
function makeElementEmpty(element) {
    while (element.hasChildNodes()) {
        element.removeChild(element.firstChild);
    }
}