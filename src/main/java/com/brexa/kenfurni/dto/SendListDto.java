package com.brexa.kenfurni.dto;

import java.time.LocalDate;

/**
 * 発送一覧DTO
 *
 * @author BREXA Technology
 * @version 1.0
 */
public class SendListDto {

    private Integer purchaseId;
    private String memberName;
    private LocalDate purchaseDay;
    private String memberPayment;
    private LocalDate sendScheduleDay;
    private LocalDate sentDay;

    public SendListDto(Integer purchaseId, String memberName, LocalDate purchaseDay,
            String memberPayment, LocalDate sendScheduleDay, LocalDate sentDay) {
        this.purchaseId = purchaseId;
        this.memberName = memberName;
        this.purchaseDay = purchaseDay;
        this.memberPayment = memberPayment;
        this.sendScheduleDay = sendScheduleDay;
        this.sentDay = sentDay;
    }

    public Integer getPurchaseId() { return purchaseId; }
    public String getMemberName() { return memberName; }
    public LocalDate getPurchaseDay() { return purchaseDay; }
    public String getMemberPayment() { return memberPayment; }
    public LocalDate getSendScheduleDay() { return sendScheduleDay; }
    public LocalDate getSentDay() { return sentDay; }
}