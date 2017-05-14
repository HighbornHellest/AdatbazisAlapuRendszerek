package view;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JScrollPane;
import javax.swing.JTable;

/**
 * @author Highborn_Hellest
 *
 */
public class MenuSor extends JMenuBar implements ActionListener
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 5218194030558631971L;

	/* (non-Javadoc)
	 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 */
	private Frame gui;
	
	//konyv
	JTable konyv;
	JScrollPane konyv_scrollpane;
	//almub
	JTable album;
	JScrollPane album_scrollpane;
	//alkalmazott
	JTable alkalmazott;
	JScrollPane alkalmazott_scrollpane;
	//film
	JTable film;
	JScrollPane film_scrollpane;
	//kedvezmeny
	JTable kedvezmeny;
	JScrollPane kedvezmeny_scrollpane;
	//Raktar
	JTable raktar;
	JScrollPane raktar_scrollpane;
	//rendeles
	JTable rendeles;
	JScrollPane rendeles_scrollpane;
	//vasarlo
	JTable vasarlo;
	JScrollPane vasarlo_scrollpane;
	
	
	
	@Override
	public void actionPerformed(ActionEvent e) //itt vanakka a kiírások a táblázatba!
	{
	    String actionCommand = e.getActionCommand();
		
	/*	if (actionCommand.equals("konyv"))
		{
			System.out.println("Könyv");
			
		}*/
		switch(actionCommand)
		{
			case "Konyv":
			{
				hideAll();
				Frame.getLeker().add(konyv_scrollpane);
				konyv_scrollpane.setVisible(true);
				gui.revalidate();
				break;
			}
			case "Album":
			{
				hideAll();
				Frame.getLeker().add(album_scrollpane);
				album_scrollpane.setVisible(true);
				gui.revalidate();
				break;
			}
			case "Alkalmazott":
			{
				hideAll();
				break;
			}
			case "Aruhaz":
			{
				hideAll();
				break;
			}
			case "Film":
			{
				hideAll();
				Frame.getLeker().add(film_scrollpane);
				film_scrollpane.setVisible(true);
				gui.revalidate();
				break;
			}
			case "Kedvezmeny":
			{
				
				hideAll();
				Frame.getLeker().add(kedvezmeny_scrollpane);
				kedvezmeny_scrollpane.setVisible(true);
				gui.revalidate();
				break;
			}
			case "Raktar":
			{
				break;
			}
			case "Rendeles":
			{
				break;
			}
			case "Termek":
			{
				break;
			}
			case "Vasarlo":
			{
				break;
			}
			default:
			{
				System.out.println("Nem káromkodunk kódban, de igazad van, valami tönkrement.");
				break;
			}
		
		}
		
		/* ezelapján kéne megcisnálni de ehhez kell a DAO-s cucc ameddig az nincs meg én nem tudom folytatni
		 * 
		 *  List<Customer> customers = gui.getController().getCustomers();

            // Csinálunk egy táblázatot, a CustomerTableModel alapjan, ami
            // megkapja a controltol a customereket
            JTable table = new JTable(new CustomerTableModel(customers));

            // A táblazatot rárakjuk egy ScrollPane-re, így ha az túl nagy lenne
            // az ablak méretéhez képest, akkor is görgetheto lesz
            JScrollPane container = new JScrollPane(table);
		 * 
		 * */
		
		
		
		
		
	}
	public void hideAll(){
		konyv_scrollpane.setVisible(false);
		album_scrollpane.setVisible(false);
		kedvezmeny_scrollpane.setVisible(false);
		film_scrollpane.setVisible(false);
		alkalmazott_scrollpane.setVisible(false);
		raktar_scrollpane.setVisible(false);
		vasarlo_scrollpane.setVisible(false);
		rendeles_scrollpane.setVisible(false);
		Frame.getLeker().removeAll();
		
	}
	public MenuSor(Frame gui)
	{
		super();
		this.gui = gui;
		//model.Label LABEL = new Label();
		//konyv
		konyv=new JTable(new KonyvTableModel());
		konyv_scrollpane = new JScrollPane(konyv);
		konyv_scrollpane.setVisible(false);
		
		//almub
		 album = new JTable(new AlbumTableModel() );
		 album_scrollpane = new JScrollPane(album);
		 album_scrollpane.setVisible(false);
		//alkalmazott
		 alkalmazott= new JTable();
		 alkalmazott_scrollpane= new JScrollPane(alkalmazott);
		//film
		 film= new JTable(new FilmTableModel());
		 film_scrollpane = new JScrollPane(film);
		 film_scrollpane.setVisible(false);
		//kedvezmeny
		 kedvezmeny = new JTable(new KedvezmenyTableModel());
		 kedvezmeny_scrollpane = new JScrollPane(kedvezmeny);
		 kedvezmeny_scrollpane.setVisible(false);
		 
		//Raktar
		 raktar= new JTable();
		 raktar_scrollpane= new JScrollPane(raktar);
		//rendeles
		 rendeles= new JTable();
		 rendeles_scrollpane= new JScrollPane(rendeles);
		//vasarlo
		 vasarlo= new JTable();
		 vasarlo_scrollpane=new JScrollPane(vasarlo);
		gui.doLayout();
        createMenuPoint(
        		"Lekerdezesek","Konyv","Album" ,"Alkalmazott","Aruhaz", "Film", "Kedvezmeny","Raktar", "Rendeles", "Termek", "Vasarlo");
        
     

        
	}
    private void createMenuPoint(String name, String... subnames)
    {
        // Létrehozunk egy menupontot az elsõ paraméter alapján
        JMenu menu = new JMenu(name);

        // A menupontot hozzáadjuk a BookShopMenuBar-hoz
        this.add(menu);

        // Az egyes menu itemeket a maradék paraméter értékeivel hozzuk létre
        for (String subname : subnames) {
            JMenuItem menuItem = new JMenuItem(subname);

            menu.add(menuItem);

            // Minden egyes menu itemet figyelünk
            // A menu itemek esetén a megfigyelést az ActionListener interfész
            // biztosítja, ezért a menubar implementálja ezt az interfészt és
            // felülírja az actionPerformed metódust
            menuItem.addActionListener(this);
        }
    }
    

	

}
