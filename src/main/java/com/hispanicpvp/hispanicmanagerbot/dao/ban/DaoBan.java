package com.hispanicpvp.hispanicmanagerbot.dao.ban;

import com.hispanicpvp.hispanicmanagerbot.models.Ban;

import java.util.List;

public interface DaoBan {

    void register(Ban ban);

    Ban retrieveById(Ban ban);

    List<Ban> retrieveAll();
}
