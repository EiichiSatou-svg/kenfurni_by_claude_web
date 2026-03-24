package com.brexa.kenfurni.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.brexa.kenfurni.entity.TEarnings;
import com.brexa.kenfurni.entity.TEarningsId;

/**
 * 売上リポジトリ
 *
 * @author BREXA Technology
 * @version 1.0
 */
@Repository
public interface EarningsRepository extends JpaRepository<TEarnings, TEarningsId> {

    List<TEarnings> findByYear(Integer year);
}