package view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagLayout;
import java.awt.GridLayout;

import javax.swing.JFrame;


public class Frame extends JFrame
{
	
	
	//Layoutokat majd válasszuk ki azalapján, hogy mennyi cucc kell.
	/*Azt, hogy mi látszódjon meg mi nem éppen mikor, azt easy 
	* a "setvisible" változókat kell állítgatni.
	* értelme úgylenne, hogy panelekre teszünk fel mindent
	* így mindig csak 1 label láthatóvá tétele telejsen másik 
	* scene-t eredményez, bár kicsit jobban pazarolja a memóriát.
	*/
    /*int width = 1;
    int height = 1;
    GridLayout gridLay = new GridLayout(width, height);*/
	
    /**
	 * 
	 */
	private static final long serialVersionUID = -5778152951530634035L;
	Button gomb;
    private static Panel login, leker, feltolt, modosit, admin;

	public Frame()
	{
		gomb = new Button();
		login = new Panel(); leker = new Panel(); feltolt = new Panel(); modosit = new Panel(); admin = new Panel();
		this.setLayout(new FlowLayout());
		this.setSize(800,600);
		this.setResizable(false);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setVisible(true);
		this.setLocationRelativeTo(null);
		this.add(gomb);

	}
	
	public Frame(String a)
	{
		//gomb = new Button("asdasda");
		login = new Panel();
		leker = new Panel();
		leker.setLayout(new BorderLayout());
		
		feltolt = new Panel();
		modosit = new Panel();
		admin = new Panel();
		MenuSor Menu = new MenuSor(this);
		
		this.setLayout(new BorderLayout());
		this.setSize(800,600);
		this.setResizable(true);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setVisible(true);
		this.setLocationRelativeTo(null);
		this.setTitle(a);
		
		
		
		
		
		//this.add(gomb);
		//itt van hozz�adva a fels� sor
		//this.add(Menu, BorderLayout.NORTH);
		this.add(Menu, BorderLayout.NORTH);
		this.add(leker, BorderLayout.CENTER);
		leker.setVisible(true);
		
		/*this.add(Menu.album_scrollpane);
		this.add(Menu.konyv_scrollpane);*/
		
		//Menu.konyv.setVisible(false);
		
		
		
		
	}

	public static Panel getLeker() {
		return leker;
	}

	public static void setLeker(Panel leker) {
		Frame.leker = leker;
	}



}