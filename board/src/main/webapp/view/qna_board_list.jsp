<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="../include/header.jsp"%>
<!-- Main content -->
<section class="content">
	<div class="box box-primary">
		<div class="box-header">
			<h3 class="box-title">List Board</h3>
		</div>
		<div class="row">
			<div class="col-md-4">
				<button type="button" class="btn btn-primary" onclick="location.href='/view/qna_board_write.jsp'">글쓰기</button>
			</div><!--글쓰기 버튼-->
			<div class="col-md-4 offset-md-4"><!--검색 들어갈 부분-->
				<form action="/qSearch.do" method="get" id="search">
					<select name="criteria" id="">
						<option value="n">------</option>
						<option value="title">title</option>
						<option value="content">content</option>
						<option value="name">name</option>
					</select>
					<input type="text" name="keyword" id="" />
					<input type="button" value="검색" class="btn btn-primary"/>
				</form>
			</div>
		</div>
		<br>
		<table class="table table-bordered">
			<tr>
				<th class='text-center' style='width:100px'>번호</th>
				<th class='text-center'>제목</th>
				<th class='text-center'>작성자</th>
				<th class='text-center'>날짜</th>
				<th class='text-center' style='width:100px'>조회수</th>
			</tr>
			<c:forEach var="dto" items="${list}">
			<tr><!-- 리스트 목록 보여주기 -->
				<td class='text-center'>${dto.bno}</td><!--번호-->
				<td><!--제목-->
					<c:if test="${dto.re_Lev != 0}">
						<c:forEach begin="0" end="${dto.re_Lev*1}">
							<!-- 공백 -->
							&nbsp;
						</c:forEach>
					</c:if>				
					<a href="/qHitUpdate.do?bno=${dto.bno}">${dto.title}</a>
				</td>
				<td class='text-center'>${dto.name}</td><!--작성자-->
				<td class='text-center'>${dto.regDate}</td><!--날짜-->
				<td class='text-center'><span class="badge badge-pill badge-primary">${dto.readCount}</span></td>
			</tr>		
			</c:forEach>
		</table>
		<div class="container">
			<div class="row  justify-content-md-center">
				<nav aria-label="Page navigation example">
				  <ul class="pagination"><!--하단의 페이지 나누기 부분-->
				  	<c:if test="${pageDto.prev }">			  	
					  	<li class="page-item"><a href="${pageDto.searchDto.page - 1}" class="page-link">이전</a></li>
					  	<li class="page-item"><a href="${pageDto.searchDto.page - 10}" class="page-link">이전(10페이지)</a></li>
				  	</c:if>
				  	<!-- 변수명은 var:idx 로 하겠다.  -->
				  	<c:forEach begin="${pageDto.startPage }" end="${pageDto.endPage }" var="idx">
				  		<!-- li class="page-item active" 하면 active준 부분이 파랗게 나옴 -->
				  		<!-- ${pageDto.searchDto.page} : 현재 페이지 번호와 현재 idx가 일치하면 active라는 클래스명 부여 같지 않으면 아무것도 부여 X -->
				  		<li class="page-item ${pageDto.searchDto.page == idx?'active':''}" >
				  			<a href="${idx}" class="page-link">${idx}</a>
				  		</li>				  	
				  	</c:forEach>
				  		
				  		
				  	<c:if test="${pageDto.next }">				  	
				  		<li class="page-item"><a href="${pageDto.searchDto.page + 10}" class="page-link">다음(10페이지)</a></li>
				  		<li class="page-item"><a href="${pageDto.searchDto.page + 1}" class="page-link">다음</a></li>
				  	</c:if>
				  </ul>
				</nav>					
			</div>
		</div>
		<div style="height:20px"></div>
	</div>	
</section>
<%-- 페이지 나누기 정보 폼 : 사용자가 요청한 페이지 번호, 한 페이지에 보여줄 게시물 개수 --%>
<form action="" id="actionForm">
	<input type="hidden" name="page" value="${pageDto.searchDto.page}" />
	<input type="hidden" name="amount" value="${pageDto.searchDto.amount}" />
</form>
<script src = "/js/list.js"></script>
<%@include file="../include/footer.jsp"%>








