package classtest;

public class TVEx {

	public static void main(String[] args) {
		//객체 생성
		TV tv = new TV();
		// 초기화
		tv.color = "black";
		tv.channel = 3;
		tv.power = false;
		
		tv.power(); // 전원켜기
		System.out.println("현재 전원 상태 "+tv.power);
		System.out.println("현재 채널 "+tv.channel);
		tv.channelUp(); // 채널 번호 증가
		System.out.println("현재 채널 "+tv.channel);
		
	}
}
