
var button = document.createElement("button");
button.innerHTML = "Download for Windows";

var button2 = document.createElement("button2");
button2.innerHTML = "Download for Mac";

var body = document.getElementsByTagName("body")[0];
body.appendChild(button);
body.appendChild(button2);

button.addEventListener ("click", function() {
  window.open("creator.html");
});

button2.addEventListener("click", function(){
  window.open("creator.html");
});

