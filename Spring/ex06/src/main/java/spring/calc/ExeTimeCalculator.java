package spring.calc;

public class ExeTimeCalculator implements Calculator {
	
	private Calculator calc; // 실제 계산 하기 위한 클래스(Impe,Rec)
	
	public ExeTimeCalculator(Calculator calc) {
		this.calc = calc;
	}

	@Override
	public long factorial(long num) {
		//long start = System.currentTimeMillis();
		long start = System.nanoTime();
		
		long result = calc.factorial(num);  //핵심 기능
		
//		long end = System.currentTimeMillis();
		long end = System.nanoTime();
		
		System.out.printf("%s.factorial(%d)의 실행 시간 : %d\n"
						,calc.getClass().getSimpleName(),num,(end-start)); // 공통(부가)기능

		return result;
	}
	
}
