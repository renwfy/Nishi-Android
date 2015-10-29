package nishi.android.net;

/**
 * Created by LSD on 15/10/18.
 */
public class MultipartRequest extends DefaultRequest {
    MultipartRequest(String url, NSCallback callback) {
        super(url, callback);
    }

    @Override
    public NSRequest doRequest() {
        return this;
    }
}
