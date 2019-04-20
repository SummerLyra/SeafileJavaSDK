package accountobjects;

/**
 * @author freezingrainnyu
 * @version 1.5
 * @date 2019/04/17
 */
public class CheckedAccountInfo {

    private long usage;
    private long total;
    private String email;

    public CheckedAccountInfo(long usage, long total, String email) {
        this.usage = usage;
        this.total = total;
        this.email = email;
    }

    public long getUsage() {
        return usage;
    }

    public long getTotal() {
        return total;
    }

    public String getEmail() {
        return email;
    }
}
