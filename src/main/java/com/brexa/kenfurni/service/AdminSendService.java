package com.brexa.kenfurni.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.brexa.kenfurni.dto.SendListDto;
import com.brexa.kenfurni.entity.TMember;
import com.brexa.kenfurni.entity.TProductSend;
import com.brexa.kenfurni.repository.MemberRepository;
import com.brexa.kenfurni.repository.ProductSendRepository;

/**
 * 管理側発送サービス
 *
 * @author BREXA Technology
 * @version 1.0
 */
@Service
public class AdminSendService {

    private final ProductSendRepository productSendRepository;
    private final MemberRepository memberRepository;

    public AdminSendService(ProductSendRepository productSendRepository,
            MemberRepository memberRepository) {
        this.productSendRepository = productSendRepository;
        this.memberRepository = memberRepository;
    }

    /**
     * 発送一覧を取得する
     *
     * @return 発送一覧DTOリスト
     */
    public List<SendListDto> findAll() {
        List<TProductSend> sendList = productSendRepository.findAll();
        return sendList.stream().map(send -> {
            TMember member = memberRepository.findById(send.getMemberId()).orElse(null);
            String memberName = member != null ? member.getMemberName() : "不明";
            return new SendListDto(
                send.getPurchaseId(),
                memberName,
                send.getPurchaseDay(),
                send.getMemberPayment(),
                send.getSendScheduleDay(),
                send.getSentDay()
            );
        }).collect(Collectors.toList());
    }
}