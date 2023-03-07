<template>
  <!-- <img src="../../public/image/首界面/界面框架/导览框.png"> -->
  <nav>
    <div class="logo"><img src="/image/homeview/pattern/logo.png"></div>
    <div>
      <p style="margin-left:30px;"> 纸间万象————中华剪纸文化艺术展览馆</p>
    </div>
    <router-link to="/"
                 class="el-menu-item"
                 active-class="active"
                 id="home-button">
      首页
    </router-link>
    <router-link to="/forum"
                 class="el-menu-item"
                 active-class="active">
      论坛
    </router-link>
    <router-link to="/column"
                 class="el-menu-item"
                 active-class="active">
      专栏
    </router-link>
    <router-link to="/paperwork"
                 class="el-menu-item"
                 active-class="active">
      作品
    </router-link>
    <router-link to="/histories"
                 class="el-menu-item"
                 active-class="active">
      历史
    </router-link>
    <router-link to="/artists"
                 class="el-menu-item"
                 active-class="active">
      艺术家
    </router-link>
    <router-link to="/techs"
                 class="el-menu-item"
                 active-class="active">
      技巧
    </router-link>
    <div :class="isLogined?'dropdown':''">
      <div style="margin-left:60px;"
           class="login-button"
           href="#"
           @click="loginButtonAction">
        <img class="image"
             ref="image"
             :src="this.$global.userAvater" />
      </div>
      <div class="dropdown-content">
        <router-link to="/user/userhome"><a>我的主页</a></router-link>
        <router-link to="/user/managecontent"
                     v-show="(this.$global.roleId==3)"><a>内容管理</a></router-link>
        <router-link to="/"><a @click="loginOutAction">退出登录</a></router-link>

      </div>
    </div>
  </nav>
  <login-form @logined="logined"
              ref="loginForm"></login-form>

</template>
<script scoped>
import LoginForm from './LoginRegister/LoginForm.vue'
import RegisterForm from './LoginRegister/RegisterForm.vue'
export default {
  name: 'TheHeading',
  data() {
    return {
      display: false,
      register: false,
      isLogined: false,
    }
  },
  components: {
    LoginForm,
    RegisterForm,
  },
  computed: {
    loginButtonAction() {
      if (this.isLogined) {
        return null
      }
      return this.login
    },
    loginOutAction() {
      if (this.isLogined) {
        return this.logout
      }
    },
  },
  methods: {
    changeDisplay() {
      this.display = !this.display
    },
    changeRegister() {
      this.register = !this.register
    },
    login() {
      this.$refs.loginForm.init()
    },
    logout() {
      this.$global.userAvater = '/image/homeview/icon/login.png'
      this.isLogined = false
      this.$global.isLogined = false
      ;(this.$global.roleId = 0),
        (this.$global.userIntroduction = ''),
        (this.$global.userId = -1)

      let params = new URLSearchParams()
      let url = 'api/user/logout'
      this.$http.get(url, { params: params }).then((res) => {
        if (res.data.status == 200) {
          ElNotification.success({
            message: '退出登录成功',
            position: 'bottom-right',
            duration: 2000,
          })
          this.$router.push('/')
        }
      })
    },
    logined() {
      console.log('logined')
      this.isLogined = true
    },
  },
  mounted() {
    setTimeout(() => {
      this.isLogined = this.$global.isLogined
      this.$refs.image.src = this.$global.userAvater
    }, 1000)
  },
}
</script>
  
<style lang="css" scoped>
#home-button {
  margin-left: 50px;
}

p {
  font-size: large;
  font-weight: bold;
  color: white;
}

nav {
  display: -webkit-flex;
  display: flex;
  align-items: center;
  justify-content: center;
  background-color: #1d1c16;
  position: relative;
  z-index: 200;
  transition: 0.4s;
}

.image {
  width: 50px;
  height: 50px;
}

nav .el-menu-item {
  color: #ffffff;
  padding: 24px 27px;
  position: relative;
  text-align: center;
  display: flex;
  border-bottom: solid 3px;
  border-bottom-color: transparent;
  font-family: One;
  font-size: normal;
  font-weight: bold;
}

nav .el-menu-item.active {
  background-color: #313028;
  border-bottom: solid 3px;
  border-bottom-color: brown;
}

nav .el-menu-item:hover {
  background-color: #313028;
  border-bottom: solid 3px;
  border-bottom-color: brown;
}

nav .login-button {
  background-color: #ffffff;
  width: 50px;
  height: 50px;
}

nav .login-button:hover {
  cursor: pointer;
}

.dropdown {
  position: relative;
  display: inline-block;
  float: left;
}

.dropdown-content {
  display: none;
  position: absolute;
  background-color: #f9f9f9;
  min-width: 160px;
  box-shadow: 0px 8px 16px 0px rgba(0, 0, 0, 0.2);
}

.dropdown-content a {
  color: #000000;
  padding: 12px 16px;
  text-decoration: none;
  display: block;
  text-align: center;
}

.dropdown-content a:hover {
  background-color: #f1f1f1;
}

.dropdown:hover .dropdown-content {
  display: block;
}

.dropdown:hover .dropbtn {
  background-color: #3e8e41;
}
</style>
  