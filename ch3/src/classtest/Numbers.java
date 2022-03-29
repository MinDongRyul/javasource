package classtest;

public class Numbers {
	int num[];

	public Numbers(int[] num) {
		super();
		this.num = num;
	}
	
	// 합계
	// 리턴은 int 
	int sum() {
		int sum = 0;
		for (int i = 0; i < num.length; i++) {
			sum += num[i];
		}
		return sum;
	}
	
	// 평균
	// 리턴은 double
	double avg() {
		return sum() / num.length;
	}
}
