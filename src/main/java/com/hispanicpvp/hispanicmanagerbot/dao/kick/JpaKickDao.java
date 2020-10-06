package com.hispanicpvp.hispanicmanagerbot.dao.kick;

import com.hispanicpvp.hispanicmanagerbot.jpautil.JPAUtil;
import com.hispanicpvp.hispanicmanagerbot.models.Kick;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import java.util.List;

public class JpaKickDao implements DaoKick {
    static final Logger logger = LoggerFactory.getLogger(JpaKickDao.class);
    private EntityManager em;
    private EntityTransaction et;

    @Override
    public void register(Kick kick) {
        em = JPAUtil.getEntityManagerFactory().createEntityManager();
        et = em.getTransaction();

        try {
            et.begin();
            em.persist(kick);
            et.commit();
        } catch (Exception e) {
            if(et != null) {
                et.rollback();
            }
            logger.error("JPA Error: " + e.getMessage());
        } finally {
            em.close();
        }
    }

    @Override
    public Kick retrieveById(Kick kick) {
        em = JPAUtil.getEntityManagerFactory().createEntityManager();
        return em.find(Kick.class, kick);
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Kick> retrieveAll() {
        em = JPAUtil.getEntityManagerFactory().createEntityManager();
        return em.createQuery("FROM TBL_KICK").getResultList();
    }
}
