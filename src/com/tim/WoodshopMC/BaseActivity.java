package com.tim.WoodshopMC;

import android.app.Activity;
import android.os.Bundle;
import com.tim.WoodshopMC.Global.GlobalData;

/**
 * Created by donald on 6/20/14.
 */
public class BaseActivity extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        GlobalData._currentActivity = BaseActivity.this;
    }
}
