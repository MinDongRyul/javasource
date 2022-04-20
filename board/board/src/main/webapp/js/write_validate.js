/**
 *  qna_board_write.jsp 폼 유효성 검증
 */
$(function(){
	$("#writeForm").validate({
		rules:{
			name:{
				required : true
			},
			title:{
				required : true
			},
			content:{
				required : true
			},
			password:{
				required : true
			},
			attach:{
				extension:"png|jpg|gif",
				maxsizetotla:2048000
			},
			
		},
		messages:{
			name:{
				required : "(이름 입력)"
			},
			title:{
				required : "(제목 입력)"
			},
			content:{
				required : "(내용 입력)"
			},
			password:{
				required : "(비밀번호 입력)"
			},
			attach:{
				extension:"(이미지 파일만 가능)",
				maxsizetotla:"(파일 사이즈 초과)"
			},
		},
		//에러 위치 정의
		errorElement : "span",
		errorPlacement : function(error, element){
			if(element.prop("type") == "file"){
				$(element).closest("form")
						  .find("small[id='"+ element.attr('id') +"']") // form아래 있는 small(attr.id와 맞는)을 찾아서 append로 에러를 넣어준다.
						  .append(error);
			}else{
				$(element).closest("form") //가장 가까운 부모 form을 찾아라.
						  .find("label[for='"+ element.attr('id') +"']")
						  .append("<br>").append(error);
			}	
		}
	})
})