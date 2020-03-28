
var button = document.createElement("button");
button.innerHTML = "+ Create New";


var body = document.getElementsByTagName("body")[0];
body.appendChild(button);

button.addEventListener ("click", function() {
  alert("You have caught deez nuts");
  window.open("creator.html");
});

console.log(data)
