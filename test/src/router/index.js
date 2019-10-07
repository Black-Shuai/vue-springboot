import Vue from 'vue'
import Router from 'vue-router'
import Login from '../views/Login'
import Main from '../views/Main'
import UserProfile from '../views/user/userProfile'
import UserList from '../views/user/userList'
import TelConnect from '../views/user/telConnect'
Vue.use(Router)

export default new Router({
  mode: 'history',
  routes: [
    {
      path: '/login',
      name: 'Login',
      component: Login
    },
    {
      path: '/main/:username',
      name: 'Main',
      component: Main,
      children: [
        {
          path: '/user/userProfile/:username',
          name: 'UserProfile',
          component: UserProfile,
          props: true
        },
        {
          path: '/user/userList/:username',
          name: 'UserList',
          component: UserList,
          props: true
        },
        {
          path: '/user/telConnect/:username',
          name: 'TelConnect',
          component: TelConnect
        }
      ]
    }
  ]
})
