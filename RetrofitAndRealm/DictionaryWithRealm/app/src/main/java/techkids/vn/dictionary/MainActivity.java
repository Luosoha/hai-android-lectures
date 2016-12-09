package techkids.vn.dictionary;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.SearchView;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import techkids.vn.dictionary.managers.DbContext;
import techkids.vn.dictionary.managers.DbHelper;
import techkids.vn.dictionary.models.Word;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.toString();

    private ArrayAdapter<String> wordArrayAdapter;

    private SearchView svWord;
    private ListView lvSuggestWords;

    private DbHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.d(TAG, "onCreate");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        DbContext.init(this);

        getReferences();
        this.dbHelper = DbHelper.getInstance();
        addListeners();

        Log.d(TAG, "--------------------");
        for (Word word : DbContext.getInstance().allWords()) {
            Log.d(TAG, word.getOriginalWord());
        }
        Log.d(TAG, "--------------------");

//        insertWord();

//        deleteWord();

//        updateWord();

//        selectAllWords();

//        selectRandomWords();

//        suggestWord("B");

//        selectFavorite();
    }

    private void getReferences() {
        svWord = (SearchView) findViewById(R.id.sv_word);
        lvSuggestWords = (ListView) findViewById(R.id.lv_suggest_words);
    }

    private void addListeners() {
        svWord.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                Log.d(TAG, "onQueryTextSubmit");

                Intent intent = new Intent(MainActivity.this, DetailActivity.class);
                List<Word> wordList = dbHelper.selectAllWords();
                for (Word word : wordList) {
                    if (word.getOriginalWord().equalsIgnoreCase(query)) {
                        Log.d(TAG, word.getOriginalWord() + " - " + query + " - " + word.getTranslatedWord());
                        intent.putExtra(DetailActivity.ORIGINAL_WORD_KEY, query);
                        intent.putExtra(DetailActivity.TRANSLATED_WORD_KEY, word.getTranslatedWord());
                        intent.putExtra(DetailActivity.FAVORITE_WORD_KEY, word.getIsFavorite());
                        startActivity(intent);
                        break;
                    }
                }

                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                if (newText.length() != 0) {

//                    List<Word> wordList = dbHelper.suggestWords(newText);
                    List<Word> wordList = DbContext.getInstance().listSuggestedWords(newText);
                    List<String> res = new ArrayList<String>();

                    if (wordList != null) {
                        for (int i = 0; i < wordList.size(); i++) {
                            res.add(wordList.get(i).getOriginalWord());
                        }
                    }

                    wordArrayAdapter = new ArrayAdapter<String>(
                            MainActivity.this, android.R.layout.simple_list_item_1, res
                    );


                    if (wordArrayAdapter != null) {
                        lvSuggestWords.setAdapter(wordArrayAdapter);
                    }

                }

                else {
                    lvSuggestWords.setAdapter(null);
                }

                return false;
            }
        });
    }

}
