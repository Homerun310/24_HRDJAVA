package day02;
import java.util.Scanner;
public class IfExam {

	public static void main(String[] args) {
		
		Scanner sc=new Scanner(System.in);
		
		System.out.print("정수를 입력하세요: ");
		
		int jungsu=sc.nextInt();
		
		String hakjum="";
		
		if(jungsu>=90) {
			hakjum="A";
			
		}else if(jungsu<90 && jungsu>=60){
			hakjum="B";
		}
		else if(jungsu<60 && jungsu>=30){
			hakjum="C";
		}
		else {
			hakjum="F";
		}
		
		System.out.println("당신의 점수는: "+hakjum);
	}

}
