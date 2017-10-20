package main;

import java.awt.BorderLayout;
import java.awt.Color;
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

public class JoinGUI {
	JScrollPane scrollPane;
	ImageIcon icon;
	ImageIcon icon2;
	private JFrame frame;
	private JTextField txtHwanavercom;
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
	}

	/**
	 * Initialize the contents of the frame.
	 */

	private void initialize() {
		icon = new ImageIcon("D:\\\\박경도\\\\배경.jpg");
		icon2 = new ImageIcon("D:\\\\박경도\\\\배경.jpg");

		frame = new JFrame();
		frame.setBounds(100, 100, 1294, 764);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

		JPanel panel = new JPanel() {
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
				//g.drawImage(icon2.getImage(), -380,-35, null);
				// Approach 2: Scale image to size of component
				// Dimension d = getSize();
				// g.drawImage(icon.getImage(), 0, 0, d.width, d.height, null);
				// Approach 3: Fix the image position in the scroll pane
				// Point p = scrollPane.getViewport().getViewPosition();
				// g.drawImage(icon.getImage(), p.x, p.y, null);
				//setOpaque(false); // 그림을 표시하게 설정,투명하게 조절
				//super.paintComponent(g);
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
		
		JLabel label = new JLabel("________________________");
		label.setForeground(new Color(255, 106, 77));
		label.setBounds(143, 247, 173, 15);
		panel_2.add(label);
		
		JLabel label_1 = new JLabel("____________________");
		label_1.setForeground(new Color(255, 106, 77));
		label_1.setBounds(289, 247, 160, 15);
		panel_2.add(label_1);
		
		txtHwanavercom = new JTextField();
		txtHwanavercom.setBackground(Color.WHITE);
		txtHwanavercom.setToolTipText("");
		txtHwanavercom.setText("hwa7444@naver.com");
		txtHwanavercom.setBounds(143, 228, 269, 21);
		txtHwanavercom.setDocument((new JTextFieldLimit(30)));
		txtHwanavercom.setBorder(javax.swing.BorderFactory.createEmptyBorder());
//		txtHwanavercom.setBackground(new Color(0,0,0,0));
		panel_2.add(txtHwanavercom);
		txtHwanavercom.setColumns(10);
		txtHwanavercom.setOpaque(false);
		
		JLabel label_2 = new JLabel("________________________");
		label_2.setForeground(new Color(255, 106, 77));
		label_2.setBounds(143, 351, 173, 15);
		panel_2.add(label_2);
		
		JLabel label_3 = new JLabel("\uBE44\uBC00\uBC88\uD638");
		label_3.setBounds(143, 307, 57, 15);
		panel_2.add(label_3);
		
		JLabel label_4 = new JLabel("____________________");
		label_4.setForeground(new Color(255, 106, 77));
		label_4.setBounds(289, 351, 160, 15);
		panel_2.add(label_4);
		
		JLabel label_5 = new JLabel("________________________");
		label_5.setForeground(new Color(255, 106, 77));
		label_5.setBounds(143, 460, 173, 15);
		panel_2.add(label_5);
		
		nameInput = new JTextField();
		nameInput.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent arg0) {
				if(arg0.getKeyCode()==10) {
					makeAccount();
				}
			}
		});
		nameInput.setToolTipText("");
		nameInput.setText("\uD2B9\uC218\uBB38\uC790 \uC81C\uC678 8 ~ 12\uC790\uB9AC");
		nameInput.setColumns(10);
		nameInput.setBackground(Color.WHITE);
		nameInput.setBounds(143, 441, 173, 21);
		nameInput.setDocument((new JTextFieldLimit(12)));
		nameInput.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		nameInput.setBackground(new Color(0,0,0,0));
		nameInput.setOpaque(false);
		panel_2.add(nameInput);
		
		JLabel label_6 = new JLabel("\uB2C9\uB124\uC784");
		label_6.setBounds(143, 416, 57, 15);
		panel_2.add(label_6);
		
		JLabel label_7 = new JLabel("____________________");
		label_7.setForeground(new Color(255, 106, 77));
		label_7.setBounds(289, 460, 160, 15);
		panel_2.add(label_7);
		
		JButton btn_JOIN = new JButton("JOIN");
		btn_JOIN.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				makeAccount();
			}

		});
		btn_JOIN.setBorderPainted(false);
		btn_JOIN.setBackground(Color.LIGHT_GRAY);
		btn_JOIN.setBounds(143, 501, 269, 38);
		panel_2.add(btn_JOIN);
		
		pwInput = new JPasswordField(); //비밀번호 입력창
		pwInput.setText("rudeh376");
		pwInput.setBounds(143, 332, 173, 21);
		pwInput.setDocument((new JTextFieldLimit(12)));
		pwInput.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		pwInput.setBackground(new Color(0,0,0,0));
		pwInput.setOpaque(false);

		panel_2.add(pwInput);
	}
	private boolean makeAccount() {
		
		System.out.println();
		
		MemberDAO md = new MemberDAO();
		ArrayList<MemberDTO> container;
		
		String input_email = txtHwanavercom.getText();
		String input_password = pwInput.getText();
		String input_name = nameInput.getText(); 

		container = md.selectAllMember(); 
		System.out.println("기존 사용자를 검색합니다.");

		for (int i = 0; i < container.size(); i++) {
			System.out.println("기존 사용자 중 중복된 이름이 있는지 검사합니다. 입력 :"+input_email);
			System.out.print(container.get(i).getId()+"\t");
			System.out.print(container.get(i).getEmail()+"\t");
			System.out.print(container.get(i).getPw()+"\t");
			System.out.println(container.get(i).getName());
			if(container.get(i).getEmail().equals(input_email)) {
				System.out.println("중복된 이메일을 사용하는 사람이 있습니다.");
				JOptionPane.showMessageDialog(null, "중복된 이메일을 사용하는 사람이 있습니다. false 리턴하고 종료합니다.");
				return false;
			}
		}
		
		
		if(md.insertMember(input_email,input_password,input_name)) {
			System.out.println("ID생성완료");
			return true;
		} else {
			System.out.println("ID생성실패");
			return false;
		}
	}
}
