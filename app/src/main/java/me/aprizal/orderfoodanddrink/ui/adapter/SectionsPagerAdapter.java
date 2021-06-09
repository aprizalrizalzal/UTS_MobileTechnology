package me.aprizal.orderfoodanddrink.ui.adapter;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import org.jetbrains.annotations.NotNull;

import me.aprizal.orderfoodanddrink.R;
import me.aprizal.orderfoodanddrink.ui.main.DrinkFragment;
import me.aprizal.orderfoodanddrink.ui.main.EatFragment;

public class SectionsPagerAdapter extends FragmentPagerAdapter {
    private static final int[]TAB_TITLES=new int[]{R.string.tab_eat,R.string.tab_drink};
    private final Context tabContext;

    public SectionsPagerAdapter(@NonNull @NotNull FragmentManager fm, Context context) {
        super(fm);
        this.tabContext = context;
    }

    @NonNull
    @org.jetbrains.annotations.NotNull
    @Override
    public Fragment getItem(int position) {
        switch ( position ){
            case 0 :
                return new EatFragment();
            case 1 :
                return new DrinkFragment();
            default:
                return new Fragment();
        }
    }

    @Override
    public int getCount() {
        return 2;
    }

    public CharSequence getPageTitle(int positions){
        return tabContext.getString(TAB_TITLES[positions]);
    }
}
