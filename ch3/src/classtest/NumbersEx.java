package classtest;

public class NumbersEx {

	public static void main(String[] args) {
//		int arr[] = {10, 20, 30, 40};
//		Numbers num = new Numbers(arr);
		
		Numbers num = new Numbers(new int[] {10, 20, 30, 40});
		
		System.out.println("합계 : "+num.sum());
		System.out.println("평균 : "+num.avg());
	}
}
