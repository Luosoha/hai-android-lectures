package techkids.vn.listviewintro.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

import techkids.vn.listviewintro.R;
import techkids.vn.listviewintro.fragments.DetailFragment;
import techkids.vn.listviewintro.fragments.OnStudentUpdateListener;
import techkids.vn.listviewintro.models.Student;

public class MainActivity extends BaseActivity implements OnStudentUpdateListener {

    private static final String TAG = MainActivity.class.toString();

    private ArrayList<Student> students;

    private ArrayAdapter<Student> studentArrayAdapter;

    private ListView lvStudent;
    private Button btAdd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        students = Student.list;

        getReferences();
        setupUI();
    }

    private void getReferences() {
        lvStudent = (ListView) findViewById(R.id.lv_student);
        btAdd = (Button) findViewById(R.id.bt_add);
    }

    @Override
    protected void onRestart() {
        studentArrayAdapter.notifyDataSetChanged();
        super.onRestart();
    }

    private void setupUI() {
        // Create Adapter
        studentArrayAdapter = new ArrayAdapter<Student>(
                this, android.R.layout.simple_list_item_1, students
        );
        lvStudent.setAdapter(studentArrayAdapter);

        lvStudent.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Student student = students.get(position);
                Log.d(TAG, String.format("%s was tapped", student));

                if (findViewById(R.id.fl_detail) == null) {
                    Intent intent = new Intent(MainActivity.this, DetailActivity.class);
                    intent.putExtra(DetailActivity.STUDENT_KEY, student);
                    intent.putExtra(DetailActivity.OPERATION_KEY, Student.OP_UPDATE);
                    startActivity(intent);
                }
                else {
                    DetailFragment detailFragment = DetailFragment.create(
                            student,
                            Student.OP_UPDATE
                    );
                    detailFragment.setOnStudentUpdateListener(MainActivity.this);
                    changeFragment(R.id.fl_detail, detailFragment, true);
                }
            }
        });

        lvStudent.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                Student student = students.get(position);
                students.remove(position);
                studentArrayAdapter.notifyDataSetChanged();
                Log.d(TAG, String.format("%s was long clicked", student));
                return true;
            }
        });

        btAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Intent intent = new Intent(MainActivity.this, DetailActivity.class);
//                intent.putExtra(DetailActivity.OPERATION_KEY, Student.OP_ADD);
//                startActivity(intent);
                if (findViewById(R.id.fl_detail) == null) {
                    Intent intent = new Intent(MainActivity.this, DetailActivity.class);
                    intent.putExtra(DetailActivity.OPERATION_KEY, Student.OP_ADD);
                    startActivity(intent);
                }
                else {
                    DetailFragment detailFragment = DetailFragment.create(
                            null,
                            Student.OP_ADD
                    );
                    detailFragment.setOnStudentUpdateListener(MainActivity.this);
                    changeFragment(R.id.fl_detail, detailFragment, true);
                }
            }
        });
    }

    @Override
    public void onUpdate() {
        studentArrayAdapter.notifyDataSetChanged();
    }
}
