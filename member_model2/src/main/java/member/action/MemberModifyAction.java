package member.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import lombok.AllArgsConstructor;
import member.dto.MemberDTO;
import member.service.MemberLoginService;
import member.service.MemberModifyService;

@AllArgsConstructor
public class MemberModifyAction implements Action {

	private String path;
	
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		//getparameter
		String current_password = request.getParameter("current_password");
		String new_password = request.getParameter("new_password");
		String confirm_password = request.getParameter("confirm_password");
		
		
		HttpSession session = request.getSession();
		MemberDTO dto = (MemberDTO)session.getAttribute("loginDto");
		//MemberDTO dto = new MemberDTO(); 
		String userid = dto.getUserid();
		
		MemberLoginService loginService = new MemberLoginService();
				
		if(loginService.login(userid, current_password)!=null) { //현재 비밀번호 일치하면
			
			MemberModifyService service = new MemberModifyService();
			
			if(new_password.equals(confirm_password)) { // 새 비밀번호와 확인 비밀번호가 일치하면
				boolean result = service.modify(new_password, userid); // 변경실패
				if(!result) {
					path = "/view/modifyForm.jsp";
				}else { // 변경성공
					session.invalidate();
				}
			}
		}else { // 현재 비밀번호가 일치하지 않을 때
			path = "/view/modifyForm.jsp";
		}
		
		return new ActionForward(path, true);
	}

}
