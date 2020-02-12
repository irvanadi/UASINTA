package com.xeylyne.uasinta;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class EstimationRespond {

    @SerializedName("item")
    @Expose
    private List<EstimationRequest> item = null;

    public List<EstimationRequest> getItem() {
        return item;
    }

    public void setItem(List<EstimationRequest> item) {
        this.item = item;
    }

}
