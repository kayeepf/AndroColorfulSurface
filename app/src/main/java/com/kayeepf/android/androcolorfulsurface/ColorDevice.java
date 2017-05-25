package com.kayeepf.android.androcolorfulsurface;

import java.util.Random;

/**
 * Created by huangshifeng on 17/5/15.
 */
public class ColorDevice {

    ColorDeviceInterface colorDeviceImpl = null;

    boolean colorfulStop = false;
    Thread colorfulThread = null;
    int r,g,b;

    ColorDevice(ColorDeviceInterface _colorDeviceImpl) {
        colorfulStop = true;
        r = 0;
        g = 0;
        b = 0;
        this.colorDeviceImpl = _colorDeviceImpl;
        if(this.colorDeviceImpl != null) {
            this.colorDeviceImpl.ColorDevice_init();
        }
    }

    void setRgb(int r, int g, int b) {
        if(colorfulThread != null) {
            colorfulStop = true;
            try {
                colorfulThread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            colorfulThread = null;
        }
        if(this.colorDeviceImpl != null) {
            this.r = r;
            this.g = g;
            this.b = b;
            this.colorDeviceImpl.ColorDevice_setRgb(r, g, b);
        }
    }

    void setColorful() {
        if(colorfulThread == null) {
            colorfulStop = false;
            colorfulThread = new Thread(new Runnable() {
                @Override
                public void run() {
                    boolean rAsc = true;
                    boolean gAsc = true;
                    boolean bAsc = true;
                    while(colorfulStop == false) {
                        Random rand = new Random();
                        if(rAsc){
                            r += rand.nextInt(10);
                            if(r > 255){
                                r = 255;
                                rAsc = false;
                            }
                        } else {
                            r -= rand.nextInt(10);
                            if(r < 0){
                                r = 0;
                                rAsc = true;
                            }
                        }

                        if(gAsc){
                            g += rand.nextInt(10);
                            if(g > 255){
                                g = 255;
                                gAsc = false;
                            }
                        } else {
                            g -= rand.nextInt(5);
                            if(g < 0){
                                g = 0;
                                gAsc = true;
                            }
                        }

                        if(bAsc){
                            b += rand.nextInt(5);
                            if(b > 255){
                                b = 255;
                                bAsc = false;
                            }
                        } else {
                            b -= rand.nextInt(5);
                            if(b < 0){
                                b = 0;
                                bAsc = true;
                            }
                        }

                        colorDeviceImpl.ColorDevice_setRgb(r,g,b);

                        try {
                            Thread.sleep(15);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            });
            colorfulThread.start();
        }
    }

    @Override
    protected void finalize() throws Throwable {
        super.finalize();
        if(colorfulThread != null) {
            colorfulStop = true;
            colorfulThread.join();
            colorfulThread = null;
        }
        if(this.colorDeviceImpl != null) {
            this.colorDeviceImpl.ColorDevice_deInit();
        }
    }
}
