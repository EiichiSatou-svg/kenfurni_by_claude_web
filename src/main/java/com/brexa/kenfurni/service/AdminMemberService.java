package com.brexa.kenfurni.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.brexa.kenfurni.entity.TMember;
import com.brexa.kenfurni.entity.TMemberHistory;
import com.brexa.kenfurni.repository.MemberHistoryRepository;
import com.brexa.kenfurni.repository.MemberRepository;

/**
 * 管理側会員サービス
 *
 * @author BREXA Technology
 * @version 1.0
 */
@Service
public class AdminMemberService {

    private final MemberRepository memberRepository;
    private final MemberHistoryRepository memberHistoryRepository;

    public AdminMemberService(MemberRepository memberRepository,
            MemberHistoryRepository memberHistoryRepository) {
        this.memberRepository = memberRepository;
        this.memberHistoryRepository = memberHistoryRepository;
    }

    /**
     * 会員全件取得
     *
     * @return 会員リスト
     */
    public List<TMember> findAll() {
        return memberRepository.findAll();
    }

    /**
     * 会員IDで取得
     *
     * @param memberId 会員ID
     * @return 会員情報
     */
    public TMember findById(Integer memberId) {
        return memberRepository.findById(memberId)
                .orElseThrow(() -> new RuntimeException("会員が見つかりません"));
    }

    /**
     * 会員の購入履歴取得
     *
     * @param memberId 会員ID
     * @return 購入履歴リスト
     */
    public List<TMemberHistory> findHistoryByMemberId(Integer memberId) {
        return memberHistoryRepository.findByMemberIdOrderByPurchaseDayDesc(memberId);
    }
}