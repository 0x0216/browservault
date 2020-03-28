  var questiontitle = document.createElement("INPUT");
questiontitle.setAttribute("type", "text");
var code = (e.keyCode ? e.keyCode : e.which);
if(code == 13 && questiontitle.inbox.value != "") { 
 open( questiontitle.inputbox.value);
}
if(code == 13 && questiontitle.inbox.value == ""){
  window.open("index.html");
}
