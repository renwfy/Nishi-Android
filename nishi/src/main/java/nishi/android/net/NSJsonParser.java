package nishi.android.net;

import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;

import java.util.ArrayList;
import java.util.List;

class NSJsonParser {
    public static final String TAG = NSJsonParser.class.getSimpleName();

    public <T> void parse(String json, Class<T> clazz, NSCallback<T> callback) {
        try {
            Gson gson = new Gson();
            JsonResponse jr = gson.fromJson(json,
                    JsonResponse.class);
            if (jr.getErrorCode() == 0) {// success
                if (clazz == null) {
                    Log.w(TAG, "null parse class");
                    callback.onSuccess(null);
                } else if (jr.getReturnValue() == null) {
                    Log.w(TAG, json);
                    callback.onSuccess(null);
                } else {
                    if (jr.getReturnValue().isJsonArray()) {
                        JsonArray array = jr.getReturnValue().getAsJsonArray();
                        List<T> result = new ArrayList<T>();
                        for (int i = 0; i < array.size(); i++) {
                            result.add(gson.fromJson(array.get(i), clazz));
                        }
                        callback.onSuccess(result, result.size());
                    } else if (jr.getReturnValue().isJsonObject()) {
                        callback.onSuccess(gson.fromJson(jr.getReturnValue(), clazz));
                    } else if (jr.getReturnValue().isJsonPrimitive()) {
                        callback.onSuccess(gson.fromJson(jr.getReturnValue(), clazz));
                    } else {
                        callback.onSuccess(null);
                    }
                }
            } else {
                callback.onFail(jr.getErrorCode(), jr.getErrorReason());
            }
        } catch (Exception e) {
            e.printStackTrace();
            Log.e(TAG, "解析异常");
            callback.onFail(-1,"");
        }
    }

    static class JsonResponse {
        int errorCode;
        String errorReason;
        JsonElement returnValue;

        public int getErrorCode() {
            return errorCode;
        }

        public void setErrorCode(int errorCode) {
            this.errorCode = errorCode;
        }

        public String getErrorReason() {
            return errorReason;
        }

        public void setErrorReason(String errorReason) {
            this.errorReason = errorReason;
        }

        public JsonElement getReturnValue() {
            return returnValue;
        }

        public void setReturnValue(JsonElement returnValue) {
            this.returnValue = returnValue;
        }
    }
}