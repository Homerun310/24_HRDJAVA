package day02;
import java.util.Scanner;
public class WhileExam {

	public static void main(String[] args) {
		
		/**
		 * 1. 중속 2. 감속 3. 중지
		 */
		
		
		Scanner scan=new Scanner(System.in);
		
		boolean run =true;
		int speed=0;
		
		while(run) {
			System.out.println("------------------------");
			System.out.println("1. 중속 2. 감속 3. 중지");
			System.out.println("------------------------");
			System.out.print("선택: ");
		
			String num= scan.nextLine();
			if(num.equals("1")) {
				speed++;
				System.out.println("현재 속도="+speed);
			}else if(num.equals("2")) {
				speed--;
				System.out.println("현재 속도="+speed);
			}else if(num.equals("3")) {
				run=false;
			}
	}
	
	
	
}
}