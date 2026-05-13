package com.example.kreedaankana.data.local;

import android.database.Cursor;
import androidx.annotation.NonNull;
import androidx.room.CoroutinesRoom;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import java.lang.Class;
import java.lang.Exception;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;
import javax.annotation.processing.Generated;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.flow.Flow;

@Generated("androidx.room.RoomProcessor")
@SuppressWarnings({"unchecked", "deprecation"})
public final class ScoreDao_Impl implements ScoreDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<ScoreEntity> __insertionAdapterOfScoreEntity;

  public ScoreDao_Impl(@NonNull final RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfScoreEntity = new EntityInsertionAdapter<ScoreEntity>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "INSERT OR REPLACE INTO `score_entries` (`id`,`sport`,`teamA`,`teamB`,`scoreA`,`scoreB`,`ground`,`dateLabel`,`createdAt`) VALUES (?,?,?,?,?,?,?,?,?)";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          @NonNull final ScoreEntity entity) {
        if (entity.getId() == null) {
          statement.bindNull(1);
        } else {
          statement.bindString(1, entity.getId());
        }
        if (entity.getSport() == null) {
          statement.bindNull(2);
        } else {
          statement.bindString(2, entity.getSport());
        }
        if (entity.getTeamA() == null) {
          statement.bindNull(3);
        } else {
          statement.bindString(3, entity.getTeamA());
        }
        if (entity.getTeamB() == null) {
          statement.bindNull(4);
        } else {
          statement.bindString(4, entity.getTeamB());
        }
        statement.bindLong(5, entity.getScoreA());
        statement.bindLong(6, entity.getScoreB());
        if (entity.getGround() == null) {
          statement.bindNull(7);
        } else {
          statement.bindString(7, entity.getGround());
        }
        if (entity.getDateLabel() == null) {
          statement.bindNull(8);
        } else {
          statement.bindString(8, entity.getDateLabel());
        }
        statement.bindLong(9, entity.getCreatedAt());
      }
    };
  }

  @Override
  public Object upsert(final ScoreEntity score, final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __insertionAdapterOfScoreEntity.insert(score);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, $completion);
  }

  @Override
  public Object upsertAll(final List<ScoreEntity> scores,
      final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __insertionAdapterOfScoreEntity.insert(scores);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, $completion);
  }

  @Override
  public Flow<List<ScoreEntity>> observeScores() {
    final String _sql = "SELECT * FROM score_entries ORDER BY createdAt DESC";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return CoroutinesRoom.createFlow(__db, false, new String[] {"score_entries"}, new Callable<List<ScoreEntity>>() {
      @Override
      @NonNull
      public List<ScoreEntity> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfSport = CursorUtil.getColumnIndexOrThrow(_cursor, "sport");
          final int _cursorIndexOfTeamA = CursorUtil.getColumnIndexOrThrow(_cursor, "teamA");
          final int _cursorIndexOfTeamB = CursorUtil.getColumnIndexOrThrow(_cursor, "teamB");
          final int _cursorIndexOfScoreA = CursorUtil.getColumnIndexOrThrow(_cursor, "scoreA");
          final int _cursorIndexOfScoreB = CursorUtil.getColumnIndexOrThrow(_cursor, "scoreB");
          final int _cursorIndexOfGround = CursorUtil.getColumnIndexOrThrow(_cursor, "ground");
          final int _cursorIndexOfDateLabel = CursorUtil.getColumnIndexOrThrow(_cursor, "dateLabel");
          final int _cursorIndexOfCreatedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "createdAt");
          final List<ScoreEntity> _result = new ArrayList<ScoreEntity>(_cursor.getCount());
          while (_cursor.moveToNext()) {
            final ScoreEntity _item;
            final String _tmpId;
            if (_cursor.isNull(_cursorIndexOfId)) {
              _tmpId = null;
            } else {
              _tmpId = _cursor.getString(_cursorIndexOfId);
            }
            final String _tmpSport;
            if (_cursor.isNull(_cursorIndexOfSport)) {
              _tmpSport = null;
            } else {
              _tmpSport = _cursor.getString(_cursorIndexOfSport);
            }
            final String _tmpTeamA;
            if (_cursor.isNull(_cursorIndexOfTeamA)) {
              _tmpTeamA = null;
            } else {
              _tmpTeamA = _cursor.getString(_cursorIndexOfTeamA);
            }
            final String _tmpTeamB;
            if (_cursor.isNull(_cursorIndexOfTeamB)) {
              _tmpTeamB = null;
            } else {
              _tmpTeamB = _cursor.getString(_cursorIndexOfTeamB);
            }
            final int _tmpScoreA;
            _tmpScoreA = _cursor.getInt(_cursorIndexOfScoreA);
            final int _tmpScoreB;
            _tmpScoreB = _cursor.getInt(_cursorIndexOfScoreB);
            final String _tmpGround;
            if (_cursor.isNull(_cursorIndexOfGround)) {
              _tmpGround = null;
            } else {
              _tmpGround = _cursor.getString(_cursorIndexOfGround);
            }
            final String _tmpDateLabel;
            if (_cursor.isNull(_cursorIndexOfDateLabel)) {
              _tmpDateLabel = null;
            } else {
              _tmpDateLabel = _cursor.getString(_cursorIndexOfDateLabel);
            }
            final long _tmpCreatedAt;
            _tmpCreatedAt = _cursor.getLong(_cursorIndexOfCreatedAt);
            _item = new ScoreEntity(_tmpId,_tmpSport,_tmpTeamA,_tmpTeamB,_tmpScoreA,_tmpScoreB,_tmpGround,_tmpDateLabel,_tmpCreatedAt);
            _result.add(_item);
          }
          return _result;
        } finally {
          _cursor.close();
        }
      }

      @Override
      protected void finalize() {
        _statement.release();
      }
    });
  }

  @NonNull
  public static List<Class<?>> getRequiredConverters() {
    return Collections.emptyList();
  }
}
