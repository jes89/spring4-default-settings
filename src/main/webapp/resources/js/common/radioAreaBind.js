function radioAreaBind(processArr){
	
	var doc 		= document;
	var tempEl		= null;
	var tempValue 	= null;
	var tempInput	= null;
	var ix			= 0;
	var ixLen		= processArr.length;
	var jx			= null;
	var jxLen		= null;

	for(; ix < ixLen; ix++){
		
		tempEl 		= doc.getElementById(processArr[ix]);
		if(tempEl){
			tempValue 	= tempEl.getAttribute('data-set');
			tempInput	= tempEl.getElementsByTagName('input');
			for(jx = 0, jxLen = tempInput.length ; jx < jxLen; jx++){
				if(tempInput[jx].value === tempValue){
					tempInput[jx].checked = true;
				}
			}
		}
		
	}
};