package day06;

// Product 추상 클래스를 상속받아 구현한 CellPhone 클래스
public class CellPhone extends Product{
	
	String carrier; // 통신사
	
	public CellPhone(String Pname, int price, String carrier) {
		super.Pname= Pname;
		super.price= price;
		this.carrier=carrier;
		
	}

	@Override
	public void printExtra() {
	System.out.println("통신사: "+carrier);
		
	}
	
	
}
