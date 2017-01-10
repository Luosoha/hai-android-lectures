package techkids.vn.lab6.fragments;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;

import org.greenrobot.eventbus.EventBus;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import techkids.vn.lab6.R;
import techkids.vn.lab6.adapters.ToDoAdapter;
import techkids.vn.lab6.events.CreateNewNoteEvent;
import techkids.vn.lab6.managers.Preferences;
import techkids.vn.lab6.networks.DbContext;
import techkids.vn.lab6.networks.jsonmodels.responsemodels.ToDoResponseBody;

/**
 * A simple {@link Fragment} subclass.
 */
public class ToDoFragment extends Fragment {

    @BindView(R.id.rv_finished_to_do_list)
    RecyclerView rvToDoList;

    @BindView(R.id.fb_add)
    FloatingActionButton fbAdd;

    private ToDoAdapter toDoAdapter;

    private static final String TAG = ToDoFragment.class.toString();

    public ToDoFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onStart() {
        super.onStart();
        DbContext.getToDoList(Preferences.getInstance().getToken()).enqueue(new Callback<List<ToDoResponseBody>>() {
            @Override
            public void onResponse(Call<List<ToDoResponseBody>> call, Response<List<ToDoResponseBody>> response) {
                Log.d(TAG, "onResponse");
//                ToDoResponseBody.toDoList = response.body();
                ToDoResponseBody.toDoList.clear();
                for (ToDoResponseBody toDoResponseBody : response.body()) {
                    if (!toDoResponseBody.isCompleted()) {

                        ToDoResponseBody.toDoList.add(toDoResponseBody);
                    }
                }
                Log.d(TAG, ToDoResponseBody.toDoList.toString());
                toDoAdapter.notifyDataSetChanged();
            }

            @Override
            public void onFailure(Call<List<ToDoResponseBody>> call, Throwable t) {
                Log.d(TAG, "onFailure");
            }
        });
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_to_do, container, false);

        ButterKnife.bind(this, view);
        setupUI();
        addListeners();

        return view;
    }

    private void addListeners() {
        fbAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "ivAdd onClick");
                EventBus.getDefault().post(new CreateNewNoteEvent());
            }
        });

//        rvToDoList.addOnItemTouchListener(new RecyclerView.OnItemTouchListener() {
//            @Override
//            public boolean onInterceptTouchEvent(RecyclerView rv, MotionEvent e) {
//                Log.d(TAG, "onInterceptTouchEvent");
//                return false;
//            }
//
//            @Override
//            public void onTouchEvent(RecyclerView rv, MotionEvent e) {
//                Log.d(TAG, "onTouchEvent");
//            }
//
//            @Override
//            public void onRequestDisallowInterceptTouchEvent(boolean disallowIntercept) {
//                Log.d(TAG, "onRequestDisallowInterceptTouchEvent");
//            }
//        });
    }

    private void setupUI() {
        toDoAdapter = new ToDoAdapter();
        rvToDoList.setHasFixedSize(true);
        rvToDoList.setLayoutManager(new StaggeredGridLayoutManager(2, 1));
        rvToDoList.setAdapter(toDoAdapter);
    }

    @Override
    public void onStop() {
        super.onStop();
    }

}
