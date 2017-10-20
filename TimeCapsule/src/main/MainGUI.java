package main;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
import javax.swing.SwingConstants;
import javax.swing.border.MatteBorder;

import com.DB.MemberDAO;
import com.DTO.MemberDTO;

public class MainGUI {
   JScrollPane scrollPane;
   ImageIcon icon;
   ImageIcon icon2;
   ImageIcon Mainicon;
   private JFrame frame;
   private JTextField txtHwanavercom;
   private JPasswordField pwdSss;
   private String id;
   private String pw;
   MemberDAO memberDAO = new MemberDAO();
   MemberDTO memberDTO;

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

      Mainicon = new ImageIcon("D:\\\\박경도\\\\배경.jpg");
      icon = new ImageIcon("D:\\\\박경도\\\\1.png");
      icon2 = new ImageIcon("D:\\\\박경도\\\\2.png");
      frame = new JFrame();
      frame.setBounds(0, 0, 1920, 1040);
      frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

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

      txtHwanavercom = new JTextField();
      sl_panel.putConstraint(SpringLayout.NORTH, txtHwanavercom, 5, SpringLayout.NORTH, panel);
      sl_panel.putConstraint(SpringLayout.WEST, txtHwanavercom, 1037, SpringLayout.WEST, panel);
      sl_panel.putConstraint(SpringLayout.EAST, txtHwanavercom, -708, SpringLayout.EAST, panel);
      txtHwanavercom.setOpaque(false);
      panel.add(txtHwanavercom);
      txtHwanavercom.setColumns(10);
      txtHwanavercom.setBorder(new MatteBorder(0, 0, 2, 0, (Color) Color.LIGHT_GRAY));

      JPanel panel_1 = new JPanel();
      sl_panel.putConstraint(SpringLayout.NORTH, panel_1, 92, SpringLayout.NORTH, panel);
      sl_panel.putConstraint(SpringLayout.SOUTH, txtHwanavercom, -60, SpringLayout.NORTH, panel_1);
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

      pwdSss = new JPasswordField();
      sl_panel.putConstraint(SpringLayout.WEST, pwdSss, 1202, SpringLayout.WEST, panel);
      sl_panel.putConstraint(SpringLayout.NORTH, pwdSss, 5, SpringLayout.NORTH, panel);
      sl_panel.putConstraint(SpringLayout.SOUTH, pwdSss, 32, SpringLayout.NORTH, panel);
      sl_panel.putConstraint(SpringLayout.EAST, pwdSss, 147, SpringLayout.EAST, txtHwanavercom);
      panel.add(pwdSss);
      pwdSss.setOpaque(false);
      pwdSss.setBorder(new MatteBorder(0, 0, 2, 0, (Color) Color.LIGHT_GRAY));

      // 로그인버튼이벤트
      JButton btb_login = new JButton("\uB85C\uADF8\uC778");
      btb_login.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
            if ((id = txtHwanavercom.getText()).equals("") || (pw = pwdSss.getText()).equals("")) {
               JOptionPane.showMessageDialog(null, "ID와 PW를 모두 입력하세요", "Login Fail", JOptionPane.WARNING_MESSAGE);
            }
            memberDTO = memberDAO.selectMember(id);
            if (memberDTO.getId().equals(id) && memberDTO.getPw().equals(pw)) {
               JOptionPane.showMessageDialog(null, "어서오세요.", "Login Success", JOptionPane.WARNING_MESSAGE);
               
            BoardMainGUI boardMainGUI = new BoardMainGUI();
            boardMainGUI.main(null);
            frame.dispose();
            
            } else {
               JOptionPane.showMessageDialog(null, "존재하지않는 ID이거나 비밀번호가 다릅니다.", "Login Fail",
                     JOptionPane.WARNING_MESSAGE);
            }
         }
      });
      sl_panel.putConstraint(SpringLayout.NORTH, btb_login, 1, SpringLayout.NORTH, txtHwanavercom);
      sl_panel.putConstraint(SpringLayout.WEST, btb_login, 6, SpringLayout.EAST, pwdSss);
      panel.add(btb_login);

      // 회원가입이벤트
      JButton btn_join = new JButton("\uD68C\uC6D0\uAC00\uC785");
      btn_join.addActionListener(new ActionListener() {

         public void actionPerformed(ActionEvent e) {
            JoinGUI joinGUI = new JoinGUI();
            joinGUI.main(null);
         }
      });
      sl_panel.putConstraint(SpringLayout.NORTH, btn_join, 1, SpringLayout.NORTH, txtHwanavercom);
      sl_panel.putConstraint(SpringLayout.WEST, btn_join, 6, SpringLayout.EAST, btb_login);
      panel.add(btn_join);

   }
}