package com.hispanicpvp.hispanicmanagerbot.models;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table(name = "TBL_KICK")
public class Kick {

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(name = "STAFF_NAME" , length = 32)
    private String staffName;

    @Column(name = "KICKED_USER", length = 32)
    private String kickedUser;

    @Column(name = "REASON", nullable = true, length = 100)
    private String reason;

    @Column(name = "DATE")
    private LocalDate date;

    public Kick() {}

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

    public String getKickedUser() {
        return kickedUser;
    }

    public void setKickedUser(String kickedUser) {
        this.kickedUser = kickedUser;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }
}
