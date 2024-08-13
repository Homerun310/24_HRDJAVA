package day06;

public class ShopLauncher {

	public static void main(String[] args) {
		IShop shop=new Myshop();
		shop.setTitle("Myshop");
		shop.genUser();
		shop.genProduct();
		shop.start();

	}

}
