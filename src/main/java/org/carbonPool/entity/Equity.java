package org.carbonPool.entity;

import java.util.Date;
import java.io.Serializable;

/**
 * 权益表(Equity)实体类
 *
 * @author makejava
 * @since 2023-02-20 17:35:55
 */
public class Equity implements Serializable {
    private static final long serialVersionUID = -75524370557021434L;
    /**
     * 主键id
     */
    private Long id;
    /**
     * 权益编号
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
     * 所属时间段
     */
    private Date date;
    /**
     * 等效减排量（tCO2）
     */
    private Double reductionQuantity;
    /**
     * 权益类型（见字典表equityType）
     */
    private String type;
    /**
     * 数量类型（见字典表quantityType）
     */
    private String quantityType;
    /**
     * 权益状态（见字典表equityStatus）
     */
    private Integer status;
    /**
     * 权益委托状态（见字典表equityEntrustStatus）
     */
    private Integer entrustStatus;
    /**
     * 估算数量（KWH）
     */
    private Double estimatedQuantity;
    /**
     * 实际数量（KWH）
     */
    private Double quantity;
    /**
     * 关联资产类型（见字典表assetsType）
     */
    private String relationAssetType;
    /**
     * 关联资产数量（MWh）
     */
    private Double relationAssetQuantity;
    /**
     * 权益持有人
     */
    private String holderName;
    /**
     * 单位（关联资产数量）
     */
    private String unit;
    /**
     * 开发时间（关联资产）
     */
    private Date developedTime;
    /**
     * 权益消纳人
     */
    private String consumerName;
    /**
     * 项目所属组织id
     */
    private Long customerId;
    /**
     * 项目委托的组织id
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

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Double getReductionQuantity() {
        return reductionQuantity;
    }

    public void setReductionQuantity(Double reductionQuantity) {
        this.reductionQuantity = reductionQuantity;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getQuantityType() {
        return quantityType;
    }

    public void setQuantityType(String quantityType) {
        this.quantityType = quantityType;
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

    public Double getEstimatedQuantity() {
        return estimatedQuantity;
    }

    public void setEstimatedQuantity(Double estimatedQuantity) {
        this.estimatedQuantity = estimatedQuantity;
    }

    public Double getQuantity() {
        return quantity;
    }

    public void setQuantity(Double quantity) {
        this.quantity = quantity;
    }

    public String getRelationAssetType() {
        return relationAssetType;
    }

    public void setRelationAssetType(String relationAssetType) {
        this.relationAssetType = relationAssetType;
    }

    public Double getRelationAssetQuantity() {
        return relationAssetQuantity;
    }

    public void setRelationAssetQuantity(Double relationAssetQuantity) {
        this.relationAssetQuantity = relationAssetQuantity;
    }

    public String getHolderName() {
        return holderName;
    }

    public void setHolderName(String holderName) {
        this.holderName = holderName;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public Date getDevelopedTime() {
        return developedTime;
    }

    public void setDevelopedTime(Date developedTime) {
        this.developedTime = developedTime;
    }

    public String getConsumerName() {
        return consumerName;
    }

    public void setConsumerName(String consumerName) {
        this.consumerName = consumerName;
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

