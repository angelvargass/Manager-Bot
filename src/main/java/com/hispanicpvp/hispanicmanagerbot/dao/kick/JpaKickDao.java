package com.hispanicpvp.hispanicmanagerbot.dao.kick;

import com.hispanicpvp.hispanicmanagerbot.dao.ban.JpaBanDao;
import com.hispanicpvp.hispanicmanagerbot.jpautil.JPAUtil;
import com.hispanicpvp.hispanicmanagerbot.logger.Logger;
import com.hispanicpvp.hispanicmanagerbot.models.KickModel;


import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import java.util.List;

public class JpaKickDao implements DaoKick {
    private final Logger logger = new Logger(JpaBanDao.class);
    private EntityManager em;
    private EntityTransaction et;

    @Override
    public void register(KickModel kick) {
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
    public KickModel retrieveById(KickModel kick) {
        em = JPAUtil.getEntityManagerFactory().createEntityManager();
        return em.find(KickModel.class, kick);
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<KickModel> retrieveAll() {
        em = JPAUtil.getEntityManagerFactory().createEntityManager();
        return em.createQuery("FROM TBL_KICK").getResultList();
    }
}
