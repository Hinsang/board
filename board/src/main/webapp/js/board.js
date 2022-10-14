
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
