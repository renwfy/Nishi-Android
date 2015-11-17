package nishi.android.model;

/**
 * 文章
 * <p/>
 * Created by LSD on 15/10/20.
 */
public class Article {

    /**
     * _id : 56447b41e042a37b25688736
     * type : 0
     * title : 测试地理位置
     * playbill : article/18600000000/2015/11/12/19/42/48/495441973/0
     * site : 江苏省苏州市吴中区翰林缘32栋
     * collectUserNumber : 1
     * hasCollect : false
     */

    private String _id;
    private int type;
    private String title;
    private String playbill;
    private String site;
    private int collectUserNumber;
    private boolean hasCollect;

    public void set_id(String _id) {
        this._id = _id;
    }

    public void setType(int type) {
        this.type = type;
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

    public void setCollectUserNumber(int collectUserNumber) {
        this.collectUserNumber = collectUserNumber;
    }

    public void setHasCollect(boolean hasCollect) {
        this.hasCollect = hasCollect;
    }

    public String get_id() {
        return _id;
    }

    public int getType() {
        return type;
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

    public int getCollectUserNumber() {
        return collectUserNumber;
    }

    public boolean isHasCollect() {
        return hasCollect;
    }
}


