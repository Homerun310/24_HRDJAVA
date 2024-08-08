package day03;
import java.util.Scanner;
public class ArrayExam {

	public static void main(String[] args) {
		
		int[] scores=null;
		
		
		Scanner sc=new Scanner(System.in);
		int sum=0;
		double avg=0.0;
	
		int student=0;
		
		
		while(true)	{
			System.out.println("---------------------------------------------------------------");
			System.out.println("1.학생수 | 2.점수입력 | 3.점수리스트 | 4.분석 | 5.종료");
			System.out.println("---------------------------------------------------------------");
			
			System.out.print("선택> ");
			int choose= Integer.parseInt(sc.nextLine());
		
		if(choose==1) {
			System.out.print("학생수: ");
			student=Integer.parseInt(sc.nextLine());
			scores=new int[student];
		}
		else if(choose==2) {
			
			
			for(int i=0; i<student; i++) {
				System.out.print("scores["+i+"]>");
				scores[i]=Integer.parseInt(sc.nextLine());
			}
		}
			
			
		else if(choose==3) {
			
			
			for(int i=0; i<scores.length; i++) {
				System.out.println("scores["+i+"]: "+scores[i]);
			}
			
		}	
			
		else if(choose==4) {
			
			for(int i=0; i<scores.length; i++) {
				
				sum= sum+scores[i];
				
			}
			avg=sum/scores.length;
			
			int max = 0;
			for (int i = 0; i < scores.length; i++) {
				if (scores[i] > max) {
					max = scores[i];
				}
			}
			
			System.out.println("최고점수: "+max);
			System.out.println("평균점수: "+avg);
		
			
		}
		else if(choose==5) {
			System.out.println("프로그램 종료");
			break;
		}
		}
	}
}
		
	
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	


