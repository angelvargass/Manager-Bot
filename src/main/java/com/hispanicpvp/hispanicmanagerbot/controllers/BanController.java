package com.hispanicpvp.hispanicmanagerbot.controllers;

import com.hispanicpvp.hispanicmanagerbot.dao.ban.JpaBanDao;
import com.hispanicpvp.hispanicmanagerbot.models.BanModel;
import net.dv8tion.jda.api.entities.Member;

import java.time.LocalDate;

public class BanController {
    JpaBanDao jpaBanDao;

    public BanController() {
        this.jpaBanDao = new JpaBanDao();
    }

    public void register(Member author, Member mentionedMember, int days) {
        BanModel ban = new BanModel();
        ban.setBannedDays(days);
        ban.setBannedUser(mentionedMember.getEffectiveName());
        ban.setStaffName(author.getEffectiveName());
        ban.setDate(LocalDate.now());
        jpaBanDao.register(ban);
    }
}
