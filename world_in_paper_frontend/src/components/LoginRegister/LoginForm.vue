<template>
  <div class="login-dialog">
    <el-dialog title="登录"
               v-model="loginFormVisible"
               width="25%"
               :rules="rules">
      <el-form class="login-form">
        <div class="input-group">
          <el-form-item class="form-item">
            <el-input v-model="loginForm.username"
                      placeholder="请输入用户名"
                      props="username"></el-input>
          </el-form-item>

          <el-form-item class="form-item">
            <el-input type="password"
                      v-model="loginForm.password"
                      placeholder="请输入密码"
                      props="password"></el-input>
          </el-form-item>
        </div>
        <div class="button-group">
          <el-form-item class="form-item">
            <el-button id="loginButton"
                       type="primary"
                       @click="login">登录</el-button>
          </el-form-item>
          <el-form-item class="form-item">
            <el-button id="registerButton"
                       type="primary"
                       @click="openRegister">注册</el-button>
          </el-form-item>
        </div>
      </el-form>
    </el-dialog>
    <register-form ref="registerDialog"
                   @show-login-dialog="init"></register-form>
  </div>
</template>

<script>
import RegisterForm from './RegisterForm.vue'

export default {
  name: 'LoginForm',
  components: { RegisterForm },
  data() {
    return {
      loginForm: {
        username: '',
        password: '',
      },
      loginFormVisible: false,
    }
  },
  emits: {
    changeDisplay: null,
    changeRegister: null,
    logined: null,
  },
  methods: {
    login() {
      let params = new URLSearchParams()
      let url = '/api/user/login'
      params.append('username', this.loginForm.username)
      params.append('password', this.loginForm.password)
      this.$http.post(url, params).then((res) => {
        if (res.data.status === 200) {
          ElNotification.success({
            message: '登录成功',
            position: 'bottom-right',
            duration: 2000,
          })
          console.log(res.data.data)
          this.loginFormVisible = false
          this.$global.userId = res.data.data.user_id
          this.$global.userName = res.data.data.user_name
          this.$global.isLogined = true
          this.$global.roleId = res.data.data.role_id
          this.$global.userAvater = res.data.data.user_avatar
          this.$global.userIntroduction = res.data.data.user_introduction
          this.$global.rank = res.data.data.rank
          this.$emit('logined', res.data.data)
          console.log('用户id:' + this.$global.userId)
          console.log('用户权限:' + this.$global.roleId)
        } else {
          ElMessage({
            message: '登录失败',
            type: 'error',
          })
        }
      })
    },
    init() {
      console.log('init')
      this.loginForm.username = ''
      this.loginForm.password = ''
      this.loginFormVisible = true
    },
    openRegister() {
      this.loginFormVisible = false
      this.$refs.registerDialog.init()
    },
  },
}
</script>

<style scoped>
@font-face {
  font-family: 'CNKI';
  src: url('../../assets/fonts/HGZCS_CNKI.TTF');
}

.login-dialog :deep(.el-dialog) {
  background-image: url('/image/homeview/frame/background.png');
  border-radius: 15px;
}
.login-dialog:deep(.el-dialog__header) {
  text-align: center;
}
.login-dialog:deep(.el-form-item) {
  margin-bottom: 30px;
}
.login-dialog:deep(.el-input) {
  height: 50px;
}

.login-dialog:deep(.el-input__inner) {
  font-size: 16px;
}

.login-dialog:deep(.el-dialog__headerbtn:focus) {
  outline: 0;
}

.login-form {
  height: 450px;
  display: flex;
  flex-direction: column;
  justify-content: center;
  align-items: center;
}

.form-item {
  width: 250px;
  height: 45px;
}

#loginButton {
  width: 250px;
  height: 45px;
  border-radius: 12px;
  background-image: linear-gradient(
    90deg,
    rgba(255, 150, 76, 1) 0%,
    rgba(255, 100, 76, 1) 50%,
    rgba(255, 50, 76, 1) 100%
  );
  display: flex;
  justify-content: center;
  align-items: center;
  font-family: 'CNKI';
}

#registerButton {
  width: 250px;
  height: 45px;
  border-radius: 12px;
  background-image: linear-gradient(
    90deg,
    rgba(255, 150, 76, 1) 0%,
    rgba(255, 100, 76, 1) 50%,
    rgba(255, 50, 76, 1) 100%
  );
  display: flex;
  justify-content: center;
  align-items: center;
  font-family: 'CNKI';
}
</style>
