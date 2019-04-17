package seafilewebapi;

/**
 * @author freezingrainnyu
 * @version 1.0
 * @date 2019/04/17
 */
public class AccountInfo {

    private String usage;
    private String total;
    private String email;

    public AccountInfo(String usage, String total, String email) {
        this.usage = usage;
        this.total = total;
        this.email = email;
    }

    public String getUsage() {
        return usage;
    }

    public String getTotal(){
        return total;
    }

    public String getEmail() {
        return email;
    }

    public void setUsage(String usage) {
        this.usage = usage;
    }

    public void setTotal(String total) {
        this.total = total;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
