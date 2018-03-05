package dao;

import entity.Prava;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class PravoDao 
{
    private static Session session = null;
    
    public static Prava vratiPravoPoId(int id)
    {
         session = HibernateUtil.getSessionFactory().openSession();
        Transaction trans = null;
        Prava pravo = null;
        try 
        {
            trans = session.beginTransaction();
            pravo = (Prava)session.get(Prava.class, id);
            trans.commit();
            
        } 
        catch (Exception e) 
        {
            if(trans != null) {
                trans.rollback();  
            }
            System.out.println(e);
        }
        
        return pravo;
    }
    
}
