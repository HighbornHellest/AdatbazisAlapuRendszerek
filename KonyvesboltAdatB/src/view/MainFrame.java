package view;

import java.awt.HeadlessException;

import javax.swing.JFrame;

public class MainFrame extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8456560429229699542L;

	public MainFrame() throws HeadlessException {
		super("Könyvesbolt");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.pack();
		this.setVisible(true);
	}
	
}
