package techkids.vn.lab2_turn4;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.Arrays;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.lv_news_menu)
    ListView lvNewsMenu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);
        setupUI();
    }

    private void setupUI() {
        lvNewsMenu.setAdapter(new NewsAdapter(
                this, R.layout.listview_item_news, Arrays.asList(NewsItem.ARRAY)
        ));
    }
}
