package com.brexa.kenfurni.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.brexa.kenfurni.entity.TMemberHistory;

/**
 * 会員購入履歴リポジトリ
 *
 * @author BREXA Technology
 * @version 1.0
 */
@Repository
public interface MemberHistoryRepository extends JpaRepository<TMemberHistory, Integer> {

    List<TMemberHistory> findByMemberIdOrderByPurchaseDayDesc(Integer memberId);
}