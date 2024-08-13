package day06;

//Product 추상 클래스를 상속받아 구현한 SmartTv 클래스
public class SmartTv extends Product{
String resolution;  // 해상도
	
	public SmartTv(String Pname, int price, String resolution) {
		super.Pname= Pname;
		super.price= price;
		this.resolution=resolution;
		
	}

	

	@Override
	public void printExtra() {
		System.out.println("해상도: "+resolution);
		
	}
}
