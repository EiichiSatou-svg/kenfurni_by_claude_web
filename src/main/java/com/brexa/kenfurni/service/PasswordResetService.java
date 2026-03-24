package com.brexa.kenfurni.service;

import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.brexa.kenfurni.entity.TMember;
import com.brexa.kenfurni.repository.MemberRepository;

/**
 * パスワード再発行サービス
 *
 * @author BREXA Technology
 * @version 1.0
 */
@Service
public class PasswordResetService {

    private final MemberRepository memberRepository;

    public PasswordResetService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    /**
     * パスワードをリセットする
     *
     * @param memberMail メールアドレス
     * @param newPassword 新しいパスワード
     * @return 成功した場合true
     */
    @Transactional
    public boolean resetPassword(String memberMail, String newPassword) {
        Optional<TMember> memberOpt = memberRepository.findByMemberMail(memberMail);
        if (memberOpt.isEmpty()) {
            return false;
        }
        TMember member = memberOpt.get();
        member.setMemberPassword(newPassword);
        memberRepository.save(member);
        return true;
    }
}