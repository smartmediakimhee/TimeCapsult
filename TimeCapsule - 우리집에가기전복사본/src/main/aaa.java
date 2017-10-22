package main;

import java.awt.EventQueue;

import javax.swing.JFrame;
import com.toedter.calendar.JDayChooser;
import java.awt.BorderLayout;

public class aaa {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					aaa window = new aaa();
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
	public aaa() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JDayChooser dayChooser = new JDayChooser();
		frame.getContentPane().add(dayChooser, BorderLayout.CENTER);
		dayChooser.getDayPanel();
	}

}
