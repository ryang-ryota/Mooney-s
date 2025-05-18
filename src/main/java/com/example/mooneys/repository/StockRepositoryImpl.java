package com.example.mooneys.repository;

import com.example.mooneys.dto.StockWithBookDto;
import com.example.mooneys.entity.Stock;
import com.example.mooneys.entity.StockExample;
import com.example.mooneys.form.StockSearchForm;
import com.example.mooneys.mapper.StockMapper;
import com.example.mooneys.mapper.custom.CustomStockMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 在庫情報のリポジトリ実装クラス
 */
@Repository
@RequiredArgsConstructor
public class StockRepositoryImpl implements StockRepository {

    /**
     * 在庫情報マッパー
     */
    private final StockMapper stockMapper;

    /**
     * カスタム在庫情報マッパー
     */
    private final CustomStockMapper customStockMapper;

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Stock> searchStocks(StockSearchForm searchForm) {
        // 検索条件の作成
        StockExample example = new StockExample();
        StockExample.Criteria criteria = example.createCriteria();

        // ISBN検索条件の設定
        if (searchForm.getIsbn() != null && !searchForm.getIsbn().isEmpty()) {
            criteria.andIsbnEqualTo(searchForm.getIsbn());
        }
        // TODO: 書名での検索はJOINやビューが必要。ここでは省略または拡張で対応。

        // 検索の実行と結果の返却
        return stockMapper.selectByExample(example);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Stock findById(Integer id) {
        // プライマリーキーによる在庫情報の取得
        return stockMapper.selectByPrimaryKey(id);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void insert(Stock stock) {
        // 在庫情報の新規登録
        stockMapper.insert(stock);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void update(Stock stock) {
        // 在庫情報の更新
        stockMapper.updateByPrimaryKey(stock);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void delete(Integer id) {
        // 在庫情報の削除
        stockMapper.deleteByPrimaryKey(id);
    }

    @Override
    public StockWithBookDto findStockWithBookById(Integer id) {
        return customStockMapper.selectById(id);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<StockWithBookDto> searchByBookTitle(String bookTitle) {
        // 書籍タイトルによる在庫情報の検索
        return customStockMapper.selectByBookTitle(bookTitle);
    }
}