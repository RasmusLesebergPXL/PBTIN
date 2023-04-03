window.addEventListener("load", loaded);

function loaded() {

    let buttonGetPerformances = document.getElementById('get_performances');
    buttonGetPerformances.addEventListener("click", handleGetPerformances);

    let buttonGetPerfByDate = document.getElementById('get_performances_by_date');
    buttonGetPerfByDate.addEventListener("click", handleGetPerformancesByDate);

    let buttonGetPerfById = document.getElementById('get_performance_id');
    buttonGetPerfById.addEventListener("click", handleGetPerformancesById);

    let buttonPostPerformance = document.getElementById('post_performance');
    buttonPostPerformance.addEventListener("click", handlePostPerformance);

}

function handleGetPerformances() {
    let url = 'http://localhost:3000/performances/';
    let output = document.getElementById("div_output");
    makeElementEmpty(output);
    fetch(url)
        .then((response) => {
            if (response.ok) {
                return response.json();
            } else {
                throw `error with status ${response.status}`;
            }
        })
        .then((festivals) => {
            let data = [];
            for (let festival of festivals) {
                data.push([festival.id, festival.name, festival.play_date, festival.description]);
            }
            let table = makeTable(data);
            output.appendChild(table);
        })
        .catch((error) => {
            output.appendChild(document.createTextNode(error));
        });
}

function handleGetPerformancesByDate() {
    let url = 'http://localhost:3000/performances/';
    let date = document.getElementById("date_input").value;
    let output = document.getElementById("div_output");
    makeElementEmpty(output);

    if (date.trim()!=''){
        fetch(`${url}?play_date=${date}`)
            .then((response) => {
                if (response.ok) {
                    return response.json();
                } else {
                    throw `error with status ${response.status}`;
                }
            })
            .then((festivals) => {
                let data = [];
                for (let festival of festivals) {
                    data.push([festival.id, festival.name, festival.play_date, festival.description]);
                }
                let table = makeTable(data);
                output.appendChild(table);
            })
            .catch((error) => {
                output.appendChild(document.createTextNode(error));
            });
    }
}

function handleGetPerformancesById() {
    let url = 'http://localhost:3000/performances/';
    let id = document.getElementById("id_input").value;
    let output = document.getElementById("div_output");
    makeElementEmpty(output);

    if (id.trim()!=''){
        fetch(`${url}?id=${id}`)
            .then((response) => {
                if (response.ok) {
                    return response.json();
                } else {
                    throw `error with status ${response.status}`;
                }
            })
            .then((festivals) => {
                let data = [];
                for (let festival of festivals) {
                    data.push([festival.id, festival.name, festival.play_date, festival.description]);
                }
                let table = makeTable(data);
                output.appendChild(table);
            })
            .catch((error) => {
                output.appendChild(document.createTextNode(error));
            });
    }
}

function handlePostPerformance() {
    let url = 'http://localhost:3000/performances/';
    let output = document.getElementById("div_output");

    let name = document.getElementById("name_input").value;
    let date_show = document.getElementById("post_date_input").value;
    let description = document.getElementById("omschrijving_input").value;
    let festival = {name: name, play_date: date_show, description: description}

    makeElementEmpty(output);
    fetch(url,
        {
            method: "POST",
            body: JSON.stringify(festival),
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
        .then((festival) => {
            let data = [];
            data.push([festival.id, festival.name, festival.play_date, festival.description]);
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

function makeElementEmpty(element) {
    while (element.hasChildNodes()) {
        element.removeChild(element.firstChild);
    }
}
