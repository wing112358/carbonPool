package org.carbonPool.controller;

import org.carbonPool.entity.TransactionAssets;
import org.carbonPool.service.TransactionAssetsService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * 交易资产关联表(TransactionAssets)表控制层
 *
 * @author makejava
 * @since 2023-02-22 16:09:38
 */
@RestController
@RequestMapping("transactionAssets")
public class TransactionAssetsController {
    /**
     * 服务对象
     */
    @Resource
    private TransactionAssetsService transactionAssetsService;

    /**
     * 分页查询
     *
     * @param transactionAssets 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    @GetMapping
    public ResponseEntity<Page<TransactionAssets>> queryByPage(TransactionAssets transactionAssets, PageRequest pageRequest) {
        return ResponseEntity.ok(this.transactionAssetsService.queryByPage(transactionAssets, pageRequest));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public ResponseEntity<TransactionAssets> queryById(@PathVariable("id") Long id) {
        return ResponseEntity.ok(this.transactionAssetsService.queryById(id));
    }

    /**
     * 新增数据
     *
     * @param transactionAssets 实体
     * @return 新增结果
     */
    @PostMapping
    public ResponseEntity<TransactionAssets> add(TransactionAssets transactionAssets) {
        return ResponseEntity.ok(this.transactionAssetsService.insert(transactionAssets));
    }

    /**
     * 编辑数据
     *
     * @param transactionAssets 实体
     * @return 编辑结果
     */
    @PutMapping
    public ResponseEntity<TransactionAssets> edit(TransactionAssets transactionAssets) {
        return ResponseEntity.ok(this.transactionAssetsService.update(transactionAssets));
    }

    /**
     * 删除数据
     *
     * @param id 主键
     * @return 删除是否成功
     */
    @DeleteMapping
    public ResponseEntity<Boolean> deleteById(Long id) {
        return ResponseEntity.ok(this.transactionAssetsService.deleteById(id));
    }

}

