package com.simplesite.mdhalim.dewaara;


import android.content.Context;
import android.os.Bundle;
import android.transition.TransitionManager;
import android.util.AttributeSet;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.inputmethod.EditorInfo;
import android.widget.CalendarView;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.Toast;

import com.google.android.material.bottomappbar.BottomAppBar;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {


    ViewGroup tContainer;
    CalendarView calendar;

    private BottomAppBar bar;
    private Switch aSwitch;
    private boolean fbModeCenter = true;
    private FloatingActionButton fab;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_main );
        // visibale and invisible of the Calendar
        tContainer = findViewById( R.id.transitionContainer );
        calendar = findViewById( R.id.calendarView );
        aSwitch = findViewById( R.id.switch1 );


        aSwitch.setOnClickListener( new View.OnClickListener() {

            boolean gone;

            @Override
            public void onClick(View v) {
                TransitionManager.beginDelayedTransition( tContainer );
                gone = !gone;
                calendar.setVisibility( gone ? View.GONE: View.VISIBLE );
            }
        } );

        //Floating point e.g menubar, toolbar etc. hide and show
        init();

        aSwitch.setOnCheckedChangeListener( new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    fab.hide();

                } else fab.show();
            }
        } );



        // Floating point button to mone center and right side
        fab.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (fbModeCenter) {
                    bar.setFabAlignmentMode( BottomAppBar.FAB_ALIGNMENT_MODE_END );
                    fbModeCenter = false;
                } else {
                    bar.setFabAlignmentMode( BottomAppBar.FAB_ALIGNMENT_MODE_CENTER );
                    fbModeCenter = true;
                }
            }
        } );

        bar.setNavigationOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mostrarMensaje();
            }
        } );


    }

        // menubar click then show the massage on the screen
    private void mostrarMensaje() {
        Toast.makeText( getBaseContext(), "Click", Toast.LENGTH_SHORT ).show();
    }


    private void init() {
        this.bar = findViewById( R.id.bar );
        this.setSupportActionBar( bar );
        this.aSwitch = findViewById( R.id.switch1 );
        this.fab = findViewById( R.id.fab );
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate( R.menu.menu_bbar, menu );
        return true;
    }



}

