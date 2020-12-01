package com.projeto.androidanimation;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.app.ActivityOptionsCompat;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnDrawableAnimation = findViewById(R.id.btnDrawableAnimation);
        Button btnViewAnimation     = findViewById(R.id.btnViewAnimation);
        Button btnPropertyAnimation = findViewById(R.id.btnPropertyAnimation);

        btnDrawableAnimation.setOnClickListener(this);
        btnViewAnimation.setOnClickListener(this);
        btnPropertyAnimation.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btnDrawableAnimation:
                // Animar transição
                // Contexto
                // Animacao para a activiy que esta entrando
                // Animacao para activity que esta saindo
                ActivityOptionsCompat activityOptionsCompat = ActivityOptionsCompat.makeCustomAnimation(this, R.anim.fade_in, R.anim.mover_direita);
                // Start, contexto, intent, e as configurações de animacao acima
                ActivityCompat.startActivity(this, new Intent(this, DrawableAnimationActivity.class), activityOptionsCompat.toBundle());
                //startActivity(new Intent(this, DrawableAnimationActivity.class ));
                break;

            case R.id.btnViewAnimation:
                startActivity(new Intent(this, ViewAnimationActivity.class));
                break;

            case R.id.btnPropertyAnimation:
                startActivity(new Intent(this, PropertyAnimationActivity.class));
                break;
        }
    }
}