package com.brexa.kenfurni.service;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.brexa.kenfurni.entity.TMember;
import com.brexa.kenfurni.repository.MemberRepository;

/**
 * 会員認証サービス
 *
 * @author BREXA Technology
 * @version 1.0
 */
@Service
public class MemberDetailsService implements UserDetailsService {

    private final MemberRepository memberRepository;

    public MemberDetailsService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String memberMail) throws UsernameNotFoundException {
        TMember member = memberRepository.findByMemberMail(memberMail)
            .orElseThrow(() -> new UsernameNotFoundException("会員が見つかりません: " + memberMail));

        return User.builder()
            .username(member.getMemberMail())
            .password(member.getMemberPassword())
            .roles("MEMBER")
            .build();
    }
}