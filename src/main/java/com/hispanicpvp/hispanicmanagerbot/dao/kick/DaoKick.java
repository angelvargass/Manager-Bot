package com.hispanicpvp.hispanicmanagerbot.dao.kick;

import com.hispanicpvp.hispanicmanagerbot.models.Kick;

import java.util.List;

public interface DaoKick {

    void register(Kick kick);

    Kick retrieveById(Kick kick);

    List<Kick> retrieveAll();
}
