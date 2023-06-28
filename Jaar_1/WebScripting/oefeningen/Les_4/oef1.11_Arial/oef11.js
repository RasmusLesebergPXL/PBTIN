window.addEventListener("load", handleLoad);

function handleLoad() {
    let selecteerLettertype = document.getElementById("select_lettertype");
    selecteerLettertype.addEventListener("change",handleChange );

    let selecteerSize = document.getElementById("select_fontsize");
    selecteerSize.addEventListener("change",handleChange );
}

function handleChange() {
    let font = document.getElementById("select_lettertype").value;
    let size = document.getElementById("select_fontsize").value;
    let text = document.getElementById("p_voorbeeld");

    text.style.fontSize = size;
    text.style.fontFamily = font;
}
