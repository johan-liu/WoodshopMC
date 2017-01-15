package com.tim.WoodshopMC;

import android.content.Intent;
import android.graphics.Rect;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.ViewTreeObserver;
import android.widget.RelativeLayout;
import com.tim.WoodshopMC.Global.GlobalData;
import com.tim.WoodshopMC.Scan.ScanManager;

public class SplashScreen extends BaseActivity {

    private ScanManager manager;

    RelativeLayout mainLayout;
    boolean bInitialized = false;
    private Handler handler;

    final int LOADINGVIEW_TIMEOUT = 3000;

    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash);

        GlobalData._mainContext = getApplicationContext();

        // Initialize Global
        GlobalData.initialize(this);

        mainLayout = (RelativeLayout)findViewById(R.id.RLSplashRoot);
        mainLayout.getViewTreeObserver().addOnGlobalLayoutListener(
                new ViewTreeObserver.OnGlobalLayoutListener() {
                    public void onGlobalLayout() {
                        if (bInitialized == false)
                        {
                            Rect r = new Rect();
                            mainLayout.getLocalVisibleRect(r);
                            ResolutionSet._instance.setResolution(r.width(), r.height(), true);
                            ResolutionSet._instance.iterateChild(findViewById(R.id.RLSplashRoot));
                            bInitialized = true;
                        }
                    }
                }
        );

        manager = ScanManager.managerWithListner(this, ScanManagerListenerInstance.sharedInstance());
        // have to be commented
        // manager.startScan();

        handler = new Handler()
        {
            @Override
            public void handleMessage(Message msg)
            {
                if (msg.what == 0)
                {
                    startActivity(new Intent(SplashScreen.this, JobsActivity.class));
                    overridePendingTransition(R.anim.right_in, R.anim.left_out);
                    finish();
                }
            }
        };

        handler.sendEmptyMessageDelayed(0, LOADINGVIEW_TIMEOUT);
    }

    @Override
    protected void onResume()
    {
        super.onResume();
    }
}
