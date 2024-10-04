package dao;

import org.springframework.stereotype.Component;

@Component("dao")
public class DaoImp implements IDao{
    @Override
    public double getData() {
        /*
        * Se connecter a la abase de donnees pour recuperer la temperature
        * */
        System.out.println("Version base de donnees");
        double temp = Math.random() * 40;
        return temp;
    }
}
