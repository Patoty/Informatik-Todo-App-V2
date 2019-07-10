package com.ruperti.todo_app_v2;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.ruperti.todo_app_v2.Task;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class TaskDatabase extends SQLiteOpenHelper {
    public static TaskDatabase INSTANCE = null;

    private static final String DB_NAME    = "TaskS";
    private static final int    VERSION    = 12;
    private static final String TABLE_NAME = "Tasks";

    public static final String ID_COLUMN          = "ID";
    public static final String NAME_COLUMN        = "name";
    public static final String IS_DONE_COLUMN     = "isDone";
    public static final String DUEDATE_COLUMN     = "dueDate";
    public static final String IMPORTANCE_COLUMN   = "importance";
    public static final String DURATION_COLUMN = "duration";
    public static final String PRIORITY_COLUMN    = "priority";
    public static final String URGENCY_COLUMN   = "urgency";

    private TaskDatabase(final Context context) {
        super(context, DB_NAME, null, VERSION);
    }

    public static TaskDatabase getInstance(final Context context) {
        if (INSTANCE == null) {
            INSTANCE = new TaskDatabase(context);
        }

        return INSTANCE;
    }

    @Override
    public void onCreate(final SQLiteDatabase sqLiteDatabase) {
        String createQuery = "CREATE TABLE " + TABLE_NAME + " (" + ID_COLUMN + " INTEGER PRIMARY KEY, " + NAME_COLUMN + " TEXT NOT NULL, " + IS_DONE_COLUMN + " BOOLEAN DEFAULT NULL, " + DUEDATE_COLUMN + " INTEGER DEFAULT NULL, " + IMPORTANCE_COLUMN + " INTEGER DEFAULT 0, "  + DURATION_COLUMN + " INTEGER DEFAULT NULL, " + PRIORITY_COLUMN + " INTEGER DEFAULT 0, " + URGENCY_COLUMN + " INTEGER DEFAULT 0)";

        sqLiteDatabase.execSQL(createQuery);
    }

    @Override
    public void onUpgrade(final SQLiteDatabase sqLiteDatabase, final int i, final int i1) {
        String dropTable = "DROP TABLE IF EXISTS " + TABLE_NAME;
        sqLiteDatabase.execSQL(dropTable);

        onCreate(sqLiteDatabase);
    }

    public Task createTask(final Task Task) {
        SQLiteDatabase database = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(NAME_COLUMN, Task.getTaskName());
        values.put(IS_DONE_COLUMN, Task.isDone());
        values.put(DUEDATE_COLUMN, Integer.valueOf(Task.getDueDate().toString()));
        values.put(IMPORTANCE_COLUMN, Task.getImportance());
        values.put(DURATION_COLUMN, Task.getDuration());
        values.put(PRIORITY_COLUMN, Task.getPriority());
        values.put(URGENCY_COLUMN, Task.getUrgency());

        long newID = database.insert(TABLE_NAME, null, values);

        database.close();

        return readTask(newID);

    }

    public Task readTask(final long id) {
        SQLiteDatabase database = this.getReadableDatabase();
        Cursor cursor = database.query(TABLE_NAME, new String[]{ID_COLUMN, NAME_COLUMN, DUEDATE_COLUMN, IMPORTANCE_COLUMN, DURATION_COLUMN, PRIORITY_COLUMN, URGENCY_COLUMN}, ID_COLUMN + " = ?", new String[]{String.valueOf(id)}, null, null, null);

        Task Task = null;

        if (cursor != null && cursor.getCount() > 0) {
            cursor.moveToFirst();
            Task = new Task(cursor.getString(cursor.getColumnIndex(NAME_COLUMN)));
            Task.setId(cursor.getInt(cursor.getColumnIndex(ID_COLUMN)));
            Task.setImportance(cursor.getInt(cursor.getColumnIndex(IMPORTANCE_COLUMN)));
            Task.setDuration(cursor.getInt(cursor.getColumnIndex(DURATION_COLUMN)));
            Task.setDueDate(new Date(cursor.getString(cursor.getColumnIndex(DUEDATE_COLUMN))));
            Task.setUrgency(cursor.getInt(cursor.getColumnIndex(URGENCY_COLUMN)));
        }

        database.close();

        return Task;
    }

    public List<Task> readAllTasks() {
        List<Task> Tasks = new ArrayList<>();
        SQLiteDatabase database = this.getReadableDatabase();

        Cursor cursor = database.rawQuery("SELECT * FROM " + TABLE_NAME, null);

        if (cursor.moveToFirst()) {
            do {
                Task Task = readTask(cursor.getLong(cursor.getColumnIndex(ID_COLUMN)));
                if (Task != null) {
                    Tasks.add(Task);
                }
            } while (cursor.moveToNext());
        }

        database.close();

        return Tasks;
    }

    public Task updateTask(final Task Task) {
        SQLiteDatabase database = this.getReadableDatabase();

        ContentValues values = new ContentValues();

        values.put(NAME_COLUMN, Task.getTaskName());
        values.put(DUEDATE_COLUMN, Integer.valueOf(Task.getDueDate().toString()));
        values.put(IMPORTANCE_COLUMN, Task.getImportance());
        values.put(PRIORITY_COLUMN, Task.getPriority());
        values.put(URGENCY_COLUMN, Task.getUrgency());

        database.update(TABLE_NAME, values, ID_COLUMN + " = ?", new String[]{String.valueOf(Task.getId())});


        database.close();

        return this.readTask(Task.getId());
    }

    public void deleteTask(final Task Task) {
        SQLiteDatabase database = this.getWritableDatabase();
        database.delete(TABLE_NAME, ID_COLUMN + " = ?", new String[]{String.valueOf(Task.getId())});
        database.close();
    }

    public void deleteAllTasks() {
        SQLiteDatabase database = this.getWritableDatabase();
        database.execSQL("DELETE FROM " + TABLE_NAME);
        database.close();
    }

    public Cursor getAllTasksAsCursor() {
        return this.getReadableDatabase().rawQuery("SELECT " + ID_COLUMN + " as _id, " + NAME_COLUMN + "," + DUEDATE_COLUMN + " FROM " + TABLE_NAME, null);
    }

    public Task getFirstTask() {
        List<Task> Tasks = this.readAllTasks();

        if (Tasks.size() > 0) {
            return Tasks.get(0);
        }

        return null;
    }
}
