package padc.training.batch9.snowaye.assignment2.activity;


import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.AppCompatImageView;
import android.support.v7.widget.AppCompatTextView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import java.util.ArrayList;
import java.util.List;
import padc.training.batch9.snowaye.assignment2.R;
import padc.training.batch9.snowaye.assignment2.fragment.DistanceFragment;
import padc.training.batch9.snowaye.assignment2.fragment.LowestPriceFragment;
import padc.training.batch9.snowaye.assignment2.fragment.RecommendedFragment;
import padc.training.batch9.snowaye.assignment2.util.Util;

public class MainActivity extends AppCompatActivity {

    private String tag = getClass().getSimpleName();

    TabLayout tabLayout;
    ViewPager viewPager;
    public static ViewPagerAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initializeUiComponent();
        initializeData();
        setupViewPager(viewPager);
        tabLayout.setupWithViewPager(viewPager);
        setupTabIcons();
        selectFirstTab();
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                selectTab(tab);
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
                unselectTab(tab);
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }

    private void initializeUiComponent() {
        tabLayout = findViewById(R.id.tabLayout);
        viewPager = findViewById(R.id.viewpager);
        viewPager.setOffscreenPageLimit(1);
        Util.setStatusBarColor(this, R.color.statusBarColor);

    }

    private void initializeData() {

    }

    private void setupViewPager(ViewPager viewPager) {
        adapter = new ViewPagerAdapter(getSupportFragmentManager());

        adapter.addFragment(new LowestPriceFragment(), "Lowest Price");
        adapter.addFragment(new DistanceFragment(), "Distance");
        adapter.addFragment(new RecommendedFragment(), "Recommended");

        viewPager.setAdapter(adapter);
    }

    private void setupTabIcons() {
        View viewLowestPrice = LayoutInflater.from(this).inflate(R.layout.tab_car, null);
        AppCompatImageView imgvLowestPrice =  viewLowestPrice.findViewById(R.id.imgv_tab);
        AppCompatTextView tvLowestPrice =  viewLowestPrice.findViewById(R.id.tv_tab);
        tvLowestPrice.setText("Lowest Price");
        imgvLowestPrice.setImageResource(R.drawable.ic_tab);
        imgvLowestPrice.setVisibility(View.VISIBLE);

        View viewDistance = LayoutInflater.from(this).inflate(R.layout.tab_car, null);
        AppCompatImageView imgvDistance =  viewDistance.findViewById(R.id.imgv_tab);
        AppCompatTextView tvDistance =  viewDistance.findViewById(R.id.tv_tab);
        tvDistance.setTextColor(ContextCompat.getColor(this, R.color.textColorMainLight));
        tvDistance.setText("Distance");
        imgvDistance.setVisibility(View.INVISIBLE);

        View viewRecommemded = LayoutInflater.from(this).inflate(R.layout.tab_car, null);
        AppCompatImageView imgvRecommended = viewRecommemded.findViewById(R.id.imgv_tab);
        AppCompatTextView tvRecommended =  viewRecommemded.findViewById(R.id.tv_tab);
        tvRecommended.setText("Recommended");
        tvRecommended.setTextColor(ContextCompat.getColor(this, R.color.textColorMainLight));
        imgvRecommended.setVisibility(View.INVISIBLE);

        tabLayout.getTabAt(0).setCustomView(viewLowestPrice);
        tabLayout.getTabAt(1).setCustomView(viewDistance);
        tabLayout.getTabAt(2).setCustomView(viewRecommemded);
    }

    private void selectTab(TabLayout.Tab tab) {
        Log.i(tag, "selectTab="+tab.getPosition());
        View view = tab.getCustomView();
        AppCompatTextView tv  = view.findViewById(R.id.tv_tab);
        AppCompatImageView imgeView = view.findViewById(R.id.imgv_tab);
        String text = null;
        switch (tab.getPosition()) {
            case 0:
                text = "Lowest Price";
                break;
            case 1:
                text = "Distance";
                break;
            case 2:
                text = "Recommended";
                break;
        }
        tv.setText(text);
        tv.setTextColor(ContextCompat.getColor(this, R.color.textColorMain));
        imgeView.setVisibility(View.VISIBLE);
    }

    private void unselectTab(TabLayout.Tab tab) {
        Log.i(tag, "selectTab="+tab.getPosition());
        View view = tab.getCustomView();
        AppCompatTextView tv  = view.findViewById(R.id.tv_tab);
        AppCompatImageView imgeView = view.findViewById(R.id.imgv_tab);
        String text = null;
        switch (tab.getPosition()) {
            case 0:
                text = "Lowest Price";
                break;
            case 1:
                text = "Distance";
                break;
            case 2:
                text = "Recommended";
                break;
        }
        tv.setText(text);
        tv.setTextColor(ContextCompat.getColor(this, R.color.textColorMainLight));
        imgeView.setVisibility(View.INVISIBLE);
    }

    /**
     * This method is for selecting the first tab/page in case sometimes viewpager is not selecting the first page.
     */
    private void selectFirstTab() {
        viewPager.setCurrentItem(0);
        tabLayout.getTabAt(0).select();
        View view = tabLayout.getTabAt(0).getCustomView();
        AppCompatImageView imgvTab = view.findViewById(R.id.imgv_tab);
        AppCompatTextView tvTab =  view.findViewById(R.id.tv_tab);
        tvTab.setText("Lowest Price");
        imgvTab.setImageResource(R.drawable.ic_tab);
        imgvTab.setVisibility(View.VISIBLE);
    }


    class ViewPagerAdapter extends FragmentPagerAdapter {
        private final List<Fragment> mFragmentList = new ArrayList<>();
        private final List<String> mFragmentTitleList = new ArrayList<>();

        public ViewPagerAdapter(FragmentManager manager) {
            super(manager);
        }

        @Override
        public Fragment getItem(int position) {
            return mFragmentList.get(position);
        }

        @Override
        public int getCount() {
            return mFragmentList.size();
        }

        public void addFragment(Fragment fragment, String title) {
            mFragmentList.add(fragment);
            mFragmentTitleList.add(title);
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return mFragmentTitleList.get(position);
        }
    }
}
