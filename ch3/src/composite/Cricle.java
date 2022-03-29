package composite;

// 포함관계 : 한 클래스의 멤버 변수로 다른 클래스 타입의 참조 변수 선언
// 원은 점이다 : is - a
// 원은 점을 가지고 있다. : has - a
// 

public class Cricle {
//	int x;
//	int y;
	
//	Point p = new Point();
	// x, y 를 가져옴
	
	Point p;
	int r;
	
	public Cricle(Point p, int r) {
		super();
		this.p = p;
		this.r = r;
	}
}
