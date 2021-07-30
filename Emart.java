package cook;

import java.util.ArrayList;																//ArrayList를 사용하기 위해 클래스 import

public class Emart {
	private double total = 0;															//장바구니 총 금액 
	IceBox iceBox = IceBox.getIceBox();													//IceBox생성자 호출 
	ArrayList<Ingredients> orderList = new ArrayList<Ingredients>();					//재료 ArrayList생성 
																						//장바구니에 주문해야할 재료리스트 
	public int addList(IceBox iceBox, String ingredientName) {												//냉장고의 재료수량을 확인, 0.2 이하면 장바구니 리스트에 추가 
		int flag = 1;
		for (Ingredients ice : iceBox.ingredientList) {
			if (ingredientName == ice.getName() && ice.getQuantity() <= 0.2) {
				for (Ingredients order : orderList) {
					if (order.getName() == ingredientName) {
						flag = 0;
					}
				}
				if (flag != 0) {
					orderList.add(ice);
					this.total += ice.getPrice();	
				}
			}
		}
		return (int)total;
	}
	
	public void showOver40000 () {
		if (this.total >= 40000) {
			System.out.println("주문해야할 재료의 금액이 40,000원 이상되었습니다.");			//총 주문금액이 40,000원 이상이면 메세지 출력 
			System.out.println();
		}
	}
	
	public void order(IceBox iceBox) {													//장바구니 리스트 오더 (=냉장고에 수량추가하기)
		for (Ingredients s : orderList) {
			iceBox.addQuantity(s.getName(), 1.0);
		}
	}
	
	public void deleteOrder() {
		while (!(orderList.size() == 0)) {
			for (int i = 0; i < orderList.size(); i++) {
				orderList.remove(i);
			}
		}
		this.total = 0;
	}
	
	public void showMeTheEmart() {
		System.out.println("================장바구니에 담겨있는 리스트입니다==================");
		for (Ingredients s : orderList) {
			System.out.println(s.getName() + " : " + s.getPrice() + "원");
		}
		System.out.println("==========================================================");
		System.out.println("total : " + this.total);
		System.out.println("==========================================================");
	}
}
