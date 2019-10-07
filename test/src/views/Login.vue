<template>
    <div id="app">
      <el-form ref="form" :rules="rules" label-position="top" :model="form" class="login-box">
          <h2 class="title">欢迎登录</h2>
        <el-form-item prop="username">
          <label>账号：</label>
          <el-input type="text" placeholder="请输入用户名" v-model="form.username"/>
        </el-form-item>
        <el-form-item prop="password">
          <label>密码：</label>
          <el-input type="password" placeholder="请输入密码" v-model="form.password"/>
        </el-form-item>
        <el-form-item class="button">
          <el-button type="primary" @click="login">立即登录</el-button>
          <el-button type="primary" button-position="right">取消登录</el-button>
        </el-form-item>
      </el-form>
    </div>
</template>

<script>
export default {
  name: 'Login',
  data () {
    return {
      form: {
        username: '',
        password: ''
      },
      rules: {
        username: [
          {required: true, message: '请输入账户', trigger: 'blur'}
        ],
        password: [
          {required: true, message: '请输入密码', trigger: 'blur'}
        ]
      }
    }
  },
  methods: {
    // 检测表单是否有数据
    // onSubmit: function (formName) {
    //   this.$refs[formName].validate((valid) => {
    //     if (valid) {
    //       // eslint-disable-next-line standard/object-curly-even-spacing
    //       this.$router.push({ name: 'Main', params: { username: this.form.username }})
    //     } else {
    //       this.$message({
    //         message: '请输入账户和密码',
    //         type: 'warning'
    //       })
    //       return false
    //     }
    //   })
    // }
    // 转到主页
    goMain: function (usern) {
      this.$router.push({name: 'Main', params: {username: {usern}}})
    },
    login () {
      this.$axios({
        method: 'post',
        url: 'http://localhost:8810/api/login',
        data: {'username': this.form.username, 'password': this.form.password}
      }).then(res => {
        localStorage.setItem('username', res.data.username)
        sessionStorage.setItem('username', res.data.username)
        console.log(sessionStorage.getItem('username'))
        this.$router.push({name: 'Main', params: {username: res.data.username}})
      }).catch(error => {
        console.log(error)
      })
    }
  }
}
</script>

<style lang="scss" scoped>
  .login-box {
    text-align: left;
    width: 350px;
    height: auto;
    margin: 200px auto;
    border: 2px solid #DCDFE6;
    padding: 25px;
    border-radius: 5px;
    box-shadow: 0 0 25px #DCDFE6;
  }
  .title{
    text-align: center;
  }
  .button{
    text-align: center;
  }
</style>
