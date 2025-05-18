package com.example.mooneys.service;

import com.example.mooneys.dto.StockWithBookDto;
import com.example.mooneys.entity.Stock;
import com.example.mooneys.form.StockForm;
import com.example.mooneys.form.StockSearchForm;
import com.example.mooneys.repository.StockRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 在庫情報管理サービスの実装クラス
 * 在庫の検索・登録・更新・削除の業務ロジックを提供する
 */
@Service
@RequiredArgsConstructor
public class StockServiceImpl implements StockService {

    /**
     * 在庫情報リポジトリ
     */
    private final StockRepository stockRepository;

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Stock> searchStocks(StockSearchForm searchForm) {
        return stockRepository.searchStocks(searchForm);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Stock findById(Integer id) {
        return stockRepository.findById(id);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void createStock(StockForm form) {
        // フォームの内容から在庫エンティティを生成
        Stock stock = new Stock();
        stock.setIsbn(form.getIsbn());
        stock.setQuantity(form.getQuantity());

        // 在庫情報を登録
        stockRepository.insert(stock);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void updateStock(Long id, StockForm form) {
        // フォームの内容から在庫エンティティを生成
        Stock stock = new Stock();
        stock.setIsbn(form.getIsbn());
        stock.setQuantity(form.getQuantity());

        // 在庫情報を更新
        stockRepository.update(stock);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void deleteStock(Integer id) {
        stockRepository.delete(id);
    }

    @Override
    public StockWithBookDto findStockWithBookById(Integer id) {
        return stockRepository.findStockWithBookById(id);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<StockWithBookDto> searchByBookTitle(String bookTitle) {
        return stockRepository.searchByBookTitle(bookTitle);
    }
}