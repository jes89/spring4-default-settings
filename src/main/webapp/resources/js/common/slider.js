/**
 * 
 * <div id="slidebox" draggable="true" ondragstart="slider.checkStartPoint();"
 * ondrop="slider.checkEndPoint();" ondragover="slider.allowDrop();"></div>
 * slider.init("slidebox", imgSrcArr, width, height, movePixel, speed,isAutoSliding,slidingTime); <input
 * type="button" value="Left" onclick="slider.setNextIdx('Left')" /> <input
 * type="button" value="Right" onclick="slider.setNextIdx('Right')" />
 * 
 * 타겟에 드레그이벤트 셋팅 슬라이더 기본값 셋팅 slider.setNextIdx 이벤트 호출
 */

// ex)
// <div id="slidebox" draggable="true" ondragstart="slider.checkStartPoint();"
// ondrop="slider.checkEndPoint();" ondragover="slider.allowDrop();"></div>
// slider.init("slidebox", imgSrcArr, width, height, movePixel, speed);
// <input type="button" value="Left" onclick="slider.setNextIdx('Left')" />
// <input type="button" value="Right" onclick="slider.setNextIdx('Right')" />
var slider = {};
var width = 500;
var height = 300;
var movePixel = 5;
var speed = 5;
var isAutoSliding = true;
var slidingTime = 3000;
var imgSrcArr = [ "http://dummyimage.com/300x200/ff00ff/ffffff.png&text=img 1",
		"http://dummyimage.com/300x200/82e600/ff0000.png&text=img 2",
		"http://dummyimage.com/300x200/009eb3/000000.png&text=img 3",
		"http://dummyimage.com/300x200/d4bb00/0011ff.png&text=img 4",
		"http://dummyimage.com/300x200/7a3f00/ffffff.png&text=img 5" ];

slider.init = function(target, imgSrcArr, width, height, movePixel, speed,
		isAutoSliding, slidingTime) {
	this.initProperty(movePixel, speed, width, height);
	this.initLayout(target, imgSrcArr, width, height);

	if (isAutoSliding) {
		this.autoSlide(slidingTime);
	}

}

slider.initProperty = function(movePixel, speed, width, height) {
	this.isFirst = true;
	this.targetEl = null;
	this.liList = [];
	this.nowIdx = 0;
	this.nextIdx = 0;
	this.isAnimationStart = false;
	this.movePixel = movePixel;
	this.speed = speed;
	this.dragPoint = 0;
	this.autoSlideCnt = 0;
	this.targetStyle = "position: relative; overflow: hidden; white-space: nowrap; border: 1px solid #000; width:"
			+ width + "px; height :" + height + "px;";
	this.ulStyle = "list-style: none; margin: 0; padding: 0;";
	this.liStyle = "position: absolute;" + "width:" + width + "px; height :"
			+ height + "px;";
	this.imgStyle = "width:" + width + "px; height :" + height + "px;";
}

slider.initLayout = function(target, imgSrcArr, width, height) {
	var targetEl = document.getElementById(target);
	var tempUl = document.createElement("ul");
	var tempImgArr = [];
	var tempLiList = [];

	if (targetEl == null) {
		alert("슬라이더 오류, 관리자에게 문의하세요");
		return;
	}

	this.targetEl = targetEl;
	targetEl.style.cssText = this.targetStyle;
	tempUl.style.cssText = this.ulStyle;

	for (var ix = imgSrcArr.length; ix--;) {
		tempLiList[ix] = document.createElement("li");
		tempImgArr[ix] = document.createElement("img");

		tempLiList[ix].style.cssText = this.liStyle;
		tempImgArr[ix].style.cssText = this.imgStyle;

		tempImgArr[ix].setAttribute("src", imgSrcArr[ix])

		tempLiList[ix].appendChild(tempImgArr[ix]);
		tempUl.appendChild(tempLiList[ix]);

		this.liList[ix] = tempLiList[ix];
	}

	targetEl.appendChild(tempUl);
}

slider.setNextIdx = function(direction) {
	var liSize = this.liList.length;
	var fnName = "setNextIdxFor" + direction;

	if (this.isAnimationStart) {
		return;
	}

	if (typeof (this[fnName] === "function")) {
		this[fnName](liSize);
		this.sliding(direction);
	} else {
		alert("슬라이더 오류, 관리자에게 문의하세요.");
	}
}

slider.setNextIdxForLeft = function(liSize) {
	this.nextIdx = (this.nowIdx + 1);
	if (this.nextIdx === liSize) {
		this.nextIdx = 0;
	}
}

slider.setNextIdxForRight = function(liSize) {
	this.nextIdx = (this.nowIdx - 1);
	if (this.nextIdx < 0) {
		this.nextIdx = (liSize - 1);
	}
}

slider.checkStartPoint = function() {
	this.dragPoint = event.pageX;
}
slider.checkEndPoint = function() {
	var direction = null;
	if (this.dragPoint > event.pageX) {
		direction = "Left"
	} else {
		direction = "Right"
	}

	this.setNextIdx(direction);

}

slider.allowDrop = function() {
	event.preventDefault();
}

slider.sliding = function(direction) {
	var nowLi = this.liList[this.nowIdx];
	var nextLi = this.liList[this.nextIdx];
	var nowLiLeft = nowLi.offsetLeft;
	var StartX = direction === "Left" ? width : (width * -1);
	var newPositionX = 0;
	var movePixel = this.movePixel;

	this.isAnimationStart = true;
	if (this.isFirst) {
		nextLi.style.left = StartX + "px";
		this.isFirst = false;
	}

	for (var ix = 0, ixLen = this.liList.length; ix < ixLen; ix++) {

		this.liList[ix].style.zIndex = 0;
	}

	nowLi.style.zIndex = 1;
	nextLi.style.zIndex = 2;

	if (direction === "Left") {
		newPositionX = nextLi.offsetLeft - movePixel;
	} else {
		newPositionX = nextLi.offsetLeft + movePixel;
	}

	nextLi.style.left = newPositionX + "px";

	if (newPositionX !== nowLiLeft) {
		setTimeout(function() {
			slider.sliding(direction);
		}, this.speed);
	} else {
		this.nowIdx = this.nextIdx;
		this.isFirst = true;
		this.isAnimationStart = false;
		this.autoSlideCnt = 0;
	}

}

slider.autoSlide = function(slidingTime) {
	var maxCount = (slidingTime / 100);

	if (typeof (slidingTime) !== "number") {
		return;
	}

	setTimeout(function timeoutFn() {
		setTimeout(function() {
			if (slider.autoSlideCnt >= maxCount) {
				slider.setNextIdx("Left");
				slider.autoSlideCnt = 0;
			} else {
				slider.autoSlideCnt++;
			}

			timeoutFn();

		}, 90)
	}, 10)

}