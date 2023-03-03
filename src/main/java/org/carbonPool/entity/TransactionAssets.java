package org.carbonPool.entity;

import java.util.Date;
import java.io.Serializable;

/**
 * 交易资产关联表(TransactionAssets)实体类
 *
 * @author makejava
 * @since 2023-02-20 17:36:42
 */
public class TransactionAssets implements Serializable {
    private static final long serialVersionUID = 149620734264677436L;
    /**
     * 主键id
     */
    private Long id;
    /**
     * 交易id
     */
    private Long transactionId;
    /**
     * 资产id
     */
    private Long assetsId;
    /**
     * 资产数量
     */
    private Double assetsQuantity;
    /**
     * 资产价格(计算规则：成交单价*资产数量)
     */
    private Double price;
    /**
     * 是否删除（0未删除，1已删除）
     */
    private Integer isDelete;
    /**
     * 更新时间
     */
    private Date updatedAt;
    /**
     * 创建时间
     */
    private Date createdAt;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(Long transactionId) {
        this.transactionId = transactionId;
    }

    public Long getAssetsId() {
        return assetsId;
    }

    public void setAssetsId(Long assetsId) {
        this.assetsId = assetsId;
    }

    public Double getAssetsQuantity() {
        return assetsQuantity;
    }

    public void setAssetsQuantity(Double assetsQuantity) {
        this.assetsQuantity = assetsQuantity;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Integer isDelete) {
        this.isDelete = isDelete;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

}

