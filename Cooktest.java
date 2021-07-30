package cook;

import javax.swing.UIManager;
import javax.swing.plaf.FontUIResource;

import java.awt.Font;
import java.util.ArrayList;
import java.util.Enumeration;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class CookTest {
	public static void main(String[] args) {

		IceBox iceBox = IceBox.getIceBox();                 //냉장고에 재료리스트 추가 
		Emart emart = new Emart();                          // 장바구니(Emart) 클래스 생성 
		ArrayList<Cook> cookList = new ArrayList<Cook>();
	
		iceBox.registerIngredient("크림파스타소스", 0.0, 10000);
		iceBox.registerIngredient("베이컨", 0.0, 5000);
		iceBox.registerIngredient("버터", 0.0, 8000);
		iceBox.registerIngredient("오징어", 0.0, 12000);
		iceBox.registerIngredient("고추", 0.0, 7000);
		iceBox.registerIngredient("떡", 0.0, 5000);
		iceBox.registerIngredient("고추장", 0.0, 15000);
		iceBox.registerIngredient("계란", 0.0, 9500);
		iceBox.registerIngredient("오뎅", 0.0, 3000);
		
		iceBox.showMeTheBox();
		
		Cook creamPasta = new Cook("크림파스타");         //요리(Cook) 클래스 생성 
		creamPasta.add("크림파스타소스", 0.2);                  //요리에 필요한 재료(Ingredients)와 재료수량 추가 
		creamPasta.add("베이컨", 0.2);
		creamPasta.add("버터", 0.2);
		cookList.add(creamPasta);
		
		Cook squidRice = new Cook("오징어볶음밥");
		squidRice.add("오징어", 0.2);
		squidRice.add("고추", 0.2);
		cookList.add(squidRice);
		
		Cook riceCake = new CookVideo("떡볶이");
		riceCake.add("떡", 0.2);
		riceCake.add("고추장", 0.2);
		riceCake.add("계란", 0.2);
		riceCake.add("오뎅", 0.2);
		cookList.add(squidRice);
	

		// ★ 모든 글꼴 통일
        Enumeration<Object> keys = UIManager.getDefaults().keys();
        while (keys.hasMoreElements()) {
            Object key = keys.nextElement();
            Object value = UIManager.get(key);
            if (value instanceof FontUIResource)
                UIManager.put(key, new FontUIResource("굴림", Font.PLAIN, 14));
        }
		
        // 프레임 생성
        JFrame frm = new JFrame("오늘뭐먹");
 
        // 프레임 크기 설정
        frm.setSize(1000, 528);
 
        // 프레임을 화면 가운데에 배치
        frm.setLocationRelativeTo(null);
        
        // 프레임을 닫았을 때 메모리에서 제거되도록 설정
        frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
 
        // ★ 레이아웃 설정
        frm.getContentPane().setLayout(null);
        
        // ★ 버튼 생성
        JButton btn1 = new JButton("크림스파게티");
        JButton btn2 = new JButton("오징어볶음밥");
        JButton btn3 = new JButton("떡볶이");
        JButton btn4 = new JButton("장바구니 확인");
        JButton btn5 = new JButton("재료 주문하기");
        JButton btn6 = new JButton("오늘 뭐먹지 요리추천");
        
        // 버튼 위치와 크기설정
        btn1.setBounds(100, 280, 200, 50);
        btn2.setBounds(400, 280, 200, 50);
        btn3.setBounds(700, 280, 200, 50);
        btn4.setBounds(350, 400, 150, 50);
        btn5.setBounds(525, 400, 150, 50);
        btn6.setBounds(700, 400, 150, 50);

        // ★ 프레임에다가 버튼 추가
        frm.getContentPane().add(btn1);
        frm.getContentPane().add(btn2);
        frm.getContentPane().add(btn3);
        frm.getContentPane().add(btn4);
        frm.getContentPane().add(btn5);
        frm.getContentPane().add(btn6);
        
        // ★ 라벨 설정
        JLabel lbl = new JLabel();
        lbl.setBounds(30, 400, 274, 50);
        lbl.setText("원하는 요리를 선택해 주세요. ");
        lbl.setHorizontalAlignment(JLabel.CENTER); // 수평 가운데 정렬
        frm.getContentPane().add(lbl);
        
        // ★ 버튼이 눌렸을때
        btn1.addActionListener(event -> {
        	int i = 0;
        	i = creamPasta.canMake(iceBox);
        	if (i == 0) {
        		for (Ingredients s : creamPasta.cookIngredientList) {
        			emart.addList(iceBox, s.getName());
        		}
        	}
        	if (i == 1) {
        		creamPasta.use(iceBox);
        		iceBox.showMeTheBox();
        		System.out.println("@@@  재료를 사용합니다. @@@");
        		System.out.println("");

        	}
        });
        
        btn2.addActionListener(event -> {
        	int i = 0;
        	i = squidRice.canMake(iceBox);
        	if (i == 0) {
        		for (Ingredients s : squidRice.cookIngredientList) {
        			emart.addList(iceBox, s.getName());
        		}
        	}
        	if (i == 1) {
        		squidRice.use(iceBox);
        		iceBox.showMeTheBox();
        		System.out.println("@@@  재료를 사용합니다. @@@");
        		System.out.println("");
        	}
        });
        
        btn3.addActionListener(event -> {
        	int i = 0;
        	i = riceCake.canMake(iceBox);
        	if (i == 0) {
        		for (Ingredients s : riceCake.cookIngredientList) {
        			emart.addList(iceBox, s.getName());
        		}
        	}
        	if (i == 1) {
        		riceCake.use(iceBox);
        		iceBox.showMeTheBox();
        		System.out.println("@@@  재료를 사용합니다. @@@");
        		System.out.println("");
        	}
        });
        
        btn4.addActionListener(event -> {
            emart.showMeTheEmart();
            emart.showOver40000();
        });
        
        btn5.addActionListener(event -> {
            emart.order(iceBox);
            iceBox.showMeTheBox();
            emart.deleteOrder();
            System.out.println("장바구니에 있는 재료를 주문하였습니다. ");
        });
        
        btn6.addActionListener(event -> {
        	int i = 0;
        	i = ((int)((Math.random()*10000)%10)%3);
        	if (i == 0) {
        		JOptionPane.showMessageDialog(null, "오늘 추천 요리는 크림파스타입니다. ");
        	}
        	else if (i == 1) {
        		JOptionPane.showMessageDialog(null, "오늘 추천 요리는 오징어덮밥입니다. ");
        	}
        	else {
        		JOptionPane.showMessageDialog(null, "오늘 추천 요리는 떡볶이입니다. ");

        	}
        	
        });
        
        // ★ 라벨 생성
        JLabel imgLbl1 = new JLabel();
        
        // ★ 라벨에 넣을 아이콘 생성
        ImageIcon bsImg = new ImageIcon(CookTest.class.getResource("/cook/img/creamPasta.jpg"));
        
        // ★ 라벨에 아이콘 설정
        imgLbl1.setIcon(bsImg);
        
        // ★ 기타 설정
        imgLbl1.setBounds(100, 50, 200, 200);
        imgLbl1.setHorizontalAlignment(JLabel.CENTER);
        frm.getContentPane().add(imgLbl1);
        
        // ★ 라벨2 생성
        JLabel imgLbl2 = new JLabel();
        
        // ★ 라벨2에 넣을 아이콘 생성
        ImageIcon bsImg2 = new ImageIcon(CookTest.class.getResource("/cook/img/squidRice.jpg"));
        
        // ★ 라벨2에 아이콘 설정
        imgLbl2.setIcon(bsImg2);
        
        // ★ 기타 설정
        imgLbl2.setBounds(400, 50, 200, 200);
        imgLbl2.setHorizontalAlignment(JLabel.CENTER);
        frm.getContentPane().add(imgLbl2);
        
     // ★ 라벨3 생성
        JLabel imgLbl3 = new JLabel();
        
        // ★ 라벨3에 넣을 아이콘 생성
        ImageIcon bsImg3 = new ImageIcon(CookTest.class.getResource("/cook/img/riceCake.png"));
        
        // ★ 라벨3에 아이콘 설정
        imgLbl3.setIcon(bsImg3);
        
        // ★ 기타 설정
        imgLbl3.setBounds(700, 50, 200, 200);
        imgLbl3.setHorizontalAlignment(JLabel.CENTER);
        frm.getContentPane().add(imgLbl3);
        
        // 프레임이 보이도록 설정
        frm.setVisible(true);
	}
}
