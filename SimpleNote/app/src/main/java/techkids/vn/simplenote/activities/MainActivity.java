package techkids.vn.simplenote.activities;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

import techkids.vn.simplenote.R;
import techkids.vn.simplenote.fragments.DetailFragment;
import techkids.vn.simplenote.fragments.onNoteUpdateListener;
import techkids.vn.simplenote.models.SimpleNote;

public class MainActivity extends BaseActivity implements onNoteUpdateListener {

    private static final String TAG = MainActivity.class.toString();

    private ArrayList<SimpleNote> simpleNotes;
    private ArrayAdapter<SimpleNote> noteArrayAdapter;

    private ListView lvNote;
    private Button btAdd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        simpleNotes = SimpleNote.list;

        getReferences();
        setupUI();
        addListeners();
    }

    @Override
    protected void onRestart() {
        noteArrayAdapter.notifyDataSetChanged();
        super.onRestart();
    }

    private void getReferences() {
        lvNote = (ListView) findViewById(R.id.lv_note);
        btAdd = (Button) findViewById(R.id.bt_add);
    }

    private void setupUI() {
        noteArrayAdapter = new ArrayAdapter<SimpleNote>(
                this, android.R.layout.simple_list_item_1, simpleNotes
        );
        lvNote.setAdapter(noteArrayAdapter);
    }

    private void addListeners() {
        lvNote.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                SimpleNote simpleNote = simpleNotes.get(position);
                Log.d(TAG, String.format("Note %s was clicked", simpleNote));

                if (findViewById(R.id.fl_detail) == null) {
                    Intent intent = new Intent(MainActivity.this, DetailActivity.class);
                    intent.putExtra(DetailActivity.POSITION_KEY, position);
                    intent.putExtra(DetailActivity.OPERATION_KEY, SimpleNote.OP_UPDATE);
                    startActivity(intent);
                }
                else {
                    DetailFragment detailFragment = DetailFragment.create(
                            simpleNote,
                            SimpleNote.OP_UPDATE
                    );
                    detailFragment.setOnNoteUpdateListener(MainActivity.this);
                    changeFragment(R.id.fl_detail, detailFragment, true);
                }
            }
        });

        lvNote.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                SimpleNote simpleNote = SimpleNote.list.get(position);
                simpleNotes.remove(simpleNote);
                noteArrayAdapter.notifyDataSetChanged();
                return true;
            }
        });

        btAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (findViewById(R.id.fl_detail) == null) {
                    Intent intent = new Intent(MainActivity.this, DetailActivity.class);
                    intent.putExtra(DetailActivity.OPERATION_KEY, SimpleNote.OP_ADD);
                    startActivity(intent);
                }
                else {
                    DetailFragment detailFragment = DetailFragment.create(
                            null,
                            SimpleNote.OP_ADD
                    );
                    detailFragment.setOnNoteUpdateListener(MainActivity.this);
                    changeFragment(R.id.fl_detail, detailFragment, true);
                }
            }
        });
    }

    @Override
    public void onUpdate() {
        noteArrayAdapter.notifyDataSetChanged();
    }
}
