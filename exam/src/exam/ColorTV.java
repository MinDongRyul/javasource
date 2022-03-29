package exam;

public class ColorTV extends TV {
 
	private int inch;
		
	public ColorTV(int size, int inch) {
		super(size);
		this.inch = inch;
		// TODO Auto-generated constructor stub
	}
	
	public void printProperty() {
		System.out.println(super.getSize()+"인치 "+inch+"컬러");
	}

	public int getInch() {
		return inch;
	}

	public void setInch(int inch) {
		this.inch = inch;
	}
}
