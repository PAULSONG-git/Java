package cook;
import java.util.ArrayList;                              //ArrayList를 사용하기 위해 클래스 import

public class IceBox {
	private static IceBox iceBox = new IceBox();		 // 유일한 냉장고 인스턴스 생성 
	private IceBox() { } 								 // 외부 클래스에서 인스턴스를 생성하지 못하게 private 접근제어 
	public static IceBox getIceBox() {                   // 생성된 인스턴스를 외부에서 참조할 수 있도록 public 메서드 구현 
		if(iceBox == null) {
			iceBox = new IceBox();						 // 방어적인 코드 
		}
		return iceBox;
	}
	
	ArrayList<Ingredients> ingredientList = new ArrayList<Ingredients>();         // 재료(Ingredients)를 ArrayList 사용하여 저장 
																				  // ArrayList목적 : 냉장고에 남아있는 재료의 이름과 수량
	public void registerIngredient(String name, double quantity, double price) {  	  // 처음 재료를 등록하는 목적 
		Ingredients ingredient = new Ingredients();
		ingredient.setName(name);
		ingredient.setQuantity(quantity);
		ingredient.setPrice(price);
		ingredientList.add(ingredient);
	}
	
	public void addQuantity(String ingredient, double quantity) {						  // 등록되어 있는 재료의 수량을 추가 (= 장바구니 재료를 주문했을때) 
		for (Ingredients s : ingredientList) {
			if (s.getName() == ingredient) {
				s.setQuantity((Math.round((s.getQuantity() + quantity) * 100.0))/100.0); // 부동소수점 때문에???
			}																	  // Math함수의 round()함수는 실수의 소수점 첫번째 자리를 반올림하여 정수로 리턴
		}
	}
	
	public void minusQuantity(String ingredient, double quantity) {						  // 등록되어 있는 재료의 수량을 감소 (= 요리를 하여 재료를 사용했을때)
		for (Ingredients s : ingredientList) {
			if (s.getName() == ingredient) {
				s.setQuantity((Math.round((s.getQuantity() - quantity) * 100.0))/100.0);
			}
		}
	}
	
	public double getQuantityByName(String name) {											  // Cook클래스에서 canMake메서드를 위
		for (Ingredients s : ingredientList) {									  // 냉장고에 있는 재료의 이름을 매개변수로 넣어주면 그 재료의 수량을 리턴해주는 메서드 
			if (s.getName() == name) {
				return s.getQuantity();
			}
		}
		return 0;
	}
	
	public void showMeTheBox() {												  // 냉장고에 있는 재료의 이름과 수량을 보여주는 메서
		System.out.println("냉장고에 있는 재료의 양은 다음과 같습니다.");
		System.out.println("===========================");
		
		for (Ingredients s : ingredientList) {
			s.showInfo();
		}
		System.out.println("===========================");
		System.out.println();
	}
	
}
