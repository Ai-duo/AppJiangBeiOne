package com.kd.appjiangbeione;

import android.graphics.Typeface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;

import com.kd.appjiangbeione.databinding.ActivityFourBinding;


public class FragmentFirst extends Fragment {
    Dmgd dmgd;
    Dmsd dmsd;
    String dm4d;
    Typeface tf;
    ActivityFourBinding inflate;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if(inflate==null) {
            inflate = DataBindingUtil.inflate(inflater, R.layout.activity_four, container, false);
            inflate.setTf(tf);
        }
        if(dmgd!=null){
            inflate.setDmgd(dmgd);
        }
        if(dmsd!=null){
            inflate.setDmsd(dmsd);
        }

        return inflate.getRoot();
    }
    public void setDmgd( Dmgd dmgd){
        this.dmgd = dmgd;
        if(inflate!=null)
        inflate.setDmgd(dmgd);
    }
    public void setDmsd( Dmsd dmsd){
        this.dmsd = dmsd;
        if(inflate!=null)
            inflate.setDmsd(dmsd);
    }

    public void setTf(Typeface tf){
        this.tf = tf;
    }
}
