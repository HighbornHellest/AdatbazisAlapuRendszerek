package view;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;


public class Button extends JButton
{
	/**
	 * 
	 */
	private static final long serialVersionUID = -7637028804184653289L;
	MouseListener m1;
	 MouseAdapter lis;
	
	public Button()
	{
		m1 = new MouseListener()
		{

			@Override
			public void mouseClicked(MouseEvent arg0) {
			  //ide tegyétek az adatbázis eventeket
				
			}

			@Override
			public void mouseEntered(MouseEvent arg0) {}

			@Override
			public void mouseExited(MouseEvent arg0) {}

			@Override
			public void mousePressed(MouseEvent arg0) {}

			@Override
			public void mouseReleased(MouseEvent arg0) {}
			
		};

	}
	public Button(String a)
	{
		this.setText(a);
	
		//events
		
		m1 = new MouseListener()
		{

			@Override
			public void mouseClicked(MouseEvent arg0) {
			  //ide tegyétek az adatbázis eventeket
				
			}

			@Override
			public void mouseEntered(MouseEvent arg0) {}

			@Override
			public void mouseExited(MouseEvent arg0) {}

			@Override
			public void mousePressed(MouseEvent arg0) {}

			@Override
			public void mouseReleased(MouseEvent arg0) {}
			
		};

		
	}

}
