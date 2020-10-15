package com.hispanicpvp.hispanicmanagerbot.dao.ban;

import com.hispanicpvp.hispanicmanagerbot.models.BanModel;

import java.util.List;

public interface DaoBan {

    void register(BanModel ban);

    BanModel retrieveById(BanModel ban);

    List<BanModel> retrieveAll();
}
