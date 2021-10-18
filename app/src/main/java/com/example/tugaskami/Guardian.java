package com.example.tugaskami;

import android.annotation.SuppressLint;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.os.Build.VERSION;
import android.widget.Toast;
import androidx.annotation.RequiresApi;
import androidx.core.app.NotificationCompat.Builder;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(
        mv = {1, 5, 1},
        k = 1,
        d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u0000 \u000f2\u00020\u0001:\u0001\u000fB\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0003J\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016J\b\u0010\t\u001a\u00020\nH\u0016J \u0010\u000b\u001a\u00020\f2\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\fH\u0017¨\u0006\u0010"},
        d2 = {"Laltermarkive/guardian/Guardian;", "Landroid/app/Service;", "()V", "createNotificationChannel", "", "onBind", "Landroid/os/IBinder;", "intent", "Landroid/content/Intent;", "onCreate", "", "onStartCommand", "", "flags", "startID", "Companion", "Fall_Detector.fall-detector"}
)
public final class Guardian extends Service {
    @NotNull
    public static final Guardian.Companion Companion = new Guardian.Companion((DefaultConstructorMarker)null);

    public void onCreate() {
        Positioning.Companion.initiate(this);
        Detector.Companion.instance$Fall_Detector_fall_detector(this);
        Sampler.Companion.instance(this);
        Alarm.Companion.instance$Fall_Detector_fall_detector(this);
    }

    @RequiresApi(26)
    private final String createNotificationChannel() {
        String var10000 = this.getResources().getString(1900020);
        Intrinsics.checkNotNullExpressionValue(var10000, "resources.getString(R.string.app)");
        String channelId = var10000;
        String channelName = channelId + " Background Service";
        NotificationChannel channel = new NotificationChannel(channelId, (CharSequence)channelName, 0);
        channel.setLockscreenVisibility(0);
        Object var5 = this.getSystemService("notification");
        if (var5 == null) {
            throw new NullPointerException("null cannot be cast to non-null type android.app.NotificationManager");
        } else {
            NotificationManager service = (NotificationManager)var5;
            service.createNotificationChannel(channel);
            return channelId;
        }
    }

    @SuppressLint({"UnspecifiedImmutableFlag"})
    public int onStartCommand(@NotNull Intent intent, int flags, int startID) {
        Intrinsics.checkNotNullParameter(intent, "intent");
        long now = System.currentTimeMillis();
        String var10000 = this.getResources().getString(1900020);
        Intrinsics.checkNotNullExpressionValue(var10000, "resources.getString(R.string.app)");
        String app = var10000;
        String channelId = VERSION.SDK_INT >= 26 ? this.createNotificationChannel() : "";
        Intent main = new Intent((Context)this, Main.class);
        PendingIntent pending = PendingIntent.getActivity((Context)this, 0, main, 0);
        Notification var11 = (new Builder((Context)this, channelId)).setSmallIcon(17301642).setContentTitle((CharSequence)app).setContentText((CharSequence)(app + " is active")).setWhen(now).setContentIntent(pending).build();
        Intrinsics.checkNotNullExpressionValue(var11, "NotificationCompat.Build…ntIntent(pending).build()");
        Notification notification = var11;
        this.startForeground(1, notification);
        return 1;
    }

    @Nullable
    public IBinder onBind(@NotNull Intent intent) {
        Intrinsics.checkNotNullParameter(intent, "intent");
        return null;
    }

    @Metadata(
            mv = {1, 5, 1},
            k = 1,
            d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0015\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0000¢\u0006\u0002\b\u0007J-\u0010\b\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\fH\u0000¢\u0006\u0002\b\u000e¨\u0006\u000f"},
            d2 = {"Laltermarkive/guardian/Guardian$Companion;", "", "()V", "initiate", "", "context", "Landroid/content/Context;", "initiate$Fall_Detector_fall_detector", "say", "level", "", "tag", "", "message", "say$Fall_Detector_fall_detector", "Fall_Detector.fall-detector"}
    )
    public static final class Companion {
        public final void initiate$Fall_Detector_fall_detector(@NotNull Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intent intent = new Intent(context, Guardian.class);
            if (VERSION.SDK_INT >= 26) {
                context.startForegroundService(intent);
            } else {
                context.startService(intent);
            }

        }

        public final void say$Fall_Detector_fall_detector(@NotNull Context context, int level, @NotNull String tag, @NotNull String message) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(tag, "tag");
            Intrinsics.checkNotNullParameter(message, "message");
            Log.INSTANCE.println(level, tag, message);
            Toast.makeText(context, (CharSequence)message, 0).show();
        }

        private Companion() {
        }

        // $FF: synthetic method
        public Companion(DefaultConstructorMarker $constructor_marker) {
            this();
        }
    }
}

