package com.hispanicpvp.hispanicmanagerbot.dao.ban;

import com.hispanicpvp.hispanicmanagerbot.jpautil.JPAUtil;
import com.hispanicpvp.hispanicmanagerbot.logger.Logger;
import com.hispanicpvp.hispanicmanagerbot.models.BanModel;


import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import java.util.List;

public class JpaBanDao implements DaoBan {

    private final Logger logger = new Logger(JpaBanDao.class);
    private EntityManager em;
    private EntityTransaction et;

    @Override
    public void register(BanModel ban) {
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
    public BanModel retrieveById(BanModel ban) {
        em = JPAUtil.getEntityManagerFactory().createEntityManager();
        return em.find(BanModel.class, ban);
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<BanModel> retrieveAll() {
        em = JPAUtil.getEntityManagerFactory().createEntityManager();
        return em.createQuery("FROM TBL_BAN").getResultList();
    }
}
