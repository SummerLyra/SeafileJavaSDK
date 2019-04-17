package seafilewebapi;

import java.time.Instant;

import static java.time.temporal.ChronoUnit.MICROS;

/**
 * @author freezingrainnyu
 * @version 1.2
 * @date 2019/04/17
 */
public class GettedAccountInfo extends CheckedAccountInfo {

    private boolean isStaff;
    private boolean isActive;
    private int id;
    private Instant createTime;

    public GettedAccountInfo(boolean isStaff, boolean isActive, int id, long createTime, long usage, long total, String email) {
        super(usage, total, email);
        this.isStaff = isStaff;
        this.isActive = isActive;
        this.id = id;
        this.createTime = Instant.EPOCH.plus(createTime, MICROS);
    }

    public boolean isStaff() {
        return isStaff;
    }

    public boolean isActive() {
        return isActive;
    }

    public int getId() {
        return id;
    }

    public Instant getCreateTime() {
        return createTime;
    }
}
