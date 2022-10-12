boardlist()
function boardlist(){
	$.ajax({
		url: "/board/Board/boardlist",
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
					'<td> '+b.btitle+' </td>' +
					'<td> '+b.bcontent+' </td>' +
					'<td> '+b.bid+' </td>' +
					'<td> '+b.bdate+' </td>' +
					'<td> '+b.bpoint+' </td>' +
					'<td><span>패스워드를 입력하세요</span>' +
					'<input type="password" id="bpw'+b.bno+'"+ ">' +
					'<button type="submit" onclick="bdelete('+b.bno+')">확인</button></td>' +
					'</tr>';
			}
			table.innerHTML = tag
		}
	})

}

//function bviewdelete() {
//	let deletebox = document.querySelectorAll("#deletebox")
//	// tag에 넣을 html 구성
//	console.log(deletebox.length)
//	let tag = '<span>패스워드를 입력하세요</span>' +
//			'<input type="password" id="bpw">' +
//			'<button id="deletebox"+b.bno onclick="bdelete()">확인</button>';
//}

function bdelete( bno ) {
	// tag 입력된 비밀번호를 가져온다.
	let bpw = document.querySelector("#bpw"+bno).value
	alert( bpw )
//	let bid = document.querySelector("#bid").value
	// ajax를 이용한 회원탈퇴 처리
	
	$.ajax({
		url : "/board/Board/delete",
		data: { "bno" : bno, "bpw" : bpw },
		success: function( result ) {
			alert(result)
			if(result == 'true') {
				alert('삭제 성공')
				location.href = '/board/Board/Board.jsp'
			} else {
				alert('삭제 실패')
			}
		}
	})
}
