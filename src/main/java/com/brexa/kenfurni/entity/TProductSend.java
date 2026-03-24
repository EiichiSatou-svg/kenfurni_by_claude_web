package com.brexa.kenfurni.entity;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

/**
 * 発送エンティティ
 *
 * @author BREXA Technology
 * @version 1.0
 */
@Entity
@Table(name = "t_product_send")
public class TProductSend {

    @Id
    @Column(name = "purchase_id")
    private Integer purchaseId;

    @Column(name = "member_id")
    private Integer memberId;

    @Column(name = "purchase_day")
    private LocalDate purchaseDay;

    @Column(name = "member_payment")
    private String memberPayment;

    @Column(name = "designation")
    private String designation;

    @Column(name = "send_schedule_day")
    private LocalDate sendScheduleDay;

    @Column(name = "sent_day")
    private LocalDate sentDay;

    public Integer getPurchaseId() { return purchaseId; }
    public void setPurchaseId(Integer purchaseId) { this.purchaseId = purchaseId; }

    public Integer getMemberId() { return memberId; }
    public void setMemberId(Integer memberId) { this.memberId = memberId; }

    public LocalDate getPurchaseDay() { return purchaseDay; }
    public void setPurchaseDay(LocalDate purchaseDay) { this.purchaseDay = purchaseDay; }

    public String getMemberPayment() { return memberPayment; }
    public void setMemberPayment(String memberPayment) { this.memberPayment = memberPayment; }

    public String getDesignation() { return designation; }
    public void setDesignation(String designation) { this.designation = designation; }

    public LocalDate getSendScheduleDay() { return sendScheduleDay; }
    public void setSendScheduleDay(LocalDate sendScheduleDay) { this.sendScheduleDay = sendScheduleDay; }

    public LocalDate getSentDay() { return sentDay; }
    public void setSentDay(LocalDate sentDay) { this.sentDay = sentDay; }
}