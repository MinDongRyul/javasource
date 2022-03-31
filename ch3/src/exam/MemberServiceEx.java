package exam;

public class MemberServiceEx {
	public static void main(String[] args) {
		// MemberService 객체 생성
		MemberService member = new MemberService();
		// login 메소드 호출
		 
		boolean result = member.login("hong", "12345");
		// 메소드 호출 결과를 받아 true 경우 "로그인 되었습니다." 메세지 출력
		//                             로그아웃 메소드 호출
		if (result) {
			 System.out.println("로그인 되었습니다.");
			 member.logout();
		}else {
		 // false 경우 "id 또는 password가 올바르지 않습니다." 메세지 출력
			 System.out.println("id 또는 패스워드가 올바르지 않습니다.");
		}
	}
}
