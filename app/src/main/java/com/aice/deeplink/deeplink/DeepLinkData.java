package com.aice.deeplink.deeplink;

import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class DeepLinkData {
    private String name;
    private HashMap<String, String> paramsMap;

    public DeepLinkData(String name, HashMap<String, String> paramsMap) {
        this.name = name;
        this.paramsMap = paramsMap;
    }

    public String getName() {
        return name;
    }

    public HashMap<String, String> getParamsMap() {
        return paramsMap;
    }

    @Override
    public String toString() {
        return "DeepLinkData{" +
                "name='" + name + '\'' +
                ", paramsMap=" + paramsMap +
                '}';
    }

    public static DeepLinkData genera(Intent intent) {
        if (intent == null) {
            return null;
        }
        Uri uri = intent.getData();
        if (uri == null) {
            return null;
        }
        String scheme = uri.getScheme();
        String host = uri.getHost();
        if (!TextUtils.equals("vitacolor", scheme)) {
            return null;
        }
        if (TextUtils.isEmpty(host)) {
            return null;
        }
        HashMap<String, String> paramsMap = new HashMap<>();
        Set<String> paramNames = uri.getQueryParameterNames();
        if (paramNames != null) {
            for (String parameterName : paramNames) {
                String parameterValue = uri.getQueryParameter(parameterName);
                paramsMap.put(parameterName, parameterValue);
            }
        }
        return new DeepLinkData(host, paramsMap);
    }
}
