package member.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import lombok.AllArgsConstructor;
import member.dto.MemberDTO;
import member.service.MemberLeaveService;

@AllArgsConstructor
public class MemberLeaveAction implements Action {

	private String path;

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String userid = request.getParameter("userid");
		String password = request.getParameter("current_password");
		
		//service
		MemberLeaveService service = new MemberLeaveService();
		boolean result = service.remove(userid, password);
		
		if(!result) {
			path = "/view/leaveForm.jsp";
		}else {
			HttpSession session = request.getSession();
			session.invalidate();
		}
		
		return new ActionForward(path, true);
	}

}
