package com.tim.WoodshopMC.Database;

import com.tim.WoodshopMC.Global.CommonDefs;

/**
 * Created by donald on 5/8/14.
 */
public class FSProduct {

    // properties
    public long productID;
    public String productName;
    public long productDeleted;

    public FSProduct()
    {
        productID = 0;
        productName = "";
        productDeleted = 0;
    }
}
