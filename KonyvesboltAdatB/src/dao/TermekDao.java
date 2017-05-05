package dao;

import model.Termek;

public class TermekDao {
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
