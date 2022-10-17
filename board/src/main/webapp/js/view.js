bview()

function bview(){
	$.ajax({
		url : "http://localhost:8080/board/board/view" , 
		success : function( re ){ 
			let board  = JSON.parse( re )
			console.log( board )
			document.querySelector('.bno').innerHTML = board.bno;
			document.querySelector('.bid').innerHTML = board.bid;
			document.querySelector('.btitle').innerHTML = board.btitle;
			document.querySelector('.bcontent').innerHTML = board.bcontent;
			
		}
	})
}
