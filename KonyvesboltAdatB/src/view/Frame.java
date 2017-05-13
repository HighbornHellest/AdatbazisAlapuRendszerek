package view;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.*;
import javax.swing.JLabel;


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
	
    Button gomb;
    Panel login, leker, feltolt, modosit, admin;

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
		
		leker.setSize(new Dimension(1000,1000));
		leker.setLayout(new GridBagLayout());
		
		feltolt = new Panel();
		modosit = new Panel();
		admin = new Panel();
		MenuSor Menu = new MenuSor(this);
		
		leker.add(Menu.konyv_scrollpane);
		leker.add(Menu.album_scrollpane);
		leker.add(Menu.film_scrollpane);
		leker.add(Menu.kedvezmeny_scrollpane);
		this.setLayout(new BorderLayout());
		this.setSize(1920,1080);
		this.setResizable(false);
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



}