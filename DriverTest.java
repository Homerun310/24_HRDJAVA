package day05;

public class DriverTest {

	
	
	public class Bus implements Vehicle{

		@Override
		public void run() {
			System.out.println("버스가 달립니다");
			
		}
		
	}
	public class Taxi implements Vehicle{

		@Override
		public void run() {
			System.out.println("택시가 달립니다");
			
		} 
		
	}
	
	
		void drive(Vehicle vehicle) {
			vehicle.run();
		}
	
	
	public static void main(String[] args) {
		DriverTest driver=new DriverTest();
		
	
		
		
	
	
	}

}

