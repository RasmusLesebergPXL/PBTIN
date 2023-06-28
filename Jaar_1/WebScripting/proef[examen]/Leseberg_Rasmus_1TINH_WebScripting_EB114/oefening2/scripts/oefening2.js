//naam: Rasmus Leseberg

//DINGEN DIE NIET WERKEN:

// getElementsbyTagName in handleLoad. Met getElementbyID werkte het wel, maar helaas niet met TagName. Ik heb niks mogen wijzigen
// in de html, dus ik heb dit niet kunnen oplossen.
// De disabling van de href lukte niet in activityDetails()
// Het sorteren van de datums is niet op de juiste plaats
// Het meegeven van de juiste items op click op een van de li items werkt niet

'use strict';
window.addEventListener("load", handleLoad);

function handleLoad() {
    let url = 'http://localhost:3000/activities';
    let output = document.getElementsByTagName("fieldset")[0];

    makeElementEmpty(output);

    fetch(url)
        .then((response) => {
            if (response.ok) {
                return response.json();
            } else {
                throw `error with status ${response.status}`;
            }
        })
        .then((activities) => {
            let list = makeList(activities);
            output.appendChild(list);
        })
        .catch((error) => {
            output.appendChild(document.createTextNode(error));
        });
}

function makeList(listOfEvents) {
    let list = document.createElement("ul");

    // sortByDate(listOfEvents);

    for (let i = 0; i < listOfEvents.length; i++) {
        let listItem = document.createElement("li");
        let aItem = document.createElement("a");
        aItem.id = "aItem";
        aItem.href = "http://pxl.be";
        aItem.appendChild(document.createTextNode(listOfEvents[i].name));
        aItem.appendChild(document.createElement("br"));
        aItem.addEventListener("click", () => { activityDetails(listOfEvents[i]);})

        let today = new Date();
        let eventDate = new Date(listOfEvents[i].date)
        if (eventDate < today.getDate()) {
            aItem.appendChild(document.createTextNode(listOfEvents[i].date))
        }

        listItem.appendChild(aItem);
        list.appendChild(listItem);
    }
    return list;
}

function sortByDate(array) {
    let sortedArray = []
    sortedArray[0] = new Date(array[0].date);
    for (let i = 0; i < array.length; i++) {
        let date = new Date(array[i].date)
        if (date < sortedArray[0]) {
            sortedArray[0] = array[i].date;
        }
    }
    return sortedArray;
}

function activityDetails(event){

    let output = document.getElementById("aItem");
    output.href.link("localhost:3000/activities");
    let block = makeBlock(event);
    output.appendChild(block);
}

function makeBlock(details) {
    let block = document.createElement("blockquote");
    block.appendChild(document.createTextNode(details.time));
    block.appendChild(document.createElement("br"));
    block.appendChild(document.createTextNode(details.location));
    block.appendChild(document.createElement("br"));
    block.appendChild(document.createTextNode(details.place));

    block.style.backgroundColor = "yellow";
    block.style.color = "green";

    return block;
}

function makeElementEmpty(element) {
    while (element.hasChildNodes()) {
        element.removeChild(element.firstChild);
    }
}