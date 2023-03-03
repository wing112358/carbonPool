package org.carbonPool.entity;

import java.util.Date;
import java.io.Serializable;

/**
 * 交易表(Transaction)实体类
 *
 * @author makejava
 * @since 2023-02-20 17:36:27
 */
public class Transaction implements Serializable {
    private static final long serialVersionUID = 677753222361866552L;
    /**
     * 主键id
     */
    private Long id;
    /**
     * 交易编号
     */
    private String serialnumber;
    /**
     * 关联交易需求id
     */
    private Long demandId;
    /**
     * 关联交易需求编号
     */
    private String demandSerialnumber;
    /**
     * 截止时间
     */
    private Date closeTime;
    /**
     * 成交时间
     */
    private Date transactionTime;
    /**
     * 成交数量
     */
    private Double quantity;
    /**
     * 成交价格（元）
     */
    private Double unitPrice;
    /**
     * 成交总金额（元）
     */
    private Double price;
    /**
     * 交易状态（见字典表transactionStatus）
     */
    private Integer status;
    /**
     * 单位
     */
    private String unit;
    /**
     * 所属组织id
     */
    private Long customerId;
    /**
     * 创建者用户id
     */
    private Long creatorUserId;
    /**
     * 创建人姓名
     */
    private String creatorUserName;
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

    public String getSerialnumber() {
        return serialnumber;
    }

    public void setSerialnumber(String serialnumber) {
        this.serialnumber = serialnumber;
    }

    public Long getDemandId() {
        return demandId;
    }

    public void setDemandId(Long demandId) {
        this.demandId = demandId;
    }

    public String getDemandSerialnumber() {
        return demandSerialnumber;
    }

    public void setDemandSerialnumber(String demandSerialnumber) {
        this.demandSerialnumber = demandSerialnumber;
    }

    public Date getCloseTime() {
        return closeTime;
    }

    public void setCloseTime(Date closeTime) {
        this.closeTime = closeTime;
    }

    public Date getTransactionTime() {
        return transactionTime;
    }

    public void setTransactionTime(Date transactionTime) {
        this.transactionTime = transactionTime;
    }

    public Double getQuantity() {
        return quantity;
    }

    public void setQuantity(Double quantity) {
        this.quantity = quantity;
    }

    public Double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(Double unitPrice) {
        this.unitPrice = unitPrice;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public Long getCreatorUserId() {
        return creatorUserId;
    }

    public void setCreatorUserId(Long creatorUserId) {
        this.creatorUserId = creatorUserId;
    }

    public String getCreatorUserName() {
        return creatorUserName;
    }

    public void setCreatorUserName(String creatorUserName) {
        this.creatorUserName = creatorUserName;
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

