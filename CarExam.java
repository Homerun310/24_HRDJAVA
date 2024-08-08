package day03;

public class CarExam {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Car mycar=new Car();
		mycar.model="K5";
		mycar.color="black";
		mycar.company="KIA";
		mycar.maxspeed=200;
		
		mycar.Carinfo();
		
		Car mycar2=new Car("KIA", "K7", "black", 200);
		mycar2.Carinfo();
	}

}
