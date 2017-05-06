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
		feltolt = new Panel();
		modosit = new Panel();
		admin = new Panel();
		MenuSor Menu = new MenuSor(this);
		
		this.setLayout(new FlowLayout());
		this.setSize(1280,720);
		this.setResizable(false);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setVisible(true);
		this.setLocationRelativeTo(null);
		this.setTitle(a);
		
		
		
		
		
		//this.add(gomb);
		//itt van hozz�adva a fels� sor
		this.add(Menu);
		
	}



}