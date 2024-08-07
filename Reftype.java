package day02;

public class Reftype {

	public static void main(String[] args) {
		
		Reftype ref=new Reftype();
		Reftype ref2=new Reftype();
		
		if(ref==ref2) {
			System.out.println("동일한 주소를 갖는 객체이다");
		}else {
			System.out.println("서로 다른 주소를 갖는 객체이다");
		}
		
		String name=new String("염");
		System.out.println(name);
		
		String name2="자바 프로그래밍";
		System.out.println(name2.length());
		
		int sum=0;
		
		int[] score= new int[5];
		score[0]=10;
		score[1]=20;
		score[2]=30;
		score[3]=40;
		score[4]=50;
		
		for(int i=0; i<5; i++) {
			sum=sum+score[i];
		}
		System.out.println(sum);
	}

}
