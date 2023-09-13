package spring.main;

import spring.calc.ExeTimeCalculator;
import spring.calc.ImpeCalculator;
import spring.calc.RecCalculator;

public class Main02 {

	public static void main(String[] args) {
		// 프록시 객체를 통해서 두가지 방법의 팩토리얼 구하기
		ExeTimeCalculator impeCalc = new ExeTimeCalculator(new ImpeCalculator());
		long fiveFacImpe = impeCalc.factorial(5);
		
		ExeTimeCalculator recCalc = new ExeTimeCalculator(new RecCalculator());
		long fiveFacRec = recCalc.factorial(5);
		
		System.out.println("fiveFacImpe의 결과값 : "+fiveFacImpe);
		System.out.println("fiveFacRec의 결과값 : "+fiveFacRec);
	}

}
