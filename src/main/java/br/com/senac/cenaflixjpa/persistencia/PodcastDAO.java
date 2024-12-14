package br.com.senac.cenaflixjpa.persistencia;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import java.util.List;
import javax.swing.JTable;


public class PodcastDAO {
    private JTable tblPodcast;
    
    //Construtores
    public PodcastDAO(){
    }
    
    public PodcastDAO(JTable tblPodcast){
        this.tblPodcast = tblPodcast;
    }
    
    //Método para cadastrar
    public void cadastrar(Podcast p){
        EntityManager em = JPAUtil.getEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(p);
            em.getTransaction().commit();
        }catch(Exception e){
            em.getTransaction().rollback();
            throw e;
        }
        finally{
            JPAUtil.closeEntityManager();
        }
    }
    
    //Método para listar
    public List<Podcast> listar() {
        EntityManager em = JPAUtil.getEntityManager();
    
        try {
            Query consulta = em.createQuery("SELECT p FROM Podcast p"); 
            List<Podcast> podcasts = consulta.getResultList();
            return podcasts;
        } finally {
            em.close(); 
        }
    }
    
    // Método para excluir registros
    public void excluir(String produtor) {
        EntityManager em = JPAUtil.getEntityManager();
    
        try {
            em.getTransaction().begin();
        
            Podcast p = em.createQuery("SELECT p FROM Podcast p WHERE p.produtor = :produtor", Podcast.class)
                       .setParameter("produtor", produtor)
                       .getSingleResult();

            if (p != null) {
                em.remove(p);
                em.getTransaction().commit();
            }    
        } catch (Exception e) {
            em.getTransaction().rollback();
            throw e;
        } finally {
            JPAUtil.closeEntityManager();
        }
    }
    
    //Método para pesquisar pelo produtor
    public List<Podcast> pesquisar(String produtor) {
        EntityManager em = JPAUtil.getEntityManager();
    
        try {
            Query consulta = em.createQuery("SELECT p FROM Podcast p WHERE p.produtor LIKE :produtor");
            consulta.setParameter("produtor", "%" + produtor + "%");
            List<Podcast> podcasts = consulta.getResultList();
            return podcasts;
        } finally {
            em.close(); 
        }
    }
}
