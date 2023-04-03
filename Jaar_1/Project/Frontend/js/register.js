window.addEventListener("load", loaded);

function loaded() {

    let registerPostButton = document.getElementById('registerbtn');
    registerPostButton.addEventListener("click", handlePostRegisterDetails);

}

function handlePostRegisterDetails() {

    let url = 'https://localhost:5001/api/Authentication/register';
    let username = document.getElementById("username").value;
    let email = document.getElementById("email").value;
    let psw = document.getElementById("psw").value;
    let psw_repeat = document.getElementById("psw_repeat").value;
    let output = document.getElementById("section_output");
    let register = {email: email, password: psw, nickName: username};

    if (output !== null) {
        makeElementEmpty(output);
    }

    if (username === "") {
        output.appendChild(document.createTextNode("The Username field is not filled in"));
        return;
    }
    if (email === "") {
        output.appendChild(document.createTextNode("The Email field is not filled in"));
        return;
    }
    if (psw === "") {
        output.appendChild(document.createTextNode("The Password field is not filled in"));
        return;
    }
    if (psw_repeat === "") {
        output.appendChild(document.createTextNode("The Repeat Password field is not filled in"));
        return;
    }

    if (psw === psw_repeat && psw.length >= 5) {
        fetch(url,
            {
                method: "POST",
                body: JSON.stringify(register),
                headers: {
                    'Accept': 'application/json',
                    'Content-Type': 'application/json'
                }
            })
            .then((response) => {
                if (response.ok) {
                    sessionStorage.setItem("email", email);
                    window.alert("Login succeeded");
                    window.location.href = '../Frontend/index.html';

                } else if (response.status === 400) {
                    response.json().then(s => output.appendChild(document.createTextNode(s.message)));
                    throw `error with status ${response.status}`; //
                }
            })
            .catch(() => {
                output.appendChild(document.createTextNode(  "\n\n"));
            });
    } else {
        if (psw !== psw_repeat && psw.length >= 5){
            output.appendChild(document.createTextNode("Passwords don't match"))
        } else {
            output.appendChild(document.createTextNode("Password length is too short"))
        }
    }
}

function makeElementEmpty(element) {
    while (element.hasChildNodes()) {
        element.removeChild(element.firstChild);
    }
}
