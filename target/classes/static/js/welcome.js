var user = sessionStorage.getItem("user")

if(user === null){
	
	let username = prompt("Please enter preferred name", "Guest")
		while (username === null || username === ''){
			username = prompt("You have to enter a name to join chat!", "Guest")
		}
		
	fetch("/welcome/user", {
		method: "POST",
		headers: {
			"Content-Type": "application/json"	
		},
		body :  username
	} )
	   .then(response =>  response.json())
	   .then(user => 

				{
					console.log(user)
					sessionStorage.setItem("user", JSON.stringify(user))})
			
} else {
	user = JSON.parse(sessionStorage.getItem("user"));
}
