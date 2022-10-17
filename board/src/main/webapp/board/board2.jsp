<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h3> 게시판 등록 </h3>
	<form action="/board/board/board2" method="post">
		제목 : 		<input type="text" 		name="btitle">				<br>
		내용 : 		<input type="text" 		name="bcontent">			<br>
		작성자 : 		<input type="text" 		name="bid">					<br>
		비밀번호 : 	<input type="password" 	name="bpw">					<br>
		<input type="submit" value="게시글 등록">
	</form>

	<div class="webbox">
		<h3>게시글 목록</h3>
		<table id="boardlisttable">
			<tr>
				<th>번호</th>
				<th>제목</th>
				<th>내용</th>
				<th>작성자</th>
				<th>작성일</th>
				<th>조회수</th>
			</tr>
		</table>
	</div>
	
<!-- 	<table> -->
<!-- 		<tr> <td> 번호 <td> 	<td class="bno2"> 		</td> </tr> -->
<!-- 		<tr> <td> 작성자 <td> <td class="bid2"> 		</td> </tr> -->
<!-- 		<tr> <td> 제목 <td> 	<td class="btitle2">  	</td> </tr> -->
<!-- 		<tr> <td> 내용 <td> 	<td class="bcontent2"> 	</td> </tr> -->
<!-- 	</table> -->

	<script src="http://code.jquery.com/jquery-latest.min.js"></script>
	<script type="text/javascript" src="../js/board.js"></script>
	<script type="text/javascript" src="../js/list.js"></script>

</body>
</html>
