
package com.test.xyz.demo.domain.model.weather;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Atmosphere {

    @SerializedName("humidity")
    @Expose
    public String humidity;
    @SerializedName("pressure")
    @Expose
    public String pressure;
    @SerializedName("rising")
    @Expose
    public String rising;
    @SerializedName("visibility")
    @Expose
    public String visibility;

}
