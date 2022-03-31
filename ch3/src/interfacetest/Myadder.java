package interfacetest;

// 인터페이스를 구현(implements)

public class Myadder implements Adder {
	@Override
	public void print() {
		System.out.println("출력");

	}

	@Override
	public int add(int x, int y) {
		return x + y;
	}
}
