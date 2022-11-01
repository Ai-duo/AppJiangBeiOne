package com.kd.appjiangbeione;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.Observer;

import com.kd.appjiangbeione.databinding.ActivityMainBinding;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {
    ActivityMainBinding main;
    TextView timeView;
    Typeface tf;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        main = DataBindingUtil.setContentView(this, R.layout.activity_main);
        timeView = findViewById(R.id.time);
        tf = Typeface.createFromAsset(getAssets(), "fonts/simsun.ttc");
        main.setTf(tf);
        initFragments();
        //getLifecycle().addObserver(new MyObserver());
        receiverLiveData();
        startService();
        initTimer();
        changeFragment();

    }

    public void startService() {
        Intent intent = new Intent(this, ElementsService.class);
        startService(intent);
    }

    FragmentFirst fragmentFirst;
    FragmentSecond fragmentSecond;


    private void initFragments() {
        fragmentFirst = new FragmentFirst();
        fragmentFirst.setTf(tf);
        fragmentSecond = new FragmentSecond();
        fragmentSecond.setTf(tf);

    }

    private void changeFragment() {
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {

            }
        }, 20 * 1000);
    }

    Timer timer;
    SimpleDateFormat format = new SimpleDateFormat("yyyy年MM月dd日 E HH:mm", Locale.CHINA);
    int index = 0;

    private void initTimer() {
        timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                String date = format.format(new Date());
                LiveDataBus.get().with("time").postValue(date);
                Log.i("TAG", "发送。。。。。。");
                int i = index % 2;
                if (i == 0) {
                    LiveDataBus.get().with("fragment").postValue(fragmentFirst);
                } else if (i == 1) {
                    LiveDataBus.get().with("fragment").postValue(fragmentSecond);
                }
                index++;
                if (index == 2000) {
                    index = 0;
                }
            }
        }, 0, 15000);
    }

    public void receiverLiveData() {
        LiveDataBus.get().with("time", String.class).observe(this, new Observer<String>() {
            @Override
            public void onChanged(String time) {
                Log.i("TAG", "收到数据》》》》");
                //  main.setTime(time);
                timeView.setText(time);
            }
        });
        LiveDataBus.get().with("fragment", Fragment.class).observe(this, new Observer<Fragment>() {
            @Override
            public void onChanged(Fragment fragment) {
                Log.i("TAG", "收到数据》》》》");
                //  main.setTime(time);
                FragmentManager manager = getSupportFragmentManager();
                FragmentTransaction transaction = manager.beginTransaction();
                transaction.replace(R.id.content, fragment).commit();
            }
        });
        LiveDataBus.get().with("dmgd", Dmgd.class).observe(this, new Observer<Dmgd>() {
            @Override
            public void onChanged(Dmgd s) {
                Log.i("TAG", "收到Dmgd数据》》》》");
                //  main.setTime(time);
                fragmentFirst.setDmgd(s);
                fragmentSecond.setDmgd(s);
            }
        });
        LiveDataBus.get().with("dmsd", Dmsd.class).observe(this, new Observer<Dmsd>() {
            @Override
            public void onChanged(Dmsd s) {
                Log.i("TAG", "收到Dmsd数据》》》》");
                //  main.setTime(time);
                fragmentFirst.setDmsd(s);
            }
        });
        LiveDataBus.get().with("dm5d", Dm5d.class).observe(this, new Observer<Dm5d>() {
            @Override
            public void onChanged(Dm5d s) {
                Log.i("TAG", "收到数据》》》》");
                //  main.setTime(time);
                //fragmentSecond.setDm5d(s);
            }
        });
        LiveDataBus.get().with("dm4d", String.class).observe(this, new Observer<String>() {
            @Override
            public void onChanged(String s) {
                Log.i("TAG", "收到Dm4d数据》》》》");

                fragmentSecond.setDm4d(s);
            }
        });
        LiveDataBus.get().with("dmrd", Dmrd.class).observe(this, new Observer<Dmrd>() {
            @Override
            public void onChanged(Dmrd s) {
                Log.i("TAG", "收到Dmrd数据》》》》");
             //   fragmentFirst.setDmrd(s);
                fragmentSecond.setDmrd(s);
            }
        });
        LiveDataBus.get().with("dmaq", Dmaq.class).observe(this, new Observer<Dmaq>() {
            @Override
            public void onChanged(Dmaq s) {
                Log.i("TAG", "收到数据》》》》");

            }
        });
        LiveDataBus.get().with("oxy", String.class).observe(this, new Observer<String>() {
            @Override
            public void onChanged(String s) {
                Log.i("TAG", "收到数据》》》》");

            }
        });
    }

   /* @NonNull
    @Override
    public Lifecycle getLifecycle() {
        return mLifecycleRegistry;
    }*/
}