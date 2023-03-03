package org.carbonPool.dao;

import org.apache.ibatis.annotations.Mapper;
import org.carbonPool.entity.Transaction;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.Pageable;
import java.util.List;

/**
 * 交易表(Transaction)表数据库访问层
 *
 * @author makejava
 * @since 2023-02-20 17:36:27
 */
@Mapper
public interface TransactionDao {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    Transaction queryById(Long id);

    /**
     * 通过需求ID查询单条数据
     *
     * @param demandId 主键
     * @return 实例对象
     */
    Transaction queryByDemandId(Long demandId);

    /**
     * 查询指定行数据
     *
     * @param transaction 查询条件
     * @param pageable         分页对象
     * @return 对象列表
     */
    List<Transaction> queryAllByLimit(Transaction transaction, @Param("pageable") Pageable pageable);

    /**
     * 统计总行数
     *
     * @param transaction 查询条件
     * @return 总行数
     */
    long count(Transaction transaction);

    /**
     * 新增数据
     *
     * @param transaction 实例对象
     * @return 影响行数
     */
    int insert(Transaction transaction);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<Transaction> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<Transaction> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<Transaction> 实例对象列表
     * @return 影响行数
     * @throws org.springframework.jdbc.BadSqlGrammarException 入参是空List的时候会抛SQL语句错误的异常，请自行校验入参
     */
    int insertOrUpdateBatch(@Param("entities") List<Transaction> entities);

    /**
     * 修改数据
     *
     * @param transaction 实例对象
     * @return 影响行数
     */
    int update(Transaction transaction);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Long id);

}

