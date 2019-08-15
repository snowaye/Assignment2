package padc.training.batch9.snowaye.assignment2.activity;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import padc.training.batch9.snowaye.assignment2.R;
import padc.training.batch9.snowaye.assignment2.util.Util;

public class DetailActivity extends AppCompatActivity {

    public static Intent newIntent(Context context) {
        Intent intent = new Intent(context, DetailActivity.class);
        return intent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        Util.setStatusBarColor(this, R.color.statusBarColor);
    }
}
