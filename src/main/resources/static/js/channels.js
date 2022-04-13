if(sessionStorage.getItem("user") === null) {
	window.location = "/welcome"	
}

var sendMessage = document.querySelector("#comment")
var url = window.location.pathname;
const queryString = window.location.href;
var id = url.substring(url.lastIndexOf('/'))
let channelId = queryString.substring(queryString.lastIndexOf("/") +1, queryString.length)
var user = JSON.parse(
	sessionStorage.getItem("user"))
console.log(user)

sendMessage.addEventListener('keypress', function(e) {
	if(e.key ==='Enter'){
	let newmessage = {
		channelId: channelId,
		message: sendMessage.value,
		userId : user.userId,
		username: user.username
	}
	sendMessage.value = ""
	fetch('/messageSent'+id,{
		method: 'POST',
		headers: {
			"Content-Type": "application/JSON"
		},
		body: JSON.stringify(newmessage)
	})
	.then((response) => response.json)
		.then(message => {
			getMessages()
		})}})
		
function getMessages(){
	fetch('/obtainMessages'+id,{
		method: 'POST',
		headers:{
			"Content-Type": "application/JSON"
		},
	})
		.then((response) => response.json())
			.then(messages => {
				displayMessages(messages)
					
			}
	)
}
setInterval(getMessages, 500);


function displayMessages(messages){
			var mainContainer = document.getElementById("commentSection")
			mainContainer.innerHTML = "";
		for(var i = 0; i < messages.length; i++){
			var div = document.createElement("div");
			div.innerHTML = messages[i].username + ' : ' + messages[i].message;
				mainContainer.appendChild(div)
				console.log(messages[i])
		}
}