package main;

import java.awt.EventQueue;
import java.awt.Graphics;
import javax.swing.JOptionPane;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.SpringLayout;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.border.MatteBorder;

import com.DB.Board_1_DAO;
import com.DB.MemberDAO;
import com.DTO.MemberDTO;

import javax.swing.SwingConstants;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.border.LineBorder;
import javax.swing.JList;
import java.awt.Choice;
import java.awt.List;

public class MainGUI {
	
	JScrollPane scrollPane;
	ImageIcon icon;
	ImageIcon icon2;
	ImageIcon Mainicon;
	ImageIcon title;
	private JFrame frame;
	private JTextField id_input;
	private JPasswordField pw_input;
	Dimension d;

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
		Mainicon = new ImageIcon(".\\Image\\back.jpg");
		icon = new ImageIcon(".\\Image\\1.png");
		icon2 = new ImageIcon(".\\Image\\2.png");
		title = new ImageIcon(".\\Image\\maintitle.png");
		frame = new JFrame();
		frame.setBounds(0, 0, 1920, 1040);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JPanel panel = new JPanel() {
			public void paintComponent(Graphics g) {
				// Approach 1: Dispaly image at at full size
				g.drawImage(Mainicon.getImage(), 0, 0, null);
				// Approach 2: Scale image to size of component
				d = getSize();
				g.drawImage(Mainicon.getImage(), 0, 0, d.width, d.height, null);
				// Approach 3: Fix the image position in the scroll pane
				// Point p = scrollPane.getViewport().getViewPosition();
				// g.drawImage(icon.getImage(), p.x, p.y, null);
				setOpaque(false); // 그림을 표시하게 설정,투명하게 조절
				super.paintComponent(g);
			}
		};
		panel.setBackground(Color.WHITE);
		frame.getContentPane().add(panel, BorderLayout.CENTER);
		SpringLayout sl_panel = new SpringLayout();
		panel.setLayout(sl_panel);

		JLabel lbl_login = new JLabel("IN");
		sl_panel.putConstraint(SpringLayout.NORTH, lbl_login, 10, SpringLayout.NORTH, panel);
		sl_panel.putConstraint(SpringLayout.SOUTH, lbl_login, -970, SpringLayout.SOUTH, panel);
		lbl_login.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_login.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				

				Board_1_DAO b1 = new Board_1_DAO();
				MemberDAO md = new MemberDAO();

				String email = id_input.getText();
				String pw = pw_input.getText();
				
				
				MemberDTO mt = md.selectMember_byEmail(email);
				
				if (mt == null) {// 입력된 값이 DB 에 없을경우
					JOptionPane.showMessageDialog(null, "이메일이 존재하지 않습니다. 이메일을 확인해주세요.");
				} else {
					System.out.println();
					System.out.println(mt.getEmail());
					System.out.println(mt.getPw());
					System.out.println(mt.getName());
					System.out.println(mt.getId());
				}

				if (mt.getPw().equals(pw)) {
					BoardMainGUI bmgui = null;
					LoggedIN.Logged_in_id = (new MemberDAO().selectMember_byEmail(email).getId());
					bmgui.main(null);
					frame.dispose();
					
					
					
				}  else {
					
					JOptionPane.showMessageDialog(null, "이메일과 패스워드를 확인하세요.");

				}

			}

			@Override
			public void mouseEntered(MouseEvent arg0) {
				lbl_login.setCursor(new Cursor(12));
			}

		});
		panel.add(lbl_login);

		JLabel lbl_sign = new JLabel("JOIN");
		sl_panel.putConstraint(SpringLayout.EAST, lbl_login, -22, SpringLayout.WEST, lbl_sign);
		sl_panel.putConstraint(SpringLayout.SOUTH, lbl_sign, 0, SpringLayout.SOUTH, lbl_login);
		lbl_sign.setHorizontalAlignment(SwingConstants.CENTER);
		sl_panel.putConstraint(SpringLayout.EAST, lbl_sign, 1504, SpringLayout.WEST, panel);
		lbl_sign.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {

				JoinGUI jg = new JoinGUI();
				jg.main(null);// 버튼누르면 회원가입창 띄우고
				frame.dispose();// 버튼누르고 창을 뛰웠을때 원래 창을 끝내는것
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				lbl_sign.setCursor(new Cursor(12));
			}

		});
		sl_panel.putConstraint(SpringLayout.NORTH, lbl_sign, 10, SpringLayout.NORTH, panel);
		sl_panel.putConstraint(SpringLayout.WEST, lbl_sign, 1445, SpringLayout.WEST, panel);
		panel.add(lbl_sign);

		id_input = new JTextField();
		id_input.setDocument((new JTextFieldLimit(20)));
		sl_panel.putConstraint(SpringLayout.NORTH, id_input, 5, SpringLayout.NORTH, panel);
		id_input.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent arg0) {
				for (int i = 0; i < 1; i++) {
					if (id_input.getText().equals("아이디 입력")) {
						id_input.setText("");
					}
				}
			}
		});

		id_input.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				if (id_input.getText().length() == 0) {
					id_input.setText("아이디 입력");
				}
			}

		});
		id_input.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (id_input.getText().equals("아이디 입력")) {
					id_input.setText("");
				}
			}
		});
		sl_panel.putConstraint(SpringLayout.WEST, id_input, 1037, SpringLayout.WEST, panel);
		sl_panel.putConstraint(SpringLayout.EAST, id_input, -708, SpringLayout.EAST, panel);
		id_input.setText("\uC544\uC774\uB514 \uC785\uB825");// 아이디 입력하는곳

		id_input.setOpaque(false);
		panel.add(id_input);
		id_input.setColumns(10);
		id_input.setBorder(new MatteBorder(0, 0, 2, 0, (Color) Color.LIGHT_GRAY));

		JPanel panel_1 = new JPanel();
		sl_panel.putConstraint(SpringLayout.SOUTH, id_input, -46, SpringLayout.NORTH, panel_1);
		sl_panel.putConstraint(SpringLayout.SOUTH, panel_1, -55, SpringLayout.SOUTH, panel);
		sl_panel.putConstraint(SpringLayout.NORTH, panel_1, 78, SpringLayout.NORTH, panel);
		sl_panel.putConstraint(SpringLayout.WEST, panel_1, 677, SpringLayout.WEST, panel);
		sl_panel.putConstraint(SpringLayout.EAST, panel_1, -606, SpringLayout.EAST, panel);
		panel_1.setBorder(new LineBorder(Color.LIGHT_GRAY, 2));
		panel.add(panel_1);
		SpringLayout sl_panel_1 = new SpringLayout();
		panel_1.setLayout(sl_panel_1);
		panel_1.setOpaque(false);

		JPanel pn_img1 = new JPanel() {
			public void paintComponent(Graphics g) {
				// Approach 1: Dispaly image at at full size
				// g.drawImage(icon.getImage(), 0, 0, null);
				// Approach 2: Scale image to size of component
				 d = getSize();
				g.drawImage(icon.getImage(), 0, 0, d.width, d.height, null);
				// Approach 3: Fix the image position in the scroll pane
				// Point p = scrollPane.getViewport().getViewPosition();
				// g.drawImage(icon.getImage(), p.x, p.y, null);
				setOpaque(false); // 그림을 표시하게 설정,투명하게 조절
				super.paintComponent(g);
			}
		};
		sl_panel_1.putConstraint(SpringLayout.NORTH, pn_img1, 38, SpringLayout.NORTH, panel_1);
		sl_panel_1.putConstraint(SpringLayout.WEST, pn_img1, 261, SpringLayout.WEST, panel_1);
		sl_panel_1.putConstraint(SpringLayout.SOUTH, pn_img1, -785, SpringLayout.SOUTH, panel_1);
		sl_panel_1.putConstraint(SpringLayout.EAST, pn_img1, -249, SpringLayout.EAST, panel_1);
		sl_panel.putConstraint(SpringLayout.NORTH, pn_img1, 90, SpringLayout.NORTH, panel);
		sl_panel.putConstraint(SpringLayout.WEST, pn_img1, 116, SpringLayout.EAST, panel_1);
		sl_panel.putConstraint(SpringLayout.EAST, pn_img1, -970, SpringLayout.EAST, panel);
		panel_1.add(pn_img1);

		JPanel pn_img2 = new JPanel() {
			public void paintComponent(Graphics g) {

				// Approach 1: Dispaly image at at full size
				// g.drawImage(icon2.getImage(), 0, 0, null);
				// Approach 2: Scale image to size of component
				d = getSize();
				g.drawImage(icon2.getImage(), 0, 0, d.width, d.height, null);
				// Approach 3: Fix the image position in the scroll pane
				// Point p = scrollPane.getViewport().getViewPosition();
				// g.drawImage(icon.getImage(), p.x, p.y, null);
				setOpaque(false); // 그림을 표시하게 설정,투명하게 조절
				super.paintComponent(g);
			}
		};
		sl_panel_1.putConstraint(SpringLayout.NORTH, pn_img2, 649, SpringLayout.SOUTH, pn_img1);
		sl_panel_1.putConstraint(SpringLayout.WEST, pn_img2, 10, SpringLayout.WEST, pn_img1);
		sl_panel_1.putConstraint(SpringLayout.SOUTH, pn_img2, -42, SpringLayout.SOUTH, panel_1);
		sl_panel_1.putConstraint(SpringLayout.EAST, pn_img2, -253, SpringLayout.EAST, panel_1);
		sl_panel.putConstraint(SpringLayout.WEST, pn_img2, 123, SpringLayout.EAST, panel_1);
		sl_panel.putConstraint(SpringLayout.SOUTH, pn_img2, -486, SpringLayout.SOUTH, panel);
		sl_panel.putConstraint(SpringLayout.EAST, pn_img2, -995, SpringLayout.EAST, panel);
		panel_1.add(pn_img2);
		
		JPanel pn_title = new JPanel() {
			public void paintComponent(Graphics g) {

				// Approach 1: Dispaly image at at full size
				// g.drawImage(icon2.getImage(), 0, 0, null);
				// Approach 2: Scale image to size of component
				d = getSize();
				g.drawImage(title.getImage(), 0, 0, d.width, d.height, null);
				// Approach 3: Fix the image position in the scroll pane
				// Point p = scrollPane.getViewport().getViewPosition();
				// g.drawImage(icon.getImage(), p.x, p.y, null);
				setOpaque(false); // 그림을 표시하게 설정,투명하게 조절
				super.paintComponent(g);
			}
		};
		sl_panel_1.putConstraint(SpringLayout.NORTH, pn_title, 196, SpringLayout.SOUTH, pn_img1);
		sl_panel_1.putConstraint(SpringLayout.WEST, pn_title, -114, SpringLayout.WEST, pn_img1);
		sl_panel_1.putConstraint(SpringLayout.SOUTH, pn_title, 386, SpringLayout.SOUTH, pn_img1);
		sl_panel_1.putConstraint(SpringLayout.EAST, pn_title, -116, SpringLayout.EAST, panel_1);
		panel_1.add(pn_title);

		pw_input = new JPasswordField();
		pw_input.setDocument((new JTextFieldLimit(8)));
		

		pw_input.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				if (pw_input.getText().length() == 0) {
					pw_input.setText("ssssssss");
				}
			}

			@Override
			public void focusGained(FocusEvent arg0) {
				if (pw_input.getText().equals("ssssssss")) {
					pw_input.setText("");
				}
			}
		});
		pw_input.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (pw_input.getText().equals("ssssssss")) {
					pw_input.setText("");
				}
			}
		});
		sl_panel.putConstraint(SpringLayout.WEST, lbl_login, 6, SpringLayout.EAST, pw_input);
		sl_panel.putConstraint(SpringLayout.WEST, pw_input, 1202, SpringLayout.WEST, panel);
		pw_input.setText("ssssssss");
		sl_panel.putConstraint(SpringLayout.NORTH, pw_input, 5, SpringLayout.NORTH, panel);
		sl_panel.putConstraint(SpringLayout.SOUTH, pw_input, 32, SpringLayout.NORTH, panel);
		sl_panel.putConstraint(SpringLayout.EAST, pw_input, 147, SpringLayout.EAST, id_input);
		panel.add(pw_input);
		pw_input.setOpaque(false);
		pw_input.setBorder(new MatteBorder(0, 0, 2, 0, (Color) Color.LIGHT_GRAY));

	}
}
