package main;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.SpringLayout;
import javax.swing.JTextField;
import java.awt.Font;

public class font {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					font window = new font();
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
	public font() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 733, 564);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		SpringLayout springLayout = new SpringLayout();
		frame.getContentPane().setLayout(springLayout);
		
		textField = new JTextField();
		textField.setText("\uC544\uC774\uB514\uB97C \uC785\uB825\uD574\uC8FC\uC138\uC694");
		springLayout.putConstraint(SpringLayout.NORTH, textField, 37, SpringLayout.NORTH, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, textField, 63, SpringLayout.WEST, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, textField, 64, SpringLayout.NORTH, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, textField, 253, SpringLayout.WEST, frame.getContentPane());
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setFont(new Font("김남윤체", Font.PLAIN, 15));
		textField_1.setText("\uC544\uC774\uB514\uB97C \uC785\uB825\uD574\uC8FC\uC138\uC694");
		springLayout.putConstraint(SpringLayout.NORTH, textField_1, 22, SpringLayout.SOUTH, textField);
		springLayout.putConstraint(SpringLayout.WEST, textField_1, 63, SpringLayout.WEST, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, textField_1, 253, SpringLayout.WEST, frame.getContentPane());
		textField_1.setColumns(10);
		frame.getContentPane().add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setFont(new Font("DX경필명조B", Font.PLAIN, 15));
		textField_2.setText("\uC544\uC774\uB514\uB97C \uC785\uB825\uD574\uC8FC\uC138\uC694");
		springLayout.putConstraint(SpringLayout.NORTH, textField_2, 139, SpringLayout.NORTH, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, textField_2, -360, SpringLayout.SOUTH, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, textField_1, -26, SpringLayout.NORTH, textField_2);
		springLayout.putConstraint(SpringLayout.WEST, textField_2, 0, SpringLayout.WEST, textField);
		springLayout.putConstraint(SpringLayout.EAST, textField_2, 0, SpringLayout.EAST, textField);
		textField_2.setColumns(10);
		frame.getContentPane().add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setFont(new Font("DX시인과나", Font.PLAIN, 15));
		textField_3.setText("\uC544\uC774\uB514\uB97C \uC785\uB825\uD574\uC8FC\uC138\uC694");
		springLayout.putConstraint(SpringLayout.NORTH, textField_3, 23, SpringLayout.SOUTH, textField_2);
		springLayout.putConstraint(SpringLayout.WEST, textField_3, 63, SpringLayout.WEST, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, textField_3, 50, SpringLayout.SOUTH, textField_2);
		springLayout.putConstraint(SpringLayout.EAST, textField_3, 0, SpringLayout.EAST, textField);
		textField_3.setColumns(10);
		frame.getContentPane().add(textField_3);
		
		textField_4 = new JTextField();
		textField_4.setFont(new Font("조선일보명조", Font.PLAIN, 15));
		textField_4.setText("\uC544\uC774\uB514\uB97C \uC785\uB825\uD574\uC8FC\uC138\uC694");
		springLayout.putConstraint(SpringLayout.NORTH, textField_4, 34, SpringLayout.SOUTH, textField_3);
		springLayout.putConstraint(SpringLayout.WEST, textField_4, 63, SpringLayout.WEST, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, textField_4, 61, SpringLayout.SOUTH, textField_3);
		springLayout.putConstraint(SpringLayout.EAST, textField_4, 0, SpringLayout.EAST, textField);
		textField_4.setColumns(10);
		frame.getContentPane().add(textField_4);
	}

}
