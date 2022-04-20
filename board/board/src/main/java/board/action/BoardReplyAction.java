package board.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.dto.BoardDTO;
import board.service.BoardReplyService;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class BoardReplyAction implements Action {

	private String path; // /qList.do
	
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// qna_board_reply.jsp 에서 넘기는 값 가져오기(댓글의 내용 + 원본글의 re~~~)
		
		// 댓글들의 정보
		BoardDTO replyDto = new BoardDTO();
		replyDto.setName(request.getParameter("name"));
		replyDto.setTitle(request.getParameter("title"));
		replyDto.setContent(request.getParameter("content"));
		replyDto.setPassword(request.getParameter("password"));
		
		// 원본글에 대한 re~~~정보
		int bno = Integer.parseInt(request.getParameter("bno"));
		replyDto.setRe_Lev(Integer.parseInt(request.getParameter("re_lev")));
		replyDto.setRe_Seq(Integer.parseInt(request.getParameter("re_seq")));
		replyDto.setRe_Ref(Integer.parseInt(request.getParameter("re_ref")));
		
		//service
		BoardReplyService service = new BoardReplyService();
		
		boolean result = service.reply(replyDto);
		
		if(!result) {
			//원본글의 bno
			path = "/qReplyView.do?bno="+bno;
		}

		return new ActionForward(path, true);
	}

}
