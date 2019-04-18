package seafilewebapi.accountobjects;

/**
 * @author freezingrainnyu
 * @version 1.0
 * @date 2019/04/17
 */
public class ListedAccountInfo {

    private String email;

    public ListedAccountInfo(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return email;
    }
}
