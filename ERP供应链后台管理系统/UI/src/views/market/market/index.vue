<template>
  <div class="app-container">
    <el-form :model="queryParams" ref="queryForm" size="small" :inline="true" v-show="showSearch" label-width="68px">
      <el-form-item label="销售名称" prop="marketName">
        <el-input
          v-model="queryParams.marketName"
          placeholder="请输入销售名称"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>

      <el-form-item label="销售数量" prop="marketNum">
        <el-input
          v-model="queryParams.marketNum"
          placeholder="请输入销售数量"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="销售价格" prop="marketPrice">
        <el-input
          v-model="queryParams.marketPrice"
          placeholder="请输入销售价格"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item>
        <el-button type="primary" icon="el-icon-search" size="mini" @click="handleQuery">搜索</el-button>
        <el-button icon="el-icon-refresh" size="mini" @click="resetQuery">重置</el-button>
      </el-form-item>
    </el-form>

    <el-row :gutter="10" class="mb8">
      <el-col :span="1.5">
        <el-button
          type="primary"
          plain
          icon="el-icon-plus"
          size="mini"
          @click="handleAdd"
          v-hasPermi="['market:market:add']"
        >新增</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="success"
          plain
          icon="el-icon-edit"
          size="mini"
          :disabled="single"
          @click="handleUpdate"
          v-hasPermi="['market:market:edit']"
        >修改</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="danger"
          plain
          icon="el-icon-delete"
          size="mini"
          :disabled="multiple"
          @click="handleDelete"
          v-hasPermi="['market:market:remove']"
        >删除</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="warning"
          plain
          icon="el-icon-download"
          size="mini"
          @click="handleExport"
          v-hasPermi="['market:market:export']"
        >导出</el-button>
      </el-col>
      <right-toolbar :showSearch.sync="showSearch" @queryTable="getList"></right-toolbar>
    </el-row>

    <el-table v-loading="loading" :data="marketList" @selection-change="handleSelectionChange">
      <el-table-column type="selection" width="55" align="center" />
      <el-table-column label="主键" align="center" prop="marketId" />
      <el-table-column label="销售名称" align="center" prop="marketName" />
      <el-table-column label="客户ID" align="center" prop="clientId" />
      <el-table-column label="销售数量" align="center" prop="marketNum" />
      <el-table-column label="销售价格" align="center" prop="marketPrice" />
      <el-table-column label="单位" align="center" prop="marketUnit" />
      <el-table-column label="审核状态" align="center" prop="auditStatus" >
        <template slot-scope="scope">
          <span v-if="scope.row.auditStatus ===0">
             <el-tag  type="danger">未审核</el-tag>
          </span>
          <span v-if="scope.row.auditStatus ===1">
            <el-tag type="primary">审核</el-tag>
          </span>
          <span v-if="scope.row.auditStatus ===2">
            <el-tag   type="success">审批</el-tag>
          </span>
        </template>

      </el-table-column>
      <el-table-column label="审核意见" align="center" prop="auditOpinion" />
      <el-table-column label="审核时间" align="center" prop="auditTime" width="180">
        <template slot-scope="scope">
          <span>{{ parseTime(scope.row.auditTime) }}</span>
        </template>
      </el-table-column>
      <el-table-column label="审核人" align="center" prop="auditPerson" />
      <el-table-column label="审批意见" align="center" prop="approverOpinion" />
      <el-table-column label="审批时间" align="center" prop="approverTime" width="180">
        <template slot-scope="scope">
          <span>{{ parseTime(scope.row.approverTime) }}</span>
        </template>
      </el-table-column>
      <el-table-column label="审批人" align="center" prop="approverPerson" />
      <el-table-column label="描述" align="center" prop="description" />
      <el-table-column label="备注" align="center" prop="remark" />
      <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
        <template slot-scope="scope">
           <span v-if="scope.row.auditStatus === 1">
              <el-button
                size="mini"
                type="text"
                icon="el-icon-delete"
                @click="handleApprover(scope.row)"
                v-hasPermi="['market:market:approver']"
              >审批</el-button>

           </span>
          <span v-if="scope.row.auditStatus === 0">
             <el-button
               size="mini"
               type="text"
               icon="el-icon-edit"
               @click="handleUpdate(scope.row)"
               v-hasPermi="['market:market:edit']"
             >修改</el-button>
          <el-button
            size="mini"
            type="text"
            icon="el-icon-delete"
            @click="handleDelete(scope.row)"
            v-hasPermi="['market:market:remove']"
          >删除</el-button>
            <el-button
              size="mini"
              type="text"
              icon="el-icon-delete"
              @click="handleAudit(scope.row)"
              v-hasPermi="['market:market:audit']"
            >审核</el-button>

          </span>

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

<!--    审批窗口-->
    <el-dialog :title="title" :visible.sync="openApprover" width="960px" append-to-body>
      <el-form ref="form" :model="formApprover" :rules="rules" label-width="180px">
        <el-form-item label="审批状态" prop="auditStatus">
          <el-radio-group v-model="formApprover.auditStatus">
            <el-radio label="1">不通过</el-radio>
            <el-radio label="2">通过</el-radio>
          </el-radio-group>
        </el-form-item>
        <el-form-item label="审批意见" prop="approverOpinion">
          <el-input v-model="formApprover.approverOpinion" type="textarea" placeholder="请输入意见内容" />
        </el-form-item>
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button type="primary" @click="submitFormApprover">确 定</el-button>
        <el-button @click="cancel">取 消</el-button>
      </div>
    </el-dialog>

    <!--审核操作-->
    <el-dialog :title="title" :visible.sync="openAudit" width="960px" append-to-body>
      <el-form ref="form" :model="formAudit" :rules="rules" label-width="180px">
        <el-form-item label="审核状态" prop="auditStatus">
          <el-radio-group v-model="formAudit.auditStatus">
            <el-radio label="0">不通过</el-radio>
            <el-radio label="1">通过</el-radio>
          </el-radio-group>
        </el-form-item>
        <el-form-item label="审核意见" prop="auditOpinion">
          <el-input v-model="formAudit.auditOpinion" type="textarea" placeholder="请输入意见内容" />
        </el-form-item>
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button type="primary" @click="submitFormAudit">确 定</el-button>
        <el-button @click="cancel">取 消</el-button>
      </div>
    </el-dialog>

    <!-- 添加或修改market对话框 -->
    <el-dialog :title="title" :visible.sync="open" width="500px" append-to-body>
      <el-form ref="form" :model="form" :rules="rules" label-width="80px">
        <el-form-item label="销售名称" prop="marketName">
          <el-input v-model="form.marketName" placeholder="请输入销售名称" />
        </el-form-item>
        <el-form-item label="客户ID" prop="clientId">
          <el-input v-model="form.clientId" placeholder="请输入客户ID" />
        </el-form-item>
        <el-form-item label="销售数量" prop="marketNum">
          <el-input v-model="form.marketNum" placeholder="请输入销售数量" />
        </el-form-item>
        <el-form-item label="销售价格" prop="marketPrice">
          <el-input v-model="form.marketPrice" placeholder="请输入销售价格" />
        </el-form-item>
        <el-form-item label="单位" prop="marketUnit">
          <el-input v-model="form.marketUnit" placeholder="请输入单位" />
        </el-form-item>
        <el-form-item label="审核意见" prop="auditOpinion">
          <el-input v-model="form.auditOpinion" placeholder="请输入审核意见" />
        </el-form-item>
        <el-form-item label="审核时间" prop="auditTime">
          <el-date-picker clearable
                          v-model="form.auditTime"
                          type="date"
                          value-format="yyyy-MM-dd"
                          placeholder="请选择审核时间">
          </el-date-picker>
        </el-form-item>
        <el-form-item label="审核人" prop="auditPerson">
          <el-input v-model="form.auditPerson" placeholder="请输入审核人" />
        </el-form-item>
        <el-form-item label="审批意见" prop="approverOpinion">
          <el-input v-model="form.approverOpinion" placeholder="请输入审批意见" />
        </el-form-item>
        <el-form-item label="审批时间" prop="approverTime">
          <el-date-picker clearable
                          v-model="form.approverTime"
                          type="date"
                          value-format="yyyy-MM-dd"
                          placeholder="请选择审批时间">
          </el-date-picker>
        </el-form-item>
        <el-form-item label="审批人" prop="approverPerson">
          <el-input v-model="form.approverPerson" placeholder="请输入审批人" />
        </el-form-item>
        <el-form-item label="描述" prop="description">
          <el-input v-model="form.description" type="textarea" placeholder="请输入内容" />
        </el-form-item>
        <el-form-item label="备注" prop="remark">
          <el-input v-model="form.remark" type="textarea" placeholder="请输入内容" />
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
import { listMarket, getMarket, delMarket, addMarket, updateMarket,auditMarket,approverMarket } from "@/api/market/market";

export default {
  name: "Market",
  data() {
    return {

      openApprover:false,//审批界面是否打开
      formApprover:{
        marketId: 0
      },


      openAudit:false,//窗口是否打开

      formAudit:{
        marketId: 0
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
      // market表格数据
      marketList: [],
      // 弹出层标题
      title: "",
      // 是否显示弹出层
      open: false,
      // 查询参数
      queryParams: {
        pageNum: 1,
        pageSize: 10,
        marketName: null,
        clientId: null,
        marketNum: null,
        marketPrice: null,
        marketUnit: null,
        auditStatus: null,
        auditOpinion: null,
        auditTime: null,
        auditPerson: null,
        approverOpinion: null,
        approverTime: null,
        approverPerson: null,
        description: null,
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

    //审批提交数据
    submitFormApprover(){
      approverMarket(this.formApprover).then(response => {
        this.$modal.msgSuccess("审批操作成功");
        this.openApprover = false;
        this.getList();
      });
    },
    //审批窗口
    handleApprover(row){
      this.formApprover.marketId = row.marketId
      this.openApprover = true
      this.title = '审批窗口'
    },

    //提交审核数据
    submitFormAudit(){
      auditMarket(this.formAudit).then(response => {
        this.$modal.msgSuccess("审核操作成功");
        this.openAudit = false;
        this.getList();
      });
    },
    //审核操作窗口
    handleAudit(row){
      this.formAudit.marketId = row.marketId
      this.openAudit = true
      this.title = '审核窗口'

    },

    /** 查询market列表 */
    getList() {
      this.loading = true;
      listMarket(this.queryParams).then(response => {
        this.marketList = response.rows;
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
        marketId: null,
        marketName: null,
        clientId: null,
        marketNum: null,
        marketPrice: null,
        marketUnit: null,
        auditStatus: 0,
        auditOpinion: null,
        auditTime: null,
        auditPerson: null,
        approverOpinion: null,
        approverTime: null,
        approverPerson: null,
        description: null,
        remark: null,
        createBy: null,
        createTime: null,
        updateBy: null,
        updateTime: null
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
      this.ids = selection.map(item => item.marketId)
      this.single = selection.length!==1
      this.multiple = !selection.length
    },
    /** 新增按钮操作 */
    handleAdd() {
      this.reset();
      this.open = true;
      this.title = "添加market";
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.reset();
      const marketId = row.marketId || this.ids
      getMarket(marketId).then(response => {
        this.form = response.data;
        this.open = true;
        this.title = "修改market";
      });
    },
    /** 提交按钮 */
    submitForm() {
      this.$refs["form"].validate(valid => {
        if (valid) {
          if (this.form.marketId != null) {
            updateMarket(this.form).then(response => {
              this.$modal.msgSuccess("修改成功");
              this.open = false;
              this.getList();
            });
          } else {
            addMarket(this.form).then(response => {
              this.$modal.msgSuccess("新增成功");
              this.open = false;
              this.getList();
            });
          }
        }
      });
    },
    /** 删除按钮操作 */
    handleDelete(row) {
      const marketIds = row.marketId || this.ids;
      this.$modal.confirm('是否确认删除market编号为"' + marketIds + '"的数据项？').then(function() {
        return delMarket(marketIds);
      }).then(() => {
        this.getList();
        this.$modal.msgSuccess("删除成功");
      }).catch(() => {});
    },
    /** 导出按钮操作 */
    handleExport() {
      this.download('market/market/export', {
        ...this.queryParams
      }, `market_${new Date().getTime()}.xlsx`)
    }
  }
};
</script>
