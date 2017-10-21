package main;

import java.awt.EventQueue;
import java.awt.Graphics;

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
import java.awt.GridLayout;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.CardLayout;

import com.DB.Board_1_DAO;
import com.DB.MemberDAO;
import com.DTO.MemberDTO;
import com.toedter.calendar.JCalendar;
import javax.swing.JComboBox;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JToggleButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.FlowLayout;
import javax.swing.border.LineBorder;
import javax.swing.border.MatteBorder;

public class postGUI {
	JScrollPane scrollPane;
	ImageIcon icon;
	ImageIcon icon2;
	ImageIcon period;
	ImageIcon title;
	ImageIcon content;
	ImageIcon bnt;
	JCalendar calendar;

	ImageIcon back;
	private JFrame frame;
	private JTextField textField;
	private JTextField txt_hour;
	private JTextField txt_minute;
	private JTextField txt_title;
	private JTextField txt_content;
	private JTextField textField_1;
	private static JTextField txtPeriod;
	private static String calendarDate;
	private JCalendar calerdar;

	public static String date = "";

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					postGUI window = new postGUI();
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
	public postGUI() {
		// Logged_in_ID.setText()
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		calendar = new JCalendar();
		back = new ImageIcon("../TimeCapsule/Image/back.jpg");
		icon = new ImageIcon("../TimeCapsule/Image/1.png");
		icon2 = new ImageIcon("../TimeCapsule/Image/2.png");
		period = new ImageIcon("../TimeCapsule/Image/period.png");
		title = new ImageIcon("../TimeCapsule/Image/title.png");
		content = new ImageIcon("../TimeCapsule/Image/content.png");
		bnt = new ImageIcon("../TimeCapsule/Image/bnt.png");
		frame = new JFrame();
		frame.setBounds(0, 0, 1920, 1040);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JPanel panel_big = new JPanel() {
			public void paintComponent(Graphics g) {
				// Approach 1: Dispaly image at at full size
				g.drawImage(back.getImage(), 0, 0, null);
				// Approach 2: Scale image to size of component

				Dimension d = getSize();
				g.drawImage(back.getImage(), 0, 0, d.width, d.height, null);
				// Approach 3: Fix the image position in the scroll pane
				// Point p = scrollPane.getViewport().getViewPosition();
				// g.drawImage(icon.getImage(), p.x, p.y, null);
				setOpaque(false); // 그림을 표시하게 설정,투명하게 조절
				super.paintComponent(g);
			}
		};
		panel_big.setBackground(Color.WHITE);
		frame.getContentPane().add(panel_big, BorderLayout.CENTER);
		SpringLayout sl_panel_big = new SpringLayout();
		panel_big.setLayout(sl_panel_big);

		JLabel lbl_login = new JLabel("\uB2D8");
		sl_panel_big.putConstraint(SpringLayout.NORTH, lbl_login, 10, SpringLayout.NORTH, panel_big);
		panel_big.add(lbl_login);

		JLabel lbl_sign = new JLabel("log out");
		lbl_sign.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				MainGUI main = new MainGUI();
				main.main(null);
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				lbl_sign.setCursor(new Cursor(12));
			}
		});
		sl_panel_big.putConstraint(SpringLayout.EAST, lbl_login, -45, SpringLayout.WEST, lbl_sign);
		sl_panel_big.putConstraint(SpringLayout.NORTH, lbl_sign, 10, SpringLayout.NORTH, panel_big);
		sl_panel_big.putConstraint(SpringLayout.EAST, lbl_sign, -35, SpringLayout.EAST, panel_big);
		panel_big.add(lbl_sign);

		JPanel pn_underimg = new JPanel() {
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
		sl_panel_big.putConstraint(SpringLayout.NORTH, pn_underimg, 816, SpringLayout.SOUTH, lbl_sign);
		sl_panel_big.putConstraint(SpringLayout.SOUTH, pn_underimg, -31, SpringLayout.SOUTH, panel_big);
		sl_panel_big.putConstraint(SpringLayout.EAST, pn_underimg, -35, SpringLayout.EAST, panel_big);
		panel_big.add(pn_underimg);

		JPanel pn_small = new JPanel();
		sl_panel_big.putConstraint(SpringLayout.SOUTH, pn_small, -31, SpringLayout.SOUTH, panel_big);
		sl_panel_big.putConstraint(SpringLayout.EAST, pn_small, -240, SpringLayout.EAST, panel_big);
		sl_panel_big.putConstraint(SpringLayout.WEST, pn_underimg, 54, SpringLayout.EAST, pn_small);
		pn_small.setBorder(new LineBorder(Color.GRAY, 2));
		pn_small.setBackground(new Color(255, 0, 0, 0));
		panel_big.add(pn_small);
		SpringLayout sl_pn_small = new SpringLayout();
		pn_small.setLayout(sl_pn_small);

		textField = new JTextField();
		pn_small.add(textField);
		textField.setColumns(10);

		txt_hour = new JTextField();
		sl_pn_small.putConstraint(SpringLayout.NORTH, txt_hour, 269, SpringLayout.NORTH, pn_small);
		sl_pn_small.putConstraint(SpringLayout.EAST, textField, -6, SpringLayout.WEST, txt_hour);
		sl_pn_small.putConstraint(SpringLayout.WEST, txt_hour, 822, SpringLayout.WEST, pn_small);
		txt_hour.setHorizontalAlignment(SwingConstants.CENTER);
		txt_hour.setText("hour");
		txt_hour.setColumns(10);
		pn_small.add(txt_hour);

		txt_minute = new JTextField();
		sl_pn_small.putConstraint(SpringLayout.NORTH, txt_minute, 269, SpringLayout.NORTH, pn_small);
		sl_pn_small.putConstraint(SpringLayout.EAST, txt_hour, -8, SpringLayout.WEST, txt_minute);
		sl_pn_small.putConstraint(SpringLayout.WEST, txt_minute, 968, SpringLayout.WEST, pn_small);
		sl_pn_small.putConstraint(SpringLayout.EAST, txt_minute, -277, SpringLayout.EAST, pn_small);
		txt_minute.setText("minute");
		txt_minute.setHorizontalAlignment(SwingConstants.CENTER);
		txt_minute.setColumns(10);
		pn_small.add(txt_minute);

		txt_title = new JTextField();
		sl_pn_small.putConstraint(SpringLayout.NORTH, textField, 43, SpringLayout.SOUTH, txt_title);
		sl_pn_small.putConstraint(SpringLayout.SOUTH, textField, -12, SpringLayout.NORTH, txt_title);
		sl_pn_small.putConstraint(SpringLayout.SOUTH, txt_minute, -15, SpringLayout.NORTH, txt_title);
		sl_pn_small.putConstraint(SpringLayout.SOUTH, txt_hour, -13, SpringLayout.NORTH, txt_title);
		sl_pn_small.putConstraint(SpringLayout.EAST, txt_title, -277, SpringLayout.EAST, pn_small);
		sl_pn_small.putConstraint(SpringLayout.NORTH, txt_title, 315, SpringLayout.NORTH, pn_small);
		txt_title.setHorizontalAlignment(SwingConstants.CENTER);
		txt_title.setText("title");
		txt_title.setColumns(10);
		pn_small.add(txt_title);

		txt_content = new JTextField();
		sl_pn_small.putConstraint(SpringLayout.EAST, txt_content, -277, SpringLayout.EAST, pn_small);
		sl_pn_small.putConstraint(SpringLayout.SOUTH, txt_title, -15, SpringLayout.NORTH, txt_content);
		sl_pn_small.putConstraint(SpringLayout.NORTH, txt_content, 361, SpringLayout.NORTH, pn_small);
		sl_pn_small.putConstraint(SpringLayout.SOUTH, txt_content, -289, SpringLayout.SOUTH, pn_small);
		txt_content.setText("content");
		txt_content.setHorizontalAlignment(SwingConstants.CENTER);
		txt_content.setColumns(10);
		pn_small.add(txt_content);

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
		sl_panel_big.putConstraint(SpringLayout.WEST, pn_small, 6, SpringLayout.EAST, pn_logo);
		sl_panel_big.putConstraint(SpringLayout.WEST, pn_logo, 69, SpringLayout.WEST, panel_big);
		sl_panel_big.putConstraint(SpringLayout.SOUTH, pn_logo, 270, SpringLayout.NORTH, panel_big);
		sl_panel_big.putConstraint(SpringLayout.EAST, pn_logo, -1629, SpringLayout.EAST, panel_big);

		JPanel panel_period = new JPanel() {
			public void paintComponent(Graphics g) {
				// Approach 1: Dispaly image at at full size
				g.drawImage(period.getImage(), 0, 0, null);
				// Approach 2: Scale image to size of component

				// Dimension d = getSize();
				// g.drawImage(font.getImage(), 0, 0, d.width, d.height, null);
				// Approach 3: Fix the image position in the scroll pane
				// Point p = scrollPane.getViewport().getViewPosition();
				// g.drawImage(icon.getImage(), p.x, p.y, null);
				setOpaque(false); // 그림을 표시하게 설정,투명하게 조절
				super.paintComponent(g);
			}
		};

		sl_pn_small.putConstraint(SpringLayout.WEST, textField, 26, SpringLayout.EAST, panel_period);
		sl_pn_small.putConstraint(SpringLayout.SOUTH, panel_period, -582, SpringLayout.SOUTH, pn_small);
		sl_pn_small.putConstraint(SpringLayout.WEST, panel_period, 301, SpringLayout.WEST, pn_small);
		sl_pn_small.putConstraint(SpringLayout.EAST, panel_period, -1024, SpringLayout.EAST, pn_small);
		sl_pn_small.putConstraint(SpringLayout.NORTH, panel_period, 269, SpringLayout.NORTH, pn_small);
		pn_small.add(panel_period);

		JPanel panel_title = new JPanel() {
			public void paintComponent(Graphics g) {
				// Approach 1: Dispaly image at at full size
				g.drawImage(title.getImage(), 0, 0, null);
				// Approach 2: Scale image to size of component

				// Dimension d = getSize();
				// g.drawImage(title.getImage(), 0, 0, d.width, d.height, null);
				// Approach 3: Fix the image position in the scroll pane
				// Point p = scrollPane.getViewport().getViewPosition();
				// g.drawImage(icon.getImage(), p.x, p.y, null);
				setOpaque(false); // 그림을 표시하게 설정,투명하게 조절
				super.paintComponent(g);
			}
		};
		sl_pn_small.putConstraint(SpringLayout.WEST, txt_title, 26, SpringLayout.EAST, panel_title);
		sl_pn_small.putConstraint(SpringLayout.NORTH, panel_title, 15, SpringLayout.SOUTH, panel_period);
		sl_pn_small.putConstraint(SpringLayout.WEST, panel_title, 301, SpringLayout.WEST, pn_small);
		sl_pn_small.putConstraint(SpringLayout.EAST, panel_title, -1024, SpringLayout.EAST, pn_small);
		pn_small.add(panel_title);

		JPanel panel_content = new JPanel() {
			public void paintComponent(Graphics g) {
				// Approach 1: Dispaly image at at full size
				g.drawImage(content.getImage(), 0, 0, null);
				// Approach 2: Scale image to size of component

				// Dimension d = getSize();
				// g.drawImage(content.getImage(), 0, 0, d.width, d.height, null);
				// Approach 3: Fix the image position in the scroll pane
				// Point p = scrollPane.getViewport().getViewPosition();
				// g.drawImage(icon.getImage(), p.x, p.y, null);
				setOpaque(false); // 그림을 표시하게 설정,투명하게 조절
				super.paintComponent(g);
			}
		};
		sl_pn_small.putConstraint(SpringLayout.SOUTH, panel_title, -15, SpringLayout.NORTH, panel_content);
		sl_pn_small.putConstraint(SpringLayout.WEST, txt_content, 26, SpringLayout.EAST, panel_content);
		sl_pn_small.putConstraint(SpringLayout.SOUTH, panel_content, -490, SpringLayout.SOUTH, pn_small);
		sl_pn_small.putConstraint(SpringLayout.NORTH, panel_content, 0, SpringLayout.NORTH, txt_content);
		sl_pn_small.putConstraint(SpringLayout.WEST, panel_content, 301, SpringLayout.WEST, pn_small);
		sl_pn_small.putConstraint(SpringLayout.EAST, panel_content, -1024, SpringLayout.EAST, pn_small);
		pn_small.add(panel_content);
		;

		JButton btn_in = new JButton(new ImageIcon("./Image/btn.png"));
		btn_in.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				Board_1_DAO b1 = new Board_1_DAO();

				String hour = txt_hour.getText();
				String minute = txt_minute.getText();
				String title = txt_title.getText();
				String content = txt_content.getText();

				String settime = date + " " + hour + ":" + minute + ":00";
				b1.insertBoard_1(title, content, settime);

			}
		});
		btn_in.setBackground(new Color(240, 240, 240));
		sl_pn_small.putConstraint(SpringLayout.NORTH, btn_in, 69, SpringLayout.SOUTH, txt_content);
		sl_pn_small.putConstraint(SpringLayout.WEST, btn_in, 638, SpringLayout.WEST, pn_small);
		sl_pn_small.putConstraint(SpringLayout.SOUTH, btn_in, 108, SpringLayout.SOUTH, txt_content);
		sl_pn_small.putConstraint(SpringLayout.EAST, btn_in, -530, SpringLayout.EAST, pn_small);
		btn_in.setBorderPainted(false);
		btn_in.setText("in");
		pn_small.add(btn_in);

		textField_1 = new JTextField();
		textField_1.setText("hour");
		textField_1.setHorizontalAlignment(SwingConstants.CENTER);
		textField_1.setColumns(10);
		pn_small.add(textField_1);

		txtPeriod = new JTextField();
		sl_pn_small.putConstraint(SpringLayout.NORTH, txtPeriod, 269, SpringLayout.NORTH, pn_small);
		sl_pn_small.putConstraint(SpringLayout.SOUTH, txtPeriod, -13, SpringLayout.NORTH, txt_title);
		txtPeriod.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent arg0) {
				JCal cal = new JCal();
				cal.main(null);
				txtPeriod.setText(calendarDate);
			}
		});
		txtPeriod.setHorizontalAlignment(SwingConstants.CENTER);
		txtPeriod.setText("period");
		sl_pn_small.putConstraint(SpringLayout.WEST, txtPeriod, -439, SpringLayout.WEST, txt_hour);
		sl_pn_small.putConstraint(SpringLayout.EAST, txtPeriod, -15, SpringLayout.WEST, txt_hour);
		pn_small.add(txtPeriod);
		txtPeriod.setColumns(10);
		sl_panel_big.putConstraint(SpringLayout.NORTH, pn_logo, 89, SpringLayout.NORTH, panel_big);
		panel_big.add(pn_logo);

		JPanel pn_nickname = new JPanel();
		sl_panel_big.putConstraint(SpringLayout.NORTH, pn_small, 64, SpringLayout.SOUTH, pn_nickname);
		pn_nickname.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
		sl_panel_big.putConstraint(SpringLayout.NORTH, pn_nickname, 3, SpringLayout.NORTH, panel_big);
		sl_panel_big.putConstraint(SpringLayout.WEST, pn_nickname, -142, SpringLayout.WEST, lbl_login);
		sl_panel_big.putConstraint(SpringLayout.SOUTH, pn_nickname, 0, SpringLayout.SOUTH, lbl_login);
		sl_panel_big.putConstraint(SpringLayout.EAST, pn_nickname, -6, SpringLayout.WEST, lbl_login);
		panel_big.add(pn_nickname);
		pn_nickname.setOpaque(false);
		SpringLayout sl_pn_nickname = new SpringLayout();
		pn_nickname.setLayout(sl_pn_nickname);

		JLabel logged_in_ID = new JLabel(LoggedIN.getInfo().getName());// DB에 있는 로그인한 id 불러오기
		logged_in_ID.setHorizontalAlignment(SwingConstants.CENTER);
		sl_pn_nickname.putConstraint(SpringLayout.NORTH, logged_in_ID, 0, SpringLayout.NORTH, pn_nickname);
		sl_pn_nickname.putConstraint(SpringLayout.WEST, logged_in_ID, 0, SpringLayout.WEST, pn_nickname);
		sl_pn_nickname.putConstraint(SpringLayout.SOUTH, logged_in_ID, 21, SpringLayout.NORTH, pn_nickname);
		sl_pn_nickname.putConstraint(SpringLayout.EAST, logged_in_ID, 136, SpringLayout.WEST, pn_nickname);
		pn_nickname.add(logged_in_ID);

		logged_in_ID.setText(logged_in_ID.getName());
		SimpleDateFormat format = new SimpleDateFormat("yy-MM-dd hh:mm:ss");

		logged_in_ID.setText(LoggedIN.getInfo().getName());
		txtPeriod.setText(date);

	}

	public static void getDate(String date2) {
		calendarDate = date2;
		txtPeriod.setText(calendarDate);
		
	}

}