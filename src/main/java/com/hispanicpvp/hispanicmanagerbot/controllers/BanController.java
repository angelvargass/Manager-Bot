package com.hispanicpvp.hispanicmanagerbot.controllers;

import com.hispanicpvp.hispanicmanagerbot.dao.ban.JpaBanDao;
import com.hispanicpvp.hispanicmanagerbot.models.Ban;

public class BanController {
    JpaBanDao jpaBanDao;

    public BanController() {
        this.jpaBanDao = new JpaBanDao();
    }

    public void register(Ban ban) {
        jpaBanDao.register(ban);
    }
}
