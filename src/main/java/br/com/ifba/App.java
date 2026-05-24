package br.com.ifba;

import br.com.ifba.config.SpringConfig;
import br.com.ifba.curso.view.CursoListar;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App {

    public static AnnotationConfigApplicationContext context;

    public static void main(String[] args) {

        context =
                new AnnotationConfigApplicationContext(SpringConfig.class);

        CursoListar tela =
                context.getBean(CursoListar.class);
        tela.inicializar();
        tela.setVisible(true);
    }
}