package nishi.android.model;

import java.util.List;

/**
 * 文章
 * <p/>
 * Created by LSD on 15/10/20.
 */
public class Article {
    String _id;
    int type;
    String creatorId;
    String creatorPortraitUri;
    String creatorNickname;
    String title;
    String playbill;
    String site;
    String city;
    String phone;
    String name;
    String businessFromTime;
    String businessToTime;
    int __v;
    int cpp;
    int activityFee;
    boolean activityNeedSignUp;
    int activitySignUpUserNumber;
    int activityMaxSignUpUserNumber;
    String createTime;
    int recommend;
    List<Item> items;
    List<Double> location;
    boolean hasNice;

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getCreatorId() {
        return creatorId;
    }

    public void setCreatorId(String creatorId) {
        this.creatorId = creatorId;
    }

    public String getCreatorPortraitUri() {
        return creatorPortraitUri;
    }

    public void setCreatorPortraitUri(String creatorPortraitUri) {
        this.creatorPortraitUri = creatorPortraitUri;
    }

    public String getCreatorNickname() {
        return creatorNickname;
    }

    public void setCreatorNickname(String creatorNickname) {
        this.creatorNickname = creatorNickname;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPlaybill() {
        return playbill;
    }

    public void setPlaybill(String playbill) {
        this.playbill = playbill;
    }

    public String getSite() {
        return site;
    }

    public void setSite(String site) {
        this.site = site;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBusinessFromTime() {
        return businessFromTime;
    }

    public void setBusinessFromTime(String businessFromTime) {
        this.businessFromTime = businessFromTime;
    }

    public String getBusinessToTime() {
        return businessToTime;
    }

    public void setBusinessToTime(String businessToTime) {
        this.businessToTime = businessToTime;
    }

    public int get__v() {
        return __v;
    }

    public void set__v(int __v) {
        this.__v = __v;
    }

    public int getCpp() {
        return cpp;
    }

    public void setCpp(int cpp) {
        this.cpp = cpp;
    }

    public int getActivityFee() {
        return activityFee;
    }

    public void setActivityFee(int activityFee) {
        this.activityFee = activityFee;
    }

    public boolean isActivityNeedSignUp() {
        return activityNeedSignUp;
    }

    public void setActivityNeedSignUp(boolean activityNeedSignUp) {
        this.activityNeedSignUp = activityNeedSignUp;
    }

    public int getActivitySignUpUserNumber() {
        return activitySignUpUserNumber;
    }

    public void setActivitySignUpUserNumber(int activitySignUpUserNumber) {
        this.activitySignUpUserNumber = activitySignUpUserNumber;
    }

    public int getActivityMaxSignUpUserNumber() {
        return activityMaxSignUpUserNumber;
    }

    public void setActivityMaxSignUpUserNumber(int activityMaxSignUpUserNumber) {
        this.activityMaxSignUpUserNumber = activityMaxSignUpUserNumber;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public int getRecommend() {
        return recommend;
    }

    public void setRecommend(int recommend) {
        this.recommend = recommend;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    public List<Double> getLocation() {
        return location;
    }

    public void setLocation(List<Double> location) {
        this.location = location;
    }

    public boolean isHasNice() {
        return hasNice;
    }

    public void setHasNice(boolean hasNice) {
        this.hasNice = hasNice;
    }

    public class Item {
        int t;
        String content;
        String _id;
        Pic pic;

        public int getT() {
            return t;
        }

        public void setT(int t) {
            this.t = t;
        }

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }

        public String get_id() {
            return _id;
        }

        public void set_id(String _id) {
            this._id = _id;
        }

        public Pic getPic() {
            return pic;
        }

        public void setPic(Pic pic) {
            this.pic = pic;
        }
    }

    public class Pic {
        String url;
        int width;
        int height;

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public int getWidth() {
            return width;
        }

        public void setWidth(int width) {
            this.width = width;
        }

        public int getHeight() {
            return height;
        }

        public void setHeight(int height) {
            this.height = height;
        }
    }
}


