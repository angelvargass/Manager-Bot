package com.hispanicpvp.hispanicmanagerbot.dao.kick;

import com.hispanicpvp.hispanicmanagerbot.models.KickModel;

import java.util.List;

public interface DaoKick {

    void register(KickModel kick);

    KickModel retrieveById(KickModel kick);

    List<KickModel> retrieveAll();
}
