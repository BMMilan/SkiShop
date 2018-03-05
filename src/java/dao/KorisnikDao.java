package dao; 

import entity.Kategorija;
import entity.Korisnik;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class KorisnikDao {
    private static Session session = null;
    
    public static Korisnik sviKorisnici(String email)
    {
        session = HibernateUtil.getSessionFactory().openSession();
        Transaction trans = null;
        Korisnik k = null;
        try 
        {
            trans = session.beginTransaction();
            Query query = session.createQuery("from Korisnik where email=:email").setString("email", email);
            if(query.list().size()>0){
                k = (Korisnik)query.list().get(0);
            }
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
        return k;
    }
    public static Korisnik ubaciKorisnika(Korisnik korisnik)
    {
        session = HibernateUtil.getSessionFactory().openSession();
        Transaction trans = null;
        try 
        {
            trans = session.beginTransaction();
            session.persist(korisnik);
            trans.commit();
        } 
        catch (Exception e) 
        {
            if(trans != null) {
                trans.rollback();  
            }
            System.out.println(e);
        }
        return korisnik;
    }
   public static Korisnik logovanKorisnik(String email)
    {
        session = HibernateUtil.getSessionFactory().openSession();
        Transaction trans = null;
        Korisnik pom = null;
        try 
        {
            trans = session.beginTransaction();
            Query query = session.createQuery("from Korisnik where email = :podatak");
            query.setParameter("podatak", email);
            pom = (Korisnik)query.list().get(0);
        } 
        catch (Exception e) 
        {
            if(trans != null) {
                trans.rollback();  
            }
            System.out.println(e);
        }
        return pom;
    }
     public static boolean proveraKorisnickogImena(String email)
    {
        session = HibernateUtil.getSessionFactory().openSession();
        Transaction trans = null;
        try 
        {
            trans = session.beginTransaction();
            Query query = session.createQuery("from Korisnik where email = :podatak");
            query.setParameter("podatak", email);
            if(query.list().isEmpty()) return false; 
        } 
        catch (Exception e) 
        {
            if(trans != null) {
                trans.rollback();  
            }
            System.out.println(e);
        }
        return true;
    }
     public static List<Korisnik> sviKorisnici()
    {
        session = HibernateUtil.getSessionFactory().openSession();
        Transaction trans = null;
        List<Korisnik> pomocna = null;
        try 
        {
            trans = session.beginTransaction();
            Query query = session.createQuery("from Korisnik k join fetch k.prava p where p.pravaId = :id ");
            query.setParameter("id", 2);
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
        return pomocna;
    }
     public static Korisnik vratiKorisnikaPoId(int id)
    {
        session = HibernateUtil.getSessionFactory().openSession();
        Transaction trans = null;
        Korisnik pom = null;
        try 
        {
            trans = session.beginTransaction();
            pom = (Korisnik)session.get(Korisnik.class, id);
            trans.commit();
        }
        catch (Exception e) 
        {
            if(trans != null) {
                trans.rollback();  
            }
            System.out.println(e);
        }
        return pom;
    }
    public static  void closeSession(){
        if(session != null)
            session.close();
        
    }
    
}
