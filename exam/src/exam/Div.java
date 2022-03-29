package exam;

public class Div extends Calc {
	@Override
	public void setValue(int a, int b) {
		this.a = a;
		this.b = b;
	}
	
	public int calculate(String operator1) {
		return  a / b;
	}

}
