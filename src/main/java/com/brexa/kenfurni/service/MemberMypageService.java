package com.brexa.kenfurni.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.brexa.kenfurni.entity.TMember;
import com.brexa.kenfurni.entity.TMemberHistory;
import com.brexa.kenfurni.form.MemberUpdateForm;
import com.brexa.kenfurni.repository.MemberHistoryRepository;
import com.brexa.kenfurni.repository.MemberRepository;

/**
 * マイページサービス
 *
 * @author BREXA Technology
 * @version 1.0
 */
@Service
public class MemberMypageService {

    private final MemberRepository memberRepository;
    private final MemberHistoryRepository memberHistoryRepository;

    public MemberMypageService(MemberRepository memberRepository,
            MemberHistoryRepository memberHistoryRepository) {
        this.memberRepository = memberRepository;
        this.memberHistoryRepository = memberHistoryRepository;
    }

    /**
     * メールアドレスで会員を取得
     *
     * @param memberMail メールアドレス
     * @return 会員情報
     */
    public TMember findByMemberMail(String memberMail) {
        return memberRepository.findByMemberMail(memberMail)
                .orElseThrow(() -> new RuntimeException("会員が見つかりません"));
    }

    /**
     * 会員情報更新
     *
     * @param memberMail メールアドレス
     * @param form 会員情報更新フォーム
     */
    @Transactional
    public void update(String memberMail, MemberUpdateForm form) {
        TMember member = findByMemberMail(memberMail);
        member.setMemberName(form.getMemberName());
        member.setMemberKana(form.getMemberKana());
        member.setMemberPost(form.getMemberPost());
        member.setMemberAddress(form.getMemberAddress());
        member.setMemberPhone(form.getMemberPhone());
        member.setMemberBirthday(LocalDate.parse(form.getMemberBirthday()));
        member.setMemberPayment(form.getMemberPayment());
        memberRepository.save(member);
    }

    /**
     * 購入履歴取得
     *
     * @param memberMail メールアドレス
     * @return 購入履歴リスト
     */
    public List<TMemberHistory> findHistoryByMemberMail(String memberMail) {
        TMember member = findByMemberMail(memberMail);
        return memberHistoryRepository.findByMemberIdOrderByPurchaseDayDesc(member.getMemberId());
    }
}