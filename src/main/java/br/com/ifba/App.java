package br.com.ifba;

import br.com.ifba.curso.view.CursoListar;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App {

    public static void main(String[] args) {

        // inicia o container Spring
        ApplicationContext context =
                new AnnotationConfigApplicationContext("br.com.ifba");

        // pega a tela gerenciada pelo Spring
        CursoListar tela =
                context.getBean(CursoListar.class);

        // mostra a tela
        tela.setVisible(true);
    }
}