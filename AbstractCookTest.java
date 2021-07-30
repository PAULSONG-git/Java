package cook;

public abstract class AbstractCookTest {
	
	public abstract int  checkQuantity();
	public abstract int  addList();

	public abstract void inputIngredient();
	public abstract void inputRecipeInfo();
	public abstract void choiceCook();
	public abstract void useIngredient();
	public abstract void order();
	public abstract void showMetheBox();
	
	public void clickCook() {
		int i = 0;
		i = checkQuantity();
		if (i == 0) {
			addList();
		}
	}
	
	public void cooking() {
		
		inputIngredient();
		inputRecipeInfo();
		showMetheBox();
		
		choiceCook();
		int i = 0;
		i = checkQuantity();
		if(i == 1) {
			useIngredient();
			System.out.println("요리 재료를 사용합니다. ");
			showMetheBox();
		}
		
		int j = 0;
		j = addList();
		if (j >= 40000) {
			order();
			System.out.println("요리 재료를 주문합니다. ");
			showMetheBox();
		}
	}
}
