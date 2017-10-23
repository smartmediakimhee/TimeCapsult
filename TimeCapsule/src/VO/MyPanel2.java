package VO;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SpringLayout;
import javax.swing.SwingConstants;
import javax.swing.border.MatteBorder;

import com.DB.Friend_DAO;
import com.DB.Like_DAO;
import com.DB.MemberDAO;

import main.BoardMainGUI;
import main.LoggedIN;
import main.MainGUI;
import main.postGUI;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.GridLayout;
import java.awt.FlowLayout;
import javax.swing.JScrollPane;

public class MyPanel2 extends JPanel {
	public JLabel lbl_title;
	public JLabel lbl_howtime;
	public JLabel lbl_string;
	public JPanel pn_2_weather;
	public JLabel lbl_showtime;
	public ImageIcon icon;
	public JLabel likecount;
	public JPanel pn_like;
	public ImageIcon like;
	public ImageIcon like2;
	private Dimension liked;
	public JLabel lbl_num;
	public JLabel lbl_name;
	private JPanel panel;
	private JPanel panel_1;
	private JPanel panel_2;
	private JPanel panel_3;

	public MyPanel2(SpringLayout sl_pn_scroll, JPanel pn_1) {
		like = new ImageIcon(".\\Image\\grayheart.png");
		like2 = new ImageIcon(".\\Image\\redheart.png");
		setBorder(new MatteBorder(1, 0, 1, 0, (Color) Color.LIGHT_GRAY));
		sl_pn_scroll.putConstraint(SpringLayout.NORTH, this, 38, SpringLayout.SOUTH, pn_1);
		sl_pn_scroll.putConstraint(SpringLayout.WEST, this, 0, SpringLayout.WEST, pn_1);
		sl_pn_scroll.putConstraint(SpringLayout.SOUTH, this, 382, SpringLayout.SOUTH, pn_1);
		sl_pn_scroll.putConstraint(SpringLayout.EAST, this, 643, SpringLayout.WEST, pn_1);

		setOpaque(false);
		setLayout(null);

		lbl_string = new JLabel("\uC5F4\uB9AC\uB294 \uC2DC\uAC04");
		lbl_string.setForeground(Color.GRAY);
		lbl_string.setFont(new Font("a엄마의편지B", Font.BOLD, 12));
		lbl_string.setBounds(0, 315, 99, 18);
		lbl_string.setHorizontalAlignment(SwingConstants.LEFT);
		this.add(lbl_string);

		pn_2_weather = new JPanel() {
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
		pn_2_weather.setBounds(560, 257, 75, 76);
		this.add(pn_2_weather);

		lbl_showtime = new JLabel();
		lbl_showtime.setForeground(Color.GRAY);
		lbl_showtime.setFont(new Font("a엄마의편지B", Font.BOLD, 12));
		lbl_showtime.setBounds(111, 315, 223, 18);
		lbl_string.setHorizontalAlignment(SwingConstants.CENTER);
		this.add(lbl_showtime);

		likecount = new JLabel("1000");
		likecount.setFont(new Font("a엄마의편지B", Font.BOLD, 12));
		likecount.setBounds(491, 317, 43, 15);
		likecount.setHorizontalAlignment(SwingConstants.CENTER);
		add(likecount);

		pn_like = new JPanel() {
			public void paintComponent(Graphics g) {
				// Approach 1: Dispaly image at at full size
				// g.drawImage(like.getImage(), 0, 0, null);
				// Approach 2: Scale image to size of component
				liked = getSize();
				g.drawImage(like.getImage(), 0, 0, liked.width, liked.height, null);
				// Approach 3: Fix the image position in the scroll pane
				// Point p = scrollPane.getViewport().getViewPosition();
				// g.drawImage(icon.getImage(), p.x, p.y, null);
				setOpaque(false); // 그림을 표시하게 설정,투명하게 조절
				super.paintComponent(g);
			}
		};
		pn_like.setBounds(531, 310, 25, 23);
		pn_like.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				new Like_DAO().like(LoggedIN.Logged_in_id, lbl_num.getText());
				System.out.println(LoggedIN.Logged_in_id + "  " + lbl_num.getText());
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				pn_like.setCursor(new Cursor(12));
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				like.setImage(like2.getImage());
			}
		});
		pn_like.setPreferredSize(new Dimension(20, 30));

		add(pn_like);

		panel = new JPanel();
		panel.setOpaque(false);
		panel.setBounds(15, 34, 636, 52);
		add(panel);
		panel.setLayout(new GridLayout(1, 0, 0, 0));

		lbl_title = new JLabel();
		panel.add(lbl_title);
		lbl_title.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_title.setFont(new Font("a펜글씨B", Font.PLAIN, 30));

		panel_1 = new JPanel();
		panel_1.setOpaque(false);
		panel_1.setBounds(15, 96, 636, 181);
		add(panel_1);
		panel_1.setLayout(new GridLayout(1, 0, 0, 0));

		lbl_howtime = new JLabel();
		panel_1.add(lbl_howtime);
		lbl_howtime.setForeground(Color.GRAY);
		lbl_howtime.setOpaque(false);
		lbl_howtime.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_howtime.setFont(new Font("a엄마의편지B", Font.ITALIC, 18));
		lbl_howtime.setBackground(Color.WHITE);

		panel_2 = new JPanel();
		panel_2.setOpaque(false);
		FlowLayout flowLayout = (FlowLayout) panel_2.getLayout();
		flowLayout.setAlignment(FlowLayout.LEFT);
		panel_2.setBounds(15, 11, 131, 25);
		add(panel_2);
		
		JLabel lblNo = new JLabel("No_");
		lblNo.setForeground(Color.GRAY);
		lblNo.setFont(new Font("a엄마의편지B", Font.BOLD, 12));
		panel_2.add(lblNo);

		lbl_num = new JLabel("No_1");
		panel_2.add(lbl_num);
		lbl_num.setHorizontalAlignment(SwingConstants.LEFT);
		lbl_num.setForeground(Color.GRAY);
		lbl_num.setFont(new Font("a엄마의편지B", Font.BOLD, 12));

		panel_3 = new JPanel();
		panel_3.setOpaque(false);
		FlowLayout flowLayout_1 = (FlowLayout) panel_3.getLayout();
		flowLayout_1.setHgap(10);
		flowLayout_1.setAlignment(FlowLayout.RIGHT);
		panel_3.setBounds(504, 11, 147, 26);
		add(panel_3);

		lbl_name = new JLabel();
		lbl_name.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(new Friend_DAO().add(LoggedIN.Logged_in_id, new MemberDAO().selectMember_byname(lbl_name.getText()))) {
					JOptionPane.showMessageDialog(null, lbl_name.getText() + "님이 친구로 등록되었습니다!");
					BoardMainGUI.isok=true;
				}else {
					JOptionPane.showMessageDialog(null, "이미 등록한 친구거나 사소한 에러로 친구추가 실패햇시유...");
				}
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				lbl_name.setCursor(new Cursor(12));
			}
		});
		panel_3.add(lbl_name);
		lbl_name.setHorizontalAlignment(SwingConstants.RIGHT);
		lbl_name.setForeground(Color.GRAY);
		lbl_name.setFont(new Font("a엄마의편지B", Font.BOLD, 12));
	}

	public void get_icon(String str) {
		icon = new ImageIcon(str);
		Image originImg = icon.getImage();
		Image changedImg = originImg.getScaledInstance(90, 90, Image.SCALE_SMOOTH);
		icon = new ImageIcon(changedImg);
	}
}
