package com.hispanicpvp.hispanicmanagerbot.models;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table(name = "TBL_BAN")
public class Ban {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(name = "STAFF_NAME", length = 32)
    private String staffName;

    @Column(name = "BANNED_USER", length = 32)
    private String bannedUser;

    @Column(name = "REASON", nullable = true)
    private String reason;

    @Column(name = "BANNED_DAYS")
    private int bannedDays;

    @Column(name = "DATE")
    private LocalDate date;

    public Ban() {}

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getStaffName() {
        return staffName;
    }

    public void setStaffName(String staffName) {
        this.staffName = staffName;
    }

    public String getBannedUser() {
        return bannedUser;
    }

    public void setBannedUser(String bannedUser) {
        this.bannedUser = bannedUser;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public int getBannedDays() {
        return bannedDays;
    }

    public void setBannedDays(int bannedDays) {
        this.bannedDays = bannedDays;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }
}
