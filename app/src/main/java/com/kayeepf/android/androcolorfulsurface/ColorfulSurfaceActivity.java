package com.kayeepf.android.androcolorfulsurface;

import android.app.Activity;
import android.os.Bundle;
import android.view.SurfaceView;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.SeekBar;

/**
 * Created by huangshifeng on 2017/5/15.
 */
public class ColorfulSurfaceActivity extends Activity {

    LinearLayout linearLayout = null;
    SurfaceView surfaceView = null;
    SeekBar seekBar = null;

    SurfaceColorDevice surfaceColorDevice = null;
    FakeColorDevice fakeColorDevice = null;
    ColorDevice colorDevice = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        linearLayout = new LinearLayout(getApplicationContext());
        linearLayout.setOrientation(LinearLayout.VERTICAL);

        seekBar = new SeekBar(getApplicationContext());
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
        LayoutParams 
        seekBar.setLayoutParams();
        linearLayout.addView(seekBar);

        surfaceView = new SurfaceView(getApplicationContext());
        linearLayout.addView(surfaceView);

        fakeColorDevice = new FakeColorDevice();
        surfaceColorDevice = new SurfaceColorDevice(surfaceView);

        setContentView(linearLayout);
    }

    @Override
    protected void onResume() {
        super.onResume();
        //colorDevice = new ColorDevice(fakeColorDevice);
        colorDevice = new ColorDevice(surfaceColorDevice);
        colorDevice.setColorful();
    }

    @Override
    protected void onPause() {
        super.onPause();

        colorDevice.setRgb(0,0,0);

        System.gc();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        colorDevice = null;
    }
}
