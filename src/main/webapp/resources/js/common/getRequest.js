var request = {}

/*
 * 배열로 get방식의 파라미터 받아옴.
 */
request.getParameter = function(arr) {

	var requestParam = [];
	var param = arr;
	var url = unescape(location.href);
	var paramArr = (url.substring(url.indexOf('?') + 1, url.length)).split('&');
	var temp = [];
	var tempText = null;

	for (var jx = 0, jxLen = param.length; jx < jxLen; jx++) {
		for (var ix = 0, ixLen = paramArr.length; ix < ixLen; ix++) {
			temp = paramArr[ix].split('=');
			if (temp[0].toUpperCase() == param[jx].toUpperCase()) {
				requestParam.push(paramArr[ix].split('=')[1]);
				break;
			}
		}
	}

	return requestParam;

}


	