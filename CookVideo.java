package cook;

import javax.swing.JOptionPane;

public class CookVideo extends Cook {
	
	public CookVideo(String cookName) {
		super(cookName);
	}
	
//	@Override
//	public int canMake(IceBox iceBox) {											
//		int i = 0;
//		i = super.canMake(iceBox);
//		
//		System.out.println();
//		return i;
//	}
	
	@Override
	public void use(IceBox iceBox) {												//요리를 하면 냉장고에 있는 재료를 소진시키는 메서드 
		for (Ingredients s : cookIngredientList) {
			iceBox.minusQuantity(s.getName(), s.getQuantity());
		}
		JOptionPane.showMessageDialog(null, cookName + " 관련 요리방법 영상 URL입니다. ");
	}
}
