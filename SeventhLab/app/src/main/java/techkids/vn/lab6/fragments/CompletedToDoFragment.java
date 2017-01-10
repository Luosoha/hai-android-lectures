package techkids.vn.lab6.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import techkids.vn.lab6.R;
import techkids.vn.lab6.adapters.CompletedToDoAdapter;
import techkids.vn.lab6.managers.Preferences;
import techkids.vn.lab6.networks.DbContext;
import techkids.vn.lab6.networks.jsonmodels.responsemodels.ToDoResponseBody;

/**
 * A simple {@link Fragment} subclass.
 */
public class CompletedToDoFragment extends Fragment {

    private static final String TAG = CompletedToDoFragment.class.toString();

    @BindView(R.id.rv_finished_to_do_list)
    RecyclerView rvFinishedToDoList;

    private CompletedToDoAdapter completedToDoAdapter;

    public CompletedToDoFragment() {
        // Required empty public constructor
    }

    @Override
    public void onStart() {
        super.onStart();
        DbContext.getToDoList(Preferences.getInstance().getToken()).enqueue(new Callback<List<ToDoResponseBody>>() {
            @Override
            public void onResponse(Call<List<ToDoResponseBody>> call, Response<List<ToDoResponseBody>> response) {
                Log.d(TAG, "onResponse");
                ToDoResponseBody.completedToDoList.clear();
                for (ToDoResponseBody toDoResponseBody : response.body()) {
                    if (toDoResponseBody.isCompleted()) {
                        ToDoResponseBody.completedToDoList.add(toDoResponseBody);
                    }
                }
                Log.d(TAG, ToDoResponseBody.completedToDoList.toString());
                completedToDoAdapter.notifyDataSetChanged();
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
        View view = inflater.inflate(R.layout.fragment_finished_to_do, container, false);
        ButterKnife.bind(this, view);
        setupUI();
        return view;
    }

    private void setupUI() {
        completedToDoAdapter = new CompletedToDoAdapter();
        rvFinishedToDoList.setHasFixedSize(true);
        rvFinishedToDoList.setLayoutManager(new StaggeredGridLayoutManager(2, 1));
        rvFinishedToDoList.setAdapter(completedToDoAdapter);
    }

}
