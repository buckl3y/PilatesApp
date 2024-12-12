const btn = document.getElementById("user_input_submit");

btn.addEventListener("click", () => {
    console.log("Button clicked");
    const request = new XMLHttpRequest();
    request.open("GET", "http://localhost:3000/status");
    request.send();
})