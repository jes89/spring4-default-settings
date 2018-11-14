// prototype.js 필요

var Popup = {
    openPopup: function(popId, pageURL, pTop, pLeft, pWidth, pHeight, scrollbar, popupMode){
        if(this.readCookie('nopopup'+popId) != 'no')
            this['openPopup' + popupMode]('popup'+popId, pageURL, pTop, pLeft, pWidth, pHeight, scrollbar);
    },
    
    openPopupP: function(popId, pageURL, pTop, pLeft, pWidth, pHeight, scrollbar){
        window.open(pageURL, popId, "top=" + pTop + ",left=" + pLeft + ",width=" + pWidth + ",height=" + pHeight + ",scrollbars=" + scrollbar);
    },
    
    openPopupL: function(popId, pageURL, pTop, pLeft, pWidth, pHeight, scrollbar){
        if($(popId)) $(popId).remove();
        else{
            var pLayer = document.createElement('div');
            var pFrame = document.createElement('iframe');
            pLayer.id = popId;
            pFrame.id = popId + 'f';
            pFrame.name = popId + 'f';
            pFrame.src = pageURL;
            pFrame.scrolling = scrollbar;
            pFrame.allowTransparency = 'true'; // IE에서 아이프레임 투명도를 위해 allowTransparency=true 삽입-이길하(20080510) //
            pFrame.frameBorder = '0';
            Element.setStyle(pLayer,{
                position: 'absolute',
                top: pTop + 'px',
                left: pLeft + 'px',
                width: pWidth + 'px',
                height: pHeight + 'px',
                overflow: 'hidden',
                //backgroundColor: 'white', // IE에서 아이프레임 투명도를 위해 백그라운드 삭제-이길하(20080510) //
                padding: '0px',
                zIndex: '100'
            });
            Element.setStyle(pFrame,{
                margin: '0px',
                width: pWidth -1 + 'px',
                height: pHeight -1 + 'px'
            });
            
            pLayer.appendChild(pFrame);
            $$('body')[0].appendChild(pLayer);
        }
    },

    closeLayer: function(popId){
        if($('popup'+popId)) $('popup'+popId).remove();
    },
    
    closePopup: function(popId, popupMode){
        var noOpen = false;
        if($('noOpen')) noOpen = $('noOpen').checked;
        if(noOpen) this.createCookie('nopopup'+popId, 'no', 1);
        this['closePopup' + popupMode](popId);
    },
    
    closePopupP: function(popId, noOpen){
        self.close();
    },
    
    closePopupL: function(popId){
        parent.Popup.closeLayer(popId);
    },

    createCookie: function(name,value,days) {
	    if (days) {
		    var date = new Date();
		    date.setTime(date.getTime()+(days*24*60*60*1000));
		    date.setHours(00, 00, 00);//추가: 삭제 시간을 0시로 초기화
		    var expires = "; expires="+date.toGMTString();
	    }
	    else var expires = "";
	    document.cookie = name+"="+value+expires+"; path=/";
    },

    readCookie: function(name) {
	    var nameEQ = name + "=";
	    var ca = document.cookie.split(';');
	    for(var i=0;i < ca.length;i++) {
		    var c = ca[i];
		    while (c.charAt(0)==' ') c = c.substring(1,c.length);
		    if (c.indexOf(nameEQ) == 0) return c.substring(nameEQ.length,c.length);
	    }
	    return null;
    }
}