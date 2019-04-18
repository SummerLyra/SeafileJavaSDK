package seafilewebapi.fileobjects;

import java.time.Instant;

import static java.time.temporal.ChronoUnit.MILLIS;

/**
 * @author freezingrainnyu
 * @version 1.0
 * @date 2019/04/18
 */
public class ViewInfo {

    private String accessToken;
    private String actionUrl;
    private Instant accessTokenTtl;

    public ViewInfo(String accessToken, String actionUrl, long accessTokenTtl) {
        this.accessToken = accessToken;
        this.actionUrl = actionUrl;
        this.accessTokenTtl = Instant.EPOCH.plus(accessTokenTtl, MILLIS);
    }

    public String getAccessToken() {
        return accessToken;
    }

    public String getActionUrl() {
        return actionUrl;
    }

    public Instant getAccessTokenTtl() {
        return accessTokenTtl;
    }
}
