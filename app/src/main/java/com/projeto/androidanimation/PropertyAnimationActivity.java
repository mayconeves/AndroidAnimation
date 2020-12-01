package com.projeto.androidanimation;

import androidx.appcompat.app.AppCompatActivity;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.animation.ValueAnimator;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AnimationSet;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.ObjectStreamException;

public class PropertyAnimationActivity extends AppCompatActivity implements View.OnClickListener{

    Button btnAplhaAnimationPA;
    Button btnScaleAnimationPA;
    Button btnRotateAnimationPA;
    Button btnTranslateAnimationPA;
    Button btnGroupAnimationPA;
    Button btnSimplificadoAnimationPA;

    ImageView imageViewAndroidPA;

    boolean visivel;
    boolean rotacaoOriginal;
    boolean tamanhoOriginal;
    boolean localOriginal;
    boolean primeiraVez;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_property_animation);

        btnAplhaAnimationPA         =  findViewById(R.id.btnAlphaAnimationPA);
        btnScaleAnimationPA         =  findViewById(R.id.btnScaleAnimationPA);
        btnRotateAnimationPA        =  findViewById(R.id.btnRotateAnimationPA);
        btnTranslateAnimationPA     =  findViewById(R.id.btnTranslateAnimationPA);
        btnGroupAnimationPA         =  findViewById(R.id.btnGroupAnimationPA);
        btnSimplificadoAnimationPA  =  findViewById(R.id.btnAnimationSimplificado);

        imageViewAndroidPA          = findViewById(R.id.imageViewAndroidPA);

        btnAplhaAnimationPA.setOnClickListener(this);
        btnScaleAnimationPA.setOnClickListener(this);
        btnRotateAnimationPA.setOnClickListener(this);
        btnTranslateAnimationPA.setOnClickListener(this);
        btnGroupAnimationPA.setOnClickListener(this);
        btnSimplificadoAnimationPA.setOnClickListener(this);

        visivel         = true;
        rotacaoOriginal = true;
        tamanhoOriginal = true;
        localOriginal   = true;
        primeiraVez     = true;
    }

    @Override
    public void onClick(View view) {

        switch (view.getId()){
            case R.id.btnAlphaAnimationPA:
                alphaAnimamationPA();
                break;

            case R.id.btnScaleAnimationPA:
                scaleAnimationPA();
                break;

            case R.id.btnRotateAnimationPA:
                rotateAnimationPA();
                break;

            case R.id.btnTranslateAnimationPA:
                translateAnimationPA();
                break;

            case R.id.btnGroupAnimationPA:
                groupAnimationPA();
                break;

            case R.id.btnAnimationSimplificado:
                viewPropertyAnimation();
                break;
        }
    }

    /**
     * Animação simplificada
     */
    private void viewPropertyAnimation() {
        if(primeiraVez){
            // Movimentar 500dp, rotacao em torno do eixo x com o angulo de 360º e a duracao
            imageViewAndroidPA.animate().x(500).rotationX(360).setDuration(3000);
        } else {
            // Efeito reverso
            imageViewAndroidPA.animate().x(250).rotationX(0).setDuration(3000);
        }

        primeiraVez = !primeiraVez;
    }

    private void groupAnimationPA() {
        ObjectAnimator alpha = ObjectAnimator.ofFloat(imageViewAndroidPA,"alpha",1.0f, 0.0f);
        ObjectAnimator rotacao = ObjectAnimator.ofFloat(imageViewAndroidPA,"rotation",0, 250);

        // Repetir animação
        alpha.setRepeatCount(3);
        alpha.setRepeatMode(ValueAnimator.REVERSE);

        rotacao.setRepeatCount(3);
        rotacao.setRepeatMode(ValueAnimator.REVERSE);

        // Agrupar
        AnimatorSet listaAnimacao = new AnimatorSet();
        listaAnimacao.setDuration(3000);
        listaAnimacao.playTogether(alpha, rotacao);

        // Executar
        listaAnimacao.start();

    }


    /**
     * Animações
     */

    // Visivel
    private void alphaAnimamationPA() {
        // O que sera animado
        // Qual acao
        // Do ponto 1 que é visivel até 0 que é invisivel
        ObjectAnimator objectAnimator = ObjectAnimator.ofFloat(
                imageViewAndroidPA,
                "alpha",
                1.0f,
                0.0f
        );

        objectAnimator.setDuration(2500);

        if(visivel){
            objectAnimator.start();
        } else {
            objectAnimator.reverse();
        }

        visivel = false;

    }

    // Ampliar / Dimimuir
    private void scaleAnimationPA() {
        // Qual ação/propriedade
        // De 1 até 0, diminuir ate ficar invisel
        PropertyValuesHolder valorX = PropertyValuesHolder.ofFloat("scaleX", 1, 0);
        PropertyValuesHolder valorY = PropertyValuesHolder.ofFloat("scaleY", 1, 0);

        // O que animar
        ObjectAnimator objectAnimator = ObjectAnimator.ofPropertyValuesHolder(
            imageViewAndroidPA, valorX, valorY
        );

        objectAnimator.setDuration(2500);

        if(tamanhoOriginal){
            objectAnimator.start();
        } else {
            objectAnimator.reverse();
        }

        tamanhoOriginal = false;
    }

    // Rotaçãoo
    public void rotateAnimationPA(){
        // Qual elemento será animado
        // Qual animacao
        // Quais os valores, sair de 0 girar até 250º
        ObjectAnimator objectAnimator = ObjectAnimator.ofFloat(
                imageViewAndroidPA,
                "rotation",
                0,
                250
        );

        objectAnimator.setDuration(2500);

        if(rotacaoOriginal){
            objectAnimator.start();
        } else {
            objectAnimator.reverse();
        }

        rotacaoOriginal = false;
    }

    // Movimento
    private void translateAnimationPA() {
        // Qual elemento será animado
        // X coordenada view
        // Sair da posição zero até a posicao 300
        final ObjectAnimator objectAnimator = ObjectAnimator.ofFloat(
                imageViewAndroidPA,
                "x",
                0,
                300
        );

        objectAnimator.setDuration(2500);
        objectAnimator.setRepeatCount(3);
        objectAnimator.setRepeatMode(ValueAnimator.REVERSE);

        // Lista
        objectAnimator.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animator) {
                Toast.makeText(getBaseContext(), "Inicio", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onAnimationEnd(Animator animator) {
                Toast.makeText(getBaseContext(), "Finalizou", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onAnimationCancel(Animator animator) {
                Toast.makeText(getBaseContext(), "Cancelado", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onAnimationRepeat(Animator animator) {
                Toast.makeText(getBaseContext(), "Repetição", Toast.LENGTH_SHORT).show();
                objectAnimator.cancel();
            }
        });

        if(localOriginal){
            objectAnimator.start();
        } else {
            objectAnimator.reverse();
        }

        localOriginal = false;
    }
}