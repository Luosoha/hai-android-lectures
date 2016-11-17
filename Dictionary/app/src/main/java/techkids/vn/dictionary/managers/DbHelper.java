package techkids.vn.dictionary.managers;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.nfc.Tag;
import android.util.Log;

import com.readystatesoftware.sqliteasset.SQLiteAssetHelper;

import java.util.ArrayList;
import java.util.List;

import techkids.vn.dictionary.models.Word;

/**
 * Created by Lush on 11/17/2016.
 */

public class DbHelper extends SQLiteAssetHelper {
    
    private static final String DB_NAME = "dictionary.db";
    private static final int DB_VERSION = 1;
    private static final String DICTIONARY_TABLE_NAME = "tbl_dictionary";

    //============================== Note constants ===============================

    private static final String DICTIONARY_ID_COLUMN = "id";
    private static final String DICTIONARY_ORIGINAL_WORD_COLUMN = "original_word";
    private static final String DICTIONARY_TRANSLATED_WORD_COLUMN = "translated_word";
    private static final String DICTIONARY_DATE_CREATED_COLUMN = "date_created";
    private static final String DICTIONARY_IS_FAVORITE_COLUMN = "is_favorite";

    private static final String[] DICTIONARY_COLUMN = {
            DICTIONARY_ID_COLUMN,
            DICTIONARY_ORIGINAL_WORD_COLUMN,
            DICTIONARY_TRANSLATED_WORD_COLUMN,
            DICTIONARY_DATE_CREATED_COLUMN,
            DICTIONARY_IS_FAVORITE_COLUMN
    };
    private static final String TAG = DbHelper.class.toString();

    //============================== Constructor and Singleton ===============================

    public DbHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    private static DbHelper instance;
    public static DbHelper getInstance() {
        return instance;
    }

    public static void init(Context context) {
        instance = new DbHelper(context);
    }

    //============================== Word ===============================

    public List<Word> suggestWords(String filter) {
        ArrayList<Word> wordList = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query(true, DICTIONARY_TABLE_NAME, DICTIONARY_COLUMN,
                DICTIONARY_ORIGINAL_WORD_COLUMN + " LIKE ?",
                new String[] { filter+"%" }, null, null, null,
                null);

        while (cursor.moveToNext()) {
            int id = cursor.getInt(cursor.getColumnIndex(DICTIONARY_ID_COLUMN));
            String originalWord = cursor.getString(cursor.getColumnIndex(DICTIONARY_ORIGINAL_WORD_COLUMN));
            String translatedWord = cursor.getString(cursor.getColumnIndex(DICTIONARY_TRANSLATED_WORD_COLUMN));
            String dateCreated = cursor.getString(cursor.getColumnIndex(DICTIONARY_DATE_CREATED_COLUMN));
            int isFavorite = cursor.getInt(cursor.getColumnIndex(DICTIONARY_IS_FAVORITE_COLUMN));

            Word word = new Word(id, originalWord, translatedWord, dateCreated, isFavorite);
            wordList.add(word);
        }

        db.close();
        return wordList;
    }

    public List<Word> selectFavorite() {
        ArrayList<Word> wordList = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query(DICTIONARY_TABLE_NAME, DICTIONARY_COLUMN,
                DICTIONARY_IS_FAVORITE_COLUMN + "=?",
                new String[]{"1"}, null, null, null, null);

        while (cursor.moveToNext()) {
            int id = cursor.getInt(cursor.getColumnIndex(DICTIONARY_ID_COLUMN));
            String originalWord = cursor.getString(cursor.getColumnIndex(DICTIONARY_ORIGINAL_WORD_COLUMN));
            String translatedWord = cursor.getString(cursor.getColumnIndex(DICTIONARY_TRANSLATED_WORD_COLUMN));
            String dateCreated = cursor.getString(cursor.getColumnIndex(DICTIONARY_DATE_CREATED_COLUMN));
            int isFavorite = cursor.getInt(cursor.getColumnIndex(DICTIONARY_IS_FAVORITE_COLUMN));

            Word word = new Word(id, originalWord, translatedWord, dateCreated, isFavorite);
            wordList.add(word);
        }

        db.close();
        return wordList;
    }

    public List<Word> selectAllWords() {
        ArrayList<Word> wordList = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query(DICTIONARY_TABLE_NAME, DICTIONARY_COLUMN, null, null, null, null, null);
        while (cursor.moveToNext()) {
            int id = cursor.getInt(cursor.getColumnIndex(DICTIONARY_ID_COLUMN));
            String originalWord = cursor.getString(cursor.getColumnIndex(DICTIONARY_ORIGINAL_WORD_COLUMN));
            String translatedWord = cursor.getString(cursor.getColumnIndex(DICTIONARY_TRANSLATED_WORD_COLUMN));
            String dateCreated = cursor.getString(cursor.getColumnIndex(DICTIONARY_DATE_CREATED_COLUMN));
            int isFavorite = cursor.getInt(cursor.getColumnIndex(DICTIONARY_IS_FAVORITE_COLUMN));

            Word word = new Word(id, originalWord, translatedWord, dateCreated, isFavorite);
            wordList.add(word);
        }

        db.close();
        return wordList;
    }

    public Word selectRandom() {
        Word word = null;
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor;
        String sql ="SELECT * FROM tbl_dictionary ORDER BY RANDOM() LIMIT 1";
        cursor = db.rawQuery(sql, null);

        if (cursor.moveToNext()) {
            int id = cursor.getInt(cursor.getColumnIndex(DICTIONARY_ID_COLUMN));
            String originalWord = cursor.getString(cursor.getColumnIndex(DICTIONARY_ORIGINAL_WORD_COLUMN));
            String translatedWord = cursor.getString(cursor.getColumnIndex(DICTIONARY_TRANSLATED_WORD_COLUMN));
            String dateCreated = cursor.getString(cursor.getColumnIndex(DICTIONARY_DATE_CREATED_COLUMN));
            int isFavorite = cursor.getInt(cursor.getColumnIndex(DICTIONARY_IS_FAVORITE_COLUMN));
            word = new Word(id, originalWord, translatedWord, dateCreated, isFavorite);
        }

        db.close();
        return word;
    }

    public void insert(Word word) {
        SQLiteDatabase db = this.getWritableDatabase();

        int id = (int) db.insert(DICTIONARY_TABLE_NAME, null, create(word));
        word.setId(id);

        db.close();
    }

    public void delete(Word word) {
        SQLiteDatabase db = this.getWritableDatabase();

        db.delete(DICTIONARY_TABLE_NAME, "id=?", args(word)); // ? = place holder

        db.close();
    }

    public void update(Word word) {
        SQLiteDatabase db = this.getWritableDatabase();

        db.update(DICTIONARY_TABLE_NAME, create(word), "id=?", args(word));

        db.close();
    }

    private ContentValues create(Word word) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(DICTIONARY_ORIGINAL_WORD_COLUMN, word.getOriginalWord());
        contentValues.put(DICTIONARY_TRANSLATED_WORD_COLUMN, word.getTranslatedWord());
        contentValues.put(DICTIONARY_DATE_CREATED_COLUMN, word.getDateCreated());
        contentValues.put(DICTIONARY_IS_FAVORITE_COLUMN, word.getIsFavorite());

        return contentValues;
    }

    private String[] args(Word word) {
        String[] args = new String[] {String.format("%s", word.getId())};
        return args;
    }
    
}
