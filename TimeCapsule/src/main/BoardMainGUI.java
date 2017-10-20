package main;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SpringLayout;
import javax.swing.border.LineBorder;

import com.DB.Board_1_DAO;
import com.DTO.Board_1_DTO;

import VO.MyPanel;
import VO.MyPanel2;
import function.Mytimer;

public class BoardMainGUI implements Runnable {
	JScrollPane scrollPane;
	private ImageIcon icon;
	private ImageIcon icon2;
	private JFrame frame;
	private ImageIcon icon3;
	private Boolean b = false;
	private Thread thread;

	private static ArrayList<Board_1_DTO> board_Arr = new ArrayList<>();
	private static ArrayList<MyPanel2> panelArr = new ArrayList<>();

	private static Board_1_DAO board_1_DAO = new Board_1_DAO();
	private static Mytimer timer = new Mytimer();
	MyPanel pn_1;

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
		icon = new ImageIcon("Image\\back.jpg");
		icon2 = new ImageIcon("Image\\1.png");
		icon3 = new ImageIcon("Image\\icon2.png");
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
				setOpaque(false); // �׸��� ǥ���ϰ� ����,�����ϰ� ����
				super.paintComponent(g);
			}
		};

		frame.getContentPane().add(panel_big, BorderLayout.CENTER);
		SpringLayout sl_panel_big = new SpringLayout();
		panel_big.setLayout(sl_panel_big);

		JLabel lbl_log_id = new JLabel(LoggedIN.getInfo().getName());
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
		lbl_sign.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				MainGUI main = new MainGUI();
				main.main(null);
				frame.dispose();
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				lbl_sign.setCursor(new Cursor(12));
			}
		});

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
				setOpaque(false); // �׸��� ǥ���ϰ� ����,�����ϰ� ����
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
				setOpaque(false); // �׸��� ǥ���ϰ� ����,�����ϰ� ����

				super.paintComponent(g);

			}
		};
		pn_img2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				postGUI post = new postGUI();
				post.main(null);
				frame.dispose();
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				pn_img2.setCursor(new Cursor(12));
			}
		});

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
		// ��ũ���� ����
		JPanel panel_ex = new JPanel();// ��ũ���ҿ� ���� �г� ����
		Dimension size = new Dimension();// ����� �����ϱ� ���� ��ü ����
		// size.setSize(10, 382*4);// ��ü�� ����� ����
		size.setSize(10, panelsHeightSize(4)); // panelHeightSize(int count) ���� count �� ��ε��� ��� ArrayList�� size ���̴�.
		pn_scroll.setPreferredSize(size);// ������ ������ ������ �ִ� ��ü�� �̿��� �г��� ������ ����
		scrollPane_1.setViewportView(pn_scroll);
		pn_scroll.setSize(450, 200);
		SpringLayout sl_pn_scroll = new SpringLayout();
		pn_scroll.setLayout(sl_pn_scroll);

		///// �Խ���1����

		// �Խ���1�гλ���!
		pn_1 = new MyPanel(pn_scroll, sl_pn_scroll);
		pn_scroll.add(pn_1); // ��ũ���гο� �г�1�� ���� ���ǰ����� �߰�
		scrollPane_1.getVerticalScrollBar().setUnitIncrement(30);
		JPanel target = pn_1;

		///// // �Խ��� 2..
		board_Arr = board_1_DAO.selectAllBoard1();
		for (int i = 0; i < board_Arr.size(); i++) {
			panelArr.add(new MyPanel2(sl_pn_scroll, target));
			pn_scroll.add(panelArr.get(i));
			target = panelArr.get(i);
		}

		size.setSize(10, panelsHeightSize(board_Arr.size()));

		// pn_2.setOpaque(false);
		scrollPane_1.getVerticalScrollBar().setUnitIncrement(30);

		scrollPane_1.getVerticalScrollBar().setUnitIncrement(30);

		thread = new Thread(this);
		thread.start();
	}

	private int panelsHeightSize(int count) {

		return count * 382;
	}

	private void Show() {
		Date nowDate = new Date();

		for (int i = 0; i < board_Arr.size(); i++) {
			Date setDate = null;
			StringBuffer sb = new StringBuffer(board_Arr.get(i).getContent());

			try {
				setDate = timer.stringToDate(board_Arr.get(i).getSettime());
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if (i == 0) {
				pn_1.lbl_title.setText(board_Arr.get(i).getTitle());

				if (!timer.isOpen(nowDate, setDate)) {
					pn_1.pn_1_howtime.setText(timer.howOpen(nowDate, setDate));
				} else {
					for (int j = 0; j < sb.length(); j++) {
						if(j==0) {
							sb.insert(0, "<html>");
						}
						if (j % 25 == 0 && j != 0) {
							sb.insert(j, "<br>");
						}
						if (j==sb.length()) {
							sb.insert(j-1, "</html>");
						}
					}
					System.out.println(sb.toString());
					pn_1.pn_1_howtime.setText(sb.toString());

					// pn_1.pn_1_howtime.setText(board_Arr.get(i).getContent());
				}
				pn_1.lbl_showtime.setText(board_Arr.get(i).getSettime());
				pn_1.get_icon(whereIconsrc("���"));
				
			} else {
				panelArr.get(i - 1).lbl_title.setText(board_Arr.get(i).getTitle());
				panelArr.get(i - 1).lbl_showtime.setText(board_Arr.get(i).getSettime());
				if (!timer.isOpen(nowDate, setDate)) {
					panelArr.get(i - 1).lbl_howtime.setText(timer.howOpen(nowDate, setDate));
				} else {
					panelArr.get(i - 1).lbl_howtime.setText(board_Arr.get(i).getContent());
				}
				panelArr.get(i - 1).get_icon(whereIconsrc("���"));
			}
		}
	}
	
	private String whereIconsrc(String weather) {
		String src = "";
		if(weather.equals("����")) {
			src = "Image\\sun.png";
		}else if(weather.equals("�帲")) {
			src = "Image\\cloud.png";
		}else if(weather.equals("���")) {
			src = "Image\\rain.png";
		}else if(weather.equals("��")) {
			src = "Image\\snow.png";
		}
		System.out.println(src);
		return src;
	}

	
	
	@Override
	public void run() {

		while (true) {

			if (b)
				break;
			Show();
			System.out.println("������ ������");
			try {
				Thread.sleep(1000);
			} catch (Exception e) {
			}
		}

	}
}