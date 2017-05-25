package com.kayeepf.android.androcolorfulsurface;

import android.graphics.Canvas;
import android.os.AsyncTask;
import android.os.Handler;
import android.util.Log;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

import java.util.logging.LogRecord;

/**
 * Created by huangshifeng on 17/5/16.
 */
public class SurfaceColorDevice implements ColorDeviceInterface {

    SurfaceView surfaceView = null;
    SurfaceHolder surfaceHolder = null;
    Handler handler = null;

    static final String log_tag = "[SurfaceColorDevice]";

    SurfaceColorDevice(SurfaceView _surfaceView) {
        this.surfaceView = _surfaceView;
        handler = new Handler();
    }

    @Override
    public void ColorDevice_init() {
        surfaceHolder = surfaceView.getHolder();
    }

    @Override
    public void ColorDevice_deInit() {

    }

    class RgbRunnable implements Runnable{

        SurfaceHolder surfaceHolder;
        int r,g,b;

        RgbRunnable(SurfaceHolder _surfaceHolder,int r,int g,int b){
            this.surfaceHolder = _surfaceHolder;
            this.r = r;
            this.g = g;
            this.b = b;
        }

        @Override
        public void run() {
            if(!surfaceHolder.getSurface().isValid())
            {
                Log.e(log_tag,"!surfaceHolder.getSurface().isValid()");
                return;
            }
            Canvas canvas = surfaceHolder.lockCanvas();
            canvas.drawARGB(255,this.r,this.g,this.b);
            surfaceHolder.unlockCanvasAndPost(canvas);
        }
    }

    @Override
    public void ColorDevice_setRgb(int r, int g, int b) {
        //Log.d(log_tag, "ColorDevice_setRgb(r:" + r + ",g:" + g + ",b:" + b + ")");
        handler.post(new RgbRunnable(this.surfaceHolder, r, g, b));
    }
}
