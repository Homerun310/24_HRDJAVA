package day08;
import java.util.*;
import java.io.*;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;
import java.util.Vector;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.Scanner;

public class ProductClient {

	
		Socket sc;
	    DataInputStream dis;
	    DataOutputStream dos;
	    Scanner scanner;

	    public static void main(String[] args) {
	        ProductClient productClient = new ProductClient();
	        try {
	            productClient.start();
	        } catch (IOException ignored) {
	        }
	    }

	    public void start() throws IOException {
	        scanner = new Scanner(System.in);
	        sc = new Socket("localhost", 50001);
	        dis = new DataInputStream(sc.getInputStream());
	        dos = new DataOutputStream(sc.getOutputStream());

	        System.out.println("[클라이언트] 서버에 연결됨");
	        getProductList();
	    }

	    public void exit() {
	        try {
	            sc.close();
	            scanner.close();
	        } catch (Exception ignored) {
	        }
	        System.out.println("[클라이언트] 종료됨");
	    }

	    public void getResponse() throws IOException {
	        JSONObject jsonResponse = new JSONObject(dis.readUTF());
	        if (jsonResponse.getString("status").equals("success")) {
	            getProductList();
	        }
	    }

	    public void getMenuNumber() throws IOException {
	        System.out.println();
	        System.out.println("----------------------------------------------------------");
	        System.out.println("메뉴: 1.Create | 2.Update | 3.Delete | 4.Exit");
	        System.out.print("선택: ");

	        int menuNo = Integer.parseInt(scanner.nextLine());
	        System.out.println();

	        switch (menuNo) {
	            case 1 -> createProduct();
	            case 2 -> updateProduct();
	            case 3 -> deleteProduct();
	            default -> exit();
	        }
	    }
	    public void getProductList() throws IOException {
	        final int MENU_NUM = 1;
	        JSONObject jsonRequest = new JSONObject();

	        System.out.println();
	        System.out.println("[상품 목록]");
	        System.out.println("----------------------------------------------------------");
	        System.out.println("no\t\tname\t\t\t\t\tprice\t\t\tstock");
	        System.out.println("----------------------------------------------------------");

	        jsonRequest.put("menu", MENU_NUM);
	        jsonRequest.put("data", new JSONObject());

	        dos.writeUTF(jsonRequest.toString());
	        dos.flush();

	        JSONObject jsonResponse = new JSONObject(dis.readUTF());

	        if (jsonResponse.getString("status").equals("success")) {
	            JSONArray jsonArray = jsonResponse.getJSONArray("data");

	            for (int i = 0; i < jsonArray.length(); i++) {
	                JSONObject product = jsonArray.getJSONObject(i);
	                System.out.printf("%d\t\t%s\t\t\t\t\t\t%d\t\t\t\t%d\n",
	                        product.getInt("no"),
	                        product.getString("name"),
	                        product.getInt("price"),
	                        product.getInt("stock")
	                );
	            }
	        }
	        getMenuNumber();
	    }

	    public void createProduct() throws IOException {
	        final int MENU_NUM = 1;
	        Product product = new Product();
	        JSONObject jsonProduct = new JSONObject();
	        JSONObject jsonRequest = new JSONObject();

	        System.out.println("[상품 생성]");

	        System.out.print("상품 이름: ");
	        product.setName(scanner.nextLine());

	        System.out.print("상품 가격: ");
	        product.setPrice(Integer.parseInt(scanner.nextLine()));

	        System.out.print("상품 재고: ");
	        product.setStock(Integer.parseInt(scanner.nextLine()));

	        jsonProduct.put("name", product.getName());
	        jsonProduct.put("price", product.getPrice());
	        jsonProduct.put("stock", product.getStock());

	        jsonRequest.put("menu", MENU_NUM);
	        jsonRequest.put("data", jsonProduct);

	        dos.writeUTF(jsonRequest.toString());
	        dos.flush();
	        getResponse();
	    }

	    public void updateProduct() throws IOException {
	        final int MENU_NUM = 2;
	        Product product = new Product();
	        JSONObject jsonProduct = new JSONObject();
	        JSONObject jsonRequest = new JSONObject();

	        System.out.println("[상품 수정]");

	        System.out.print("상품 번호: ");
	        product.setNo(Integer.parseInt(scanner.nextLine()));

	        System.out.print("이름 변경: ");
	        product.setName(scanner.nextLine());

	        System.out.print("가격 변경: ");
	        product.setPrice(Integer.parseInt(scanner.nextLine()));

	        System.out.print("재고 변경: ");
	        product.setStock(Integer.parseInt(scanner.nextLine()));

	        jsonProduct.put("no", product.getNo());
	        jsonProduct.put("name", product.getName());
	        jsonProduct.put("price", product.getPrice());
	        jsonProduct.put("stock", product.getStock());

	        jsonRequest.put("menu", MENU_NUM);
	        jsonRequest.put("data", jsonProduct);

	        dos.writeUTF(jsonRequest.toString());
	        dos.flush();
	        getResponse();
	    }


	    public void deleteProduct() throws IOException {
	        final int MENU_NUM = 3;
	        JSONObject jsonProduct = new JSONObject();
	        JSONObject jsonRequest = new JSONObject();

	        System.out.println("[상품 삭제]");

	        System.out.print("상품 번호: ");
	        int no = Integer.parseInt(scanner.nextLine());

	        jsonProduct.put("no", no);

	        jsonRequest.put("menu", MENU_NUM);
	        jsonRequest.put("data", jsonProduct);

	        dos.writeUTF(jsonRequest.toString());
	        dos.flush();
	        getResponse();
	    }
	}

	


