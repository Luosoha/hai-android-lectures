package techkids.vn.lab6.activities;

import android.content.Intent;
import android.os.Build;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import butterknife.BindView;
import butterknife.ButterKnife;
import techkids.vn.lab6.R;
import techkids.vn.lab6.adapters.ScreenSlideAdapter;
import techkids.vn.lab6.events.CreateNewNoteEvent;
import techkids.vn.lab6.events.SaveToDoEvent;
import techkids.vn.lab6.fragments.CreateFragment;
import techkids.vn.lab6.fragments.ToDoFragment;

public class NoteActivity extends BaseActivity {

    public static final int NUM_PAGES = 2;
    private static final String TAG = NoteActivity.class.toString();

    @BindView(R.id.vp_to_do)
    ViewPager vpToDo;

    private ScreenSlideAdapter screenSlideAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_note);
        init();
    }

    public void init() {
        ButterKnife.bind(this);
        EventBus.getDefault().register(this);
        screenSlideAdapter = new ScreenSlideAdapter(getSupportFragmentManager());
        vpToDo.setAdapter(screenSlideAdapter);
    }

    @Subscribe
    public void onEvent(CreateNewNoteEvent createNewNoteEvent) {
        changeFragment(R.id.fl_container, new CreateFragment(), false);
    }

    @Override
    public void onBackPressed() {
        if (vpToDo.getCurrentItem() == 0) {
            super.onBackPressed();
        } else {
            vpToDo.setCurrentItem(vpToDo.getCurrentItem() - 1);
        }
    }

    @Override
    protected void onStop() {
        super.onStop();
        EventBus.getDefault().unregister(this);
    }

    @Override
    public void recreate() {
        super.recreate();
    }
}
