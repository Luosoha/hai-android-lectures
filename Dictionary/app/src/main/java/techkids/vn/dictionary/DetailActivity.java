package techkids.vn.dictionary;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class DetailActivity extends AppCompatActivity {

    private static final String TAG = DetailActivity.class.toString();

    public final static String ORIGINAL_WORD_KEY = "original_word";
    public final static String TRANSLATED_WORD_KEY = "translated_word";
    public final static String FAVORITE_WORD_KEY = "is_favorite";

    private TextView tvOriginalWord;
    private TextView tvTranslatedWord;
    private ImageView ivHeart;
    private int favorite;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        getReferences();

        Intent intent = getIntent();
        String originalWord = intent.getStringExtra(ORIGINAL_WORD_KEY);
        String translatedWord = intent.getStringExtra(TRANSLATED_WORD_KEY);
        favorite = intent.getIntExtra(FAVORITE_WORD_KEY, -1);

        tvOriginalWord.setText(originalWord);
        tvTranslatedWord.setText(translatedWord);
        if (favorite == 1) {
            ivHeart.setImageResource(R.drawable.favorite_heart);
        }
        else {
            ivHeart.setImageResource(R.drawable.not_favorite);
        }

        addListeners();

        Log.d(TAG, originalWord + " - " + translatedWord);
    }

    private void getReferences() {
        tvOriginalWord = (TextView) findViewById(R.id.tv_original_word);
        tvTranslatedWord = (TextView) findViewById(R.id.tv_translated_word);
        ivHeart = (ImageView) findViewById(R.id.iv_heart);
    }

    private void addListeners() {
        ivHeart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (favorite == 1) {
                    ivHeart.setImageResource(R.drawable.not_favorite);
                    favorite = 0;
                }
                else {
                    ivHeart.setImageResource(R.drawable.favorite_heart);
                    favorite = 1;
                }
            }
        });
    }
}
