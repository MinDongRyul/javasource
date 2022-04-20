package board.action;

import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.dto.BoardDTO;
import board.service.BoardUpdateService;
import board.util.UploadUtil;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class BoardUpdateAction implements Action {

	private String path;
	
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		UploadUtil util = new UploadUtil();
		//hashmap을 이용하여 request분해하여 확인
		HashMap<String, String> dataMap = util.uploadFile(request);
		
		//get(dataMap에서 값 가져오기) service
		BoardDTO updatedto = new BoardDTO();
		/* form에서 enctype으로 바꿈으로 request(getparameter)로 불가 */
		updatedto.setBno(Integer.parseInt(dataMap.get("bno")));
		updatedto.setName(dataMap.get("name"));
		updatedto.setTitle(dataMap.get("title"));
		updatedto.setContent(dataMap.get("content"));
		updatedto.setPassword(dataMap.get("password"));
		updatedto.setAttach(dataMap.get("attach")); // 파일첨부를 했다면 값이 들어와 있고, 안했다면 null
		
		BoardUpdateService service = new BoardUpdateService();
		
		//결과에 페이지 이동 => 성공 qView.do, 실패 qModify.do
		if(!service.update(updatedto)) {
			path = "/qModify.do?bno="+updatedto.getBno();
		}else {
			path += "?bno="+updatedto.getBno(); // /qView.do?bno=3
		}
		
		return new ActionForward(path, true);
	}

}
