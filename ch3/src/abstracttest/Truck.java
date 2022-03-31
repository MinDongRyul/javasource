package abstracttest;

public class Truck extends Car {

	@Override // drive()를 무조건 사용하여라
	public void drive() {
		System.out.println("트럭을 운전합니다.");
	}
	@Override // stop() 무조건 사용
	public void stop() {
		System.out.println("트럭을 멈춥니다.");
	}
	
}
