package com.aice.deeplink.deeplink.route;

import android.util.Log;

import com.aice.deeplink.deeplink.DeepLinkData;

import androidx.fragment.app.FragmentActivity;

public class LibCateLinkRoute extends BaseLinkRoute {
    @Override
    public void route(FragmentActivity activity, DeepLinkData deepLinkData) {
        Log.v("xixi=", deepLinkData.toString());

    }
}
