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
import dao.FilmDao;
import dao.KonyvDao;
import model.Album;
import model.AlbumTableModel;
import model.Alkalmazott;
import model.AlkalmazottTableModel;
import model.Film;
import model.FilmTableModel;
import model.KedvezmenyTableModel;
import model.Konyv;
import model.KonyvTableModel;

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
			break;
		}
		case "Film": {
			currentPane = film_scrollpane;
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
			break;
		}
		case "Raktar": {
			break;
		}
		case "Rendeles": {
			break;
		}
		case "Termek": {
			break;
		}
		case "Vasarlo": {
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
		raktar = new JTable();
		raktar_scrollpane = new JScrollPane(raktar);
		raktar.setAutoCreateRowSorter(true);
		// rendeles
		rendeles = new JTable();
		rendeles_scrollpane = new JScrollPane(rendeles);
		rendeles.setAutoCreateRowSorter(true);
		// vasarlo
		vasarlo = new JTable();
		vasarlo_scrollpane = new JScrollPane(vasarlo);
		vasarlo.setAutoCreateRowSorter(true);

		gombPanel = new JPanel();
		gombPanel.setLayout(new FlowLayout());
		add = new JButton("add");
		gombPanel.add(add);
		gombPanel.setVisible(false);
		Frame.getLeker().add(gombPanel, BorderLayout.SOUTH);
		gui.doLayout();
		createMenuPoint("Lekerdezesek", "Konyv", "Album", "Alkalmazott", "Aruhaz", "Film", "Kedvezmeny", "Raktar",
				"Rendeles", "Termek", "Vasarlo");

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
