package day03;

public class CalcTest {

	public static void main(String[] args) {
		Calculator cm=new Calculator();
		
	cm.x=10;
	cm.y=10;
	
	System.out.println(cm.add(10, 5));
	cm.minus(10, 5);
	System.out.println(cm.multi());
	System.out.println(cm.devide());
	
	System.out.println("길이가 10cm인 정사각형의 넓이= "+cm.areaRect(10));
	System.out.println("가로가 10, 세로가 9인 직사각형의 넓이= "+cm.areaRect(10, 9));
	
	
	double result=10*10*Calculator.pi;
	
	
	
	
	
	
	
	
	}
		

		

}
