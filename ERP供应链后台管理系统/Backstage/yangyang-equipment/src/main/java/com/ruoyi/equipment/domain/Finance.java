package com.ruoyi.equipment.domain;

import java.math.BigDecimal;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 财务数据对象 lp_finance
 *
 * @author jia
 * @date 2022-11-27
 */
public class Finance extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 主键递增 */
    private Integer financeId;

    /** 财务数据名称 */
    @Excel(name = "财务数据名称")
    private String financeName;

    /** 财务数据内容 */
    @Excel(name = "财务数据内容")
    private String financeContent;

    /** 发生金额 */
    @Excel(name = "发生金额")
    private BigDecimal financeMoney;

    /** 余额 */
    @Excel(name = "余额")
    private BigDecimal financeBalance;

    /** 供应商ID */
    @Excel(name = "供应商ID")
    private Integer supplierId;

    /** 0表示支出  1表示收入 */
    @Excel(name = "0表示支出  1表示收入")
    private Integer financeStatus;

    /** 0表示未审核  1表示审核  2表示审批 */
    @Excel(name = "0表示未审核  1表示审核  2表示审批")
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

    public void setFinanceId(Integer financeId)
    {
        this.financeId = financeId;
    }

    public Integer getFinanceId()
    {
        return financeId;
    }
    public void setFinanceName(String financeName)
    {
        this.financeName = financeName;
    }

    public String getFinanceName()
    {
        return financeName;
    }
    public void setFinanceContent(String financeContent)
    {
        this.financeContent = financeContent;
    }

    public String getFinanceContent()
    {
        return financeContent;
    }
    public void setFinanceMoney(BigDecimal financeMoney)
    {
        this.financeMoney = financeMoney;
    }

    public BigDecimal getFinanceMoney()
    {
        return financeMoney;
    }
    public void setFinanceBalance(BigDecimal financeBalance)
    {
        this.financeBalance = financeBalance;
    }

    public BigDecimal getFinanceBalance()
    {
        return financeBalance;
    }
    public void setSupplierId(Integer supplierId)
    {
        this.supplierId = supplierId;
    }

    public Integer getSupplierId()
    {
        return supplierId;
    }
    public void setFinanceStatus(Integer financeStatus)
    {
        this.financeStatus = financeStatus;
    }

    public Integer getFinanceStatus()
    {
        return financeStatus;
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
                .append("financeId", getFinanceId())
                .append("financeName", getFinanceName())
                .append("financeContent", getFinanceContent())
                .append("financeMoney", getFinanceMoney())
                .append("financeBalance", getFinanceBalance())
                .append("supplierId", getSupplierId())
                .append("financeStatus", getFinanceStatus())
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