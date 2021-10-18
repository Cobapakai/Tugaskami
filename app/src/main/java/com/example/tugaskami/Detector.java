package com.example.tugaskami;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(
        mv = {1, 5, 1},
        k = 1,
        d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0013\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u001b\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0016\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 ]2\u00020\u0001:\u0001]B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u00107\u001a\u0002082\u0006\u0010\r\u001a\u000209H\u0002J \u0010:\u001a\u00020\u00062\u0006\u0010;\u001a\u00020\u00142\u0006\u0010<\u001a\u00020\u001c2\u0006\u0010=\u001a\u00020\u001cH\u0002J\u0010\u0010>\u001a\u00020\u001c2\u0006\u0010?\u001a\u00020\u001cH\u0002J \u0010@\u001a\u00020\u00062\u0006\u0010A\u001a\u00020\u00062\u0006\u0010B\u001a\u00020\u00142\u0006\u0010C\u001a\u00020\u0014H\u0002J\u0010\u0010D\u001a\u0002082\u0006\u0010\r\u001a\u00020\u000eH\u0002J0\u0010E\u001a\u00020\u00062\u0006\u0010F\u001a\u00020\u00042\u0006\u0010G\u001a\u00020\u00062\u0006\u0010H\u001a\u00020\u00042\u0006\u0010I\u001a\u00020\u00062\u0006\u0010J\u001a\u00020\u0004H\u0002J \u0010K\u001a\u00020\u00062\u0006\u0010A\u001a\u00020\u00062\u0006\u0010B\u001a\u00020\u00142\u0006\u0010C\u001a\u00020\u0014H\u0002J\u0010\u0010L\u001a\u00020\u00062\u0006\u0010;\u001a\u00020\u0014H\u0002J\u0010\u0010M\u001a\u00020\u00062\u0006\u0010;\u001a\u00020\u0014H\u0002J\u0018\u0010N\u001a\u0002082\u0006\u0010O\u001a\u00020P2\u0006\u0010Q\u001a\u00020\u001cH\u0016J\u0010\u0010R\u001a\u0002082\u0006\u0010S\u001a\u00020TH\u0016J\b\u0010U\u001a\u000208H\u0002J(\u0010V\u001a\u0002082\u0006\u0010W\u001a\u00020\u00042\u0006\u0010X\u001a\u00020\u00062\u0006\u0010Y\u001a\u00020\u00062\u0006\u0010Z\u001a\u00020\u0006H\u0002J(\u0010[\u001a\u0002082\u0006\u0010W\u001a\u00020\u00042\u0006\u0010X\u001a\u00020\u00062\u0006\u0010Y\u001a\u00020\u00062\u0006\u0010Z\u001a\u00020\u0006H\u0002J \u0010\\\u001a\u00020\u00062\u0006\u0010\u001e\u001a\u00020\u00062\u0006\u0010&\u001a\u00020\u00062\u0006\u0010.\u001a\u00020\u0006H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u001c\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0014X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0014X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0014X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0014X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0014X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u001cX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u001cX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u0014X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\u0014X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020\u0014X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\u0014X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020\u0014X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020\u0014X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020\u0014X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020\u0014X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010&\u001a\u00020\u0014X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010'\u001a\u00020\u0014X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010(\u001a\u00020\u0014X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010)\u001a\u00020\u0014X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010*\u001a\u00020\u0014X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010+\u001a\u00020\u0014X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010,\u001a\u00020\u0014X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010-\u001a\u00020\u0014X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010.\u001a\u00020\u0014X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010/\u001a\u00020\u0014X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u00100\u001a\u00020\u0014X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u00101\u001a\u00020\u0014X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u00102\u001a\u00020\u0014X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u00103\u001a\u00020\u0014X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u00104\u001a\u00020\u0014X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u00105\u001a\u00020\u0014X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u00106\u001a\u00020\u0014X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006^"},
        d2 = {"Laltermarkive/guardian/Detector;", "Landroid/hardware/SensorEventListener;", "()V", "anteTime", "", "anteX", "", "anteY", "anteZ", "buffers", "Laltermarkive/guardian/Buffers;", "getBuffers", "()Laltermarkive/guardian/Buffers;", "context", "Laltermarkive/guardian/Guardian;", "getContext", "()Laltermarkive/guardian/Guardian;", "setContext", "(Laltermarkive/guardian/Guardian;)V", "falling", "", "impact", "lying", "regular", "svD", "svMaxMin", "svTOT", "timeoutFalling", "", "timeoutImpact", "x", "xHPF", "xHpfXV", "xHpfYV", "xLPF", "xLpfXV", "xLpfYV", "xMaxMin", "y", "yHPF", "yHpfXV", "yHpfYV", "yLPF", "yLpfXV", "yLpfYV", "yMaxMin", "z", "z2", "zHPF", "zHpfXV", "zHpfYV", "zLPF", "zLpfXV", "zLpfYV", "zMaxMin", "alert", "", "Landroid/content/Context;", "at", "array", "index", "size", "expire", "timeout", "hpf", "value", "xv", "yv", "initiateSensor", "linear", "before", "ante", "after", "post", "now", "lpf", "max", "min", "onAccuracyChanged", "sensor", "Landroid/hardware/Sensor;", "accuracy", "onSensorChanged", "event", "Landroid/hardware/SensorEvent;", "process", "protect", "postTime", "postX", "postY", "postZ", "resample", "sv", "Companion", "Fall_Detector.fall-detector"}
)
public final class Detector implements SensorEventListener {
    @Nullable
    private Guardian context;
    private int timeoutFalling = -1;
    private int timeoutImpact = -1;
    @NotNull
    private final Buffers buffers = new Buffers(19, 500, 0, Double.NaN);
    private final double[] x;
    private final double[] y;
    private final double[] z;
    private final double[] xLPF;
    private final double[] yLPF;
    private final double[] zLPF;
    private final double[] xHPF;
    private final double[] yHPF;
    private final double[] zHPF;
    private final double[] xMaxMin;
    private final double[] yMaxMin;
    private final double[] zMaxMin;
    private final double[] svTOT;
    private final double[] svD;
    private final double[] svMaxMin;
    private final double[] z2;
    private final double[] falling;
    private final double[] impact;
    private final double[] lying;
    private final double[] xLpfXV;
    private final double[] xLpfYV;
    private final double[] yLpfXV;
    private final double[] yLpfYV;
    private final double[] zLpfXV;
    private final double[] zLpfYV;
    private final double[] xHpfXV;
    private final double[] xHpfYV;
    private final double[] yHpfXV;
    private final double[] yHpfYV;
    private final double[] zHpfXV;
    private final double[] zHpfYV;
    private double anteX;
    private double anteY;
    private double anteZ;
    private long anteTime;
    private long regular;
    @NotNull
    private static Detector singleton = new Detector();
    private static final String TAG;
    public static final int INTERVAL_MS = 20;
    private static final int DURATION_S = 10;
    public static final int N = 500;
    public static final double FALLING_WAIST_SV_TOT = 0.6D;
    public static final double IMPACT_WAIST_SV_TOT = 2.0D;
    public static final double IMPACT_WAIST_SV_D = 1.7D;
    public static final double IMPACT_WAIST_SV_MAX_MIN = 2.0D;
    public static final double IMPACT_WAIST_Z_2 = 1.5D;
    private static final int SPAN_MAX_MIN = 5;
    private static final int SPAN_FALLING = 50;
    private static final int SPAN_IMPACT = 100;
    private static final int SPAN_AVERAGING = 20;
    private static final int FILTER_N_ZEROS = 2;
    private static final int FILTER_N_POLES = 2;
    private static final double FILTER_LPF_GAIN = 4143.204922D;
    private static final double FILTER_HPF_GAIN = 1.022463023D;
    private static final double FILTER_FACTOR_0 = -0.9565436765D;
    private static final double FILTER_FACTOR_1 = 1.9555782403D;
    private static final double G = 1.0D;
    private static final double LYING_AVERAGE_Z_LPF = 0.5D;
    public static final int BUFFER_X = 0;
    public static final int BUFFER_Y = 1;
    public static final int BUFFER_Z = 2;
    public static final int BUFFER_X_LPF = 3;
    public static final int BUFFER_Y_LPF = 4;
    public static final int BUFFER_Z_LPF = 5;
    public static final int BUFFER_X_HPF = 6;
    public static final int BUFFER_Y_HPF = 7;
    public static final int BUFFER_Z_HPF = 8;
    public static final int BUFFER_X_MAX_MIN = 9;
    public static final int BUFFER_Y_MAX_MIN = 10;
    public static final int BUFFER_Z_MAX_MIN = 11;
    public static final int BUFFER_SV_TOT = 12;
    public static final int BUFFER_SV_D = 13;
    public static final int BUFFER_SV_MAX_MIN = 14;
    public static final int BUFFER_Z_2 = 15;
    public static final int BUFFER_FALLING = 16;
    public static final int BUFFER_IMPACT = 17;
    public static final int BUFFER_LYING = 18;
    public static final int BUFFER_COUNT = 19;
    @NotNull
    public static final Detector.Companion Companion = new Detector.Companion((DefaultConstructorMarker)null);

    @Nullable
    public final Guardian getContext() {
        return this.context;
    }

    public final void setContext(@Nullable Guardian var1) {
        this.context = var1;
    }

    @NotNull
    public final Buffers getBuffers() {
        return this.buffers;
    }

    private final double linear(long before, double ante, long after, double post, long now) {
        return ante + (post - ante) * (double)(now - before) / (double)(after - before);
    }

    private final double at(double[] array, int index, int size) {
        return array[(index + size) % size];
    }

    private final int expire(int timeout) {
        return timeout > -1 ? timeout - 1 : -1;
    }

    private final double sv(double x, double y, double z) {
        double var7 = x * x + y * y + z * z;
        boolean var9 = false;
        return Math.sqrt(var7);
    }

    private final double min(double[] array) {
        double min = this.at(array, this.buffers.getPosition(), 500);
        int i = 1;

        for(byte var5 = 5; i < var5; ++i) {
            double value = this.at(array, this.buffers.getPosition() - i, 500);
            boolean var10 = false;
            if (!Double.isNaN(value) && value < min) {
                min = value;
            }
        }

        return min;
    }

    private final double max(double[] array) {
        double max = this.at(array, this.buffers.getPosition(), 500);
        int i = 1;

        for(byte var5 = 5; i < var5; ++i) {
            double value = this.at(array, this.buffers.getPosition() - i, 500);
            boolean var10 = false;
            if (!Double.isNaN(value) && max < value) {
                max = value;
            }
        }

        return max;
    }

    private final double lpf(double value, double[] xv, double[] yv) {
        xv[0] = xv[1];
        xv[1] = xv[2];
        xv[2] = value / 4143.204922D;
        yv[0] = yv[1];
        yv[1] = yv[2];
        yv[2] = xv[0] + xv[2] + (double)2 * xv[1] + -0.9565436765D * yv[0] + 1.9555782403D * yv[1];
        return yv[2];
    }

    private final double hpf(double value, double[] xv, double[] yv) {
        xv[0] = xv[1];
        xv[1] = xv[2];
        xv[2] = value / 1.022463023D;
        yv[0] = yv[1];
        yv[1] = yv[2];
        yv[2] = xv[0] + xv[2] - (double)2 * xv[1] + -0.9565436765D * yv[0] + 1.9555782403D * yv[1];
        return yv[2];
    }

    private final void process() {
        int at = this.buffers.getPosition();
        this.timeoutFalling = this.expire(this.timeoutFalling);
        this.timeoutImpact = this.expire(this.timeoutImpact);
        this.xLPF[at] = this.lpf(this.x[at], this.xLpfXV, this.xLpfYV);
        this.yLPF[at] = this.lpf(this.y[at], this.yLpfXV, this.yLpfYV);
        this.zLPF[at] = this.lpf(this.z[at], this.zLpfXV, this.zLpfYV);
        this.xHPF[at] = this.hpf(this.x[at], this.xHpfXV, this.xHpfYV);
        this.yHPF[at] = this.hpf(this.y[at], this.yHpfXV, this.yHpfYV);
        this.zHPF[at] = this.hpf(this.z[at], this.zHpfXV, this.zHpfYV);
        this.xMaxMin[at] = this.max(this.x) - this.min(this.x);
        this.yMaxMin[at] = this.max(this.y) - this.min(this.y);
        this.zMaxMin[at] = this.max(this.z) - this.min(this.z);
        double svTOTAt = this.sv(this.x[at], this.y[at], this.z[at]);
        this.svTOT[at] = svTOTAt;
        double svDAt = this.sv(this.xHPF[at], this.yHPF[at], this.zHPF[at]);
        this.svD[at] = svDAt;
        this.svMaxMin[at] = this.sv(this.xMaxMin[at], this.yMaxMin[at], this.zMaxMin[at]);
        this.z2[at] = (svTOTAt * svTOTAt - svDAt * svDAt - 1.0D) / 2.0D;
        double svTOTBefore = this.at(this.svTOT, at - 1, 500);
        this.falling[at] = 0.0D;
        if (0.6D <= svTOTBefore && svTOTAt < 0.6D) {
            this.timeoutFalling = 50;
            this.falling[at] = 1.0D;
        }

        this.impact[at] = 0.0D;
        double sum;
        double count;
        if (-1 < this.timeoutFalling) {
            sum = this.svMaxMin[at];
            count = this.z2[at];
            if (2.0D <= svTOTAt || 1.7D <= svDAt || 2.0D <= sum || 1.5D <= count) {
                this.timeoutImpact = 100;
                this.impact[at] = 1.0D;
            }
        }

        this.lying[at] = 0.0D;
        if (this.timeoutImpact == 0) {
            sum = 0.0D;
            count = 0.0D;
            int i = 0;

            for(byte var13 = 20; i < var13; ++i) {
                double value = this.at(this.zLPF, at - i, 500);
                boolean var18 = false;
                if (!Double.isNaN(value)) {
                    sum += value;
                    ++count;
                }
            }

            if (0.5D < sum / count) {
                this.lying[at] = 1.0D;
                Guardian context = this.context;
                if (context != null) {
                    Guardian.Companion.say$Fall_Detector_fall_detector((Context)context, 5, TAG, "Detected a fall");
                    this.alert((Context)context);
                }
            }
        }

    }

    private final void resample(long postTime, double postX, double postY, double postZ) {
        if (0L == this.anteTime) {
            this.regular = postTime + (long)20;
        } else {
            while(this.regular < postTime) {
                int at = this.buffers.getPosition();
                this.x[at] = this.linear(this.anteTime, this.anteX, postTime, postX, this.regular);
                this.y[at] = this.linear(this.anteTime, this.anteY, postTime, postY, this.regular);
                this.z[at] = this.linear(this.anteTime, this.anteZ, postTime, postZ, this.regular);
                this.process();
                this.buffers.setPosition((this.buffers.getPosition() + 1) % 500);
                this.regular += (long)20;
            }

        }
    }

    private final void protect(long postTime, double postX, double postY, double postZ) {
        Buffers var9 = this.buffers;
        boolean var10 = false;
        boolean var11 = false;
        synchronized(var9) {
            int var12 = false;
            this.resample(postTime, postX, postY, postZ);
            Unit var14 = Unit.INSTANCE;
        }
    }

    public void onAccuracyChanged(@NotNull Sensor sensor, int accuracy) {
        Intrinsics.checkNotNullParameter(sensor, "sensor");
        if (1 == sensor.getType()) {
            Companion.log(4, "Accuracy of the accelerometer is now equal to " + accuracy);
        }

    }

    public void onSensorChanged(@NotNull SensorEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        Sensor var10001 = event.sensor;
        Intrinsics.checkNotNullExpressionValue(var10001, "event.sensor");
        if (1 == var10001.getType()) {
            long postTime = event.timestamp / (long)1000000;
            double postX = (double)event.values[0] / (double)9.80665F;
            double postY = (double)event.values[1] / (double)9.80665F;
            double postZ = (double)event.values[2] / (double)9.80665F;
            this.protect(postTime, postX, postY, postZ);
            this.anteTime = postTime;
            this.anteX = postX;
            this.anteY = postY;
            this.anteZ = postZ;
        }

    }

    private final void initiateSensor(Guardian context) {
        this.context = context;
        Object var10000 = context.getSystemService("sensor");
        if (var10000 == null) {
            throw new NullPointerException("null cannot be cast to non-null type android.hardware.SensorManager");
        } else {
            SensorManager manager = (SensorManager)var10000;
            Sensor var8 = manager.getDefaultSensor(1);
            Intrinsics.checkNotNullExpressionValue(var8, "manager.getDefaultSensor…ensor.TYPE_ACCELEROMETER)");
            Sensor sensor = var8;
            String var9 = sensor.getVendor();
            Intrinsics.checkNotNullExpressionValue(var9, "sensor.vendor");
            String vendor = var9;
            var9 = sensor.getName();
            Intrinsics.checkNotNullExpressionValue(var9, "sensor.name");
            String name = var9;
            int delay = sensor.getMinDelay();
            float resolution = sensor.getResolution();
            Companion.log(4, "Sensor: " + vendor + ", " + name + ", " + delay + " [us], " + resolution);
            manager.registerListener((SensorEventListener)this, sensor, 20000);
        }
    }

    private final void alert(Context context) {
        Alarm.Companion.alert$Fall_Detector_fall_detector(context);
    }

    private Detector() {
        this.x = this.buffers.getBuffers()[0];
        this.y = this.buffers.getBuffers()[1];
        this.z = this.buffers.getBuffers()[2];
        this.xLPF = this.buffers.getBuffers()[3];
        this.yLPF = this.buffers.getBuffers()[4];
        this.zLPF = this.buffers.getBuffers()[5];
        this.xHPF = this.buffers.getBuffers()[6];
        this.yHPF = this.buffers.getBuffers()[7];
        this.zHPF = this.buffers.getBuffers()[8];
        this.xMaxMin = this.buffers.getBuffers()[9];
        this.yMaxMin = this.buffers.getBuffers()[10];
        this.zMaxMin = this.buffers.getBuffers()[11];
        this.svTOT = this.buffers.getBuffers()[12];
        this.svD = this.buffers.getBuffers()[13];
        this.svMaxMin = this.buffers.getBuffers()[14];
        this.z2 = this.buffers.getBuffers()[15];
        this.falling = this.buffers.getBuffers()[16];
        this.impact = this.buffers.getBuffers()[17];
        this.lying = this.buffers.getBuffers()[18];
        byte var1 = 3;
        double[] var2 = new double[var1];

        int var3;
        boolean var5;
        double var9;
        for(var3 = 0; var3 < var1; ++var3) {
            var5 = false;
            var9 = 0.0D;
            var2[var3] = var9;
        }

        this.xLpfXV = var2;
        var1 = 3;
        var2 = new double[var1];

        for(var3 = 0; var3 < var1; ++var3) {
            var5 = false;
            var9 = 0.0D;
            var2[var3] = var9;
        }

        this.xLpfYV = var2;
        var1 = 3;
        var2 = new double[var1];

        for(var3 = 0; var3 < var1; ++var3) {
            var5 = false;
            var9 = 0.0D;
            var2[var3] = var9;
        }

        this.yLpfXV = var2;
        var1 = 3;
        var2 = new double[var1];

        for(var3 = 0; var3 < var1; ++var3) {
            var5 = false;
            var9 = 0.0D;
            var2[var3] = var9;
        }

        this.yLpfYV = var2;
        var1 = 3;
        var2 = new double[var1];

        for(var3 = 0; var3 < var1; ++var3) {
            var5 = false;
            var9 = 0.0D;
            var2[var3] = var9;
        }

        this.zLpfXV = var2;
        var1 = 3;
        var2 = new double[var1];

        for(var3 = 0; var3 < var1; ++var3) {
            var5 = false;
            var9 = 0.0D;
            var2[var3] = var9;
        }

        this.zLpfYV = var2;
        var1 = 3;
        var2 = new double[var1];

        for(var3 = 0; var3 < var1; ++var3) {
            var5 = false;
            var9 = 0.0D;
            var2[var3] = var9;
        }

        this.xHpfXV = var2;
        var1 = 3;
        var2 = new double[var1];

        for(var3 = 0; var3 < var1; ++var3) {
            var5 = false;
            var9 = 0.0D;
            var2[var3] = var9;
        }

        this.xHpfYV = var2;
        var1 = 3;
        var2 = new double[var1];

        for(var3 = 0; var3 < var1; ++var3) {
            var5 = false;
            var9 = 0.0D;
            var2[var3] = var9;
        }

        this.yHpfXV = var2;
        var1 = 3;
        var2 = new double[var1];

        for(var3 = 0; var3 < var1; ++var3) {
            var5 = false;
            var9 = 0.0D;
            var2[var3] = var9;
        }

        this.yHpfYV = var2;
        var1 = 3;
        var2 = new double[var1];

        for(var3 = 0; var3 < var1; ++var3) {
            var5 = false;
            var9 = 0.0D;
            var2[var3] = var9;
        }

        this.zHpfXV = var2;
        var1 = 3;
        var2 = new double[var1];

        for(var3 = 0; var3 < var1; ++var3) {
            var5 = false;
            var9 = 0.0D;
            var2[var3] = var9;
        }

        this.zHpfYV = var2;
        this.anteX = Double.NaN;
        this.anteY = Double.NaN;
        this.anteZ = Double.NaN;
    }

    static {
        String var10000 = Detector.class.getSimpleName();
        Intrinsics.checkNotNullExpressionValue(var10000, "Detector::class.java.simpleName");
        TAG = var10000;
    }

    @Metadata(
            mv = {1, 5, 1},
            k = 1,
            d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0015\n\u0002\u0010\u0006\n\u0002\b\u0013\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0015\u00105\u001a\u0002002\u0006\u00106\u001a\u000207H\u0000¢\u0006\u0002\b8J\u0016\u00109\u001a\u00020:2\u0006\u0010;\u001a\u00020\u00042\u0006\u0010<\u001a\u00020.R\u000e\u0010\u0003\u001a\u00020\u0004X\u0080T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0080T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0080T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0080T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0080T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0080T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0080T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004X\u0080T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004X\u0080T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004X\u0080T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0004X\u0080T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0004X\u0080T¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0004X\u0080T¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0004X\u0080T¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0004X\u0080T¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0004X\u0080T¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0004X\u0080T¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0004X\u0080T¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0004X\u0080T¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0004X\u0080T¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u001aX\u0080T¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u001aX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u001aX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u001aX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u001aX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\u001aX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020\u001aX\u0080T¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020\u001aX\u0080T¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020\u001aX\u0080T¢\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020\u001aX\u0080T¢\u0006\u0002\n\u0000R\u000e\u0010&\u001a\u00020\u0004X\u0080T¢\u0006\u0002\n\u0000R\u000e\u0010'\u001a\u00020\u001aX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010(\u001a\u00020\u0004X\u0080T¢\u0006\u0002\n\u0000R\u000e\u0010)\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010*\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010+\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010,\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010-\u001a\u00020.X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010/\u001a\u000200X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b1\u00102\"\u0004\b3\u00104¨\u0006="},
            d2 = {"Laltermarkive/guardian/Detector$Companion;", "", "()V", "BUFFER_COUNT", "", "BUFFER_FALLING", "BUFFER_IMPACT", "BUFFER_LYING", "BUFFER_SV_D", "BUFFER_SV_MAX_MIN", "BUFFER_SV_TOT", "BUFFER_X", "BUFFER_X_HPF", "BUFFER_X_LPF", "BUFFER_X_MAX_MIN", "BUFFER_Y", "BUFFER_Y_HPF", "BUFFER_Y_LPF", "BUFFER_Y_MAX_MIN", "BUFFER_Z", "BUFFER_Z_2", "BUFFER_Z_HPF", "BUFFER_Z_LPF", "BUFFER_Z_MAX_MIN", "DURATION_S", "FALLING_WAIST_SV_TOT", "", "FILTER_FACTOR_0", "FILTER_FACTOR_1", "FILTER_HPF_GAIN", "FILTER_LPF_GAIN", "FILTER_N_POLES", "FILTER_N_ZEROS", "G", "IMPACT_WAIST_SV_D", "IMPACT_WAIST_SV_MAX_MIN", "IMPACT_WAIST_SV_TOT", "IMPACT_WAIST_Z_2", "INTERVAL_MS", "LYING_AVERAGE_Z_LPF", "N", "SPAN_AVERAGING", "SPAN_FALLING", "SPAN_IMPACT", "SPAN_MAX_MIN", "TAG", "", "singleton", "Laltermarkive/guardian/Detector;", "getSingleton$Fall_Detector_fall_detector", "()Laltermarkive/guardian/Detector;", "setSingleton$Fall_Detector_fall_detector", "(Laltermarkive/guardian/Detector;)V", "instance", "context", "Laltermarkive/guardian/Guardian;", "instance$Fall_Detector_fall_detector", "log", "", "level", "entry", "Fall_Detector.fall-detector"}
    )
    public static final class Companion {
        @NotNull
        public final Detector getSingleton$Fall_Detector_fall_detector() {
            return Detector.singleton;
        }

        public final void setSingleton$Fall_Detector_fall_detector(@NotNull Detector var1) {
            Intrinsics.checkNotNullParameter(var1, "<set-?>");
            Detector.singleton = var1;
        }

        @NotNull
        public final Detector instance$Fall_Detector_fall_detector(@NotNull Guardian context) {
            Intrinsics.checkNotNullParameter(context, "context");
            if (Intrinsics.areEqual(((Detector.Companion)this).getSingleton$Fall_Detector_fall_detector().getContext(), context) ^ true) {
                ((Detector.Companion)this).getSingleton$Fall_Detector_fall_detector().initiateSensor(context);
            }

            return ((Detector.Companion)this).getSingleton$Fall_Detector_fall_detector();
        }

        public final void log(int level, @NotNull String entry) {
            Intrinsics.checkNotNullParameter(entry, "entry");
            if (BuildConfig.DEBUG) {
                Log.INSTANCE.println(level, Detector.TAG, entry);
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

