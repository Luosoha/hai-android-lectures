package techkids.vn.lab6.activities;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.os.Bundle;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import butterknife.BindView;
import butterknife.ButterKnife;
import techkids.vn.lab6.R;
import techkids.vn.lab6.adapters.ScreenSlideAdapter;
import techkids.vn.lab6.events.CreateNewNoteEvent;
import techkids.vn.lab6.events.EditNoteEvent;
import techkids.vn.lab6.fragments.ActionOnNoteFragment;
import techkids.vn.lab6.networks.jsonmodels.responsemodels.ToDoResponseBody;

public class NoteActivity extends BaseActivity {

    public static final int NUM_PAGES = 2;
    private static final String TAG = NoteActivity.class.toString();

    @BindView(R.id.vp_to_do)
    ViewPager vpToDo;

    @BindView(R.id.tl_title)
    TabLayout tlTitle;

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
        tlTitle.setupWithViewPager(vpToDo);
        screenSlideAdapter = new ScreenSlideAdapter(getSupportFragmentManager());
        vpToDo.setAdapter(screenSlideAdapter);
    }

    @Subscribe
    public void onEvent(CreateNewNoteEvent createNewNoteEvent) {
        ActionOnNoteFragment actionOnNoteFragment = new ActionOnNoteFragment();
        actionOnNoteFragment.setActionCode(ActionOnNoteFragment.CREATE_CODE);
        changeFragment(R.id.fl_container, actionOnNoteFragment, false);
    }

    @Subscribe
    public void onEvent(EditNoteEvent editNoteEvent) {
        ActionOnNoteFragment actionOnNoteFragment = new ActionOnNoteFragment();
        actionOnNoteFragment.setActionCode(ActionOnNoteFragment.EDIT_CODE);
        actionOnNoteFragment.setToDoResponseBody(editNoteEvent.getToDoResponseBody());
        changeFragment(R.id.fl_container, actionOnNoteFragment, false);
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
