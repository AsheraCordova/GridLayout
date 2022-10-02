package com.ashera.gridlayout;

import org.apache.cordova.CordovaInterface;
import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.CordovaWebView;

import com.ashera.widget.WidgetFactory;

public class AndroidXGridLayoutPlugin extends CordovaPlugin {
    @Override
    public void initialize(CordovaInterface cordova, CordovaWebView webView) {
        super.initialize(cordova, webView);
        //start - widgets
        WidgetFactory.register(new com.ashera.gridlayout.GridLayoutImpl());
        //end - widgets

    }
}
