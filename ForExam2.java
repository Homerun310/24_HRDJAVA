package day02;

public class ForExam2 {

	public static void main(String[] args) {
		//for(초기식; 조건식; 증감식){ 반복 수행문 }
		//1에서 100까지 짝수들의 총합을 계산하여 출력하시오.
		
		int a=0;
		
		int sum=0;
		
		for(a=0; a<=100; a++) {
			if(a%2==0) {
				sum=sum+a;
			}
		}
		System.out.println("0에서 100까지 짝수들의 합: "+sum);
	}
}
