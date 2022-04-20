package item.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import item.service.ItemUpdateService;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class ItemUpdateAction implements Action {

	String path = "";
	
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// get serivce
		int num = Integer.parseInt(request.getParameter("num"));
		int price = Integer.parseInt(request.getParameter("price"));
		String psize = request.getParameter("psize");
		
		//serivce
		ItemUpdateService service = new ItemUpdateService();
		boolean result = service.itemUpdate(num, price, psize);
		
		if(!result) {
			path = "/update.jsp";
		}
		
		return new ActionForward(path, true);
	}

}
