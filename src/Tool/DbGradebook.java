package Tool;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

import model.Gradebook;

public class DbGradebook {

    public static void insert(Gradebook gradebook) {
		EntityManager em = DbUtil.getEmFactory().createEntityManager();
		EntityTransaction trans = em.getTransaction();
		// System.out.println("DbBullhorn: begin transaction");
		try {
			trans.begin();
			em.persist(gradebook);
			// System.out.println("DbBullhorn: commit transaction");
			trans.commit();
		} catch (Exception e) {
			e.printStackTrace();
			// System.out.println("DbBullhorn: rollback transaction");
			trans.rollback();
		} finally {
			// System.out.println("DbBullhorn: close em");
			em.close();
		}
	
       
    }

    public static void update(Gradebook gradebook) {
		EntityManager em = DbUtil.getEmFactory().createEntityManager();
		EntityTransaction trans = em.getTransaction();
		try {
			trans.begin();
			em.merge(gradebook);
			trans.commit();
		} catch (Exception e) {
			System.out.println(e);
			trans.rollback();
		} finally {
			em.close();
		}
	
      
    }

    public static void delete(Gradebook gradebook) {
		EntityManager em = DbUtil.getEmFactory().createEntityManager();
		EntityTransaction trans = em.getTransaction();
		try {
			trans.begin();
			em.remove(em.merge(gradebook));
			trans.commit();
		} catch (Exception e) {
			System.out.println(e);
			trans.rollback();
		} finally {
			em.close();
		}
	
        
    }

    public static List<Gradebook> gradebook (){
        EntityManager em = DbUtil.getEmFactory().createEntityManager();
        String qString = "select b from Gradebook b";
        
        List<Gradebook> posts = null;
        try{
            TypedQuery<Gradebook> query = em.createQuery(qString,Gradebook.class);
            posts = query.getResultList();

        }catch (Exception e){
            e.printStackTrace();
        }
        finally{
                em.close();
            }
        return posts;
    }
    
    public static Gradebook gradebook (Integer gradebookid){
        EntityManager em = DbUtil.getEmFactory().createEntityManager();
        String qString = "select b from Gradebook b where b.gradebookid =:gradebookid";
        
        Gradebook posts = null;
        try{
            TypedQuery<Gradebook> query = em.createQuery(qString,Gradebook.class);
            query.setParameter("gradebookid", gradebookid);
            posts = query.getSingleResult();

        }catch (Exception e){
            e.printStackTrace();
        }
        finally{
                em.close();
            }
        return posts;
    }
    
    public static List<Gradebook> gradesofUser(long userid)
    {
        EntityManager em = DbUtil.getEmFactory().createEntityManager();
        List<Gradebook> userposts = null;
        String qString = "select b from Gradebook b where b.bhuser.bhuserid = :userid";
        
        try{
            TypedQuery<Gradebook> query = em.createQuery(qString,Gradebook.class);
            query.setParameter("userid", userid);
            userposts = query.getResultList();
        }catch (Exception e){
            e.printStackTrace();
        }
        finally{
                em.close();
            }
        return userposts;    
    }
    public static List<Gradebook> gradesofUser(String useremail)
    {
        EntityManager em = DbUtil.getEmFactory().createEntityManager();
        List<Gradebook> userposts = null;
        String qString = "select b from Gradebook b "
                + "where b.bhuser.useremail = :useremail";
        
        try{
            TypedQuery<Gradebook> query = em.createQuery(qString,Gradebook.class);
            query.setParameter("useremail", useremail);
            userposts = query.getResultList();
        }catch (Exception e){
            e.printStackTrace();
        }
        finally{
                em.close();
            }
        return userposts;    
    }
    
    public static List<Gradebook> searchPosts (String search)
    {
        EntityManager em = DbUtil.getEmFactory().createEntityManager();
        List<Gradebook> searchposts = null;
        String qString = "select b from Gradebook b "
                + "where b.posttext like :search";
        
        try{
            TypedQuery<Gradebook> query = em.createQuery(qString,Gradebook.class);
            query.setParameter("search", "%" + search + "%");
            searchposts = query.getResultList();
        }catch (Exception e){
            e.printStackTrace();
        }finally{
            em.close();
        }return searchposts;
    }
    
}
