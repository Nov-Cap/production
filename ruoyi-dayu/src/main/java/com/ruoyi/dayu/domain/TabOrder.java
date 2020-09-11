package com.ruoyi.dayu.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 订单信息对象 tab_order
 *
 * @author ruoyi
 * @date 2020-09-10
 */
public class TabOrder extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** id */
    private Long id;

    /** 订单号 */
    @Excel(name = "订单号")
    private String orderNo;

    /** 任务表id */
    @Excel(name = "任务表id")
    private Long taskId;

    /** 下单时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "下单时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date orderTime;

    /** 应完工日期 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "应完工日期", width = 30, dateFormat = "yyyy-MM-dd")
    private Date completionTime;

    /** 产品名称 */
    @Excel(name = "产品名称")
    private String productName;

    /** 产品名称数量 */
    @Excel(name = "产品名称数量")
    private Long productNo;

    /** 探头数量 */
    @Excel(name = "探头数量")
    private Integer probesNumber;

    /** 探头外壳 */
    @Excel(name = "探头外壳")
    private Integer probesHouse;

    /** 购买公司 */
    @Excel(name = "购买公司")
    private String buyingCompany;

    /** 开发板数量 */
    @Excel(name = "开发板数量")
    private Integer developmentBoardsNumber;

    /** 量程 */
    @Excel(name = "量程")
    private String taskRange;

    /** 盲区 */
    @Excel(name = "盲区")
    private String blindArea;

    /** 探头类别 */
    @Excel(name = "探头类别")
    private Integer probeType;

    /** 温度传感器 */
    @Excel(name = "温度传感器")
    private Integer temperatureSensor;

    /** 探头频率 */
    @Excel(name = "探头频率")
    private String probeFrequency;

    /** 探头安装尺寸 */
    @Excel(name = "探头安装尺寸")
    private Integer probeInstallationSize;

    /** 铭牌上的型号 */
    @Excel(name = "铭牌上的型号")
    private String plateModel;

    /** 铭牌上的公司名称 */
    @Excel(name = "铭牌上的公司名称")
    private String plateCompany;

    /** 发货时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "发货时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date deliveryTime;

    /** 快递类型 */
    @Excel(name = "快递类型")
    private Integer expressType;

    /** 电缆线长 */
    @Excel(name = "电缆线长")
    private Integer probeCableLength;

    /** 分体电缆线芯数 */
    @Excel(name = "分体电缆线芯数")
    private Integer probeSplitCableCoreNumber;

    /** O型圈 */
    @Excel(name = "O型圈")
    private Integer oRing;

    /** 螺母 */
    @Excel(name = "螺母")
    private Integer nut;

    /** 配套脉冲变压器类型 */
    @Excel(name = "配套脉冲变压器类型")
    private Integer matchingPulseTransformerType;

    /** 脉冲变压器数量 */
    @Excel(name = "脉冲变压器数量")
    private Integer pulseTransformersNumber;

    /** 合同上的技术指标image地址 */
    @Excel(name = "合同上的技术指标image地址")
    private String contractSpecificationsImageUrl;

    /** 合同上的技术指标描述 */
    @Excel(name = "合同上的技术指标描述")
    private String contractSpecificationsDescribe;

    /** 特殊要求 */
    @Excel(name = "特殊要求")
    private String specialRequirements;

    /** 其他 */
    @Excel(name = "其他")
    private String productOther;

    /** 外壳种类 */
    @Excel(name = "外壳种类")
    private Integer shellType;

    /** 线制 */
    @Excel(name = "线制")
    private Integer threadSystem;

    /** 供电电源 */
    @Excel(name = "供电电源")
    private Integer powerSupply;

    /** 输出 */
    @Excel(name = "输出")
    private Integer output;

    /** 继电器 */
    @Excel(name = "继电器")
    private Integer relay;

    /** 通讯协议 */
    @Excel(name = "通讯协议")
    private Integer communicationProtocol;

    /** 说明书类型 */
    @Excel(name = "说明书类型")
    private Integer descriptionType;

    /** 螺纹尺寸 */
    @Excel(name = "螺纹尺寸")
    private Integer threadSize;

    /** 法兰尺寸 */
    @Excel(name = "法兰尺寸")
    private Integer flangeSize;

    /** 被测介质 */
    @Excel(name = "被测介质")
    private String measuredMedium;

    /** 法兰材质 */
    @Excel(name = "法兰材质")
    private Integer flangeMaterial;

    /** 是否允许接线 */
    @Excel(name = "是否允许接线")
    private Integer isWiringAllowed;

    /** 备注 */
    @Excel(name = "备注")
    private String remarks;

    /** 型号 */
    @Excel(name = "型号")
    private String productModel;

    /** 产品名称 */
    @Excel(name = "产品名称")
    private String mpProductName;

    /** 产品型号 */
    @Excel(name = "产品型号")
    private String mpProductModel;

    /** 量程 */
    @Excel(name = "量程")
    private String mpTaskRange;

    /** 线制 */
    @Excel(name = "线制")
    private String mpThreadSysteml;

    /** 电缆线长 */
    @Excel(name = "电缆线长")
    private String mpCableLength;

    /** 工作温度 */
    @Excel(name = "工作温度")
    private String mpWorkingTemperature;

    /** 供电 */
    @Excel(name = "供电")
    private String mpPowerSupply;

    /** 输出 */
    @Excel(name = "输出")
    private String mpOutput;

    /** 公司名称 */
    @Excel(name = "公司名称")
    private String mpCorporateName;

    /** 产品位号 */
    @Excel(name = "产品位号")
    private String mpProductItemNumber;

    /** 防护等级 */
    @Excel(name = "防护等级")
    private String mpProtectionLevel;

    /** 产品编号 */
    @Excel(name = "产品编号")
    private String mpProductNumber;

    /** 服务电话 */
    @Excel(name = "服务电话")
    private String mpProductTelephone;

    public void setId(Long id)
    {
        this.id = id;
    }

    public Long getId()
    {
        return id;
    }
    public void setOrderNo(String orderNo)
    {
        this.orderNo = orderNo;
    }

    public String getOrderNo()
    {
        return orderNo;
    }
    public void setTaskId(Long taskId)
    {
        this.taskId = taskId;
    }

    public Long getTaskId()
    {
        return taskId;
    }
    public void setOrderTime(Date orderTime)
    {
        this.orderTime = orderTime;
    }

    public Date getOrderTime()
    {
        return orderTime;
    }
    public void setCompletionTime(Date completionTime)
    {
        this.completionTime = completionTime;
    }

    public Date getCompletionTime()
    {
        return completionTime;
    }
    public void setProductName(String productName)
    {
        this.productName = productName;
    }

    public String getProductName()
    {
        return productName;
    }
    public void setProductNo(Long productNo)
    {
        this.productNo = productNo;
    }

    public Long getProductNo()
    {
        return productNo;
    }
    public void setProbesNumber(Integer probesNumber)
    {
        this.probesNumber = probesNumber;
    }

    public Integer getProbesNumber()
    {
        return probesNumber;
    }
    public void setProbesHouse(Integer probesHouse)
    {
        this.probesHouse = probesHouse;
    }

    public Integer getProbesHouse()
    {
        return probesHouse;
    }
    public void setBuyingCompany(String buyingCompany)
    {
        this.buyingCompany = buyingCompany;
    }

    public String getBuyingCompany()
    {
        return buyingCompany;
    }
    public void setDevelopmentBoardsNumber(Integer developmentBoardsNumber)
    {
        this.developmentBoardsNumber = developmentBoardsNumber;
    }

    public Integer getDevelopmentBoardsNumber()
    {
        return developmentBoardsNumber;
    }
    public void setTaskRange(String taskRange)
    {
        this.taskRange = taskRange;
    }

    public String getTaskRange()
    {
        return taskRange;
    }
    public void setBlindArea(String blindArea)
    {
        this.blindArea = blindArea;
    }

    public String getBlindArea()
    {
        return blindArea;
    }
    public void setProbeType(Integer probeType)
    {
        this.probeType = probeType;
    }

    public Integer getProbeType()
    {
        return probeType;
    }
    public void setTemperatureSensor(Integer temperatureSensor)
    {
        this.temperatureSensor = temperatureSensor;
    }

    public Integer getTemperatureSensor()
    {
        return temperatureSensor;
    }
    public void setProbeFrequency(String probeFrequency)
    {
        this.probeFrequency = probeFrequency;
    }

    public String getProbeFrequency()
    {
        return probeFrequency;
    }
    public void setProbeInstallationSize(Integer probeInstallationSize)
    {
        this.probeInstallationSize = probeInstallationSize;
    }

    public Integer getProbeInstallationSize()
    {
        return probeInstallationSize;
    }
    public void setPlateModel(String plateModel)
    {
        this.plateModel = plateModel;
    }

    public String getPlateModel()
    {
        return plateModel;
    }
    public void setPlateCompany(String plateCompany)
    {
        this.plateCompany = plateCompany;
    }

    public String getPlateCompany()
    {
        return plateCompany;
    }
    public void setDeliveryTime(Date deliveryTime)
    {
        this.deliveryTime = deliveryTime;
    }

    public Date getDeliveryTime()
    {
        return deliveryTime;
    }
    public void setExpressType(Integer expressType)
    {
        this.expressType = expressType;
    }

    public Integer getExpressType()
    {
        return expressType;
    }
    public void setProbeCableLength(Integer probeCableLength)
    {
        this.probeCableLength = probeCableLength;
    }

    public Integer getProbeCableLength()
    {
        return probeCableLength;
    }
    public void setProbeSplitCableCoreNumber(Integer probeSplitCableCoreNumber)
    {
        this.probeSplitCableCoreNumber = probeSplitCableCoreNumber;
    }

    public Integer getProbeSplitCableCoreNumber()
    {
        return probeSplitCableCoreNumber;
    }
    public void setoRing(Integer oRing)
    {
        this.oRing = oRing;
    }

    public Integer getoRing()
    {
        return oRing;
    }
    public void setNut(Integer nut)
    {
        this.nut = nut;
    }

    public Integer getNut()
    {
        return nut;
    }
    public void setMatchingPulseTransformerType(Integer matchingPulseTransformerType)
    {
        this.matchingPulseTransformerType = matchingPulseTransformerType;
    }

    public Integer getMatchingPulseTransformerType()
    {
        return matchingPulseTransformerType;
    }
    public void setPulseTransformersNumber(Integer pulseTransformersNumber)
    {
        this.pulseTransformersNumber = pulseTransformersNumber;
    }

    public Integer getPulseTransformersNumber()
    {
        return pulseTransformersNumber;
    }
    public void setContractSpecificationsImageUrl(String contractSpecificationsImageUrl)
    {
        this.contractSpecificationsImageUrl = contractSpecificationsImageUrl;
    }

    public String getContractSpecificationsImageUrl()
    {
        return contractSpecificationsImageUrl;
    }
    public void setContractSpecificationsDescribe(String contractSpecificationsDescribe)
    {
        this.contractSpecificationsDescribe = contractSpecificationsDescribe;
    }

    public String getContractSpecificationsDescribe()
    {
        return contractSpecificationsDescribe;
    }
    public void setSpecialRequirements(String specialRequirements)
    {
        this.specialRequirements = specialRequirements;
    }

    public String getSpecialRequirements()
    {
        return specialRequirements;
    }
    public void setProductOther(String productOther)
    {
        this.productOther = productOther;
    }

    public String getProductOther()
    {
        return productOther;
    }
    public void setShellType(Integer shellType)
    {
        this.shellType = shellType;
    }

    public Integer getShellType()
    {
        return shellType;
    }
    public void setThreadSystem(Integer threadSystem)
    {
        this.threadSystem = threadSystem;
    }

    public Integer getThreadSystem()
    {
        return threadSystem;
    }
    public void setPowerSupply(Integer powerSupply)
    {
        this.powerSupply = powerSupply;
    }

    public Integer getPowerSupply()
    {
        return powerSupply;
    }
    public void setOutput(Integer output)
    {
        this.output = output;
    }

    public Integer getOutput()
    {
        return output;
    }
    public void setRelay(Integer relay)
    {
        this.relay = relay;
    }

    public Integer getRelay()
    {
        return relay;
    }
    public void setCommunicationProtocol(Integer communicationProtocol)
    {
        this.communicationProtocol = communicationProtocol;
    }

    public Integer getCommunicationProtocol()
    {
        return communicationProtocol;
    }
    public void setDescriptionType(Integer descriptionType)
    {
        this.descriptionType = descriptionType;
    }

    public Integer getDescriptionType()
    {
        return descriptionType;
    }
    public void setThreadSize(Integer threadSize)
    {
        this.threadSize = threadSize;
    }

    public Integer getThreadSize()
    {
        return threadSize;
    }
    public void setFlangeSize(Integer flangeSize)
    {
        this.flangeSize = flangeSize;
    }

    public Integer getFlangeSize()
    {
        return flangeSize;
    }
    public void setMeasuredMedium(String measuredMedium)
    {
        this.measuredMedium = measuredMedium;
    }

    public String getMeasuredMedium()
    {
        return measuredMedium;
    }
    public void setFlangeMaterial(Integer flangeMaterial)
    {
        this.flangeMaterial = flangeMaterial;
    }

    public Integer getFlangeMaterial()
    {
        return flangeMaterial;
    }
    public void setIsWiringAllowed(Integer isWiringAllowed)
    {
        this.isWiringAllowed = isWiringAllowed;
    }

    public Integer getIsWiringAllowed()
    {
        return isWiringAllowed;
    }
    public void setRemarks(String remarks)
    {
        this.remarks = remarks;
    }

    public String getRemarks()
    {
        return remarks;
    }
    public void setProductModel(String productModel)
    {
        this.productModel = productModel;
    }

    public String getProductModel()
    {
        return productModel;
    }
    public void setMpProductName(String mpProductName)
    {
        this.mpProductName = mpProductName;
    }

    public String getMpProductName()
    {
        return mpProductName;
    }
    public void setMpProductModel(String mpProductModel)
    {
        this.mpProductModel = mpProductModel;
    }

    public String getMpProductModel()
    {
        return mpProductModel;
    }
    public void setMpTaskRange(String mpTaskRange)
    {
        this.mpTaskRange = mpTaskRange;
    }

    public String getMpTaskRange()
    {
        return mpTaskRange;
    }
    public void setMpThreadSysteml(String mpThreadSysteml)
    {
        this.mpThreadSysteml = mpThreadSysteml;
    }

    public String getMpThreadSysteml()
    {
        return mpThreadSysteml;
    }
    public void setMpCableLength(String mpCableLength)
    {
        this.mpCableLength = mpCableLength;
    }

    public String getMpCableLength()
    {
        return mpCableLength;
    }
    public void setMpWorkingTemperature(String mpWorkingTemperature)
    {
        this.mpWorkingTemperature = mpWorkingTemperature;
    }

    public String getMpWorkingTemperature()
    {
        return mpWorkingTemperature;
    }
    public void setMpPowerSupply(String mpPowerSupply)
    {
        this.mpPowerSupply = mpPowerSupply;
    }

    public String getMpPowerSupply()
    {
        return mpPowerSupply;
    }
    public void setMpOutput(String mpOutput)
    {
        this.mpOutput = mpOutput;
    }

    public String getMpOutput()
    {
        return mpOutput;
    }
    public void setMpCorporateName(String mpCorporateName)
    {
        this.mpCorporateName = mpCorporateName;
    }

    public String getMpCorporateName()
    {
        return mpCorporateName;
    }
    public void setMpProductItemNumber(String mpProductItemNumber)
    {
        this.mpProductItemNumber = mpProductItemNumber;
    }

    public String getMpProductItemNumber()
    {
        return mpProductItemNumber;
    }
    public void setMpProtectionLevel(String mpProtectionLevel)
    {
        this.mpProtectionLevel = mpProtectionLevel;
    }

    public String getMpProtectionLevel()
    {
        return mpProtectionLevel;
    }
    public void setMpProductNumber(String mpProductNumber)
    {
        this.mpProductNumber = mpProductNumber;
    }

    public String getMpProductNumber()
    {
        return mpProductNumber;
    }
    public void setMpProductTelephone(String mpProductTelephone)
    {
        this.mpProductTelephone = mpProductTelephone;
    }

    public String getMpProductTelephone()
    {
        return mpProductTelephone;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
                .append("id", getId())
                .append("orderNo", getOrderNo())
                .append("taskId", getTaskId())
                .append("orderTime", getOrderTime())
                .append("completionTime", getCompletionTime())
                .append("productName", getProductName())
                .append("productNo", getProductNo())
                .append("probesNumber", getProbesNumber())
                .append("probesHouse", getProbesHouse())
                .append("buyingCompany", getBuyingCompany())
                .append("developmentBoardsNumber", getDevelopmentBoardsNumber())
                .append("taskRange", getTaskRange())
                .append("blindArea", getBlindArea())
                .append("probeType", getProbeType())
                .append("temperatureSensor", getTemperatureSensor())
                .append("probeFrequency", getProbeFrequency())
                .append("probeInstallationSize", getProbeInstallationSize())
                .append("plateModel", getPlateModel())
                .append("plateCompany", getPlateCompany())
                .append("deliveryTime", getDeliveryTime())
                .append("expressType", getExpressType())
                .append("probeCableLength", getProbeCableLength())
                .append("probeSplitCableCoreNumber", getProbeSplitCableCoreNumber())
                .append("oRing", getoRing())
                .append("nut", getNut())
                .append("matchingPulseTransformerType", getMatchingPulseTransformerType())
                .append("pulseTransformersNumber", getPulseTransformersNumber())
                .append("contractSpecificationsImageUrl", getContractSpecificationsImageUrl())
                .append("contractSpecificationsDescribe", getContractSpecificationsDescribe())
                .append("specialRequirements", getSpecialRequirements())
                .append("productOther", getProductOther())
                .append("shellType", getShellType())
                .append("threadSystem", getThreadSystem())
                .append("powerSupply", getPowerSupply())
                .append("output", getOutput())
                .append("relay", getRelay())
                .append("communicationProtocol", getCommunicationProtocol())
                .append("descriptionType", getDescriptionType())
                .append("threadSize", getThreadSize())
                .append("flangeSize", getFlangeSize())
                .append("measuredMedium", getMeasuredMedium())
                .append("flangeMaterial", getFlangeMaterial())
                .append("isWiringAllowed", getIsWiringAllowed())
                .append("remarks", getRemarks())
                .append("productModel", getProductModel())
                .append("mpProductName", getMpProductName())
                .append("mpProductModel", getMpProductModel())
                .append("mpTaskRange", getMpTaskRange())
                .append("mpThreadSysteml", getMpThreadSysteml())
                .append("mpCableLength", getMpCableLength())
                .append("mpWorkingTemperature", getMpWorkingTemperature())
                .append("mpPowerSupply", getMpPowerSupply())
                .append("mpOutput", getMpOutput())
                .append("mpCorporateName", getMpCorporateName())
                .append("mpProductItemNumber", getMpProductItemNumber())
                .append("mpProtectionLevel", getMpProtectionLevel())
                .append("mpProductNumber", getMpProductNumber())
                .append("mpProductTelephone", getMpProductTelephone())
                .append("createTime", getCreateTime())
                .append("updateTime", getUpdateTime())
                .append("createBy", getCreateBy())
                .append("updateBy", getUpdateBy())
                .toString();
    }
}