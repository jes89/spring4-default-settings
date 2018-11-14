var server = {};


server.isTestServer = function() {
	var returnValue = false;
	if (location.href.indexOf("192.168.2.9") > -1 ||location.href.indexOf("192.168.2.26") > -1 || location.href.indexOf("localhost") > -1) {
		returnValue = true;
	}
	return returnValue;
}