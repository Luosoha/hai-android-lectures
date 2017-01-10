package techkids.vn.hackathon.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.BindView;
import butterknife.ButterKnife;
import techkids.vn.hackathon.R;
import techkids.vn.hackathon.adapters.FriendAdapter;

/**
 * A simple {@link Fragment} subclass.
 */
public class ListFriendFragment extends Fragment {

    @BindView(R.id.rv_list_friend)
    RecyclerView rvListFriend;

    private FriendAdapter friendAdapter;

    public ListFriendFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_list_friend, container, false);

        ButterKnife.bind(this, view);
        setupUI();

        return view;
    }

    private void setupUI() {
        friendAdapter = new FriendAdapter();
        rvListFriend.setHasFixedSize(true);
        rvListFriend.setLayoutManager(new GridLayoutManager(this.getContext(), 1));
        rvListFriend.setAdapter(friendAdapter);
    }

}
