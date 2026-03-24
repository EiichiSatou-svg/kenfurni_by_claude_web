package com.brexa.kenfurni.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.brexa.kenfurni.entity.MStaff;

/**
 * スタッフリポジトリ
 *
 * @author BREXA Technology
 * @version 1.0
 */
@Repository
public interface StaffRepository extends JpaRepository<MStaff, Integer> {

    Optional<MStaff> findByStaffNameAndValidFlag(String staffName, String validFlag);
}