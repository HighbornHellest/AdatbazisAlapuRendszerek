package view;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import model.Label;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JScrollPane;
import javax.swing.JTable;
/**
 * @author SZLXAGT.SZE Szûrszabó Levente  h669845
 */


/**
 * @author Highborn_Hellest
 *
 */
public class MenuSor extends JMenuBar implements ActionListener
{

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
	//Termek
	JTable termek;
	JScrollPane termek_scrollpane;
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
				//visiblityk
				album.setVisible(false);
				album_scrollpane.setVisible(false);
				konyv.setVisible(true);
				konyv_scrollpane.setVisible(true);
				
				
				System.out.println(actionCommand);
				
				album_scrollpane.repaint(); album.repaint();
				;gui.revalidate();
				break;
			}
			case "Album":
			{
				//visiblityk
				konyv.setVisible(false);
				konyv_scrollpane.setVisible(false);

				album.setVisible(true);
				album_scrollpane.setVisible(true);
				
				
				
				System.out.println(actionCommand);
				
				album_scrollpane.repaint(); album.repaint();
				;gui.revalidate();
				break;
			}
			case "Alkalmazott":
			{
				System.out.println(actionCommand);
				break;
			}
			case "Aruhaz":
			{
				System.out.println(actionCommand);
				break;
			}
			case "Film":
			{
				System.out.println(actionCommand);
				break;
			}
			case "Kedvezmeny":
			{
				System.out.println(actionCommand);
				break;
			}
			case "Raktar":
			{
				System.out.println(actionCommand);
				break;
			}
			case "Rendeles":
			{
				System.out.println(actionCommand);
				break;
			}
			case "Termek":
			{
				System.out.println(actionCommand);
				break;
			}
			case "Vasarlo":
			{
				System.out.println(actionCommand);
				break;
			}
			default:
			{
				System.out.println("Valami el van baszva mert ez nem futhat le");
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
	
	public MenuSor(Frame gui)
	{
		super();
		this.gui = gui;
		model.Label LABEL = new Label();
		//konyv
		konyv=new JTable(new KonyvTableModel());
		konyv_scrollpane = new JScrollPane(konyv);
		konyv_scrollpane.setVisible(false);
		
		//almub
		 album = new JTable(new AlbumTableModel() );
		 album_scrollpane = new JScrollPane(album);
		 album_scrollpane.setVisible(false);
		/*//alkalmazott
		 alkalmazott= new JTable();
		 alkalmazott_scrollpane;
		//film
		 film= new JTable();
		 film_scrollpane;
		//kedvezmeny
		 kedvezmeny =new JTable();
		 kedvezmeny_scrollpane;
		//Raktar
		 raktar= new JTable();
		 raktar_scrollpane;
		//rendeles
		 rendeles= new JTable();
		 rendeles_scrollpane;
		//Termek
		 termek= new JTable();
		 termek_scrollpane;
		//vasarlo
		 vasarlo= new JTable();
		 vasarlo_scrollpane;*/
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		gui.doLayout();
		//konyv_scrollpane.setVisible(false);
		//
        createMenuPoint(
        		"Lekerdezesek","Konyv","Album" ,"Alkalmazott",
        		"Aruhaz", "Film", "Kedvezmeny",
        		"Raktar", "Rendeles", "Termek", "Vasarlo");
        
     

        
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
