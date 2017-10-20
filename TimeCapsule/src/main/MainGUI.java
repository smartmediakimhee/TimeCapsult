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

public class MainGUI {
	JScrollPane scrollPane;
	ImageIcon icon;
	ImageIcon icon2;
	ImageIcon Mainicon;
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
		Mainicon = new ImageIcon(".\\Image\\back.jpg");
		icon = new ImageIcon(".\\Image\\1.png");
		icon2 = new ImageIcon(".\\Image\\2.png");
		frame = new JFrame();
		frame.setBounds(0, 0, 1920, 1040);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JPanel panel = new JPanel() {
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
				BoardMainGUI bmgui = new BoardMainGUI();
				
				Board_1_DAO b1 = new Board_1_DAO();
				MemberDAO md = new MemberDAO();
				
				
				String email = id_input.getText();
				String pw = pw_input.getText();
				
				MemberDTO mt = md.selectMember(email);
				
				if(md==null) {//입력된 값이 DB 에 없을경우
					System.out.println("입력된 값이 DB에 존재하지 않습니다");

				} else {
					System.out.println();
					System.out.println(mt.getEmail());
					System.out.println(mt.getPw());
					System.out.println(mt.getName());
					System.out.println(mt.getId());
				}


				if (mt.getPw().equals(pw)) {
					bmgui.main(null);
				} else {
					JOptionPane.showMessageDialog(null, "이메일과 패스워드를 확인하세요.");

					
				}
				
				
				
				
			}
			@Override
			public void mouseEntered(MouseEvent arg0) {
				lbl_login.setCursor(new Cursor(12));			}
			
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
				jg.main(null);//버튼누르면 회원가입창 띄우고
				frame.dispose();//버튼누르고 창을 뛰웠을때 원래 창을 끝내는것
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
		sl_panel.putConstraint(SpringLayout.NORTH, id_input, 5, SpringLayout.NORTH, panel);
		sl_panel.putConstraint(SpringLayout.WEST, id_input, 1037, SpringLayout.WEST, panel);
		sl_panel.putConstraint(SpringLayout.EAST, id_input, -708, SpringLayout.EAST, panel);
		
		id_input.setOpaque(false);
		panel.add(id_input);
		id_input.setColumns(10);
		id_input.setBorder(new MatteBorder(0, 0, 2, 0, (Color) Color.LIGHT_GRAY));
		
		JPanel panel_1 = new JPanel();
		sl_panel.putConstraint(SpringLayout.NORTH, panel_1, 92, SpringLayout.NORTH, panel);
		sl_panel.putConstraint(SpringLayout.SOUTH, id_input, -60, SpringLayout.NORTH, panel_1);
		panel_1.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(192, 192, 192)));
		sl_panel.putConstraint(SpringLayout.WEST, panel_1, 677, SpringLayout.WEST, panel);
		sl_panel.putConstraint(SpringLayout.SOUTH, panel_1, 734, SpringLayout.NORTH, panel);
		sl_panel.putConstraint(SpringLayout.EAST, panel_1, -606, SpringLayout.EAST, panel);
		panel.add(panel_1);
		SpringLayout sl_panel_1 = new SpringLayout();
		panel_1.setLayout(sl_panel_1);
		panel_1.setOpaque(false);
		
		JPanel pn_img1 = new JPanel() {
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
		sl_panel_1.putConstraint(SpringLayout.NORTH, pn_img1, 10, SpringLayout.NORTH, panel_1);
		sl_panel_1.putConstraint(SpringLayout.WEST, pn_img1, 247, SpringLayout.WEST, panel_1);
		sl_panel_1.putConstraint(SpringLayout.EAST, pn_img1, -263, SpringLayout.EAST, panel_1);
		sl_panel.putConstraint(SpringLayout.NORTH, pn_img1, 90, SpringLayout.NORTH, panel);
		sl_panel.putConstraint(SpringLayout.WEST, pn_img1, 116, SpringLayout.EAST, panel_1);
		sl_panel.putConstraint(SpringLayout.EAST, pn_img1, -970, SpringLayout.EAST, panel);
		panel_1.add(pn_img1);
		
		JLabel lbl_main = new JLabel("T I M E");
		sl_panel_1.putConstraint(SpringLayout.NORTH, lbl_main, 79, SpringLayout.NORTH, panel_1);
		sl_panel_1.putConstraint(SpringLayout.SOUTH, pn_img1, -6, SpringLayout.NORTH, lbl_main);
		sl_panel_1.putConstraint(SpringLayout.WEST, lbl_main, 204, SpringLayout.WEST, panel_1);
		sl_panel.putConstraint(SpringLayout.SOUTH, pn_img1, -52, SpringLayout.NORTH, lbl_main);
		sl_panel.putConstraint(SpringLayout.NORTH, lbl_main, 231, SpringLayout.NORTH, panel);
		sl_panel.putConstraint(SpringLayout.WEST, lbl_main, 755, SpringLayout.WEST, panel);
		panel_1.add(lbl_main);
		lbl_main.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_main.setFont(new Font("굴림", Font.PLAIN, 60));
		
		JLabel lblCAP = new JLabel("C A P S U L E");
		sl_panel_1.putConstraint(SpringLayout.NORTH, lblCAP, 6, SpringLayout.SOUTH, lbl_main);
		sl_panel_1.putConstraint(SpringLayout.WEST, lblCAP, 107, SpringLayout.WEST, panel_1);
		sl_panel.putConstraint(SpringLayout.NORTH, lblCAP, 17, SpringLayout.SOUTH, lbl_main);
		sl_panel.putConstraint(SpringLayout.WEST, lblCAP, 660, SpringLayout.WEST, panel);
		panel_1.add(lblCAP);
		lblCAP.setHorizontalAlignment(SwingConstants.CENTER);
		lblCAP.setFont(new Font("굴림", Font.PLAIN, 60));
		
		JPanel pn_img2 = new JPanel() {
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
		sl_panel_1.putConstraint(SpringLayout.NORTH, pn_img2, 284, SpringLayout.SOUTH, lblCAP);
		sl_panel_1.putConstraint(SpringLayout.WEST, pn_img2, 261, SpringLayout.WEST, panel_1);
		sl_panel_1.putConstraint(SpringLayout.SOUTH, pn_img2, -42, SpringLayout.SOUTH, panel_1);
		sl_panel_1.putConstraint(SpringLayout.EAST, pn_img2, 0, SpringLayout.EAST, pn_img1);
		sl_panel.putConstraint(SpringLayout.NORTH, pn_img2, 41, SpringLayout.SOUTH, lblCAP);
		sl_panel.putConstraint(SpringLayout.WEST, pn_img2, 123, SpringLayout.EAST, panel_1);
		sl_panel.putConstraint(SpringLayout.SOUTH, pn_img2, -486, SpringLayout.SOUTH, panel);
		sl_panel.putConstraint(SpringLayout.EAST, pn_img2, -995, SpringLayout.EAST, panel);
		panel_1.add(pn_img2);
		
		pw_input = new JPasswordField();
		sl_panel.putConstraint(SpringLayout.WEST, lbl_login, 6, SpringLayout.EAST, pw_input);
		sl_panel.putConstraint(SpringLayout.WEST, pw_input, 1202, SpringLayout.WEST, panel);
		sl_panel.putConstraint(SpringLayout.NORTH, pw_input, 5, SpringLayout.NORTH, panel);
		sl_panel.putConstraint(SpringLayout.SOUTH, pw_input, 32, SpringLayout.NORTH, panel);
		sl_panel.putConstraint(SpringLayout.EAST, pw_input, 147, SpringLayout.EAST, id_input);
		panel.add(pw_input);
		pw_input.setOpaque(false);
		pw_input.setBorder(new MatteBorder(0, 0, 2, 0, (Color) Color.LIGHT_GRAY));

	}
}
