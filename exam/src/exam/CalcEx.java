package exam;

import java.util.Scanner;

public class CalcEx {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		System.out.print("Input Num1 : ");
		int num1 = Integer.parseInt(sc.nextLine());
		
		System.out.print("Input Num2 : ");
		int num2 = Integer.parseInt(sc.nextLine());
		
		System.out.print("Input operator : ");
		String operator1 = sc.nextLine();
		
		//super.Calculate(operator1);
		
		if(operator1.equals("+")) {
			Calc calc = new Add();
			calc.setValue(num1, num2);
			System.out.println(calc.calculate(operator1));
		}else if(operator1.equals("-")) {
			Calc calc1 = new Sub();
			calc1.setValue(num1, num2);
			System.out.println(calc1.calculate(operator1));
		}else if(operator1.equals("*")) {
			Calc calc2 = new Mul();
			calc2.setValue(num1, num2);
			System.out.println(calc2.calculate(operator1));
		}else if(operator1.equals("/")) {
			Calc calc3 = new Div();	
			calc3.setValue(num1, num2);
			System.out.println(calc3.calculate(operator1));
		}
		
		sc.close();
	}
}

