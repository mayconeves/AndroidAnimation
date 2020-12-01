package com.projeto.androidanimation;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.view.animation.RotateAnimation;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class ViewAnimationActivity extends AppCompatActivity implements View.OnClickListener{

    ImageView imageViewAndroid;
    Button btnScaleAnimation;
    Button btnRotateAnimation;
    Button btnAlphaAnimation;
    Button btnTranslateAnimation;
    Button btnGroupAnimation;
    Button btnVisualizarBug;
    Button btnBug;
    boolean visivel;
    boolean rotacaoOriginal;
    boolean tamanhoOriginal;
    boolean localOriginal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_animation);

        imageViewAndroid         = findViewById(R.id.imageViewAndroid);
        btnScaleAnimation        = findViewById(R.id.btnScaleAnimation);
        btnRotateAnimation       = findViewById(R.id.btnRotateAnimation);
        btnAlphaAnimation        = findViewById(R.id.btnAlphaAnimation);
        btnTranslateAnimation    = findViewById(R.id.btnTranslateAnimation);
        btnGroupAnimation        = findViewById(R.id.btnGroupAnimation);
        btnVisualizarBug         = findViewById(R.id.btnVisualizarBug);
        btnBug                   = findViewById(R.id.btnBug);

        visivel         = true;
        rotacaoOriginal = true;
        tamanhoOriginal = true;
        localOriginal   = true;

        btnScaleAnimation.setOnClickListener(this);
        btnRotateAnimation.setOnClickListener(this);
        btnAlphaAnimation.setOnClickListener(this);
        btnTranslateAnimation.setOnClickListener(this);
        btnGroupAnimation.setOnClickListener(this);
        btnVisualizarBug.setOnClickListener(this);
        btnBug.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btnScaleAnimation:
                //scaleAnimation();
                scaleAnimationXML();
                break;

            case R.id.btnRotateAnimation:
                //rotateAnimation();
                rotateAnimationXML();
                break;

            case R.id.btnAlphaAnimation:
                //alphaAnimation();
                alphaAnimationXML();
                break;

            case R.id.btnTranslateAnimation:
                //translateAnimation();
                translateAnimationXML();
                break;

            case R.id.btnGroupAnimation:
                //groupAnimation();
                groupAnimationXML();
                break;

            case R.id.btnVisualizarBug:
                Toast.makeText(this, "Clicou no botão!", Toast.LENGTH_SHORT).show();
                break;

            case R.id.btnBug:
                //groupAnimation();
                animaBotaoBug();
                break;

        }

    }

    // Metodo
    public void animaBotaoBug(){
        TranslateAnimation animation = new TranslateAnimation(
                Animation.RELATIVE_TO_SELF, 0.0f, Animation.RELATIVE_TO_SELF, 0.0f, // eixo x
                Animation.RELATIVE_TO_SELF, 0.0f, Animation.RELATIVE_TO_SELF, 1.5f // eixo y
        );

        // Duração da animação 2,5s
        animation.setDuration(2500);

        // Não voltar ao estado inicial
        animation.setFillAfter(true);

        // Executar
        btnVisualizarBug.startAnimation(animation);
    }

    /**
     * ANIMAÇÕES
     */
    // Agrupar animações
    public void groupAnimationXML(){
        Animation agrupar = AnimationUtils.loadAnimation(this, R.anim.set_todas_animacoes);
        imageViewAndroid.startAnimation(agrupar);
    }

    // Agrupar animações
    public void groupAnimation(){
        // Definir quais animações serão utilizadas
        AlphaAnimation fade_out = new AlphaAnimation(1.0f, 0.0f);

        ScaleAnimation diminuir = new ScaleAnimation(
                1.0f, 0.0f,
                1.0f, 0.0f,
                Animation.RELATIVE_TO_SELF, 0.5f,
                Animation.RELATIVE_TO_SELF, 0.5f
        );

        TranslateAnimation moverDireita = new TranslateAnimation(
                Animation.RELATIVE_TO_SELF, 0.0f, Animation.RELATIVE_TO_SELF, 1.5f, // eixo x
                Animation.RELATIVE_TO_SELF, 0.0f, Animation.RELATIVE_TO_SELF, 0.0f // eixo y
        );

        // Agrupar
        AnimationSet lista = new AnimationSet(true);
        lista.addAnimation(fade_out);
        lista.addAnimation(diminuir);
        lista.addAnimation(moverDireita);

        // Duracao
        lista.setDuration(3000);

        // Voltar ao estado original
        lista.setFillAfter(false);

        // Executar
        imageViewAndroid.startAnimation(lista);

    }

    // Vai de visivel a invisivel ou vice-versa
    public void alphaAnimationXML(){
        Animation animation = AnimationUtils.loadAnimation(this, R.anim.alpha_fade_out);
        imageViewAndroid.startAnimation(animation);
    }

    // Vai de visivel a invisivel ou vice-versa
    public void alphaAnimation(){
        // Onde mais proximo 1 torna a imagem visivel, Origem/Destino
        AlphaAnimation fade_out = new AlphaAnimation(1.0f, 0.0f);

        // Onde mais proximo de 0 torna a imagem insivel, Origem/Destino
        AlphaAnimation fade_in = new AlphaAnimation(0.0f, 1.0f);

        // Verificar visibilidade
        Animation animation = visivel ? fade_out : fade_in;

        // Duração da animação 2,5s
        animation.setDuration(2500);

        // Não voltar ao estado inicial
        animation.setFillAfter(true);

        // Executar
        imageViewAndroid.startAnimation(animation);

        // Alterar visibilidade
        visivel = false;
    }

    // Rotacionar imagem
    public void rotateAnimationXML(){
        Animation animation = AnimationUtils.loadAnimation(this, R.anim.rotate_girar);
        imageViewAndroid.startAnimation(animation);
    }

    // Rotacionar imagem
    public void rotateAnimation(){
        // Qual angulo irá girar, angulo inicial(0) até o angulo final
        // Qual eixo x vertical irá rotacionar 0.5f representa o centro
        // Qual eixo y horizontal irá rotacionar 0.5f representa o centro
        RotateAnimation girar = new RotateAnimation(
                0, 180,
                Animation.RELATIVE_TO_SELF, 0.5f,
                Animation.RELATIVE_TO_SELF, 0.5f);

        // Voltar
        RotateAnimation voltar = new RotateAnimation(
                180, 0,
                Animation.RELATIVE_TO_SELF, 0.5f,
                Animation.RELATIVE_TO_SELF, 0.5f);

        // Verificar visibilidade
        Animation animation = rotacaoOriginal ? girar : voltar;

        // Duração da animação 2,5s
        animation.setDuration(2500);

        // Não voltar ao estado inicial
        animation.setFillAfter(true);

        // Executar
        imageViewAndroid.startAnimation(animation);

        // Alterar visibilidade
        rotacaoOriginal = false;
    }

    // Escala da imagem
    public void scaleAnimationXML(){
        Animation animation = AnimationUtils.loadAnimation(this, R.anim.scale_animation);
        imageViewAndroid.startAnimation(animation);
    }

    // Escala da imagem
    public void scaleAnimation(){

        // Qual angulo irá girar, angulo inicial(0) até o angulo final
        // Qual eixo x vertical irá rotacionar 0.5f representa o centro
        // Qual eixo y horizontal irá rotacionar 0.5f representa o centro
        ScaleAnimation aumentar = new ScaleAnimation(
                0.0f, 1.0f,
                0.0f, 1.0f,
                Animation.RELATIVE_TO_SELF, 0.5f,
                Animation.RELATIVE_TO_SELF, 0.5f
        );

        // Diminuir
        ScaleAnimation diminuir = new ScaleAnimation(
                1.0f, 0.0f,
                1.0f, 0.0f,
                Animation.RELATIVE_TO_SELF, 0.5f,
                Animation.RELATIVE_TO_SELF, 0.5f
        );

        // Verificar visibilidade
        Animation animation = tamanhoOriginal ? diminuir : aumentar;

        // Duração da animação 2,5s
        animation.setDuration(2500);

        // Não voltar ao estado inicial
        animation.setFillAfter(true);

        // Executar
        imageViewAndroid.startAnimation(animation);

        // Alterar visibilidade
        tamanhoOriginal = false;
    }

    // Movimento, mover para a direita ou esquerda
    public void translateAnimationXML(){
        Animation animation = AnimationUtils.loadAnimation(this, R.anim.translate_mover_direita);
        imageViewAndroid.startAnimation(animation);
    }

    // Movimento, mover para a direita ou esquerda
    public void translateAnimation(){
        TranslateAnimation moverDireita = new TranslateAnimation(
                Animation.RELATIVE_TO_SELF, 0.0f, Animation.RELATIVE_TO_SELF, 1.5f, // eixo x
                Animation.RELATIVE_TO_SELF, 0.0f, Animation.RELATIVE_TO_SELF, 0.0f // eixo y
        );

        TranslateAnimation moverEsquerda = new TranslateAnimation(
                Animation.RELATIVE_TO_SELF, 1.0f, Animation.RELATIVE_TO_SELF, 0.0f, // eixo x
                Animation.RELATIVE_TO_SELF, 0.0f, Animation.RELATIVE_TO_SELF, 0.0f // eixo y
        );

        // Verificar visibilidade
        Animation animation = localOriginal ? moverDireita : moverEsquerda;

        // Duração da animação 2,5s
        animation.setDuration(2500);

        // Não voltar ao estado inicial
        animation.setFillAfter(true);

        // Executar
        imageViewAndroid.startAnimation(animation);

        // Alterar visibilidade
        localOriginal = false;
    }
}