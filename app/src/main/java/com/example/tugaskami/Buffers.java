package com.example.tugaskami;


import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(
        mv = {1, 5, 1},
        k = 1,
        d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0010\u0013\n\u0002\b\b\n\u0002\u0010\u0002\n\u0000\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u000e\u0010\u0013\u001a\u00020\u00142\u0006\u0010\t\u001a\u00020\u0000R\u0019\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\n¢\u0006\n\n\u0002\u0010\u000e\u001a\u0004\b\f\u0010\rR\u001a\u0010\u0005\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012¨\u0006\u0015"},
        d2 = {"Laltermarkive/guardian/Buffers;", "", "count", "", "size", "position", "value", "", "(IIID)V", "buffers", "", "", "getBuffers", "()[[D", "[[D", "getPosition", "()I", "setPosition", "(I)V", "copyInto", "", "Fall_Detector.fall-detector"}
)
public final class Buffers {
    @NotNull
    private final double[][] buffers;
    private int position;

    @NotNull
    public final double[][] getBuffers() {
        return this.buffers;
    }

    public final void copyInto(@NotNull Buffers buffers) {
        Intrinsics.checkNotNullParameter(buffers, "buffers");
        if (((Object[])this.buffers).length == ((Object[])buffers.buffers).length) {
            int i = 0;

            int var3;
            for(var3 = this.buffers.length; i < var3; ++i) {
                if (this.buffers[i].length != buffers.buffers[i].length) {
                    return;
                }
            }

            i = 0;

            for(var3 = this.buffers.length; i < var3; ++i) {
                ArraysKt.copyInto$default(this.buffers[i], buffers.buffers[i], 0, 0, 0, 14, (Object)null);
            }

            buffers.position = this.position;
        }
    }

    public final int getPosition() {
        return this.position;
    }

    public final void setPosition(int var1) {
        this.position = var1;
    }

    public Buffers(int count, int size, int position, double value) {
        this.position = position;
        double[][] var6 = new double[count][];

        for(int var7 = 0; var7 < count; ++var7) {
            int var9 = false;
            int var10 = size;
            double[] var11 = new double[size];

            for(int var12 = 0; var12 < var10; ++var12) {
                int var16 = false;
                var11[var12] = value;
            }

            var6[var7] = var11;
        }

        this.buffers = (double[][])var6;
    }
}

