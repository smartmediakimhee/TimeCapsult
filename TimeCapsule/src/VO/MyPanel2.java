package VO;

import java.awt.Color;
import java.awt.Cursor;
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
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MyPanel2 extends JPanel {
	public JLabel lbl_title;
	public JLabel lbl_howtime;
	public JLabel lbl_string;
	public JPanel pn_2_weather;
	public JLabel lbl_showtime;
	public ImageIcon icon;
	private JLabel likecount;
	private JPanel pn_like;
	private ImageIcon like;
	private ImageIcon like2;
	private Dimension liked;

	public MyPanel2(SpringLayout sl_pn_scroll, JPanel pn_1) {
		like = new ImageIcon(".\\Image\\blue.png");
		like2 = new ImageIcon(".\\Image\\blackheart.png");
		setBorder(new MatteBorder(1, 0, 1, 0, (Color) Color.LIGHT_GRAY));
		sl_pn_scroll.putConstraint(SpringLayout.NORTH, this, 38, SpringLayout.SOUTH, pn_1);
		sl_pn_scroll.putConstraint(SpringLayout.WEST, this, 0, SpringLayout.WEST, pn_1);
		sl_pn_scroll.putConstraint(SpringLayout.SOUTH, this, 382, SpringLayout.SOUTH, pn_1);
		sl_pn_scroll.putConstraint(SpringLayout.EAST, this, 643, SpringLayout.WEST, pn_1);

		setOpaque(false);

		SpringLayout sl_pn_2 = new SpringLayout();
		setLayout(sl_pn_2);

		lbl_title = new JLabel("\uC2A4\uB9C8\uD2B8\uBBF8\uB514\uC5B4\uC778\uC7AC\uAC1C\uBC1C\uC6D0");
		sl_pn_2.putConstraint(SpringLayout.NORTH, lbl_title, 31, SpringLayout.NORTH, this);
		sl_pn_2.putConstraint(SpringLayout.WEST, lbl_title, 149, SpringLayout.WEST, this);
		lbl_title.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_title.setFont(new Font("굴림", Font.PLAIN, 30));
		this.add(lbl_title);
		

		lbl_howtime = new JLabel("18:27:00'");
		
		sl_pn_2.putConstraint(SpringLayout.NORTH, lbl_howtime, 23, SpringLayout.SOUTH, lbl_title);
		sl_pn_2.putConstraint(SpringLayout.WEST, lbl_howtime, 30, SpringLayout.WEST, this);
		sl_pn_2.putConstraint(SpringLayout.SOUTH, lbl_howtime, 186, SpringLayout.SOUTH, lbl_title);
		lbl_howtime.setOpaque(false);
		lbl_howtime.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_howtime.setFont(new Font("굴림", Font.PLAIN, 30));
		lbl_howtime.setBackground(Color.WHITE);
		this.add(lbl_howtime);

		lbl_string = new JLabel("\uC5F4\uB9AC\uB294 \uC2DC\uAC04");
		lbl_string.setHorizontalAlignment(SwingConstants.CENTER);
		this.add(lbl_string);

		pn_2_weather = new JPanel() {
			public void paintComponent(Graphics g) {
				// Approach 1: Dispaly image at at full size
//				g.drawImage(icon.getImage(), 0, 0, null);
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
		sl_pn_2.putConstraint(SpringLayout.EAST, lbl_howtime, -55, SpringLayout.EAST, pn_2_weather);
		sl_pn_2.putConstraint(SpringLayout.EAST, lbl_string, -248, SpringLayout.WEST, pn_2_weather);
		sl_pn_2.putConstraint(SpringLayout.NORTH, pn_2_weather, 274, SpringLayout.NORTH, this);
		sl_pn_2.putConstraint(SpringLayout.SOUTH, pn_2_weather, -30, SpringLayout.SOUTH, this);
		sl_pn_2.putConstraint(SpringLayout.WEST, pn_2_weather, -53, SpringLayout.EAST, this);
		sl_pn_2.putConstraint(SpringLayout.EAST, pn_2_weather, -10, SpringLayout.EAST, this);
		this.add(pn_2_weather);

		lbl_showtime = new JLabel();
		sl_pn_2.putConstraint(SpringLayout.WEST, lbl_showtime, 184, SpringLayout.WEST, this);
		sl_pn_2.putConstraint(SpringLayout.EAST, lbl_showtime, -136, SpringLayout.WEST, pn_2_weather);
		sl_pn_2.putConstraint(SpringLayout.SOUTH, lbl_string, -6, SpringLayout.NORTH, lbl_showtime);
		sl_pn_2.putConstraint(SpringLayout.NORTH, lbl_showtime, 301, SpringLayout.NORTH, this);
		lbl_string.setHorizontalAlignment(SwingConstants.CENTER);
		this.add(lbl_showtime);
		
		likecount = new JLabel("1000");
		sl_pn_2.putConstraint(SpringLayout.NORTH, likecount, 6, SpringLayout.SOUTH, pn_2_weather);
		sl_pn_2.putConstraint(SpringLayout.WEST, likecount, -20, SpringLayout.WEST, pn_2_weather);
		likecount.setHorizontalAlignment(SwingConstants.CENTER);
		add(likecount);
		
		
		pn_like = new JPanel() {
			public void paintComponent(Graphics g) {
				// Approach 1: Dispaly image at at full size
//				g.drawImage(like.getImage(), 0, 0, null);
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
		pn_like.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				pn_like.setCursor(new Cursor(12));
			}
			@Override
			public void mouseReleased(MouseEvent e) {
				like.setImage(like2.getImage());
			}
		});
		
		
		
		sl_pn_2.putConstraint(SpringLayout.NORTH, pn_like, 5, SpringLayout.SOUTH, pn_2_weather);
		sl_pn_2.putConstraint(SpringLayout.WEST, pn_like, 7, SpringLayout.EAST, likecount);
		sl_pn_2.putConstraint(SpringLayout.SOUTH, pn_like, 23, SpringLayout.SOUTH, pn_2_weather);
		pn_like.setPreferredSize(new Dimension(20,30));


		add(pn_like);
	}

	public void get_icon(String str) {
		icon = new ImageIcon(str);
		Image originImg = icon.getImage();
		Image changedImg = originImg.getScaledInstance(90, 90, Image.SCALE_SMOOTH);
		icon = new ImageIcon(changedImg);
	}
}
