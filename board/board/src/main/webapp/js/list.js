/**
 * qna_board_list.jsp 스크립트
 * 스크립트에서는 $()으로 부르고 싶은걸 부른다는걸 기억.
 */
$(function(){
	//text에 엔터 금지 (13 : 엔터 keyCode)
	$(":text").keydown(function(e){
		if(e.keyCode == 13){
			e.preventDefault();
		}
	})
	
	$(".btn-primary").click(function(){
		//criteria의 value가 n이면 경고메세지
		if($('[name="criteria"]').val() == "n"){
			alert("검색 조건이 없습니다.");
			return false;
		}
		//keyword도 비어있으면 경고메세지
		if($('[name="keyword"]').val() == ""){
			alert("검색어가 없습니다.");
			return false;
		}
		//form sumbit
		$("#search").submit();
	})

	//페이지 나누기 이동
	
	//페이지 나구기 정보를 가지고 있는 폼 가져오기
	let actionForm = $("#actionForm");
	
	//1234 or 이전, 다음이 클릭되면 actionForm 보내기
	//e:event 
	$(".page-link").click(function(e){
		//원래의 기능 중지
		e.preventDefault();
		
		//a태그의 href속성이 가지고 있는 값 가져오기, jsp에서는 a href = "${idx}"
		let page = $(this).attr("href");
		
		//actionForm 안의 page 번호를 교체	
		//actionForm에서 name이 page인 것의 val값을 href속성이가지고 있는 page값으로 바꿔준다.
		actionForm.find("[name='page']").val(page);
		
		//actionForm 보내기, default가 get방식이어서 주소창에 따라 들어간다.
		actionForm.submit();
	})
})

