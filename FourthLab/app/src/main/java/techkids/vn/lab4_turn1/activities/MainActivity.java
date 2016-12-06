package techkids.vn.lab4_turn1.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.google.gson.Gson;

import java.io.IOException;
import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import techkids.vn.lab4_turn1.R;
import techkids.vn.lab4_turn1.adapter.CompanyAdapter;
import techkids.vn.lab4_turn1.fragments.DetailFragment;
import techkids.vn.lab4_turn1.models.Company;
import techkids.vn.lab4_turn1.models.TechkidsConnectList;

public class MainActivity extends BaseActivity {

    private static final String TAG = MainActivity.class.toString();
    public final String COMPANY_API_URL = "https://a-server.herokuapp.com/api/company";

    @BindView(R.id.lv_company)
    ListView lvCompany;

    private ArrayList<Company> companies = new ArrayList<>();
    private CompanyAdapter companyArrayAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        sendGET();
        setupUI();
        addListeners();
    }

    private void setupUI() {
        companyArrayAdapter = new CompanyAdapter(
                this, R.layout.list_item_company, companies
        );
        lvCompany.setAdapter(companyArrayAdapter);
    }

    private void addListeners() {
        lvCompany.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Company company = companies.get(position);
                Log.d(TAG, String.format("%s", company.getName()));

                if (findViewById(R.id.fl_detail) == null) {
                    Intent intent = new Intent(MainActivity.this, DetailActivity.class);
                    intent.putExtra(DetailActivity.COMPANY_KEY, company);
                    startActivity(intent);
                } else {
                    DetailFragment detailFragment = DetailFragment.create(company);
                    changeFragment(R.id.fl_detail, detailFragment, true);
                }
            }
        });
    }

    private void sendGET() {
        OkHttpClient client = new OkHttpClient();

        Request request = new Request.Builder()
                .url(COMPANY_API_URL)
                .build();

        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                Log.d(TAG, "onFailure");
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String body = response.body().string();
                Log.d(TAG, body);

                Gson gson = new Gson();
                TechkidsConnectList techkidsConnectList = gson.fromJson(body, TechkidsConnectList.class);

//                companies.clear();
                ArrayList<Company> listCompany = techkidsConnectList.getCompanyList().getCompanies();
                for (int i = 0; i < techkidsConnectList.getCompanyList().getCompaniesSize(); i++) {
                    companies.add(listCompany.get(i));
                }

                Log.d(TAG, companies.get(1).getLogo());

                MainActivity.this.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        companyArrayAdapter.notifyDataSetChanged();
                    }
                });
            }
        });
    }

}
