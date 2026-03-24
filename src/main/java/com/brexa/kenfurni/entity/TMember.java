package com.brexa.kenfurni.entity;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

/**
 * 会員エンティティ
 *
 * @author BREXA Technology
 * @version 1.0
 */
@Entity
@Table(name = "t_member")
public class TMember {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "member_id")
    private Integer memberId;

    @Column(name = "member_mail")
    private String memberMail;

    @Column(name = "member_password")
    private String memberPassword;

    @Column(name = "member_name")
    private String memberName;

    @Column(name = "member_kana")
    private String memberKana;

    @Column(name = "member_post")
    private String memberPost;

    @Column(name = "member_address")
    private String memberAddress;

    @Column(name = "member_phone")
    private String memberPhone;

    @Column(name = "member_birthday")
    private LocalDate memberBirthday;

    @Column(name = "member_payment")
    private String memberPayment;

    @Column(name = "member_point")
    private Integer memberPoint;

    @Column(name = "signup_day")
    private LocalDate signupDay;

    @Column(name = "withdrawal_day")
    private LocalDate withdrawalDay;

    @Column(name = "valid_flag")
    private String validFlag;

    public Integer getMemberId() { return memberId; }
    public void setMemberId(Integer memberId) { this.memberId = memberId; }

    public String getMemberMail() { return memberMail; }
    public void setMemberMail(String memberMail) { this.memberMail = memberMail; }

    public String getMemberPassword() { return memberPassword; }
    public void setMemberPassword(String memberPassword) { this.memberPassword = memberPassword; }

    public String getMemberName() { return memberName; }
    public void setMemberName(String memberName) { this.memberName = memberName; }

    public String getMemberKana() { return memberKana; }
    public void setMemberKana(String memberKana) { this.memberKana = memberKana; }

    public String getMemberPost() { return memberPost; }
    public void setMemberPost(String memberPost) { this.memberPost = memberPost; }

    public String getMemberAddress() { return memberAddress; }
    public void setMemberAddress(String memberAddress) { this.memberAddress = memberAddress; }

    public String getMemberPhone() { return memberPhone; }
    public void setMemberPhone(String memberPhone) { this.memberPhone = memberPhone; }

    public LocalDate getMemberBirthday() { return memberBirthday; }
    public void setMemberBirthday(LocalDate memberBirthday) { this.memberBirthday = memberBirthday; }

    public String getMemberPayment() { return memberPayment; }
    public void setMemberPayment(String memberPayment) { this.memberPayment = memberPayment; }

    public Integer getMemberPoint() { return memberPoint; }
    public void setMemberPoint(Integer memberPoint) { this.memberPoint = memberPoint; }

    public LocalDate getSignupDay() { return signupDay; }
    public void setSignupDay(LocalDate signupDay) { this.signupDay = signupDay; }

    public LocalDate getWithdrawalDay() { return withdrawalDay; }
    public void setWithdrawalDay(LocalDate withdrawalDay) { this.withdrawalDay = withdrawalDay; }

    public String getValidFlag() { return validFlag; }
    public void setValidFlag(String validFlag) { this.validFlag = validFlag; }
}