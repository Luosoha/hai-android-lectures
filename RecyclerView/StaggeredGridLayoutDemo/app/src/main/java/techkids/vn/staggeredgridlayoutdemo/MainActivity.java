package techkids.vn.staggeredgridlayoutdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;

import butterknife.BindView;
import butterknife.ButterKnife;
import techkids.vn.staggeredgridlayoutdemo.adapters.NoteAdapter;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.rv_note)
    RecyclerView rvNote;

    private NoteAdapter noteAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        setupUI();
    }

    private void setupUI() {
        noteAdapter = new NoteAdapter();
        rvNote.setHasFixedSize(true);
        rvNote.setLayoutManager(new StaggeredGridLayoutManager(2, 1));
        rvNote.setAdapter(noteAdapter);
    }

}
