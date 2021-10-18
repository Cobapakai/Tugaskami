package com.example.tugaskami;

import android.content.Context;
import android.media.AudioAttributes;
import android.media.AudioManager;
import android.media.SoundPool;
import android.media.AudioAttributes.Builder;
import android.os.Build.VERSION;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(
        mv = {1, 5, 1},
        k = 1,
        d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u000b2\u00020\u0001:\u0001\u000bB\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\f"},
        d2 = {"Laltermarkive/guardian/Alarm;", "", "context", "Laltermarkive/guardian/Guardian;", "(Laltermarkive/guardian/Guardian;)V", "getContext", "()Laltermarkive/guardian/Guardian;", "id", "", "pool", "Landroid/media/SoundPool;", "Companion", "Fall_Detector.fall-detector"}
)
public final class Alarm {
    private SoundPool pool;
    private int id;
    @NotNull
    private final Guardian context;
    private static Alarm singleton;
    private static final String TAG;
    @NotNull
    public static final Alarm.Companion Companion = new Alarm.Companion((DefaultConstructorMarker)null);

    @NotNull
    public final Guardian getContext() {
        return this.context;
    }

    private Alarm(Guardian context) {
        this.context = context;
        if (VERSION.SDK_INT >= 21) {
            AudioAttributes var10000 = (new Builder()).setContentType(2).setUsage(4).build();
            Intrinsics.checkNotNullExpressionValue(var10000, "AudioAttributes.Builder(…\n                .build()");
            AudioAttributes audioAttributes = var10000;
            SoundPool var10001 = (new android.media.SoundPool.Builder()).setMaxStreams(5).setAudioAttributes(audioAttributes).build();
            Intrinsics.checkNotNullExpressionValue(var10001, "SoundPool.Builder()\n    …\n                .build()");
            this.pool = var10001;
        } else {
            this.pool = new SoundPool(5, 4, 0);
        }

        this.id = this.pool.load(this.context.getApplicationContext(), 1800000, 1);
    }

    static {
        String var10000 = Alarm.class.getSimpleName();
        Intrinsics.checkNotNullExpressionValue(var10000, "Alarm::class.java.simpleName");
        TAG = var10000;
    }

    // $FF: synthetic method
    public Alarm(Guardian context, DefaultConstructorMarker $constructor_marker) {
        this(context);
    }

    // $FF: synthetic method
    public static final void access$setPool$p(Alarm $this, SoundPool var1) {
        $this.pool = var1;
    }

    // $FF: synthetic method
    public static final void access$setId$p(Alarm $this, int var1) {
        $this.id = var1;
    }

    @Metadata(
            mv = {1, 5, 1},
            k = 1,
            d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0015\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0000¢\u0006\u0002\b\u000bJ\u0015\u0010\f\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\rH\u0000¢\u0006\u0002\b\u000eJ\u001d\u0010\u000f\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u0010\u001a\u00020\u0011H\u0000¢\u0006\u0002\b\u0012J\u0015\u0010\u0013\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0000¢\u0006\u0002\b\u0014R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0015"},
            d2 = {"Laltermarkive/guardian/Alarm$Companion;", "", "()V", "TAG", "", "singleton", "Laltermarkive/guardian/Alarm;", "alert", "", "context", "Landroid/content/Context;", "alert$Fall_Detector_fall_detector", "instance", "Laltermarkive/guardian/Guardian;", "instance$Fall_Detector_fall_detector", "loudest", "stream", "", "loudest$Fall_Detector_fall_detector", "siren", "siren$Fall_Detector_fall_detector", "Fall_Detector.fall-detector"}
    )
    public static final class Companion {
        @NotNull
        public final Alarm instance$Fall_Detector_fall_detector(@NotNull Guardian context) {
            Intrinsics.checkNotNullParameter(context, "context");
            Alarm singleton = Alarm.singleton;
            if (singleton == null) {
                singleton = new Alarm(context, (DefaultConstructorMarker)null);
                Alarm.singleton = singleton;
            }

            return singleton;
        }

        public final void siren$Fall_Detector_fall_detector(@NotNull Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            ((Alarm.Companion)this).loudest$Fall_Detector_fall_detector(context, 4);
            Alarm singleton = Alarm.singleton;
            if (singleton != null) {
                SoundPool pool = singleton.pool;
                pool.play(singleton.id, 1.0F, 1.0F, 1, 3, 1.0F);
            }

        }

        public final void loudest$Fall_Detector_fall_detector(@NotNull Context context, int stream) {
            Intrinsics.checkNotNullParameter(context, "context");
            Object var10000 = context.getSystemService("audio");
            if (var10000 == null) {
                throw new NullPointerException("null cannot be cast to non-null type android.media.AudioManager");
            } else {
                AudioManager manager = (AudioManager)var10000;
                int loudest = manager.getStreamMaxVolume(stream);
                manager.setStreamVolume(stream, loudest, 0);
            }
        }

        public final void alert$Fall_Detector_fall_detector(@NotNull Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            String contact = Contact.Companion.get$Fall_Detector_fall_detector(context);
            if (contact != null && Intrinsics.areEqual("", contact) ^ true) {
                Guardian.Companion.say$Fall_Detector_fall_detector(context, 5, Alarm.TAG, "Alerting the emergency phone number (" + contact + ')');
                Messenger.Companion.sms(context, Contact.Companion.get$Fall_Detector_fall_detector(context), "Fall Detected");
                Telephony.Companion.call$Fall_Detector_fall_detector(context, contact);
            } else {
                Guardian.Companion.say$Fall_Detector_fall_detector(context, 6, Alarm.TAG, "ERROR: Emergency phone number not set");
                ((Alarm.Companion)this).siren$Fall_Detector_fall_detector(context);
            }

        }

        private Companion() {
        }

        // $FF: synthetic method
        public Companion(DefaultConstructorMarker $constructor_marker) {
            this();
        }
    }
}
