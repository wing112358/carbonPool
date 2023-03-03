package org.carbonPool.controller;

import org.carbonPool.entity.AssetsEquity;
import org.carbonPool.service.AssetsEquityService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * 资产权益表(AssetsEquity)表控制层
 *
 * @author makejava
 * @since 2023-02-22 16:08:34
 */
@RestController
@RequestMapping("assetsEquity")
public class AssetsEquityController {
    /**
     * 服务对象
     */
    @Resource
    private AssetsEquityService assetsEquityService;

    /**
     * 分页查询
     *
     * @param assetsEquity 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    @GetMapping
    public ResponseEntity<Page<AssetsEquity>> queryByPage(AssetsEquity assetsEquity, PageRequest pageRequest) {
        return ResponseEntity.ok(this.assetsEquityService.queryByPage(assetsEquity, pageRequest));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public ResponseEntity<AssetsEquity> queryById(@PathVariable("id") Long id) {
        return ResponseEntity.ok(this.assetsEquityService.queryById(id));
    }

    /**
     * 新增数据
     *
     * @param assetsEquity 实体
     * @return 新增结果
     */
    @PostMapping
    public ResponseEntity<AssetsEquity> add(AssetsEquity assetsEquity) {
        return ResponseEntity.ok(this.assetsEquityService.insert(assetsEquity));
    }

    /**
     * 编辑数据
     *
     * @param assetsEquity 实体
     * @return 编辑结果
     */
    @PutMapping
    public ResponseEntity<AssetsEquity> edit(AssetsEquity assetsEquity) {
        return ResponseEntity.ok(this.assetsEquityService.update(assetsEquity));
    }

    /**
     * 删除数据
     *
     * @param id 主键
     * @return 删除是否成功
     */
    @DeleteMapping
    public ResponseEntity<Boolean> deleteById(Long id) {
        return ResponseEntity.ok(this.assetsEquityService.deleteById(id));
    }

}

