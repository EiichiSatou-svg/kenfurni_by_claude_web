package com.brexa.kenfurni.form;

/**
 * 会員情報更新フォーム
 *
 * @author BREXA Technology
 * @version 1.0
 */
public class MemberUpdateForm {

    private String memberName;
    private String memberKana;
    private String memberPost;
    private String memberAddress;
    private String memberPhone;
    private String memberBirthday;
    private String memberPayment;

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

    public String getMemberBirthday() { return memberBirthday; }
    public void setMemberBirthday(String memberBirthday) { this.memberBirthday = memberBirthday; }

    public String getMemberPayment() { return memberPayment; }
    public void setMemberPayment(String memberPayment) { this.memberPayment = memberPayment; }
}