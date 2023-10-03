package kh.lclass.semi.member.model.vo;

public class MemberVo {
//	이름        널?       유형           
//	--------- -------- ------------ 
//	EMAIL     NOT NULL VARCHAR2(50) 
//	PASSWORD  NOT NULL VARCHAR2(20) 
//	NICKNAME  NOT NULL VARCHAR2(15) 
//	AGE_GROUP NOT NULL NUMBER  
	
	private String email;
	private String password;
	private String nickname;
	private int ageGroup;
	
	public MemberVo() {
		super();
	}
	
	public MemberVo(String email, String password, String nickname) {
		super();
		this.email = email;
		this.password = password;
		this.nickname = nickname;
	}

	public MemberVo(String email, String password) {
		super();
		this.email = email;
		this.password = password;
	}


	@Override
	public String toString() {
		return "MemberVo [email=" + email + ", password=" + password + ", nickname=" + nickname + ", ageGroup="
				+ ageGroup + "]";
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public int getAgeGroup() {
		return ageGroup;
	}
	public void setAgeGroup(int ageGroup) {
		this.ageGroup = ageGroup;
	}
	
	
	

}
