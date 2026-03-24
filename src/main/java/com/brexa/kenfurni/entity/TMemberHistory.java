package com.brexa.kenfurni.entity;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

/**
 * 会員購入履歴エンティティ
 *
 * @author BREXA Technology
 * @version 1.0
 */
@Entity
@Table(name = "t_member_history")
public class TMemberHistory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "purchase_id")
    private Integer purchaseId;

    @Column(name = "member_id")
    private Integer memberId;

    @Column(name = "used_point")
    private Integer usedPoint;

    @Column(name = "total_amount")
    private Integer totalAmount;

    @Column(name = "used_point_total_amount")
    private Integer usedPointTotalAmount;

    @Column(name = "cancel_flag")
    private String cancelFlag;

    @Column(name = "purchase_day")
    private LocalDate purchaseDay;

    @Column(name = "sent_day")
    private LocalDate sentDay;

    @Column(name = "cancel_day")
    private LocalDate cancelDay;

    @Column(name = "valid_flag")
    private String validFlag;

    public Integer getPurchaseId() { return purchaseId; }
    public void setPurchaseId(Integer purchaseId) { this.purchaseId = purchaseId; }

    public Integer getMemberId() { return memberId; }
    public void setMemberId(Integer memberId) { this.memberId = memberId; }

    public Integer getUsedPoint() { return usedPoint; }
    public void setUsedPoint(Integer usedPoint) { this.usedPoint = usedPoint; }

    public Integer getTotalAmount() { return totalAmount; }
    public void setTotalAmount(Integer totalAmount) { this.totalAmount = totalAmount; }

    public Integer getUsedPointTotalAmount() { return usedPointTotalAmount; }
    public void setUsedPointTotalAmount(Integer usedPointTotalAmount) { this.usedPointTotalAmount = usedPointTotalAmount; }

    public String getCancelFlag() { return cancelFlag; }
    public void setCancelFlag(String cancelFlag) { this.cancelFlag = cancelFlag; }

    public LocalDate getPurchaseDay() { return purchaseDay; }
    public void setPurchaseDay(LocalDate purchaseDay) { this.purchaseDay = purchaseDay; }

    public LocalDate getSentDay() { return sentDay; }
    public void setSentDay(LocalDate sentDay) { this.sentDay = sentDay; }

    public LocalDate getCancelDay() { return cancelDay; }
    public void setCancelDay(LocalDate cancelDay) { this.cancelDay = cancelDay; }

    public String getValidFlag() { return validFlag; }
    public void setValidFlag(String validFlag) { this.validFlag = validFlag; }
}