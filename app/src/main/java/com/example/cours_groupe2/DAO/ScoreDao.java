package com.example.cours_groupe2.DAO;

import android.content.ContentValues;
import android.database.Cursor;

import com.example.cours_groupe2.model.entities.Score;

public class ScoreDao extends BaseDao<Score> {
    public ScoreDao(DataBaseHelper helper) {
        super(helper);
    }

    public static String TABLE_NAME = "High_Score";
    public static String COLUMN_SCORE = "Premier_Element";
    public static String COLUMN_NOM = "Deuxieme_element";

    @Override
    protected String getTableName() {
        return TABLE_NAME;
    }

    @Override
    protected void putValues(ContentValues values, Score entity) {
        values.put(COLUMN_NOM,entity.getScore());
        values.put(COLUMN_SCORE,entity.getNom());
    }

    @Override
    protected Score getEntity(Cursor cursor) {
        Integer indexNom = cursor.getColumnIndex(COLUMN_NOM);
        Integer indexScore = cursor.getColumnIndex(COLUMN_SCORE);
        Score monScore = new Score();
        monScore.setScore(cursor.getInt(indexScore));
        monScore.setNom(cursor.getString(indexNom));
        return monScore;
    }

}
