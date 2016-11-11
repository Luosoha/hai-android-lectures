package techkids.vn.simplenote.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import techkids.vn.simplenote.R;
import techkids.vn.simplenote.models.SimpleNote;

/**
 * A simple {@link Fragment} subclass.
 */
public class DetailFragment extends Fragment {

    private SimpleNote simpleNote;
    private int operation;
    private onNoteUpdateListener onNoteUpdateListener;

    private EditText etTitle;
    private EditText etMultiLine;
    private Button btSave;

    public DetailFragment() {
        // Required empty public constructor
    }

    public void setSimpleNote(SimpleNote simpleNote) {
        this.simpleNote = simpleNote;
    }

    public void setOperation(int operation) {
        this.operation = operation;
    }

    public void setOnNoteUpdateListener(techkids.vn.simplenote.fragments.onNoteUpdateListener onNoteUpdateListener) {
        this.onNoteUpdateListener = onNoteUpdateListener;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_detail, container, false);

        getReferences(view);
        setupUI();
        addListeners();

        return view;
    }

    public static DetailFragment create(SimpleNote simpleNote, int operation) {
        // 1: Create fragment
        DetailFragment detailFragment = new DetailFragment();

        // 2: Pass arguments (optional)
        if (operation == simpleNote.OP_UPDATE) {
            detailFragment.setSimpleNote(simpleNote);
            detailFragment.setOperation(operation);
        }

        return detailFragment;
    }


    private void getReferences(View view) {
        etTitle = (EditText) view.findViewById(R.id.et_title);
        etMultiLine = (EditText) view.findViewById(R.id.et_multi_line);
        btSave = (Button) view.findViewById(R.id.bt_save);
    }

    private void setupUI() {
        if (operation == SimpleNote.OP_UPDATE) {
            etTitle.setText(simpleNote.getTitle());
            etMultiLine.setText(simpleNote.getNote());
        }
    }

    private void addListeners() {
        btSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (operation == simpleNote.OP_UPDATE) {
                    simpleNote.setNote(etMultiLine.getText().toString());

                    if (onNoteUpdateListener != null) {
                        onNoteUpdateListener.onUpdate();
                    }
                }

                if (operation == simpleNote.OP_ADD) {
                    SimpleNote tmp = new SimpleNote("");
                    tmp.setTitle(etTitle.getText().toString());
                    tmp.setNote(etMultiLine.getText().toString());
                    SimpleNote.list.add(tmp);
                    if (onNoteUpdateListener != null) {
                        onNoteUpdateListener.onUpdate();
                    }
//                    onStudentUpdateListener.onUpdate();
//                    getActivity().finish();
                }
            }
        });
    }

}
