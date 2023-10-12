package com.aice.deeplink.deeplink;

import android.content.Intent;

import com.aice.deeplink.deeplink.route.BonusHintLinkRoute;
import com.aice.deeplink.deeplink.route.BonusPicLinkRoute;
import com.aice.deeplink.deeplink.route.GardenLinkRoute;
import com.aice.deeplink.deeplink.route.HomeTabLinkRoute;
import com.aice.deeplink.deeplink.route.ILinkRoute;
import com.aice.deeplink.deeplink.route.LibCateLinkRoute;
import com.aice.deeplink.deeplink.route.PaintLinkRoute;
import com.aice.deeplink.deeplink.route.ThemeListLinkRoute;

import java.util.HashMap;
import java.util.Map;

import androidx.fragment.app.FragmentActivity;

public class DeepLinkManager {
    private final Map<String, ILinkRoute> mLinkRouteMap;

    public static DeepLinkManager get() {
        return Holder.singleton;
    }

    private DeepLinkManager() {
        mLinkRouteMap = new HashMap<>();
        mLinkRouteMap.put("bonuspic", new BonusPicLinkRoute());
        mLinkRouteMap.put("bonushint", new BonusHintLinkRoute());
        mLinkRouteMap.put("libcate", new LibCateLinkRoute());
        mLinkRouteMap.put("paint", new PaintLinkRoute());
        mLinkRouteMap.put("garden", new GardenLinkRoute());
        mLinkRouteMap.put("themelist", new ThemeListLinkRoute());
        mLinkRouteMap.put("hometab", new HomeTabLinkRoute());
    }

    private static class Holder {
        private static final DeepLinkManager singleton = new DeepLinkManager();
    }

    public void route(FragmentActivity fragmentActivity, Intent intent) {
        DeepLinkData deepLinkData = DeepLinkData.genera(intent);
        if (deepLinkData == null) {
            return;
        }
        ILinkRoute iLinkRoute = mLinkRouteMap.get(deepLinkData.getName());
        if (iLinkRoute == null) {
            return;
        }
        iLinkRoute.route(fragmentActivity, deepLinkData);
    }
}
