package day03;

public class Car {
	//필드 선언
	String company;
	String model;
	String color;
	int maxspeed;
	
	int rpm;
	int speed;
	
	
	
	//생성자 선언
	public Car() {
		
	}
	
	//인자생성자(오버로딩)
	public Car(String company, String model, String color, int maxspeed) { 
		this.company=company;
		this.model=model;
		this.color=color;
		this.maxspeed=maxspeed;
	}
	
	public Car(String company, String model, String color) {
		this(company, model, color, 200);
	}
	
	public Car(String company, String model) {
		this(company, model, "yellow", 200);
	}
	
	
	//메소드 선언
	void Carinfo(){
		System.out.println("=========================");
		System.out.println("제조회사: "+company);
		System.out.println("모델: "+model);
		System.out.println("색깔: "+color);
		System.out.println("최고속도: "+maxspeed);
	}
}
