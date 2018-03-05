package dao;

import entity.Brend;
import entity.Kategorija;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class KategorijeDao {
    private static Session session = null;
    
    public static List<Kategorija> sveKategorije()
    {
        session = HibernateUtil.getSessionFactory().openSession();
        Transaction trans = null;
        List<Kategorija> pomocna = null;
        try 
        {
            trans = session.beginTransaction();
            Query query = session.createQuery("from Kategorija");
            pomocna = query.list();
            trans.commit();
        } 
        catch (Exception e) 
        {
            if(trans != null) {
                trans.rollback();  
            }
            System.out.println(e);
        }
        finally
        {
           if(session != null)
            session.close(); 
        }
        return pomocna;
    }
    public static Kategorija KategorijaPoId(int id)
    {
        session = HibernateUtil.getSessionFactory().openSession();
        Transaction trans = null;
        Kategorija kat = null;
        try 
        {
            trans = session.beginTransaction();
            kat = (Kategorija)session.get(Kategorija.class, id);
            trans.commit();
        } 
        catch (Exception e) 
        {
            if(trans != null) {
                trans.rollback();  
            }
            System.out.println(e);
        }
        finally
        {
           if(session != null)
            session.close(); 
        }
        return kat;
    }
    
}
