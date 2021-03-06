package com.AirMaps;

import com.facebook.react.ReactPackage;
import com.facebook.react.bridge.JavaScriptModule;
import com.facebook.react.bridge.NativeModule;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.uimanager.ViewManager;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class AirPackage implements ReactPackage {
    @Override
    public List<NativeModule> createNativeModules(ReactApplicationContext reactContext) {
        return Collections.emptyList();
    }

    @Override
    public List<Class<? extends JavaScriptModule>> createJSModules() {
        return Collections.emptyList();
    }

    @Override
    public List<ViewManager> createViewManagers(ReactApplicationContext reactContext) {
        AirMapCalloutManager calloutManager = new AirMapCalloutManager();
        AirMapMarkerManager annotationManager = new AirMapMarkerManager(calloutManager);
        AirMapPolylineManager polylineManager = new AirMapPolylineManager(reactContext);
        AirMapPolygonManager polygonManager = new AirMapPolygonManager(reactContext);
        AirMapCircleManager circleManager = new AirMapCircleManager(reactContext);
        AirMapUrlTileManager tileManager = new AirMapUrlTileManager(reactContext);
        AirMapManager mapManager = new AirMapManager(
            annotationManager,
            polylineManager,
            polygonManager,
            circleManager,
            tileManager
        );

        return Arrays.<ViewManager>asList(
            calloutManager,
            annotationManager,
            polylineManager,
            polygonManager,
            circleManager,
            tileManager,
            mapManager
        );
    }
}
