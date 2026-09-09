package com.kiya.launcher;

import android.app.*;
import android.content.*;
import android.content.pm.*;
import android.graphics.Color;
import android.os.Bundle;
import android.view.*;
import android.widget.*;
import java.util.*;

public class MainActivity extends Activity {
    LinearLayout root, grid; TextView title;
    @Override public void onCreate(Bundle b){super.onCreate(b); build();}
    void build(){
        root=new LinearLayout(this); root.setOrientation(LinearLayout.VERTICAL); root.setPadding(24,40,24,24); root.setBackgroundColor(Color.BLACK);
        LinearLayout bar=new LinearLayout(this); bar.setGravity(Gravity.CENTER_VERTICAL);
        title=new TextView(this); title.setText("Kiya Launcher"); title.setTextColor(Color.WHITE); title.setTextSize(25); bar.addView(title,new LinearLayout.LayoutParams(0,70,1));
        Button settings=new Button(this); settings.setText("Settings"); settings.setOnClickListener(v->startActivity(new Intent(this,SettingsActivity.class))); bar.addView(settings,new LinearLayout.LayoutParams(-2,70)); root.addView(bar);
        EditText search=new EditText(this); search.setHint("Search apps"); search.setHintTextColor(Color.GRAY); search.setTextColor(Color.WHITE); search.setSingleLine(); root.addView(search,new LinearLayout.LayoutParams(-1,60));
        ScrollView scroll=new ScrollView(this); grid=new LinearLayout(this); grid.setOrientation(LinearLayout.VERTICAL); scroll.addView(grid); root.addView(scroll,new LinearLayout.LayoutParams(-1,0,1)); setContentView(root);
        search.addTextChangedListener(new android.text.TextWatcher(){public void beforeTextChanged(CharSequence s,int a,int c,int d){} public void onTextChanged(CharSequence s,int a,int b,int c){load(s.toString());} public void afterTextChanged(android.text.Editable e){}}); load("");
    }
    void load(String q){grid.removeAllViews(); PackageManager pm=getPackageManager(); Intent i=new Intent(Intent.ACTION_MAIN); i.addCategory(Intent.CATEGORY_LAUNCHER); List<ResolveInfo> apps=pm.queryIntentActivities(i,0); Collections.sort(apps,Comparator.comparing(a->a.loadLabel(pm).toString().toLowerCase()));
        for(ResolveInfo r:apps){String name=r.loadLabel(pm).toString(); if(!name.toLowerCase().contains(q.toLowerCase()))continue; Button b=new Button(this); b.setAllCaps(false); b.setText(name); b.setTextSize(17); b.setGravity(Gravity.START|Gravity.CENTER_VERTICAL); b.setOnClickListener(v->{Intent x=pm.getLaunchIntentForPackage(r.activityInfo.packageName); if(x!=null)startActivity(x);}); grid.addView(b,new LinearLayout.LayoutParams(-1,64));}
    }
    @Override public void onBackPressed(){ }
}
