package board.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.dto.BoardDTO;
import board.service.BoardDeleteService;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class BoardDeleteAction implements Action {

	String path = "";
	
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		//get service
		int bno = Integer.parseInt(request.getParameter("bno"));
		String password = request.getParameter("password");
		
		BoardDeleteService service = new BoardDeleteService();
		boolean result = service.remove(bno, password);
		
		if(!result) {
			path = "/view/qna_board_pwdCheck.jsp?bno="+bno;
		}
				
		return new ActionForward(path, true);
	}

}
