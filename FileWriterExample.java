package day06;
import java.io.*;
public class FileWriterExample {
	static FileWriter fw=null;	
	static BufferedInputStream dis=null;
	static BufferedInputStream dos=null;
	//OutputStreamWriter osw=null;
	
	public static void main(String[] args) {
		try{
			
			// 1. 키보드로 부터 문자데이터를 읽어와서 콘솔로 출력하고 파일로도 출력하기
			InputStream is=System.in;
			dos=new BufferedInputStream(is);
			BufferedInputStream bos = new BufferedInputStream(System.in);
			
//		fw = new FileWriter("file.txt");
//			fw.write("java");
		}finally {
			try {
			fw.close();
			}catch (IOException e) {
				e.printStackTrace();
			}
	}

}
}
