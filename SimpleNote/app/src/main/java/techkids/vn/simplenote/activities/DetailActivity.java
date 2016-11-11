package techkids.vn.simplenote.activities;

import android.content.Intent;
import android.os.Bundle;

import techkids.vn.simplenote.R;
import techkids.vn.simplenote.fragments.DetailFragment;
import techkids.vn.simplenote.fragments.onNoteUpdateListener;
import techkids.vn.simplenote.models.SimpleNote;

public class DetailActivity extends BaseActivity implements onNoteUpdateListener {

    public static final String POSITION_KEY = "position";
    public static final String OPERATION_KEY = "operation";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        Intent intent = getIntent();
        int position = intent.getIntExtra(POSITION_KEY, -1);
        int operation = intent.getIntExtra(OPERATION_KEY, -1);

        if (position != -1) {
            SimpleNote simpleNote = SimpleNote.list.get(position);

            // 1: Create and pass arguments for fragment
            DetailFragment detailFragment = DetailFragment.create(simpleNote, operation);

            detailFragment.setOnNoteUpdateListener(this);

            // 2: Change fragment
            changeFragment(R.id.fl_detail, detailFragment, false);
        }
        else { // Add
            DetailFragment detailFragment = DetailFragment.create(null, operation);

            detailFragment.setOnNoteUpdateListener(this);

            changeFragment(R.id.fl_detail, detailFragment, false);
        }
    }

    @Override
    public void onUpdate() {
        finish();
    }
}
