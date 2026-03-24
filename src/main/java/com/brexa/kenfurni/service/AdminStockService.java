package com.brexa.kenfurni.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.brexa.kenfurni.dto.StockListDto;
import com.brexa.kenfurni.entity.MProductStock;
import com.brexa.kenfurni.repository.ProductRepository;
import com.brexa.kenfurni.repository.ProductStockRepository;

/**
 * 管理側商品在庫サービス
 *
 * @author BREXA Technology
 * @version 1.0
 */
@Service
public class AdminStockService {

    private final ProductStockRepository productStockRepository;
    private final ProductRepository productRepository;

    public AdminStockService(ProductStockRepository productStockRepository,
            ProductRepository productRepository) {
        this.productStockRepository = productStockRepository;
        this.productRepository = productRepository;
    }

    /**
     * 商品在庫一覧を取得する
     *
     * @return 商品在庫一覧DTOリスト
     */
    public List<StockListDto> findAll() {
        List<MProductStock> stockList = productStockRepository.findAll();
        return stockList.stream().map(stock -> {
            String productName = productRepository.findById(stock.getProductId())
                    .map(p -> p.getProductName()).orElse("不明");
            return new StockListDto(stock.getProductId(), productName, stock.getProductStock());
        }).collect(Collectors.toList());
    }
}