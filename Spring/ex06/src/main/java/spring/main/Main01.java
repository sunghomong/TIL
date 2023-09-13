package spring.main;

import spring.calc.ImpeCalculator;
import spring.calc.RecCalculator;

public class Main01 {

	public static void main(String[] args) {
		ImpeCalculator impe = new ImpeCalculator();
		long fiveFacImpe = impe.factorial(5);
		
		RecCalculator rec = new RecCalculator();
		long fiveFacRec = rec.factorial(5); 
		
		System.out.println("fiveFacImpe의 결과값 : "+fiveFacImpe);
		System.out.println("fiveFacRec의 결과값 : "+fiveFacRec);

	}

}
