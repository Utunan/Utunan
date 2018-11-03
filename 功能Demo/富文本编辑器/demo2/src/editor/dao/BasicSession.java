package editor.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;


public class BasicSession {
    public  SessionFactory getSession(){
        StandardServiceRegistryBuilder srb= new StandardServiceRegistryBuilder();
        StandardServiceRegistry sr=srb.configure().build();

        SessionFactory sf=new MetadataSources(sr).buildMetadata().buildSessionFactory();


        return sf;
    }
    public void close(Session s, SessionFactory sf){
        Transaction tra=s.beginTransaction();
        tra.commit();
        s.close();
        sf.close();
    }
}
