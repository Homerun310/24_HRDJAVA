package day05;

//abstract class Animal{
//	//추상클래스 ..적어도한개 이상의 추상 메소드를 갖는 클래스
//	//추상메소드.. 바디가 없는 메소드
//	
//	abstract void sound();
//}


//class Dog extends Animal{
//
//	@Override
//	void sound() {
//		System.out.println("멍멍");
//		// TODO Auto-generated method stub
//		
//	}
//	
//}
//
//class Cat extends Animal{
//
//	@Override
//	void sound() {
//		// TODO Auto-generated method stub
//		System.out.println("야옹");
//	}
//	
//}

	


	class Dog implements Soundable{

		@Override
		public String sound() {
			// TODO Auto-generated method stub
			return "멍";
		}
		
	}
	class Cat implements Soundable{

		@Override
		public String sound() {
			// TODO Auto-generated method stub
			
			return "야옹";
		}
			
		}
	interface Soundable {
		public String sound();
		
		
	}
	
	public class AnimalTest {
	public static void printSound(Soundable soundable) {
			soundable.sound();
		}

	public static void main(String[] args) {
//		Animal animal=new Dog();
//		animal.sound();
		AnimalTest.printSound(new Cat());
		
		
	}

}

