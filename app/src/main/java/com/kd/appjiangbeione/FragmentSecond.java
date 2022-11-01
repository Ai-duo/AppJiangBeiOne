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

import com.kd.appjiangbeione.databinding.ActivityFifthBinding;


public class FragmentSecond extends Fragment {
    Dmgd dmgd;
    Dmrd dmrd;
    Typeface tf;
    String dm4d;
    ActivityFifthBinding inflate;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if(inflate==null) {
            inflate = DataBindingUtil.inflate(inflater, R.layout.activity_fifth, container, false);
            inflate.setTf(tf);
        }
        if(dmgd!=null){
            inflate.setDmgd(dmgd);
        }
        if(dmrd!=null){
            inflate.setDmrd(dmrd);
        }
        if(dm4d!=null){
            inflate.setCo2(dm4d);
        }
        return inflate.getRoot();
    }
    public void setDmgd( Dmgd dmgd){
        this.dmgd = dmgd;
        if(inflate!=null)
            inflate.setDmgd(dmgd);
    }
    public void setDmrd( Dmrd dmrd){
        this.dmrd = dmrd;
        if(inflate!=null)
            inflate.setDmrd(dmrd);
    }
    public void setDm4d( String dm4d){
        this.dm4d = dm4d;
        if(inflate!=null)
            inflate.setCo2(dm4d);
    }
    public void setTf(Typeface tf){
        this.tf = tf;
    }
}
