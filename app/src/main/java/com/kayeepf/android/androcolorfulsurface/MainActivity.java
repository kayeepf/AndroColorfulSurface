package com.kayeepf.android.androcolorfulsurface;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

/**
 * Created by huangshifeng on 2017/5/15.
 */
public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    protected void onResume() {
        super.onResume();
        Intent intent = new Intent(getApplicationContext(),ColorfulSurfaceActivity.class);
        startActivity(intent);
        this.finish();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

}
