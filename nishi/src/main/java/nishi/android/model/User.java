package nishi.android.model;

/**
 * Created by LSD on 15/10/29.
 */
public class User {
    int __v;
    String mobile;
    String nickname;
    String password;
    String _id;
    int activityMessageNumber;
    int niceMessageNumber;
    int commentMessageNumber;
    int inarticleMessageNumber;
    String createTime;
    String lastActionTime;
    String ip;
    String motto;
    String portraitUri;
    String authToken;

    public int get__v() {
        return __v;
    }

    public void set__v(int __v) {
        this.__v = __v;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public int getActivityMessageNumber() {
        return activityMessageNumber;
    }

    public void setActivityMessageNumber(int activityMessageNumber) {
        this.activityMessageNumber = activityMessageNumber;
    }

    public int getNiceMessageNumber() {
        return niceMessageNumber;
    }

    public void setNiceMessageNumber(int niceMessageNumber) {
        this.niceMessageNumber = niceMessageNumber;
    }

    public int getCommentMessageNumber() {
        return commentMessageNumber;
    }

    public void setCommentMessageNumber(int commentMessageNumber) {
        this.commentMessageNumber = commentMessageNumber;
    }

    public int getInarticleMessageNumber() {
        return inarticleMessageNumber;
    }

    public void setInarticleMessageNumber(int inarticleMessageNumber) {
        this.inarticleMessageNumber = inarticleMessageNumber;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getLastActionTime() {
        return lastActionTime;
    }

    public void setLastActionTime(String lastActionTime) {
        this.lastActionTime = lastActionTime;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getMotto() {
        return motto;
    }

    public void setMotto(String motto) {
        this.motto = motto;
    }

    public String getPortraitUri() {
        return portraitUri;
    }

    public void setPortraitUri(String portraitUri) {
        this.portraitUri = portraitUri;
    }

    public String getAuthToken() {
        return authToken;
    }

    public void setAuthToken(String authToken) {
        this.authToken = authToken;
    }
}
