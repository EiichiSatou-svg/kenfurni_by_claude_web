package com.brexa.kenfurni.service;

import java.time.LocalDate;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.brexa.kenfurni.entity.TMember;
import com.brexa.kenfurni.entity.TMemberHistory;
import com.brexa.kenfurni.entity.TMemberHistoryProductList;
import com.brexa.kenfurni.entity.TProductSend;
import com.brexa.kenfurni.form.CartItem;
import com.brexa.kenfurni.repository.MemberHistoryProductListRepository;
import com.brexa.kenfurni.repository.MemberHistoryRepository;
import com.brexa.kenfurni.repository.MemberRepository;
import com.brexa.kenfurni.repository.ProductSendRepository;

/**
 * 購入サービス
 *
 * @author BREXA Technology
 * @version 1.0
 */
@Service
public class PurchaseService {

    private final MemberRepository memberRepository;
    private final MemberHistoryRepository memberHistoryRepository;
    private final MemberHistoryProductListRepository memberHistoryProductListRepository;
    private final ProductSendRepository productSendRepository;

    public PurchaseService(
            MemberRepository memberRepository,
            MemberHistoryRepository memberHistoryRepository,
            MemberHistoryProductListRepository memberHistoryProductListRepository,
            ProductSendRepository productSendRepository) {
        this.memberRepository = memberRepository;
        this.memberHistoryRepository = memberHistoryRepository;
        this.memberHistoryProductListRepository = memberHistoryProductListRepository;
        this.productSendRepository = productSendRepository;
    }

    /**
     * 購入処理
     *
     * @param memberMail ログイン会員メールアドレス
     * @param cartService カートサービス
     */
    @Transactional
    public void purchase(String memberMail, CartService cartService) {
        TMember member = memberRepository.findByMemberMail(memberMail)
                .orElseThrow(() -> new RuntimeException("会員が見つかりません"));

        int totalAmount = cartService.getTotalAmount();

        // 購入履歴登録
        TMemberHistory history = new TMemberHistory();
        history.setMemberId(member.getMemberId());
        history.setUsedPoint(0);
        history.setTotalAmount(totalAmount);
        history.setUsedPointTotalAmount(totalAmount);
        history.setCancelFlag("0");
        history.setPurchaseDay(LocalDate.now());
        history.setValidFlag("0");
        TMemberHistory savedHistory = memberHistoryRepository.save(history);

        // 明細登録
        int lineNo = 1;
        for (CartItem item : cartService.getCartItems()) {
            TMemberHistoryProductList detail = new TMemberHistoryProductList();
            detail.setPurchaseId(savedHistory.getPurchaseId());
            detail.setPurchaseIdNumber(lineNo++);
            detail.setProductId(item.getProductId());
            detail.setProductPurchasePrice(item.getProductPrice());
            detail.setPurchaseQuantity(item.getQuantity());
            memberHistoryProductListRepository.save(detail);
        }

        // 発送テーブル登録
        TProductSend send = new TProductSend();
        send.setPurchaseId(savedHistory.getPurchaseId());
        send.setMemberId(member.getMemberId());
        send.setPurchaseDay(LocalDate.now());
        send.setMemberPayment(member.getMemberPayment());
        send.setDesignation("0");
        send.setSendScheduleDay(LocalDate.now().plusDays(3));
        productSendRepository.save(send);
    }
}