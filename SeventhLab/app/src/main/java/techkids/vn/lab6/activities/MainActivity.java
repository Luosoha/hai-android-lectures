package techkids.vn.lab6.activities;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.widget.FrameLayout;
import android.widget.Toast;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import butterknife.BindView;
import butterknife.ButterKnife;
import techkids.vn.lab6.R;
import techkids.vn.lab6.adapters.ScreenSlideAdapter;
import techkids.vn.lab6.events.CreateNewNoteEvent;
import techkids.vn.lab6.events.SaveToDoEvent;
import techkids.vn.lab6.events.OnButtonClickEvent;
import techkids.vn.lab6.fragments.CreateFragment;
import techkids.vn.lab6.fragments.LoginFragment;
import techkids.vn.lab6.fragments.ToDoFragment;
import techkids.vn.lab6.managers.Preferences;

public class MainActivity extends BaseActivity {

    private static final String TAG = MainActivity.class.toString();

    @BindView(R.id.fl_container)
    FrameLayout flContainer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }

    private void init() {
        ButterKnife.bind(this);
        EventBus.getDefault().register(this);

        if (Preferences.getInstance().getToken() == null) {
            changeFragment(R.id.fl_container, new LoginFragment(), false);
        }
        else {
            changeFragment(R.id.fl_container, new LoginFragment(), false);
            Intent intent = new Intent(this, NoteActivity.class);
            startActivity(intent);
        }
    }

    @Subscribe
    public void onEvent(OnButtonClickEvent onButtonClickEvent) {
        Toast.makeText(this, onButtonClickEvent.getMessage(), Toast.LENGTH_SHORT).show();
        if (onButtonClickEvent.getToken() != null) {
            Intent intent = new Intent(this, NoteActivity.class);
            startActivity(intent);
        }
    }

    @Subscribe
    public void onEvent(SaveToDoEvent saveToDoEvent) {
        Intent intent = new Intent(this, NoteActivity.class);
        startActivity(intent);
    }

}
