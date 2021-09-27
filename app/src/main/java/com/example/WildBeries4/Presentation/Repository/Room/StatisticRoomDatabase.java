package com.example.WildBeries4.Presentation.Repository.Room;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

import com.example.WildBeries4.Domain.Model.Statistic;
import com.example.WildBeries4.Presentation.Repository.Room.DAO.StatisticDAO;
;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Database(entities = {Statistic.class}, version = 4, exportSchema = false)
abstract class StatisticRoomDatabase extends RoomDatabase {
     abstract StatisticDAO StatisticDao();

    private static volatile  StatisticRoomDatabase INSTANCE;
    private static final int NUMBER_OF_THREADS = 4;
    static final ExecutorService databaseWriteExecutor =
            Executors.newFixedThreadPool(NUMBER_OF_THREADS);

    static StatisticRoomDatabase getDatabase(final Context context) {
        if (INSTANCE == null) {
            synchronized (StatisticRoomDatabase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            StatisticRoomDatabase.class, "statistic_database").fallbackToDestructiveMigration()
                            .build();
                }
            }
        }
        return INSTANCE;
    }
    private static RoomDatabase.Callback sRoomDatabaseCallback = new RoomDatabase.Callback() {
        @Override
        public void onCreate(@NonNull SupportSQLiteDatabase db) {
            super.onCreate(db);

            databaseWriteExecutor.execute(() -> {
                StatisticDAO dao = INSTANCE.StatisticDao();
                dao.deleteAll();

                Statistic name = new Statistic("Water");
                dao.insert(name);

            });
        }
    };
}
