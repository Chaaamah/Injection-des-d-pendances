package pres;

import dao.IDao;
import metier.IMetier;

import java.io.File;
import java.lang.reflect.Method;
import java.util.Scanner;

public class Presentation2 {
    public static void main(String[] args) throws Exception{
        Scanner scanner = new Scanner(new File("config.txt"));

        String daoClassName = scanner.nextLine(); // Connaitre le nom de la classe
        Class cDao = Class.forName(daoClassName); // Charger la classe au memoire
        IDao dao = (IDao) cDao.newInstance(); // Instancier la classe = (newInstance creer un objet d'une classe : dynamique)

        //System.out.println(dao.getData());

        String metierClassName = scanner.nextLine(); // Charger la classe metier
        Class cMetier = Class.forName(metierClassName);
        IMetier metier = (IMetier) cMetier.newInstance();

        Method method = cMetier.getMethod("setDao", IDao.class);
        // metier.setDao(dao);
        method.invoke(metier, dao);

        System.out.println("Resultat => " +metier.calcul());
    }
}

