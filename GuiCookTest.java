package cook;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class GuiCookTest {

	public static void main(String[] args) {
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
        
        // 버튼 위치와 크기설정
        btn1.setBounds(100, 300, 200, 50);
        btn2.setBounds(400, 300, 200, 50);
        btn3.setBounds(700, 300, 200, 50);

        // ★ 프레임에다가 버튼 추가
        frm.getContentPane().add(btn1);
        frm.getContentPane().add(btn2);
        frm.getContentPane().add(btn3);
        
        // ★ 라벨 설정
        JLabel lbl = new JLabel();
        lbl.setBounds(30, 400, 274, 50);
        lbl.setText("원하는 요리를 선택해 주세요. ");
        lbl.setHorizontalAlignment(JLabel.CENTER); // 수평 가운데 정렬
        frm.getContentPane().add(lbl);
        
        // 프레임이 보이도록 설정
        frm.setVisible(true);
    }
 
}
