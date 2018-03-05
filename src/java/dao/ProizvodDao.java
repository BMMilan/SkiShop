package dao; 

import entity.Brend;
import entity.Porudzbina;
import entity.Proizvod;
import entity.Stavka;
import java.math.BigDecimal;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class ProizvodDao {
    
    private static Session session = null;
    
    public static List<Proizvod> sviProizvodiJedneKategorije(String kategorija)
    {
        session = HibernateUtil.getSessionFactory().openSession();
        Transaction trans = null;
        List<Proizvod> pomocna = null;
        try 
        {
            trans = session.beginTransaction();
            Query query = session
                    .createQuery("from Proizvod p join fetch p.kategorija pk where pk.kategorija= :kategorija")
                    .setString("kategorija", kategorija);
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
    public static List<Proizvod> sviProizvodi()
    {
        session = HibernateUtil.getSessionFactory().openSession();
        Transaction trans = null;
        List<Proizvod> pomocna = null;
        try 
        {
            trans = session.beginTransaction();
            Query query = session.createQuery("from Proizvod");
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
    public static Proizvod proizvodPoId(int id)
    {
        session = HibernateUtil.getSessionFactory().openSession();
        Transaction trans = null;
        Proizvod proz = null;
        try 
        {
            trans = session.beginTransaction();
            proz = (Proizvod)session.get(Proizvod.class, id);
            trans.commit();
        } 
        catch (Exception e) 
        {
            if(trans != null) {
                trans.rollback();  
            }
            System.out.println(e);
        }
        return proz;
    }
    public static Brend sviBrendoviPoId(int id)
    {
        session = HibernateUtil.getSessionFactory().openSession();
        Transaction trans = null;
        Brend brend = null;
        try 
        {
            trans = session.beginTransaction();
            brend = (Brend)session.get(Brend.class, id);
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
        return brend;
    }
    
    public static Porudzbina insertPorudzbina(Porudzbina porudzbina)
    {
        session = HibernateUtil.getSessionFactory().openSession();
        Transaction trans = null;
        try 
        {
            trans = session.beginTransaction();
            session.persist(porudzbina);
            trans.commit();
            
        } 
        catch (Exception e) 
        {
            if(trans != null) {
                trans.rollback();  
            }
            System.out.println(e);
        }
        return porudzbina;
    }
    public static void insertStavke(Stavka stavka)
    {
        session = HibernateUtil.getSessionFactory().openSession();
        Transaction trans = null;
        try 
        {
            trans = session.beginTransaction();
            session.persist(stavka);
            trans.commit();
            
        } 
        catch (Exception e) 
        {
            if(trans != null) {
                trans.rollback();  
            }
            System.out.println(e);
        }
    }
    public static Porudzbina selectPoruzbina(int id)
    {
        session = HibernateUtil.getSessionFactory().openSession();
        Transaction trans = null;
        Porudzbina poruzbina = null;
        try 
        {
            trans = session.beginTransaction();
            poruzbina = (Porudzbina)session.get(Porudzbina.class, id);
            trans.commit();
            
        } 
        catch (Exception e) 
        {
            if(trans != null) {
                trans.rollback();  
            }
            System.out.println(e);
        }
        
        return poruzbina;
    }
    
    public static List<Brend> sviBrendovi()
    {
        session = HibernateUtil.getSessionFactory().openSession();
        Transaction trans = null;
        List<Brend> pomocna = null;
        try 
        {
            trans = session.beginTransaction();
            Query query = session.createQuery("from Brend");
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
    public static void insertProizvod(Proizvod proizvod)
    {
        session = HibernateUtil.getSessionFactory().openSession();
        Transaction trans = null;
        try 
        {
            trans = session.beginTransaction();
            session.persist(proizvod);
            trans.commit();
            
        } 
        catch (Exception e) 
        {
            if(trans != null) {
                trans.rollback();  
            }
            System.out.println(e);
        }
    }
     public static void updateCenuProizvoda(int id,BigDecimal cena)
    {
        session = HibernateUtil.getSessionFactory().openSession();
        Transaction trans = null;
        try 
        {
            trans = session.beginTransaction();
            Proizvod pom = (Proizvod)session.get(Proizvod.class, id);
            pom.setCena(cena);
            session.merge(pom);
            trans.commit();
            
        } 
        catch (Exception e) 
        {
            if(trans != null) {
                trans.rollback();  
            }
            System.out.println(e);
        }
    }
    
    public static void updateDimezijeProizvod(int id,String dimenzije)
    {
        session = HibernateUtil.getSessionFactory().openSession();
        Transaction trans = null;
        try 
        {
            trans = session.beginTransaction();
            Proizvod pom = (Proizvod)session.get(Proizvod.class, id);
            pom.setVelicina(dimenzije.trim());
            session.merge(pom);
            trans.commit();
            
        } 
        catch (Exception e) 
        {
            if(trans != null) {
                trans.rollback();  
            }
            System.out.println(e);
        }
    }
    
    public static void updateNazivProizvod(int id,String Naziv)
    {
        session = HibernateUtil.getSessionFactory().openSession();
        Transaction trans = null;
        try 
        {
            trans = session.beginTransaction();
            Proizvod pom = (Proizvod)session.get(Proizvod.class, id);
            pom.setNazivProizvoda(Naziv.trim());
            session.merge(pom);
            trans.commit();
            
        } 
        catch (Exception e) 
        {
            if(trans != null) {
                trans.rollback();  
            }
            System.out.println(e);
        }
    }
    
    
    public static  void closeSession(){
        if(session != null)
            session.close();
        
    }
    
}
