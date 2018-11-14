<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="t"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="ko">
<head>
	<link href="/resources/css/admin/Common.css" rel="stylesheet" type="text/css" />
	<link href="/resources/css/admin/Layout.css" rel="stylesheet" type="text/css" />
</head>
<body>
	
	<t:insertAttribute name="userMenu" />
	<t:insertAttribute name="topMenu" />

	<dvi class="AdminCWrap"> 
		<t:insertAttribute name="sideMenu" />
		<t:insertAttribute name="content" />
		</dvi>
	</body>

</html>