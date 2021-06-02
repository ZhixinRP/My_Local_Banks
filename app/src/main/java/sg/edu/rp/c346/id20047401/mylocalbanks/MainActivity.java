package sg.edu.rp.c346.id20047401.mylocalbanks;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TextView tvDBS,tvOCBC,tvUOB;
    String bankClicked;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tvDBS = findViewById(R.id.textViewDBS);
        tvOCBC = findViewById(R.id.textViewOCBC);
        tvUOB = findViewById(R.id.textViewUOB);
        registerForContextMenu(tvDBS);
        registerForContextMenu(tvOCBC);
        registerForContextMenu(tvUOB);
    }

    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo){
        menu.add(0,0,0,"Website");
        menu.add(0,1,1,"Contact the bank");
        menu.add(0,2,2,"Toggle Favourite");

        if (v == tvDBS) {
            bankClicked = "dbs";
        } else if (v == tvOCBC) {
            bankClicked = "ocbc";
        } else if (v == tvUOB) {
            bankClicked = "uob";
        }
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == 0) {
            if (bankClicked.equalsIgnoreCase("dbs")) {
                Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.dbs.com.sg"));
                startActivity(i);
            } else if (bankClicked.equalsIgnoreCase("ocbc")){
                Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.ocbc.com"));
                startActivity(i);
            } else if (bankClicked.equalsIgnoreCase("ocbc")){
                Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.uob.com.sg"));
                startActivity(i);
            }
            return true;
        } else if (item.getItemId() == 1) {
            if (bankClicked.equalsIgnoreCase("dbs")) {
                Intent i = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + "18001111111"));
                startActivity(i);
            } else if (bankClicked.equalsIgnoreCase("ocbc")){
                Intent i = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + "18003633333"));
                startActivity(i);
            } else if (bankClicked.equalsIgnoreCase("ocbc")){
                Intent i = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + "18002222121"));
                startActivity(i);
            }
            return true;
        } else if (item.getItemId() == 2) {

            if (bankClicked.equalsIgnoreCase("dbs") && tvDBS.getCurrentTextColor() == Color.BLACK) {
                tvDBS.setTextColor(Color.RED);
            } else if (bankClicked.equalsIgnoreCase("dbs") && tvDBS.getCurrentTextColor() == Color.RED) {
                tvDBS.setTextColor(Color.BLACK);
            }

            if (bankClicked.equalsIgnoreCase("ocbc") && tvOCBC.getCurrentTextColor() == Color.BLACK) {
                tvOCBC.setTextColor(Color.RED);
            } else if (bankClicked.equalsIgnoreCase("ocbc") && tvOCBC.getCurrentTextColor() == Color.RED) {
                tvOCBC.setTextColor(Color.BLACK);
            }

            if (bankClicked.equalsIgnoreCase("uob") && tvUOB.getCurrentTextColor() == Color.BLACK) {
                tvUOB.setTextColor(Color.RED);
            } else if (bankClicked.equalsIgnoreCase("uob") && tvUOB.getCurrentTextColor() == Color.RED) {
                tvUOB.setTextColor(Color.BLACK);
            }
            return true;
        }
        return super.onContextItemSelected(item);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.englishSelection) {
            tvDBS.setText("DBS");
            tvOCBC.setText("OCBC");
            tvUOB.setText("UOB");
        } else if (item.getItemId() == R.id.chineseSelection) {
            tvDBS.setText("星展银行");
            tvOCBC.setText("华侨银行");
            tvUOB.setText("大华银行");
        }
        return super.onOptionsItemSelected(item);
    }
}