package com.example.tugaskami;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import java.io.File;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(
        mv = {1, 5, 1},
        k = 1,
        d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \t2\u00020\u0001:\u0001\tB\u0005¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016¨\u0006\n"},
        d2 = {"Laltermarkive/guardian/Connectivity;", "Landroid/content/BroadcastReceiver;", "()V", "onReceive", "", "context", "Landroid/content/Context;", "intent", "Landroid/content/Intent;", "Companion", "Fall_Detector.fall-detector"}
)
public final class Connectivity extends BroadcastReceiver {
    private static final String TAG = Connectivity.class.getName();
    @NotNull
    public static final Connectivity.Companion Companion = new Connectivity.Companion((DefaultConstructorMarker)null);

    public void onReceive(@NotNull Context context, @NotNull Intent intent) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(intent, "intent");
        if (Intrinsics.areEqual("android.net.conn.CONNECTIVITY_CHANGE", intent.getAction())) {
            Object var10000 = context.getSystemService("connectivity");
            if (var10000 == null) {
                throw new NullPointerException("null cannot be cast to non-null type android.net.ConnectivityManager");
            }

            ConnectivityManager manager = (ConnectivityManager)var10000;
            NetworkInfo info = manager.getActiveNetworkInfo();
            if (info != null && info.isConnected()) {
                Log var5 = Log.INSTANCE;
                String var10001 = TAG;
                Intrinsics.checkNotNullExpressionValue(var10001, "TAG");
                var5.i(var10001, "Detected internet connectivity");
                altermarkive.guardian.Upload.Companion var6 = Upload.Companion;
                Context var7 = context.getApplicationContext();
                Intrinsics.checkNotNullExpressionValue(var7, "context.applicationContext");
                Context var10002 = context.getApplicationContext();
                Intrinsics.checkNotNullExpressionValue(var10002, "context.applicationContext");
                File var8 = var10002.getFilesDir();
                Intrinsics.checkNotNullExpressionValue(var8, "context.applicationContext.filesDir");
                String var9 = var8.getPath();
                Intrinsics.checkNotNullExpressionValue(var9, "context.applicationContext.filesDir.path");
                var6.go$Fall_Detector_fall_detector(var7, var9);
            }
        }

    }

    @Metadata(
            mv = {1, 5, 1},
            k = 1,
            d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0016\u0010\u0003\u001a\n \u0005*\u0004\u0018\u00010\u00040\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0006"},
            d2 = {"Laltermarkive/guardian/Connectivity$Companion;", "", "()V", "TAG", "", "kotlin.jvm.PlatformType", "Fall_Detector.fall-detector"}
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

