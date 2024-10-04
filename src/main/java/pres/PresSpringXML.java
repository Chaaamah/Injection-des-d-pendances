package pres;

import metier.IMetier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class PresSpringXML {
    public static void main(String[] args) {
        // Chargement du contexte Spring via le fichier XML
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        IMetier metier = (IMetier) context.getBean("metier");

        System.out.println("Résultat : " + metier.calcul());
    }
}
