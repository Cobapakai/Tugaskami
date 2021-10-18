package com.example.tugaskami;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.net.Uri;
import android.net.wifi.WifiManager;
import android.os.Bundle;
import androidx.core.app.ActivityCompat;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(
        mv = {1, 5, 1},
        k = 1,
        d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \"2\u00020\u0001:\u0001\"B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0012\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\bH\u0002J\u0010\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\bH\u0016J\u0010\u0010\u0014\u001a\u00020\u00122\u0006\u0010\u0015\u001a\u00020\u0016H\u0016J\u0010\u0010\u0017\u001a\u00020\u00122\u0006\u0010\u0015\u001a\u00020\u0016H\u0016J \u0010\u0018\u001a\u00020\u00122\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001cH\u0016J\u0018\u0010\u001d\u001a\u00020\u00122\u0006\u0010\u001e\u001a\u00020\u000b2\u0006\u0010\u001f\u001a\u00020\u000fH\u0002J\r\u0010 \u001a\u00020\u0012H\u0000¢\u0006\u0002\b!R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006#"},
        d2 = {"Laltermarkive/guardian/Positioning;", "Landroid/location/LocationListener;", "context", "Laltermarkive/guardian/Guardian;", "(Laltermarkive/guardian/Guardian;)V", "format", "Ljava/text/SimpleDateFormat;", "gps", "Landroid/location/Location;", "network", "once", "", "replied", "", "accuracy", "", "location", "onLocationChanged", "", "newLocation", "onProviderDisabled", "provider", "", "onProviderEnabled", "onStatusChanged", "status", "", "extras", "Landroid/os/Bundle;", "reset", "minTimeMs", "minDistanceM", "trigger", "trigger$Fall_Detector_fall_detector", "Companion", "Fall_Detector.fall-detector"}
)
public final class Positioning implements LocationListener {
    private Location gps;
    private Location network;
    private long once;
    private boolean replied;
    private final SimpleDateFormat format;
    private final Guardian context;
    private static final long METERS_10 = 10L;
    private static final float MINUTES_10 = 600000.0F;
    @Nullable
    private static Positioning singleton;
    @NotNull
    public static final Positioning.Companion Companion = new Positioning.Companion((DefaultConstructorMarker)null);

    public final void trigger$Fall_Detector_fall_detector() {
        Companion.enforce((Context)this.context);
        boolean var2 = false;
        boolean var3 = false;
        synchronized(this) {
            int var4 = false;
            this.reset(0L, 0.0F);
            this.once = System.currentTimeMillis();
            this.replied = false;
            Unit var6 = Unit.INSTANCE;
        }
    }

    private final void reset(long minTimeMs, float minDistanceM) {
        Context var10000 = this.context.getApplicationContext();
        Intrinsics.checkNotNullExpressionValue(var10000, "context.applicationContext");
        Context applicationContext = var10000;
        if (ActivityCompat.checkSelfPermission(applicationContext, "android.permission.ACCESS_FINE_LOCATION") == 0 && ActivityCompat.checkSelfPermission(applicationContext, "android.permission.ACCESS_COARSE_LOCATION") == 0) {
            Object var6 = applicationContext.getSystemService("location");
            if (var6 == null) {
                throw new NullPointerException("null cannot be cast to non-null type android.location.LocationManager");
            } else {
                LocationManager manager = (LocationManager)var6;
                if (this.gps == null) {
                    this.gps = manager.getLastKnownLocation("gps");
                }

                if (this.network == null) {
                    this.network = manager.getLastKnownLocation("network");
                }

                manager.removeUpdates((LocationListener)this);
                manager.requestLocationUpdates("network", minTimeMs, minDistanceM, (LocationListener)this);
            }
        }
    }

    private final float accuracy(Location location) {
        return location != null && location.hasAccuracy() ? location.getAccuracy() : Float.POSITIVE_INFINITY;
    }

    public void onLocationChanged(@NotNull Location newLocation) {
        Intrinsics.checkNotNullParameter(newLocation, "newLocation");
        Object location = newLocation;
        Companion.enforce((Context)this.context);
        boolean var4 = false;
        boolean var5 = false;
        synchronized(this) {
            int var6 = false;
            if (Intrinsics.areEqual("gps", location.getProvider()) && this.accuracy(location) < this.accuracy(this.gps)) {
                this.gps = location;
            }

            if (Intrinsics.areEqual("network", location.getProvider()) && this.accuracy(location) < this.accuracy(this.network)) {
                this.network = location;
            }

            long deadline = this.once + (long)120000;
            long now = System.currentTimeMillis();
            if (deadline <= now && !this.replied) {
                String message;
                label51: {
                    int battery = Battery.INSTANCE.level$Fall_Detector_fall_detector((Context)this.context);
                    message = null;
                    float var13 = this.accuracy(this.gps);
                    boolean var14 = false;
                    if (Float.isInfinite(var13)) {
                        var13 = this.accuracy(this.network);
                        var14 = false;
                        if (Float.isInfinite(var13)) {
                            message = "Battery: " + battery + "% Location: unknown";
                            break label51;
                        }
                    }

                    Location replacement = this.accuracy(this.gps) < this.accuracy(this.network) ? this.gps : this.network;
                    if (replacement != null) {
                        location = replacement;
                    }

                    String lon = "%.5f";
                    Object[] var16 = new Object[]{location.getLatitude()};
                    boolean var17 = false;
                    String var10000 = String.format(lon, Arrays.copyOf(var16, var16.length));
                    Intrinsics.checkNotNullExpressionValue(var10000, "java.lang.String.format(this, *args)");
                    String lat = var10000;
                    String var25 = "%.5f";
                    Object[] var27 = new Object[]{location.getLongitude()};
                    boolean var18 = false;
                    var10000 = String.format(var25, Arrays.copyOf(var27, var27.length));
                    Intrinsics.checkNotNullExpressionValue(var10000, "java.lang.String.format(this, *args)");
                    lon = var10000;
                    int accuracy = (int)location.getAccuracy();
                    int altitude = (int)location.getAltitude();
                    int bearing = (int)location.getBearing();
                    int speed = (int)((double)location.getSpeed() * 60.0D * 60.0D / 1000.0D);
                    var10000 = this.format.format(new Date(location.getTime()));
                    Intrinsics.checkNotNullExpressionValue(var10000, "format.format(Date(location.time))");
                    String time = var10000;
                    message = "Battery: " + battery + " % Location (" + time + "): " + lat + ',' + lon + " ~" + accuracy + " m ^" + altitude + " m " + bearing + " deg " + speed + " km/h http://maps.google.com/?q=" + lat + ',' + lon;
                }

                Messenger.Companion.sms((Context)this.context, Contact.Companion.get$Fall_Detector_fall_detector((Context)this.context), message);
                this.reset(10L, 600000.0F);
                this.replied = true;
            }

            Unit var22 = Unit.INSTANCE;
        }
    }

    public void onStatusChanged(@NotNull String provider, int status, @NotNull Bundle extras) {
        Intrinsics.checkNotNullParameter(provider, "provider");
        Intrinsics.checkNotNullParameter(extras, "extras");
        Companion.enforce((Context)this.context);
    }

    public void onProviderEnabled(@NotNull String provider) {
        Intrinsics.checkNotNullParameter(provider, "provider");
        Companion.enforce((Context)this.context);
    }

    public void onProviderDisabled(@NotNull String provider) {
        Intrinsics.checkNotNullParameter(provider, "provider");
        Companion.enforce((Context)this.context);
    }

    private Positioning(Guardian context) {
        this.context = context;
        this.replied = true;
        this.format = new SimpleDateFormat("yyyy.MM.dd HH:mm:ss", Locale.US);
        this.reset(10L, 600000.0F);
    }

    // $FF: synthetic method
    public Positioning(Guardian context, DefaultConstructorMarker $constructor_marker) {
        this(context);
    }

    @Metadata(
            mv = {1, 5, 1},
            k = 1,
            d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0002J\u0010\u0010\u0011\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0002J\u0010\u0010\u0012\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0002J\u000e\u0010\u0013\u001a\u00020\u000e2\u0006\u0010\u0014\u001a\u00020\u0015R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\f¨\u0006\u0016"},
            d2 = {"Laltermarkive/guardian/Positioning$Companion;", "", "()V", "METERS_10", "", "MINUTES_10", "", "singleton", "Laltermarkive/guardian/Positioning;", "getSingleton$Fall_Detector_fall_detector", "()Laltermarkive/guardian/Positioning;", "setSingleton$Fall_Detector_fall_detector", "(Laltermarkive/guardian/Positioning;)V", "enforce", "", "context", "Landroid/content/Context;", "enforceGPS", "enforceWiFi", "initiate", "guardian", "Laltermarkive/guardian/Guardian;", "Fall_Detector.fall-detector"}
    )
    public static final class Companion {
        @Nullable
        public final Positioning getSingleton$Fall_Detector_fall_detector() {
            return Positioning.singleton;
        }

        public final void setSingleton$Fall_Detector_fall_detector(@Nullable Positioning var1) {
            Positioning.singleton = var1;
        }

        public final void initiate(@NotNull Guardian guardian) {
            Intrinsics.checkNotNullParameter(guardian, "guardian");
            if (((Positioning.Companion)this).getSingleton$Fall_Detector_fall_detector() == null) {
                ((Positioning.Companion)this).setSingleton$Fall_Detector_fall_detector(new Positioning(guardian, (DefaultConstructorMarker)null));
            }

        }

        private final void enforce(Context context) {
            ((Positioning.Companion)this).enforceWiFi(context);
            ((Positioning.Companion)this).enforceGPS(context);
        }

        private final void enforceWiFi(Context context) {
            Context var10000 = context.getApplicationContext();
            Intrinsics.checkNotNullExpressionValue(var10000, "context.applicationContext");
            Context applicationContext = var10000;
            if (ActivityCompat.checkSelfPermission(applicationContext, "android.permission.CHANGE_WIFI_STATE") == 0) {
                Object var4 = applicationContext.getSystemService("wifi");
                if (var4 == null) {
                    throw new NullPointerException("null cannot be cast to non-null type android.net.wifi.WifiManager");
                } else {
                    WifiManager wifi = (WifiManager)var4;
                    wifi.setWifiEnabled(true);
                }
            }
        }

        private final void enforceGPS(Context context) {
            Context var10000 = context.getApplicationContext();
            Intrinsics.checkNotNullExpressionValue(var10000, "context.applicationContext");
            Context applicationContext = var10000;
            Object var13 = applicationContext.getApplicationContext().getSystemService("location");
            if (var13 == null) {
                throw new NullPointerException("null cannot be cast to non-null type android.location.LocationManager");
            } else {
                LocationManager manager = (LocationManager)var13;
                if (!manager.isProviderEnabled("gps")) {
                    boolean stealth = false;

                    try {
                        PackageManager packages = applicationContext.getPackageManager();
                        PackageInfo info = packages.getPackageInfo("com.android.settings", 2);
                        if (info != null) {
                            ActivityInfo[] var9 = info.receivers;
                            int var10 = var9.length;

                            for(int var8 = 0; var8 < var10; ++var8) {
                                ActivityInfo receiver = var9[var8];
                                if (Intrinsics.areEqual(receiver.name, "com.android.settings.widget.SettingsAppWidgetProvider") && receiver.exported) {
                                    stealth = true;
                                }
                            }
                        }
                    } catch (NameNotFoundException var11) {
                    }

                    Intent poke;
                    if (stealth) {
                        poke = new Intent();
                        poke.setClassName("com.android.settings", "com.android.settings.widget.SettingsAppWidgetProvider");
                        poke.addCategory("android.intent.category.ALTERNATIVE");
                        poke.setData(Uri.parse("3"));
                        applicationContext.sendBroadcast(poke);
                    } else {
                        poke = new Intent("android.settings.LOCATION_SOURCE_SETTINGS");
                        poke.addFlags(268435456);
                        applicationContext.startActivity(poke);
                    }

                }
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
