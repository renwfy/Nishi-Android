package nishi.android.model;

import java.util.List;

/**
 * Created by LSD on 15/11/14.
 */
public class ArticleDetails {

    /**
     * _id : 564460fb84f565b884bc354f
     * type : 0
     * creatorId : 5620eb27701a82d786b28abf
     * creatorPortraitUri : portrait/18600000000/2015/11/7/18/8/42/252977013/0
     * creatorNickname : 18600000v
     * title : 测试
     * playbill : article/18600000000/2015/11/12/17/50/31/78359007/0
     * site : 苏州市园区独墅湖高等教育区林泉街608号
     * city : 苏州
     * name : 测试
     * businessFromTime : 21:00
     * businessToTime : 6
     * __v : 0
     * cpp : 100
     * activityFee : 0
     * activityNeedSignUp : false
     * activitySignUpUsers : []
     * activitySignUpUserNumber : 0
     * activityMaxSignUpUserNumber : 0
     * readNumber : 0
     * createTime : 2015-11-12T09:50:51.719Z
     * recommend : 0
     * collectUsers : []
     * collectUserNumber : 1
     * items : [{"t":0,"content":"咯吱咯吱吧","_id":"564460fb84f565b884bc3550"}]
     * location : [120.750616,31.284262]
     * hasCollect : false
     */

    private String _id;
    private int type;
    private String creatorId;
    private String creatorPortraitUri;
    private String creatorNickname;
    private String title;
    private String playbill;
    private String site;
    private String city;
    private String name;
    private String businessFromTime;
    private String businessToTime;
    private int __v;
    private int cpp;
    private int activityFee;
    private boolean activityNeedSignUp;
    private int activitySignUpUserNumber;
    private int activityMaxSignUpUserNumber;
    private int readNumber;
    private String createTime;
    private int recommend;
    private int collectUserNumber;
    private boolean hasCollect;
    private List<?> activitySignUpUsers;
    private List<?> collectUsers;
    /**
     * t : 0
     * content : 咯吱咯吱吧
     * _id : 564460fb84f565b884bc3550
     */

    private List<ItemsEntity> items;
    private List<Double> location;

    public void set_id(String _id) {
        this._id = _id;
    }

    public void setType(int type) {
        this.type = type;
    }

    public void setCreatorId(String creatorId) {
        this.creatorId = creatorId;
    }

    public void setCreatorPortraitUri(String creatorPortraitUri) {
        this.creatorPortraitUri = creatorPortraitUri;
    }

    public void setCreatorNickname(String creatorNickname) {
        this.creatorNickname = creatorNickname;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setPlaybill(String playbill) {
        this.playbill = playbill;
    }

    public void setSite(String site) {
        this.site = site;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setBusinessFromTime(String businessFromTime) {
        this.businessFromTime = businessFromTime;
    }

    public void setBusinessToTime(String businessToTime) {
        this.businessToTime = businessToTime;
    }

    public void set__v(int __v) {
        this.__v = __v;
    }

    public void setCpp(int cpp) {
        this.cpp = cpp;
    }

    public void setActivityFee(int activityFee) {
        this.activityFee = activityFee;
    }

    public void setActivityNeedSignUp(boolean activityNeedSignUp) {
        this.activityNeedSignUp = activityNeedSignUp;
    }

    public void setActivitySignUpUserNumber(int activitySignUpUserNumber) {
        this.activitySignUpUserNumber = activitySignUpUserNumber;
    }

    public void setActivityMaxSignUpUserNumber(int activityMaxSignUpUserNumber) {
        this.activityMaxSignUpUserNumber = activityMaxSignUpUserNumber;
    }

    public void setReadNumber(int readNumber) {
        this.readNumber = readNumber;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public void setRecommend(int recommend) {
        this.recommend = recommend;
    }

    public void setCollectUserNumber(int collectUserNumber) {
        this.collectUserNumber = collectUserNumber;
    }

    public void setHasCollect(boolean hasCollect) {
        this.hasCollect = hasCollect;
    }

    public void setActivitySignUpUsers(List<?> activitySignUpUsers) {
        this.activitySignUpUsers = activitySignUpUsers;
    }

    public void setCollectUsers(List<?> collectUsers) {
        this.collectUsers = collectUsers;
    }

    public void setItems(List<ItemsEntity> items) {
        this.items = items;
    }

    public void setLocation(List<Double> location) {
        this.location = location;
    }

    public String get_id() {
        return _id;
    }

    public int getType() {
        return type;
    }

    public String getCreatorId() {
        return creatorId;
    }

    public String getCreatorPortraitUri() {
        return creatorPortraitUri;
    }

    public String getCreatorNickname() {
        return creatorNickname;
    }

    public String getTitle() {
        return title;
    }

    public String getPlaybill() {
        return playbill;
    }

    public String getSite() {
        return site;
    }

    public String getCity() {
        return city;
    }

    public String getName() {
        return name;
    }

    public String getBusinessFromTime() {
        return businessFromTime;
    }

    public String getBusinessToTime() {
        return businessToTime;
    }

    public int get__v() {
        return __v;
    }

    public int getCpp() {
        return cpp;
    }

    public int getActivityFee() {
        return activityFee;
    }

    public boolean isActivityNeedSignUp() {
        return activityNeedSignUp;
    }

    public int getActivitySignUpUserNumber() {
        return activitySignUpUserNumber;
    }

    public int getActivityMaxSignUpUserNumber() {
        return activityMaxSignUpUserNumber;
    }

    public int getReadNumber() {
        return readNumber;
    }

    public String getCreateTime() {
        return createTime;
    }

    public int getRecommend() {
        return recommend;
    }

    public int getCollectUserNumber() {
        return collectUserNumber;
    }

    public boolean isHasCollect() {
        return hasCollect;
    }

    public List<?> getActivitySignUpUsers() {
        return activitySignUpUsers;
    }

    public List<?> getCollectUsers() {
        return collectUsers;
    }

    public List<ItemsEntity> getItems() {
        return items;
    }

    public List<Double> getLocation() {
        return location;
    }

    public static class ItemsEntity {
        private int t;
        private String content;
        private String _id;

        public void setT(int t) {
            this.t = t;
        }

        public void setContent(String content) {
            this.content = content;
        }

        public void set_id(String _id) {
            this._id = _id;
        }

        public int getT() {
            return t;
        }

        public String getContent() {
            return content;
        }

        public String get_id() {
            return _id;
        }
    }
}
