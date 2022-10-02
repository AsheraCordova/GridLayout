package com.ashera.gridlayout;

import com.ashera.widget.WidgetFactory;

public class GridLayoutPlugin {
    public static void initPlugin() {
        //start - widgets
        WidgetFactory.register(new com.ashera.gridlayout.GridLayoutImpl());
        //end - widgets

    }
}
