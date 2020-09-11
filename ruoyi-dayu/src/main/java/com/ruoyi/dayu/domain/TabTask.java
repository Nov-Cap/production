package com.ruoyi.dayu.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 任务表对象 tab_task
 * 
 * @author ruoyi
 * @date 2020-09-08
 */
public class TabTask extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** id */
    private Long id;

    /** 任务号 */
    @Excel(name = "任务号")
    private String taskNo;

    /** 下单人员 */
    @Excel(name = "下单人员")
    private Long orderPerson;

    /** 生产主管 */
    @Excel(name = "生产主管")
    private Long productionCharge;

    /** 生产人员 */
    @Excel(name = "生产人员")
    private Long productionPersonnel;

    /** 状态 */
    @Excel(name = "状态")
    private Integer state;

    /** 任务类型 */
    @Excel(name = "任务类型")
    private Integer taskType;

    /** 发件人发货地址 */
    @Excel(name = "发件人发货地址")
    private String senderShippingAddress;

    /** 发件人发货公司 */
    @Excel(name = "发件人发货公司")
    private String senderShippingCompany;

    /** 发件人 */
    @Excel(name = "发件人")
    private Long senderUserid;

    /** 收件人信息收货地址 */
    @Excel(name = "收件人信息收货地址")
    private String recipientShippingAddress;

    /** 收件人信息收货公司 */
    @Excel(name = "收件人信息收货公司")
    private String recipientShippingCompany;

    /** 收件人信息收货人 */
    @Excel(name = "收件人信息收货人")
    private Long recipientUserid;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setTaskNo(String taskNo) 
    {
        this.taskNo = taskNo;
    }

    public String getTaskNo() 
    {
        return taskNo;
    }
    public void setOrderPerson(Long orderPerson) 
    {
        this.orderPerson = orderPerson;
    }

    public Long getOrderPerson() 
    {
        return orderPerson;
    }
    public void setProductionCharge(Long productionCharge) 
    {
        this.productionCharge = productionCharge;
    }

    public Long getProductionCharge() 
    {
        return productionCharge;
    }
    public void setProductionPersonnel(Long productionPersonnel) 
    {
        this.productionPersonnel = productionPersonnel;
    }

    public Long getProductionPersonnel() 
    {
        return productionPersonnel;
    }
    public void setState(Integer state) 
    {
        this.state = state;
    }

    public Integer getState() 
    {
        return state;
    }
    public void setTaskType(Integer taskType) 
    {
        this.taskType = taskType;
    }

    public Integer getTaskType() 
    {
        return taskType;
    }
    public void setSenderShippingAddress(String senderShippingAddress) 
    {
        this.senderShippingAddress = senderShippingAddress;
    }

    public String getSenderShippingAddress() 
    {
        return senderShippingAddress;
    }
    public void setSenderShippingCompany(String senderShippingCompany) 
    {
        this.senderShippingCompany = senderShippingCompany;
    }

    public String getSenderShippingCompany() 
    {
        return senderShippingCompany;
    }
    public void setSenderUserid(Long senderUserid) 
    {
        this.senderUserid = senderUserid;
    }

    public Long getSenderUserid() 
    {
        return senderUserid;
    }
    public void setRecipientShippingAddress(String recipientShippingAddress) 
    {
        this.recipientShippingAddress = recipientShippingAddress;
    }

    public String getRecipientShippingAddress() 
    {
        return recipientShippingAddress;
    }
    public void setRecipientShippingCompany(String recipientShippingCompany) 
    {
        this.recipientShippingCompany = recipientShippingCompany;
    }

    public String getRecipientShippingCompany() 
    {
        return recipientShippingCompany;
    }
    public void setRecipientUserid(Long recipientUserid) 
    {
        this.recipientUserid = recipientUserid;
    }

    public Long getRecipientUserid() 
    {
        return recipientUserid;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("taskNo", getTaskNo())
            .append("orderPerson", getOrderPerson())
            .append("productionCharge", getProductionCharge())
            .append("productionPersonnel", getProductionPersonnel())
            .append("state", getState())
            .append("taskType", getTaskType())
            .append("senderShippingAddress", getSenderShippingAddress())
            .append("senderShippingCompany", getSenderShippingCompany())
            .append("senderUserid", getSenderUserid())
            .append("recipientShippingAddress", getRecipientShippingAddress())
            .append("recipientShippingCompany", getRecipientShippingCompany())
            .append("recipientUserid", getRecipientUserid())
            .append("remark", getRemark())
            .append("updateTime", getUpdateTime())
            .append("createTime", getCreateTime())
            .append("updateby", getUpdateBy())
            .append("createby", getCreateBy())
            .toString();
    }
}
