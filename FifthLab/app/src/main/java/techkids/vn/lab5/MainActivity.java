package techkids.vn.lab5;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ListView;
import android.widget.ProgressBar;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.realm.RealmList;
import okhttp3.MediaType;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import techkids.vn.lab5.adapters.HairAdapter;
import techkids.vn.lab5.networks.DbContext;
import techkids.vn.lab5.networks.jsonmodel.HairResponseBody;
import techkids.vn.lab5.networks.jsonmodel.HairStyle;
import techkids.vn.lab5.networks.services.HairService;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.toString();

    @BindView(R.id.lv_hair_menu)
    ListView lvHairMenu;

    @BindView(R.id.pb_loading)
    ProgressBar pbLoading;

    private HairResponseBody hairResponseBody;
    private List<HairStyle> hairStyleList;
    private HairAdapter hairAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        new MyTask().execute();

        init();

//        getHairCollection();
    }

    private void init() {
        DbContext.init(this);
        hairStyleList = new RealmList<>();
        hairResponseBody = new HairResponseBody();
    }

    public void getHairCollection() {
        HairService hairService = DbContext.HAIR.create(HairService.class);

        RequestBody requestBody = RequestBody.create(
                MediaType.parse("application/json"),
                ""
        );

        Call<HairResponseBody> response = hairService.hairCollection(requestBody);

        response.enqueue(new Callback<HairResponseBody>() {
            @Override
            public void onResponse(Call<HairResponseBody> call, Response<HairResponseBody> response) {
                Log.d(TAG, "onResponse");
                hairResponseBody = response.body();
                Log.d(TAG, hairResponseBody.toString());

                for (int i = 0; i < hairResponseBody.getHairStyles().size(); i++) {
                    hairStyleList.add(hairResponseBody.getHairStyles().get(i));
                }

                DbContext.getInstance().deleteAll();
                for (HairStyle hairStyle : hairStyleList) {
                    DbContext.getInstance().insert(hairStyle);
                }

                Log.d(TAG, String.format("onResponse: %d", hairStyleList.size()));
                for (Object object : hairStyleList) {
                    Log.d(TAG, object.toString());
                }

                MainActivity.this.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        hairAdapter = new HairAdapter(MainActivity.this, R.layout.list_item_hair, hairStyleList);
                        lvHairMenu.setAdapter(hairAdapter);
                    }
                });
            }

            @Override
            public void onFailure(Call<HairResponseBody> call, Throwable t) {
                Log.d(TAG, "onFailure");
                hairStyleList = DbContext.getInstance().allHairs();
                for (Object object : hairStyleList) {
                    Log.d(TAG, object.toString());
                }
                Log.d(TAG, String.format("onFailure: %d", hairStyleList.size()));

                MainActivity.this.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        hairAdapter = new HairAdapter(MainActivity.this, R.layout.list_item_hair, hairStyleList);
                        lvHairMenu.setAdapter(hairAdapter);
                    }
                });
            }
        });
    }

    class MyTask extends AsyncTask<String, Integer, String> {

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            Log.d(TAG, "onPreExecute");
            lvHairMenu.setVisibility(View.INVISIBLE);
            pbLoading.setVisibility(View.VISIBLE);
        }

        @Override
        protected String doInBackground(String... params) {
            getHairCollection();
            Log.d(TAG, "doInBackground");
            return null;
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            Log.d(TAG, "onPostExecute");
            pbLoading.setVisibility(View.GONE);
            lvHairMenu.setVisibility(View.VISIBLE);
        }
    }

}
