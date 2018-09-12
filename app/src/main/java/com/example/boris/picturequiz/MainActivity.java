package com.example.boris.picturequiz;

//@Author Boris Kalshoven

import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioGroup;

public class MainActivity extends AppCompatActivity {

    //local variables
    private int currentImageIndex = 0;
    private int[] mImageNames;
    private ImageView mImageView;
    private Button mPrevButton;
    private Button mCheckButton;
    private Button mNextButton;
    private RadioGroup mGroup;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mImageView = findViewById(R.id.imageView_Main);
        mPrevButton = findViewById(R.id.button_Prev);
        mCheckButton = findViewById(R.id.button_Check);
        mNextButton = findViewById(R.id.button_Next);
        mGroup = findViewById(R.id.radioGroup);

        mImageNames = new int[]{R.drawable.image1, R.drawable.image2, R.drawable.image3};

        //Define what happens when the user clicks the "next image" button
        mNextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                currentImageIndex++;
                if (currentImageIndex >= mImageNames.length){
                    currentImageIndex = 0;
                }
                mImageView.setImageResource(mImageNames[currentImageIndex]);
            }
        });

        //Define what happens when the "Prev" button is clicked
        mPrevButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                currentImageIndex--;
                if (currentImageIndex < 0){
                    currentImageIndex = 2;
                }
                mImageView.setImageResource(mImageNames[currentImageIndex]);
            }
        });

        //Define what happens when the "Check" button is clicked
        mCheckButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                //Method variables needed to determine the correct answer to the question
                int radioButtonID = mGroup.getCheckedRadioButtonId();
                View radioButton = mGroup.findViewById(radioButtonID);
                int answerIndex = mGroup.indexOfChild(radioButton);

                if (currentImageIndex == answerIndex){
                    Snackbar.make(mImageView, "Correct", Snackbar.LENGTH_SHORT).setAction("Action",null).show();
                } else {
                    Snackbar.make(mImageView, "Wrong", Snackbar.LENGTH_SHORT).setAction("Action", null).show();
                }


            }
        });

    }
}
