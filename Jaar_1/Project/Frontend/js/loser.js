function buttonpress(){
    window.location.href = '../Frontend/waitingroom.html';
}
let waitinRoomButton = document.getElementById("waitingroom_button");
waitinRoomButton.addEventListener("click", buttonpress);

let score = document.getElementById("score")


score.appendChild(document.createTextNode("Score"));
score.appendChild(document.createElement("br"));
score.appendChild(document.createElement("br"));
score.appendChild(document.createTextNode(sessionStorage.getItem("player1Name") + "'s Score: " + sessionStorage.getItem("player1Score")));
score.appendChild(document.createElement("br"));
score.appendChild(document.createTextNode(sessionStorage.getItem("player2Name") + "'s Score: " + sessionStorage.getItem("player2Score")));

