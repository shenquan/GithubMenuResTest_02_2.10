package com.example.administrator.menurestest;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class MainActivity extends Activity {

    private TextView txt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txt = (TextView) findViewById(R.id.txt);
        registerForContextMenu(txt);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
//        getMenuInflater().inflate(R.menu.menu_main, menu);
        new MenuInflater(this).inflate(R.menu.menu_main,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        MenuInflater inflater = new MenuInflater(this);
        inflater.inflate(R.menu.context, menu);
        menu.setHeaderIcon(R.drawable.tools);
        menu.setHeaderTitle("请选择背景色");
        super.onCreateContextMenu(menu, v, menuInfo);
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        item.setChecked(true);
        switch (item.getItemId()) {
            case R.id.red:
                item.setChecked(true);
                txt.setBackgroundColor(Color.RED);
                break;
            case R.id.green:
                item.setChecked(true);
                txt.setBackgroundColor(Color.GREEN);
                break;
            case R.id.blue:
                item.setChecked(true);
                txt.setBackgroundColor(Color.BLUE);
                break;
        }
        return super.onContextItemSelected(item);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        /*// Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }*/

        if(item.isCheckable()){
            item.setChecked(true);
        }
        switch (item.getItemId()){
            case R.id.font_10:
                txt.setTextSize(10*2);
                break;
            case R.id.font_12:
                txt.setTextSize(12 * 2);
                break;
            case R.id.font_14:
                txt.setTextSize(14 * 2);
                break;
            case R.id.font_16:
                txt.setTextSize(16 * 2);
                break;
            case R.id.font_18:
                txt.setTextSize(18 * 2);
                break;
            case R.id.red_font:
                txt.setTextColor(Color.RED);
                item.setChecked(true);
                break;
            case R.id.green_font:
                txt.setTextColor(Color.GREEN);
                item.setChecked(true);
                break;
            case R.id.blue_font:
                txt.setTextColor(Color.BLUE);
                item.setChecked(true);
                break;
            case R.id.plain_item:
                Toast  toast = Toast.makeText(MainActivity.this,"您单机了普通菜单项",Toast.LENGTH_SHORT);
                toast.show();
                break;
        }

        return super.onOptionsItemSelected(item);
    }
}
