package techkids.vn.lab6.adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import techkids.vn.lab6.activities.NoteActivity;
import techkids.vn.lab6.fragments.CompletedToDoFragment;
import techkids.vn.lab6.fragments.ToDoFragment;

/**
 * Created by Lush on 12/23/2016.
 */

public class ScreenSlideAdapter extends FragmentStatePagerAdapter {
    public ScreenSlideAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return new ToDoFragment();
            case 1:
                return new CompletedToDoFragment();
        }
        return null;
    }

    @Override
    public int getCount() {
        return NoteActivity.NUM_PAGES;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        switch (position) {
            case 0:
                return "To Do List";
            case 1:
                return "Completed List";
        }
        return null;
    }
}
