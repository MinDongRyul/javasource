package board.action;

import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.dto.BoardDTO;
import board.service.BoardInsertService;
import board.util.UploadUtil;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class BoardInsertAction implements Action {

	String path = "";
	
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		UploadUtil util = new UploadUtil();
		HashMap<String, String> dataMap = util.uploadFile(request);
		
		//get(dataMap에서 값 가져오기) service
		BoardDTO dto= new BoardDTO();
		/* form에서 enctype으로 바꿈으로 request로 불가 */
		dto.setName(dataMap.get("name"));
		dto.setTitle(dataMap.get("title"));
		dto.setContent(dataMap.get("content"));
		dto.setPassword(dataMap.get("password"));
		dto.setAttach(dataMap.get("attach"));
		
		//결과에 페이지 이동 => 성공 qList.do, 실패 qna_board_write.jsp
		
		BoardInsertService service = new BoardInsertService();
		boolean result = service.insert(dto);
		
		if(!result) {
			path = "/view/qna_board_write.jsp";
		}
		
		return new ActionForward(path, true);
	}

}
