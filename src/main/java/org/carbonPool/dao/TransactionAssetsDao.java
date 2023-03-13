package org.carbonPool.dao;

import org.apache.ibatis.annotations.Mapper;
import org.carbonPool.entity.TransactionAssets;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.Pageable;
import java.util.List;

/**
 * 交易资产关联表(TransactionAssets)表数据库访问层
 *
 * @author makejava
 * @since 2023-02-20 17:36:42
 */
@Mapper
public interface TransactionAssetsDao {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    TransactionAssets queryById(Long id);

    /**
     * 通过交易ID查询多条数据
     *
     * @param transactionId 主键
     * @return 实例对象
     */
    List<TransactionAssets> queryByTransactionId(Long transactionId);

    /**
     * 查询指定行数据
     *
     * @param transactionAssets 查询条件
     * @param pageable         分页对象
     * @return 对象列表
     */
    List<TransactionAssets> queryAllByLimit(TransactionAssets transactionAssets, @Param("pageable") Pageable pageable);

    /**
     * 统计总行数
     *
     * @param transactionAssets 查询条件
     * @return 总行数
     */
    long count(TransactionAssets transactionAssets);

    /**
     * 新增数据
     *
     * @param transactionAssets 实例对象
     * @return 影响行数
     */
    int insert(TransactionAssets transactionAssets);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<TransactionAssets> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<TransactionAssets> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<TransactionAssets> 实例对象列表
     * @return 影响行数
     * @throws org.springframework.jdbc.BadSqlGrammarException 入参是空List的时候会抛SQL语句错误的异常，请自行校验入参
     */
    int insertOrUpdateBatch(@Param("entities") List<TransactionAssets> entities);

    /**
     * 修改数据
     *
     * @param transactionAssets 实例对象
     * @return 影响行数
     */
    int update(TransactionAssets transactionAssets);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Long id);

}

