package com.brexa.kenfurni.service;

import java.util.List;

import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.brexa.kenfurni.entity.MStaff;
import com.brexa.kenfurni.repository.StaffRepository;

/**
 * スタッフ認証サービス
 *
 * @author BREXA Technology
 * @version 1.0
 */
@Service
public class StaffDetailsService implements UserDetailsService {

    private final StaffRepository staffRepository;

    public StaffDetailsService(StaffRepository staffRepository) {
        this.staffRepository = staffRepository;
    }

    /**
     * スタッフ名で認証情報を返す
     *
     * @param staffName スタッフ名
     * @return UserDetails
     * @throws UsernameNotFoundException スタッフが見つからない場合
     */
    @Override
    public UserDetails loadUserByUsername(String staffName) throws UsernameNotFoundException {
        MStaff staff = staffRepository.findByStaffNameAndValidFlag(staffName, "0")
                .orElseThrow(() -> new UsernameNotFoundException("スタッフが見つかりません: " + staffName));

        String role = switch (staff.getStaffAuthorityFlag()) {
            case "0" -> "STAFF_FULL";
            case "1" -> "STAFF_CONTRACT";
            case "2" -> "STAFF_OUTSOURCE";
            case "5" -> "STAFF_PART";
            default  -> "STAFF_OTHER";
        };

        return User.builder()
                .username(staff.getStaffName())
                .password(staff.getStaffPassword())
                .authorities(List.of(new SimpleGrantedAuthority("ROLE_" + role)))
                .build();
    }
}