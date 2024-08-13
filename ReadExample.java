package day06;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

public class ReadExample {

	public static void main(String[] args) throws IOException {
		try {
			Reader reader=null;
			reader=new FileReader("Test.txt");  //부모타입 자식객체
			while(true) {
				int data=reader.read();
				if(data==-1)break;
				System.out.println((char)data);			
				
			}
			reader.close();
			System.out.println();
			
			//문자 배열로 읽기
			reader=new FileReader("Test.txt");
			char[] data=new char[100];
			while(true) {
				int num=reader.read();
				if(num==-1)break;
				for(int i=0; i<num; i++) {
				System.out.println(data[i]);
				}
								
			}
		}catch(FileNotFoundException e) {
		e.printStackTrace();
	}catch (IOException e) {
		e.printStackTrace();
	}

}
}
