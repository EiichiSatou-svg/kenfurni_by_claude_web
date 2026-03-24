package com.brexa.kenfurni.entity;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

/**
 * スタッフエンティティ
 *
 * @author BREXA Technology
 * @version 1.0
 */
@Entity
@Table(name = "m_staff")
public class MStaff {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "staff_id")
    private Integer staffId;

    @Column(name = "staff_name")
    private String staffName;

    @Column(name = "staff_kana")
    private String staffKana;

    @Column(name = "staff_password")
    private String staffPassword;

    @Column(name = "staff_authority_flag")
    private String staffAuthorityFlag;

    @Column(name = "staff_registday")
    private LocalDate staffRegistday;

    @Column(name = "staff_retirementday")
    private LocalDate staffRetirementday;

    @Column(name = "valid_flag")
    private String validFlag;

    public Integer getStaffId() { return staffId; }
    public void setStaffId(Integer staffId) { this.staffId = staffId; }

    public String getStaffName() { return staffName; }
    public void setStaffName(String staffName) { this.staffName = staffName; }

    public String getStaffKana() { return staffKana; }
    public void setStaffKana(String staffKana) { this.staffKana = staffKana; }

    public String getStaffPassword() { return staffPassword; }
    public void setStaffPassword(String staffPassword) { this.staffPassword = staffPassword; }

    public String getStaffAuthorityFlag() { return staffAuthorityFlag; }
    public void setStaffAuthorityFlag(String staffAuthorityFlag) { this.staffAuthorityFlag = staffAuthorityFlag; }

    public LocalDate getStaffRegistday() { return staffRegistday; }
    public void setStaffRegistday(LocalDate staffRegistday) { this.staffRegistday = staffRegistday; }

    public LocalDate getStaffRetirementday() { return staffRetirementday; }
    public void setStaffRetirementday(LocalDate staffRetirementday) { this.staffRetirementday = staffRetirementday; }

    public String getValidFlag() { return validFlag; }
    public void setValidFlag(String validFlag) { this.validFlag = validFlag; }
}