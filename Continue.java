package day02;

public class Continue {

	public static void main(String[] args) {
		//1에서 10까지 홀수는 무시하고 짝수만 출력
		int i=1;
		
		while(i<=10) {
			i++;
			if(i%2 != 0) {
				continue; //무시
			}
			
			System.out.print(i+" ");
			
		}
		
	}
}