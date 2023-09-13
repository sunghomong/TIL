package spring.printer;

public class VersionPrinter {
	
	private int majorVersion;
	private int minorVersion;
	
	// 빈 객체를 주입 받는 것과 달리 기본타입(정수:int)을 주입받아서 사용
	// 생성자를 통한 주입
	public VersionPrinter(int majorVersion, int minorVersion) {
		this.majorVersion = majorVersion;
		this.minorVersion = minorVersion;
	}
	
	
	public VersionPrinter() {}
	// Setter 메서드를 통한 주입  => 빈 생성자 필요
	public void setMajorVersion(int majorVersion) {
		this.majorVersion = majorVersion;
	}

	public void setMinorVersion(int minorVersion) {
		this.minorVersion = minorVersion;
	}





	public void print() {
		System.out.printf(
				"이 프로그램의 버전은 %d.%d 입니다. \n\n"
				,majorVersion, minorVersion);
	}
}
