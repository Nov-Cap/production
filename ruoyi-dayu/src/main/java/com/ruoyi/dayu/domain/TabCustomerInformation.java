package com.ruoyi.dayu.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 客户信息对象 tab_customer_information
 * 
 * @author ruoyi
 * @date 2020-09-08
 */
public class TabCustomerInformation extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** id */
    private Long id;

    /** 客户名称 */
    @Excel(name = "客户名称")
    private String customerName;

    /** 联系人 */
    @Excel(name = "联系人")
    private String contacts;

    /** 联系电话 */
    @Excel(name = "联系电话")
    private String contactNumber;

    /** 收货地址 */
    @Excel(name = "收货地址")
    private String shippingAddress;

    /** 第一次成交时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "第一次成交时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date firstTransaction;

    /** 开票信息 */
    private String billingInformation;

    /** 预留字段1 */
    private String reservedFields1;

    /** 预留字段2 */
    private String reservedFields2;

    /** 预留字段3 */
    private String reservedFields3;

    /** 预留字段4 */
    private String reservedFields4;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setCustomerName(String customerName) 
    {
        this.customerName = customerName;
    }

    public String getCustomerName() 
    {
        return customerName;
    }
    public void setContacts(String contacts) 
    {
        this.contacts = contacts;
    }

    public String getContacts() 
    {
        return contacts;
    }
    public void setContactNumber(String contactNumber) 
    {
        this.contactNumber = contactNumber;
    }

    public String getContactNumber() 
    {
        return contactNumber;
    }
    public void setShippingAddress(String shippingAddress) 
    {
        this.shippingAddress = shippingAddress;
    }

    public String getShippingAddress() 
    {
        return shippingAddress;
    }
    public void setFirstTransaction(Date firstTransaction) 
    {
        this.firstTransaction = firstTransaction;
    }

    public Date getFirstTransaction() 
    {
        return firstTransaction;
    }
    public void setBillingInformation(String billingInformation) 
    {
        this.billingInformation = billingInformation;
    }

    public String getBillingInformation() 
    {
        return billingInformation;
    }
    public void setReservedFields1(String reservedFields1) 
    {
        this.reservedFields1 = reservedFields1;
    }

    public String getReservedFields1() 
    {
        return reservedFields1;
    }
    public void setReservedFields2(String reservedFields2) 
    {
        this.reservedFields2 = reservedFields2;
    }

    public String getReservedFields2() 
    {
        return reservedFields2;
    }
    public void setReservedFields3(String reservedFields3) 
    {
        this.reservedFields3 = reservedFields3;
    }

    public String getReservedFields3() 
    {
        return reservedFields3;
    }
    public void setReservedFields4(String reservedFields4) 
    {
        this.reservedFields4 = reservedFields4;
    }

    public String getReservedFields4() 
    {
        return reservedFields4;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("customerName", getCustomerName())
            .append("createBy", getCreateBy())
            .append("updateBy", getUpdateBy())
            .append("createTime", getCreateTime())
            .append("updateTime", getUpdateTime())
            .append("remark", getRemark())
            .append("contacts", getContacts())
            .append("contactNumber", getContactNumber())
            .append("shippingAddress", getShippingAddress())
            .append("firstTransaction", getFirstTransaction())
            .append("billingInformation", getBillingInformation())
            .append("reservedFields1", getReservedFields1())
            .append("reservedFields2", getReservedFields2())
            .append("reservedFields3", getReservedFields3())
            .append("reservedFields4", getReservedFields4())
            .toString();
    }
}
