package com.kiya.launcher;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.provider.Settings;
import android.view.View;
import android.widget.*;

public class SettingsActivity extends Activity {
    private SharedPreferences prefs;
    @Override public void onCreate(Bundle state) {
        super.onCreate(state);
        prefs = getSharedPreferences("launcher", MODE_PRIVATE);
        LinearLayout root = new LinearLayout(this);
        root.setOrientation(LinearLayout.VERTICAL);
        root.setPadding(24,32,24,24);
        TextView title = new TextView(this); title.setText("Kiya Launcher Settings"); title.setTextSize(24); root.addView(title);
        root.addView(text("Launcher type"));
        Spinner modes = new Spinner(this);
        String[] values = {"Standard / Stock-like","Third-party style","Custom","Minimalist","Gaming"};
        modes.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, values));
        modes.setSelection(prefs.getInt("mode",0));
        modes.setOnItemSelectedListener(new android.widget.AdapterView.OnItemSelectedListener(){
            public void onNothingSelected(android.widget.AdapterView<?> p) {}
            public void onItemSelected(android.widget.AdapterView<?> p, View v, int pos, long id){prefs.edit().putInt("mode",pos).apply();}
        });
        root.addView(modes);
        Button home = new Button(this); home.setText("Choose default Home app");
        home.setOnClickListener(v -> startActivity(new Intent(Settings.ACTION_HOME_SETTINGS))); root.addView(home);
        root.addView(toggle("Show search", "search", true));
        root.addView(toggle("Show app labels", "labels", true));
        root.addView(toggle("Animations", "animations", true));
        root.addView(toggle("Gaming mode", "gaming", false));
        root.addView(text("Animation duration"));
        SeekBar anim = new SeekBar(this); anim.setMax(1000); anim.setProgress(prefs.getInt("animation_ms",250));
        anim.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener(){public void onStartTrackingTouch(SeekBar b){} public void onStopTrackingTouch(SeekBar b){} public void onProgressChanged(SeekBar b,int p,boolean f){prefs.edit().putInt("animation_ms",p).apply();}}); root.addView(anim);
        setContentView(root);
    }
    TextView text(String s){TextView t=new TextView(this);t.setText(s);t.setTextSize(17);t.setPadding(4,18,4,8);return t;}
    Switch toggle(String s,String key,boolean d){Switch x=new Switch(this);x.setText(s);x.setChecked(prefs.getBoolean(key,d));x.setOnCheckedChangeListener((v,c)->prefs.edit().putBoolean(key,c).apply());return x;}
}
