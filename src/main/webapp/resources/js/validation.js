function validateForm() {
	var manufacturer = document.forms["frm"]["manufacturer"].value;
	var model=document.forms["frm"]["model"].value;
	var price = document.forms["frm"]["price"].value;
	var date = document.forms["frm"]["date"].value;
	year=date.substring(0, 4);
	var pattern = /^(\d+\.?\d{0,9}|\.\d{1,9})$/;
	var patternLine = /^[A-Za-z0-9]+(?:[ _-][A-Za-z0-9]+)*$/;
	valid=true;	

	if (manufacturer.length == 0) {
		var input = document.getElementById('manufacturer');
		input.style.border = "thin solid red";
		valid= false;
	}	
	
	if (manufacturer.length != 0) {
		var input = document.getElementById('manufacturer');
		input.style.border = "";
	}

	if (!patternLine.test(manufacturer)) {
		var input = document.getElementById('manufacturer');
		input.style.border = "thin solid red";
		valid= false;
	}

	if (patternLine.test(manufacturer)) {
		var input = document.getElementById('manufacturer');
		input.style.border = "";
	}
	
	if (model.length == 0) {
		var input = document.getElementById('model');
		input.style.border = "thin solid red";
		valid= false;
	}	
	
	if (model.length != 0) {
		var input = document.getElementById('model');
		input.style.border = "";
	}

	if (!patternLine.test(model)) {
		var input = document.getElementById('model');
		input.style.border = "thin solid red";
		valid= false;
	}

	if (patternLine.test(model)) {
		var input = document.getElementById('model');
		input.style.border = "";
	}
	
	if (date.length == 0) {
		var input = document.getElementById('date');
		input.style.border = "thin solid red";
		valid= false;
	}	
	
	if (date.length != 0) {
		var input = document.getElementById('date');
		input.style.border = "";
	}
	if(year>2016 || year< 1886) {
		var input = document.getElementById('date');
		input.style.border = "thin solid red";
		valid= false;
	}
	
	if(year<2016 && year>1886) {
		var input = document.getElementById('date');
		input.style.border = "";
	}
	
	if (price.length == 0) {
		var input = document.getElementById('price');
		input.style.border = "thin solid red";
		valid= false;
	}	
	
	if (price.length != 0) {
		var input = document.getElementById('price');
		input.style.border = "";
	}
	
	if (!pattern.test(price)) {
		var input = document.getElementById('price');
		input.style.border = "thin solid red";
		valid= false;
	}
	
	if (pattern.test(price)) {
		var input = document.getElementById('price');
		input.style.border = "";
	}
	
	return valid;
}



