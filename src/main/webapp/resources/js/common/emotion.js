var emotion = {};

//TargetId = 붙일 엘리먼트 Id
//ajaxUrl = 이모션 데이터 가져올 URL
//callback = 콜백 함수 (파라미터 보낼때 "callbackFn"이라고 하면 단순 String이니 callbackFn이라고 함수를 보내줘야함.)

emotion.init = function(targetId, ajaxUrl, callback) {
	this.dataStore(ajaxUrl);
	this.initProperty(callback);
	this.createStyleSheets();
	this.initLayout(targetId);
}
emotion.initProperty = function(callback) {
	this.emoJson = null;
	this.selectGroup = null;
	this.emoGroupLength = 0;
	this.sEmotionView = null;
	this.insertBtn = null;
	this.emoticonGroup = 0;
	this.emoticonCnt = 9999;
	this.emoBox = null;
	this.sEmotion = null;
	this.groupIdx = 0;
	this.emotionGroupLi = [];
	this.emotionGroup = 0;
	this.emoItemBox = null;
	this.emoItemPlayBox = null;
	this.emoticonPagingIdx = 1;
	this.callback = callback;
	this.smileIcon = "data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAABgAAAAYCAYAAADgdz34AAAAGXRFWHRTb2Z0d2FyZQBBZG9iZSBJbWFnZVJlYWR5ccllPAAABOpJREFUeNq0VmtQVGUYPre9q8DKttlGDiGwC8iYbsAmbNNFISUhh8QwapjEGXLCmabL1J9+9K8/zVSigYKGomOkZORgQzLWjMhVFhESWcAAucNyW2B3z27Pt57FE7NQf/xmnp3vvOc77/19vqU9Hg/1OBdHfnIO5a92RguYgSRgExxS0TQ9if0d4BpQC9j9fVhS+M1DAyssHfAJFGY5nc5gnucpiqYpCcdRZO92u9NYjvtcwkk6IT6GswWAw28EflYKcHzR4dgIBVSUPrI7OlpvfSI42KZUyucgZ0ZGxtY3t7RG3uvqiaAoz9cSiWQvvjkIdP6XgUx4XbqwsCjZHGPo2pu2+5pBH9EHOS+8ZwBSOHfqrp03G5paQssv/vJKX39/klwu/w3yVKBtJQMJUF4MDyXJO16+kZ2VcZXjOBfkUn/OoBZUnPE5a2R4WF9hcWlq863WbXK57AJeJQITPm98Sw4cXVx0KF8yJzbkvLP/VyinBOWrLWlAwDr+g7z3KsI3PdsB5wyQfUmJwvWt/Sjm1pAQ3Uh21ptVeGaF96Rwi6IU+ZZTkJMIOaSHys15+7JSIZ9FA+RCFiU2oCTd6nZ7qNTXdlxXKOTzggF3bV1jbOnZCykDA4MakRG+pbUt4vSZ8yld1p6nfUbgnC0hzljrQIrxfEBsYIuL5+M0mvWzxq1b7uGZHHDh4w3fHTuZ+VNFpbmo5Ew66kMT+djYeOC3BSfeuvTzFXNBYUmG3W6XEWeIEVPC8x0Mw5AmSBYbMPAuXh6ie6pfqVQQ7+lHlfQV9F/lJc8+DqBFZMBu0GrHg4ICbZiVMHEXPcnzLkqr1cwIuSVyLiws9EF+3sHz3T33deYkUzO6hqjigoPVtvzDh8pu324PT4g3tqlUykUhpZRaHcirg4Kck5NTAWIDHq+LHrHP3g0dH7etCagXuokV8k3HxkS1A61COpWPovMsqRMbGGIZhhoeHV0ryLynBh4Mqi2td4wsx/pnROSGYVneFGf8a80aFYmCGp+wsYAUdbCLDbSDV+b7BwZ1c/Z5hUqp8Lbl9MysqviHc69zLLusBg+Xy8VTSJf9hXhjh2+6B4eGNDabbZ1UKm0SF9kCJXXgl7WW1rYwXx3Cw0L7Y2MMvd4pRJ8vB1nm7aZGlUo1J+hy3qhtiEa7k32V2ADpnBNk9K9crU7EwJG282CS+ewD+yrVQYHTiMzLojzvhucuamZ2joqB8T2pyX8KmXD13u9T1zU0JUilEpKBs8sn+Ue8qLdae3Wl58p3ClGwoRufGfrs4yOnEk1xFlDCDNK3oNEEj6Xv2fXHR0fyyuA9UeaZm7PTRcWl6SBJFfJ/HLK7y8mOUML7Mpm0pvr36yaFXObIzHijmmFoChM6mn84t3x+fkHpcDpYpMcpk0rtQlfxExM22fcnT6ehnSNAdqSzvliJTZuQpncRSdnlyqoX/+4b0IKua0Bi/aSAoJBpYOkwUsberG+KuFhR+erA4LAOTnVBvA+YWu0+uAQju+FlIQquv9vZpTfowzs2R0dZkaIpdIeTUMPI6Ji6xdIWAa9DSe2gnFyfhOS6/8+NRg5vl8lkH/Jud/atljZDY7PFwDIsxbKMtz09HjdF6BzRksvlKFDkh3FXvZOHgU8Zmv4KdTGRSx9kF06mFop9l34N0ODvLl5ig8f9t+UfAQYAOmr/MvETVlIAAAAASUVORK5CYII=";
	this.nextIcon = "data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAAAsAAAARCAYAAAAL4VbbAAAAGXRFWHRTb2Z0d2FyZQBBZG9iZSBJbWFnZVJlYWR5ccllPAAAAL1JREFUeNpiLK9tY4ACNiD+xYAHMEFpAyC+DcT2hBQzA/FSIJYD4u34NIAU/wXiUCB+AcSc+DTAnHENiJ2B+DWSBhtcimEaHJA07ELXwISmGd0GkAYnXIpB4DKahr1A3IJLMUyDPxK/GoijcCkGmdiFxD8CxJuYcChE9twUIPYE4i9MWBQiB1s9EOeCFKK7GT1CmqAYI+iwKazHFSlbkBS2YlOIrHgNlO4A4hpcCYkFSk8H4rNAfApfEgUIMADRqSi1oKB2fAAAAABJRU5ErkJggg==";
	this.prevIcon = "data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAAAsAAAARCAYAAAAL4VbbAAAAGXRFWHRTb2Z0d2FyZQBBZG9iZSBJbWFnZVJlYWR5ccllPAAAAMBJREFUeNpi3LJ1BwMBwAzEf0EMJgIK7YH4HhAbEFIMUrgdiOWAeCnIBlyKbaAKOYH4BRCHgpzChEPhLqjC10DsDMTXsDkDXaEDTCG6Yickq1FMRFfcAsR7gZgHSeFldPeBFIcDcTWSmD82hTDFW4H4CJJYF9QpWBV/AWJPIJ6IxZMM2NwM0lAAxPVYwpkBW2iAQBOSBnt0DdgipQmKMTTgiu56NA1bCCUkkIYOKHsNiGAhkEQrgXg9EJ8CcQACDAA0kSkjlG5L6AAAAABJRU5ErkJggg==";
}

emotion.dataStore = function(ajaxUrl) {
	var xhttp = new XMLHttpRequest();
	xhttp.onreadystatechange = function() {
		if (this.readyState == 4 && this.status == 200) {
			emotion.emoJson = JSON.parse(this.responseText);
		}
	}
	xhttp.open("GET", ajaxUrl, true);
	xhttp.send();
}
emotion.initLayout = function(targetId) {
	var targetEl = document.getElementById(targetId);
	var insertBtn = document.createElement("button");
	var insertBtnImg = document.createElement("img");
	var insertBtnSpan = document.createElement("span");
	var sEmotion = document.createElement("span");
	var emoItemPlayBox = document.createElement("div");
	var useBtn = document.createElement("button");
	var light = document.createElement("div");
	var imotiWrap = document.createElement("div");
	var imotiThumb = document.createElement("div");
	var goPrevBtn = document.createElement("button");
	var goNextBtn = document.createElement("button")
	var emoBox = document.createElement("ul");
	var imotiItem = document.createElement("div");
	var emoItemBox = document.createElement("ul");

	insertBtn.className = "btn_insert";
	imotiWrap.className = "imotiWrap";
	imotiThumb.className = "imotiThumb";
	imotiItem.className = "imotiItem";
	emoItemPlayBox.className = "imotiView imotiM";
	useBtn.className = "btn_use";
	goPrevBtn.className = "go_prev";
	goNextBtn.className = "go_next";
	light.className = "imotiBox imotiM";

	sEmotion.style.display = "none";

	insertBtnSpan.style.cssText = "line-height:25px";
	insertBtnImg.style.cssText = "vertical-align:top;width:22px";
	emoItemPlayBox.style.cssText = "display:none; text-align:right;";

	insertBtnImg.setAttribute("src", this.smileIcon);

	insertBtnSpan.textContent = "이모티콘 삽입 ▼";
	useBtn.textContent = "사용하기";

	insertBtn.appendChild(insertBtnImg);
	insertBtn.appendChild(insertBtnSpan);
	emoItemPlayBox.appendChild(useBtn);
	sEmotion.appendChild(emoItemPlayBox);
	sEmotion.appendChild(light);
	light.appendChild(imotiWrap);
	imotiWrap.appendChild(imotiThumb);
	imotiWrap.appendChild(imotiItem);
	imotiItem.appendChild(emoItemBox);
	imotiThumb.appendChild(goPrevBtn);
	imotiThumb.appendChild(goNextBtn);
	imotiThumb.appendChild(emoBox);
	targetEl.appendChild(insertBtn);
	targetEl.appendChild(sEmotion);

	this.emoBox = emoBox;
	this.sEmotion = sEmotion;
	this.sEmotionView = insertBtnSpan;
	this.insertBtn = insertBtn;
	this.emoItemBox = emoItemBox;
	this.emoItemPlayBox = emoItemPlayBox;

	insertBtn.addEventListener("click", this.emoticonLoaded, false);
	goPrevBtn.addEventListener("click", this.preview, false);
	goNextBtn.addEventListener("click", this.nextview, false);

}

emotion.emoticonLoaded = function() {
	var sEmotionView = emotion.sEmotionView
	var sEmotion = emotion.sEmotion
	var emoBox = emotion.emoBox
	var emoBoxLi = emoBox.getElementsByTagName("li");
	var tempThumb = null;
	var tempLi = [];
	var emoJson = emotion.emoJson;
	var tempSelectedIdx = null;
	var emoThumb = null;
	var liListResult = "";

	if (emotion.selectGroup !== "view") {

		sEmotionView.textContent = "이모티콘 닫기 ▲";
		sEmotion.style.display = "";
		emotion.selectGroup = "view";
		
		if(emoJson != null && emoJson.length == 1){
			emoJson = emoJson["Json"];
		}
		

		for (var ix = 0, ixLen = emoJson.length; ix < ixLen; ix++) {

			tempSelectedIdx = emoJson[ix];

			emoThumb = "<li title=\"" + tempSelectedIdx["emoNm"] + "\"";
			emoThumb = emoThumb + "\" id='emotigroup" + tempSelectedIdx["emoIdx"];
			emoThumb = emoThumb + "' groupidx='" + tempSelectedIdx["emoIdx"];
			emoThumb = emoThumb + "' onmouseover=\"emotion.emoGroupHilight(" + tempSelectedIdx["emoIdx"] + ")\"";
			emoThumb = emoThumb + " onmouseout=\"emotion.emoGropDehilight(this)\" style='list-style-type : none;' >";
			emoThumb = emoThumb + " <img src='"+ tempSelectedIdx["emoThumb"] + "' style='cursor:pointer;' onclick='emotion.showEmoItems(" + tempSelectedIdx["emoIdx"] + ")'  />";
			emoThumb = emoThumb + " </li>";

			liListResult = liListResult + emoThumb;
		}
		emoBox.innerHTML = liListResult;

	} else {
		emotion.closeEmoticon();
	}
}

emotion.emoGroupHilight = function(groupidx) {
	var liList = this.emoBox.getElementsByTagName("li");
	var targetEl = document.getElementById("emotigroup" + groupidx);
	for (var ix = 0, ixLen = liList.length; ix < ixLen; ix++) {
		liList[ix].classList.remove("on");
	}
	if (targetEl) {
		targetEl.classList.add("on");
	}
}

emotion.emoGropDehilight = function(that) {
	that.classList.remove("on");
}

emotion.showEmoItems = function(emoIdx) {
	this.clear();

	var emoJson = this.emoJson;
	var tempJson = null;
	var tempIdx = null;
	var width = null;
	var height = null;
	var positions = null;
	var itemsThumb = null;
	var emoItemThumb = "";
	var xPos = 0;
	var yPos = 0;

	for (var ix = 0, ixLen = emoJson.length; ix < ixLen; ix++) {

		tempJson = emoJson[ix];
		tempIdx = tempJson["emoIdx"] * 1;

		if (tempIdx === (emoIdx * 1)) {

			width = tempJson["itemsThumbPos"]["width"];
			height = tempJson["itemsThumbPos"]["height"];
			positions = tempJson["itemsThumbPos"]["positions"];
			itemsThumb = tempJson["itemsThumb"];

			for (var jx = 0, jxLen = positions.length; jx < jxLen; jx++) {

				xPos = positions[jx][0];
				yPos = positions[jx][1];

				emoItemThumb = emoItemThumb + " <li style='float:left; list-style-type : none;' > ";
				emoItemThumb = emoItemThumb + " <button type='button' class='emoItemBtn' ";
				emoItemThumb = emoItemThumb + " style=\"width:" + width + "px; height:" + height + "px; border:0px; outline:0px; ";
				emoItemThumb = emoItemThumb + " background:url('" + itemsThumb + "') -" + xPos + "px -" + yPos + "px no-repeat\" ";
				emoItemThumb = emoItemThumb + " onclick='emotion.playEmoItem(" + emoIdx + ", " + jx + ")' ";
				emoItemThumb = emoItemThumb + " onmouseover='emotion.emoItemHilight(this)' ";
				emoItemThumb = emoItemThumb + " onmouseout='emotion.emoItemDehilight(this)' /> ";
				emoItemThumb = emoItemThumb + " </li> ";

			}

			this.emoItemBox.innerHTML = emoItemThumb;
			break;
		}
	}

	this.emoticonGroup = emoIdx;
	this.clearEmoticonitem();
}

emotion.closeEmoticon = function() {
	this.clear();
	this.sEmotionView.textContent = "이모티콘 삽입 ▼";
	this.selectGroup = "";
	this.sEmotion.style.display = "none";
	this.emotionGroup = 0;
	this.emoticonCnt = 9999
}

emotion.clearEmoticonitem = function() {
	this.emoItemPlayBox.textContent = "";
	this.emoticonCnt = 9999;
	this.emoItemPlayBox.style.display = "none";
}

emotion.clear = function() {

	this.emotionGroup = 0;
	this.emoticonCnt = 9999;
	this.emoItemBox.textContent = "";
	this.emoItemPlayBox.textContent = "";
	this.emoItemPlayBox.style.display = "none";
}

emotion.emoItemHilight = function(that) {

	var emoItemBtn = document.getElementsByClassName("emoItemBtn");

	for (var ix = 0, ixLen = emoItemBtn.length; ix < ixLen; ix++) {
		emoItemBtn[ix].style.border = "none";
	}
	
	that.style.border = "1px solid #ddd";
}

emotion.emoItemDehilight = function(that) {
	that.style.border = "none";
}

emotion.playEmoItem = function(emoIdx, itemIdx) {
	var btnHtml = "<button type='button'onclick='emotion.createEmoticonItem();' class='btn_use'>사용하기</button>&nbsp;&nbsp;</br></br></br></br></br>";
	var iframHtml = "<iframe src='http://app.hsp.net/M/Emoticon/EmoticonView.aspx?emoIdx=" + emoIdx + "&itemIdx=" + itemIdx + "' scrolling='no' frameborder='0' style='width:155px; height:110px;' />";
	
	this.emoItemPlayBox.innerHTML = btnHtml + iframHtml;
	this.emoItemPlayBox.style.display = "";
	this.emotionGroup = emoIdx;
	this.emoticonCnt = itemIdx;

}

emotion.createEmoticonItem = function() {
	var emoGroupIdx = this.emoticonPagingIdx;
	var emoItemIdx = this.emoticonCnt;

	if (emoGroupIdx == "" || emoItemIdx == "") {
		emoGroupIdx = "0"
		emoItemIdx = "9999"
	}

	var emoticon = "<iframe src='http://app.hsp.net/M/Emoticon/EmoticonView.aspx?emoIdx=" + emoGroupIdx + "&itemIdx=" + emoItemIdx + "' scrolling='no' frameborder='0' style='width:155px; height:110px;' />";

	if (typeof (this.callback) === "function") {
		this.callback(emoticon);
	}
	
	emotion.closeEmoticon();
}

emotion.preview = function() {
	var emoticonGroupviewPagingIdx = emotion.emoticonPagingIdx;
	var emoBox = emotion.emoBox
	var emoBoxLi = emoBox.getElementsByTagName("li");

	if ((emoticonGroupviewPagingIdx - 1) * 10 >= 0) {
		emoticonGroupviewPagingIdx--;

		for (var ix = 0, ixLen = emoBoxLi.length; ix < ixLen; ix++) {
			if (ix <= (emoticonGroupviewPagingIdx - 1) * 10
					&& ix < emoticonGroupviewPagingIdx * 10) {
				emoBoxLi[ix].style.display = "";
			}
		}
	}

	emotion.emoticonPagingIdx = emoticonGroupviewPagingIdx;
}
emotion.nextview = function() {
	var emoticonGroupviewPagingIdx = emotion.emoticonPagingIdx;
	var emoBox = emotion.emoBox
	var emoBoxLi = emoBox.getElementsByTagName("li");

	if (emoBoxLi.length >= emoticonGroupviewPagingIdx * 10) {

		for (var ix = 0, ixLen = emoBoxLi.length; ix < ixLen; ix++) {
			if (ix <= (emoticonGroupviewPagingIdx - 1) * 10
					&& ix < emoticonGroupviewPagingIdx * 10) {
				emoBoxLi[ix].style.display = "none";
			}
		}
		emoticonGroupviewPagingIdx++;
	}
	emotion.emoticonPagingIdx = emoticonGroupviewPagingIdx;
}

emotion.createStyleSheets = function() {

	var head = document.head || document.getElementsByTagName('head')[0];
	var style = document.createElement('style');
	var css = ".imotiBtn {position:relative;padding-top:10px;height:24px} ";
	css = css + ".imotiBtn button {height:24px;color:#767676;border:none;background:none;font-size:12px;font-family:gulim} ";
	css = css + ".imotiBtn button span {line-height:28px} ";
	css = css + ".imotiBtn button img {vertical-align:top} ";
	css = css + ".imotiView {position:absolute;top:50px;left:533px;width:170px;height:385px;text-align:center;background:#fff;border:1px solid #d4d4d4;z-index:1000} ";
	css = css + ".imotiView img {width:170px;height:auto;margin:120px auto;cursor:pointer} ";
	css = css + ".imotiBox {position:absolute;top:50px;left:-17px;width:550px;height:auto;border:1px solid #d4d4d4;overflow:hidden;background:#fff;z-index:1000} ";
	css = css + ".imotiThumb {height:45px;position:relative;border-bottom:1px solid #ddd} ";
	css = css + ".imotiThumb .go_prev {top:0;left:0;border-right:1px solid #ddd;background:url(" + this.prevIcon + ") center center no-repeat, #ebebeb} ";
	css = css + ".imotiThumb .go_next {top:0;right:0;border-left:1px solid #ddd;background:url(" + this.nextIcon + ") center center no-repeat, #ebebeb} ";
	css = css + ".imotiThumb ul {padding:0 35px;height:45px;background:#f4f4f6;overflow:hidden} ";
	css = css + ".imotiThumb li {float:left;height:45px;width:48px;text-align:center;cursor:pointer} ";
	css = css + ".imotiThumb li img {width:auto;height:35px;margin-top:5px;vertical-align:top}";
	css = css + ".imotiItem {overflow-y:scroll;height:339px} ";
	css = css + ".imotiItem ul {padding:20px 0} ";
	css = css + ".imotiItem li {float:left;width:23%;height:100px;margin:1%;text-align:center} ";
	css = css + ".imotiItem li img {width:125px;height:auto} ";
	css = css + ".replyemoticon {position:relative;width:170px; margin-top:10px;background:#fff;border:0px solid #F00;} ";
	css = css + ".replyemoticon img {width:170px;height:auto;} ";
	css = css + ".imotiView.type02 {position:absolute;top:40px;left:503px;width:170px;height:385px;text-align:center;background:#fff;border:1px solid #d4d4d4;z-index:1000} ";
	css = css + ".imotiBox.type02  {position:absolute;top:40px;left:-47px;width:550px;height:auto;border:1px solid #d4d4d4;overflow:hidden;background:#fff;z-index:1000} ";
	css = css + ".ReplyWrap .ReplyCon .imotiBox li {padding:0;border-bottom:0} ";
	css = css + ".ReplyWrap .ReplyCon .imotiBox.type02 .imotiItem li.on {border-bottom:1px solid #ddd} ";
	css = css + ".imotiItem li.on {border:1px solid #ddd;box-sizing:border-box;-o-box-sizing:border-box;-ms-box-sizing:border-box;-moz-box-sizing:border-box;-webkit-box-sizing:border-box} ";
	css = css + ".imotiThumb li.on {background:#ebebeb;border-right:1px solid #ddd;border-left:1px solid #ddd;box-sizing:border-box;-o-box-sizing:border-box;-ms-box-sizing:border-box;-moz-box-sizing:border-box;-webkit-box-sizing:border-box} ";
	css = css + ".imotiThumb button {position:absolute;width:35px;height:45px;overflow:hidden;text-indent:-9999px;box-sizing:border-box;-o-box-sizing:border-box;-ms-box-sizing:border-box;-moz-box-sizing:border-box;-webkit-box-sizing:border-box} "

	style.type = 'text/css';

	if (style.styleSheet) {
		style.styleSheet.cssText = css;
	} else {
		style.appendChild(document.createTextNode(css));
	}

	head.appendChild(style);

}