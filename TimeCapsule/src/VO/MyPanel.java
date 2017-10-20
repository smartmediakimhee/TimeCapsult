package VO;

import java.awt.Color;
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
import javax.swing.JScrollPane;

public class MyPanel extends JPanel {

	public JLabel lbl_title;
	public JLabel pn_1_howtime;
	public JLabel pn_1_string;
	public JLabel lbl_showtime;
	public JLabel lbl_joayo;
	public JPanel pn_weather;
	public ImageIcon icon;
	private JLabel likecount;
	
	public MyPanel(JPanel pn_scroll, SpringLayout sl_pn_scroll) {
		setBorder(new MatteBorder(1, 0, 1, 0, (Color) Color.LIGHT_GRAY)); // �г�1�� �׵θ� (top,left,bottom,right
																			// (�÷���ü)�÷�����Ʈ�׷��̻�����
		sl_pn_scroll.putConstraint(SpringLayout.EAST, this, 653, SpringLayout.WEST, pn_scroll); // �г� 1�� ������ ��ũ���гμ���
																								// ��������653��ŭ ����������
		setOpaque(false); // �г�1�� �����ֱ�
		setBackground(Color.GREEN); // �г�1�� ��׶��� ���� , ������ ���� setOpaque(����)�� ��⶧���� ���ô���
		sl_pn_scroll.putConstraint(SpringLayout.NORTH, this, 10, SpringLayout.NORTH, pn_scroll);// �г�1�� ������ ��Ŭ���г���
																								// �������κ��� 10��ŭ ����������
		sl_pn_scroll.putConstraint(SpringLayout.WEST, this, 10, SpringLayout.WEST, pn_scroll);// �г�1�� ������ ��ũ���г��� �������κ���
																								// 10��ŭ ����������
		sl_pn_scroll.putConstraint(SpringLayout.SOUTH, this, 354, SpringLayout.NORTH, pn_scroll); // �г�1�� ������ ��ũ�� �г���
																									// �������κ��� 354��ŭ
																									// ����������

		SpringLayout sl_pn_1 = new SpringLayout(); // ���������̾ƿ��� ����
		setLayout(sl_pn_1); // �г�1�� ���� ������ sl_pn_1(���������̾ƿ���)����

		// ������
		lbl_title = new JLabel("\uC2A4\uB9C8\uD2B8\uBBF8\uB514\uC5B4\uC778\uC7AC\uAC1C\uBC1C\uC6D0"); // �г�1�� ù��° �󺧷�
		lbl_title.setAutoscrolls(true);																								// ����Ʈ�̵�����簳�߿��ؽ�Ʈ��
																										// ���Ե� ���� ����
		sl_pn_1.putConstraint(SpringLayout.NORTH, lbl_title, 34, SpringLayout.NORTH, this);// �Ʊ� ������ sl_pn_1(���������̾ƿ�)��
																							// ��ġ����(pn_1_lbl�� ������ �г�1��
																							// �������κ��� 34��ŭ �������Բ� ����)
		sl_pn_1.putConstraint(SpringLayout.WEST, lbl_title, 145, SpringLayout.WEST, this);
		lbl_title.setHorizontalAlignment(SwingConstants.CENTER);// �ؽ�Ʈ�� �߾�����
		lbl_title.setFont(new Font("����", Font.PLAIN, 30));
		
		add(lbl_title);// �г�1�� ��� ���� pn_1_lbl�� �߰�

		// ���ڿ� : �����½ð�
		pn_1_string = new JLabel("\uC5F4\uB9AC\uB294 \uC2DC\uAC04");
		sl_pn_1.putConstraint(SpringLayout.WEST, pn_1_string, 273, SpringLayout.WEST, this);
		pn_1_string.setHorizontalAlignment(SwingConstants.CENTER);
		add(pn_1_string);

		pn_weather = new JPanel(){
			   public void paintComponent(Graphics g) {
				    // Approach 1: Dispaly image at at full size
//				    g.drawImage(icon.getImage(), 0, 0, null);
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
		sl_pn_1.putConstraint(SpringLayout.NORTH, pn_weather, -64, SpringLayout.SOUTH, this);
		sl_pn_1.putConstraint(SpringLayout.WEST, pn_weather, 593, SpringLayout.WEST, this);
		sl_pn_1.putConstraint(SpringLayout.SOUTH, pn_weather, -29, SpringLayout.SOUTH, this);
		sl_pn_1.putConstraint(SpringLayout.EAST, pn_weather, -10, SpringLayout.EAST, this);
		add(pn_weather);

		lbl_showtime = new JLabel("");
		sl_pn_1.putConstraint(SpringLayout.SOUTH, pn_1_string, -6, SpringLayout.NORTH, lbl_showtime);
		sl_pn_1.putConstraint(SpringLayout.NORTH, lbl_showtime, 304, SpringLayout.NORTH, this);
		sl_pn_1.putConstraint(SpringLayout.WEST, lbl_showtime, 182, SpringLayout.WEST, this);
		sl_pn_1.putConstraint(SpringLayout.EAST, lbl_showtime, -269, SpringLayout.EAST, this);
		add(lbl_showtime);
		
		likecount = new JLabel("1000");
		sl_pn_1.putConstraint(SpringLayout.NORTH, likecount, 4, SpringLayout.SOUTH, pn_weather);
		sl_pn_1.putConstraint(SpringLayout.WEST, likecount, -48, SpringLayout.EAST, this);
		sl_pn_1.putConstraint(SpringLayout.EAST, likecount, -5, SpringLayout.EAST, pn_weather);
		likecount.setHorizontalAlignment(SwingConstants.CENTER);
		add(likecount);
		
				// ����ð�
				pn_1_howtime = new JLabel("18:27:00'");
				
				sl_pn_1.putConstraint(SpringLayout.NORTH, pn_1_howtime, 18, SpringLayout.SOUTH, lbl_title);
				sl_pn_1.putConstraint(SpringLayout.WEST, pn_1_howtime, 35, SpringLayout.WEST, this);
				sl_pn_1.putConstraint(SpringLayout.SOUTH, pn_1_howtime, -37, SpringLayout.NORTH, pn_1_string);
				sl_pn_1.putConstraint(SpringLayout.EAST, pn_1_howtime, 570, SpringLayout.WEST, this);
				pn_1_howtime.setOpaque(true);
				pn_1_howtime.setHorizontalAlignment(SwingConstants.CENTER);
				pn_1_howtime.setFont(new Font("����", Font.PLAIN, 30));
				pn_1_howtime.setBackground(Color.WHITE);
				pn_1_howtime.setOpaque(false);
				add(pn_1_howtime);

	}
	
	public void get_icon(String str) {
		icon = new ImageIcon(str);
		Image originImg = icon.getImage(); 
		Image changedImg = originImg.getScaledInstance(90, 90, Image.SCALE_SMOOTH);
		icon = new ImageIcon(changedImg);
	}
}
