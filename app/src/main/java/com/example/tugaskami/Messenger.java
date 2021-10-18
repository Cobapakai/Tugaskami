package com.example.tugaskami;

import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Build.VERSION;
import android.telephony.SmsManager;
import android.telephony.SmsMessage;
import androidx.core.content.ContextCompat;
import java.util.Collection;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(
        mv = {1, 5, 1},
        k = 1,
        d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \t2\u00020\u0001:\u0001\tB\u0005¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016¨\u0006\n"},
        d2 = {"Laltermarkive/guardian/Messenger;", "Landroid/content/BroadcastReceiver;", "()V", "onReceive", "", "context", "Landroid/content/Context;", "intent", "Landroid/content/Intent;", "Companion", "Fall_Detector.fall-detector"}
)
public final class Messenger extends BroadcastReceiver {
    private static final String TAG;
    @NotNull
    public static final Messenger.Companion Companion = new Messenger.Companion((DefaultConstructorMarker)null);

    public void onReceive(@NotNull Context context, @NotNull Intent intent) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(intent, "intent");
        String action = intent.getAction();
        if (Intrinsics.areEqual("android.provider.Telephony.SMS_RECEIVED", action)) {
            Bundle bundle = intent.getExtras();
            if (bundle == null) {
                Guardian.Companion.say$Fall_Detector_fall_detector(context, 5, TAG, "Received an SMS broadcast without extras");
            } else {
                Object var10000 = bundle.get("pdus");
                if (var10000 == null) {
                    throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<*>");
                }

                Object[] messages = (Object[])var10000;
                SmsMessage[] message = new SmsMessage[messages.length];
                int i = 0;

                String content;
                for(int var8 = messages.length; i < var8; ++i) {
                    Object var10002;
                    if (VERSION.SDK_INT >= 23) {
                        content = bundle.getString("format");
                        var10002 = messages[i];
                        if (messages[i] == null) {
                            throw new NullPointerException("null cannot be cast to non-null type kotlin.ByteArray");
                        }

                        message[i] = SmsMessage.createFromPdu((byte[])var10002, content);
                    } else {
                        var10002 = messages[i];
                        if (messages[i] == null) {
                            throw new NullPointerException("null cannot be cast to non-null type kotlin.ByteArray");
                        }

                        message[i] = SmsMessage.createFromPdu((byte[])var10002);
                    }
                }

                boolean var15 = false;
                boolean var10 = false;
                if (message.length != 0) {
                    SmsMessage message0 = message[0];
                    if (message0 == null) {
                        Guardian.Companion.say$Fall_Detector_fall_detector(context, 5, TAG, "Received an SMS without content");
                        return;
                    }

                    String contact = message0.getOriginatingAddress();
                    String var21 = message0.getMessageBody();
                    Intrinsics.checkNotNullExpressionValue(var21, "message0.messageBody");
                    String var17 = var21;
                    Locale var22 = Locale.US;
                    Intrinsics.checkNotNullExpressionValue(var22, "Locale.US");
                    Locale var11 = var22;
                    boolean $i$f$toTypedArray = false;
                    if (var17 == null) {
                        throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
                    }

                    var21 = var17.toUpperCase(var11);
                    Intrinsics.checkNotNullExpressionValue(var21, "(this as java.lang.String).toUpperCase(locale)");
                    content = var21;
                    Collection $this$toTypedArray$iv = (Collection)StringsKt.split$default((CharSequence)content, new String[]{";"}, false, 0, 6, (Object)null);
                    $i$f$toTypedArray = false;
                    Object[] var23 = $this$toTypedArray$iv.toArray(new String[0]);
                    if (var23 == null) {
                        throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
                    }

                    String[] items = (String[])var23;
                    if (items.length > 1) {
                        contact = items[1];
                    }

                    if (Contact.Companion.check$Fall_Detector_fall_detector(context, contact)) {
                        boolean prevent = false;
                        if (StringsKt.contains$default((CharSequence)content, (CharSequence)"POSITION", false, 2, (Object)null)) {
                            Positioning var24 = Positioning.Companion.getSingleton$Fall_Detector_fall_detector();
                            if (var24 != null) {
                                var24.trigger$Fall_Detector_fall_detector();
                            }

                            prevent = true;
                        }

                        if (StringsKt.contains$default((CharSequence)content, (CharSequence)"ALARM", false, 2, (Object)null)) {
                            Alarm.Companion.siren$Fall_Detector_fall_detector(context);
                            prevent = true;
                        }

                        if (prevent) {
                            this.abortBroadcast();
                        }
                    }
                } else {
                    Guardian.Companion.say$Fall_Detector_fall_detector(context, 5, TAG, "Received empty SMS");
                }
            }
        }

    }

    static {
        String var10000 = Messenger.class.getSimpleName();
        Intrinsics.checkNotNullExpressionValue(var10000, "Messenger::class.java.simpleName");
        TAG = var10000;
    }

    @Metadata(
            mv = {1, 5, 1},
            k = 1,
            d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J \u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\u00042\u0006\u0010\n\u001a\u00020\u0004R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000b"},
            d2 = {"Laltermarkive/guardian/Messenger$Companion;", "", "()V", "TAG", "", "sms", "", "context", "Landroid/content/Context;", "contact", "message", "Fall_Detector.fall-detector"}
    )
    public static final class Companion {
        public final void sms(@NotNull Context context, @Nullable String contact, @NotNull String message) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(message, "message");
            if (ContextCompat.checkSelfPermission(context, "android.permission.SEND_SMS") == 0) {
                SmsManager manager = SmsManager.getDefault();
                manager.sendTextMessage(contact, (String)null, message, (PendingIntent)null, (PendingIntent)null);
            } else {
                Guardian.Companion.say$Fall_Detector_fall_detector(context, 6, Messenger.TAG, "ERROR: No permission to send an SMS");
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
