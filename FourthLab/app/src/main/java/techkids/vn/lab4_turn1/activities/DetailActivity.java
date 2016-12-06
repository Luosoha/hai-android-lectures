package techkids.vn.lab4_turn1.activities;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import techkids.vn.lab4_turn1.R;
import techkids.vn.lab4_turn1.fragments.DetailFragment;
import techkids.vn.lab4_turn1.models.Company;

public class DetailActivity extends BaseActivity {

    public static final String COMPANY_KEY = "company";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        ButterKnife.bind(this);

        Intent intent = getIntent();
        Company company = (Company) intent.getSerializableExtra(COMPANY_KEY);

        DetailFragment detailFragment = DetailFragment.create(company);
        changeFragment(R.id.fl_detail, detailFragment, false);
    }

}
