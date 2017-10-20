package main;


import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;


public class JComboBoxTest extends JFrame {
//�޺��ڽ��� ��Ÿ�� �����͸� �迭�� �����մϴ�.

String rainbow[] = {"������", "��Ȳ��", "�����", "�ʷϻ�", "�Ķ���", "����","�����"};

JComboBox<String> combo; 
JLabel msg;//���� �� �ϳ��� �����ϸ�, �󺧿� �޼����� ���ϴ�.

JComboBoxTest()
{
 setLayout(new BorderLayout());
 
 combo = new JComboBox<String>(rainbow);
 msg = new JLabel("      ");
 add( combo, BorderLayout.NORTH);
 add(msg, BorderLayout.CENTER);
 
 setSize(400, 300);
 setVisible(true);
 setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
 
 //�޺��ڽ��� addActionListener �̺�Ʈ ó���� �մϴ�.
  combo.addActionListener(new ActionListener() {
  
  @Override
  public void actionPerformed(ActionEvent e) {

   String color = combo.getSelectedItem().toString();
   msg.setText("���������� "+color+"�� �־��");
  }
 }
  );
}
}



