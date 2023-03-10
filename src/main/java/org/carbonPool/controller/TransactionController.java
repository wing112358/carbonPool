package org.carbonPool.controller;

import org.carbonPool.entity.Transaction;
import org.carbonPool.service.TransactionService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * 交易表(Transaction)表控制层
 *
 * @author makejava
 * @since 2023-02-22 16:09:30
 */
@RestController
@RequestMapping("transaction")
public class TransactionController {
    /**
     * 服务对象
     */
    @Resource
    private TransactionService transactionService;

    /**
     * 分页查询
     *
     * @param transaction 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    @GetMapping
    public ResponseEntity<Page<Transaction>> queryByPage(Transaction transaction, PageRequest pageRequest) {
        return ResponseEntity.ok(this.transactionService.queryByPage(transaction, pageRequest));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public ResponseEntity<Transaction> queryById(@PathVariable("id") Long id) {
        return ResponseEntity.ok(this.transactionService.queryById(id));
    }

    /**
     * 新增数据
     *
     * @param transaction 实体
     * @return 新增结果
     */
    @PostMapping
    public ResponseEntity<Transaction> add(Transaction transaction) {
        return ResponseEntity.ok(this.transactionService.insert(transaction));
    }

    /**
     * 编辑数据
     *
     * @param transaction 实体
     * @return 编辑结果
     */
    @PutMapping
    public ResponseEntity<Transaction> edit(Transaction transaction) {
        return ResponseEntity.ok(this.transactionService.update(transaction));
    }

    /**
     * 删除数据
     *
     * @param id 主键
     * @return 删除是否成功
     */
    @DeleteMapping
    public ResponseEntity<Boolean> deleteById(Long id) {
        return ResponseEntity.ok(this.transactionService.deleteById(id));
    }

}

