var showPreviewImg = {};

//이미지 미리보기기능
showPreviewImg.show = function (input,id,callbackName) {
    if (input.files && input.files[0]) {
    	
    	this.initProperty();
    	this.input = input;
    	this.inputFile = input.files[0];
		this.callback = callbackName;
    	
    	var reader = new FileReader();
        
    	reader.readAsDataURL(input.files[0]);
    	
        reader.onload = function(e) {
            document.getElementById(id).setAttribute('src', e.target.result);
        }
        if(typeof (callbackName) === 'function'){
        	callbackName();
		}
    }
}

showPreviewImg.initProperty = function() {
	this.input = null;
	this.inputFile = null;
	this.callback = null;
	this.newFile = null;
}

showPreviewImg.reSizeImgFile = function(width,height,callbackName) {
	this.callback = callbackName;
	var file = this.inputFile;
	var fileType = file.type;
	var reader = new FileReader();
	
	reader.readAsDataURL(file);
	
	reader.onloadend = function() {
		var image = new Image();
		image.src = reader.result;

		image.onload = function() {
			var maxWidth = width;
			var maxHeight = height;
			var imageWidth = image.width;
			var imageHeight = image.height;
			var canvas = document.createElement('canvas');
			var ctx = canvas.getContext('2d');
			
			if (imageWidth > imageHeight) {
				if (imageWidth > maxWidth) {
					imageHeight *= maxWidth / imageWidth;
					imageWidth = maxWidth;
				}
			} else {
				if (imageHeight > maxHeight) {
				    imageWidth *= maxHeight / imageHeight;
				    imageHeight = maxHeight;
				}
			}
			canvas.width = imageWidth;
			canvas.height = imageHeight;
			ctx.drawImage(this, 0, 0, imageWidth, imageHeight);
			if(typeof(showPreviewImg.callback) === 'function'){
				showPreviewImg.saveNewFile(canvas.toDataURL(fileType));
				showPreviewImg.callback(canvas.toDataURL(fileType));
			}
		}
	}
}

showPreviewImg.saveNewFile= function(resizeResultUrl) {
	var blobBin = null;
	var array = [];
	blobBin = atob(resizeResultUrl.split(',')[1]);
	for(var i = 0; i < blobBin.length; i++) {
	  array.push(blobBin.charCodeAt(i));
	}
	this.newFile = new Blob([new Uint8Array(array)], {type: 'image/png', name: 'avatar.png'});
}



