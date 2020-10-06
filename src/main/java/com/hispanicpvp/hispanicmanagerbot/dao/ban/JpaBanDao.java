package com.hispanicpvp.hispanicmanagerbot.dao.ban;

import com.hispanicpvp.hispanicmanagerbot.jpautil.JPAUtil;
import com.hispanicpvp.hispanicmanagerbot.models.Ban;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import java.util.List;

public class JpaBanDao implements DaoBan {

    static final Logger logger = LoggerFactory.getLogger(JpaBanDao.class);
    private EntityManager em;
    private EntityTransaction et;

    @Override
    public void register(Ban ban) {
        em = JPAUtil.getEntityManagerFactory().createEntityManager();
        et = em.getTransaction();

        try {
            et.begin();
            em.persist(ban);
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
    public Ban retrieveById(Ban ban) {
        em = JPAUtil.getEntityManagerFactory().createEntityManager();
        return em.find(Ban.class, ban);
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Ban> retrieveAll() {
        em = JPAUtil.getEntityManagerFactory().createEntityManager();
        return em.createQuery("FROM TBL_BAN").getResultList();
    }
}
