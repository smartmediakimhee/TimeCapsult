package VO;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SpringLayout;
import javax.swing.SwingConstants;
import javax.swing.border.MatteBorder;
import javax.swing.JScrollPane;
import java.awt.CardLayout;

public class MyPanel extends JPanel {

	public JLabel lbl_title;
	public JLabel pn_1_howtime;
	public JLabel pn_1_string;
	public JLabel lbl_showtime;
	public JLabel lbl_joayo;
	public JPanel pn_weather;
	public ImageIcon icon;
	private JLabel likecount;
	private JPanel panel;
	private ImageIcon timeImage;
	private JPanel panel_1;

	public MyPanel(JPanel pn_scroll, SpringLayout sl_pn_scroll) {
		timeImage = new ImageIcon(".\\Image\\timecapsule_ad.PNG");
		setBorder(new MatteBorder(1, 0, 1, 0, (Color) Color.LIGHT_GRAY)); // 패널1에 테두리 (top,left,bottom,right
																			// (컬러객체)컬러라이트그레이색으로
		sl_pn_scroll.putConstraint(SpringLayout.EAST, this, 653, SpringLayout.WEST, pn_scroll); // 패널 1의 동쪽은 스크롤패널서쪽
																								// 기준으로653만큼 떨어져있음
		setOpaque(false); // 패널1에 투명주기
		setBackground(Color.ORANGE); // 패널1에 백그라운드 색상 , 하지만 위에 setOpaque(투명도)를 줬기때문에 무시당함
		sl_pn_scroll.putConstraint(SpringLayout.NORTH, this, 10, SpringLayout.NORTH, pn_scroll);// 패널1의 북쪽은 스클롤패널의
																								// 북쪽으로부터 10만큼 떨어져있음
		sl_pn_scroll.putConstraint(SpringLayout.WEST, this, 10, SpringLayout.WEST, pn_scroll);// 패널1의 서쪽은 스크롤패널의 서쪽으로부터
																								// 10만큼 떨어져있음
		sl_pn_scroll.putConstraint(SpringLayout.SOUTH, this, 354, SpringLayout.NORTH, pn_scroll);
		setLayout(new CardLayout(0, 0));
		
	
		panel_1 = new JPanel(){
			public void paintComponent(Graphics g) {
				// Approach 1: Dispaly image at at full size
				// g.drawImage(timeImage.getImage(), 0, 0, null);
				// Approach 2: Scale image to size of component
				Dimension d = getSize();
				g.drawImage(timeImage.getImage(), 0, 0, d.width, d.height, null);
				// Approach 3: Fix the image position in the scroll pane
				// Point p = scrollPane.getViewport().getViewPosition();
				// g.drawImage(icon.getImage(), p.x, p.y, null);
				setOpaque(false); // 그림을 표시하게 설정,투명하게 조절
				super.paintComponent(g);
			}
		};
		add(panel_1, "name_349041968829963");

		// 글제목
		lbl_title = new JLabel("\uC2A4\uB9C8\uD2B8\uBBF8\uB514\uC5B4\uC778\uC7AC\uAC1C\uBC1C\uC6D0");
		lbl_title.setAutoscrolls(true);
		lbl_title.setHorizontalAlignment(SwingConstants.CENTER);// 텍스트를 중앙정렬
		lbl_title.setFont(new Font("굴림", Font.PLAIN, 30));

		add(lbl_title, "name_349037386638920");// 패널1에 방금 만든 pn_1_lbl을 추가
		
		// 문자열 : 열리는시간
		pn_1_string = new JLabel("");
		pn_1_string.setHorizontalAlignment(SwingConstants.CENTER);
		add(pn_1_string, "name_349037396856976");

		pn_weather = new JPanel() {
			public void paintComponent(Graphics g) {
				// Approach 1: Dispaly image at at full size
				// g.drawImage(icon.getImage(), 0, 0, null);
				// Approach 2: Scale image to size of component
				Dimension d = getSize();
				g.drawImage(icon.getImage(), 0, 0, d.width, d.height, null);
				// Approach 3: Fix the image position in the scroll pane
				// Point p = scrollPane.getViewport().getViewPosition();
				// g.drawImage(icon.getImage(), p.x, p.y, null);
				setOpaque(false);
				super.paintComponent(g);
			}
		};
		add(pn_weather, "name_349037403095089");
		
		lbl_showtime = new JLabel("");
		add(lbl_showtime, "name_349037409087794");

		likecount = new JLabel("");
		likecount.setHorizontalAlignment(SwingConstants.CENTER);
		add(likecount, "name_349037415304173");

		// 현재시각
		pn_1_howtime = new JLabel("18:27:00'");
		pn_1_howtime.setOpaque(true);
		pn_1_howtime.setHorizontalAlignment(SwingConstants.CENTER);
		pn_1_howtime.setFont(new Font("굴림", Font.PLAIN, 30));
		pn_1_howtime.setBackground(Color.WHITE);
		pn_1_howtime.setOpaque(false);
		add(pn_1_howtime, "name_349037444415265");

		panel = new JPanel() ;
		add(panel, "name_349037450304434");

	}

	public void get_icon(String str) {
		icon = new ImageIcon(str);
		Image originImg = icon.getImage();
		Image changedImg = originImg.getScaledInstance(90, 90, Image.SCALE_SMOOTH);
		icon = new ImageIcon(changedImg);
	}
	@Override
	public void paintComponent(Graphics g) {
		g.setColor(Color.ORANGE);
		// Approach 1: Dispaly image at at full size
		// g.drawImage(timeImage.getImage(), 0, 0, null);
		// Approach 2: Scale image to size of component
	//	Dimension d = getSize();
	//	g.drawImage(timeImage.getImage(), 0, 0, d.width, d.height, null);
		// Approach 3: Fix the image position in the scroll pane
		// Point p = scrollPane.getViewport().getViewPosition();
		// g.drawImage(icon.getImage(), p.x, p.y, null);
		setOpaque(true); // 그림을 표시하게 설정,투명하게 조절
		super.paintComponent(g);
	}
}
