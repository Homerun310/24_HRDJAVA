package day02;
import java.util.Scanner;
public class DoWhileExam {

	public static void main(String[] args) {
		//1에서 10까지 홀수는 무시하고 짝수만 출력
		Scanner scan=new Scanner(System.in);
		String inputstring;
		System.out.println("메세지를 입력하세요");
		System.out.println("프로그램을 종료하려면 q를 입력하세요");
	
		do {
			
			System.out.println(">");
			inputstring =scan.nextLine();
			System.out.println(inputstring);
			
		}while(inputstring.equals("q"));
			
		}
}