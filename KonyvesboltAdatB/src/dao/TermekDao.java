package dao;

import model.Termek;

/**
 * @author Tamássy Urmás
 *
 */
public class TermekDao {
	/**
	 * Típus és id alapján lekéri a megfelelő terméket
	 * @param termekId
	 * @param termekTipus
	 * @return
	 */
	public static Termek getTermek(int termekId,String termekTipus){
		Termek termek=null;
		if(termekTipus.equals(KonyvesboltDao.TERMEK_TIPUS_ALBUM)){
			termek=AlbumDao.getAlbumIdSzerint(termekId);
		}else if(termekTipus.equals(KonyvesboltDao.TERMEK_TIPUS_FILM)){
			termek=FilmDao.getFilmIdSzerint(termekId);
		}else if(termekTipus.equals(KonyvesboltDao.TERMEK_TIPUS_KONYV)){
			termek=KonyvDao.getKonyvIdSzerint(termekId);
		}
		return termek;
	}
}
