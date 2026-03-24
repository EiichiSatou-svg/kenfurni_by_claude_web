package com.brexa.kenfurni.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.brexa.kenfurni.dto.EarningsListDto;
import com.brexa.kenfurni.entity.TEarnings;
import com.brexa.kenfurni.repository.EarningsRepository;
import com.brexa.kenfurni.repository.ProductRepository;

/**
 * 管理側売上サービス
 *
 * @author BREXA Technology
 * @version 1.0
 */
@Service
public class AdminEarningsService {

    private final EarningsRepository earningsRepository;
    private final ProductRepository productRepository;

    public AdminEarningsService(EarningsRepository earningsRepository,
            ProductRepository productRepository) {
        this.earningsRepository = earningsRepository;
        this.productRepository = productRepository;
    }

    /**
     * 年度で売上一覧を取得する
     *
     * @param year 年度
     * @return 売上一覧DTOリスト
     */
    public List<EarningsListDto> findByYear(Integer year) {
        List<TEarnings> list = earningsRepository.findByYear(year);
        return list.stream().map(e -> {
            String productName = productRepository.findById(e.getProductId())
                    .map(p -> p.getProductName()).orElse("不明");
            int totalAmount =
                nullToZero(e.getSalesAmount01()) + nullToZero(e.getSalesAmount02()) +
                nullToZero(e.getSalesAmount03()) + nullToZero(e.getSalesAmount04()) +
                nullToZero(e.getSalesAmount05()) + nullToZero(e.getSalesAmount06()) +
                nullToZero(e.getSalesAmount07()) + nullToZero(e.getSalesAmount08()) +
                nullToZero(e.getSalesAmount09()) + nullToZero(e.getSalesAmount10()) +
                nullToZero(e.getSalesAmount11()) + nullToZero(e.getSalesAmount12());
            return new EarningsListDto(e.getProductId(), productName, e.getYear(), totalAmount);
        }).collect(Collectors.toList());
    }

    private int nullToZero(Integer value) {
        return value != null ? value : 0;
    }
}