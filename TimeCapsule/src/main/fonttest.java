package main;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.SpringLayout;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.CardLayout;
import javax.swing.SwingConstants;
import java.awt.Font;

public class fonttest {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;
	private JTextField textField_9;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					fonttest window = new fonttest();
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
	public fonttest() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 1168, 749);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		SpringLayout springLayout = new SpringLayout();
		frame.getContentPane().setLayout(springLayout);
		
		JPanel panel = new JPanel();
		springLayout.putConstraint(SpringLayout.NORTH, panel, 10, SpringLayout.NORTH, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, panel, 10, SpringLayout.WEST, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, panel, 675, SpringLayout.NORTH, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, panel, 1091, SpringLayout.WEST, frame.getContentPane());
		frame.getContentPane().add(panel);
		SpringLayout sl_panel = new SpringLayout();
		panel.setLayout(sl_panel);
		
		textField = new JTextField();
		sl_panel.putConstraint(SpringLayout.NORTH, textField, 25, SpringLayout.NORTH, panel);
		sl_panel.putConstraint(SpringLayout.EAST, textField, 423, SpringLayout.WEST, panel);
		textField.setFont(new Font("a조합명조B", Font.PLAIN, 12));
		textField.setHorizontalAlignment(SwingConstants.CENTER);
		textField.setText("\uC784\uC1A1\uD558");
		panel.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		sl_panel.putConstraint(SpringLayout.NORTH, textField_1, 85, SpringLayout.NORTH, panel);
		sl_panel.putConstraint(SpringLayout.WEST, textField_1, 31, SpringLayout.WEST, panel);
		sl_panel.putConstraint(SpringLayout.SOUTH, textField_1, -544, SpringLayout.SOUTH, panel);
		sl_panel.putConstraint(SpringLayout.EAST, textField_1, -658, SpringLayout.EAST, panel);
		sl_panel.putConstraint(SpringLayout.WEST, textField, 0, SpringLayout.WEST, textField_1);
		sl_panel.putConstraint(SpringLayout.SOUTH, textField, -24, SpringLayout.NORTH, textField_1);
		textField_1.setFont(new Font("a엄마의편지B", Font.ITALIC, 14));
		textField_1.setText("\uC784\uC1A1\uD558");
		textField_1.setColumns(10);
		panel.add(textField_1);
		
		textField_2 = new JTextField();
		sl_panel.putConstraint(SpringLayout.NORTH, textField_2, 146, SpringLayout.NORTH, panel);
		sl_panel.putConstraint(SpringLayout.WEST, textField_2, 31, SpringLayout.WEST, panel);
		sl_panel.putConstraint(SpringLayout.EAST, textField_2, -658, SpringLayout.EAST, panel);
		textField_2.setFont(new Font("a펜고딕B", Font.PLAIN, 12));
		textField_2.setText("\uC784\uC1A1\uD558");
		sl_panel.putConstraint(SpringLayout.SOUTH, textField_2, 61, SpringLayout.SOUTH, textField_1);
		textField_2.setColumns(10);
		panel.add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setFont(new Font("a엄마의편지B", Font.PLAIN, 14));
		textField_3.setText("\uC784\uC1A1\uD558");
		sl_panel.putConstraint(SpringLayout.NORTH, textField_3, 24, SpringLayout.SOUTH, textField_2);
		sl_panel.putConstraint(SpringLayout.WEST, textField_3, 31, SpringLayout.WEST, panel);
		sl_panel.putConstraint(SpringLayout.SOUTH, textField_3, 60, SpringLayout.SOUTH, textField_2);
		sl_panel.putConstraint(SpringLayout.EAST, textField_3, 423, SpringLayout.WEST, panel);
		textField_3.setColumns(10);
		panel.add(textField_3);
		
		textField_4 = new JTextField();
		textField_4.setFont(new Font("1훈하얀고양이 R", Font.ITALIC, 16));
		sl_panel.putConstraint(SpringLayout.WEST, textField_4, 31, SpringLayout.WEST, panel);
		sl_panel.putConstraint(SpringLayout.EAST, textField_4, -658, SpringLayout.EAST, panel);
		textField_4.setText("\uC784\uC1A1\uD558");
		sl_panel.putConstraint(SpringLayout.NORTH, textField_4, 26, SpringLayout.SOUTH, textField_3);
		sl_panel.putConstraint(SpringLayout.SOUTH, textField_4, 62, SpringLayout.SOUTH, textField_3);
		textField_4.setColumns(10);
		panel.add(textField_4);
		
		textField_5 = new JTextField();
		textField_5.setFont(new Font("a엄마의편지B", Font.PLAIN, 14));
		sl_panel.putConstraint(SpringLayout.WEST, textField_5, 31, SpringLayout.WEST, panel);
		sl_panel.putConstraint(SpringLayout.EAST, textField_5, -658, SpringLayout.EAST, panel);
		textField_5.setText("\uC784\uC1A1\uD558");
		sl_panel.putConstraint(SpringLayout.NORTH, textField_5, 20, SpringLayout.SOUTH, textField_4);
		sl_panel.putConstraint(SpringLayout.SOUTH, textField_5, -305, SpringLayout.SOUTH, panel);
		textField_5.setColumns(10);
		panel.add(textField_5);
		
		textField_6 = new JTextField();
		textField_6.setFont(new Font("a공간M", Font.PLAIN, 14));
		sl_panel.putConstraint(SpringLayout.WEST, textField_6, 31, SpringLayout.WEST, panel);
		sl_panel.putConstraint(SpringLayout.EAST, textField_6, -658, SpringLayout.EAST, panel);
		textField_6.setText("\uC784\uC1A1\uD558");
		sl_panel.putConstraint(SpringLayout.NORTH, textField_6, 28, SpringLayout.SOUTH, textField_5);
		sl_panel.putConstraint(SpringLayout.SOUTH, textField_6, -240, SpringLayout.SOUTH, panel);
		textField_6.setColumns(10);
		panel.add(textField_6);
		
		textField_7 = new JTextField();
		textField_7.setFont(new Font("DX시인과나", Font.PLAIN, 14));
		sl_panel.putConstraint(SpringLayout.WEST, textField_7, 31, SpringLayout.WEST, panel);
		sl_panel.putConstraint(SpringLayout.EAST, textField_7, -658, SpringLayout.EAST, panel);
		textField_7.setText("\uC784\uC1A1\uD558");
		sl_panel.putConstraint(SpringLayout.NORTH, textField_7, 24, SpringLayout.SOUTH, textField_6);
		sl_panel.putConstraint(SpringLayout.SOUTH, textField_7, -183, SpringLayout.SOUTH, panel);
		textField_7.setColumns(10);
		panel.add(textField_7);
		
		textField_8 = new JTextField();
		textField_8.setFont(new Font("문체부 바탕체", Font.PLAIN, 14));
		sl_panel.putConstraint(SpringLayout.WEST, textField_8, 31, SpringLayout.WEST, panel);
		sl_panel.putConstraint(SpringLayout.EAST, textField_8, -658, SpringLayout.EAST, panel);
		textField_8.setText("\uC784\uC1A1\uD558");
		sl_panel.putConstraint(SpringLayout.NORTH, textField_8, 23, SpringLayout.SOUTH, textField_7);
		sl_panel.putConstraint(SpringLayout.SOUTH, textField_8, 59, SpringLayout.SOUTH, textField_7);
		textField_8.setColumns(10);
		panel.add(textField_8);
		
		textField_9 = new JTextField();
		sl_panel.putConstraint(SpringLayout.WEST, textField_9, 31, SpringLayout.WEST, panel);
		sl_panel.putConstraint(SpringLayout.SOUTH, textField_9, -50, SpringLayout.SOUTH, panel);
		textField_9.setColumns(10);
		panel.add(textField_9);
	}
}
