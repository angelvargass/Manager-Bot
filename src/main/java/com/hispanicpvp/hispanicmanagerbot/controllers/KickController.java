package com.hispanicpvp.hispanicmanagerbot.controllers;

import com.hispanicpvp.hispanicmanagerbot.dao.kick.JpaKickDao;
import com.hispanicpvp.hispanicmanagerbot.models.KickModel;
import net.dv8tion.jda.api.entities.Member;

import java.time.LocalDate;

public class KickController {

    private JpaKickDao jpaKickDao;

    public KickController() {
        jpaKickDao = new JpaKickDao();
    }

    public void register(Member author, Member mentionedMember) {
        KickModel kick = new KickModel();
        kick.setKickedUser(mentionedMember.getEffectiveName());
        kick.setStaffName(author.getEffectiveName());
        kick.setDate(LocalDate.now());
        jpaKickDao.register(kick);
    }
}
