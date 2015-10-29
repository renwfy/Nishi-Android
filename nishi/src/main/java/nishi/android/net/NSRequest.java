package nishi.android.net;

import java.util.Map;

/**
 * Created by LSD on 15/10/18.
 */
public interface NSRequest {
    public NSRequest doRequest();

    public void cancelRequests(String tag);

    public void setParams(Map<String, String> params);

    public void setHeaders(Map<String, String> header);
}
