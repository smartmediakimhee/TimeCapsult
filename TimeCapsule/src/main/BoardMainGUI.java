package main;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.ScrollPane;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SpringLayout;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

import com.DB.Board_1_DAO;
import com.DB.Friend_DAO;
import com.DB.Like_DAO;
import com.DB.Rel_Mem_Cap;
import com.DTO.Board_1_DTO;
import com.DTO.FriendDTO;

import VO.MyPanel;
import VO.MyPanel2;
import VO.MyPanelFriend;
import function.MyWeather;
import function.Mytimer;

public class BoardMainGUI implements Runnable {
   JScrollPane scrollPane;
   private ImageIcon icon;
   private ImageIcon icon2;
   private ImageIcon list;
   private JFrame frame;
   private ImageIcon icon3;
   private ImageIcon icon4;
   private Boolean b = false;
   private Thread thread;

   private ArrayList<Board_1_DTO> board_Arr = new ArrayList<>();
   private ArrayList<MyPanel2> panelArr = new ArrayList<>();

   private static Board_1_DAO board_1_DAO = new Board_1_DAO();
   private static Mytimer timer = new Mytimer();
   MyPanel pn_1;
   private boolean isSortboardArr = false;
   private Date setDate = null;
   public static String member_id = "1";
   public static boolean isok = false;
   public static boolean isok2 = false;
   public static int viewCaseNum = 0;

   //
   static Dimension size;
   static JScrollPane scrollPane_1;
   static JScrollPane scrollPane_2;
   static JPanel pn_scroll;
   static SpringLayout sl_pn_scroll;
   static JPanel target;

   //
   
   ArrayList<MyPanelFriend> f_info_list = new ArrayList<>();
   ArrayList<FriendDTO> farr = new ArrayList<>();
   static JScrollPane scroll_pn_friend;
   static JPanel pn_friend;
   static Dimension size2;
   
   //
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
   private synchronized void initialize() {
      list = new ImageIcon("Image\\list.png");
      icon = new ImageIcon("Image\\back.jpg");
      icon2 = new ImageIcon("Image\\1.png");
      icon3 = new ImageIcon("Image\\icon2.png");
      icon4 = new ImageIcon("Image\\rain.png");
      frame = new JFrame();
      frame.setBounds(0, 0, 1920, 1040);
      frame.addWindowListener(new WindowAdapter() {
         public void windowClosing(WindowEvent e) {
            System.out.println("진짜종료한다..");
            thread.interrupt();
         }
      });
      viewCaseNum = 0;
      member_id = LoggedIN.getInfo().getId();
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
            setOpaque(false); // 그림을 표시하게 설정,투명하게 조절
            super.paintComponent(g);
         }
      };
      panel_big.setOpaque(false);
      frame.getContentPane().add(panel_big, BorderLayout.CENTER);
      SpringLayout sl_panel_big = new SpringLayout();
      panel_big.setLayout(sl_panel_big);

      JLabel lbl_log_id = new JLabel(LoggedIN.getInfo().getName());
      lbl_log_id.addMouseListener(new MouseAdapter() {
         @Override
         public synchronized void mouseClicked(MouseEvent e) {
            viewCaseNum = 1;
            member_id = LoggedIN.getInfo().getId();
            System.out.println("멤버로보기선택함" + member_id + "##################################");
            init_boardArr();
            initPanelArr();
            // target = pn_1;
            // initPanelArr(scrollPane_1, pn_scroll, size, sl_pn_scroll, target);
         }
         @Override
         public void mouseEntered(MouseEvent e) {
            lbl_log_id.setCursor(new Cursor(12));
         }
      });
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
            thread.interrupt();
            MainGUI main = null;
            main.main(null);
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
            setOpaque(false); // 그림을 표시하게 설정,투명하게 조절
            super.paintComponent(g);
         }
      };
      pn_img1.addMouseListener(new MouseAdapter() {
         @Override
         public void mouseClicked(MouseEvent e) {
            
            viewCaseNum=0;
            member_id = LoggedIN.Logged_in_id;
            isok2=true;
            
         }
         @Override
         public void mouseEntered(MouseEvent e) {
            pn_img1.setCursor(new Cursor(12));
         }
      });
      sl_panel_big.putConstraint(SpringLayout.NORTH, pn_img1, 28, SpringLayout.NORTH, panel_big);
      sl_panel_big.putConstraint(SpringLayout.WEST, pn_img1, 10, SpringLayout.WEST, panel_big);
      sl_panel_big.putConstraint(SpringLayout.SOUTH, pn_img1, -867, SpringLayout.SOUTH, panel_big);
      sl_panel_big.putConstraint(SpringLayout.EAST, pn_img1, -1759, SpringLayout.EAST, panel_big);
      panel_big.add(pn_img1);

      Button btn_sort = new Button("정렬");
      btn_sort.addMouseListener(new MouseAdapter() {
         @Override
         public void mouseClicked(MouseEvent e) {
            if (isSortboardArr) {
               JOptionPane.showMessageDialog(null, "게시글을 남은 열림시간순으로 정렬합니다");
               sortBoardArrtime();
               isSortboardArr = false;
            } else {
               init_boardArr();
               isSortboardArr = true;
            }
         }
         @Override
         public void mouseEntered(MouseEvent e) {
            btn_sort.setCursor(new Cursor(12));
         }
      });
      
      
      pn_img1.addMouseListener(new MouseAdapter() {
         @Override
         public void mouseClicked(MouseEvent e) {
            viewCaseNum = 0;
            member_id = LoggedIN.Logged_in_id;
            isok2 = true;
         }

         @Override
         public void mouseEntered(MouseEvent e) {
            pn_img1.setCursor(new Cursor(12));
         }
      });

      
      
      sl_panel_big.putConstraint(SpringLayout.NORTH, btn_sort, 968, SpringLayout.NORTH, panel_big);
      sl_panel_big.putConstraint(SpringLayout.WEST, btn_sort, 1350, SpringLayout.WEST, panel_big);
      panel_big.add(btn_sort);
      
/*      JLabel lbl_sort = new JLabel() {
         public void paintComponent(Graphics g) {
            // Approach 1: Dispaly image at at full size
//            g.drawImage(Mainicon.getImage(), 0, 0, null);
            // Approach 2: Scale image to size of component
            Dimension d = new Dimension(200, 200);
            g.drawImage(list.getImage(), 0, 0, d.width, d.height, null);
            // Approach 3: Fix the image position in the scroll pane
            // Point p = scrollPane.getViewport().getViewPosition();
            // g.drawImage(icon.getImage(), p.x, p.y, null);
            setOpaque(false); // 그림을 표시하게 설정,투명하게 조절
            super.paintComponent(g);
         }
      };
      sl_panel_big.putConstraint(SpringLayout.NORTH, lbl_sort, 800, SpringLayout.NORTH, panel_big);
      sl_panel_big.putConstraint(SpringLayout.WEST, lbl_sort, 1600, SpringLayout.WEST, panel_big);

      lbl_sort.addMouseListener(new MouseAdapter() {
         @Override
         public void mouseClicked(MouseEvent e) {
            if (isSortboardArr) {
               JOptionPane.showMessageDialog(null, "게시글을 남은 열림시간순으로 정렬합니다");
               sortBoardArrtime();
               isSortboardArr = false;
            } else {
               init_boardArr();
               isSortboardArr = true;
            }
         }
         @Override
         public void mouseEntered(MouseEvent e) {
            lbl_sort.setCursor(new Cursor(12));
         }
      });*/
      /*
       * sl_panel_big.putConstraint(SpringLayout.NORTH, lbl_sort, 800,
       * SpringLayout.NORTH, panel_big); sl_panel_big.putConstraint(SpringLayout.WEST,
       * lbl_sort, 200, SpringLayout.WEST, panel_big);
       * sl_panel_big.putConstraint(SpringLayout.SOUTH, lbl_sort, -82,
       * SpringLayout.SOUTH, panel_big); sl_panel_big.putConstraint(SpringLayout.EAST,
       * lbl_sort, -60, SpringLayout.EAST, panel_big);
       */
   /*   panel_big.add(lbl_sort);*/

      // sl_panel_big.putConstraint(SpringLayout.NORTH, pn_img2, 813,
      // SpringLayout.NORTH, panel_big);
      // sl_panel_big.putConstraint(SpringLayout.WEST, pn_img2, 0, SpringLayout.WEST,
      // lbl_login);
      // sl_panel_big.putConstraint(SpringLayout.SOUTH, pn_img2, -82,
      // SpringLayout.SOUTH, panel_big);
      // sl_panel_big.putConstraint(SpringLayout.EAST, pn_img2, -40,
      // SpringLayout.EAST, panel_big);
      // panel_big.add(pn_img2);

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
            setOpaque(false); // 그림을 표시하게 설정,투명하게 조절

            super.paintComponent(g);

         }
      };

      pn_img2.addMouseListener(new MouseAdapter() {
         @Override
         public void mouseClicked(MouseEvent e) {
            thread.interrupt();
            
            postGUI post = null;
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

      scrollPane_1 = new JScrollPane();
      sl_panel_big.putConstraint(SpringLayout.NORTH, scrollPane_1, 0, SpringLayout.NORTH, pn_img1);
      sl_panel_big.putConstraint(SpringLayout.WEST, scrollPane_1, -1300, SpringLayout.EAST, panel_big);
      sl_panel_big.putConstraint(SpringLayout.SOUTH, scrollPane_1, 992, SpringLayout.NORTH, panel_big);
      sl_panel_big.putConstraint(SpringLayout.EAST, scrollPane_1, -493, SpringLayout.EAST, panel_big);
      panel_big.add(scrollPane_1);
      scrollPane_1.setBorder(javax.swing.BorderFactory.createEmptyBorder());
      scrollPane_1.getViewport().setOpaque(false);

      pn_scroll = new JPanel();
      pn_scroll.setBorder(new LineBorder(null, 0, true));
      scrollPane_1.setViewportView(pn_scroll);

      pn_scroll.setOpaque(false);
      scrollPane_1.setOpaque(false);
      panel_big.setOpaque(false);
      
      // 스크롤팬 생성
      JPanel panel_ex = new JPanel();// 스크롤팬에 붙일 패널 생성
      size = new Dimension();// 사이즈를 지정하기 위한 객체 생성
      // size.setSize(10, 382*4);// 객체의 사이즈를 지정
      size.setSize(10, panelsHeightSize(4)); // panelHeightSize(int count) 에서 count 는 페널들이 담긴 ArrayList의 size 값이다.
      pn_scroll.setPreferredSize(size);// 사이즈 정보를 가지고 있는 객체를 이용해 패널의 사이즈 지정
      scrollPane_1.setViewportView(pn_scroll);
      pn_scroll.setSize(450, 200);
      sl_pn_scroll = new SpringLayout();
      pn_scroll.setLayout(sl_pn_scroll);
      
      
      
      
      
      scroll_pn_friend = new JScrollPane();
      sl_panel_big.putConstraint(SpringLayout.NORTH, scroll_pn_friend, 200, SpringLayout.NORTH, panel_big);
      sl_panel_big.putConstraint(SpringLayout.SOUTH, scroll_pn_friend, 500, SpringLayout.NORTH, scroll_pn_friend);
      sl_panel_big.putConstraint(SpringLayout.WEST, scroll_pn_friend, 1470, SpringLayout.WEST, panel_big);
      sl_panel_big.putConstraint(SpringLayout.EAST, scroll_pn_friend, 375, SpringLayout.WEST, scroll_pn_friend);
      panel_big.add(scroll_pn_friend);
//      scroll_pn_friend.setBackground(Color.black);
      
      
      scroll_pn_friend.getViewport().setOpaque(false);
      scroll_pn_friend.setBorder(null);
      scroll_pn_friend.setOpaque(false);
      pn_friend = new JPanel();
      pn_friend.setOpaque(false);

      scroll_pn_friend.add(pn_friend);
      scroll_pn_friend.setViewportView(pn_friend);
      pn_friend.setLayout(null);
      size2 = new Dimension();
      farr = new Friend_DAO().list(LoggedIN.Logged_in_id);
      
      for (int i = 0; i < farr.size(); i++) {
         f_info_list.add(new MyPanelFriend());
         f_info_list.get(i).setBackground(new Color(230,166,166));
         f_info_list.get(i).setBounds(5, i*30, 360, 25);
         f_info_list.get(i).lbl_string.setText(farr.get(i).getName());
         
         pn_friend.add(f_info_list.get(i));
      }
      
      size2.setSize(10, 30*farr.size()+10);
      pn_friend.setPreferredSize(size2);
      
      
//      f_info_list.add(new pn_friend)
      
      
      

//      
//       size.setSize(10, 6000);// 객체의 사이즈를 지정
//            size.setSize(10, panelsHeightSize(4)); // panelHeightSize(int count) 에서 count 는 페널들이 담긴 ArrayList의 size 값이다.
//            pn_friend.setPreferredSize(size);// 사이즈 정보를 가지고 있는 객체를 이용해 패널의 사이즈 지정
//            scroll_pn_friend.setViewportView(pn_friend);
//            pn_friend.setSize(450, 50);
            scroll_pn_friend.getVerticalScrollBar().setUnitIncrement(30);
//      
//      
      
      
      

      

      ///// 게시판1시작

      // 게시판1패널생성!
      pn_1 = new MyPanel(pn_scroll, sl_pn_scroll);
      pn_scroll.add(pn_1); // 스크롤패널에 패널1을 위에 조건값으로 추가
      scrollPane_1.getVerticalScrollBar().setUnitIncrement(30);
      JPanel target = pn_1;

      // 보드arr초기화
      init_boardArr();
      pn_1.lbl_title.setText("");
      pn_1.pn_1_howtime.setText("");
      pn_1.lbl_showtime.setText("");
      pn_1.get_icon(whereIconsrc(new MyWeather().getWeather()));
      // 정렬
      // sortBoardArrtime(board_Arr);

      // 재생성오류해결
      if (!panelArr.isEmpty()) {
         System.out.println("패널초기화");
         panelArr.clear();
      }
      System.out.println("##########" + board_Arr.size() + "" + " 보드불러왓음 사이즈는");
      for (int i = 0; i < board_Arr.size(); i++) {
         panelArr.add(new MyPanel2(sl_pn_scroll, target));
         pn_scroll.add(panelArr.get(i));
         target = panelArr.get(i);
      }
      System.out.println("##########" + panelArr.size() + "" + " 판넬어레이 사이즈는");
      size.setSize(10, panelsHeightSize(board_Arr.size()+1));

      // pn_2.setOpaque(false);
      scrollPane_1.getVerticalScrollBar().setUnitIncrement(30);

      scrollPane_1.getVerticalScrollBar().setUnitIncrement(30);

      System.out.println("boardgui 초기화 실행 완료!!!!!!!!!!");
      thread = new Thread(this);
      thread.start();
   }

   private void initfriend() {
      farr.clear();
      f_info_list.clear();
      pn_friend.removeAll();
      
      pn_friend = new JPanel();
      pn_friend.setOpaque(false);
      scroll_pn_friend.setViewportView(pn_friend);
      pn_friend.setLayout(null);
      size2 = new Dimension();
      farr = new Friend_DAO().list(LoggedIN.Logged_in_id);
      for (int i = 0; i < farr.size(); i++) {
         f_info_list.add(new MyPanelFriend());
         f_info_list.get(i).setBounds(10, i*45, 374, 40);
         f_info_list.get(i).lbl_string.setText(farr.get(i).getName() + " 님과 (서로친구)");
         pn_friend.add(f_info_list.get(i));
      }
      size2.setSize(10, 45*30+10);
      pn_friend.setPreferredSize(size2);
      
   }
   private void initPanelArr() {

      panelArr.clear();
      pn_scroll.removeAll();

      pn_1 = new MyPanel(pn_scroll, sl_pn_scroll);
      pn_scroll.add(pn_1); // 스크롤패널에 패널1을 위에 조건값으로 추가
      scrollPane_1.getVerticalScrollBar().setUnitIncrement(30);
      target = pn_1;
      init_boardArr();
      System.out.println("##########" + board_Arr.size() + "" + " 보드불러왓음 사이즈는");
      for (int i = 0; i < board_Arr.size(); i++) {
         panelArr.add(new MyPanel2(sl_pn_scroll, target));
         pn_scroll.add(panelArr.get(i));
         target = panelArr.get(i);
      }
      System.out.println("##########" + panelArr.size() + "" + " 판넬어레이 사이즈는");
      size.setSize(10, panelsHeightSize(board_Arr.size()+1));
      // pn_2.setOpaque(false);
      scrollPane_1.getVerticalScrollBar().setUnitIncrement(30);
      scrollPane_1.getVerticalScrollBar().setUnitIncrement(30);
   }

   private void sortBoardArrtime() {
      Date nowDate = new Date();
      ArrayList<Board_1_DTO> tempArr = new ArrayList<>();

      Collections.sort(board_Arr, new Comparator() {
         @Override
         public int compare(Object o1, Object o2) {
            Board_1_DTO b1 = (Board_1_DTO) o1;
            Board_1_DTO b2 = (Board_1_DTO) o2;
            return b1.getSettime().compareTo(b2.getSettime());
         }
      });

      for (Board_1_DTO board : board_Arr) {
         System.out.println("소트테스트 : " + board.getSettime());
      }

   }

   private synchronized void init_boardArr() {
      // board_Arr의 초기화 선택
      // 0.모든글보기 1.나의글보기 2.선택한 유저의 글모음
      board_Arr.clear();
      if (viewCaseNum == 0) {
         board_Arr = board_1_DAO.selectAllBoard1();
      } else if (viewCaseNum == 1) {
         board_Arr = board_1_DAO.selectMembersCapsules(member_id);
      } else {
         System.out.println("============Error!! Error!! Error!! Error!!===========");
         System.out.println("board 초기화넘버오류 발생 -> 현재 들어온 viewCaseNum = " + viewCaseNum);
         System.out.println("board_gui 호출시 파라메터 viewCaseNum값 입력과 호출을 다시살펴볼것");
         System.out.println("======================================================");
      }

   }

   private int panelsHeightSize(int count) {

      return count * 382;
   }

   private synchronized void Show() {
      Date nowDate = new Date();
      if (board_Arr.size() <= 0) {
         pn_1.lbl_title.setText("");
         pn_1.pn_1_howtime.setText("");
         pn_1.lbl_showtime.setText("");
         pn_1.get_icon(whereIconsrc(""));
         target = pn_1;
         panelArr.add(new MyPanel2(sl_pn_scroll, target));
         pn_scroll.add(panelArr.get(0));
         System.out.println("표시할글이 존재하지 않습니다.");
         panelArr.get(0).lbl_title.setText("아니.. 아직도 작성한 글이 없어요..?");
         panelArr.get(0).lbl_howtime.setText("해당 아이디로 작성한 글이 없습니다!");
         panelArr.get(0).lbl_showtime.setText("글을 작성해 보세요~");
         panelArr.get(0).get_icon(whereIconsrc(""));
      } else {
         pn_1.lbl_title.setText("");
         pn_1.pn_1_howtime.setText("");
         pn_1.lbl_showtime.setText("");
         pn_1.get_icon(whereIconsrc(""));
         size.setSize(10, panelsHeightSize(board_Arr.size()+1));
         // pn_2.setOpaque(false);
         scrollPane_1.getVerticalScrollBar().setUnitIncrement(30);
         scrollPane_1.getVerticalScrollBar().setUnitIncrement(30);
         for (int i = 0; i < board_Arr.size(); i++) {
            StringBuffer sb = new StringBuffer(board_Arr.get(i).getContent());

            try {
               setDate = timer.stringToDate(board_Arr.get(i).getSettime());
            } catch (ParseException e) {
               // TODO Auto-generated catch block
               e.printStackTrace();
            }
            if (board_Arr.size() > 0) {
               
               
               System.out.println("다른보드게시판생성중 " + i);
               System.out.println(panelArr.size());
               System.out.println(board_Arr.get(i).getTitle());
               panelArr.get(i).lbl_title.setText(board_Arr.get(i).getTitle());
               panelArr.get(i).lbl_showtime.setText(board_Arr.get(i).getSettime());
               if (!timer.isOpen(nowDate, setDate)) {
                  panelArr.get(i).lbl_howtime.setText(timer.howOpen(nowDate, setDate));
               } else {
                  panelArr.get(i).lbl_howtime.setText(board_Arr.get(i).getContent());
               }
               panelArr.get(i).get_icon(whereIconsrc(new Board_1_DAO().getWeather(board_Arr.get(i).getId())));
               panelArr.get(i).lbl_num.setText(Integer.toString(board_Arr.get(i).getId()));
               panelArr.get(i).lbl_name.setText(new Rel_Mem_Cap().membersCapsule(board_Arr.get(i).getId()));
               panelArr.get(i).likecount.setText(new Like_DAO().countLike(board_Arr.get(i).getId()));
               if (new Like_DAO().isLike(LoggedIN.Logged_in_id, panelArr.get(i).lbl_num.getText())) {
                  panelArr.get(i).like.setImage(panelArr.get(i).like2.getImage());
                  panelArr.get(i).pn_like.repaint();
               }

            }
         }
      }
   }

   
   
   private String whereIconsrc(String weather) {
      String src = "";
      if (weather.equals("맑음")) {
         src = "Image\\sun.png";
      } else if (weather.equals("흐림") || weather.equals("구름많음") || weather.equals("구름조금")) {
         src = "Image\\cloud.png";
      } else if (weather.equals("비")) {
         src = "Image\\rain.png";
      } else if (weather.equals("눈")) {
         src = "Image\\snow.png";
      }
      return src;
   }

   @Override
   public void run() {
      try {
         while (!Thread.currentThread().isInterrupted()) {
            if(isok) {
            initfriend();
            isok=false;
            }
            if(isok2) {
               init_boardArr();
               initPanelArr();
               viewCaseNum=0;
               isok2=false;
            }
            Show();
            System.out.println("##스레드 동작중##");
            Thread.sleep(1000);
         }

      } catch (InterruptedException e) {
         // 예상된 스레드 예외
      } finally {
         frame.dispose();
         System.out.println("############스레드는 정상종료되었습니다##############");
      }
   }

}