var xmlhttp;
function getAjax(url, divName) {
	if (window.XMLHttpRequest) {
		xmlhttp=new XMLHttpRequest(); 
	} else {
		xmlhttp=new ActiveXObject("Microsoft.XMLHTTP");
	}
	if(url.indexOf("?") < 0) url += "?";
	else url += "&";
	url += "random_token=" + Math.random();
	//alert(url);
	xmlhttp.open("GET",url,true); 
	xmlhttp.onreadystatechange= function(){callBack(divName)};
	xmlhttp.send();
}
function callBack(divName){
	if (xmlhttp.readyState==4 && xmlhttp.status==200) {
		document.getElementById(divName).innerHTML=xmlhttp.responseText; 
	} 
}
