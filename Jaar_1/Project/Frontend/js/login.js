window.addEventListener("load", loaded);

function loaded() {
    let username = document.getElementById("email");
    let email_fill = sessionStorage.getItem("email");

    if (email_fill !== "") {
        username.value = email_fill;
    }

    let loginPostButton = document.getElementById('login_button');
    loginPostButton.addEventListener("click", handlePostLogin);
}

function handlePostLogin() {

    let url = 'https://localhost:5001/api/Authentication/token';
    let email = document.getElementById("email").value;
    let password = document.getElementById("password").value;
    let login = {email: email, password: password};
    let output = document.getElementById("section_output");

    if (output !== null) {
        makeElementEmpty(output);
    }
    if (email === "") {
        output.appendChild(document.createTextNode("The Username field is not filled in"));
        return;
    }
    if (password === "") {
        output.appendChild(document.createTextNode("The Password field is not filled in"));
        return;
    }

    fetch(url,
        {
            method: "POST",
            body: JSON.stringify(login),
            headers: {
                'Accept': 'application/json',
                'Content-Type': 'application/json'
            }
        })
        .then((response) => {
            if (response.status === 200) {
                return response.json();

            } else if (response.status === 401) {
                output.appendChild(document.createTextNode("Unauthorized"));
                // response.json().then(s => output.appendChild(document.createTextNode(s.message)));
                throw `error with status ${response.status}`;

            } else if (response.status === 400) {
                output.appendChild(document.createTextNode("Password is incorrect"));
            }
        })
        .then((jsonResponse) => {
            if (email === "quizmaster@pxl.be") {
                sessionStorage.setItem("quizmasterToken",jsonResponse.token);
                window.location.href = '../Frontend/quizmaster.html';                               // QM redirect to QM page
            } else {
                sessionStorage.setItem("playerToken",jsonResponse.token);
                sessionStorage.setItem("PlayerID" ,jsonResponse.user.id )
                window.location.href = '../Frontend/waitingroom.html';                              // other people to waiting room
            }
        })
        .catch(() => {
            output.appendChild(document.createTextNode(""));
        });
}

function makeElementEmpty(element) {
    while (element.hasChildNodes()) {
        element.removeChild(element.firstChild);
    }
}
