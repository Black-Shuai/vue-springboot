<template>
  <div>
    <el-button type="text" @click="centerDialogVisible = true">点击打开 Dialog</el-button>

    <el-dialog
      title="提示"
      :visible.sync="centerDialogVisible"
      width="50%"
      center>
      <span class="el-dialog__body">
        <el-row type="flex" class="row-bg">
          <el-col :span="6"><div class="grid-content bg-purple"><label style="font-size:16px">主叫电话：</label></div></el-col>
         <el-input placeholder="请输入内容" v-model="input1" clearable></el-input>
        </el-row>
        <el-row type="flex" class="row-bg">
          <el-col :span="6"><div class="grid-content bg-purple"><label style="font-size:16px">被叫电话：</label></div></el-col>
          <el-input placeholder="请输入内容" v-model="input2" clearable></el-input>
        </el-row>
      </span>
      <span slot="footer" class="dialog-footer">
    <el-button @click="centerDialogVisible = false">取 消</el-button>
    <el-button type="primary" @click="getContent">确 定</el-button>
  </span>
    </el-dialog>
  </div>
</template>

<script>
export default {
  name: 'telConnect',
  data () {
    return {
      centerDialogVisible: false,
      input1: '',
      input2: ''
    }
  },
  methods: {
    getContent () {
      this.centerDialogVisible = false
    }
  }
}
</script>

<style lang="scss" scoped>
  .el-input{
    padding-bottom: 30px;
  }
  .bg-purple{
    padding-top: 10px;
  }
  .el-dialog__body {
    padding: 25px 25px 0px;
  }
</style>
