package com.jatin.popupmenudemo;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.PopupMenu;

/*
  STEPS TO CREATE POPUP MENU:
  1. Create Menu Items
  2. Add View on Which we want to show PopUp Menu
  3. Create and show PopUp Menu
  4. Add events
 */
public class MainActivity extends AppCompatActivity {

    private LinearLayout layout;
    private Button btnBackground;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        layout = findViewById(R.id.layout);
        btnBackground = findViewById(R.id.btnBackground);
        btnBackground.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                PopupMenu popupMenu = new PopupMenu(MainActivity.this,btnBackground);
                final MenuInflater menuInflater = getMenuInflater();
                menuInflater.inflate(R.menu.my_menu,popupMenu.getMenu());
                popupMenu.show();
                popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {
                        switch (item.getItemId()){
                            case R.id.menu_cyan:
                                layout.setBackgroundColor(Color.CYAN);
                                return true;
                            case R.id.menu_magenta:
                                layout.setBackgroundColor(Color.MAGENTA);
                                return true;
                            case R.id.menu_yellow:
                                layout.setBackgroundColor(Color.YELLOW);
                                return true;
                            default:
                                return false;
                        }

                    }
                });
            }
        });
    }
}