/*
 * 1.초기 보여줄 페이징 넘버 (pageNo)
 * 2. 한 화면에 보여질 글 갯수 (rowCnt)
 * 3. 총 글 갯수 (totalCount)
 * 4. 페이징 한 그룹을 몇개 할지 ex: << < 1 2 3 4 5 > >> 이면 5 (groupCnt)
 * 5. 어디에 붙일지 지금은 id로 해놔서 붙이고 싶은 곳 id를 입력하면 붙음. ()
 * 6. paging.init(1,10,31,5,'targetDiv')
 */


var paging = {};

paging.init = function( pageNo , rowCnt , totalCnt, pagingSize, target) {
	
	this.initPropertys(pageNo , rowCnt , totalCnt, pagingSize, target);
	this.initLayout();
	this.setOnClass();
	
}


paging.initLayout = function() {
	
	var doc 		= document;
	var	getTarget 	= doc.getElementById(this.target);
	var	first 		= doc.createElement('a');
	var	end 		= doc.createElement('a');
	var	prev 		= doc.createElement('a');
	var	next 		= doc.createElement('a');
	var	warp 		= doc.createElement('span');
	var	numArr 		= [];
	var	tempNo 		= 0;
	var	ix 			= 0;
	var	ixLen 		= this.pagingSize;
	var	tempEl 		= null;
	var	pageCnt		= null;
	

	getTarget.innerHTML = "";
	
	if(this.total == 0){
		return ;
	}
	
	first.setAttribute( 'href'	,' javascript:paging.goPage(\'first\')'   );
	prev.setAttribute(  'href'	,' javascript:paging.goPage(\'prev\')'    );
	next.setAttribute(  'href'	,' javascript:paging.goPage(\'next\')'    );
	end.setAttribute(   'href'	,' javascript:paging.goPage(\'last\')'    );
	
	first.innerHTML = '<img src="/Images/adminImg/btn_prev2.png">';
	prev.innerHTML  = '<img src="/Images/adminImg/btn_prev1.png">';
	next.innerHTML 	= '<img src="/Images/adminImg/btn_next1.png">';
	end.innerHTML  	= '<img src="/Images/adminImg/btn_next2.png">';
	
	warp.appendChild(first)
	warp.appendChild(prev);
	
	numArr.length = this.pagingSize;
	
	for(ix = this.startPageNo ; ix < (this.endPageNo +1); ix++){
		if(this.finalPageNo >= ix){
			
			tempEl =  doc.createElement('a');
			tempEl.setAttribute('href'	,' javascript:paging.goPage('+ ix +')'    );
			tempEl.textContent = ix;

			warp.appendChild(tempEl);
		}
	}

	warp.appendChild(next);
	warp.appendChild(end);
	getTarget.appendChild(warp);
	
}

paging.initPropertys = function(pageNo , rowCnt , totalCnt, pagingSize, target) {
	

	if(pageNo == null ||  pageNo == ''){
		pageNo = 1;
	}
	if(totalCnt == 0 || totalCnt == null ||  totalCnt == ''){
		totalCnt = 1;
	}
	
	this.pageNo 		= pageNo;
	this.rowCnt 		= rowCnt;
	this.totalCnt 		= totalCnt;
	this.target 		= target;
	this.pagingSize		= pagingSize;
	this.groupSize      = Math.ceil(totalCnt / rowCnt);
	this.nowGroup		= Math.ceil(pageNo/pagingSize);
	this.startPageNo 	= (this.nowGroup * this.pagingSize) - (this.pagingSize - 1);
	this.endPageNo		= this.nowGroup * this.pagingSize;
	this.nowPageNo		= pageNo;
	this.finalPageNo	= Math.ceil(totalCnt / rowCnt);

}

paging.setOnClass = function () {
	
	var getPagingArea 	= document.getElementById(this.target),
		getOnClass 		= getPagingArea.getElementsByClassName('on'),
		getPageNoList 	= getPagingArea.getElementsByTagName('a'),
		ix 				= 0,
		ixLen 			= getPageNoList.length;
	
	if(getOnClass.length > 0){
		
		getOnClass[0].className = '';
	
	} 
	for(; ix < ixLen; ix++){
		
		if(getPageNoList[ix].textContent == this.pageNo){
			
			getPageNoList[ix].className = 'on';
			
		}
	}
	
}

paging.pageNoSetting = function(pageNo) {
	if( typeof pageNo != 'number'){
		
		if(this.nowPageNo){
			
			if(pageNo == 'next'){

				pageNo = ((this.nowPageNo * 1) + 1)
				
				if(pageNo > this.finalPageNo){
					
					alert('마지막 페이지입니다.');
					return false;
					
				}
				
			} else if(pageNo == 'prev'){
				
				pageNo = ((this.nowPageNo * 1) - 1)
				
				if(pageNo < 1){
					alert('첫번째 페이지입니다.');
					return false;
				}
				
			} else if(pageNo == 'first'){
				pageNo = 1;
				
			} else if(pageNo == 'last'){
				
				pageNo = this.finalPageNo;
				
			} else {
				alert('페이지 오류');
				return false;
			}
		}
	}
	
	this.nowPageNo = pageNo;
	
	if(this.nowPageNo > this.endPageNo || this.nowPageNo < this.startPageNo){
	
		this.nowGroup = Math.ceil(this.nowPageNo / this.pagingSize);
		this.endPageNo = this.nowGroup * this.pagingSize;
		this.startPageNo = (this.nowGroup * this.pagingSize) - (this.pagingSize - 1);
		this.initLayout();
		
	} 
	
	return true;

	
} 
paging.goPage = function(pageNo) {
	
	var isGo = false;
	isGo = this.pageNoSetting(pageNo);
	
	if(isGo){
		this.setOnClass(this.nowPageNo);
		
		goPage(this.nowPageNo);
	}
	
	

}






