package com.xeylyne.uasinta;

import android.content.ClipData;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ClusteringRespond {
    @SerializedName("item")
    @Expose
    private List<ClusteringRequest> item = null;

    public List<ClusteringRequest> getItem() {
        return item;
    }

    public void setItem(List<ClusteringRequest> item) {
        this.item = item;
    }
}
