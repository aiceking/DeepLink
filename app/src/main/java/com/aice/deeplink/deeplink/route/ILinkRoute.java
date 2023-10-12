package com.aice.deeplink.deeplink.route;

import com.aice.deeplink.deeplink.DeepLinkData;

import java.util.Map;

import androidx.fragment.app.FragmentActivity;

public interface ILinkRoute {
    void route(FragmentActivity activity, DeepLinkData deepLinkData);
}
