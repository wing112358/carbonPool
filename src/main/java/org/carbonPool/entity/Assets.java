package org.carbonPool.entity;

import java.util.Date;
import java.io.Serializable;

/**
 * 资产表(Assets)实体类
 *
 * @author makejava
 * @since 2023-02-20 17:34:40
 */
public class Assets implements Serializable {
    private static final long serialVersionUID = 383815077848727150L;
    /**
     * 主键id
     */
    private Long id;
    /**
     * 资产编号
     */
    private String serialnumber;
    /**
     * 所属项目id
     */
    private Long projectId;
    /**
     * 所属项目名
     */
    private String projectName;
    /**
     * 所属时间段（开始）
     */
    private Date timeStart;
    /**
     * 所属时间段（结束）
     */
    private Date timeEnd;
    /**
     * 资产类型（见字典表assetsType）
     */
    private String type;
    /**
     * 能源类型（见字典表energyType）
     */
    private String energyType;
    /**
     * 资产状态（见字典表assetsStatus）
     */
    private Integer status;
    /**
     * 委托状态（见字典表assetsEntrustStatus）
     */
    private Integer entrustStatus;
    /**
     * 资产总数
     */
    private Double totalQuantity;
    /**
     * 库存数量
     */
    private Double availableQuantity;
    /**
     * 冻结库存数量
     */
    private Double frozenQuantity;
    /**
     * 过期数量
     */
    private Double expiredQuantity;
    /**
     * 交易数量
     */
    private Double transactionQuantity;
    /**
     * 成交收益（元）
     */
    private Double transactionIncome;
    /**
     * 权益数量类型（见字典表equityQuantityType）
     */
    private String equityQuantityType;
    /**
     * 单位
     */
    private String unit;
    /**
     * 过期时间
     */
    private Date closeTime;
    /**
     * 所属组织id
     */
    private Long customerId;
    /**
     * 资产委托组织id
     */
    private Long entrustCustomerId;
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

    public Long getProjectId() {
        return projectId;
    }

    public void setProjectId(Long projectId) {
        this.projectId = projectId;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public Date getTimeStart() {
        return timeStart;
    }

    public void setTimeStart(Date timeStart) {
        this.timeStart = timeStart;
    }

    public Date getTimeEnd() {
        return timeEnd;
    }

    public void setTimeEnd(Date timeEnd) {
        this.timeEnd = timeEnd;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getEnergyType() {
        return energyType;
    }

    public void setEnergyType(String energyType) {
        this.energyType = energyType;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getEntrustStatus() {
        return entrustStatus;
    }

    public void setEntrustStatus(Integer entrustStatus) {
        this.entrustStatus = entrustStatus;
    }

    public Double getTotalQuantity() {
        return totalQuantity;
    }

    public void setTotalQuantity(Double totalQuantity) {
        this.totalQuantity = totalQuantity;
    }

    public Double getAvailableQuantity() {
        return availableQuantity;
    }

    public void setAvailableQuantity(Double availableQuantity) {
        this.availableQuantity = availableQuantity;
    }

    public Double getFrozenQuantity() {
        return frozenQuantity;
    }

    public void setFrozenQuantity(Double frozenQuantity) {
        this.frozenQuantity = frozenQuantity;
    }

    public Double getExpiredQuantity() {
        return expiredQuantity;
    }

    public void setExpiredQuantity(Double expiredQuantity) {
        this.expiredQuantity = expiredQuantity;
    }

    public Double getTransactionQuantity() {
        return transactionQuantity;
    }

    public void setTransactionQuantity(Double transactionQuantity) {
        this.transactionQuantity = transactionQuantity;
    }

    public Double getTransactionIncome() {
        return transactionIncome;
    }

    public void setTransactionIncome(Double transactionIncome) {
        this.transactionIncome = transactionIncome;
    }

    public String getEquityQuantityType() {
        return equityQuantityType;
    }

    public void setEquityQuantityType(String equityQuantityType) {
        this.equityQuantityType = equityQuantityType;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public Date getCloseTime() {
        return closeTime;
    }

    public void setCloseTime(Date closeTime) {
        this.closeTime = closeTime;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public Long getEntrustCustomerId() {
        return entrustCustomerId;
    }

    public void setEntrustCustomerId(Long entrustCustomerId) {
        this.entrustCustomerId = entrustCustomerId;
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

