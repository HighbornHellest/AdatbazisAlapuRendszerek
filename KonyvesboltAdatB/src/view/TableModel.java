package view;
import javax.swing.table.AbstractTableModel;



public class TableModel extends AbstractTableModel
{	
	/* (non-Javadoc)
	 * @see javax.swing.table.TableModel#getColumnCount()
	 */
	
	
	
    private String[] columnNames = new String[]
    {
            Labels.oldalSzam , Labels.kiadIdo, Labels.hanyadikKiadas, Labels.szerzo,
            Labels.tarsSzerzo, Labels.kiado, "vasarlasSzam",
            Labels.meret, Labels.kotes, Labels.mufaj,
            Labels.alMufaj, Labels.ebook, Labels.csakEb,
            Labels.isbn13
            
    };
	
	
	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return 0;
	}

	/* (non-Javadoc)
	 * @see javax.swing.table.TableModel#getRowCount()
	 */
	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return 0;
	}

	/* (non-Javadoc)
	 * @see javax.swing.table.TableModel#getValueAt(int, int)
	 */
	@Override
	public Object getValueAt(int arg0, int arg1) {
		// TODO Auto-generated method stub
		return null;
	}

}
