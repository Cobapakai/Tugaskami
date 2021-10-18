package com.example.tugaskami;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.Locale;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(
        mv = {1, 5, 1},
        k = 1,
        d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0014\n\u0002\b\f\u0018\u0000 )2\u00020\u0001:\u0001)B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0015\u001a\u00020\u00062\u0006\u0010\u0016\u001a\u00020\u000eH\u0002J%\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001eH\u0000¢\u0006\u0002\b\u001fJ\b\u0010 \u001a\u00020\u0006H\u0002J\b\u0010!\u001a\u00020\u0018H\u0002J\b\u0010\"\u001a\u00020\u0018H\u0002J%\u0010#\u001a\u00020\u00182\u0006\u0010$\u001a\u00020\u001a2\u0006\u0010%\u001a\u00020\u000e2\u0006\u0010&\u001a\u00020\u000eH\u0000¢\u0006\u0002\b'J\b\u0010(\u001a\u00020\u0018H\u0002R\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0012\u001a\n \u0014*\u0004\u0018\u00010\u00130\u0013X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006*"},
        d2 = {"Laltermarkive/guardian/Data;", "", "guardian", "Laltermarkive/guardian/Guardian;", "(Laltermarkive/guardian/Guardian;)V", "db", "Landroid/database/sqlite/SQLiteDatabase;", "getDb", "()Landroid/database/sqlite/SQLiteDatabase;", "setDb", "(Landroid/database/sqlite/SQLiteDatabase;)V", "getGuardian", "()Laltermarkive/guardian/Guardian;", "last", "", "queue", "Ljava/util/concurrent/ConcurrentLinkedQueue;", "Laltermarkive/guardian/Batch;", "root", "Ljava/io/File;", "kotlin.jvm.PlatformType", "advance", "current", "dispatch", "", "type", "", "timestamp", "", "values", "", "dispatch$Fall_Detector_fall_detector", "find", "flush", "initiate", "log", "priority", "tag", "entry", "log$Fall_Detector_fall_detector", "sweep", "Companion", "Fall_Detector.fall-detector"}
)
public final class Data {
    private final File root;
    private String last;
    @Nullable
    private SQLiteDatabase db;
    private final ConcurrentLinkedQueue queue;
    @NotNull
    private final Guardian guardian;
    private static final SimpleDateFormat FORMAT;
    @NotNull
    public static final Data.Companion Companion = new Data.Companion((DefaultConstructorMarker)null);

    @Nullable
    public final SQLiteDatabase getDb() {
        return this.db;
    }

    public final void setDb(@Nullable SQLiteDatabase var1) {
        this.db = var1;
    }

    private final void initiate() {
        new Upload();
        ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(2);
        scheduler.scheduleAtFixedRate((Runnable)(new Runnable() {
            public final void run() {
                Data.this.sweep();
            }
        }), 0L, 1L, TimeUnit.HOURS);
        scheduler.scheduleAtFixedRate((Runnable)(new Runnable() {
            public final void run() {
                altermarkive.guardian.Upload.Companion var10000 = Upload.Companion;
                Context var10001 = Data.this.getGuardian().getApplicationContext();
                Intrinsics.checkNotNullExpressionValue(var10001, "guardian.applicationContext");
                File var10002 = Data.this.root;
                Intrinsics.checkNotNullExpressionValue(var10002, "root");
                String var1 = var10002.getPath();
                Intrinsics.checkNotNullExpressionValue(var1, "root.path");
                var10000.go$Fall_Detector_fall_detector(var10001, var1);
            }
        }), 0L, 1L, TimeUnit.HOURS);
        ExecutorService infinite = Executors.newSingleThreadExecutor();
        infinite.execute((Runnable)(new Runnable() {
            public final void run() {
                Data.this.flush();
            }
        }));
    }

    public final void dispatch$Fall_Detector_fall_detector(int type, long timestamp, @NotNull float[] values) {
        Intrinsics.checkNotNullParameter(values, "values");
        ContentValues content = new ContentValues();
        content.put("stamp", System.currentTimeMillis());
        content.put("timestamp", timestamp);
        content.put("type", type);
        int i = 0;

        for(byte var7 = 5; i <= var7; ++i) {
            String column = "value" + i;
            if (i < values.length) {
                content.put(column, values[i]);
            } else {
                content.putNull(column);
            }
        }

        this.queue.add(new Batch("data", content));
    }

    public final void log$Fall_Detector_fall_detector(int priority, @NotNull String tag, @NotNull String entry) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        Intrinsics.checkNotNullParameter(entry, "entry");
        ContentValues content = new ContentValues();
        content.put("stamp", System.currentTimeMillis());
        content.put("priority", priority);
        content.put("tag", tag);
        content.put("entry", entry);
        this.queue.add(new Batch("logs", content));
    }

    private final void flush() {
        while(true) {
            while(this.queue.peek() != null) {
                SQLiteDatabase db = this.find();
                Batch entry = (Batch)this.queue.poll();
                if (entry == null) {
                    break;
                }

                db.insert(entry.getTable$Fall_Detector_fall_detector(), (String)null, entry.getContent$Fall_Detector_fall_detector());
            }

            Thread.sleep(1000L);
        }
    }

    private final void sweep() {
        Storage var10000 = Storage.INSTANCE;
        File var10001 = this.root;
        Intrinsics.checkNotNullExpressionValue(var10001, "root");
        String var16 = var10001.getPath();
        Intrinsics.checkNotNullExpressionValue(var16, "root.path");
        String[] unzipped = var10000.list$Fall_Detector_fall_detector(var16, Storage.INSTANCE.getFILTER_SQLITE$Fall_Detector_fall_detector());
        boolean var5;
        int var12;
        if (unzipped != null) {
            boolean var3 = false;
            var5 = false;
            if (unzipped.length != 0) {
                Arrays.sort(unzipped);
                String[] var4 = unzipped;
                var12 = unzipped.length;

                for(int var9 = 0; var9 < var12; ++var9) {
                    String file = var4[var9];
                    SQLiteDatabase db = this.db;
                    if (db != null) {
                        String var15 = db.getPath();
                        Intrinsics.checkNotNullExpressionValue(var15, "db.path");
                        if (StringsKt.endsWith$default(var15, file, false, 2, (Object)null)) {
                            continue;
                        }
                    }

                    var10000 = Storage.INSTANCE;
                    var10001 = this.root;
                    Intrinsics.checkNotNullExpressionValue(var10001, "root");
                    var16 = var10001.getPath();
                    Intrinsics.checkNotNullExpressionValue(var16, "root.path");
                    if (var10000.zip$Fall_Detector_fall_detector(var16, file)) {
                        var10000 = Storage.INSTANCE;
                        var10001 = this.root;
                        Intrinsics.checkNotNullExpressionValue(var10001, "root");
                        var16 = var10001.getPath();
                        Intrinsics.checkNotNullExpressionValue(var16, "root.path");
                        var10000.delete$Fall_Detector_fall_detector(var16, file);
                        var10000 = Storage.INSTANCE;
                        var10001 = this.root;
                        Intrinsics.checkNotNullExpressionValue(var10001, "root");
                        var16 = var10001.getPath();
                        Intrinsics.checkNotNullExpressionValue(var16, "root.path");
                        var10000.delete$Fall_Detector_fall_detector(var16, file + "-journal");
                    }
                }
            }
        }

        int week = 604800000;
        var10000 = Storage.INSTANCE;
        var10001 = this.root;
        Intrinsics.checkNotNullExpressionValue(var10001, "root");
        var16 = var10001.getPath();
        Intrinsics.checkNotNullExpressionValue(var16, "root.path");
        String[] zipped = var10000.list$Fall_Detector_fall_detector(var16, Storage.INSTANCE.getFILTER_ZIP$Fall_Detector_fall_detector());
        if (zipped != null) {
            var5 = false;
            boolean var7 = false;
            if (zipped.length != 0) {
                Arrays.sort(zipped);
                String[] var13 = zipped;
                int var14 = zipped.length;

                for(var12 = 0; var12 < var14; ++var12) {
                    String file = var13[var12];
                    var10000 = Storage.INSTANCE;
                    var10001 = this.root;
                    Intrinsics.checkNotNullExpressionValue(var10001, "root");
                    var16 = var10001.getPath();
                    Intrinsics.checkNotNullExpressionValue(var16, "root.path");
                    if (var10000.age$Fall_Detector_fall_detector(var16, file) + (long)week < System.currentTimeMillis()) {
                        var10000 = Storage.INSTANCE;
                        var10001 = this.root;
                        Intrinsics.checkNotNullExpressionValue(var10001, "root");
                        var16 = var10001.getPath();
                        Intrinsics.checkNotNullExpressionValue(var16, "root.path");
                        var10000.delete$Fall_Detector_fall_detector(var16, file);
                    }
                }
            }
        }

    }

    private final SQLiteDatabase advance(String current) {
        SQLiteDatabase var10000 = this.db;
        if (var10000 != null) {
            var10000.close();
        }

        this.last = current;
        StringBuilder var4 = new StringBuilder();
        File var10001 = this.root;
        Intrinsics.checkNotNullExpressionValue(var10001, "root");
        String name = var4.append(var10001.getPath()).append(File.separator).append(current).append(".sqlite3").toString();
        SQLiteDatabase db = SQLiteDatabase.openOrCreateDatabase(name, (CursorFactory)null);
        db.execSQL("CREATE TABLE IF NOT EXISTS data(stamp INTEGER, timestamp INTEGER, type INTEGER, value0 REAL, value1 REAL, value2 REAL, value3 REAL, value4 REAL, value5 REAL);");
        db.execSQL("CREATE TABLE IF NOT EXISTS logs(stamp INTEGER, priority INTEGER, tag VARCHAR, entry VARCHAR);");
        this.db = db;
        Intrinsics.checkNotNullExpressionValue(db, "db");
        return db;
    }

    private final SQLiteDatabase find() {
        String current = FORMAT.format(new Date(System.currentTimeMillis()));
        SQLiteDatabase db = this.db;
        SQLiteDatabase var10000;
        if (!(Intrinsics.areEqual(current, this.last) ^ true) && db != null) {
            var10000 = db;
        } else {
            Intrinsics.checkNotNullExpressionValue(current, "current");
            var10000 = this.advance(current);
        }

        return var10000;
    }

    @NotNull
    public final Guardian getGuardian() {
        return this.guardian;
    }

    public Data(@NotNull Guardian guardian) {
        Intrinsics.checkNotNullParameter(guardian, "guardian");
        super();
        this.guardian = guardian;
        Context var10001 = this.guardian.getApplicationContext();
        Intrinsics.checkNotNullExpressionValue(var10001, "guardian.applicationContext");
        this.root = var10001.getFilesDir();
        this.queue = new ConcurrentLinkedQueue();
        this.initiate();
    }

    static {
        FORMAT = new SimpleDateFormat("yyyy-MM-dd", Locale.US);
    }

    @Metadata(
            mv = {1, 5, 1},
            k = 1,
            d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0005"},
            d2 = {"Laltermarkive/guardian/Data$Companion;", "", "()V", "FORMAT", "Ljava/text/SimpleDateFormat;", "Fall_Detector.fall-detector"}
    )
    public static final class Companion {
        private Companion() {
        }

        // $FF: synthetic method
        public Companion(DefaultConstructorMarker $constructor_marker) {
            this();
        }
    }
}

