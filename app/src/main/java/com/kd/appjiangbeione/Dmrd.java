package com.kd.appjiangbeione;

import android.util.Log;

public class Dmrd {
    public String zfs,rzh,gh,zwx;

    public Dmrd(String zfs, String rzh, String gh) {
        this.zfs = "总辐射:"+zfs+"W/㎡";
        this.rzh = "小时日照:"+rzh+"min";
        this.gh = "光合有效:"+gh+"W/㎡";
        Log.i("TAG",toString());
    }

    public Dmrd(String gh, String zwx) {
        this.gh = "光合:"+gh+"W/㎡";
        this.zwx = "紫外:"+zwx+"mW/㎡";
    }
    public Dmrd(String gh, String zfs,int s) {
        this.gh = "光合有效:"+gh+"W/㎡";
        this.zfs = "总辐射:"+zfs+"W/㎡";
    }
    @Override
    public String toString() {
        return "Dmrd{" +
                "zfs='" + zfs + '\'' +
                ", rzh='" + rzh + '\'' +
                ", gh='" + gh + '\'' +
                '}';
    }
}
