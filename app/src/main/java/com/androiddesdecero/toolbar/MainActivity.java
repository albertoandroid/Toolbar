package com.androiddesdecero.toolbar;

import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {

    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setUpToolBar();
        setUpHomeUpIconAndColor(R.drawable.ic_camera, R.color.colorWhiteApp);
    }

    private void setUpToolBar(){
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        showHomeUpIcon();
    }

    public void showHomeUpIcon(){
        if(getSupportActionBar() != null){
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }
    }

    private void setUpHomeUpIconAndColor(int drawable, int color){
        if(getSupportActionBar()!= null){
            final Drawable icon = getResources().getDrawable(drawable);
            icon.setColorFilter(getResources().getColor(color), PorterDuff.Mode.SRC_ATOP);
            getSupportActionBar().setHomeAsUpIndicator(icon);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        menuIconColor(menu, R.color.colorWhiteApp);
        return super.onCreateOptionsMenu(menu);
    }

    public void menuIconColor(Menu menu, int color){
        for(int i=0; i<menu.size(); i++){
            Drawable drawable = menu.getItem(i).getIcon();
            if(drawable != null){
                drawable.mutate();
                drawable.setColorFilter(getResources().getColor(color), PorterDuff.Mode.SRC_ATOP);
            }
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        switch (item.getItemId()){
            case android.R.id.home:
                Log.d("TAG1", "homeButton - onOptionsItemsSelected");
                break;
            case R.id.new_email:
                Log.d("TAG1", "New Email");
                break;
            case R.id.send_email:
                Log.d("TAG1", "Send Email");
                break;
            case R.id.send_mail_secure:
                Log.d("TAG1", "Send mail Secure");
                break;
            case R.id.send_mail_unsecure:
                Log.d("TAG1", "Send  Email Unsecure");
                break;
            case R.id.update_settings:
                Log.d("TAG1", "update settings");
                break;
            default:
                    //Error Desconocido
        }
        return super.onOptionsItemSelected(item);
    }
}
