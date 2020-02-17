package info.androidtv.nvgamecast;

import android.content.ComponentName;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
//    }
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    //        Intent launchIntentForPackage = getPackageManager().getLaunchIntentForPackage(this.test);
    //        if (launchIntentForPackage != null) {
        //Esto al incluirlo machaca la configuracion que deberia ser usada anteriormente.
    //            Intent launchIntentForPackage = org.videolan.vlc;
        Intent launchIntentForPackage = new Intent();
        launchIntentForPackage.setComponent(new ComponentName("com.nvidia.nvgamecast", "com.nvidia.nvgamecast.GamecastActivity"));
        startActivity(launchIntentForPackage);
    //        } else {
    //            Toast.makeText(this, "Aplicacion \"" + this.test + "\" no encontrada!", 1).show();
    //        }
        finish();
    }
}
