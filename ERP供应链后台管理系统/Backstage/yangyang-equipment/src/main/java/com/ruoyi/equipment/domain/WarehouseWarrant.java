package com.ruoyi.equipment.domain;

import java.math.BigDecimal;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 入库列表对象 lp_warehouse_warrant
 *
 * @author jia
 * @date 2022-12-06
 */
public class WarehouseWarrant extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 主键 */
    private Integer warehouseWarrantId;

    /** 入库名称 */
    @Excel(name = "入库名称")
    private String warehouseWarrantName;

    /** 入库数量 */
    @Excel(name = "入库数量")
    private Integer warehouseWarrantNum;

    /** 入库价格 */
    @Excel(name = "入库价格")
    private BigDecimal warehouseWarrantPrice;

    /** 单位 */
    @Excel(name = "单位")
    private String unit;

    /** 库房ID */
    @Excel(name = "库房ID")
    private Integer warehouseId;

    /** 货架ID */
    @Excel(name = "货架ID")
    private Integer shelfId;

    /** 库位ID */
    @Excel(name = "库位ID")
    private Integer locationId;

    /** 采购状态：0表示未审核  1表示审核  2表示审批 */
    @Excel(name = "采购状态：0表示未审核  1表示审核  2表示审批")
    private Integer auditStatus;

    /** 审核意见 */
    @Excel(name = "审核意见")
    private String auditOpinion;

    /** 审核时间 */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Excel(name = "审核时间", width = 30, dateFormat = "yyyy-MM-dd HH:mm:ss")
    private Date auditTime;

    /** 审核人员 */
    @Excel(name = "审核人员")
    private String auditPerson;

    /** 审批意见 */
    @Excel(name = "审批意见")
    private String approverOpinion;

    /** 审批时间 */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Excel(name = "审批时间", width = 30, dateFormat = "yyyy-MM-dd HH:mm:ss")
    private Date approverTime;

    /** 审批人员 */
    @Excel(name = "审批人员")
    private String approverPerson;

    public void setWarehouseWarrantId(Integer warehouseWarrantId)
    {
        this.warehouseWarrantId = warehouseWarrantId;
    }

    public Integer getWarehouseWarrantId()
    {
        return warehouseWarrantId;
    }
    public void setWarehouseWarrantName(String warehouseWarrantName)
    {
        this.warehouseWarrantName = warehouseWarrantName;
    }

    public String getWarehouseWarrantName()
    {
        return warehouseWarrantName;
    }
    public void setWarehouseWarrantNum(Integer warehouseWarrantNum)
    {
        this.warehouseWarrantNum = warehouseWarrantNum;
    }

    public Integer getWarehouseWarrantNum()
    {
        return warehouseWarrantNum;
    }
    public void setWarehouseWarrantPrice(BigDecimal warehouseWarrantPrice)
    {
        this.warehouseWarrantPrice = warehouseWarrantPrice;
    }

    public BigDecimal getWarehouseWarrantPrice()
    {
        return warehouseWarrantPrice;
    }
    public void setUnit(String unit)
    {
        this.unit = unit;
    }

    public String getUnit()
    {
        return unit;
    }
    public void setWarehouseId(Integer warehouseId)
    {
        this.warehouseId = warehouseId;
    }

    public Integer getWarehouseId()
    {
        return warehouseId;
    }
    public void setShelfId(Integer shelfId)
    {
        this.shelfId = shelfId;
    }

    public Integer getShelfId()
    {
        return shelfId;
    }
    public void setLocationId(Integer locationId)
    {
        this.locationId = locationId;
    }

    public Integer getLocationId()
    {
        return locationId;
    }
    public void setAuditStatus(Integer auditStatus)
    {
        this.auditStatus = auditStatus;
    }

    public Integer getAuditStatus()
    {
        return auditStatus;
    }
    public void setAuditOpinion(String auditOpinion)
    {
        this.auditOpinion = auditOpinion;
    }

    public String getAuditOpinion()
    {
        return auditOpinion;
    }
    public void setAuditTime(Date auditTime)
    {
        this.auditTime = auditTime;
    }

    public Date getAuditTime()
    {
        return auditTime;
    }
    public void setAuditPerson(String auditPerson)
    {
        this.auditPerson = auditPerson;
    }

    public String getAuditPerson()
    {
        return auditPerson;
    }
    public void setApproverOpinion(String approverOpinion)
    {
        this.approverOpinion = approverOpinion;
    }

    public String getApproverOpinion()
    {
        return approverOpinion;
    }
    public void setApproverTime(Date approverTime)
    {
        this.approverTime = approverTime;
    }

    public Date getApproverTime()
    {
        return approverTime;
    }
    public void setApproverPerson(String approverPerson)
    {
        this.approverPerson = approverPerson;
    }

    public String getApproverPerson()
    {
        return approverPerson;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
                .append("warehouseWarrantId", getWarehouseWarrantId())
                .append("warehouseWarrantName", getWarehouseWarrantName())
                .append("warehouseWarrantNum", getWarehouseWarrantNum())
                .append("warehouseWarrantPrice", getWarehouseWarrantPrice())
                .append("unit", getUnit())
                .append("warehouseId", getWarehouseId())
                .append("shelfId", getShelfId())
                .append("locationId", getLocationId())
                .append("auditStatus", getAuditStatus())
                .append("auditOpinion", getAuditOpinion())
                .append("auditTime", getAuditTime())
                .append("auditPerson", getAuditPerson())
                .append("approverOpinion", getApproverOpinion())
                .append("approverTime", getApproverTime())
                .append("approverPerson", getApproverPerson())
                .append("remark", getRemark())
                .append("createBy", getCreateBy())
                .append("createTime", getCreateTime())
                .append("updateBy", getUpdateBy())
                .append("updateTime", getUpdateTime())
                .toString();
    }
}