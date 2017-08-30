package com.pabloserrano.recipes.view.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import com.pabloserrano.recipes.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public abstract class BaseActivity extends AppCompatActivity {

    @Nullable
    @BindView(R.id.toolbar)
    Toolbar toolbar;

    @Override protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutId());
        initializeButterKnife();
        initializeToolbar();
    }

    protected abstract int getLayoutId();

    private void initializeButterKnife() {
        ButterKnife.bind(this);
    }

    protected void initializeToolbar() {
        if (toolbar != null) {
            setSupportActionBar(toolbar);
        }
    }
}
