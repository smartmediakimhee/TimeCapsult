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
import javax.swing.JOptionPane;

import java.awt.Color;
import java.awt.Container;
import java.awt.Cursor;
import java.awt.Desktop;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Rectangle;
import java.awt.dnd.Autoscroll;
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
import java.io.IOException;
import java.net.URISyntaxException;

import javax.swing.JToggleButton;
import javax.swing.ScrollPaneConstants;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.FlowLayout;
import javax.swing.border.LineBorder;
import javax.swing.border.MatteBorder;
import javax.swing.event.HyperlinkEvent;
import javax.swing.event.HyperlinkListener;

import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextPane;
import javax.swing.JTextArea;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JEditorPane;

public class postGUI {
   JScrollPane scrollPane;
   ImageIcon icon;
   ImageIcon icon2;
   ImageIcon period;
   ImageIcon title;
   ImageIcon content;
   ImageIcon bnt;
   JCalendar calendar;
   JEditorPane txt;

   ImageIcon back;
   private JFrame frame;
   private JTextField textField;
   private JTextField txt_title;
   private static JTextField txtPeriod;
   private static String calendarDate;
   private JCalendar calerdar;
   private JComboBox timebox;
   public static String date = "";
   private String temp2 = "선택안함";
   private JComboBox minbox;
   private String temp3 = "선택안함";

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
      txtPeriod.setForeground(Color.gray);
      txtPeriod.setText("마우스를 클릭하면 달력이 나타납니다.");
   }

<<<<<<< HEAD
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
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
=======
   /**
    * Initialize the contents of the frame.
    */
   private void initialize() {
      calendar = new JCalendar();
      back = new ImageIcon("../TimeCapsule/Image/back.jpg");
      icon = new ImageIcon("../TimeCapsule/Image/1.png");
      icon2 = new ImageIcon("../TimeCapsule/Image/icon2.png");
      period = new ImageIcon("../TimeCapsule/Image/period.png");
      title = new ImageIcon("../TimeCapsule/Image/title.png");
      content = new ImageIcon("../TimeCapsule/Image/content.png");
      bnt = new ImageIcon("../TimeCapsule/Image/bnt.png");
      frame = new JFrame();
      frame.setBounds(0, 0, 1920, 1040);
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
>>>>>>> branch 'master' of https://github.com/smartmediakimhee/TimeCapsult.git

      timebox = new JComboBox();
      ((JLabel) timebox.getRenderer()).setHorizontalAlignment(SwingConstants.CENTER);
      timebox.setBackground(Color.WHITE);
      timebox.setOpaque(false);
      timebox.addItemListener(new ItemListener() {
         public void itemStateChanged(ItemEvent ev) {
            if (ev.getStateChange() == ItemEvent.SELECTED) {
               JComboBox jbox2 = (JComboBox) ev.getItemSelectable();
               temp2 = jbox2.getSelectedItem().toString();
               System.out.println(temp2);
            }
         }
      });

      minbox = new JComboBox();
      ((JLabel) minbox.getRenderer()).setHorizontalAlignment(SwingConstants.CENTER);
      minbox.setBackground(Color.WHITE);
      minbox.setOpaque(false);
      minbox.setBorder(new LineBorder(Color.LIGHT_GRAY, 2));
      minbox.addItemListener(new ItemListener() {
         public void itemStateChanged(ItemEvent ev) {
            if (ev.getStateChange() == ItemEvent.SELECTED) {
               JComboBox jbox = (JComboBox) ev.getItemSelectable();
               temp3 = jbox.getSelectedItem().toString();
               System.out.println(temp3);
            }
         }
      });

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
      sl_panel_big.putConstraint(SpringLayout.NORTH, lbl_login, 3, SpringLayout.NORTH, panel_big);
      panel_big.add(lbl_login);

      JLabel lbl_sign = new JLabel("log out");
      sl_panel_big.putConstraint(SpringLayout.NORTH, lbl_sign, -2, SpringLayout.NORTH, lbl_login);
      sl_panel_big.putConstraint(SpringLayout.WEST, lbl_sign, 23, SpringLayout.EAST, lbl_login);
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
      sl_panel_big.putConstraint(SpringLayout.SOUTH, lbl_login, -823, SpringLayout.NORTH, pn_underimg);
      sl_panel_big.putConstraint(SpringLayout.NORTH, pn_underimg, 841, SpringLayout.NORTH, panel_big);
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
      sl_pn_small.putConstraint(SpringLayout.WEST, timebox, 813, SpringLayout.WEST, pn_small);
      sl_pn_small.putConstraint(SpringLayout.EAST, timebox, -19, SpringLayout.WEST, minbox);
      sl_pn_small.putConstraint(SpringLayout.WEST, minbox, 967, SpringLayout.WEST, pn_small);
      sl_pn_small.putConstraint(SpringLayout.EAST, minbox, -277, SpringLayout.EAST, pn_small);
      pn_small.setLayout(sl_pn_small);
      pn_small.setOpaque(false);

      textField = new JTextField();
      sl_pn_small.putConstraint(SpringLayout.WEST, textField, 381, SpringLayout.WEST, pn_small);
      sl_pn_small.putConstraint(SpringLayout.EAST, textField, -563, SpringLayout.EAST, pn_small);
      pn_small.add(textField);
      textField.setColumns(10);

      txt_title = new JTextField();
      sl_pn_small.putConstraint(SpringLayout.SOUTH, txt_title, -532, SpringLayout.SOUTH, pn_small);
      txt_title.addFocusListener(new FocusAdapter() {
         @Override
         public void focusLost(FocusEvent arg0) {
            if (txt_title.getText().equals("")) {
               txt_title.setText("title");
               txt_title.setForeground(Color.gray);
            }
         }

         @Override
         public void focusGained(FocusEvent e) {
            if (txt_title.getText().equals("title")) {

               txt_title.setForeground(Color.black);
               txt_title.setText("");
            }
         }
      });
      txt_title.addMouseListener(new MouseAdapter() {
         @Override
         public void mouseClicked(MouseEvent arg0) {
            if (txt_title.getText().equals("title")) {
               txt_title.setForeground(Color.black);
               txt_title.setText("");

            }
         }
      });
      txt_title.setForeground(Color.GRAY);
      txt_title.setFont(new Font("a엄마의편지B", Font.PLAIN, 15));
      txt_title.setBorder(new LineBorder(Color.LIGHT_GRAY, 2, true));
      sl_pn_small.putConstraint(SpringLayout.NORTH, textField, 43, SpringLayout.SOUTH, txt_title);
      sl_pn_small.putConstraint(SpringLayout.SOUTH, textField, -12, SpringLayout.NORTH, txt_title);
      sl_pn_small.putConstraint(SpringLayout.EAST, txt_title, -277, SpringLayout.EAST, pn_small);
      txt_title.setHorizontalAlignment(SwingConstants.CENTER);
      txt_title.setText("title");
      txt_title.setColumns(10);
      pn_small.add(txt_title);

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
      sl_pn_small.putConstraint(SpringLayout.NORTH, panel_content, 361, SpringLayout.NORTH, pn_small);
      sl_pn_small.putConstraint(SpringLayout.SOUTH, panel_content, -490, SpringLayout.SOUTH, pn_small);
      sl_pn_small.putConstraint(SpringLayout.SOUTH, panel_title, -15, SpringLayout.NORTH, panel_content);
      sl_pn_small.putConstraint(SpringLayout.WEST, panel_content, 301, SpringLayout.WEST, pn_small);
      sl_pn_small.putConstraint(SpringLayout.EAST, panel_content, -1024, SpringLayout.EAST, pn_small);
      pn_small.add(panel_content);
      ;

      JButton btn_in = new JButton();
      sl_pn_small.putConstraint(SpringLayout.NORTH, btn_in, 312, SpringLayout.SOUTH, txt_title);
      sl_pn_small.putConstraint(SpringLayout.SOUTH, btn_in, -181, SpringLayout.SOUTH, pn_small);
      btn_in.addMouseListener(new MouseAdapter() {
         @Override
         public void mouseEntered(MouseEvent e) {
            btn_in.setOpaque(true);
            btn_in.setBackground(new Color(255, 160, 160));
            btn_in.setCursor(new Cursor(12));
         }

         @Override
         public void mouseExited(MouseEvent e) {
            btn_in.setOpaque(false);
         }
      });
      btn_in.setOpaque(false);
      btn_in.setFont(new Font("a엄마의편지B", Font.PLAIN, 20));
      btn_in.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent arg0) {
            if (!txtPeriod.getText().equals("마우스를 클릭하면 달력이 나타납니다.") && !temp2.equals("선택안함")&&!temp3.equals("선택안함")) {
               Board_1_DAO b1 = new Board_1_DAO();

               String hour = temp2;
               String minute = temp3;
               String title = txt_title.getText();
               String content = txt.getText();

               String settime = date + " " + hour + ":" + minute + ":00";
               if (b1.insertBoard_1(title, content, settime)) {
                  frame.dispose();
               }
            } else {
               System.out.println("날짜를 선택하라고 ㅋㅋㅋ");
               JOptionPane.showMessageDialog(null, "글이 열릴 날짜를 정확히 선택해주세요.");
            }
         }
      });
      btn_in.setBackground(new Color(240, 240, 240));
      sl_pn_small.putConstraint(SpringLayout.WEST, btn_in, 638, SpringLayout.WEST, pn_small);
      sl_pn_small.putConstraint(SpringLayout.EAST, btn_in, -530, SpringLayout.EAST, pn_small);
      btn_in.setBorderPainted(false);
      btn_in.setText("Create");
      pn_small.add(btn_in);

      txtPeriod = new JTextField();
      sl_pn_small.putConstraint(SpringLayout.SOUTH, txtPeriod, -576, SpringLayout.SOUTH, pn_small);
      sl_pn_small.putConstraint(SpringLayout.NORTH, txt_title, 13, SpringLayout.SOUTH, txtPeriod);
      sl_pn_small.putConstraint(SpringLayout.WEST, txtPeriod, 28, SpringLayout.EAST, panel_period);
      sl_pn_small.putConstraint(SpringLayout.EAST, txtPeriod, -16, SpringLayout.WEST, timebox);
      txtPeriod.setFont(new Font("a엄마의편지B", Font.PLAIN, 15));
      txtPeriod.setBorder(new LineBorder(Color.LIGHT_GRAY, 2, true));
      sl_pn_small.putConstraint(SpringLayout.NORTH, txtPeriod, 269, SpringLayout.NORTH, pn_small);
      txtPeriod.addMouseListener(new MouseAdapter() {
         @Override
         public void mouseReleased(MouseEvent arg0) {
            txtPeriod.setForeground(Color.BLACK);
            JCal cal = new JCal();
            cal.main(null);
            txtPeriod.setText(calendarDate);
         }
      });
      txtPeriod.setHorizontalAlignment(SwingConstants.CENTER);
      txtPeriod.setText("period");
      pn_small.add(txtPeriod);
      txtPeriod.setColumns(10);
      sl_panel_big.putConstraint(SpringLayout.NORTH, pn_logo, 89, SpringLayout.NORTH, panel_big);
      panel_big.add(pn_logo);

      JPanel pn_nickname = new JPanel();
      sl_panel_big.putConstraint(SpringLayout.WEST, lbl_login, 6, SpringLayout.EAST, pn_nickname);
      sl_panel_big.putConstraint(SpringLayout.NORTH, pn_nickname, 3, SpringLayout.NORTH, panel_big);
      sl_panel_big.putConstraint(SpringLayout.WEST, pn_nickname, 1653, SpringLayout.WEST, panel_big);
      sl_panel_big.putConstraint(SpringLayout.SOUTH, pn_nickname, -977, SpringLayout.SOUTH, panel_big);
      sl_panel_big.putConstraint(SpringLayout.EAST, pn_nickname, -136, SpringLayout.EAST, panel_big);
      sl_panel_big.putConstraint(SpringLayout.NORTH, pn_small, 64, SpringLayout.SOUTH, pn_nickname);
      pn_nickname.setBorder(new MatteBorder(0, 0, 0, 0, (Color) new Color(0, 0, 0)));
      panel_big.add(pn_nickname);
      pn_nickname.setOpaque(false);
      SpringLayout sl_pn_nickname = new SpringLayout();
      pn_nickname.setLayout(sl_pn_nickname);

<<<<<<< HEAD
					String settime = date + " " + hour + ":" + minute + ":00";
					if (b1.insertBoard_1(title, content, settime)) {
						frame.dispose();
						BoardMainGUI bgui = null;
						bgui.main(null);
					}else {
						JOptionPane.showMessageDialog(null, "DB에 삽입중 오류가 발생함");
					}
					
				} else {
					System.out.println("날짜를 선택하라고 ㅋㅋㅋ");
					JOptionPane.showMessageDialog(null, "글이 열릴 날짜를 정확히 선택해주세요.");
				}
			}
		});
		btn_in.setBackground(new Color(240, 240, 240));
		sl_pn_small.putConstraint(SpringLayout.NORTH, btn_in, 69, SpringLayout.SOUTH, txt_content);
		sl_pn_small.putConstraint(SpringLayout.WEST, btn_in, 638, SpringLayout.WEST, pn_small);
		sl_pn_small.putConstraint(SpringLayout.SOUTH, btn_in, 108, SpringLayout.SOUTH, txt_content);
		sl_pn_small.putConstraint(SpringLayout.EAST, btn_in, -530, SpringLayout.EAST, pn_small);
		btn_in.setBorderPainted(false);
		btn_in.setText("Create");
		pn_small.add(btn_in);
=======
      JLabel logged_in_ID = new JLabel(LoggedIN.getInfo().getName());
      sl_pn_nickname.putConstraint(SpringLayout.NORTH, logged_in_ID, 0, SpringLayout.NORTH, pn_nickname);
      sl_pn_nickname.putConstraint(SpringLayout.WEST, logged_in_ID, 24, SpringLayout.WEST, pn_nickname);
      sl_pn_nickname.putConstraint(SpringLayout.SOUTH, logged_in_ID, -8, SpringLayout.SOUTH, pn_nickname);
      sl_pn_nickname.putConstraint(SpringLayout.EAST, logged_in_ID, -10, SpringLayout.EAST, pn_nickname);
      logged_in_ID.setHorizontalAlignment(SwingConstants.RIGHT);
      pn_nickname.add(logged_in_ID);
>>>>>>> branch 'master' of https://github.com/smartmediakimhee/TimeCapsult.git

      logged_in_ID.setText(logged_in_ID.getName());
      SimpleDateFormat format = new SimpleDateFormat("yy-MM-dd hh:mm:ss");

      logged_in_ID.setText(LoggedIN.getInfo().getName());
      txtPeriod.setText(date);

      sl_pn_small.putConstraint(SpringLayout.SOUTH, timebox, 0, SpringLayout.SOUTH, txtPeriod);
      timebox.setBorder(new LineBorder(Color.LIGHT_GRAY, 2));
      sl_pn_small.putConstraint(SpringLayout.NORTH, timebox, 0, SpringLayout.NORTH, txtPeriod);
      timebox.setModel(new DefaultComboBoxModel(new String[] { "TIME", "01", "02", "03", "04", "05", "06", "07", "08",
            "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23" }));
      pn_small.add(timebox);

      sl_pn_small.putConstraint(SpringLayout.NORTH, minbox, 0, SpringLayout.NORTH, timebox);
      sl_pn_small.putConstraint(SpringLayout.SOUTH, minbox, 0, SpringLayout.SOUTH, timebox);
      minbox.setModel(new DefaultComboBoxModel(
            new String[] { "MIN", "00", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12",
                  "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28",
                  "29", "30", "31", "32", "33", "34", "35", "36", "37", "38", "39", "40", "41", "42", "43", "44",
                  "45", "46", "47", "48", "49", "50", "51", "52", "53", "54", "55", "56", "57", "58", "59" }));
      pn_small.add(minbox);
      
      JPanel panel = new JPanel();
      sl_pn_small.putConstraint(SpringLayout.NORTH, panel, 0, SpringLayout.NORTH, panel_content);
      sl_pn_small.putConstraint(SpringLayout.WEST, panel, 0, SpringLayout.WEST, textField);
      sl_pn_small.putConstraint(SpringLayout.SOUTH, panel, 308, SpringLayout.NORTH, txtPeriod);
      sl_pn_small.putConstraint(SpringLayout.EAST, panel, -277, SpringLayout.EAST, pn_small);
      pn_small.add(panel);
      panel.setLayout(new GridLayout(1, 0, 0, 0));
      
      txt = new JEditorPane();
      panel.add(txt);
      sl_pn_small.putConstraint(SpringLayout.NORTH, txt, 21, SpringLayout.SOUTH, txt_title);
      sl_pn_small.putConstraint(SpringLayout.SOUTH, txt, 231, SpringLayout.NORTH, txtPeriod);
      sl_pn_small.putConstraint(SpringLayout.EAST, txt, 1158, SpringLayout.WEST, pn_small);
      
            JScrollPane scroll=new JScrollPane(txt);
            panel.add(scroll);
                  
            
            
            txt.setBorder(new LineBorder(Color.LIGHT_GRAY, 2));
            txt.setDocument((new JTextFieldLimit(200)));
            
            txt.setForeground(Color.GRAY);
            
            txt.addKeyListener(new KeyAdapter() {
               @Override
               public void keyTyped(KeyEvent e) {
                  
               }
            });
            txt.addFocusListener(new FocusAdapter() {
               @Override
               public void focusGained(FocusEvent e) {
                  if (txt.getText().equals("게시물의 내용은 200자 내로 작성하시오.")) {
                     txt.setForeground(Color.black);
                     txt.setText("");

                  }
               }

               @Override
               public void focusLost(FocusEvent e) {
                  if (txt.getText().length() == 0) {
                     txt.setText("게시물의 내용은 200자 내로 작성하시오.");
                     txt.setForeground(Color.gray);
                  }
               }
            });
            txt.addMouseListener(new MouseAdapter() {
               @Override
               public void mouseClicked(MouseEvent arg0) {
                  if (txt.getText().equals("게시물의 내용은 200자 내로 작성하시오.")) {
                     txt.setForeground(Color.black);
                     txt.setText("");
                  }
               }
            });
            txt.setFont(new Font("a엄마의편지L", Font.PLAIN, 20));
            txt.setText("\uAC8C\uC2DC\uBB3C\uC758 \uB0B4\uC6A9\uC740 200\uC790 \uB0B4\uB85C \uC791\uC131\uD558\uC2DC\uC624.");
   }

   public static void getDate(String date2) {
      calendarDate = date2;
      txtPeriod.setText(calendarDate);

   }
}