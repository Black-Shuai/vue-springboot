<template>
    <div style="backgroundImage='../assets/56.jpg'">
<!-- 页头-->
        <el-header style="text-align: right; font-size: 12px">
          <el-dropdown>
            <i class="el-icon-setting" style="margin-right: 15px"></i>
            <el-dropdown-menu slot="dropdown">
              <el-dropdown-item>个人信息</el-dropdown-item>
              <el-dropdown-item>修改密码</el-dropdown-item>
              <el-dropdown-item>
                <router-link to="/login">退出登录</router-link>
              </el-dropdown-item>
            </el-dropdown-menu>
          </el-dropdown>
          <span>{{ this.getUsername() }}</span>
        </el-header>
<!-- 导航栏和显示页面-->
        <el-container>
          <el-container>
          <el-aside width="200px" style="background-color: rgb(238, 241, 246)">
            <el-menu :default-openeds="['1']">
              <el-submenu index="1">
                <template slot="title"><i class="el-icon-message"></i>个人信息</template>
                  <el-menu-item index="1-1">
                    <router-link :to="{ name:'UserProfile', params:{ username: $route.params.username }}">用户信息</router-link>
                  </el-menu-item>
                  <el-menu-item index="1-2">
                    <router-link :to="{ name:'UserList', params:{ username: $route.params.username }}">用户列表</router-link>
                  </el-menu-item>
                  <el-menu-item index="1-3">信息修改</el-menu-item>
              </el-submenu>
              <el-submenu index="2">
                <template slot="title"><i class="el-icon-menu"></i>导航二</template>
                  <el-menu-item index="2-1">
                    <router-link :to="{ name:'TelConnect', params:{ username: $route.params.username }}">电话连接</router-link>
                  </el-menu-item>
                  <el-menu-item index="2-2">选项2</el-menu-item>
                  <el-menu-item index="2-3">选项3</el-menu-item>
              </el-submenu>
              <el-submenu index="3">
                <template slot="title"><i class="el-icon-setting"></i>导航三</template>
                  <el-menu-item index="3-1">选项1</el-menu-item>
                  <el-menu-item index="3-2">选项2</el-menu-item>
                  <el-menu-item index="3-3">选项3</el-menu-item>
              </el-submenu>
            </el-menu>
          </el-aside>
<!-- 显示内容-->
          <el-main>
              <router-view></router-view>
          </el-main>
        </el-container>
      </el-container>
    </div>
</template>

<script>
export default {
  name: 'Main',
  beforeRouteEnter: (to, from, next) => { // 通过钩子实现对当前登录状态的验证
    if (sessionStorage.getItem('username') == null) {
      next({name: 'Login'})
    }
    next()
  },
  methods: {
    getUsername () {
      return sessionStorage.getItem('username')
    },
    getUsernameBylocalStorage () {
      return localStorage.getItem('username')
    }
  }
}
</script>

<style lang="scss" scoped>
  .el-header {
    background-color: #B3C0D1;
    color: #333;
    line-height: 60px;
  }
  .el-container{
    height: 100%;
    min-height: 100vh;
    border: 1px solid #eee
  }
  .el-aside {
    color: #333;
    display: block;
    left: 0;
    top: 70px;
    bottom: 0;
    overflow-y: scroll;
  }
</style>
