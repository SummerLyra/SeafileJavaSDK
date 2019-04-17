package seafilewebapi;

/**
 * @author freezingrainnyu
 * @version 1.0
 * @date 2019/04/17
 */
public class AccountInfoToList {

    private String email;

    public AccountInfoToList(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return email;
    }
}
