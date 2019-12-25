package seafilejavasdk.accountobjects;

/**
 * @author liudongyu1119@outlook.com
 * @version 1.5
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
