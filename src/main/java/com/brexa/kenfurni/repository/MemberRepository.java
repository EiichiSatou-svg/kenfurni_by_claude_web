package com.brexa.kenfurni.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.brexa.kenfurni.entity.TMember;

/**
 * 会員リポジトリ
 *
 * @author BREXA Technology
 * @version 1.0
 */
@Repository
public interface MemberRepository extends JpaRepository<TMember, Integer> {

    Optional<TMember> findByMemberMail(String memberMail);
}