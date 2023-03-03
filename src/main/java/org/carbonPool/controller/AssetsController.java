package org.carbonPool.controller;

import org.carbonPool.entity.Assets;
import org.carbonPool.service.AssetsService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * 资产表(Assets)表控制层
 *
 * @author makejava
 * @since 2023-02-22 16:08:22
 */
@RestController
@RequestMapping("assets")
public class AssetsController {
    /**
     * 服务对象
     */
    @Resource
    private AssetsService assetsService;

    /**
     * 分页查询
     *
     * @param assets 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    @GetMapping
    public ResponseEntity<Page<Assets>> queryByPage(Assets assets, PageRequest pageRequest) {
        return ResponseEntity.ok(this.assetsService.queryByPage(assets, pageRequest));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public ResponseEntity<Assets> queryById(@PathVariable("id") Long id) {
        return ResponseEntity.ok(this.assetsService.queryById(id));
    }

    /**
     * 新增数据
     *
     * @param assets 实体
     * @return 新增结果
     */
    @PostMapping
    public ResponseEntity<Assets> add(Assets assets) {
        return ResponseEntity.ok(this.assetsService.insert(assets));
    }

    /**
     * 编辑数据
     *
     * @param assets 实体
     * @return 编辑结果
     */
    @PutMapping
    public ResponseEntity<Assets> edit(Assets assets) {
        return ResponseEntity.ok(this.assetsService.update(assets));
    }

    /**
     * 删除数据
     *
     * @param id 主键
     * @return 删除是否成功
     */
    @DeleteMapping
    public ResponseEntity<Boolean> deleteById(Long id) {
        return ResponseEntity.ok(this.assetsService.deleteById(id));
    }

}

