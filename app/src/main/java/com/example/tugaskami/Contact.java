package com.example.tugaskami;

import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract.Contacts;
import android.provider.ContactsContract.CommonDataKinds.Phone;
import android.telephony.PhoneNumberUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContract;
import androidx.activity.result.contract.ActivityResultContracts.StartActivityForResult;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.preference.PreferenceManager;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(
        mv = {1, 5, 1},
        k = 1,
        d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \u00102\u00020\u00012\u00020\u0002:\u0001\u0010B\u0005¢\u0006\u0002\u0010\u0003J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016J\u0012\u0010\f\u001a\u00020\t2\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0014J\b\u0010\u000f\u001a\u00020\tH\u0002R\u001c\u0010\u0004\u001a\u0010\u0012\f\u0012\n \u0007*\u0004\u0018\u00010\u00060\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0011"},
        d2 = {"Laltermarkive/guardian/Contact;", "Landroidx/appcompat/app/AppCompatActivity;", "Landroid/view/View$OnClickListener;", "()V", "contactPicker", "Landroidx/activity/result/ActivityResultLauncher;", "Landroid/content/Intent;", "kotlin.jvm.PlatformType", "onClick", "", "view", "Landroid/view/View;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "pickContact", "Companion", "Fall_Detector.fall-detector"}
)
public final class Contact extends AppCompatActivity implements OnClickListener {
    private final ActivityResultLauncher contactPicker;
    private static final String TAG;
    @NotNull
    public static final Contact.Companion Companion = new Contact.Companion((DefaultConstructorMarker)null);

    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setContentView(1300080);
        View var10000 = this.findViewById(1000080);
        if (var10000 == null) {
            throw new NullPointerException("null cannot be cast to non-null type android.widget.EditText");
        } else {
            EditText edit = (EditText)var10000;
            edit.setText((CharSequence)Companion.get$Fall_Detector_fall_detector((Context)this));
            var10000 = this.findViewById(1000030);
            if (var10000 == null) {
                throw new NullPointerException("null cannot be cast to non-null type android.widget.Button");
            } else {
                Button buttonSearch = (Button)var10000;
                buttonSearch.setOnClickListener((OnClickListener)this);
                var10000 = this.findViewById(1000219);
                if (var10000 == null) {
                    throw new NullPointerException("null cannot be cast to non-null type android.widget.Button");
                } else {
                    Button buttonOk = (Button)var10000;
                    buttonOk.setOnClickListener((OnClickListener)this);
                    var10000 = this.findViewById(1000000);
                    if (var10000 == null) {
                        throw new NullPointerException("null cannot be cast to non-null type android.widget.Button");
                    } else {
                        Button buttonCancel = (Button)var10000;
                        buttonCancel.setOnClickListener((OnClickListener)this);
                    }
                }
            }
        }
    }

    private final void pickContact() {
        Intent intent = new Intent("android.intent.action.PICK", Contacts.CONTENT_URI);
        this.contactPicker.launch(intent);
    }

    public void onClick(@NotNull View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        switch(view.getId()) {
            case 1000000:
                this.finish();
                break;
            case 1000030:
                if (ContextCompat.checkSelfPermission((Context)this, "android.permission.READ_CONTACTS") == 0) {
                    this.pickContact();
                } else {
                    Guardian.Companion.say$Fall_Detector_fall_detector((Context)this, 6, TAG, "ERROR: No permission to access contacts");
                }
                break;
            case 1000219:
                View var10000 = this.findViewById(1000080);
                if (var10000 == null) {
                    throw new NullPointerException("null cannot be cast to non-null type android.widget.EditText");
                }

                EditText edit = (EditText)var10000;
                String phone = edit.getText().toString();
                Companion.set$Fall_Detector_fall_detector((Context)this, phone);
                this.finish();
        }

    }

    public Contact() {
        ActivityResultLauncher var10001 = this.registerForActivityResult((ActivityResultContract)(new StartActivityForResult()), (ActivityResultCallback)(new ActivityResultCallback() {
            // $FF: synthetic method
            // $FF: bridge method
            public void onActivityResult(Object var1) {
                this.onActivityResult((ActivityResult)var1);
            }

            public final void onActivityResult(ActivityResult result) {
                Intrinsics.checkNotNullExpressionValue(result, "result");
                if (result.getResultCode() == -1) {
                    Intent data = result.getData();
                    if (data == null) {
                        Guardian.Companion.say$Fall_Detector_fall_detector((Context)Contact.this, 6, Contact.TAG, "ERROR: No data after contact selection");
                    } else {
                        String selection = "contact_id=?";
                        Uri outcome = data.getData();
                        if (outcome == null) {
                            Guardian.Companion.say$Fall_Detector_fall_detector((Context)Contact.this, 6, Contact.TAG, "ERROR: No outcome after contact selection");
                        } else {
                            String id = outcome.getLastPathSegment();
                            String[] arguments = new String[]{id};
                            ContentResolver resolver = Contact.this.getContentResolver();
                            Cursor cursor = resolver.query(Phone.CONTENT_URI, (String[])null, selection, arguments, (String)null);
                            if (cursor == null) {
                                Guardian.Companion.say$Fall_Detector_fall_detector((Context)Contact.this, 6, Contact.TAG, "ERROR: Failed to query contacts");
                            } else {
                                int index = cursor.getColumnIndex("data1");
                                if (cursor.moveToFirst()) {
                                    String phone = cursor.getString(index);
                                    if (phone != null) {
                                        View var10000 = Contact.this.findViewById(1000080);
                                        if (var10000 == null) {
                                            throw new NullPointerException("null cannot be cast to non-null type android.widget.EditText");
                                        }

                                        EditText edit = (EditText)var10000;
                                        edit.setText((CharSequence)phone);
                                    }
                                }

                                cursor.close();
                            }
                        }
                    }
                }

            }
        }));
        Intrinsics.checkNotNullExpressionValue(var10001, "registerForActivityResul…        }\n        }\n    }");
        this.contactPicker = var10001;
    }

    static {
        String var10000 = Contact.class.getSimpleName();
        Intrinsics.checkNotNullExpressionValue(var10000, "Contact::class.java.simpleName");
        TAG = var10000;
    }

    @Metadata(
            mv = {1, 5, 1},
            k = 1,
            d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001f\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\u0004H\u0000¢\u0006\u0002\b\nJ\u0018\u0010\u000b\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0007\u001a\u00020\bH\u0080\u0002¢\u0006\u0002\b\fJ \u0010\r\u001a\u00020\u000e2\u0006\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\u0004H\u0080\u0002¢\u0006\u0002\b\u000fR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"},
            d2 = {"Laltermarkive/guardian/Contact$Companion;", "", "()V", "TAG", "", "check", "", "context", "Landroid/content/Context;", "contact", "check$Fall_Detector_fall_detector", "get", "get$Fall_Detector_fall_detector", "set", "", "set$Fall_Detector_fall_detector", "Fall_Detector.fall-detector"}
    )
    public static final class Companion {
        @Nullable
        public final String get$Fall_Detector_fall_detector(@NotNull Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            Context var10000 = context.getApplicationContext();
            Intrinsics.checkNotNullExpressionValue(var10000, "context.applicationContext");
            Context applicationContext = var10000;
            SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(applicationContext);
            return preferences.getString(context.getString(1900079), "");
        }

        public final void set$Fall_Detector_fall_detector(@NotNull Context context, @Nullable String contact) {
            Intrinsics.checkNotNullParameter(context, "context");
            Context var10000 = context.getApplicationContext();
            Intrinsics.checkNotNullExpressionValue(var10000, "context.applicationContext");
            Context applicationContext = var10000;
            SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(applicationContext);
            Editor editor = preferences.edit();
            editor.putString(context.getString(1900079), contact);
            editor.apply();
        }

        public final boolean check$Fall_Detector_fall_detector(@NotNull Context context, @Nullable String contact) {
            Intrinsics.checkNotNullParameter(context, "context");
            Context var10000 = context.getApplicationContext();
            Intrinsics.checkNotNullExpressionValue(var10000, "context.applicationContext");
            Context applicationContext = var10000;
            SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(applicationContext);
            String expected = preferences.getString(context.getString(1900079), "");
            return PhoneNumberUtils.compare(contact, expected);
        }

        private Companion() {
        }

        // $FF: synthetic method
        public Companion(DefaultConstructorMarker $constructor_marker) {
            this();
        }
    }
}
