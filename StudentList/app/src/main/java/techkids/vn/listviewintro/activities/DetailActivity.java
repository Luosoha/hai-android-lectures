package techkids.vn.listviewintro.activities;

import android.content.Intent;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import techkids.vn.listviewintro.R;
import techkids.vn.listviewintro.fragments.DetailFragment;
import techkids.vn.listviewintro.fragments.OnStudentUpdateListener;
import techkids.vn.listviewintro.models.Student;

public class DetailActivity extends BaseActivity implements OnStudentUpdateListener {

    public static final String OPERATION_KEY = "operation";
    public static final String STUDENT_KEY = "student";
    private static final String TAG = DetailActivity.class.toString();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        Intent intent = getIntent();
        int operation = intent.getIntExtra(OPERATION_KEY, -1);
        Student student = (Student) intent.getSerializableExtra(STUDENT_KEY);

        if (student != null) {
            for (int i = 0; i < Student.list.size(); i++) {
                if (student.getName().equals(Student.list.get(i).getName())) {
                    student = Student.list.get(i);
                }
            }

            // 1: Create and pass arguments for fragment
            DetailFragment detailFragment = DetailFragment.create(student, operation);

            detailFragment.setOnStudentUpdateListener(this);

            // 2: Change fragment
            changeFragment(R.id.fl_detail, detailFragment, false);
        }
        else { // Add
            DetailFragment detailFragment = DetailFragment.create(null, operation);

            detailFragment.setOnStudentUpdateListener(this);

            changeFragment(R.id.fl_detail, detailFragment, false);
        }
    }


    @Override
    public void onUpdate() {
        finish();
    }
}
