package org.carbonPool.controller;

import org.carbonPool.entity.TransactionPrice;
import org.carbonPool.service.TransactionPriceService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * 交易价格表(TransactionPrice)表控制层
 *
 * @author makejava
 * @since 2023-02-22 16:09:45
 */
@RestController
@RequestMapping("transactionPrice")
public class TransactionPriceController {
    /**
     * 服务对象
     */
    @Resource
    private TransactionPriceService transactionPriceService;

    /**
     * 分页查询
     *
     * @param transactionPrice 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    @GetMapping
    public ResponseEntity<Page<TransactionPrice>> queryByPage(TransactionPrice transactionPrice, PageRequest pageRequest) {
        return ResponseEntity.ok(this.transactionPriceService.queryByPage(transactionPrice, pageRequest));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public ResponseEntity<TransactionPrice> queryById(@PathVariable("id") Long id) {
        return ResponseEntity.ok(this.transactionPriceService.queryById(id));
    }

    /**
     * 新增数据
     *
     * @param transactionPrice 实体
     * @return 新增结果
     */
    @PostMapping
    public ResponseEntity<TransactionPrice> add(TransactionPrice transactionPrice) {
        return ResponseEntity.ok(this.transactionPriceService.insert(transactionPrice));
    }

    /**
     * 编辑数据
     *
     * @param transactionPrice 实体
     * @return 编辑结果
     */
    @PutMapping
    public ResponseEntity<TransactionPrice> edit(TransactionPrice transactionPrice) {
        return ResponseEntity.ok(this.transactionPriceService.update(transactionPrice));
    }

    /**
     * 删除数据
     *
     * @param id 主键
     * @return 删除是否成功
     */
    @DeleteMapping
    public ResponseEntity<Boolean> deleteById(Long id) {
        return ResponseEntity.ok(this.transactionPriceService.deleteById(id));
    }

}

