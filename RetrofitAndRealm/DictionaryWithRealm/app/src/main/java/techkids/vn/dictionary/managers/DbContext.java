package techkids.vn.dictionary.managers;

import android.content.Context;

import java.util.ArrayList;
import java.util.List;

import io.realm.Realm;
import techkids.vn.dictionary.models.Word;

/**
 * Created by Lush on 12/9/2016.
 */

public class DbContext {
    private Realm realm;

    private DbContext() {
        realm = Realm.getDefaultInstance();
    }

    public void insert(Word word) {
        realm.beginTransaction();
        realm.copyToRealm(word);
        realm.commitTransaction();
    }

    public List<Word> allWords() {
        return realm.where(Word.class).findAll();
    }

    public void update(Word word, String originalWord, String translatedWord) {
        realm.beginTransaction();
        word.setOriginalWord(originalWord);
        word.setTranslatedWord(translatedWord);
        realm.commitTransaction();
    }

    public void delete(Word word) {
        realm.beginTransaction();
        word.deleteFromRealm();
        realm.commitTransaction();
    }

    public List<Word> listSuggestedWords(String filter) {
        List<Word> wordList = allWords();
        ArrayList<Word> res = new ArrayList<>();
        int length = filter.length();
        boolean isSimilar = true;

        for (Word word : wordList) {
            for (int i = 0; i < length; i++) {
                if (word.getOriginalWord().length() < filter.length()) {
                    isSimilar = false;
                    break;
                } else {
                    if (word.getOriginalWord().charAt(i) != filter.charAt(i)) {
                        isSimilar = false;
                    }
                }
            }
            if (isSimilar && word != null) {
                res.add(word);
            }
            isSimilar = true;
        }

        return res;
    }

    private static DbContext instance;

    public static DbContext getInstance() {
        return instance;
    }

    public static void init(Context context) {
        Realm.init(context);
        instance = new DbContext();
    }
}
