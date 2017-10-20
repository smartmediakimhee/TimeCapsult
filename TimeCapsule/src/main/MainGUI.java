package main;

import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.SystemColor;
import java.awt.Window;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.SpringLayout;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.border.LineBorder;
import javax.swing.border.MatteBorder;
import javax.swing.border.TitledBorder;
import javax.swing.SwingConstants;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MainGUI {
	JScrollPane scrollPane;
	ImageIcon icon;
	ImageIcon icon2;
	ImageIcon Mainicon;
	ImageIcon Maintitle;
	private JFrame frame;
	private JTextField id_input;
	private JPasswordField pw_input;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainGUI window = new MainGUI();
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
	public MainGUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		Mainicon = new ImageIcon("../TimeCapsule/Image/back.jpg");
		icon = new ImageIcon("../TimeCapsule/Image/1.png");
		icon2 = new ImageIcon("../TimeCapsule/Image/2.png");
		Maintitle = new ImageIcon("../TimeCapsule/Image/maintitle.png");
		frame = new JFrame();
		frame.setBounds(0, 0, 1920, 1040);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JPanel pn_all = new JPanel() {
			public void paintComponent(Graphics g) {
				// Approach 1: Dispaly image at at full size
				g.drawImage(Mainicon.getImage(), 0, 0, null);
				// Approach 2: Scale image to size of component
				 Dimension d = getSize();
				 g.drawImage(Mainicon.getImage(), 0, 0, d.width, d.height, null);
				// Approach 3: Fix the image position in the scroll pane
				// Point p = scrollPane.getViewport().getViewPosition();
				// g.drawImage(icon.getImage(), p.x, p.y, null);
				setOpaque(false); // 그림을 표시하게 설정,투명하게 조절
				super.paintComponent(g);
			}
		};
		pn_all.setBackground(Color.WHITE);
		frame.getContentPane().add(pn_all, BorderLayout.CENTER);
		SpringLayout sl_pn_all = new SpringLayout();
		pn_all.setLayout(sl_pn_all);

		JLabel lbl_login = new JLabel("IN");
		pn_all.add(lbl_login);

		JLabel lbl_sign = new JLabel("JOIN");
		lbl_sign.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			JoinGUI join = new JoinGUI();
			join.main(null);
			
			}
		});
		sl_pn_all.putConstraint(SpringLayout.NORTH, lbl_sign, 10, SpringLayout.NORTH, pn_all);
		sl_pn_all.putConstraint(SpringLayout.WEST, lbl_sign, 1445, SpringLayout.WEST, pn_all);
		sl_pn_all.putConstraint(SpringLayout.NORTH, lbl_login, 0, SpringLayout.NORTH, lbl_sign);
		sl_pn_all.putConstraint(SpringLayout.EAST, lbl_login, -53, SpringLayout.WEST, lbl_sign);
		pn_all.add(lbl_sign);
		
		id_input = new JTextField();
		sl_pn_all.putConstraint(SpringLayout.NORTH, id_input, -5, SpringLayout.NORTH, lbl_login);
		sl_pn_all.putConstraint(SpringLayout.WEST, id_input, 1037, SpringLayout.WEST, pn_all);
		sl_pn_all.putConstraint(SpringLayout.SOUTH, id_input, 32, SpringLayout.NORTH, pn_all);
		sl_pn_all.putConstraint(SpringLayout.EAST, id_input, -184, SpringLayout.WEST, lbl_login);
		id_input.setText("hwa");
		String id = id_input.getText(); //id값 불러오기
		System.out.println(id);

		id_input.setOpaque(false);
		pn_all.add(id_input);
		id_input.setColumns(10);
		id_input.setBorder(new MatteBorder(0, 0, 2, 0, (Color) Color.LIGHT_GRAY));
		
		JPanel pn_contents = new JPanel();
		sl_pn_all.putConstraint(SpringLayout.SOUTH, pn_contents, 915, SpringLayout.NORTH, pn_all);
		pn_contents.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(192, 192, 192)));
		sl_pn_all.putConstraint(SpringLayout.NORTH, pn_contents, 60, SpringLayout.SOUTH, id_input);
		sl_pn_all.putConstraint(SpringLayout.WEST, pn_contents, 677, SpringLayout.WEST, pn_all);
		sl_pn_all.putConstraint(SpringLayout.EAST, pn_contents, -606, SpringLayout.EAST, pn_all);
		pn_all.add(pn_contents);
		SpringLayout sl_pn_contents = new SpringLayout();
		pn_contents.setLayout(sl_pn_contents);
		pn_contents.setOpaque(false);
		
		TitledBorder oneTb = // 주변 테두리 색을 지정하기 위해 LineBorder사용
				new TitledBorder(new LineBorder(Color.black));
		oneTb.setTitleColor(Color.red); // 타이틀 컬러 지정
		
		
		pn_contents.setBorder(new LineBorder(SystemColor.activeCaptionBorder, 2));
		
		
		JPanel pn_logo = new JPanel() {
			public void paintComponent(Graphics g) {
				// Approach 1: Dispaly image at at full size
				g.drawImage(icon.getImage(), 0, 0, null);
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
		sl_pn_contents.putConstraint(SpringLayout.NORTH, pn_logo, 99, SpringLayout.NORTH, pn_contents);
		sl_pn_contents.putConstraint(SpringLayout.WEST, pn_logo, 261, SpringLayout.WEST, pn_contents);
		sl_pn_contents.putConstraint(SpringLayout.SOUTH, pn_logo, -659, SpringLayout.SOUTH, pn_contents);
		sl_pn_contents.putConstraint(SpringLayout.EAST, pn_logo, -248, SpringLayout.EAST, pn_contents);
		sl_pn_all.putConstraint(SpringLayout.NORTH, pn_logo, 90, SpringLayout.NORTH, pn_all);
		sl_pn_all.putConstraint(SpringLayout.WEST, pn_logo, 116, SpringLayout.EAST, pn_contents);
		sl_pn_all.putConstraint(SpringLayout.EAST, pn_logo, -970, SpringLayout.EAST, pn_all);
		pn_contents.add(pn_logo);
		
		JPanel pn_logo2 = new JPanel() {
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
		sl_pn_contents.putConstraint(SpringLayout.NORTH, pn_logo2, 618, SpringLayout.NORTH, pn_contents);
		sl_pn_contents.putConstraint(SpringLayout.WEST, pn_logo2, 0, SpringLayout.WEST, pn_logo);
		sl_pn_contents.putConstraint(SpringLayout.SOUTH, pn_logo2, -102, SpringLayout.SOUTH, pn_contents);
		sl_pn_contents.putConstraint(SpringLayout.EAST, pn_logo2, -263, SpringLayout.EAST, pn_contents);
		sl_pn_all.putConstraint(SpringLayout.WEST, pn_logo2, 123, SpringLayout.EAST, pn_contents);
		sl_pn_all.putConstraint(SpringLayout.SOUTH, pn_logo2, -486, SpringLayout.SOUTH, pn_all);
		sl_pn_all.putConstraint(SpringLayout.EAST, pn_logo2, -995, SpringLayout.EAST, pn_all);
		pn_contents.add(pn_logo2);
		
		JPanel pn_maintitle = new JPanel(){
			public void paintComponent(Graphics g) {
				
				// Approach 1: Dispaly image at at full size
				g.drawImage(Maintitle.getImage(), 0, 0, null);
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
		sl_pn_contents.putConstraint(SpringLayout.NORTH, pn_maintitle, 42, SpringLayout.SOUTH, pn_logo);
		sl_pn_contents.putConstraint(SpringLayout.WEST, pn_maintitle, 137, SpringLayout.WEST, pn_contents);
		sl_pn_contents.putConstraint(SpringLayout.SOUTH, pn_maintitle, 254, SpringLayout.SOUTH, pn_logo);
		sl_pn_contents.putConstraint(SpringLayout.EAST, pn_maintitle, -125, SpringLayout.EAST, pn_contents);
		pn_contents.add(pn_maintitle);
		
		pw_input = new JPasswordField();
		pw_input.setText("sss");
		@SuppressWarnings("deprecation")
		char[] pw = pw_input.getPassword();					//비밀번호입력 GUI기능은 캐릭터형태의 배열로 들어가게끔 되있음
		for (int i = 0; i < pw.length; i++) {				
			System.out.println(pw[i]);
		}
		sl_pn_all.putConstraint(SpringLayout.NORTH, pw_input, 5, SpringLayout.NORTH, pn_all);
		sl_pn_all.putConstraint(SpringLayout.WEST, pw_input, 6, SpringLayout.EAST, id_input);
		sl_pn_all.putConstraint(SpringLayout.SOUTH, pw_input, 32, SpringLayout.NORTH, pn_all);
		sl_pn_all.putConstraint(SpringLayout.EAST, pw_input, 147, SpringLayout.EAST, id_input);
		pn_all.add(pw_input);
		pw_input.setOpaque(false);
		pw_input.setBorder(new MatteBorder(0, 0, 2, 0, (Color) Color.LIGHT_GRAY));

	}
}
