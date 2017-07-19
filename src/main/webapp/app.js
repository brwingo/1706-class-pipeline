/**
 * 	app.js
 */


window.onload = function(){
	console.log('loaded');
	loadNavbar();
	loadDashboardView();
}

function loadNavbar(){
	//make an ajax request to load the navbar html
	var xhr = new XMLHttpRequest();
	
	xhr.onreadystatechange = function(){
		if(xhr.readyState == 4 && xhr.status == 200){
			console.log('loading navbar code');
			document.getElementById('navbar').innerHTML = xhr.responseText;
			document.getElementById('txView').addEventListener('click', loadTxView, false);
			document.getElementById('dashboardView').addEventListener('click', loadDashboardView, false);
		}
	}
	
	xhr.open("GET", 'getNavbar', true);
	xhr.send();
	
}

function loadDashboardView(){
	//make an ajax request to load the navbar html
	var xhr = new XMLHttpRequest();
	
	xhr.onreadystatechange = function(){
		if(xhr.readyState == 4 && xhr.status == 200){
			console.log('loading dashboard code');
			document.getElementById('view').innerHTML = xhr.responseText;
		}
	}
	
	xhr.open("GET", 'getDashboardView', true);
	xhr.send();
	
}

function loadTxView(){
	//make an ajax request to load the navbar html
	var xhr = new XMLHttpRequest();
	
	xhr.onreadystatechange = function(){
		if(xhr.readyState == 4 && xhr.status == 200){
			console.log('loading withdraw/deposit code');
			document.getElementById('view').innerHTML = xhr.responseText;
			document.getElementById('txBtn').addEventListener('click', processTx, false);
		}
	}
	
	xhr.open("GET", 'transaction', true);
	xhr.send();
	
}

function processTx(){
	var amount = document.getElementById('amount').value;
	var txType = document.querySelector('input[name = "txType"]:checked').value;
	console.log('amount ' + amount + ' txType: ' + txType);
	
	//convert values into a single javascript object
	var tx = {
			txAmount: amount,
			txType: txType  
	}
	
	//convert javascript object into JSON
	tx = JSON.stringify(tx);
	
	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function() {
		if(xhr.readyState == 4 && xhr.status ==200){
			console.log(xhr.responseText);
			
		}
	}
	xhr.open("POST", "ajaxProcessTx", true);
	console.log(tx);
//	xhr.setRequestHeader("key",tx);
	//set the header to tell the server you have data for it to process
	xhr.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
	xhr.send(tx); //include your post data in the send()
}
