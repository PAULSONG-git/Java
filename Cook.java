package cook;
import java.util.ArrayList;															//ArrayList를 사용하기 위해 클래스 import

public class Cook {
	protected String cookName;														//property(요리이름)
	ArrayList<Ingredients> cookIngredientList = new ArrayList<Ingredients>();       //Ingredient클래스 자료형으로 하는 ArrayList 생성 
																					//ArrayList목적 : 요리에 사용되는 재료의 이름과 수량
	public Cook(String cookName) {
		this.cookName = cookName;
	}
	
	public String getCookName() {
		return cookName;
	}

	public void setCookName(String cookName) {
		this.cookName = cookName;
	}

	public void add(String ingredients, double quantity) {							//add메서드 : 재료의 이름과 수량을 매개변수로 받아, Ingredients인스턴스 생성, ArrayList 추가 
		Ingredients ingredient = new Ingredients(ingredients, quantity);
		cookIngredientList.add(ingredient);
	}
	
	public void minus(String ingredients) {											//minus메서드 : 재료의 이름을 매개변수로 받아, 반복&조건문을 통해, ArrayList 제거
		for (int i = 0; i < cookIngredientList.size(); i++) {
			if (cookIngredientList.get(i).getName() == ingredients)
				cookIngredientList.remove(i);
		}
	}
	
	public int canMake(IceBox iceBox) {											//냉장고재료에 따른 요리가 가능한지 확인하는 메서드: 
		int flag = 1;
		for (Ingredients s : cookIngredientList) {
			if (!(s.getQuantity() <= iceBox.getQuantityByName(s.getName())))						//요리에 필요한 재료의 양이 냉장고에 있는 재료의 양과 비교해서
				flag = 0;															//하나의 재료라도 부족하면 flag = 0(=요리 할 수 없음)
		}
		if (flag == 1) {
			System.out.println(cookName + "을 위한 재료가 충분합니다. 요리할 수 있습니다.");
			System.out.println();
		}
		else {
			System.out.println(cookName + "을 위한 냉장고 재료의 양이 부족합니다.");
			System.out.println("필요한 재료를 장바구니에 담습니다.");
			System.out.println();
		}
		return flag;
	}
	
	public void use(IceBox iceBox) {												//요리를 하면 냉장고에 있는 재료를 소진시키는 메서드 
		for (Ingredients s : cookIngredientList) {
			iceBox.minusQuantity(s.getName(), s.getQuantity());
		}
	}
}
