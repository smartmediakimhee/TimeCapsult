package main;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.SpringLayout;
import javax.swing.JTextField;
import java.awt.Font;

public class font {

	private JFrame frame;
	private JTextField txtIn;
	private JTextField txtInputYourPassword;
	private JTextField txtInputYourPassword_4;
	private JTextField txtInputYourPassword_5;
	private JTextField txtInputYourPassword_3;
	private JTextField txtInputYourPassword_1;
	private JTextField txtInputYourPassword_2;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;

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
		
		txtIn = new JTextField();
		springLayout.putConstraint(SpringLayout.SOUTH, txtIn, 147, SpringLayout.NORTH, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, txtIn, -54, SpringLayout.EAST, frame.getContentPane());
		txtIn.setFont(new Font("a연애소설", Font.PLAIN, 17));
		txtIn.setText("input your password");
		frame.getContentPane().add(txtIn);
		txtIn.setColumns(10);
		
		txtInputYourPassword = new JTextField();
		springLayout.putConstraint(SpringLayout.NORTH, txtInputYourPassword, 6, SpringLayout.SOUTH, txtIn);
		springLayout.putConstraint(SpringLayout.WEST, txtInputYourPassword, 473, SpringLayout.WEST, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, txtInputYourPassword, 0, SpringLayout.EAST, txtIn);
		txtInputYourPassword.setFont(new Font("a시나리오", Font.PLAIN, 20));
		txtInputYourPassword.setText("input your password");
		txtInputYourPassword.setColumns(10);
		frame.getContentPane().add(txtInputYourPassword);
		
		txtInputYourPassword_4 = new JTextField();
		springLayout.putConstraint(SpringLayout.NORTH, txtInputYourPassword_4, 33, SpringLayout.NORTH, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, txtInputYourPassword_4, 63, SpringLayout.WEST, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, txtInputYourPassword_4, -464, SpringLayout.EAST, frame.getContentPane());
		txtInputYourPassword_4.setFont(new Font("a조합명조M", Font.PLAIN, 15));
		txtInputYourPassword_4.setText("input your password");
		txtInputYourPassword_4.setColumns(10);
		frame.getContentPane().add(txtInputYourPassword_4);
		
		txtInputYourPassword_5 = new JTextField();
		springLayout.putConstraint(SpringLayout.WEST, txtInputYourPassword_5, 473, SpringLayout.WEST, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, txtInputYourPassword_5, -54, SpringLayout.EAST, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, txtInputYourPassword_4, -26, SpringLayout.NORTH, txtInputYourPassword_5);
		springLayout.putConstraint(SpringLayout.NORTH, txtInputYourPassword_5, 86, SpringLayout.NORTH, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, txtInputYourPassword_5, -413, SpringLayout.SOUTH, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.NORTH, txtIn, 7, SpringLayout.SOUTH, txtInputYourPassword_5);
		txtInputYourPassword_5.setFont(new Font("DX시인과나", Font.PLAIN, 15));
		txtInputYourPassword_5.setText("input your password");
		txtInputYourPassword_5.setColumns(10);
		frame.getContentPane().add(txtInputYourPassword_5);
		
		txtInputYourPassword_3 = new JTextField();
		springLayout.putConstraint(SpringLayout.NORTH, txtInputYourPassword_3, 0, SpringLayout.NORTH, txtInputYourPassword_5);
		springLayout.putConstraint(SpringLayout.WEST, txtInputYourPassword_3, 0, SpringLayout.WEST, txtInputYourPassword_4);
		springLayout.putConstraint(SpringLayout.SOUTH, txtInputYourPassword_3, -413, SpringLayout.SOUTH, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, txtInputYourPassword_3, -464, SpringLayout.EAST, frame.getContentPane());
		txtInputYourPassword_3.setFont(new Font("a휘리릭퐁", Font.PLAIN, 20));
		txtInputYourPassword_3.setText("input your password");
		txtInputYourPassword_3.setColumns(10);
		frame.getContentPane().add(txtInputYourPassword_3);
		
		txtInputYourPassword_1 = new JTextField();
		springLayout.putConstraint(SpringLayout.EAST, txtInputYourPassword_1, -464, SpringLayout.EAST, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, txtIn, 220, SpringLayout.EAST, txtInputYourPassword_1);
		springLayout.putConstraint(SpringLayout.SOUTH, txtInputYourPassword, 45, SpringLayout.NORTH, txtInputYourPassword_1);
		springLayout.putConstraint(SpringLayout.NORTH, txtInputYourPassword_1, 135, SpringLayout.NORTH, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, txtInputYourPassword_1, 63, SpringLayout.WEST, frame.getContentPane());
		txtInputYourPassword_1.setText("input your password");
		txtInputYourPassword_1.setFont(new Font("a엄마의편지B", Font.PLAIN, 16));
		txtInputYourPassword_1.setColumns(10);
		frame.getContentPane().add(txtInputYourPassword_1);
		
		txtInputYourPassword_2 = new JTextField();
		springLayout.putConstraint(SpringLayout.NORTH, txtInputYourPassword_2, 21, SpringLayout.SOUTH, txtInputYourPassword_1);
		springLayout.putConstraint(SpringLayout.WEST, txtInputYourPassword_2, 63, SpringLayout.WEST, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, txtInputYourPassword_2, -464, SpringLayout.EAST, frame.getContentPane());
		txtInputYourPassword_2.setText("input your password");
		txtInputYourPassword_2.setFont(new Font("a엄마의편지L", Font.PLAIN, 16));
		txtInputYourPassword_2.setColumns(10);
		frame.getContentPane().add(txtInputYourPassword_2);
		
		textField = new JTextField();
		springLayout.putConstraint(SpringLayout.NORTH, textField, 11, SpringLayout.SOUTH, txtInputYourPassword_2);
		springLayout.putConstraint(SpringLayout.WEST, textField, 0, SpringLayout.WEST, txtInputYourPassword_4);
		springLayout.putConstraint(SpringLayout.EAST, textField, 0, SpringLayout.EAST, txtInputYourPassword_4);
		textField.setText("input your password");
		textField.setFont(new Font("a시나리오", Font.PLAIN, 20));
		textField.setColumns(10);
		frame.getContentPane().add(textField);
		
		textField_1 = new JTextField();
		springLayout.putConstraint(SpringLayout.NORTH, textField_1, 6, SpringLayout.SOUTH, textField);
		springLayout.putConstraint(SpringLayout.WEST, textField_1, 0, SpringLayout.WEST, txtInputYourPassword_4);
		springLayout.putConstraint(SpringLayout.EAST, textField_1, 0, SpringLayout.EAST, txtInputYourPassword_4);
		textField_1.setText("input your password");
		textField_1.setFont(new Font("a엄마의편지M", Font.PLAIN, 17));
		textField_1.setColumns(10);
		frame.getContentPane().add(textField_1);
		
		textField_2 = new JTextField();
		springLayout.putConstraint(SpringLayout.NORTH, textField_2, 10, SpringLayout.SOUTH, textField_1);
		springLayout.putConstraint(SpringLayout.WEST, textField_2, 0, SpringLayout.WEST, txtInputYourPassword_4);
		springLayout.putConstraint(SpringLayout.EAST, textField_2, 0, SpringLayout.EAST, txtInputYourPassword_4);
		textField_2.setText("input your password");
		textField_2.setFont(new Font("a조합명조M", Font.PLAIN, 17));
		textField_2.setColumns(10);
		frame.getContentPane().add(textField_2);
		
		textField_3 = new JTextField();
		springLayout.putConstraint(SpringLayout.NORTH, textField_3, 17, SpringLayout.SOUTH, textField_2);
		springLayout.putConstraint(SpringLayout.WEST, textField_3, 0, SpringLayout.WEST, txtInputYourPassword_4);
		springLayout.putConstraint(SpringLayout.EAST, textField_3, 0, SpringLayout.EAST, txtInputYourPassword_4);
		textField_3.setText("input your password");
		textField_3.setFont(new Font("a명월M", Font.PLAIN, 15));
		textField_3.setColumns(10);
		frame.getContentPane().add(textField_3);
	}

}
