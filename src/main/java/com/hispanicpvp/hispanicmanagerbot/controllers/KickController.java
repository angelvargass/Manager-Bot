package com.hispanicpvp.hispanicmanagerbot.controllers;

import com.hispanicpvp.hispanicmanagerbot.dao.kick.JpaKickDao;
import com.hispanicpvp.hispanicmanagerbot.models.Kick;

public class KickController {

    private JpaKickDao jpaKickDao;

    public KickController() {
        jpaKickDao = new JpaKickDao();
    }

    public void register(Kick kick) {
        jpaKickDao.register(kick);
    }
}
