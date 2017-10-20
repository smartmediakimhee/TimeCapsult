package main;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.SystemColor;
import java.util.Set;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.SpringLayout;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.border.MatteBorder;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import javax.swing.BoxLayout;
import java.awt.FlowLayout;
import javax.swing.JScrollBar;

public class BoardMainGUI {
	JScrollPane scrollPane;
	private ImageIcon icon;
	private ImageIcon icon2;
	private JFrame frame;
	private ImageIcon icon3;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BoardMainGUI window = new BoardMainGUI();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public BoardMainGUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		icon = new ImageIcon("../TimeCapsule/Image/back.jpg");
		icon2 = new ImageIcon("../TimeCapsule/Image/1.png");
		icon3 = new ImageIcon("../TimeCapsule/Image/2.png");
		frame = new JFrame();
		frame.setBounds(0, 0, 1920, 1040);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JPanel panel_big = new JPanel() {
			public void paintComponent(Graphics g) {
				// Approach 1: Dispaly image at at full size
				g.drawImage(icon.getImage(), 0, 0, null);
				// Approach 2: Scale image to size of component

				Dimension d = getSize();
				g.drawImage(icon.getImage(), 0, 0, d.width, d.height, null);
				// Approach 3: Fix the image position in the scroll pane
				// Point p = scrollPane.getViewport().getViewPosition();
				// g.drawImage(icon.getImage(), p.x, p.y, null);
				setOpaque(false); // 그림을 표시하게 설정,투명하게 조절
				super.paintComponent(g);
			}
		};

		frame.getContentPane().add(panel_big, BorderLayout.CENTER);
		SpringLayout sl_panel_big = new SpringLayout();
		panel_big.setLayout(sl_panel_big);

		JLabel lbl_log_id = new JLabel("__________");
		panel_big.add(lbl_log_id);

		JLabel lbl_login = new JLabel("\uB2D8");
		sl_panel_big.putConstraint(SpringLayout.NORTH, lbl_login, 10, SpringLayout.NORTH, panel_big);
		sl_panel_big.putConstraint(SpringLayout.NORTH, lbl_log_id, 0, SpringLayout.NORTH, lbl_login);
		sl_panel_big.putConstraint(SpringLayout.EAST, lbl_log_id, -13, SpringLayout.WEST, lbl_login);
		panel_big.add(lbl_login);

		JLabel lbl_sign = new JLabel("log out");
		sl_panel_big.putConstraint(SpringLayout.EAST, lbl_login, -45, SpringLayout.WEST, lbl_sign);
		sl_panel_big.putConstraint(SpringLayout.NORTH, lbl_sign, 10, SpringLayout.NORTH, panel_big);
		sl_panel_big.putConstraint(SpringLayout.EAST, lbl_sign, -35, SpringLayout.EAST, panel_big);
		panel_big.add(lbl_sign);

		JPanel pn_img1 = new JPanel() {
			public void paintComponent(Graphics g) {
				// Approach 1: Dispaly image at at full size
				g.drawImage(icon2.getImage(), 0, 0, null);
				// Approach 2: Scale image to size of component
				// Dimension d = getSize();
				// g.drawImage(icon.getImage(), 0, 0, d.width, d.height, null);
				// Approach 3: Fix the image position in the scroll pane
				// Point p = scrollPane.getViewport().getViewPosition();
				// g.drawImage(icon.getImage(), p.x, p.y, null);
				setOpaque(false); // 그림을 표시하게 설정,투명하게 조절
				super.paintComponent(g);
			}
		};
		sl_panel_big.putConstraint(SpringLayout.NORTH, pn_img1, 28, SpringLayout.NORTH, panel_big);
		sl_panel_big.putConstraint(SpringLayout.WEST, pn_img1, 10, SpringLayout.WEST, panel_big);
		sl_panel_big.putConstraint(SpringLayout.SOUTH, pn_img1, -867, SpringLayout.SOUTH, panel_big);
		sl_panel_big.putConstraint(SpringLayout.EAST, pn_img1, -1759, SpringLayout.EAST, panel_big);
		panel_big.add(pn_img1);

		JPanel pn_img2 = new JPanel() {
			public void paintComponent(Graphics g) {

				// Approach 1: Dispaly image at at full size
				g.drawImage(icon3.getImage(), 0, 0, null);

				// Approach 2: Scale image to size of component
				// Dimension d = getSize();
				// g.drawImage(icon.getImage(), 0, 0, d.width, d.height, null);
				// Approach 3: Fix the image position in the scroll pane
				// Point p = scrollPane.getViewport().getViewPosition();
				// g.drawImage(icon.getImage(), p.x, p.y, null);
				setOpaque(false); // 그림을 표시하게 설정,투명하게 조절

				super.paintComponent(g);

			}
		};

		sl_panel_big.putConstraint(SpringLayout.NORTH, pn_img2, 813, SpringLayout.NORTH, panel_big);
		sl_panel_big.putConstraint(SpringLayout.WEST, pn_img2, 0, SpringLayout.WEST, lbl_login);
		sl_panel_big.putConstraint(SpringLayout.SOUTH, pn_img2, -82, SpringLayout.SOUTH, panel_big);
		sl_panel_big.putConstraint(SpringLayout.EAST, pn_img2, -40, SpringLayout.EAST, panel_big);
		panel_big.add(pn_img2);

		JScrollPane scrollPane_1 = new JScrollPane();
		sl_panel_big.putConstraint(SpringLayout.NORTH, scrollPane_1, 0, SpringLayout.NORTH, pn_img1);
		sl_panel_big.putConstraint(SpringLayout.WEST, scrollPane_1, -1300, SpringLayout.EAST, panel_big);
		sl_panel_big.putConstraint(SpringLayout.SOUTH, scrollPane_1, 992, SpringLayout.NORTH, panel_big);
		sl_panel_big.putConstraint(SpringLayout.EAST, scrollPane_1, -493, SpringLayout.EAST, panel_big);
		panel_big.add(scrollPane_1);
		scrollPane_1.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		scrollPane_1.getViewport().setOpaque(false);

		JPanel pn_scroll = new JPanel();
		pn_scroll.setBorder(new LineBorder(new Color(192, 192, 192), 0, true));
		scrollPane_1.setViewportView(pn_scroll);

		pn_scroll.setOpaque(false);
		scrollPane_1.setOpaque(false);
		panel_big.setOpaque(false);
		// 스크롤팬 생성
		JPanel panel_ex = new JPanel();// 스크롤팬에 붙일 패널 생성
		Dimension size = new Dimension();// 사이즈를 지정하기 위한 객체 생성
		// size.setSize(10, 382*4);// 객체의 사이즈를 지정
		size.setSize(10, panelsHeightSize(4)); // panelHeightSize(int count) 에서 count 는 페널들이 담긴 ArrayList의 size 값이다.
		pn_scroll.setPreferredSize(size);// 사이즈 정보를 가지고 있는 객체를 이용해 패널의 사이즈 지정
		scrollPane_1.setViewportView(pn_scroll);
		pn_scroll.setSize(450, 200);
		SpringLayout sl_pn_scroll = new SpringLayout();
		pn_scroll.setLayout(sl_pn_scroll);

		JPanel pn_1 = new JPanel();
		pn_1.setBorder(new MatteBorder(1, 0, 1, 0, (Color) Color.LIGHT_GRAY));
		sl_pn_scroll.putConstraint(SpringLayout.EAST, pn_1, 653, SpringLayout.WEST, pn_scroll);
		pn_1.setOpaque(false);

		pn_1.setBackground(Color.GREEN);
		sl_pn_scroll.putConstraint(SpringLayout.NORTH, pn_1, 10, SpringLayout.NORTH, pn_scroll);
		sl_pn_scroll.putConstraint(SpringLayout.WEST, pn_1, 10, SpringLayout.WEST, pn_scroll);
		sl_pn_scroll.putConstraint(SpringLayout.SOUTH, pn_1, 354, SpringLayout.NORTH, pn_scroll);
		pn_scroll.add(pn_1);
		SpringLayout sl_pn_1 = new SpringLayout();
		pn_1.setLayout(sl_pn_1);

		JLabel pn_1_lbl = new JLabel("\uC2A4\uB9C8\uD2B8\uBBF8\uB514\uC5B4\uC778\uC7AC\uAC1C\uBC1C\uC6D0");
		sl_pn_1.putConstraint(SpringLayout.NORTH, pn_1_lbl, 35, SpringLayout.NORTH, pn_1);
		sl_pn_1.putConstraint(SpringLayout.WEST, pn_1_lbl, 181, SpringLayout.WEST, pn_1);
		pn_1_lbl.setHorizontalAlignment(SwingConstants.CENTER);
		pn_1_lbl.setFont(new Font("조선일보명조", Font.PLAIN, 25));
		pn_1.add(pn_1_lbl);

		JLabel pn_1_lbl2 = new JLabel("18:27:00'");
		sl_pn_1.putConstraint(SpringLayout.NORTH, pn_1_lbl2, 55, SpringLayout.SOUTH, pn_1_lbl);
		sl_pn_1.putConstraint(SpringLayout.WEST, pn_1_lbl2, 242, SpringLayout.WEST, pn_1);
		pn_1_lbl2.setOpaque(true);
		pn_1_lbl2.setHorizontalAlignment(SwingConstants.CENTER);
		pn_1_lbl2.setFont(new Font("굴림", Font.PLAIN, 30));
		pn_1_lbl2.setBackground(Color.WHITE);
		pn_1.add(pn_1_lbl2);

		JLabel pn_1_lbl3 = new JLabel("\uC5F4\uB9AC\uB294 \uC2DC\uAC04");
		sl_pn_1.putConstraint(SpringLayout.NORTH, pn_1_lbl3, 58, SpringLayout.SOUTH, pn_1_lbl2);
		sl_pn_1.putConstraint(SpringLayout.WEST, pn_1_lbl3, 273, SpringLayout.WEST, pn_1);
		pn_1_lbl3.setHorizontalAlignment(SwingConstants.CENTER);
		pn_1.add(pn_1_lbl3);

		JPanel pn_weather = new JPanel();
		sl_pn_1.putConstraint(SpringLayout.NORTH, pn_weather, -84, SpringLayout.SOUTH, pn_1);
		sl_pn_1.putConstraint(SpringLayout.WEST, pn_weather, 531, SpringLayout.WEST, pn_1);
		sl_pn_1.putConstraint(SpringLayout.SOUTH, pn_weather, -11, SpringLayout.SOUTH, pn_1);
		sl_pn_1.putConstraint(SpringLayout.EAST, pn_weather, -10, SpringLayout.EAST, pn_1);
		pn_1.add(pn_weather);

		scrollPane_1.getVerticalScrollBar().setUnitIncrement(30);

		JPanel pn_2 = new JPanel();
		pn_2.setBorder(new MatteBorder(1, 0, 1, 0, (Color) Color.LIGHT_GRAY));
		sl_pn_scroll.putConstraint(SpringLayout.NORTH, pn_2, 38, SpringLayout.SOUTH, pn_1);
		sl_pn_scroll.putConstraint(SpringLayout.WEST, pn_2, 0, SpringLayout.WEST, pn_1);
		sl_pn_scroll.putConstraint(SpringLayout.SOUTH, pn_2, 382, SpringLayout.SOUTH, pn_1);
		sl_pn_scroll.putConstraint(SpringLayout.EAST, pn_2, 643, SpringLayout.WEST, pn_1);

		pn_2.setOpaque(false);

		SpringLayout sl_pn_2 = new SpringLayout();
		pn_2.setLayout(sl_pn_2);

		JLabel lbl_title = new JLabel("\uC2A4\uB9C8\uD2B8\uBBF8\uB514\uC5B4\uC778\uC7AC\uAC1C\uBC1C\uC6D0");
		sl_pn_2.putConstraint(SpringLayout.NORTH, lbl_title, 31, SpringLayout.NORTH, pn_2);
		sl_pn_2.putConstraint(SpringLayout.WEST, lbl_title, 149, SpringLayout.WEST, pn_2);
		lbl_title.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_title.setFont(new Font("굴림", Font.PLAIN, 30));
		pn_2.add(lbl_title);

		JLabel lbl_howtime = new JLabel("18:27:00'");
		sl_pn_2.putConstraint(SpringLayout.NORTH, lbl_howtime, 51, SpringLayout.SOUTH, lbl_title);
		sl_pn_2.putConstraint(SpringLayout.WEST, lbl_howtime, 241, SpringLayout.WEST, pn_2);
		lbl_howtime.setOpaque(true);
		lbl_howtime.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_howtime.setFont(new Font("굴림", Font.PLAIN, 30));
		lbl_howtime.setBackground(Color.WHITE);
		pn_2.add(lbl_howtime);

		JLabel lbl_string = new JLabel("\uC5F4\uB9AC\uB294 \uC2DC\uAC04");
		sl_pn_2.putConstraint(SpringLayout.NORTH, lbl_string, 74, SpringLayout.SOUTH, lbl_howtime);
		sl_pn_2.putConstraint(SpringLayout.WEST, lbl_string, 276, SpringLayout.WEST, pn_2);
		lbl_string.setHorizontalAlignment(SwingConstants.CENTER);
		pn_2.add(lbl_string);

		JPanel pn_2_weather = new JPanel();
		sl_pn_2.putConstraint(SpringLayout.NORTH, pn_2_weather, 33, SpringLayout.NORTH, lbl_string);
		sl_pn_2.putConstraint(SpringLayout.WEST, pn_2_weather, -112, SpringLayout.EAST, pn_2);
		sl_pn_2.putConstraint(SpringLayout.SOUTH, pn_2_weather, -10, SpringLayout.SOUTH, pn_2);
		sl_pn_2.putConstraint(SpringLayout.EAST, pn_2_weather, -10, SpringLayout.EAST, pn_2);
		pn_2.add(pn_2_weather);
		pn_scroll.add(pn_2);

		JPanel pn_3 = new JPanel();
		pn_3.setBorder(new MatteBorder(1, 0, 1, 0, (Color) Color.LIGHT_GRAY));
		sl_pn_scroll.putConstraint(SpringLayout.NORTH, pn_3, 38, SpringLayout.SOUTH, pn_2);
		sl_pn_scroll.putConstraint(SpringLayout.WEST, pn_3, 0, SpringLayout.WEST, pn_2);
		sl_pn_scroll.putConstraint(SpringLayout.SOUTH, pn_3, 382, SpringLayout.SOUTH, pn_2);
		sl_pn_scroll.putConstraint(SpringLayout.EAST, pn_3, 643, SpringLayout.WEST, pn_2);
		pn_scroll.add(pn_3);
		pn_3.setOpaque(false);

		SpringLayout sl_pn_3 = new SpringLayout();
		pn_3.setLayout(sl_pn_3);

		JLabel pn_3_lbl = new JLabel("\uC2A4\uB9C8\uD2B8\uBBF8\uB514\uC5B4\uC778\uC7AC\uAC1C\uBC1C\uC6D0");
		sl_pn_3.putConstraint(SpringLayout.NORTH, pn_3_lbl, 31, SpringLayout.NORTH, pn_3);
		sl_pn_3.putConstraint(SpringLayout.WEST, pn_3_lbl, 149, SpringLayout.WEST, pn_3);
		pn_3_lbl.setHorizontalAlignment(SwingConstants.CENTER);
		pn_3_lbl.setFont(new Font("굴림", Font.PLAIN, 30));
		pn_3.add(pn_3_lbl);
		
		
		JLabel pn_3_lbl2 = new JLabel("18:27:00'");
		sl_pn_3.putConstraint(SpringLayout.NORTH, pn_3_lbl2, 51, SpringLayout.SOUTH, pn_3_lbl);
		sl_pn_3.putConstraint(SpringLayout.WEST, pn_3_lbl2, 241, SpringLayout.WEST, pn_3);
		pn_3_lbl2.setOpaque(true);
		pn_3_lbl2.setHorizontalAlignment(SwingConstants.CENTER);
		pn_3_lbl2.setFont(new Font("굴림", Font.PLAIN, 30));
		pn_3_lbl2.setBackground(Color.WHITE);
		pn_3.add(pn_3_lbl2);

		JLabel pn_3_lbl3 = new JLabel("\uC5F4\uB9AC\uB294 \uC2DC\uAC04");
		sl_pn_3.putConstraint(SpringLayout.NORTH, pn_3_lbl3, 74, SpringLayout.SOUTH, pn_3_lbl2);
		sl_pn_3.putConstraint(SpringLayout.WEST, pn_3_lbl3, 276, SpringLayout.WEST, pn_3);
		pn_3_lbl3.setHorizontalAlignment(SwingConstants.CENTER);
		pn_3.add(pn_3_lbl3);

		JPanel pn_3_weather = new JPanel();
		sl_pn_3.putConstraint(SpringLayout.NORTH, pn_3_weather, 33, SpringLayout.NORTH, pn_3_lbl3);
		sl_pn_3.putConstraint(SpringLayout.WEST, pn_3_weather, -112, SpringLayout.EAST, pn_3);
		sl_pn_3.putConstraint(SpringLayout.SOUTH, pn_3_weather, -10, SpringLayout.SOUTH, pn_3);
		sl_pn_3.putConstraint(SpringLayout.EAST, pn_3_weather, -10, SpringLayout.EAST, pn_3);
		pn_3.add(pn_3_weather);
		
		
		
		
		JPanel pn_4 = new JPanel();
		pn_4.setBorder(new MatteBorder(1, 0, 1, 0, (Color) Color.LIGHT_GRAY));
		sl_pn_scroll.putConstraint(SpringLayout.NORTH, pn_4, 38, SpringLayout.SOUTH, pn_3);
		sl_pn_scroll.putConstraint(SpringLayout.WEST, pn_4, 0, SpringLayout.WEST, pn_3);
		sl_pn_scroll.putConstraint(SpringLayout.SOUTH, pn_4, 382, SpringLayout.SOUTH, pn_3);
		sl_pn_scroll.putConstraint(SpringLayout.EAST, pn_4, 643, SpringLayout.WEST, pn_3);
		pn_scroll.add(pn_4);
		pn_4.setOpaque(false);
		
		SpringLayout sl_pn_4 = new SpringLayout();
		pn_4.setLayout(sl_pn_4);
		
		JLabel pn_4_lbl = new JLabel("\uC2A4\uB9C8\uD2B8\uBBF8\uB514\uC5B4\uC778\uC7AC\uAC1C\uBC1C\uC6D0");
		sl_pn_4.putConstraint(SpringLayout.NORTH, pn_4_lbl, 31, SpringLayout.NORTH, pn_4);
		sl_pn_4.putConstraint(SpringLayout.WEST, pn_4_lbl, 149, SpringLayout.WEST, pn_4);
		pn_4_lbl.setHorizontalAlignment(SwingConstants.CENTER);
		pn_4_lbl.setFont(new Font("굴림", Font.PLAIN, 30));
		pn_4.add(pn_4_lbl);
		
		
		JLabel pn_4_lbl2 = new JLabel("18:27:00'");
		sl_pn_4.putConstraint(SpringLayout.NORTH, pn_4_lbl2, 51, SpringLayout.SOUTH, pn_4_lbl);
		sl_pn_4.putConstraint(SpringLayout.WEST, pn_4_lbl2, 241, SpringLayout.WEST, pn_4);
		pn_4_lbl2.setOpaque(true);
		pn_4_lbl2.setHorizontalAlignment(SwingConstants.CENTER);
		pn_4_lbl2.setFont(new Font("굴림", Font.PLAIN, 30));
		pn_4_lbl2.setBackground(Color.WHITE);
		pn_4.add(pn_4_lbl2);
		
		JLabel pn_4_lbl3 = new JLabel("\uC5F4\uB9AC\uB294 \uC2DC\uAC04");
		sl_pn_4.putConstraint(SpringLayout.NORTH, pn_4_lbl3, 74, SpringLayout.SOUTH, pn_4_lbl2);
		sl_pn_4.putConstraint(SpringLayout.WEST, pn_4_lbl3, 276, SpringLayout.WEST, pn_4);
		pn_4_lbl3.setHorizontalAlignment(SwingConstants.CENTER);
		pn_4.add(pn_4_lbl3);
		
		JPanel pn_4_weather = new JPanel();
		sl_pn_4.putConstraint(SpringLayout.NORTH, pn_4_weather, 33, SpringLayout.NORTH, pn_4_lbl3);
		sl_pn_4.putConstraint(SpringLayout.WEST, pn_4_weather, -112, SpringLayout.EAST, pn_4);
		sl_pn_4.putConstraint(SpringLayout.SOUTH, pn_4_weather, -10, SpringLayout.SOUTH, pn_4);
		sl_pn_4.putConstraint(SpringLayout.EAST, pn_4_weather, -10, SpringLayout.EAST, pn_4);
		pn_4.add(pn_4_weather);
		
		
		
		
		
		JPanel pn_5 = new JPanel();
		pn_5.setBorder(new MatteBorder(1, 0, 1, 0, (Color) Color.LIGHT_GRAY));
		sl_pn_scroll.putConstraint(SpringLayout.NORTH, pn_5, 38, SpringLayout.SOUTH, pn_4);
		sl_pn_scroll.putConstraint(SpringLayout.WEST, pn_5, 0, SpringLayout.WEST, pn_4);
		sl_pn_scroll.putConstraint(SpringLayout.SOUTH, pn_5, 382, SpringLayout.SOUTH, pn_4);
		sl_pn_scroll.putConstraint(SpringLayout.EAST, pn_5, 643, SpringLayout.WEST, pn_4);
		pn_scroll.add(pn_5);
		pn_5.setOpaque(false);
		
		SpringLayout sl_pn_5 = new SpringLayout();
		pn_5.setLayout(sl_pn_5);
		
		JLabel pn_5_lbl = new JLabel("\uC2A4\uB9C8\uD2B8\uBBF8\uB514\uC5B4\uC778\uC7AC\uAC1C\uBC1C\uC6D0");
		sl_pn_5.putConstraint(SpringLayout.NORTH, pn_5_lbl, 31, SpringLayout.NORTH, pn_5);
		sl_pn_5.putConstraint(SpringLayout.WEST, pn_5_lbl, 149, SpringLayout.WEST, pn_5);
		pn_5_lbl.setHorizontalAlignment(SwingConstants.CENTER);
		pn_5_lbl.setFont(new Font("굴림", Font.PLAIN, 30));
		pn_5.add(pn_5_lbl);
		
		
		JLabel pn_5_lbl2 = new JLabel("18:27:00'");
		sl_pn_5.putConstraint(SpringLayout.NORTH, pn_4_lbl2, 51, SpringLayout.SOUTH, pn_5_lbl);
		sl_pn_5.putConstraint(SpringLayout.WEST, pn_4_lbl2, 241, SpringLayout.WEST, pn_5);
		pn_5_lbl2.setOpaque(true);
		pn_5_lbl2.setHorizontalAlignment(SwingConstants.CENTER);
		pn_5_lbl2.setFont(new Font("굴림", Font.PLAIN, 30));
		pn_5_lbl2.setBackground(Color.WHITE);
		pn_5.add(pn_5_lbl2);
		
		JLabel pn_5_lbl3 = new JLabel("\uC5F4\uB9AC\uB294 \uC2DC\uAC04");
		sl_pn_5.putConstraint(SpringLayout.NORTH, pn_5_lbl3, 74, SpringLayout.SOUTH, pn_5_lbl2);
		sl_pn_5.putConstraint(SpringLayout.WEST, pn_5_lbl3, 276, SpringLayout.WEST, pn_5);
		pn_5_lbl3.setHorizontalAlignment(SwingConstants.CENTER);
		pn_5.add(pn_5_lbl3);
		
		JPanel pn_5_weather = new JPanel();
		sl_pn_5.putConstraint(SpringLayout.NORTH, pn_5_weather, 33, SpringLayout.NORTH, pn_5_lbl3);
		sl_pn_5.putConstraint(SpringLayout.WEST, pn_5_weather, -112, SpringLayout.EAST, pn_5);
		sl_pn_5.putConstraint(SpringLayout.SOUTH, pn_5_weather, -10, SpringLayout.SOUTH, pn_5);
		sl_pn_5.putConstraint(SpringLayout.EAST, pn_5_weather, -10, SpringLayout.EAST, pn_5);
		pn_5.add(pn_5_weather);

		pn_2.setOpaque(false);
		
		JLabel lbl_showtime = new JLabel("New label");
		sl_pn_2.putConstraint(SpringLayout.NORTH, lbl_showtime, 17, SpringLayout.SOUTH, lbl_string);
		sl_pn_2.putConstraint(SpringLayout.WEST, lbl_showtime, -346, SpringLayout.WEST, pn_2_weather);
		sl_pn_2.putConstraint(SpringLayout.EAST, lbl_showtime, -71, SpringLayout.WEST, pn_2_weather);
		pn_2.add(lbl_showtime);
		scrollPane_1.getVerticalScrollBar().setUnitIncrement(30);

		scrollPane_1.getVerticalScrollBar().setUnitIncrement(30);

	}

	private int panelsHeightSize(int count) {

		return count * 382;
	}
}