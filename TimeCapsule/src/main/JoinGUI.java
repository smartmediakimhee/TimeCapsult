package main;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.SystemColor;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.SpringLayout;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

import com.DB.MemberDAO;
import com.DTO.MemberDTO;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import javax.swing.SwingConstants;
import javax.swing.JTextArea;
import java.awt.Font;
import javax.swing.border.MatteBorder;

public class JoinGUI {
	JScrollPane scrollPane;
	ImageIcon icon;
	ImageIcon icon2;
	ImageIcon icon3;
	private JFrame frame;
	private JTextField idInput;
	private JTextField nameInput;
	private JPasswordField pwInput;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JoinGUI window = new JoinGUI();
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
	public JoinGUI() {
		initialize();
		idInput.setForeground(Color.gray);
		idInput.setText("아이디는 20자 이내로 만드세요. ");

		pwInput.setText("ssssssss");
		nameInput.setForeground(Color.gray);
		nameInput.setText("\uD2B9\uC218\uBB38\uC790\uC81C\uC6788~12\uC790\uB9AC");

	}

	/**
	 * Initialize the contents of the frame.
	 */

	private void initialize() {
		icon = new ImageIcon(".\\\\Image\\\\back.jpg");
		icon2 = new ImageIcon(".\\\\Image\\\\back.jpg");
		icon3 = new ImageIcon(".\\Image\\exit.png");

		frame = new JFrame();
		frame.setBounds(100, 100, 1294, 764);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

		JPanel panel = new JPanel() {
			public void paintComponent(Graphics g) {
				// Approach 1: Dispaly image at at full size
//				g.drawImage(icon.getImage(), 0, 0, null);
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
		panel.setBackground(Color.WHITE);
		frame.getContentPane().add(panel, BorderLayout.CENTER);
		SpringLayout sl_panel = new SpringLayout();
		panel.setLayout(sl_panel);

		JPanel panel_1 = new JPanel();
		sl_panel.putConstraint(SpringLayout.NORTH, panel_1, 10, SpringLayout.NORTH, panel);
		sl_panel.putConstraint(SpringLayout.WEST, panel_1, 327, SpringLayout.WEST, panel);
		sl_panel.putConstraint(SpringLayout.SOUTH, panel_1, -7, SpringLayout.SOUTH, panel);
		sl_panel.putConstraint(SpringLayout.EAST, panel_1, -321, SpringLayout.EAST, panel);
		panel_1.setBackground(new Color(255, 0, 0, 0));
		panel_1.setOpaque(false);
		panel_1.setLayout(null);

		TitledBorder oneTb = // 주변 테두리 색을 지정하기 위해 LineBorder사용
				new TitledBorder(new LineBorder(Color.black));
		oneTb.setTitleColor(Color.red); // 타이틀 컬러 지정

		panel_1.setBorder(new LineBorder(SystemColor.activeCaptionBorder, 3));

		panel.add(panel_1);

		JPanel panel_2 = new JPanel() {
			public void paintComponent(Graphics g) {
				// Approach 1: Dispaly image at at full size
				// g.drawImage(icon2.getImage(), -380,-35, null);
				// Approach 2: Scale image to size of component
				// Dimension d = getSize();
				// g.drawImage(icon.getImage(), 0, 0, d.width, d.height, null);
				// Approach 3: Fix the image position in the scroll pane
				// Point p = scrollPane.getViewport().getViewPosition();
				// g.drawImage(icon.getImage(), p.x, p.y, null);
				// setOpaque(false); // 그림을 표시하게 설정,투명하게 조절
				// super.paintComponent(g);
			}
		};

		panel_2.setLayout(null);
		panel_2.setBorder(new LineBorder(SystemColor.activeCaptionBorder, 3));
		panel_2.setBackground(new Color(255, 0, 0, 0));
		panel_2.setOpaque(false);
		panel_2.setBounds(35, 25, 559, 658);
		panel_1.add(panel_2);

		JLabel lblNewLabel = new JLabel("\uC774\uBA54\uC77C");
		lblNewLabel.setBounds(143, 203, 57, 15);
		panel_2.add(lblNewLabel);

		idInput = new JTextField();
		idInput.setFont(new Font("a내손글씨L", Font.PLAIN, 24));
		idInput.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				if (idInput.getText().length() == 0) {
					idInput.setText("아이디는 20자 이내로 만드세요. ");
					idInput.setForeground(Color.gray);
				}
			}
		});
		idInput.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) { // id입력창 누르면 글삭제
				if (idInput.getText().equals("아이디는 20자 이내로 만드세요. ")) {
					idInput.setText("");
					idInput.setForeground(Color.black);

				}
			}
		});
		idInput.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				int i = 0;
				while (i < 2) {
					i++;
					if (idInput.getText().equals("아이디는 20자 이내로 만드세요. ")) {
						idInput.setForeground(Color.BLACK);
						idInput.setText("");
					}

				}
			}
		});
		idInput.setForeground(Color.BLACK);
		idInput.setBackground(Color.WHITE);
		idInput.setToolTipText("");
		idInput.setText("hwa7444@naver.com");
		idInput.setBounds(143, 228, 269, 21);
		idInput.setDocument((new JTextFieldLimit(20)));
		idInput.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		// txtHwanavercom.setBackground(new Color(0,0,0,0));
		panel_2.add(idInput);
		idInput.setColumns(10);
		idInput.setOpaque(false);

		JLabel label_3 = new JLabel("\uBE44\uBC00\uBC88\uD638");
		label_3.setBounds(143, 307, 57, 15);
		panel_2.add(label_3);

		nameInput = new JTextField();
		nameInput.setFont(new Font("a내손글씨L", Font.PLAIN, 24));
		nameInput.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				for (int i = 0; i < 1; i++) {
					if (nameInput.getText().length() == 0) {
						nameInput.setForeground(Color.gray);
						nameInput.setText("특수문자제외8~12자리");
					}
				}

			}
		});
		nameInput.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (nameInput.getText().equals("특수문자제외8~12자리")) {
					nameInput.setForeground(Color.black);
					nameInput.setText("");
				}
			}
		});
		nameInput.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent arg0) {
				if (arg0.getKeyCode() == 10) {
					makeAccount();
				}
			}
		});
		nameInput.setToolTipText("");

		nameInput.setColumns(10);
		nameInput.setBackground(Color.WHITE);
		nameInput.setBounds(143, 441, 173, 21);
		nameInput.setDocument((new JTextFieldLimit(12)));
		nameInput.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		nameInput.setBackground(new Color(0, 0, 0, 0));
		nameInput.setOpaque(false);
		panel_2.add(nameInput);

		JLabel label_6 = new JLabel("\uB2C9\uB124\uC784");
		label_6.setBounds(143, 416, 57, 15);
		panel_2.add(label_6);

		JButton btn_JOIN = new JButton("JOIN");
		btn_JOIN.setOpaque(false);
		btn_JOIN.setFont(new Font("a서당개", Font.PLAIN, 17));
		btn_JOIN.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btn_JOIN.setCursor(new Cursor(12));
				btn_JOIN.setOpaque(true);
				btn_JOIN.setBackground(new Color(255,160,160));
			}
			public void mouseExited(MouseEvent e) {
				
				btn_JOIN.setOpaque(false);
				
			}
			
			
			
			
		});
		btn_JOIN.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				makeAccount();
			}

		});
		btn_JOIN.setBorderPainted(false);
		btn_JOIN.setBackground(Color.LIGHT_GRAY);
		btn_JOIN.setBounds(143, 501, 269, 38);
		panel_2.add(btn_JOIN);
		JLabel lbl_pw = new JLabel("\uBE44\uBC00\uBC88\uD638\uB294 6~8\uC790\uB9AC");
		lbl_pw.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_pw.setForeground(Color.GRAY);
		lbl_pw.setBounds(199, 307, 117, 15);
		panel_2.add(lbl_pw);

		pwInput = new JPasswordField(); // 비밀번호 입력창
		pwInput.setFont(new Font("휴먼옛체", Font.PLAIN, 12));
		pwInput.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				if (pwInput.getText().length() == 0) {
					pwInput.setText("ssssssss");
					lbl_pw.setText("비밀번호는 6~8자리");

				}
			}
		});
		pwInput.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				for (int i = 0; i < 1; i++) {
					if (pwInput.getText().equals("ssssssss")) {
						lbl_pw.setText("");
						pwInput.setText("");
					}
				}
			}
		});
		pwInput.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (pwInput.getText().equals("ssssssss")) {
					lbl_pw.setText("");
					pwInput.setText("");

				}
			}
		});

		pwInput.setForeground(new Color(255, 144, 144));
		pwInput.setEchoChar('♥');
		pwInput.setText("rudeh376");
		pwInput.setBounds(143, 332, 173, 21);
		pwInput.setDocument((new JTextFieldLimit(8)));
		pwInput.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		pwInput.setBackground(new Color(0, 0, 0, 0));
		pwInput.setOpaque(false);

		panel_2.add(pwInput);

		JPanel pn_exit = new JPanel() {
			public void paintComponent(Graphics g) {
				// Approach 1: Dispaly image at at full size
				// g.drawImage(icon3.getImage(), 0, 0, null);
				// Approach 2: Scale image to size of component
				Dimension d = getSize();
				g.drawImage(icon3.getImage(), 0, 0, d.width, d.height, null);
				// Approach 3: Fix the image position in the scroll pane
				// Point p = scrollPane.getViewport().getViewPosition();
				// g.drawImage(icon.getImage(), p.x, p.y, null);
				setOpaque(false); // 그림을 표시하게 설정,투명하게 조절
				super.paintComponent(g);
			}
		};
		pn_exit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				MainGUI main = new MainGUI();
				main.main(null);
				frame.dispose();// 원래창 끄기
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				pn_exit.setCursor(new Cursor(12));
			}
		});
		pn_exit.setBounds(23, 580, 25, 27);
		panel_2.add(pn_exit);

		JPanel panel_3 = new JPanel();
		panel_3.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(255, 162, 162)));
		panel_3.setBounds(143, 246, 269, 10);
		panel_2.add(panel_3);
		panel_3.setOpaque(false);

		JPanel panel_4 = new JPanel();
		panel_4.setOpaque(false);
		panel_4.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(255, 162, 162)));
		panel_4.setBounds(143, 349, 269, 10);
		panel_2.add(panel_4);

		JPanel panel_5 = new JPanel();
		panel_5.setOpaque(false);
		panel_5.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(255, 162, 162)));
		panel_5.setBounds(143, 464, 269, 10);
		panel_2.add(panel_5);

	}

	private boolean makeAccount() {

		System.out.println();

		MemberDAO md = new MemberDAO();
		ArrayList<MemberDTO> container;

		String input_email = idInput.getText();

		String input_password = pwInput.getText();
		String input_name = nameInput.getText();

		container = md.selectAllMember();
		System.out.println("기존 사용자를 검색합니다.");

		for (int i = 0; i < container.size(); i++) {
			System.out.println("기존 사용자 중 중복된 이름이 있는지 검사합니다. 입력 :" + input_email);
			System.out.print(container.get(i).getId() + "\t");
			System.out.print(container.get(i).getEmail() + "\t");
			System.out.print(container.get(i).getPw() + "\t");
			System.out.println(container.get(i).getName());
			if (container.get(i).getEmail().equals(input_email)) {
				System.out.println("중복된 이메일을 사용하는 사람이 있습니다.");
				JOptionPane.showMessageDialog(null, "중복된 이메일을 사용하는 사람이 있습니다. false 리턴하고 종료합니다.");
				return false;
			}
		}

		if (md.insertMember(input_email, input_password, input_name)) {
			System.out.println("ID생성완료");
			return true;
		} else {
			System.out.println("ID생성실패");
			return false;
		}
	}
}
