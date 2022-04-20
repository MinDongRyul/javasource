package member.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import lombok.AllArgsConstructor;
import member.dto.MemberDTO;
import member.service.MemberJoinService;

@AllArgsConstructor
public class MemberJoinAction implements Action {

	private String path;
	
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		// getparameter
		MemberDTO dto = new MemberDTO();
		dto.setUserid(request.getParameter("userid"));
		dto.setPassword(request.getParameter("password"));
		dto.setName(request.getParameter("name"));
		dto.setGender(request.getParameter("gender"));
		dto.setEmail(request.getParameter("email"));
		
		String confirm_password = request.getParameter("confirm_pasword");
		
		// service 성공-loginform.jsp, 실패-joinform.jsp
		MemberJoinService service = new MemberJoinService();
		boolean result = service.join(dto);
		
		if(!result){
			path = "/view/joinForm.jsp";
		}
		
		return new ActionForward(path, true);
	}
}
