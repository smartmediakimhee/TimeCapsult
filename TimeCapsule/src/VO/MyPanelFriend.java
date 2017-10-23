package VO;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SpringLayout;
import javax.swing.SwingConstants;

import com.DB.Friend_DAO;
import com.DB.MemberDAO;

import main.BoardMainGUI;
import main.LoggedIN;

public class MyPanelFriend extends JPanel {

	public JLabel lbl_icon;
	public JLabel lbl_string;
	public ImageIcon icon;
	public Image image;

	public MyPanelFriend() {
		icon = new ImageIcon(".\\Image\\redheart.png");
		lbl_icon = new JLabel("    ") {
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
		lbl_string = new JLabel("���̸�");
		lbl_string.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				JOptionPane.showMessageDialog(null, lbl_string.getText() + "���� �۸���� �ҷ��ɴϴ�!");
				BoardMainGUI.viewCaseNum = 1;
				BoardMainGUI.member_id = new MemberDAO().selectMember_byname(lbl_string.getText());
				BoardMainGUI.isok2 = true;
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				lbl_string.setCursor(new Cursor(12));
			}
		});
		lbl_string.setForeground(Color.GRAY);
		lbl_string.setFont(new Font("a����������B", Font.BOLD, 12));
		lbl_string.setHorizontalAlignment(SwingConstants.LEFT);
		lbl_icon.setForeground(Color.GRAY);
		lbl_icon.setOpaque(false);
		lbl_icon.setFont(new Font("a����������B", Font.BOLD, 12));
		lbl_icon.setHorizontalAlignment(SwingConstants.LEFT);
		this.add(lbl_icon);
		this.add(lbl_string);

	}
}
