package main;

import java.awt.EventQueue;
import java.awt.Window;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JFrame;
import javax.swing.SpringLayout;
import javax.swing.JPanel;
import java.awt.Component;
import javax.swing.Box;
import com.toedter.calendar.JCalendar;
import java.awt.CardLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class JCal {
   private JFrame frame;
   String Month;

   /**
    * Launch the application.
    */
   public static void main(String[] args) {
      EventQueue.invokeLater(new Runnable() {
         public void run() {
            try {
               JCal window = new JCal();
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
   public JCal() {
      initialize();
   }

   /**
    * Initialize the contents of the frame.
    */
   private void initialize() {
	  
      frame = new JFrame();
      frame.setBounds(100, 100, 302, 247);
      frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
      SpringLayout springLayout = new SpringLayout();
      frame.getContentPane().setLayout(springLayout);
      
      JPanel panel = new JPanel();
      springLayout.putConstraint(SpringLayout.NORTH, panel, 0, SpringLayout.NORTH, frame.getContentPane());
      springLayout.putConstraint(SpringLayout.WEST, panel, 0, SpringLayout.WEST, frame.getContentPane());
      springLayout.putConstraint(SpringLayout.SOUTH, panel, 209, SpringLayout.NORTH, frame.getContentPane());
      springLayout.putConstraint(SpringLayout.EAST, panel, 286, SpringLayout.WEST, frame.getContentPane());
      frame.getContentPane().add(panel);
      panel.setLayout(new CardLayout(0, 0));
      
      JCalendar calendar = new JCalendar();
      
      panel.add(calendar, "name_28143323268548");
      
      calendar.addPropertyChangeListener(new PropertyChangeListener() {
         
         @Override
         public void propertyChange(PropertyChangeEvent evt) {
            // TODO Auto-generated method stub
             Date d = calendar.getDate();
              SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
              postGUI.date = format.format(d);
   
              if(d.getMonth()<9) {
            	  Month = "0"+(d.getMonth()+1);
              } else {
            	  Month = d.getMonth()+1+"";
              }
              String date =(d.getYear()+1900)+""+Month+""+d.getDate();
              
              System.out.println(date);
              postGUI.getDate(date);
         }

         
      });
      
       
         
              
   }
}