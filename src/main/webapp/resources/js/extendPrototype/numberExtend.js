
if(typeof(Number.prototype.zf) == 'undefined'){
	Number.prototype.zf  = function(len){
		return this.toString().zf(len);
	}
}



