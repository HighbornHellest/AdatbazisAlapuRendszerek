package view;
import java.sql.Date;

/**
 * @author SZLXAGT.SZE Szûrszabó Levente  h669845
 */

/**
 * @author Highborn_Hellest
 *
 */


public class Labels //ezek csak cimkék
{

    // General labels
    public final static String name = "Name";
    public final static String ok = "OK";
    public final static String cancel = "Cancel";
    public final static String error = "Error";
    public final static String empty = "";
    public final static String unknown = "Unknown";

    // Main window
    public static final String main_window_title_format = "Book Shop (%1$s)";
    public static final String main_window_title_unknown_user = "ismeretlen";

    // Customer labels
    public final static String customer = "Customer";
    public final static String add_customer = "Add customer";
    public final static String list_customers = "List customers";
    public final static String gender = "Gender";
    public final static String female = "Female";
    public final static String male = "Male";
    public final static String age = "Age";
    public final static String grantee = "Grantee";
    public final static String university = "University";
    public final static String college = "College";
    public final static String high_school = "High school";
    public final static String elementary_school = "Elementary school";
    public final static String[] qualifications = {
        
    		
    		
    	Labels.university,
        Labels.college,
        Labels.high_school,
        Labels.elementary_school
    };
    public final static String qualification = "Qualification";
    public final static String student = "Student";
    public final static String rented = "Rented";
    public final static String customer_name_is_required = "Customer name is required!";
    public final static String customer_exists = "Customer already exists!";

    // Book labels
  /*  public final static String book = "Book";
    public final static String buy_book = "Buy book";
    public final static String list_books = "List books";
    public final static String author = "Author";
    public final static String title = "Title";
    public final static String year = "Year";
    public final static String category = "Category";
    public final static String price = "Price";
    public final static String piece = "Piece";
    public final static String sci_fi = "sci-fi";
    public final static String horror = "horror";
    public final static String drama = "Dráma";
    public final static String[] categories = new String[]
    {
        Labels.sci_fi,
        Labels.horror,
        Labels.drama
    };*/
    public static String konyv = "Konyv";
    public static String oldalSzam = "Oldalszam";
    public static String kiadIdo;
	// int?
	public static String hanyadikKiadas = "Kiaads";
	public static String szerzo = "Szerzo";
	public static String tarsSzerzo = "Tarsszerzo";
	public static String kiado = "Kiadasi ido";
	public static String vasarlasSzam = "Vasarlasok szama";
	public static String meret = "Meret (dim)";
	public static String kotes = "Kotes";
	public static String mufaj = "Mufaj";
	public static String alMufaj = "Almufajk";
	public static String ebook = "Ebook";
	public static String csakEb = "Csak Eb";
	public static String isbn13 = "ISBN13";    
	/*
    public final static String ancient = "Ancient";
    public final static String book_title_is_required = "Book title is required!";
    public final static String book_exists = "Such book is already bought!";*/

    // Sell labels
    public final static String sell = "Sell";
    public final static String sell_book = "Sell book";
    public final static String list_sold_books = "List sold books";
    public final static String purchase_choose_book_and_customer =
            "Válassz ki könyvet és vásárlót!";
    public final static String purchase_failed =
            "Nem sikerült rögzíteni a vásárlást!";
}
