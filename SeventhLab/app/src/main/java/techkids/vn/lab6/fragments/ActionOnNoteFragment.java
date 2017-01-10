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

import java.util.Arrays;

import butterknife.BindView;
import butterknife.ButterKnife;
import techkids.vn.lab6.R;
import techkids.vn.lab6.adapters.ColorAdapter;
import techkids.vn.lab6.events.EditNoteEvent;
import techkids.vn.lab6.events.SaveToDoEvent;
import techkids.vn.lab6.models.ColorChoosen;
import techkids.vn.lab6.networks.DbContext;
import techkids.vn.lab6.networks.jsonmodels.requestmodels.ActionOnNoteRequestBody;
import techkids.vn.lab6.networks.jsonmodels.responsemodels.ToDoResponseBody;

/**
 * A simple {@link Fragment} subclass.
 */
public class ActionOnNoteFragment extends Fragment {

    private static final String TAG = ActionOnNoteFragment.class.toString();
    public static final int EDIT_CODE = 0;
    public static final int CREATE_CODE = 1;

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

    private int actionCode;
    private ToDoResponseBody toDoResponseBody = null;
    private int colorIndex = -1;

    private ColorAdapter colorAdapter;
    private String color;

    public ActionOnNoteFragment() {
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

        if (toDoResponseBody != null) {
            etTitle.setText(toDoResponseBody.getTitle());
            etContent.setText(toDoResponseBody.getContent());
            cvContainer.setBackgroundColor(Color.parseColor(toDoResponseBody.getColor()));
        }

        return view;
    }

    private void addListeners() {
        spColor.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (toDoResponseBody == null || (toDoResponseBody != null & position != 0)) {
                    color = ColorChoosen.COLORS[position].getColorSrc();
                    cvContainer.setBackgroundColor(Color.parseColor(color));
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        fbCheck.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ActionOnNoteRequestBody createNoteRequestBody = new ActionOnNoteRequestBody(
                        etTitle.getText().toString(),
                        etContent.getText().toString(),
                        color
                );
                Log.d(TAG, createNoteRequestBody.toString());

                if (colorIndex != -1)
                ActionOnNoteRequestBody editNoteRequestBody = new ActionOnNoteRequestBody(
                        etTitle.getText().toString(),
                        etContent.getText().toString(),
                        ColorChoosen.COLORS[colorIndex].getColorSrc()
                );

                if (actionCode == CREATE_CODE) {
                    DbContext.createNote(createNoteRequestBody);
                } else if (actionCode == EDIT_CODE) {
                    DbContext.editNote(createNoteRequestBody, toDoResponseBody.getId());
                }

                EventBus.getDefault().post(new SaveToDoEvent());
            }
        });
    }

    private void setupUI() {
        colorAdapter = new ColorAdapter(
                getContext(), R.layout.item_color, Arrays.asList(ColorChoosen.COLORS)
        );
        spColor.setAdapter(colorAdapter);

        if (toDoResponseBody != null) {
            for (int i = 0; i < ColorChoosen.COLORS.length; i++) {
                if (toDoResponseBody.getColor().equals(ColorChoosen.COLORS[i].getColorSrc())) {
                    colorIndex = i;
                }
            }
        }
        spColor.setSelection(colorIndex);
    }

    public void setActionCode(int actionCode) {
        this.actionCode = actionCode;
    }

    public void setToDoResponseBody(ToDoResponseBody toDoResponseBody) {
        this.toDoResponseBody = toDoResponseBody;
    }
}
