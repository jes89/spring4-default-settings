var formAction = {}

formAction.setForm = function(name,method,url) {
	
	if(document.forms[name] == null || document.forms[name] == undefined){
		alert('전송 오류 관리자에게 문의하세요');
		return;
	}
	
	if(!method){
		method = 'POST';
	}
	
	if(!url){
		alert('전송 오류 관리자에게 문의하세요');
		url = '/';
	}
	
	this.property(name);
	document.forms[name].action = url;
	document.forms[name].method = method;
	
}
formAction.submit = function() {
	document.forms[this.formName].submit();
}

formAction.property = function(name) {
	this.formName = name;
}