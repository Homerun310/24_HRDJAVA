package day05;

public class PrintText implements Printable{

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Printable pt=new PrintText();
		//Printable pb=new Printabl ->X (만들 수 없다)
		pt.printMe();
	}

	@Override
	public void printMe() {
		// TODO Auto-generated method stub
		System.out.println("텍스트파일을 출력합니다");
	}

}
