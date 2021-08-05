package com.example.usrrighmvvmpractic.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class SucessResponse {

    @SerializedName("weo_p_error")
    @Expose
    private List<Object> weoPError = null;
    @SerializedName("p_in_obj")
    @Expose
    private PInObj pInObj;
    @SerializedName("p_out_icon_obj")
    @Expose
    private POutIconObj pOutIconObj;

    public List<Object> getWeoPError() {
        return weoPError;
    }

    public void setWeoPError(List<Object> weoPError) {
        this.weoPError = weoPError;
    }

    public PInObj getpInObj() {
        return pInObj;
    }

    public void setpInObj(PInObj pInObj) {
        this.pInObj = pInObj;
    }

    public POutIconObj getpOutIconObj() {
        return pOutIconObj;
    }

    public void setpOutIconObj(POutIconObj pOutIconObj) {
        this.pOutIconObj = pOutIconObj;
    }

}
