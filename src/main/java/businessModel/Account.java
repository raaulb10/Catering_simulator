package businessModel;

import java.io.Serializable;

public class Account implements Serializable {

    private String username;
    private String password;
    private String telephone;
    private boolean isEmployee;

    public Account(String username, String password, String telephone, boolean isEmployee) {
        this.username = username;
        this.password = password;
        this.telephone = telephone;
        this.isEmployee = isEmployee;
    }

    public String getUsername() { return username; }
    public String getPassword() { return password; }
    public boolean isEmployee() { return isEmployee; }
    public boolean isEqual(Account a){
        if (this.username.compareTo(a.username)==0 && this.telephone.compareTo(a.telephone)==0)
            return true;
        else
            return false;
    }
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(username).append(" | ").append(telephone);
        if ( isEmployee ){
            sb.append(" | employee\n");
        }else
            sb.append(" | client\n");

        return sb.toString();
    }
}
