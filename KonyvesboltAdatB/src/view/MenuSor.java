package view;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

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
	@Override
	public void actionPerformed(ActionEvent e) //itt vanakka a kiírások a táblázatba!
	{
	    String actionCommand = e.getActionCommand();
		System.out.println(actionCommand);
		
		
	/*	if (actionCommand.equals("konyv"))
		{
			System.out.println("Könyv");
			
		}*/
		switch(actionCommand)
		{
			case "Konyv":
			{
				System.out.println(actionCommand);
				break;
			}
			case "Album":
			{
				System.out.println(actionCommand);
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
        /*createMenuPoint(Labels.konyv, "list_books");
        createMenuPoint("placeholder for Almbum","placeholder" );
        createMenuPoint("placeholder for Alkalmazott","placeholder" );
        createMenuPoint("placeholder  for Aruhaz","placeholder" );
        createMenuPoint("placeholder for Film","placeholder" );
        createMenuPoint("placeholder for Kedvezmeny","placeholder" );
        createMenuPoint("placeholder for Raktar","placeholder" );
        createMenuPoint("placeholder for Rendeles","placeholder" );
        createMenuPoint("placeholder for Termek","placeholder" );
        createMenuPoint("placeholder for Vasarlo","placeholder" );*/
        createMenuPoint(
        		"Lekerdezesek","Konyv","Almbum" ,"Alkalmazott",
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
