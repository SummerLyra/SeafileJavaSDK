package seafilewebapi;

/**
 * @author freezingrainnyu
 * @version 1.0
 * @date 2019/04/17
 */
public class AccountInfoToGet extends AccountInfoToCheck {

    private boolean isStaff;
    private boolean isActive;
    private String id;
    private String createTime;

    public AccountInfoToGet(boolean isStaff, boolean isActive, String id, String createTime, String usage, String total, String email) {
        super(usage, total, email);
        this.isStaff = isStaff;
        this.isActive = isActive;
        this.id = id;
        this.createTime = createTime;
    }

    public boolean getIsStaff() {
        return isStaff;
    }

    public boolean getIsActive() {
        return isActive;
    }

    public String getId() {
        return id;
    }

    public String getCreateTime() {
        return createTime;
    }
}
