package day03;

public class Memberservice {



	boolean login(String id, String pass) {
		boolean result=false;
		if((id.equals("hong"))&&(pass.equals("12345"))) {
			result=true;
		}else {
			result=false;
		}
		return result;
	}
	
	void logout(String id) {
		 
		System.out.println(id+"님이 로그아웃 되었습니다");
		
	}
}

