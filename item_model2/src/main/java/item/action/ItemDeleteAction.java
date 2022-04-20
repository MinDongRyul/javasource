package item.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import item.service.ItemDeleteService;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class ItemDeleteAction implements Action {

	String path = "";
	
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		//get service path돌려주기
		int num = Integer.parseInt(request.getParameter("num"));
		
		ItemDeleteService service = new ItemDeleteService();
		
		boolean result = service.deleteItem(num);
		
		if(!result) {
			path = "/delete.jsp";
		}
		
		return new ActionForward(path, true);
	}

}
