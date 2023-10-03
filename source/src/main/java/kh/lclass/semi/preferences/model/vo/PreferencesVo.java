package kh.lclass.semi.preferences.model.vo;


public class PreferencesVo {
	
//	"EMAIL"	VARCHAR2(50)		NOT NULL,
//	"GENRE_ID"	NUMBER		NOT NULL
	
	//취향선택
	private String email;
	private int genreId;
	
	public PreferencesVo() {
		super();
	}

	public PreferencesVo(String email, int genreId) {
		super();
		this.email = email;
		this.genreId = genreId;
	}

	@Override
	public String toString() {
		return "PreferencesVo [email=" + email + ", genreId=" + genreId + "]";
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getGenreId() {
		return genreId;
	}

	public void setGenreId(int genreId) {
		this.genreId = genreId;
	}
	
	

}
