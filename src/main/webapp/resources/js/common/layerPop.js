var layerPop = {};

layerPop.showLayerPop = function(elementId) {
	var getGraywrapperEl = document.createElement('div');
	var getEl = document.getElementById(elementId);
	var documentHeight = document.body.clientHeight;
	var contents = document.getElementById("contents");
	var footer = document.getElementById("footer");
	
	//이쪽은 성능상 cssText로 입력
	getEl.style.cssText = "z-index: 11; display : '';"
	getGraywrapperEl.style.cssText = "z-index: 10; display : ''; top : 0px; left:0px; position : absolute; background : rgba(0,0,0,0.5);";
	
	//이쪽은 가동성상 프로퍼티에 직접입력함.
	getGraywrapperEl.style.width = "100%";
	
	if(contents && footer){
		if(contents.offsetHeight > documentHeight){
			documentHeight = documentHeight + contents.offsetHeight + footer.offsetHeight+200;
		}
	}
	
	getGraywrapperEl.style.height = documentHeight + 'px';

	this.grayEl = getGraywrapperEl;

	document.body.appendChild(getGraywrapperEl);
}

layerPop.property = function() {
	this.grayEl = null;
}

layerPop.closeLayerPop = function(id) {
	document.getElementById(id).style.display = 'none';
	this.grayEl.style.display = 'none';
}