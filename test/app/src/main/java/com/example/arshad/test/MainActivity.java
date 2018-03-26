package com.example.arshad.test;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {

    FirebaseApp firebaseApp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button up=(Button) findViewById(R.id.up);
        Button down=(Button) findViewById(R.id.down);



        up.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FirebaseDatabase database=FirebaseDatabase.getInstance();
                DatabaseReference myref=database.getReference("state");
                myref.setValue("1");
//                System.out.println("this is working");
                ImageView img=(ImageView)findViewById(R.id.change);
                img.animate().alpha(1).setDuration(1000);
                img.setImageResource(R.drawable.open);

            }
        });
        down.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                FirebaseDatabase database=FirebaseDatabase.getInstance();
                DatabaseReference myref=database.getReference("state");
                myref.setValue("0");
//                System.out.println("this is working");
                ImageView img=(ImageView)findViewById(R.id.change);
                img.animate().alpha(1).setDuration(1000);
                img.setImageResource(R.drawable.close);

            }
        });
    }
   

    public void down(View view){

        Toast toast=Toast.makeText(this.getApplicationContext(),"this down button is working",Toast.LENGTH_SHORT);
        toast.show();
    }

    public void up(View view){

        Toast toast=Toast.makeText(this.getApplicationContext(),"this up button is working",Toast.LENGTH_SHORT);
        toast.show();
    }
}
