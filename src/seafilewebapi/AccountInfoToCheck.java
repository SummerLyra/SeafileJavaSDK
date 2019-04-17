package seafilewebapi;

/**
 * @author freezingrainnyu
 * @version 1.2
 * @date 2019/04/17
 */
public class AccountInfoToCheck {

    private String usage;
    private String total;
    private String email;

    public AccountInfoToCheck(String usage, String total, String email) {
        this.usage = usage;
        this.total = total;
        this.email = email;
    }

    public String getUsage() {
        return usage;
    }

    public String getTotal() {
        return total;
    }

    public String getEmail() {
        return email;
    }
}
