package form;
 
public class AccountForm {
 
    private String login;
    private String password;
    private String passwordConf;
 
	public AccountForm() {
    }
    		
    public AccountForm(String login, String password, String passwordConf) {
        this.login = login;
        this.password = password;
        this.passwordConf = passwordConf;
    }
 
    public String getLogin() {
        return login;
    }
    
    public String getPassword() {
        return password;
    }
 
    public void setlogin(String login) {
        this.login = login;
    }
 
    public void setpassword(String password) {
        this.password = password;
    }
    
     public String getPasswordConf() {
		return passwordConf;
	}

	public void setPasswordConf(String passwordConf) {
		this.passwordConf = passwordConf;
	}
}