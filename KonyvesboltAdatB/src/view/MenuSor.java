package view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Objects;

import javax.swing.JButton;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import dao.AlbumDao;
import dao.AlkalmazottDao;
import dao.AruhazDao;
import dao.FilmDao;
import dao.KedvezmenyDao;
import dao.KonyvDao;
import dao.RaktarDao;
import dao.RendelesDao;
import dao.VasarloDao;
import model.Album;
import model.AlbumTableModel;
import model.Alkalmazott;
import model.AlkalmazottTableModel;
import model.Aruhaz;
import model.AruhazTableModel;
import model.Film;
import model.FilmTableModel;
import model.Kedvezmeny;
import model.KedvezmenyTableModel;
import model.Konyv;
import model.KonyvTableModel;
import model.Raktar;
import model.RaktarTableModel;
import model.Rendeles;
import model.RendelesTableModel;
import model.ResettableTableModel;
import model.Vasarlo;
import model.VasarloTableModel;

/**
 * @author Highborn_Hellest
 *
 */
public class MenuSor extends JMenuBar implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5218194030558631971L;

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 */
	private Frame gui;
	private JTable selectedTable;

	// konyv
	JTable konyv;
	JScrollPane konyv_scrollpane;
	// almub
	JTable album;
	JScrollPane album_scrollpane;
	// alkalmazott
	JTable alkalmazott;
	JScrollPane alkalmazott_scrollpane;
	// film
	JTable film;
	JScrollPane film_scrollpane;
	// kedvezmeny
	JTable kedvezmeny;
	JScrollPane kedvezmeny_scrollpane;
	// Raktar
	JTable raktar;
	JScrollPane raktar_scrollpane;
	// rendeles
	JTable rendeles;
	JScrollPane rendeles_scrollpane;
	// vasarlo
	JTable vasarlo;
	JScrollPane vasarlo_scrollpane;
	JScrollPane currentPane;

	private JPanel gombPanel;

	private JButton add;
	private JButton delete;
	

	private JScrollPane aruhaz_scrollpane;
	private JTable aruhaz;


	@Override
	public void actionPerformed(ActionEvent e) // itt vanakka a kiírások a
												// táblázatba!
	{
		String actionCommand = e.getActionCommand();

		/*
		 * if (actionCommand.equals("konyv")) { System.out.println("Könyv");
		 * 
		 * }
		 */
		hideAll();
		switch (actionCommand) {
		case "Konyv": {
			selectedTable=konyv;
			currentPane = konyv_scrollpane;
			add.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					Konyv k = new Konyv();
					InputWindow iw = new InputWindow(KonyvTableModel.COLUMN_NAMES);
					k.setFromArray(iw.showForm());
					KonyvDao.addKonyv(k);
					((KonyvTableModel) konyv.getModel()).reset();
					gui.revalidate();
				}
			});
			
			break;
		}
		case "Album": {
			currentPane = album_scrollpane;
			selectedTable=album;
			add.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					Album a=new Album();
					InputWindow iw = new InputWindow(AlbumTableModel.COLUMN_NAMES);
					a.setFromArray(iw.showForm());
					AlbumDao.addAlbum(a);
					((AlbumTableModel) album.getModel()).reset();
					gui.revalidate();
				}
			});
			break;
		}
		case "Alkalmazott": {
			currentPane = alkalmazott_scrollpane;
			selectedTable=alkalmazott;
			add.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					Alkalmazott a=new Alkalmazott();
					InputWindow iw = new InputWindow(AlkalmazottTableModel.COLUMN_NAMES);
					a.setFromArray(iw.showForm());
					AlkalmazottDao.addAlkalmazott(a);
					((AlkalmazottTableModel)alkalmazott.getModel()).reset();
					gui.revalidate();
				}
			});
			break;
		}
		case "Aruhaz": {
			currentPane = aruhaz_scrollpane;
			selectedTable=aruhaz;
			add.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					Aruhaz a=new Aruhaz();
					InputWindow iw = new InputWindow(AruhazTableModel.COLUMN_NAMES);
					a.setFromArray(iw.showForm());
					AruhazDao.addAruhaz(a);
					((AruhazTableModel) aruhaz.getModel()).reset();
					gui.revalidate();
				}
			});
			break;
		}
		case "Film": {
			currentPane = film_scrollpane;
			selectedTable=film;
			add.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					Film f=new Film();
					InputWindow iw = new InputWindow(FilmTableModel.COLUMN_NAMES);
					f.setFromArray(iw.showForm());
					FilmDao.addFilm(f);
					((FilmTableModel) film.getModel()).reset();
					gui.revalidate();
				}
			});
			break;
		}
		case "Kedvezmeny": {
			currentPane = kedvezmeny_scrollpane;
			selectedTable=kedvezmeny;
			add.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					Kedvezmeny k=new Kedvezmeny();
					InputWindow iw = new InputWindow(KedvezmenyTableModel.COLUMN_NAMES);
					k.setFromArray(iw.showForm());
					KedvezmenyDao.addKedvezmeny(k);
					((ResettableTableModel) selectedTable.getModel()).reset();
					gui.revalidate();
				}
			});
			break;
		}
		case "Raktar": {
			currentPane = raktar_scrollpane;
			selectedTable=raktar;
			add.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					Raktar r=new Raktar();
					InputWindow iw = new InputWindow(RaktarTableModel.COLUMN_NAMES);
					r.setFromArray(iw.showForm());
					RaktarDao.addRaktar(r);
					((ResettableTableModel) selectedTable.getModel()).reset();
					gui.revalidate();
				}
			});
			break;
		}
		case "Rendeles": {
			currentPane = rendeles_scrollpane;
			selectedTable=rendeles;
			add.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					Rendeles r=new Rendeles();
					InputWindow iw = new InputWindow(RaktarTableModel.COLUMN_NAMES);
					r.setFromArray(iw.showForm());
					RendelesDao.addRendeles(r);
					((ResettableTableModel) selectedTable.getModel()).reset();
					gui.revalidate();
				}
			});
			break;
		}
		case "Vasarlo": {
			currentPane = vasarlo_scrollpane;
			selectedTable=vasarlo;
			add.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					Vasarlo v=new Vasarlo();
					InputWindow iw = new InputWindow(RaktarTableModel.COLUMN_NAMES);
					v.setFromArray(iw.showForm());
					VasarloDao.addVasarlo(v);
					((ResettableTableModel) selectedTable.getModel()).reset();
					gui.revalidate();
				}
			});
			break;
		}
		default: {
			System.out.println("Nem káromkodunk a kódban, de igazad van, valami tönkrement.");
			break;
		}

		}
		Frame.getLeker().add(currentPane, BorderLayout.CENTER);
		gui.revalidate();

		/*
		 * ezelapján kéne megcisnálni de ehhez kell a DAO-s cucc ameddig az
		 * nincs meg én nem tudom folytatni
		 * 
		 * List<Customer> customers = gui.getController().getCustomers();
		 * 
		 * // Csinálunk egy táblázatot, a CustomerTableModel alapjan, ami //
		 * megkapja a controltol a customereket JTable table = new JTable(new
		 * CustomerTableModel(customers));
		 * 
		 * // A táblazatot rárakjuk egy ScrollPane-re, így ha az túl nagy lenne
		 * // az ablak méretéhez képest, akkor is görgetheto lesz JScrollPane
		 * container = new JScrollPane(table);
		 * 
		 */

	}

	public void hideAll() {
		if (!Objects.equals(currentPane, null))
			Frame.getLeker().remove(currentPane);
		if (!gombPanel.isVisible())
			gombPanel.setVisible(true);
		for (ActionListener a : add.getActionListeners()) {
			add.removeActionListener(a);
		}
	}

	public MenuSor(Frame gui) {
		super();
		this.gui = gui;
		// model.Label LABEL = new Label();
		// konyv
		konyv = new JTable(new KonyvTableModel());
		konyv.setAutoCreateRowSorter(true);
		konyv_scrollpane = new JScrollPane(konyv);
		konyv_scrollpane.setVisible(true);

		// album
		album = new JTable(new AlbumTableModel());
		album_scrollpane = new JScrollPane(album);
		album.setAutoCreateRowSorter(true);
		album_scrollpane.setVisible(true);
		// áruház
		aruhaz = new JTable(new AruhazTableModel());
		aruhaz_scrollpane = new JScrollPane(aruhaz);
		aruhaz.setAutoCreateRowSorter(true);
		aruhaz_scrollpane.setVisible(true);
		// alkalmazott
		alkalmazott = new JTable(new AlkalmazottTableModel());
		alkalmazott_scrollpane = new JScrollPane(alkalmazott);
		alkalmazott.setAutoCreateRowSorter(true);
		// film
		film = new JTable(new FilmTableModel());
		film_scrollpane = new JScrollPane(film);
		film_scrollpane.setVisible(true);
		film.setAutoCreateRowSorter(true);
		// kedvezmeny
		kedvezmeny = new JTable(new KedvezmenyTableModel());
		kedvezmeny_scrollpane = new JScrollPane(kedvezmeny);
		kedvezmeny_scrollpane.setVisible(true);
		kedvezmeny.setAutoCreateRowSorter(true);
		// Raktar
		raktar = new JTable(new RaktarTableModel());
		raktar_scrollpane = new JScrollPane(raktar);
		raktar.setAutoCreateRowSorter(true);
		// rendeles
		rendeles = new JTable(new RendelesTableModel());
		rendeles_scrollpane = new JScrollPane(rendeles);
		rendeles.setAutoCreateRowSorter(true);
		// vasarlo
		vasarlo = new JTable(new VasarloTableModel());
		vasarlo_scrollpane = new JScrollPane(vasarlo);
		vasarlo.setAutoCreateRowSorter(true);

		gombPanel = new JPanel();
		gombPanel.setLayout(new FlowLayout());
		add = new JButton("add");
		delete=new JButton("delete selected");
		gombPanel.add(add);
		gombPanel.add(delete);
		delete.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				int row=selectedTable.getSelectedRow();
				if(row>-1){
					Integer id=(Integer) selectedTable.getValueAt(row, 0);
					((ResettableTableModel)selectedTable.getModel()).delete(id);
					((ResettableTableModel)selectedTable.getModel()).reset();
				}
			}
		});
		gombPanel.setVisible(false);
		Frame.getLeker().add(gombPanel, BorderLayout.SOUTH);
		gui.doLayout();
		createMenuPoint("Lekerdezesek", "Konyv", "Album", "Alkalmazott", "Aruhaz", "Film", "Kedvezmeny", "Raktar",
				"Rendeles", "Vasarlo");

	}

	private void createMenuPoint(String name, String... subnames) {
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
