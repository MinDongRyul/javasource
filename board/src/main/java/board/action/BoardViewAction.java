package board.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.dto.BoardDTO;
import board.service.BoardViewService;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class BoardViewAction implements Action {

	String path = "";// /view/qna_board_view.jsp
	
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		//bno가져오기 service
		int bno = Integer.parseInt(request.getParameter("bno"));
		
		BoardViewService service = new BoardViewService();
		//댓글작업에 있어서 dto는 원본글의 정보
		BoardDTO dto = service.read(bno);
		
		request.setAttribute("dto", dto);
		
		//페이지 이동 
		return new ActionForward(path, false);
	}
}
