package day02;
import java.util.Random;
import java.util.Scanner;
public class Game {

	public static void main(String[] args) {
		/**
		 * 가위바위보 게임 만들기
		 * 1~3까지 난수 생성 1-가위 2-바위 3-보
		 * 컴퓨터와 유저간 게임을 하여 승 패를 출력하기
		 * 변수, 자료형, 조건문, 반복문, scanner, random클래스 사용하기
		 */
		Scanner sc=new Scanner(System.in);
		Random random=new Random();
		boolean run=true;
		String com="";
		
		System.out.println("gamestart");
		System.out.println("1.가위 2.바위 3.보");
		System.out.println("#######################");
		
		while(run) {
			
			int num=random.nextInt(3)+1;
			if(num==1) {
				com="가위";
			}else if(num==2) {
				com="바위";
			}else if(num==3) {
				com="보";
			}
			
			System.out.println("공격합니다: "+com);
			System.out.print("입력하세요>>> ");
			int my=sc.nextInt();
			
			
			if((num==my)) {
				System.out.println("draw");
			}else if((num==1)&&(my==3) || (num==2)&&(my==1) || (num==3)&&(my==2) ) {
				System.out.println("lose");
			}else if(my>=4){
				System.out.println("다른숫자를 입력하세요");
			}
			else if((my>0)&&(my<4)) {
				System.out.println("win");
			}
			
			if(my==0) {
				System.out.println("종료");
				break;
			}
			
			
		}
	}

}
