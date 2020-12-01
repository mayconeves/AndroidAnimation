package com.projeto.androidanimation;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.drawable.Animatable;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.widget.ImageView;

public class DrawableAnimationActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drawable_animation);

        ImageView imageView = findViewById(R.id.imageViewLoading);

        // Dar inicio a animação
        Animatable animacao = (AnimationDrawable) imageView.getDrawable();
        animacao.start();

    }

    // Animação ao voltar
    @Override
    public void finish() {
        super.finish();

        // Animacao para a que esta entrando, e animacao para a que esta saindo
        overridePendingTransition(R.anim.fade_in, R.anim.mover_direita);
    }
}