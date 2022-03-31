package exam;

public class IPTV extends ColorTV {
	
	String ip;
	
	public IPTV(int size, int inch, String ip) {
		super(size, inch);
		this.ip = ip;
	}
	
	public void printProperty() {
		System.out.println("나의 IPTV는 "+ip+" 주소의 "+super.getSize()+"인치 "+super.getInch()+"컬러");
	}

}
