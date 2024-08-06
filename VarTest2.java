package day01;

public class VarTest2 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	int x=1, j=20;
	
	char c='g';
	
	String n="문자";
	
	System.out.println(x+n);
	
	//강제 형 변환
	double k=3.141592;
	j=j+(int)k;
	
	System.out.println("J:"+j+"\n"+"K:"+k);
	
	String result4="10"+ 2+ 8;
	System.out.println("result4: "+result4);
	
	int result2= 10+2+Integer.parseInt("8");
	System.out.println("result2: "+result2);
	
	}

}
