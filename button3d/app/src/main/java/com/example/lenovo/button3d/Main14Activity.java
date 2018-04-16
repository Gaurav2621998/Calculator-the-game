package com.example.lenovo.button3d;

import android.content.Intent;
import android.graphics.Typeface;
import android.media.MediaPlayer;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

public class Main14Activity extends AppCompatActivity implements  View.OnClickListener{
//level-13( level -  24)
static int goal = 210;
    static int  result = 0;
    static int moves = 5 ;
    static int count13 = 10;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main14);
        Button clear=(Button)findViewById(R.id.bclear);
        ImageButton setting =(ImageButton)findViewById(R.id.setting);
        Button black1= (Button)findViewById(R.id.black1);
        Button black2= (Button)findViewById(R.id.black2);
        Button black3= (Button)findViewById(R.id.black3);
        Button b1= (Button)findViewById(R.id.b1);
        Button b2= (Button)findViewById(R.id.b2);
        Button b3= (Button)findViewById(R.id.b3);
        Button b4=(Button)findViewById(R.id.b4);
        TextView Result=(TextView)findViewById(R.id.answer);
        TextView Goal=(TextView)findViewById(R.id.goal);
        TextView Level=(TextView)findViewById(R.id.level);
        TextView move = (TextView)findViewById(R.id.moves);
        black1.setOnClickListener(this);
        black2.setOnClickListener(this);
        black3.setOnClickListener(this);
    b2.setOnClickListener( this );
        black1.setText("-5");
        Result.setText(""+result);
        black2.setText("+5 ");
        black3.setText("5 ");
        Goal.setText("GOAL : 210");
        Level.setText("LEVEL 13");
        b1.setEnabled(false);
        b2.setText( "2" );
        b3.setEnabled( false );
        move.setText("MOVES :"+moves);
        Result.setText(""+result);
        b4.setEnabled(false);
        TextView myTextView = (TextView) findViewById(R.id.answer);
        Typeface typeface = Typeface.createFromAsset(getAssets(), "fonts/digital.ttf");
        myTextView.setTypeface(typeface);
        //black3.setEnabled(false);

    }

    @Override
    public void onClick(View v) {
        if (moves > 0) {
            Button clear=(Button)findViewById(R.id.bclear);
            TextView Result = (TextView) findViewById(R.id.answer);
            TextView move = (TextView) findViewById(R.id.moves);

            switch (v.getId()) {

                case R.id.black1:{

                    final MediaPlayer mp = MediaPlayer.create(this, R.raw.bclick);
                    mp.start();
                    result = result -5 ;
                    Result.setText("" + result);
                    --moves;
                    move.setText("MOVES: " + moves);

                    break;}
                case R.id.black2: {

                    final MediaPlayer mp = MediaPlayer.create(this, R.raw.bclick);
                    mp.start();
                    result = result +5;
                    Result.setText("" + result);
                    --moves;
                    move.setText("MOVES: " + moves);
                    break;
                }
                case R.id.black3: {

                    final MediaPlayer mp = MediaPlayer.create(this, R.raw.bclick);
                    mp.start();
                    String A = String.valueOf( result );
                    A = A + "5";
                    result = Integer.parseInt( A );
                    Result.setText("" + result);
                    --moves;
                    move.setText("MOVES: " + moves);
                    break;
                }
                case R.id.b2 : {
                    final MediaPlayer mp = MediaPlayer.create(this, R.raw.bclick);
                    mp.start();
                    String A = String.valueOf( result );
                    A = A + "2";
                    result = Integer.parseInt( A );
                    Result.setText("" + result);
                    --moves;
                    move.setText("MOVES: " + moves);
                    break;

                }


            }
            if(result < 0)
            {
                clear();
            }
            if (goal == result) {
                Result.setText("YOU WIN");
                count13 = count13+10;
                new Handler().postDelayed( new Runnable() {
                    @Override
                    public void run() {

                        Intent i=new Intent(Main14Activity.this,Main15Activity.class);
                        finish();
                        startActivity(i);
                    }
                }, 450);
            }
            else{
                if(moves==0&&goal!=result)
                {
                    Result.setTextSize(65);
                    Result.setText("YOU LOOSE");
                }
            }

        }
    }
    public void bclear(View view){
        clear();
    }
    public void clear(){
        TextView Result = (TextView) findViewById(R.id.answer);
        TextView move = (TextView) findViewById(R.id.moves);

        final MediaPlayer mp = MediaPlayer.create(this, R.raw.bclick);
        mp.start();
        count13 = count13-5;

        moves = 5;
        result = 0;
        Result.setText("" + result);
        move.setText("MOVES: " + moves);
    }
    public void setClick(View view)
    {

        final MediaPlayer mp = MediaPlayer.create(this, R.raw.bclick);
        mp.start();
        Intent i=new Intent(Main14Activity.this,SettingActivity.class);
        TextView Level=(TextView)findViewById(R.id.level);
        i.putExtra("level13", count13);
        i.putExtra("calling-activity", MainActivity.ActivityConstants.ACTIVITY_13);
        i.putExtra("textViewText", Level.getText().toString());
        startActivity(i);
    }
    @Override
    protected void onPause() {
        super.onPause();
        finish();
    }
}
