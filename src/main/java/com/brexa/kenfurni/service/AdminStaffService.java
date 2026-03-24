package com.brexa.kenfurni.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.brexa.kenfurni.entity.MStaff;
import com.brexa.kenfurni.repository.StaffRepository;

/**
 * 管理側社員サービス
 *
 * @author BREXA Technology
 * @version 1.0
 */
@Service
public class AdminStaffService {

    private final StaffRepository staffRepository;

    public AdminStaffService(StaffRepository staffRepository) {
    	this.staffRepository = staffRepository;
    }

    public List<MStaff> findAll() {
        return staffRepository.findAll();
    }

    public MStaff findById(Integer staffId) {
        return staffRepository.findById(staffId)
                .orElseThrow(() -> new RuntimeException("社員が見つかりません"));
    }

    @Transactional
    public void save(MStaff staff) {
        staffRepository.save(staff);
    }
}