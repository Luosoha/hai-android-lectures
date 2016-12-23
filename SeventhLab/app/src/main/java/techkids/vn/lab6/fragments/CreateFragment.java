package techkids.vn.lab6.fragments;


import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v7.widget.CardView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.Spinner;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import java.util.Arrays;

import butterknife.BindView;
import butterknife.ButterKnife;
import techkids.vn.lab6.R;
import techkids.vn.lab6.adapters.ColorAdapter;
import techkids.vn.lab6.events.SaveToDoEvent;
import techkids.vn.lab6.models.ColorChoosen;
import techkids.vn.lab6.networks.DbContext;
import techkids.vn.lab6.networks.jsonmodels.requestmodels.CreateNoteRequestBody;

/**
 * A simple {@link Fragment} subclass.
 */
public class CreateFragment extends Fragment {

    private static final String TAG = CreateFragment.class.toString();
    @BindView(R.id.et_title)
    EditText etTitle;

    @BindView(R.id.et_content)
    EditText etContent;

    @BindView(R.id.sp_color)
    Spinner spColor;

    @BindView(R.id.fb_check)
    FloatingActionButton fbCheck;

    @BindView(R.id.cv_container)
    CardView cvContainer;

    private ColorAdapter colorAdapter;
    private String color;

    public CreateFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_create, container, false);

        ButterKnife.bind(this, view);

        setupUI();
        addListeners();

        return view;
    }

    private void addListeners() {
        spColor.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                color = ColorChoosen.COLORS[position].getColorSrc();
                cvContainer.setBackgroundColor(Color.parseColor(color));
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        fbCheck.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CreateNoteRequestBody createNoteRequestBody = new CreateNoteRequestBody(
                        etTitle.getText().toString(),
                        etContent.getText().toString(),
                        color
                );
                Log.d(TAG, createNoteRequestBody.toString());

                DbContext.createNote(createNoteRequestBody);

                EventBus.getDefault().post(new SaveToDoEvent());
            }
        });
    }

    private void setupUI() {
        colorAdapter = new ColorAdapter(
                getContext(), R.layout.item_color, Arrays.asList(ColorChoosen.COLORS)
        );
        spColor.setAdapter(colorAdapter);
    }

}
