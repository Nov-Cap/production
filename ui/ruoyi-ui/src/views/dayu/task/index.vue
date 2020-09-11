<template>
  <div class="app-container">
    <el-form :model="queryParams" ref="queryForm" :inline="true" v-show="showSearch" label-width="68px">
      <el-form-item label="任务号" prop="taskNo">
        <el-input v-model="queryParams.taskNo" placeholder="请输入任务号" clearable size="small" @keyup.enter.native="handleQuery" />
      </el-form-item>
      <el-form-item>
        <el-upload class="avatar-uploader" action="" ref="uploadAvatar" :show-file-list="false" :auto-upload="false"
          :on-change="changeFile">
          <img v-if="imageUrl" :src="imageUrl" class="uploadAvatar">
          <i v-else class="el-icon-plus avatar-uploader-icon"></i>
        </el-upload>
      </el-form-item>
      <el-form-item>
        <el-button type="cyan" icon="el-icon-search" size="mini" @click="handleQuery">搜索</el-button>
        <el-button icon="el-icon-refresh" size="mini" @click="resetQuery">重置</el-button>
      </el-form-item>
    </el-form>

    <el-row :gutter="10" class="mb8">
      <el-col :span="1.5">
        <el-button type="primary" icon="el-icon-plus" size="mini" @click="handleAdd" v-hasPermi="['dayu:task:add']">新增</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button type="success" icon="el-icon-edit" size="mini" :disabled="single" @click="handleUpdate" v-hasPermi="['dayu:task:edit']">修改</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button type="danger" icon="el-icon-delete" size="mini" :disabled="multiple" @click="handleDelete"
          v-hasPermi="['dayu:task:remove']">删除</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button type="warning" icon="el-icon-download" size="mini" @click="handleExport" v-hasPermi="['dayu:task:export']">导出</el-button>
      </el-col>
      <right-toolbar :showSearch.sync="showSearch" @queryTable="getList"></right-toolbar>
    </el-row>

    <el-table v-loading="loading" :data="taskList" @selection-change="handleSelectionChange">
      <el-table-column type="selection" width="55" align="center" />
      <el-table-column label="id" align="center" prop="id" />
      <el-table-column label="任务号" align="center" prop="taskNo" />
      <el-table-column label="任务类型" align="center" prop="taskType" :formatter="taskTypeFormat" />
      <el-table-column label="下单人员" align="center" prop="orderPerson" />
      <el-table-column label="生产主管" align="center" prop="productionCharge" />
      <el-table-column label="生产人员" align="center" prop="productionPersonnel" />
      <el-table-column label="状态" align="center" prop="state" :formatter="stateFormat" />
      <!--      <el-table-column label="发件人发货地址" align="center" prop="senderShippingAddress" />
      <el-table-column label="发件人发货公司" align="center" prop="senderShippingCompany" />
      <el-table-column label="发件人" align="center" prop="senderUserid" />
      <el-table-column label="收件人信息收货地址" align="center" prop="recipientShippingAddress" />
      <el-table-column label="收件人信息收货公司" align="center" prop="recipientShippingCompany" />
      <el-table-column label="收件人信息收货人" align="center" prop="recipientUserid" /> -->
      <el-table-column label="备注" align="center" prop="remark" />
      <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
        <template slot-scope="scope">
          <el-button size="mini" type="text" icon="el-icon-edit" @click="handleUpdate(scope.row)" v-hasPermi="['dayu:task:edit']">修改</el-button>
          <el-button size="mini" type="text" icon="el-icon-delete" @click="handleDelete(scope.row)" v-hasPermi="['dayu:task:remove']">删除</el-button>
        </template>
      </el-table-column>
    </el-table>

    <pagination v-show="total>0" :total="total" :page.sync="queryParams.pageNum" :limit.sync="queryParams.pageSize"
      @pagination="getList" />

    <!-- 添加或修改任务表对话框 -->
    <el-dialog :title="title" :visible.sync="open" width="1000px" append-to-body>
      <el-form ref="form" :model="form" :rules="rules" label-width="100px">
        <el-form-item label="任务类型">
          <el-radio-group v-model="form.taskType">
            <el-radio v-for="dict in taskTypeOptions" :key="dict.dictValue" :label="parseInt(dict.dictValue)">{{dict.dictLabel}}</el-radio>
          </el-radio-group>
        </el-form-item>

        <!-- 遍历订单号 -->
        <div v-for="(item,index) in taskOrderList">
          <hr />
          <el-row :gutter="20" style="margin-top: 30px;">
            <el-col :span="8">
              <el-form-item :label="'订单号'+ (index+1)" prop="productionPersonnel">
                <el-input v-model="item.orderNo" placeholder="订单号" />
              </el-form-item>
            </el-col>
            <el-col :span="8">
              <el-form-item label="下单时间" prop="orderTime">
                <el-date-picker clearable size="small" style="width: 200px" v-model="item.orderTime" type="date"
                  value-format="yyyy-MM-dd" placeholder="选择下单时间">
                </el-date-picker>
              </el-form-item>
            </el-col>
            <el-col :span="8">
              <el-form-item label="应完工日期" prop="completionTime">
                <el-date-picker clearable size="small" style="width: 200px" v-model="item.completionTime" type="date"
                  value-format="yyyy-MM-dd" placeholder="选择应完工日期">
                </el-date-picker>
              </el-form-item>
            </el-col>
          </el-row>

          <!-- 大禹生产 -->
          <span v-if="form.taskType == 0">
            <el-row :gutter="20">
              <el-col :span="8">
                <el-form-item label="购买公司" prop="buyingCompany">
                  <el-input v-model="item.buyingCompany" placeholder="请输入购买公司" />
                </el-form-item>
              </el-col>
              <el-col :span="16">
                <el-form-item label="其他" prop="productOther">
                  <el-input v-model="item.productOther" placeholder="请输入其他" />
                </el-form-item>
              </el-col>
            </el-row>
            <el-row :gutter="20">
              <el-col :span="8">
                <el-form-item label="产品名称" prop="productName">
                  <el-input v-model="item.productName" placeholder="请输入名称" />
                </el-form-item>
              </el-col>
              <el-col :span="8">
                <el-form-item label="产品名称数量" prop="productNo">
                  <el-input v-model="item.productNo" placeholder="请输入产品名称数量" />
                </el-form-item>
              </el-col>
             <el-col :span="8">
              <el-form-item label="外壳种类" prop="shellType">
                <el-select v-model="item.shellType" placeholder="请选择外壳种类" clearable size="small">
                  <el-option v-for="dict in shellTypeOptions" :key="dict.dictValue" :label="dict.dictLabel" :value="dict.dictValue" />
                </el-select>
              </el-form-item>
              </el-col>
            </el-row>

            <el-row :gutter="20">
              <el-col :span="8">
               <el-form-item label="量程" prop="taskRange">
                 <el-input v-model="item.taskRange" placeholder="请输入量程" />
               </el-form-item>
              </el-col>
              <el-col :span="16">
                <el-form-item label="线制" prop="threadSystem">
                 <el-select v-model="item.threadSystem" placeholder="请选择外壳种类" clearable size="small">
                   <el-option v-for="dict in threadSystemOptions" :key="dict.dictValue" :label="dict.dictLabel" :value="dict.dictValue" />
                 </el-select>
                </el-form-item>
              </el-col>
            </el-row>

            <el-row :gutter="20">
              <el-col :span="8">
                <el-form-item label="供电电源" prop="powerSupply">
                  <el-select v-model="item.powerSupply" placeholder="请选择外壳种类" clearable size="small">
                    <el-option v-for="dict in powerSupplyOptions" :key="dict.dictValue" :label="dict.dictLabel" :value="dict.dictValue" />
                  </el-select>
                </el-form-item>
              </el-col>
              <el-col :span="16">
                <el-form-item label="输出" prop="productNo">
                 <el-select v-model="item.output" placeholder="请选择外壳种类" clearable size="small">
                   <el-option v-for="dict in outputOptions" :key="dict.dictValue" :label="dict.dictLabel" :value="dict.dictValue" />
                 </el-select>
                </el-form-item>
              </el-col>
            </el-row>

            <el-row :gutter="20">
              <el-col :span="8">
                <el-form-item label="继电器" prop="relay">
                  <el-select v-model="item.relay" placeholder="请选择继电器" clearable size="small">
                    <el-option v-for="dict in relayOptions" :key="dict.dictValue" :label="dict.dictLabel" :value="dict.dictValue" />
                  </el-select>
                </el-form-item>
              </el-col>
              <el-col :span="16">
                <el-form-item label="通讯协议" prop="communicationProtocol">
                 <el-select v-model="item.communicationProtocol" placeholder="请选择通讯协议" clearable size="small">
                   <el-option v-for="dict in communicationProtocolOptions" :key="dict.dictValue" :label="dict.dictLabel" :value="dict.dictValue" />
                 </el-select>
                </el-form-item>
              </el-col>
            </el-row>

            <el-row :gutter="20">
              <el-col :span="8">
                <el-form-item label="说明书类型" prop="descriptionType">
                  <el-select v-model="item.descriptionType" placeholder="请选择说明书类型" clearable size="small">
                    <el-option v-for="dict in descriptionTypeOptions" :key="dict.dictValue" :label="dict.dictLabel" :value="dict.dictValue" />
                  </el-select>
                </el-form-item>
              </el-col>
              <el-col :span="8">
                <el-form-item label="螺纹尺寸" prop="threadSize">
                 <el-select v-model="item.threadSize" placeholder="请选择螺纹尺寸" clearable size="small">
                   <el-option v-for="dict in threadSizeOptions" :key="dict.dictValue" :label="dict.dictLabel" :value="dict.dictValue" />
                 </el-select>
                </el-form-item>
              </el-col>
              <el-col :span="8">
                <el-form-item label="法兰尺寸" prop="flangeSize">
                 <el-select v-model="item.flangeSize" placeholder="请选择法兰尺寸" clearable size="small">
                   <el-option v-for="dict in flangeSizeOptions" :key="dict.dictValue" :label="dict.dictLabel" :value="dict.dictValue" />
                 </el-select>
                </el-form-item>
              </el-col>
            </el-row>

            <el-row :gutter="20">
              <el-col :span="8">
                <el-form-item label="被测介质" prop="measuredMedium">
                 <el-input v-model="item.measuredMedium" placeholder="请输入被测介质" />
                </el-form-item>
              </el-col>
              <el-col :span="8">
                <el-form-item label="法兰材质" prop="flangeMaterial">
                 <el-select v-model="item.flangeMaterial" placeholder="请选择法兰材质" clearable size="small">
                   <el-option v-for="dict in flangeMaterialOptions" :key="dict.dictValue" :label="dict.dictLabel" :value="dict.dictValue" />
                 </el-select>
                </el-form-item>
              </el-col>
              <el-col :span="8">
              </el-col>
            </el-row>

            <el-row :gutter="20">
              <el-col :span="8">
                <el-form-item label="发货时间" prop="deliveryTime">
                 <el-select v-model="item.deliveryTime" placeholder="请选择发货时间" clearable size="small">
                   <el-option v-for="dict in deliveryTimeOptions" :key="dict.dictValue" :label="dict.dictLabel" :value="dict.dictValue" />
                 </el-select>
                </el-form-item>
              </el-col>
              <el-col :span="8">
                <el-form-item label="快递类型" prop="expressType">
                 <el-select v-model="item.expressType" placeholder="请选择快递类型" clearable size="small">
                   <el-option v-for="dict in expressTypeOptions" :key="dict.dictValue" :label="dict.dictLabel" :value="dict.dictValue" />
                 </el-select>
                </el-form-item>
              </el-col>
              <el-col :span="8">
                <el-form-item label="备注" prop="remarks">
                 <el-input v-model="item.remarks" placeholder="请输入备注" />
                </el-form-item>
              </el-col>
            </el-row>

            <el-row :gutter="20">
              <el-col :span="8">
                <el-form-item label="电缆线长" prop="probeCableLength">
                 <el-select v-model="item.probeCableLength" placeholder="请选择电缆线长" clearable size="small">
                   <el-option v-for="dict in probeCableLengthOptions" :key="dict.dictValue" :label="dict.dictLabel" :value="dict.dictValue" />
                 </el-select>
                </el-form-item>
              </el-col>
              <el-col :span="8">
                <el-form-item label="是否允许接线" prop="isWiringAllowed">
                 <el-select v-model="item.isWiringAllowed" placeholder="是否允许接线" clearable size="small">
                   <el-option v-for="dict in isWiringAllowedOptions" :key="dict.dictValue" :label="dict.dictLabel" :value="dict.dictValue" />
                 </el-select>
                </el-form-item>
              </el-col>
              <el-col :span="8">

              </el-col>
            </el-row>

             <el-row :gutter="20">
               <el-col :span="24">
                 <div style="text-align: center;margin: 1.25rem;margin-top: 0px;">以下铭牌信息要是空白，代表不需要打印</div>
               </el-col>
             </el-row>
            <!-- 以下铭牌信息要是空白，代表不需要打印 -->
            <el-row :gutter="20">
              <el-col :span="8">
               <el-form-item label="产品名称" prop="mp_product_name">
                <el-input v-model="item.mp_product_name" placeholder="请输入产品名称" />
               </el-form-item>
              </el-col>
              <el-col :span="8">
                <el-form-item label="产品型号" prop="mp_product_model">
                 <el-input v-model="item.mp_product_model" placeholder="请输入产品型号" />
                </el-form-item>
              </el-col>
              <el-col :span="8">
              </el-col>
            </el-row>

            <el-row :gutter="20">
              <el-col :span="8">
               <el-form-item label="量程" prop="mp_task_range">
                <el-input v-model="item.mp_task_range" placeholder="请输入量程" />
               </el-form-item>
              </el-col>
              <el-col :span="8">
                <el-form-item label="线制" prop="mp_thread_systeml">
                 <el-input v-model="item.mp_thread_systeml" placeholder="请输入线制" />
                </el-form-item>
              </el-col>
              <el-col :span="8">
                <el-form-item label="电缆线长" prop="mp_cable_length">
                 <el-input v-model="item.mp_cable_length" placeholder="请输入电缆线长" />
                </el-form-item>
              </el-col>
            </el-row>

            <el-row :gutter="20">
              <el-col :span="8">
               <el-form-item label="工作温度" prop="mp_working_temperature">
                <el-input v-model="item.mp_working_temperature" placeholder="请输入工作温度" />
               </el-form-item>
              </el-col>
              <el-col :span="8">
                <el-form-item label="供电" prop="mp_power_supply">
                 <el-input v-model="item.mp_power_supply" placeholder="请输入供电" />
                </el-form-item>
              </el-col>
              <el-col :span="8">
                <el-form-item label="输出" prop="mp_output">
                 <el-input v-model="item.mp_output" placeholder="请输入输出" />
                </el-form-item>
              </el-col>
            </el-row>

            <el-row :gutter="20">
              <el-col :span="8">
               <el-form-item label="公司名称" prop="mp_corporate_name">
                <el-input v-model="item.mp_corporate_name" placeholder="请输入公司名称" />
               </el-form-item>
              </el-col>
              <el-col :span="8">
                <el-form-item label="产品位号" prop="mp_product_item_number">
                 <el-input v-model="item.mp_product_item_number" placeholder="请输入产品位号" />
                </el-form-item>
              </el-col>
              <el-col :span="8">
                <el-form-item label="防护等级" prop="mp_protection_level">
                 <el-input v-model="item.mp_protection_level" placeholder="请输入防护等级" />
                </el-form-item>
              </el-col>
            </el-row>

            <el-row :gutter="20">
              <el-col :span="8">
               <el-form-item label="产品编号" prop="mp_product_number">
                <el-input v-model="item.mp_product_number" placeholder="请输入产品编号" />
               </el-form-item>
              </el-col>
              <el-col :span="8">
                <el-form-item label="服务电话" prop="mp_product_telephone">
                 <el-input v-model="item.mp_product_telephone" placeholder="请输入服务电话" />
                </el-form-item>
              </el-col>
              <el-col :span="8">
              </el-col>
            </el-row>

            <el-row :gutter="20">
              <el-col :span="24">
               <el-form-item label="特殊要求" prop="special_requirements">
                <el-input type="textarea" v-model="item.special_requirements" placeholder="请输入特殊要求" />
               </el-form-item>
              </el-col>

            </el-row>
          </span>

          <!-- 能换器生产 -->
          <span v-if="form.taskType == 1">


          </span>
        </div>
          <hr />
        <!--        <el-form-item label="任务号" prop="taskNo">
                <el-input v-model="form.taskNo" placeholder="自动生成任务号" readonly/>
              </el-form-item> -->
        <el-form-item label="备注" prop="remark">
          <el-input v-model="form.remark" placeholder="请输入备注" />
        </el-form-item>
        <!-- 下单人员 -->
        <el-row :gutter="20">
          <el-col :span="8">
            <el-form-item label="下单人员" prop="orderPerson">
              <el-input v-model="form.orderPerson" placeholder="请输入下单人员" />
            </el-form-item>
          </el-col>
          <el-col :span="8">
            <el-form-item label="生产主管" prop="productionCharge">
              <el-input v-model="form.productionCharge" placeholder="请输入生产主管" />
            </el-form-item>
          </el-col>
          <el-col :span="8">
            <el-form-item label="生产人员" prop="productionPersonnel">
              <el-input v-model="form.productionPersonnel" placeholder="请输入生产人员" />
            </el-form-item>
          </el-col>
        </el-row>

        <!-- <el-form-item label="状态" prop="state">
          <el-input v-model="form.state" placeholder="请输入状态" />
        </el-form-item> -->
        <!-- <el-form-item label="发件人发货地址" prop="senderShippingAddress">
          <el-input v-model="form.senderShippingAddress" placeholder="请输入发件人发货地址" />
        </el-form-item>
        <el-form-item label="发件人发货公司" prop="senderShippingCompany">
          <el-input v-model="form.senderShippingCompany" placeholder="请输入发件人发货公司" />
        </el-form-item>
        <el-form-item label="发件人" prop="senderUserid">
          <el-input v-model="form.senderUserid" placeholder="请输入发件人" />
        </el-form-item>
        <el-form-item label="收件人信息收货地址" prop="recipientShippingAddress">
          <el-input v-model="form.recipientShippingAddress" placeholder="请输入收件人信息收货地址" />
        </el-form-item>
        <el-form-item label="收件人信息收货公司" prop="recipientShippingCompany">
          <el-input v-model="form.recipientShippingCompany" placeholder="请输入收件人信息收货公司" />
        </el-form-item>
        <el-form-item label="收件人信息收货人" prop="recipientUserid">
          <el-input v-model="form.recipientUserid" placeholder="请输入收件人信息收货人" />
        </el-form-item> -->

      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button type="primary" @click="submitForm">确 定</el-button>
        <el-button @click="cancel">取 消</el-button>
      </div>
    </el-dialog>
  </div>
</template>

<script>
  import {
    listTask,
    getTask,
    delTask,
    addTask,
    updateTask,
    exportTask
  } from "@/api/dayu/task";
  import {
    listTask_order,
    getTask_order,
    delTask_order,
    addTask_order,
    updateTask_order,
    exportTask_order
  } from "@/api/dayu/task_order";
  import {
    getToken
  } from "@/utils/auth";
  export default {
    name: "Task",
    data() {
      return {
        imageUrl: '',
        imageBaseUrl: '',
        upload: {
          // 是否禁用上传
          isUploading: false,
          // 设置上传的请求头部
          headers: {
            Authorization: "Bearer " + getToken()
          },
          // 上传的地址
          url: process.env.VUE_APP_BASE_API + "/common/upload",
          // 上传的文件列表
          fileList: []
        },
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
        // 任务表表格数据
        taskList: [],
        // 弹出层标题
        title: "",
        // 是否显示弹出层
        open: false,
        // 状态字典
        stateOptions: [],
        // 任务类型字典
        taskTypeOptions: [],
        // 探头外壳字典
        probesHouseOptions: [],
        // 探头类别字典
        probeTypeOptions: [],
        // 温度传感器字典
        temperatureSensorOptions: [],
        // 探头安装尺寸字典
        probeInstallationSizeOptions: [],
        // 快递类型字典
        expressTypeOptions: [],
        // 电缆线长字典
        probeCableLengthOptions: [],
        // O型圈字典
        oRingOptions: [],
        // 螺母字典
        nutOptions: [],
        // 配套脉冲变压器类型字典
        matchingPulseTransformerTypeOptions: [],
        // 外壳种类字典
        shellTypeOptions: [],
        // 线制字典
        threadSystemOptions: [],
        // 供电电源字典
        powerSupplyOptions: [],
        // 输出字典
        outputOptions: [],
        // 继电器字典
        relayOptions: [],
        // 通讯协议字典
        communicationProtocolOptions: [],
        // 说明书类型字典
        descriptionTypeOptions: [],
        // 螺纹尺寸字典
        threadSizeOptions: [],
        // 法兰尺寸字典
        flangeSizeOptions: [],
        // 法兰材质字典
        flangeMaterialOptions: [],
        // 是否允许接线字典
        isWiringAllowedOptions: [],
        //发货类型
        deliveryTimeOptions:[],
        // 查询参数
        queryParams: {
          pageNum: 1,
          pageSize: 10,
          taskNo: null,
          orderPerson: null,
          productionCharge: null,
          productionPersonnel: null,
          state: null,
          taskType: null,
          senderShippingAddress: null,
          senderShippingCompany: null,
          senderUserid: null,
          recipientShippingAddress: null,
          recipientShippingCompany: null,
          recipientUserid: null,
        },
        // 表单参数
        form: {},
        //订单集合
        taskOrderList: [{}],
        // 表单校验
        rules: {
          state: [{
            required: true,
            message: "状态不能为空",
            trigger: "blur"
          }],
          taskType: [{
            required: true,
            message: "任务类型不能为空",
            trigger: "blur"
          }],
        }
      };
    },
    created() {
      this.getList();
      this.getDicts("tab_task_state").then(response => {
        this.stateOptions = response.data;
      });
      this.getDicts("tab_task_type").then(response => {
        this.taskTypeOptions = response.data;
      });
      this.getDicts("tab_task_ probeHousing").then(response => {
        this.probesHouseOptions = response.data;
      });
      this.getDicts("tab_task_probeCategory").then(response => {
        this.probeTypeOptions = response.data;
      });
      this.getDicts("tab_task_temperatureSensor").then(response => {
        this.temperatureSensorOptions = response.data;
      });
      this.getDicts("tab_task_probeInstallationSize").then(response => {
        this.probeInstallationSizeOptions = response.data;
      });
      this.getDicts("tab_task_ExpressType").then(response => {
        this.expressTypeOptions = response.data;
      });
      this.getDicts("tab_task_probe_cable_length").then(response => {
        this.probeCableLengthOptions = response.data;
      });
      this.getDicts("tab_isNull").then(response => {
        this.oRingOptions = response.data;
      });
      this.getDicts("tab_isNull").then(response => {
        this.nutOptions = response.data;
      });
      this.getDicts("tab_task_matching_pulse_transformer_type").then(response => {
        this.matchingPulseTransformerTypeOptions = response.data;
      });
      this.getDicts("tab_task_shell_type").then(response => {
        this.shellTypeOptions = response.data;
      });
      this.getDicts("tab_task_thread_system").then(response => {
        this.threadSystemOptions = response.data;
      });
      this.getDicts("tab_task_power_supply").then(response => {
        this.powerSupplyOptions = response.data;
      });
      this.getDicts("tab_task_output").then(response => {
        this.outputOptions = response.data;
      });
      this.getDicts("tab_task_relay").then(response => {
        this.relayOptions = response.data;
      });
      this.getDicts("tab_task_communication_protocol").then(response => {
        this.communicationProtocolOptions = response.data;
      });
      this.getDicts("tab_task_description_type").then(response => {
        this.descriptionTypeOptions = response.data;
      });
      this.getDicts("tab_task_thread_size").then(response => {
        this.threadSizeOptions = response.data;
      });
      this.getDicts("tab_task_flange_size").then(response => {
        this.flangeSizeOptions = response.data;
      });
      this.getDicts("tab_task_flange_material").then(response => {
        this.flangeMaterialOptions = response.data;
      });
      this.getDicts("tab_trueFalse").then(response => {
        this.isWiringAllowedOptions = response.data;
      });
      this.getDicts("tab_task_shipmentType").then(response => {
        this.deliveryTimeOptions = response.data;
      });
    },
    methods: {
      /**
       * 文件框改变事件
       * @param file
       * @param fileList
       */
      changeFile(file, fileList) {
        const isJPGORPNG = (file.raw.type === 'image/jpeg' || file.raw.type === 'image/png');
        const isLt1M = file.size / 1024 / 1024 < 1;

        if (!isJPGORPNG) {
          this.$message.info('上传头像图片只能是 JPG 或 PNG 格式!');
          return;
        }
        if (!isLt1M) {
          this.$message.info('上传头像图片大小不能超过 1MB!');
          return;
        }

        var This = this;
        var reader = new FileReader();
        reader.readAsDataURL(file.raw);
        reader.onload = function(e) {
          this.result; //base64编码
          This.imageBaseUrl = this.result;
          This.imageUrl = this.result;
          console.log(This.imageUrl)
        }
      },
      handleUpdate(row) {
        this.upload.fileList = [{
          name: this.form.fileName,
          url: this.form.filePath
        }];
      },
      /** 查询任务表列表 */
      getList() {
        this.loading = true;
        listTask(this.queryParams).then(response => {
          this.taskList = response.rows;
          this.total = response.total;
          this.loading = false;
        });
      },
      // 状态字典翻译
      stateFormat(row, column) {
        return this.selectDictLabel(this.stateOptions, row.state);
      },
      // 任务类型字典翻译
      taskTypeFormat(row, column) {
        return this.selectDictLabel(this.taskTypeOptions, row.taskType);
      },
      // 探头外壳字典翻译
      probesHouseFormat(row, column) {
        return this.selectDictLabel(this.probesHouseOptions, row.probesHouse);
      },
      // 探头类别字典翻译
      probeTypeFormat(row, column) {
        return this.selectDictLabel(this.probeTypeOptions, row.probeType);
      },
      // 温度传感器字典翻译
      temperatureSensorFormat(row, column) {
        return this.selectDictLabel(this.temperatureSensorOptions, row.temperatureSensor);
      },
      // 探头安装尺寸字典翻译
      probeInstallationSizeFormat(row, column) {
        return this.selectDictLabel(this.probeInstallationSizeOptions, row.probeInstallationSize);
      },
      // 快递类型字典翻译
      expressTypeFormat(row, column) {
        return this.selectDictLabel(this.expressTypeOptions, row.expressType);
      },
      // 电缆线长字典翻译
      probeCableLengthFormat(row, column) {
        return this.selectDictLabel(this.probeCableLengthOptions, row.probeCableLength);
      },
      // O型圈字典翻译
      oRingFormat(row, column) {
        return this.selectDictLabel(this.oRingOptions, row.oRing);
      },
      // 螺母字典翻译
      nutFormat(row, column) {
        return this.selectDictLabel(this.nutOptions, row.nut);
      },
      // 配套脉冲变压器类型字典翻译
      matchingPulseTransformerTypeFormat(row, column) {
        return this.selectDictLabel(this.matchingPulseTransformerTypeOptions, row.matchingPulseTransformerType);
      },
      // 外壳种类字典翻译
      shellTypeFormat(row, column) {
        return this.selectDictLabel(this.shellTypeOptions, row.shellType);
      },
      // 线制字典翻译
      threadSystemFormat(row, column) {
        return this.selectDictLabel(this.threadSystemOptions, row.threadSystem);
      },
      // 供电电源字典翻译
      powerSupplyFormat(row, column) {
        return this.selectDictLabel(this.powerSupplyOptions, row.powerSupply);
      },
      // 输出字典翻译
      outputFormat(row, column) {
        return this.selectDictLabel(this.outputOptions, row.output);
      },
      // 继电器字典翻译
      relayFormat(row, column) {
        return this.selectDictLabel(this.relayOptions, row.relay);
      },
      // 通讯协议字典翻译
      communicationProtocolFormat(row, column) {
        return this.selectDictLabel(this.communicationProtocolOptions, row.communicationProtocol);
      },
      // 说明书类型字典翻译
      descriptionTypeFormat(row, column) {
        return this.selectDictLabel(this.descriptionTypeOptions, row.descriptionType);
      },
      // 螺纹尺寸字典翻译
      threadSizeFormat(row, column) {
        return this.selectDictLabel(this.threadSizeOptions, row.threadSize);
      },
      // 法兰尺寸字典翻译
      flangeSizeFormat(row, column) {
        return this.selectDictLabel(this.flangeSizeOptions, row.flangeSize);
      },
      // 法兰材质字典翻译
      flangeMaterialFormat(row, column) {
        return this.selectDictLabel(this.flangeMaterialOptions, row.flangeMaterial);
      },
      // 是否允许接线字典翻译
      isWiringAllowedFormat(row, column) {
        return this.selectDictLabel(this.isWiringAllowedOptions, row.isWiringAllowed);
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
          taskNo: null,
          orderPerson: null,
          productionCharge: null,
          productionPersonnel: null,
          state: null,
          taskType: 0,
          senderShippingAddress: null,
          senderShippingCompany: null,
          senderUserid: null,
          recipientShippingAddress: null,
          recipientShippingCompany: null,
          recipientUserid: null,
          remark: null,
          updateTime: null,
          createTime: null,
          updateby: null,
          createby: null
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
        this.single = selection.length !== 1
        this.multiple = !selection.length
      },
      /** 新增按钮操作 */
      handleAdd() {
        this.reset();
        this.open = true;
        this.title = "添加任务表";
      },
      /** 修改按钮操作 */
      handleUpdate(row) {
        this.reset();
        const id = row.id || this.ids
        getTask(id).then(response => {
          this.form = response.data;
          this.open = true;
          this.title = "修改任务表";
        });
      },
      /** 提交按钮 */
      submitForm() {
        console.log(this.taskOrderList)
        this.$refs["form"].validate(valid => {
          if (valid) {
            if (this.form.id != null) {
              updateTask(this.form).then(response => {
                if (response.code === 200) {
                  this.msgSuccess("修改成功");
                  this.open = false;
                  this.getList();
                }
              });
            } else {
              addTask(this.form).then(response => {
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
        this.$confirm('是否确认删除任务表编号为"' + ids + '"的数据项?', "警告", {
          confirmButtonText: "确定",
          cancelButtonText: "取消",
          type: "warning"
        }).then(function() {
          return delTask(ids);
        }).then(() => {
          this.getList();
          this.msgSuccess("删除成功");
        }).catch(function() {});
      },
      /** 导出按钮操作 */
      handleExport() {
        const queryParams = this.queryParams;
        this.$confirm('是否确认导出所有任务表数据项?', "警告", {
          confirmButtonText: "确定",
          cancelButtonText: "取消",
          type: "warning"
        }).then(function() {
          return exportTask(queryParams);
        }).then(response => {
          this.download(response.msg);
        }).catch(function() {});
      }
    }
  };
</script>
