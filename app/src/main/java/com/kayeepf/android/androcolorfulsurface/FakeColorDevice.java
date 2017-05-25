package com.kayeepf.android.androcolorfulsurface;

import android.util.Log;

/**
 * Created by huangshifeng on 17/5/16.
 */
public class FakeColorDevice implements ColorDeviceInterface {

    static final String log_tag = "[FakeColorDevice]";

    @Override
    public void ColorDevice_init() {
        Log.i(log_tag,">>>ColorDevice_init");
        Log.i(log_tag,"<<<ColorDevice_init");
    }

    @Override
    public void ColorDevice_deInit() {
        Log.i(log_tag,">>>ColorDevice_deInit");
        Log.i(log_tag,"<<<ColorDevice_deInit");
    }

    @Override
    public void ColorDevice_setRgb(int r, int g, int b) {
        Log.i(log_tag,">>>ColorDevice_setRgb(r:"+r+",g:"+g+",b:"+b+")");
        Log.i(log_tag,"<<<ColorDevice_setRgb(r:"+r+",g:"+g+",b:"+b+")");
    }
}
