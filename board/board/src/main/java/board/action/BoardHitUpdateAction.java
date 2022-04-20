package board.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import board.service.BoardHitUpdateService;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class BoardHitUpdateAction implements Action {

	String path = ""; // /qView.do
	
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		//bno가져오기 service
		int bno = Integer.parseInt(request.getParameter("bno"));
		
		//service 작업 => 조회수 업데이트
		BoardHitUpdateService update = new BoardHitUpdateService();
		update.readUpdate(bno);
		
		path += "?bno="+bno; // /qView?bno=3
		
		//페이지 이동 
		return new ActionForward(path, true);
	}
}
