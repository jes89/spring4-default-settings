function selectBoxBind(processArr){
	
	var tempEl		= null;
	var tempValue 	= null;
	var ix			= 0;
	var ixLen		= processArr.length;
	var jx			= 0;
	var jxLen 		= null;
	for(; ix < ixLen; ix++){
		
		tempEl 		= document.getElementById(processArr[ix]);
		if(tempEl){
			
			tempValue 	= tempEl.getAttribute('data-set');
			
			for(jx = 0, jxLen = tempEl.options.length; jx < jxLen;  jx++){
				if(tempEl[jx].value === tempValue){
					tempEl.selectedIndex = jx;
				}
			}
			
		}
	
	}
};


