package com.example.tugaskami;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(
        mv = {1, 5, 1},
        k = 3,
        d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002¨\u0006\u0003"},
        d2 = {"<anonymous>", "", "invoke", "androidx/navigation/ui/AppBarConfigurationKt$AppBarConfiguration$3"}
)
public final class Main$onCreate$$inlined$AppBarConfiguration$1 extends Lambda implements Function0 {
    public static final Main$onCreate$$inlined$AppBarConfiguration$1 INSTANCE = new Main$onCreate$$inlined$AppBarConfiguration$1();

    public Main$onCreate$$inlined$AppBarConfiguration$1() {
        super(0);
    }

    // $FF: synthetic method
    // $FF: bridge method
    public Object invoke() {
        return this.invoke();
    }

    public final boolean invoke() {
        return false;
    }
}
// Main.java
package altermarkive.guardian;

        import altermarkive.guardian.databinding.MainBinding;
        import android.app.Dialog;
        import android.content.Context;
        import android.os.Bundle;
        import android.view.View;
        import android.view.Window;
        import android.view.View.OnClickListener;
        import android.view.WindowManager.LayoutParams;
        import android.webkit.WebView;
        import android.widget.Button;
        import androidx.appcompat.app.AppCompatActivity;
        import androidx.customview.widget.Openable;
        import androidx.fragment.app.Fragment;
        import androidx.navigation.NavController;
        import androidx.navigation.fragment.NavHostFragment;
        import androidx.navigation.ui.ActivityKt;
        import androidx.navigation.ui.AppBarConfiguration;
        import androidx.navigation.ui.BottomNavigationViewKt;
        import androidx.navigation.ui.AppBarConfiguration.Builder;
        import androidx.navigation.ui.AppBarConfiguration.OnNavigateUpListener;
        import com.google.android.material.bottomnavigation.BottomNavigationView;
        import java.util.Set;
        import kotlin.Metadata;
        import kotlin.collections.SetsKt;
        import kotlin.jvm.functions.Function0;
        import kotlin.jvm.internal.Intrinsics;
        import org.jetbrains.annotations.Nullable;

@Metadata(
        mv = {1, 5, 1},
        k = 1,
        d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0002J\u0012\u0010\u0007\u001a\u00020\u00042\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0014¨\u0006\n"},
        d2 = {"Laltermarkive/guardian/Main;", "Landroidx/appcompat/app/AppCompatActivity;", "()V", "eula", "", "context", "Landroid/content/Context;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "Fall_Detector.fall-detector"}
)
public final class Main extends AppCompatActivity {
    private final void eula(Context context) {
        Guardian.Companion.initiate$Fall_Detector_fall_detector((Context)this);
        final Dialog dialog = new Dialog(context);
        dialog.setContentView(1300007);
        dialog.setTitle((CharSequence)"EULA");
        View var10000 = dialog.findViewById(1000236);
        if (var10000 == null) {
            throw new NullPointerException("null cannot be cast to non-null type android.webkit.WebView");
        } else {
            WebView web = (WebView)var10000;
            web.loadUrl("file:///android_asset/eula.html");
            var10000 = dialog.findViewById(1000242);
            if (var10000 == null) {
                throw new NullPointerException("null cannot be cast to non-null type android.widget.Button");
            } else {
                Button accept = (Button)var10000;
                accept.setOnClickListener((OnClickListener)(new OnClickListener() {
                    public final void onClick(View it) {
                        dialog.dismiss();
                    }
                }));
                LayoutParams layout = new LayoutParams();
                Window window = dialog.getWindow();
                if (window != null) {
                    layout.copyFrom(window.getAttributes());
                    layout.width = -1;
                    layout.height = -1;
                    window.setAttributes(layout);
                    dialog.show();
                }
            }
        }
    }

    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        MainBinding var10000 = MainBinding.inflate(this.getLayoutInflater());
        Intrinsics.checkNotNullExpressionValue(var10000, "MainBinding.inflate(layoutInflater)");
        MainBinding binding = var10000;
        this.setContentView((View)binding.getRoot());
        BottomNavigationView var12 = binding.navigation;
        Intrinsics.checkNotNullExpressionValue(var12, "binding.navigation");
        BottomNavigationView navView = var12;
        Fragment var13 = this.getSupportFragmentManager().findFragmentById(1000188);
        if (var13 == null) {
            throw new NullPointerException("null cannot be cast to non-null type androidx.navigation.fragment.NavHostFragment");
        } else {
            NavHostFragment navHostFragment = (NavHostFragment)var13;
            NavController var14 = navHostFragment.getNavController();
            Intrinsics.checkNotNullExpressionValue(var14, "navHostFragment.navController");
            NavController navController = var14;
            Set topLevelDestinationIds$iv = SetsKt.setOf(new Integer[]{1000235, 1000294, 1000203});
            Openable drawerLayout$iv = (Openable)null;
            Function0 fallbackOnNavigateUpListener$iv = (Function0)Main$onCreate$$inlined$AppBarConfiguration$1.INSTANCE;
            int $i$f$AppBarConfiguration = false;
            AppBarConfiguration var15 = (new Builder(topLevelDestinationIds$iv)).setOpenableLayout(drawerLayout$iv).setFallbackOnNavigateUpListener((OnNavigateUpListener)(new Main$inlined$sam$i$androidx_navigation_ui_AppBarConfiguration_OnNavigateUpListener$0(fallbackOnNavigateUpListener$iv))).build();
            Intrinsics.checkExpressionValueIsNotNull(var15, "AppBarConfiguration.Buil…eUpListener)\n    .build()");
            AppBarConfiguration appBarConfiguration = var15;
            ActivityKt.setupActionBarWithNavController(this, navController, appBarConfiguration);
            BottomNavigationViewKt.setupWithNavController(navView, navController);
            this.eula((Context)this);
        }
    }
}
// Main$inlined$sam$i$androidx_navigation_ui_AppBarConfiguration_OnNavigateUpListener$0.java
package altermarkive.guardian;

        import androidx.navigation.ui.AppBarConfiguration.OnNavigateUpListener;
        import kotlin.Metadata;
        import kotlin.jvm.functions.Function0;
        import kotlin.jvm.internal.Intrinsics;

@Metadata(
        mv = {1, 1, 16},
        bv = {1, 0, 3},
        k = 3
)
public final class Main$inlined$sam$i$androidx_navigation_ui_AppBarConfiguration_OnNavigateUpListener$0 implements OnNavigateUpListener {
    // $FF: synthetic field
    private final Function0 function;

    public Main$inlined$sam$i$androidx_navigation_ui_AppBarConfiguration_OnNavigateUpListener$0(Function0 var1) {
        this.function = var1;
    }

    // $FF: synthetic method
    public final boolean onNavigateUp() {
        Object var10000 = this.function.invoke();
        Intrinsics.checkExpressionValueIsNotNull(var10000, "invoke(...)");
        return (Boolean)var10000;
    }
}

