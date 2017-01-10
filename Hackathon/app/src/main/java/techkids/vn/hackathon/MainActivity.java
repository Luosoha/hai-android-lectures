package techkids.vn.hackathon;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.FrameLayout;

import butterknife.BindView;
import butterknife.ButterKnife;
import techkids.vn.hackathon.adapters.FriendAdapter;
import techkids.vn.hackathon.fragments.ListFriendFragment;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.rv_list_friend)
    RecyclerView rvListFriend;

    private FriendAdapter friendAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);
        setupUI();

//        getSupportFragmentManager().beginTransaction()
//                .replace(R.id.fl_container, new ListFriendFragment())
//                .addToBackStack(null)
//                .commit();
    }

    private void setupUI() {
        friendAdapter = new FriendAdapter();
        rvListFriend.setHasFixedSize(true);
        rvListFriend.setLayoutManager(new GridLayoutManager(this, 1));
        rvListFriend.setAdapter(friendAdapter);
    }


}
