package com.example.animationapp;

import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.ArrayAdapter;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private ImageView imageView;
    private Spinner animationSpinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize the ImageView and Spinner
        imageView = findViewById(R.id.imageView);
        animationSpinner = findViewById(R.id.animationSpinner);

        // Create an ArrayAdapter for the Spinner
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.animation_effects, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        animationSpinner.setAdapter(adapter);

        // Set an OnItemSelectedListener to handle selection of animation type
        animationSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parentView, android.view.View selectedItemView, int position, long id) {
                // Apply selected animation
                applyAnimation(position);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parentView) {
                // Do nothing
            }
        });
    }

    // Method to apply selected animation to the ImageView
    private void applyAnimation(int position) {
        Animation animation = null;

        switch (position) {
            case 0: // Scale
                animation = AnimationUtils.loadAnimation(this, R.anim.scale_animation);
                break;
            case 1: // Rotate (half rotation)
                animation = AnimationUtils.loadAnimation(this, R.anim.rotate_half_animation);
                break;
            case 2: // Rotate (full rotation)
                animation = AnimationUtils.loadAnimation(this, R.anim.rotate_full_animation);
                break;
            case 3: // Bounce
                animation = AnimationUtils.loadAnimation(this, R.anim.bounce_animation);
                break;
            case 4: // Fade
                animation = AnimationUtils.loadAnimation(this, R.anim.fade_animation);
                break;
            case 5: // Slide
                animation = AnimationUtils.loadAnimation(this, R.anim.slide_animation);
                break;
            case 6: // Flip
                animation = AnimationUtils.loadAnimation(this, R.anim.flip_animation);
                break;
            case 7: // Zoom In/Out
                animation = AnimationUtils.loadAnimation(this, R.anim.zoom_animation);
                break;
        }

        if (animation != null) {
            imageView.startAnimation(animation);
        }
    }
}