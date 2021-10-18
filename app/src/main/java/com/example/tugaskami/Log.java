package com.example.tugaskami;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(
        mv = {1, 5, 1},
        k = 1,
        d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006J\u0016\u0010\b\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006J\u0016\u0010\t\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006J\u001e\u0010\n\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006J\u0016\u0010\r\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006J\u0016\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006¨\u0006\u000f"},
        d2 = {"Laltermarkive/guardian/Log;", "", "()V", "d", "", "tag", "", "entry", "e", "i", "println", "level", "", "v", "w", "Fall_Detector.fall-detector"}
)
public final class Log {
    @NotNull
    public static final Log INSTANCE;

    public final void println(int level, @NotNull String tag, @NotNull String entry) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        Intrinsics.checkNotNullParameter(entry, "entry");
        android.util.Log.println(level, tag, entry);
        Sampler var10000 = Sampler.Companion.getInstance$Fall_Detector_fall_detector();
        if (var10000 != null) {
            Data var4 = var10000.data();
            if (var4 != null) {
                var4.log$Fall_Detector_fall_detector(level, tag, entry);
            }
        }

    }

    public final void v(@NotNull String tag, @NotNull String entry) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        Intrinsics.checkNotNullParameter(entry, "entry");
        android.util.Log.v(tag, entry);
        Sampler var10000 = Sampler.Companion.getInstance$Fall_Detector_fall_detector();
        if (var10000 != null) {
            Data var3 = var10000.data();
            if (var3 != null) {
                var3.log$Fall_Detector_fall_detector(2, tag, entry);
            }
        }

    }

    public final void d(@NotNull String tag, @NotNull String entry) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        Intrinsics.checkNotNullParameter(entry, "entry");
        android.util.Log.d(tag, entry);
        Sampler var10000 = Sampler.Companion.getInstance$Fall_Detector_fall_detector();
        if (var10000 != null) {
            Data var3 = var10000.data();
            if (var3 != null) {
                var3.log$Fall_Detector_fall_detector(3, tag, entry);
            }
        }

    }

    public final void i(@NotNull String tag, @NotNull String entry) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        Intrinsics.checkNotNullParameter(entry, "entry");
        android.util.Log.i(tag, entry);
        Sampler var10000 = Sampler.Companion.getInstance$Fall_Detector_fall_detector();
        if (var10000 != null) {
            Data var3 = var10000.data();
            if (var3 != null) {
                var3.log$Fall_Detector_fall_detector(4, tag, entry);
            }
        }

    }

    public final void w(@NotNull String tag, @NotNull String entry) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        Intrinsics.checkNotNullParameter(entry, "entry");
        android.util.Log.w(tag, entry);
        Sampler var10000 = Sampler.Companion.getInstance$Fall_Detector_fall_detector();
        if (var10000 != null) {
            Data var3 = var10000.data();
            if (var3 != null) {
                var3.log$Fall_Detector_fall_detector(5, tag, entry);
            }
        }

    }

    public final void e(@NotNull String tag, @NotNull String entry) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        Intrinsics.checkNotNullParameter(entry, "entry");
        android.util.Log.e(tag, entry);
        Sampler var10000 = Sampler.Companion.getInstance$Fall_Detector_fall_detector();
        if (var10000 != null) {
            Data var3 = var10000.data();
            if (var3 != null) {
                var3.log$Fall_Detector_fall_detector(6, tag, entry);
            }
        }

    }

    private Log() {
    }

    static {
        Log var0 = new Log();
        INSTANCE = var0;
    }
}

