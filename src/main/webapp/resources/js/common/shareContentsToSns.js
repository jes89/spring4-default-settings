

var shareConetentsToSns = {};


shareConetentsToSns.kakaoInit = function(title,imgPath,btnText,url,target) {
	 
	var filter      = 'win16|win32|win64|mac';
	 
	 if (navigator.platform) {
	    if (0 < filter.indexOf(navigator.platform.toLowerCase())) {
	        document.getElementById(target).style.display = 'none';
	        return;
	    }
	 }
	 
	 Kakao.init('a99fb2c457f8c14015873e48c49df28a');
	 Kakao.Link.createTalkLinkButton({
        container : '#kakao-link-btn',
        label : title,
        image : {
			src : imgPath,
			width : '200',
			height : '150'
		},
        webButton: {
			text : btnText,
			url  : url
	    }
	});
}


shareConetentsToSns.shareContents = function(target,title,img,url) {
	var fullUrl = null;

	if(target === 'facebook'){
	    fullUrl = 'http://www.facebook.com/share.php?s=100&p[url]='+ encodeURIComponent(url) 
	               +'&p[images][0]='+ img 
	               +'&p[title]='+ title 
	               +'&p[summary]='+ '';
	    window.open(fullUrl,'','');
	} else if(target === 'twitter'){
		title = encodeURIComponent(title);
         window.open('http://twitter.com/share?text=' + title + '&url=' + encodeURIComponent(url));
	} else if(target === 'kakaoStory'){
		 Kakao.Story.share({
             url: url,
             text: title
         });
	}
}




