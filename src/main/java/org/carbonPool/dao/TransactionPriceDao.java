package org.carbonPool.dao;

import org.apache.ibatis.annotations.Mapper;
import org.carbonPool.entity.TransactionPrice;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.Pageable;
import java.util.List;

/**
 * 交易价格表(TransactionPrice)表数据库访问层
 *
 * @author makejava
 * @since 2023-02-20 17:36:52
 */
@Mapper
public interface TransactionPriceDao {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    TransactionPrice queryById(Long id);

    /**
     * 查询指定行数据
     *
     * @param transactionPrice 查询条件
     * @param pageable         分页对象
     * @return 对象列表
     */
    List<TransactionPrice> queryAllByLimit(TransactionPrice transactionPrice, @Param("pageable") Pageable pageable);

    /**
     * 统计总行数
     *
     * @param transactionPrice 查询条件
     * @return 总行数
     */
    long count(TransactionPrice transactionPrice);

    /**
     * 新增数据
     *
     * @param transactionPrice 实例对象
     * @return 影响行数
     */
    int insert(TransactionPrice transactionPrice);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<TransactionPrice> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<TransactionPrice> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<TransactionPrice> 实例对象列表
     * @return 影响行数
     * @throws org.springframework.jdbc.BadSqlGrammarException 入参是空List的时候会抛SQL语句错误的异常，请自行校验入参
     */
    int insertOrUpdateBatch(@Param("entities") List<TransactionPrice> entities);

    /**
     * 修改数据
     *
     * @param transactionPrice 实例对象
     * @return 影响行数
     */
    int update(TransactionPrice transactionPrice);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Long id);

}

