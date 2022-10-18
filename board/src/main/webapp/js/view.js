viewload()
function viewload(){ // 세션을 저장하고 페이지가 리로드 되자마자 실행되는 함수, 리스트 정보를 보여줌 
	$.ajax({
		url : "http://localhost:8080/board/board/viewload" ,
		success : function( re ){
			// viewload(re) // 다른페이지에 넘어갈때 함수실행하면서 결과값 넘겨줌
			let board  = JSON.parse( re )
			document.querySelector('.bno').innerHTML = board.bno;
			document.querySelector('.bid').innerHTML = board.bid;
			document.querySelector('.btitle').innerHTML = board.btitle;
			document.querySelector('.bcontent').innerHTML = board.bcontent;
		}
	})
}
