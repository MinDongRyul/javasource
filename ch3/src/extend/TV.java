package extend;

//Captiontv = caption + tv

public class TV {

	String color;
	boolean power;
	int channel;
	

	//기능 : 전원 온/오프, 채널 변경
	void power() {
		power = !power;
	}
	void channelUp() {
		channel++;
	}
	void channelDown() {
		channel--;
	}
}
