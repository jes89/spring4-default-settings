<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div id="fileArea"></div>

	<table id="fileWrapper">
		<tr>
			<td style="vertical-align: text-top; font-size: 11px; padding-bottom: 8px;">
				파일명, (파일 용량) 표시</td>
			<td>
				<div id="viewFile" style="margin-top: -5px;"></div>
				<div id="fileCloneArea" style="display:"none";></div>
			</td>
		</tr>
	</table>
	
	
	<input type="file" onchange="executeCloneFile(this);">

<script type="text/javascript">
//파일 여러개 첨부기능
function executeCloneFile(getEl) {
    var doc           = document,
        fileCloneArea = doc.getElementById("fileCloneArea"),
        fileArea      = doc.getElementById("fileArea"),
        viewFile      = doc.getElementById("viewFile"),
        cloneList     = doc.getElementsByClassName("cloneConut"),
        clone         = doc.createElement("input"),
        fileSize      = getEl.files[0].size,
        fileName      = getEl.files[0].name,
        ix            = 0,
        ellipsisName  = fileName,
        ixLen         = cloneList.length;

    //파일 10개 이하인지 체크
        if (cloneList.length < 10) {
            for (; ix < ixLen; ix++) {
                fileSize += cloneList[ix].getAttribute("data-fileSize")*1;
            }
            //파일 용량이 10MB가 넘는지 체크
            if (fileSize < 1085760) {

                clone.setAttribute("type", "file");
                clone.setAttribute("name", "FileName");
                clone.setAttribute("onchange", "executeCloneFile(this)");
                
                clone.style.height       = "22px";
                clone.style.marginLeft   = "8px"
                clone.style.marginBottom = "1px"
                
                getEl.className        = "cloneConut";
                getEl.style.display = "none";
                
                getEl.setAttribute("data-fileSize", getEl.files[0].size)

                if (getEl.files[0].name.length >= 20) {
                    ellipsisName = getEl.files[0].name.substring(0, 20) + '...';
                }

                //파일 이름 + 용량 넣어줌.
                viewFile.innerHTML += "<div class='theisTextSize thisTextMarginLeft'>";
                viewFile.innerHTML += ellipsisName;
                viewFile.innerHTML += "(" + (getEl.files[0].size / 1024).toFixed(1) + "KB)";
                viewFile.innerHTML += "<input type='button' value='삭제' onclick='delFile();'/> </div>";
                
                fileArea.appendChild(clone);
                fileCloneArea.appendChild(getEl);
            } else {
                getEl.value = "";
                alert("파일의 용량은 10MB까지입니다.");
            }
        } else {
        getEl.value = "";
        alert("파일은 10개 이하만 추가 가능합니다.");
    }
}


//파일 삭제기능
function delFile() {
    var targetEl      	= event.target || event.srcElement,
    	viewFile 		= document.getElementById("viewFile"),
        allList       	= viewFile.getElementsByTagName("img"),
        fileCloneArea 	= document.getElementById("fileCloneArea"),
        ix            	= 0,
        ixLen         	= allList.length;

    
    for (; ix < ixLen; ix++) {

        //타겟버튼이 전체 리스트에서 몇번째인지 찾음.
        if (targetEl === allList[ix]) {

            //몇번째인지 찾은 ix로 해당 ix의 엘리먼트 삭제
            fileCloneArea.removeChild(fileCloneArea.childNodes[ix]);
            viewFile.removeChild(targetEl.parentElement);
        }
    }
}
</script>
</body>
</html>