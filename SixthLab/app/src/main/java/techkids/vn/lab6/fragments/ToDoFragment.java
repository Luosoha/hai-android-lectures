package techkids.vn.lab6.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.BindView;
import butterknife.ButterKnife;
import techkids.vn.lab6.R;
import techkids.vn.lab6.adapters.ToDoAdapter;

/**
 * A simple {@link Fragment} subclass.
 */
public class ToDoFragment extends Fragment {

    @BindView(R.id.rv_to_do_list)
    RecyclerView rvToDoList;

    private ToDoAdapter toDoAdapter;

    private static final String TAG = ToDoFragment.class.toString();

    public ToDoFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_to_do, container, false);

        ButterKnife.bind(this, view);
        setupUI();

        return view;
    }

    private void setupUI() {
        toDoAdapter = new ToDoAdapter();
        rvToDoList.setHasFixedSize(true);
        rvToDoList.setLayoutManager(new StaggeredGridLayoutManager(2, 1));
        rvToDoList.setAdapter(toDoAdapter);
    }

    public ToDoAdapter getToDoAdapter() {
        return toDoAdapter;
    }

    @Override
    public void onStop() {
        super.onStop();
    }

}
