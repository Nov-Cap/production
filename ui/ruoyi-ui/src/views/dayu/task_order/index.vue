<template>
  <div class="app-container">
    <el-form :model="queryParams" ref="queryForm" :inline="true" v-show="showSearch" label-width="68px">
      <el-form-item label="订单号" prop="orderNo">
        <el-input
          v-model="queryParams.orderNo"
          placeholder="请输入订单号"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="任务表id" prop="taskId">
        <el-input
          v-model="queryParams.taskId"
          placeholder="请输入任务表id"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="下单时间" prop="orderTime">
        <el-date-picker clearable size="small" style="width: 200px"
          v-model="queryParams.orderTime"
          type="date"
          value-format="yyyy-MM-dd"
          placeholder="选择下单时间">
        </el-date-picker>
      </el-form-item>
      <el-form-item label="应完工日期" prop="completionTime">
        <el-date-picker clearable size="small" style="width: 200px"
          v-model="queryParams.completionTime"
          type="date"
          value-format="yyyy-MM-dd"
          placeholder="选择应完工日期">
        </el-date-picker>
      </el-form-item>
      <el-form-item label="产品名称" prop="productName">
        <el-input
          v-model="queryParams.productName"
          placeholder="请输入产品名称"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="产品名称数量" prop="productNo">
        <el-input
          v-model="queryParams.productNo"
          placeholder="请输入产品名称数量"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="探头数量" prop="probesNumber">
        <el-input
          v-model="queryParams.probesNumber"
          placeholder="请输入探头数量"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="探头外壳" prop="probesHouse">
        <el-input
          v-model="queryParams.probesHouse"
          placeholder="请输入探头外壳"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="购买公司" prop="buyingCompany">
        <el-input
          v-model="queryParams.buyingCompany"
          placeholder="请输入购买公司"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="开发板数量" prop="developmentBoardsNumber">
        <el-input
          v-model="queryParams.developmentBoardsNumber"
          placeholder="请输入开发板数量"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="量程" prop="taskRange">
        <el-input
          v-model="queryParams.taskRange"
          placeholder="请输入量程"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="盲区" prop="blindArea">
        <el-input
          v-model="queryParams.blindArea"
          placeholder="请输入盲区"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="探头类别" prop="probeType">
        <el-select v-model="queryParams.probeType" placeholder="请选择探头类别" clearable size="small">
          <el-option label="请选择字典生成" value="" />
        </el-select>
      </el-form-item>
      <el-form-item label="温度传感器" prop="temperatureSensor">
        <el-input
          v-model="queryParams.temperatureSensor"
          placeholder="请输入温度传感器"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="探头频率" prop="probeFrequency">
        <el-input
          v-model="queryParams.probeFrequency"
          placeholder="请输入探头频率"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="探头安装尺寸" prop="probeInstallationSize">
        <el-input
          v-model="queryParams.probeInstallationSize"
          placeholder="请输入探头安装尺寸"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="铭牌上的型号" prop="plateModel">
        <el-input
          v-model="queryParams.plateModel"
          placeholder="请输入铭牌上的型号"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="铭牌上的公司名称" prop="plateCompany">
        <el-input
          v-model="queryParams.plateCompany"
          placeholder="请输入铭牌上的公司名称"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="发货时间" prop="deliveryTime">
        <el-date-picker clearable size="small" style="width: 200px"
          v-model="queryParams.deliveryTime"
          type="date"
          value-format="yyyy-MM-dd"
          placeholder="选择发货时间">
        </el-date-picker>
      </el-form-item>
      <el-form-item label="快递类型" prop="expressType">
        <el-select v-model="queryParams.expressType" placeholder="请选择快递类型" clearable size="small">
          <el-option label="请选择字典生成" value="" />
        </el-select>
      </el-form-item>
      <el-form-item label="电缆线长" prop="probeCableLength">
        <el-input
          v-model="queryParams.probeCableLength"
          placeholder="请输入电缆线长"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="分体电缆线芯数" prop="probeSplitCableCoreNumber">
        <el-input
          v-model="queryParams.probeSplitCableCoreNumber"
          placeholder="请输入分体电缆线芯数"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="O型圈" prop="oRing">
        <el-input
          v-model="queryParams.oRing"
          placeholder="请输入O型圈"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="螺母" prop="nut">
        <el-input
          v-model="queryParams.nut"
          placeholder="请输入螺母"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="配套脉冲变压器类型" prop="matchingPulseTransformerType">
        <el-select v-model="queryParams.matchingPulseTransformerType" placeholder="请选择配套脉冲变压器类型" clearable size="small">
          <el-option label="请选择字典生成" value="" />
        </el-select>
      </el-form-item>
      <el-form-item label="脉冲变压器数量" prop="pulseTransformersNumber">
        <el-input
          v-model="queryParams.pulseTransformersNumber"
          placeholder="请输入脉冲变压器数量"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="合同上的技术指标image地址" prop="contractSpecificationsImageUrl">
        <el-input
          v-model="queryParams.contractSpecificationsImageUrl"
          placeholder="请输入合同上的技术指标image地址"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="合同上的技术指标描述" prop="contractSpecificationsDescribe">
        <el-input
          v-model="queryParams.contractSpecificationsDescribe"
          placeholder="请输入合同上的技术指标描述"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="特殊要求" prop="specialRequirements">
        <el-input
          v-model="queryParams.specialRequirements"
          placeholder="请输入特殊要求"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="其他" prop="productOther">
        <el-input
          v-model="queryParams.productOther"
          placeholder="请输入其他"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="外壳种类" prop="shellType">
        <el-select v-model="queryParams.shellType" placeholder="请选择外壳种类" clearable size="small">
          <el-option label="请选择字典生成" value="" />
        </el-select>
      </el-form-item>
      <el-form-item label="线制" prop="threadSystem">
        <el-input
          v-model="queryParams.threadSystem"
          placeholder="请输入线制"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="供电电源" prop="powerSupply">
        <el-input
          v-model="queryParams.powerSupply"
          placeholder="请输入供电电源"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="输出" prop="output">
        <el-input
          v-model="queryParams.output"
          placeholder="请输入输出"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="继电器" prop="relay">
        <el-input
          v-model="queryParams.relay"
          placeholder="请输入继电器"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="通讯协议" prop="communicationProtocol">
        <el-input
          v-model="queryParams.communicationProtocol"
          placeholder="请输入通讯协议"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="说明书类型" prop="descriptionType">
        <el-select v-model="queryParams.descriptionType" placeholder="请选择说明书类型" clearable size="small">
          <el-option label="请选择字典生成" value="" />
        </el-select>
      </el-form-item>
      <el-form-item label="螺纹尺寸" prop="threadSize">
        <el-input
          v-model="queryParams.threadSize"
          placeholder="请输入螺纹尺寸"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="法兰尺寸" prop="flangeSize">
        <el-input
          v-model="queryParams.flangeSize"
          placeholder="请输入法兰尺寸"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="被测介质" prop="measuredMedium">
        <el-input
          v-model="queryParams.measuredMedium"
          placeholder="请输入被测介质"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="法兰材质" prop="flangeMaterial">
        <el-input
          v-model="queryParams.flangeMaterial"
          placeholder="请输入法兰材质"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="是否允许接线" prop="isWiringAllowed">
        <el-input
          v-model="queryParams.isWiringAllowed"
          placeholder="请输入是否允许接线"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="备注" prop="remarks">
        <el-input
          v-model="queryParams.remarks"
          placeholder="请输入备注"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="型号" prop="productModel">
        <el-input
          v-model="queryParams.productModel"
          placeholder="请输入型号"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="产品名称" prop="mpProductName">
        <el-input
          v-model="queryParams.mpProductName"
          placeholder="请输入产品名称"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="产品型号" prop="mpProductModel">
        <el-input
          v-model="queryParams.mpProductModel"
          placeholder="请输入产品型号"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="量程" prop="mpTaskRange">
        <el-input
          v-model="queryParams.mpTaskRange"
          placeholder="请输入量程"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="线制" prop="mpThreadSysteml">
        <el-input
          v-model="queryParams.mpThreadSysteml"
          placeholder="请输入线制"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="电缆线长" prop="mpCableLength">
        <el-input
          v-model="queryParams.mpCableLength"
          placeholder="请输入电缆线长"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="工作温度" prop="mpWorkingTemperature">
        <el-input
          v-model="queryParams.mpWorkingTemperature"
          placeholder="请输入工作温度"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="供电" prop="mpPowerSupply">
        <el-input
          v-model="queryParams.mpPowerSupply"
          placeholder="请输入供电"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="输出" prop="mpOutput">
        <el-input
          v-model="queryParams.mpOutput"
          placeholder="请输入输出"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="公司名称" prop="mpCorporateName">
        <el-input
          v-model="queryParams.mpCorporateName"
          placeholder="请输入公司名称"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="产品位号" prop="mpProductItemNumber">
        <el-input
          v-model="queryParams.mpProductItemNumber"
          placeholder="请输入产品位号"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="防护等级" prop="mpProtectionLevel">
        <el-input
          v-model="queryParams.mpProtectionLevel"
          placeholder="请输入防护等级"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="产品编号" prop="mpProductNumber">
        <el-input
          v-model="queryParams.mpProductNumber"
          placeholder="请输入产品编号"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="服务电话" prop="mpProductTelephone">
        <el-input
          v-model="queryParams.mpProductTelephone"
          placeholder="请输入服务电话"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item>
        <el-button type="cyan" icon="el-icon-search" size="mini" @click="handleQuery">搜索</el-button>
        <el-button icon="el-icon-refresh" size="mini" @click="resetQuery">重置</el-button>
      </el-form-item>
    </el-form>

    <el-row :gutter="10" class="mb8">
      <el-col :span="1.5">
        <el-button
          type="primary"
          icon="el-icon-plus"
          size="mini"
          @click="handleAdd"
          v-hasPermi="['dayu:task_order:add']"
        >新增</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="success"
          icon="el-icon-edit"
          size="mini"
          :disabled="single"
          @click="handleUpdate"
          v-hasPermi="['dayu:task_order:edit']"
        >修改</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="danger"
          icon="el-icon-delete"
          size="mini"
          :disabled="multiple"
          @click="handleDelete"
          v-hasPermi="['dayu:task_order:remove']"
        >删除</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="warning"
          icon="el-icon-download"
          size="mini"
          @click="handleExport"
          v-hasPermi="['dayu:task_order:export']"
        >导出</el-button>
      </el-col>
	  <right-toolbar :showSearch.sync="showSearch" @queryTable="getList"></right-toolbar>
    </el-row>

    <el-table v-loading="loading" :data="task_orderList" @selection-change="handleSelectionChange">
      <el-table-column type="selection" width="55" align="center" />
      <el-table-column label="id" align="center" prop="id" />
      <el-table-column label="订单号" align="center" prop="orderNo" />
      <el-table-column label="任务表id" align="center" prop="taskId" />
      <el-table-column label="下单时间" align="center" prop="orderTime" width="180">
        <template slot-scope="scope">
          <span>{{ parseTime(scope.row.orderTime, '{y}-{m}-{d}') }}</span>
        </template>
      </el-table-column>
      <el-table-column label="应完工日期" align="center" prop="completionTime" width="180">
        <template slot-scope="scope">
          <span>{{ parseTime(scope.row.completionTime, '{y}-{m}-{d}') }}</span>
        </template>
      </el-table-column>
      <el-table-column label="产品名称" align="center" prop="productName" />
      <el-table-column label="产品名称数量" align="center" prop="productNo" />
      <el-table-column label="探头数量" align="center" prop="probesNumber" />
      <el-table-column label="探头外壳" align="center" prop="probesHouse" />
      <el-table-column label="购买公司" align="center" prop="buyingCompany" />
      <el-table-column label="开发板数量" align="center" prop="developmentBoardsNumber" />
      <el-table-column label="量程" align="center" prop="taskRange" />
      <el-table-column label="盲区" align="center" prop="blindArea" />
      <el-table-column label="探头类别" align="center" prop="probeType" />
      <el-table-column label="温度传感器" align="center" prop="temperatureSensor" />
      <el-table-column label="探头频率" align="center" prop="probeFrequency" />
      <el-table-column label="探头安装尺寸" align="center" prop="probeInstallationSize" />
      <el-table-column label="铭牌上的型号" align="center" prop="plateModel" />
      <el-table-column label="铭牌上的公司名称" align="center" prop="plateCompany" />
      <el-table-column label="发货时间" align="center" prop="deliveryTime" width="180">
        <template slot-scope="scope">
          <span>{{ parseTime(scope.row.deliveryTime, '{y}-{m}-{d}') }}</span>
        </template>
      </el-table-column>
      <el-table-column label="快递类型" align="center" prop="expressType" />
      <el-table-column label="电缆线长" align="center" prop="probeCableLength" />
      <el-table-column label="分体电缆线芯数" align="center" prop="probeSplitCableCoreNumber" />
      <el-table-column label="O型圈" align="center" prop="oRing" />
      <el-table-column label="螺母" align="center" prop="nut" />
      <el-table-column label="配套脉冲变压器类型" align="center" prop="matchingPulseTransformerType" />
      <el-table-column label="脉冲变压器数量" align="center" prop="pulseTransformersNumber" />
      <el-table-column label="合同上的技术指标image地址" align="center" prop="contractSpecificationsImageUrl" />
      <el-table-column label="合同上的技术指标描述" align="center" prop="contractSpecificationsDescribe" />
      <el-table-column label="特殊要求" align="center" prop="specialRequirements" />
      <el-table-column label="其他" align="center" prop="productOther" />
      <el-table-column label="外壳种类" align="center" prop="shellType" />
      <el-table-column label="线制" align="center" prop="threadSystem" />
      <el-table-column label="供电电源" align="center" prop="powerSupply" />
      <el-table-column label="输出" align="center" prop="output" />
      <el-table-column label="继电器" align="center" prop="relay" />
      <el-table-column label="通讯协议" align="center" prop="communicationProtocol" />
      <el-table-column label="说明书类型" align="center" prop="descriptionType" />
      <el-table-column label="螺纹尺寸" align="center" prop="threadSize" />
      <el-table-column label="法兰尺寸" align="center" prop="flangeSize" />
      <el-table-column label="被测介质" align="center" prop="measuredMedium" />
      <el-table-column label="法兰材质" align="center" prop="flangeMaterial" />
      <el-table-column label="是否允许接线" align="center" prop="isWiringAllowed" />
      <el-table-column label="备注" align="center" prop="remarks" />
      <el-table-column label="型号" align="center" prop="productModel" />
      <el-table-column label="产品名称" align="center" prop="mpProductName" />
      <el-table-column label="产品型号" align="center" prop="mpProductModel" />
      <el-table-column label="量程" align="center" prop="mpTaskRange" />
      <el-table-column label="线制" align="center" prop="mpThreadSysteml" />
      <el-table-column label="电缆线长" align="center" prop="mpCableLength" />
      <el-table-column label="工作温度" align="center" prop="mpWorkingTemperature" />
      <el-table-column label="供电" align="center" prop="mpPowerSupply" />
      <el-table-column label="输出" align="center" prop="mpOutput" />
      <el-table-column label="公司名称" align="center" prop="mpCorporateName" />
      <el-table-column label="产品位号" align="center" prop="mpProductItemNumber" />
      <el-table-column label="防护等级" align="center" prop="mpProtectionLevel" />
      <el-table-column label="产品编号" align="center" prop="mpProductNumber" />
      <el-table-column label="服务电话" align="center" prop="mpProductTelephone" />
      <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
        <template slot-scope="scope">
          <el-button
            size="mini"
            type="text"
            icon="el-icon-edit"
            @click="handleUpdate(scope.row)"
            v-hasPermi="['dayu:task_order:edit']"
          >修改</el-button>
          <el-button
            size="mini"
            type="text"
            icon="el-icon-delete"
            @click="handleDelete(scope.row)"
            v-hasPermi="['dayu:task_order:remove']"
          >删除</el-button>
        </template>
      </el-table-column>
    </el-table>
    
    <pagination
      v-show="total>0"
      :total="total"
      :page.sync="queryParams.pageNum"
      :limit.sync="queryParams.pageSize"
      @pagination="getList"
    />

    <!-- 添加或修改订单信息对话框 -->
    <el-dialog :title="title" :visible.sync="open" width="500px" append-to-body>
      <el-form ref="form" :model="form" :rules="rules" label-width="80px">
        <el-form-item label="订单号" prop="orderNo">
          <el-input v-model="form.orderNo" placeholder="请输入订单号" />
        </el-form-item>
        <el-form-item label="任务表id" prop="taskId">
          <el-input v-model="form.taskId" placeholder="请输入任务表id" />
        </el-form-item>
        <el-form-item label="下单时间" prop="orderTime">
          <el-date-picker clearable size="small" style="width: 200px"
            v-model="form.orderTime"
            type="date"
            value-format="yyyy-MM-dd"
            placeholder="选择下单时间">
          </el-date-picker>
        </el-form-item>
        <el-form-item label="应完工日期" prop="completionTime">
          <el-date-picker clearable size="small" style="width: 200px"
            v-model="form.completionTime"
            type="date"
            value-format="yyyy-MM-dd"
            placeholder="选择应完工日期">
          </el-date-picker>
        </el-form-item>
        <el-form-item label="产品名称" prop="productName">
          <el-input v-model="form.productName" placeholder="请输入产品名称" />
        </el-form-item>
        <el-form-item label="产品名称数量" prop="productNo">
          <el-input v-model="form.productNo" placeholder="请输入产品名称数量" />
        </el-form-item>
        <el-form-item label="探头数量" prop="probesNumber">
          <el-input v-model="form.probesNumber" placeholder="请输入探头数量" />
        </el-form-item>
        <el-form-item label="探头外壳" prop="probesHouse">
          <el-input v-model="form.probesHouse" placeholder="请输入探头外壳" />
        </el-form-item>
        <el-form-item label="购买公司" prop="buyingCompany">
          <el-input v-model="form.buyingCompany" placeholder="请输入购买公司" />
        </el-form-item>
        <el-form-item label="开发板数量" prop="developmentBoardsNumber">
          <el-input v-model="form.developmentBoardsNumber" placeholder="请输入开发板数量" />
        </el-form-item>
        <el-form-item label="量程" prop="taskRange">
          <el-input v-model="form.taskRange" placeholder="请输入量程" />
        </el-form-item>
        <el-form-item label="盲区" prop="blindArea">
          <el-input v-model="form.blindArea" placeholder="请输入盲区" />
        </el-form-item>
        <el-form-item label="探头类别" prop="probeType">
          <el-select v-model="form.probeType" placeholder="请选择探头类别">
            <el-option label="请选择字典生成" value="" />
          </el-select>
        </el-form-item>
        <el-form-item label="温度传感器" prop="temperatureSensor">
          <el-input v-model="form.temperatureSensor" placeholder="请输入温度传感器" />
        </el-form-item>
        <el-form-item label="探头频率" prop="probeFrequency">
          <el-input v-model="form.probeFrequency" placeholder="请输入探头频率" />
        </el-form-item>
        <el-form-item label="探头安装尺寸" prop="probeInstallationSize">
          <el-input v-model="form.probeInstallationSize" placeholder="请输入探头安装尺寸" />
        </el-form-item>
        <el-form-item label="铭牌上的型号" prop="plateModel">
          <el-input v-model="form.plateModel" placeholder="请输入铭牌上的型号" />
        </el-form-item>
        <el-form-item label="铭牌上的公司名称" prop="plateCompany">
          <el-input v-model="form.plateCompany" placeholder="请输入铭牌上的公司名称" />
        </el-form-item>
        <el-form-item label="发货时间" prop="deliveryTime">
          <el-date-picker clearable size="small" style="width: 200px"
            v-model="form.deliveryTime"
            type="date"
            value-format="yyyy-MM-dd"
            placeholder="选择发货时间">
          </el-date-picker>
        </el-form-item>
        <el-form-item label="快递类型" prop="expressType">
          <el-select v-model="form.expressType" placeholder="请选择快递类型">
            <el-option label="请选择字典生成" value="" />
          </el-select>
        </el-form-item>
        <el-form-item label="电缆线长" prop="probeCableLength">
          <el-input v-model="form.probeCableLength" placeholder="请输入电缆线长" />
        </el-form-item>
        <el-form-item label="分体电缆线芯数" prop="probeSplitCableCoreNumber">
          <el-input v-model="form.probeSplitCableCoreNumber" placeholder="请输入分体电缆线芯数" />
        </el-form-item>
        <el-form-item label="O型圈" prop="oRing">
          <el-input v-model="form.oRing" placeholder="请输入O型圈" />
        </el-form-item>
        <el-form-item label="螺母" prop="nut">
          <el-input v-model="form.nut" placeholder="请输入螺母" />
        </el-form-item>
        <el-form-item label="配套脉冲变压器类型" prop="matchingPulseTransformerType">
          <el-select v-model="form.matchingPulseTransformerType" placeholder="请选择配套脉冲变压器类型">
            <el-option label="请选择字典生成" value="" />
          </el-select>
        </el-form-item>
        <el-form-item label="脉冲变压器数量" prop="pulseTransformersNumber">
          <el-input v-model="form.pulseTransformersNumber" placeholder="请输入脉冲变压器数量" />
        </el-form-item>
        <el-form-item label="合同上的技术指标image地址" prop="contractSpecificationsImageUrl">
          <el-input v-model="form.contractSpecificationsImageUrl" placeholder="请输入合同上的技术指标image地址" />
        </el-form-item>
        <el-form-item label="合同上的技术指标描述" prop="contractSpecificationsDescribe">
          <el-input v-model="form.contractSpecificationsDescribe" placeholder="请输入合同上的技术指标描述" />
        </el-form-item>
        <el-form-item label="特殊要求" prop="specialRequirements">
          <el-input v-model="form.specialRequirements" placeholder="请输入特殊要求" />
        </el-form-item>
        <el-form-item label="其他" prop="productOther">
          <el-input v-model="form.productOther" placeholder="请输入其他" />
        </el-form-item>
        <el-form-item label="外壳种类" prop="shellType">
          <el-select v-model="form.shellType" placeholder="请选择外壳种类">
            <el-option label="请选择字典生成" value="" />
          </el-select>
        </el-form-item>
        <el-form-item label="线制" prop="threadSystem">
          <el-input v-model="form.threadSystem" placeholder="请输入线制" />
        </el-form-item>
        <el-form-item label="供电电源" prop="powerSupply">
          <el-input v-model="form.powerSupply" placeholder="请输入供电电源" />
        </el-form-item>
        <el-form-item label="输出" prop="output">
          <el-input v-model="form.output" placeholder="请输入输出" />
        </el-form-item>
        <el-form-item label="继电器" prop="relay">
          <el-input v-model="form.relay" placeholder="请输入继电器" />
        </el-form-item>
        <el-form-item label="通讯协议" prop="communicationProtocol">
          <el-input v-model="form.communicationProtocol" placeholder="请输入通讯协议" />
        </el-form-item>
        <el-form-item label="说明书类型" prop="descriptionType">
          <el-select v-model="form.descriptionType" placeholder="请选择说明书类型">
            <el-option label="请选择字典生成" value="" />
          </el-select>
        </el-form-item>
        <el-form-item label="螺纹尺寸" prop="threadSize">
          <el-input v-model="form.threadSize" placeholder="请输入螺纹尺寸" />
        </el-form-item>
        <el-form-item label="法兰尺寸" prop="flangeSize">
          <el-input v-model="form.flangeSize" placeholder="请输入法兰尺寸" />
        </el-form-item>
        <el-form-item label="被测介质" prop="measuredMedium">
          <el-input v-model="form.measuredMedium" placeholder="请输入被测介质" />
        </el-form-item>
        <el-form-item label="法兰材质" prop="flangeMaterial">
          <el-input v-model="form.flangeMaterial" placeholder="请输入法兰材质" />
        </el-form-item>
        <el-form-item label="是否允许接线" prop="isWiringAllowed">
          <el-input v-model="form.isWiringAllowed" placeholder="请输入是否允许接线" />
        </el-form-item>
        <el-form-item label="备注" prop="remarks">
          <el-input v-model="form.remarks" placeholder="请输入备注" />
        </el-form-item>
        <el-form-item label="型号" prop="productModel">
          <el-input v-model="form.productModel" placeholder="请输入型号" />
        </el-form-item>
        <el-form-item label="产品名称" prop="mpProductName">
          <el-input v-model="form.mpProductName" placeholder="请输入产品名称" />
        </el-form-item>
        <el-form-item label="产品型号" prop="mpProductModel">
          <el-input v-model="form.mpProductModel" placeholder="请输入产品型号" />
        </el-form-item>
        <el-form-item label="量程" prop="mpTaskRange">
          <el-input v-model="form.mpTaskRange" placeholder="请输入量程" />
        </el-form-item>
        <el-form-item label="线制" prop="mpThreadSysteml">
          <el-input v-model="form.mpThreadSysteml" placeholder="请输入线制" />
        </el-form-item>
        <el-form-item label="电缆线长" prop="mpCableLength">
          <el-input v-model="form.mpCableLength" placeholder="请输入电缆线长" />
        </el-form-item>
        <el-form-item label="工作温度" prop="mpWorkingTemperature">
          <el-input v-model="form.mpWorkingTemperature" placeholder="请输入工作温度" />
        </el-form-item>
        <el-form-item label="供电" prop="mpPowerSupply">
          <el-input v-model="form.mpPowerSupply" placeholder="请输入供电" />
        </el-form-item>
        <el-form-item label="输出" prop="mpOutput">
          <el-input v-model="form.mpOutput" placeholder="请输入输出" />
        </el-form-item>
        <el-form-item label="公司名称" prop="mpCorporateName">
          <el-input v-model="form.mpCorporateName" placeholder="请输入公司名称" />
        </el-form-item>
        <el-form-item label="产品位号" prop="mpProductItemNumber">
          <el-input v-model="form.mpProductItemNumber" placeholder="请输入产品位号" />
        </el-form-item>
        <el-form-item label="防护等级" prop="mpProtectionLevel">
          <el-input v-model="form.mpProtectionLevel" placeholder="请输入防护等级" />
        </el-form-item>
        <el-form-item label="产品编号" prop="mpProductNumber">
          <el-input v-model="form.mpProductNumber" placeholder="请输入产品编号" />
        </el-form-item>
        <el-form-item label="服务电话" prop="mpProductTelephone">
          <el-input v-model="form.mpProductTelephone" placeholder="请输入服务电话" />
        </el-form-item>
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button type="primary" @click="submitForm">确 定</el-button>
        <el-button @click="cancel">取 消</el-button>
      </div>
    </el-dialog>
  </div>
</template>

<script>
import { listTask_order, getTask_order, delTask_order, addTask_order, updateTask_order, exportTask_order } from "@/api/dayu/task_order";

export default {
  name: "Task_order",
  data() {
    return {
      // 遮罩层
      loading: true,
      // 选中数组
      ids: [],
      // 非单个禁用
      single: true,
      // 非多个禁用
      multiple: true,
      // 显示搜索条件
      showSearch: true,
      // 总条数
      total: 0,
      // 订单信息表格数据
      task_orderList: [],
      // 弹出层标题
      title: "",
      // 是否显示弹出层
      open: false,
      // 查询参数
      queryParams: {
        pageNum: 1,
        pageSize: 10,
        orderNo: null,
        taskId: null,
        orderTime: null,
        completionTime: null,
        productName: null,
        productNo: null,
        probesNumber: null,
        probesHouse: null,
        buyingCompany: null,
        developmentBoardsNumber: null,
        taskRange: null,
        blindArea: null,
        probeType: null,
        temperatureSensor: null,
        probeFrequency: null,
        probeInstallationSize: null,
        plateModel: null,
        plateCompany: null,
        deliveryTime: null,
        expressType: null,
        probeCableLength: null,
        probeSplitCableCoreNumber: null,
        oRing: null,
        nut: null,
        matchingPulseTransformerType: null,
        pulseTransformersNumber: null,
        contractSpecificationsImageUrl: null,
        contractSpecificationsDescribe: null,
        specialRequirements: null,
        productOther: null,
        shellType: null,
        threadSystem: null,
        powerSupply: null,
        output: null,
        relay: null,
        communicationProtocol: null,
        descriptionType: null,
        threadSize: null,
        flangeSize: null,
        measuredMedium: null,
        flangeMaterial: null,
        isWiringAllowed: null,
        remarks: null,
        productModel: null,
        mpProductName: null,
        mpProductModel: null,
        mpTaskRange: null,
        mpThreadSysteml: null,
        mpCableLength: null,
        mpWorkingTemperature: null,
        mpPowerSupply: null,
        mpOutput: null,
        mpCorporateName: null,
        mpProductItemNumber: null,
        mpProtectionLevel: null,
        mpProductNumber: null,
        mpProductTelephone: null,
      },
      // 表单参数
      form: {},
      // 表单校验
      rules: {
      }
    };
  },
  created() {
    this.getList();
  },
  methods: {
    /** 查询订单信息列表 */
    getList() {
      this.loading = true;
      listTask_order(this.queryParams).then(response => {
        this.task_orderList = response.rows;
        this.total = response.total;
        this.loading = false;
      });
    },
    // 取消按钮
    cancel() {
      this.open = false;
      this.reset();
    },
    // 表单重置
    reset() {
      this.form = {
        id: null,
        orderNo: null,
        taskId: null,
        orderTime: null,
        completionTime: null,
        productName: null,
        productNo: null,
        probesNumber: null,
        probesHouse: null,
        buyingCompany: null,
        developmentBoardsNumber: null,
        taskRange: null,
        blindArea: null,
        probeType: null,
        temperatureSensor: null,
        probeFrequency: null,
        probeInstallationSize: null,
        plateModel: null,
        plateCompany: null,
        deliveryTime: null,
        expressType: null,
        probeCableLength: null,
        probeSplitCableCoreNumber: null,
        oRing: null,
        nut: null,
        matchingPulseTransformerType: null,
        pulseTransformersNumber: null,
        contractSpecificationsImageUrl: null,
        contractSpecificationsDescribe: null,
        specialRequirements: null,
        productOther: null,
        shellType: null,
        threadSystem: null,
        powerSupply: null,
        output: null,
        relay: null,
        communicationProtocol: null,
        descriptionType: null,
        threadSize: null,
        flangeSize: null,
        measuredMedium: null,
        flangeMaterial: null,
        isWiringAllowed: null,
        remarks: null,
        productModel: null,
        mpProductName: null,
        mpProductModel: null,
        mpTaskRange: null,
        mpThreadSysteml: null,
        mpCableLength: null,
        mpWorkingTemperature: null,
        mpPowerSupply: null,
        mpOutput: null,
        mpCorporateName: null,
        mpProductItemNumber: null,
        mpProtectionLevel: null,
        mpProductNumber: null,
        mpProductTelephone: null,
        createTime: null,
        updateTime: null,
        createBy: null,
        updateBy: null
      };
      this.resetForm("form");
    },
    /** 搜索按钮操作 */
    handleQuery() {
      this.queryParams.pageNum = 1;
      this.getList();
    },
    /** 重置按钮操作 */
    resetQuery() {
      this.resetForm("queryForm");
      this.handleQuery();
    },
    // 多选框选中数据
    handleSelectionChange(selection) {
      this.ids = selection.map(item => item.id)
      this.single = selection.length!==1
      this.multiple = !selection.length
    },
    /** 新增按钮操作 */
    handleAdd() {
      this.reset();
      this.open = true;
      this.title = "添加订单信息";
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.reset();
      const id = row.id || this.ids
      getTask_order(id).then(response => {
        this.form = response.data;
        this.open = true;
        this.title = "修改订单信息";
      });
    },
    /** 提交按钮 */
    submitForm() {
      this.$refs["form"].validate(valid => {
        if (valid) {
          if (this.form.id != null) {
            updateTask_order(this.form).then(response => {
              if (response.code === 200) {
                this.msgSuccess("修改成功");
                this.open = false;
                this.getList();
              }
            });
          } else {
            addTask_order(this.form).then(response => {
              if (response.code === 200) {
                this.msgSuccess("新增成功");
                this.open = false;
                this.getList();
              }
            });
          }
        }
      });
    },
    /** 删除按钮操作 */
    handleDelete(row) {
      const ids = row.id || this.ids;
      this.$confirm('是否确认删除订单信息编号为"' + ids + '"的数据项?', "警告", {
          confirmButtonText: "确定",
          cancelButtonText: "取消",
          type: "warning"
        }).then(function() {
          return delTask_order(ids);
        }).then(() => {
          this.getList();
          this.msgSuccess("删除成功");
        }).catch(function() {});
    },
    /** 导出按钮操作 */
    handleExport() {
      const queryParams = this.queryParams;
      this.$confirm('是否确认导出所有订单信息数据项?', "警告", {
          confirmButtonText: "确定",
          cancelButtonText: "取消",
          type: "warning"
        }).then(function() {
          return exportTask_order(queryParams);
        }).then(response => {
          this.download(response.msg);
        }).catch(function() {});
    }
  }
};
</script>