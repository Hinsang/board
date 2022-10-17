boardlist()
function boardlist(){
	$.ajax({
		url: "/board/board/boardlist",
		success : function( result ) {
			let boardlist = JSON.parse(result)
			
			// tag 가져오기
			let table = document.querySelector("#boardlisttable")
			
			// table에 넣을 html 문자열
			let tag = '<tr>' +
					'<th>번호</th>' +
					'<th>제목</th>' +
					'<th>내용</th>' +
					'<th>작성자</th>' +
					'<th>작성일</th>' +
					'<th>조회수</th>' +
				'</tr>';
			
			// tag 값 넣기
			for( let i = 0 ; i < boardlist.length ; i++ ) {
				// 해당 인덱스의 객체호출
				let b = boardlist[i]
				tag += '<tr>' +
					'<td> '+b.bno+' </td>' +
					'<td onclick="view('+b.bno+')">'+b.btitle+'</td>'+
					'<td> '+b.bcontent+' </td>' +
					'<td> '+b.bid+' </td>' +
					'<td> '+b.bdate+' </td>' +
					'<td> '+b.bpoint+' </td>' +
					'<td><span>패스워드를 입력하세요</span>' +
					'<input type="password" id="bpw'+b.bno+'"+ ">' +
					'<button type="submit" onclick="bdelete('+b.bno+')">확인</button></td>' +
					'</tr>';
			}
			table.innerHTML += tag
		}
	})

}

function view(bno){
	console.log(bno+"입니다!!")
	$.ajax({
		url : "http://localhost:8080/board/board/view" ,
		data : { "bno" : bno },
		success : function( re ){
			location.href = "http://localhost:8080/board/board/view.jsp"
			viewload(re) // 다른페이지에 넘어갈때 함수실행하면서 결과값 넘겨줌
		}
	})
}

function viewload(re){
	let board  = JSON.parse( re )
	document.querySelector('.bno').innerHTML = board.bno;
	document.querySelector('.bid').innerHTML = board.bid;
	document.querySelector('.btitle').innerHTML = board.btitle;
	document.querySelector('.bcontent').innerHTML = board.bcontent;
}

//function viewload(board) {
//	location.href="../Board/view.jsp";
//	console.log( board )
//	document.querySelector('.bno2').innerHTML = board.bno;
//	document.querySelector('.bid2').innerHTML = board.bid;
//	document.querySelector('.btitle2').innerHTML = board.btitle;
//	document.querySelector('.bcontent2').innerHTML = board.bcontent;
//}