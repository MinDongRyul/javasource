package exam;

public class Won2Dollar extends Converter {

	@Override
	protected double convert(double src) {
		double res = src / 1200;
		return res;
	}

	@Override
	protected String getSrcString() {
		return "원";
	}

	@Override
	protected String getDestString() {
		return "달러";
	}

}
