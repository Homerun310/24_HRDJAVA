package day02;
import java.util.Random;
import java.util.Scanner;
public class Game369 {

	public static void main(String[] args) {
		/** continue문
		 * 1부터 10까지의 정수 출력 중 3,6,9 일때 소리를 출력하는 프로그램 작성하기
		 * 
		 */
	 int a=1;
	 
	 while(a<=10) {
		 
		
		 if((a==3)||(a==6)||(a==9) ) {
			 System.out.print("짝 ");
			 a++;
			 continue;
		 }
		 
		 System.out.print(a+" ");
		 a++;
	 }
			
		
		
		
		
			
		}
	}


