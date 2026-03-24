package com.brexa.kenfurni.service;

import java.time.LocalDate;

import org.springframework.stereotype.Service;

import com.brexa.kenfurni.entity.TMember;
import com.brexa.kenfurni.form.MemberRegisterForm;
import com.brexa.kenfurni.repository.MemberRepository;

/**
 * 会員登録サービス
 *
 * @author BREXA Technology
 * @version 1.0
 */
@Service
public class MemberRegisterService {

    private final MemberRepository memberRepository;

    public MemberRegisterService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    /**
     * メールアドレス重複チェック
     *
     * @param memberMail メールアドレス
     * @return 重複している場合true
     */
    public boolean existsByMemberMail(String memberMail) {
        return memberRepository.findByMemberMail(memberMail).isPresent();
    }

    /**
     * 会員登録
     *
     * @param form 会員登録フォーム
     */
    public void register(MemberRegisterForm form) {
        TMember member = new TMember();
        member.setMemberMail(form.getMemberMail());
        member.setMemberPassword(form.getMemberPassword());
        member.setMemberName(form.getMemberName());
        member.setMemberKana(form.getMemberKana());
        member.setMemberPost(form.getMemberPost());
        member.setMemberAddress(form.getMemberAddress());
        member.setMemberPhone(form.getMemberPhone());
        member.setMemberBirthday(LocalDate.parse(form.getMemberBirthday()));
        member.setMemberPayment(form.getMemberPayment());
        member.setMemberPoint(0);
        member.setSignupDay(LocalDate.now());
        member.setValidFlag("0");
        memberRepository.save(member);
    }
}