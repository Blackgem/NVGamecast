package info.androidtv.libreelec;

import android.app.Activity;
import android.app.AlertDialog.Builder;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import java.io.DataOutputStream;
import java.io.IOException;

public class reboot extends Activity {
    protected void onCreate(Bundle paramBundle) {
        super.onCreate(paramBundle);
        createAndShowAlertDialog();
    }

    private void createAndShowAlertDialog() {
        Builder builder = new Builder(this);
        builder.setTitle("Reiniciar a LibreELEC?");
        builder.setPositiveButton("Aceptar", new OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                reboot.sudo("reboot update");
                dialog.dismiss();
                finish(); //Para cerrar bien la app?
            }
        });
        builder.setNegativeButton("Cancelar", new OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                dialog.dismiss();
                System.exit(0);
                finish(); //Para cerrar bien la app?
            }
        });
        builder.create().show();
    }

    private static void sudo(String... strings) {
        try {
            Process su = Runtime.getRuntime().exec("su");
            DataOutputStream outputStream = new DataOutputStream(su.getOutputStream());
            for (String s : strings) {
                outputStream.writeBytes(s + "\n");
                outputStream.flush();
            }
            outputStream.writeBytes("exit\n");
            outputStream.flush();
            try {
                su.waitFor();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            outputStream.close();
        } catch (IOException e2) {
            e2.printStackTrace();
        }
    }
}