package day05;
import java.awt.*; //abstract window tool

class Button{
	
	//정적중첩 인터페이스
	public static interface ClickListener{
		void onClick();
	}
	
	private ClickListener clistener;
	
	public void setClickListener(ClickListener clistener) {
		this.clistener=clistener;
	}
	
	public void onClick() {
		clistener.onClick();
	}
	
}


public class ButttonExam {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Button okbtn=new Button();
		
		//로컬클래스
		class OkListener implements Button.ClickListener{

			@Override
			public void onClick() {
				// TODO Auto-generated method stub
				System.out.println("OK 버튼은 출력했습니다");
			}
			
		}
		okbtn.setClickListener(new OkListener());
		okbtn.onClick();
	}

}
