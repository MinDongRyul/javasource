package item.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import item.dto.ItemDTO;
import item.service.ItemListService;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class ItemListAction implements Action {

	private String path;
	
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// 받아올것
		// Service
		ItemListService service = new ItemListService();
		
		// return 값으로 변수 설정해주는게 좋다.
		List<ItemDTO> list = service.listAll();
		
		// list는 request에 담아준다.
		request.setAttribute("list", list);
		
		// request라서 forward이기에 false
		return new ActionForward(path, false);
	}

}
