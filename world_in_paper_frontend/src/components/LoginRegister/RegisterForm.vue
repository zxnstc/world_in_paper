<template>
  <div class="register-dialog">
    <el-dialog title="注册"
               v-model="RegisterFormVisible"
               width="25%"
               :before-close="showLoginDialog">
      <el-form class="register-form">
        <el-form-item class="form-item">
          <el-input class="el-input"
                    v-model="registerForm.username"
                    placeholder="请输入用户名"></el-input>
        </el-form-item>
        <el-form-item class="form-item">
          <el-input class="el-input"
                    type="password"
                    v-model="registerForm.password"
                    placeholder="请输入密码"></el-input>
        </el-form-item>

        <el-form-item class="form-item">
          <el-input class="el-input"
                    type="password"
                    v-model="registerForm.password2"
                    placeholder="请再次输入密码"
                    @blur="testPassord()"></el-input>
        </el-form-item>

        <el-form-item class="form-item">
          <el-input class="el-input"
                    v-model="registerForm.email"
                    placeholder="请输入邮箱"
                    @blur="testEmail()"></el-input>
        </el-form-item>

        <el-form-item class="form-item">
          <el-input class="el-input"
                    v-model="registerForm.code"
                    placeholder="请输入验证码"></el-input>
          <el-button id="getCodeButton"
                     @click="getCode"
                     :class="sent?'sent':''"
                     ref="getCodeButton"> 获取验证码 {{countdown!==-1?'('+countdown+'s)':''}}</el-button>
        </el-form-item>

        <el-form-item class="form-item">
          <el-button id="registerButton"
                     type="primary"
                     @click="register">注册</el-button>
        </el-form-item>
      </el-form>
    </el-dialog>
  </div>
</template>

<script  >
export default {
  name: 'RegisterForm',
  data() {
    return {
      isPasswordTrue: false,
      isEmailTrue: false,
      registerForm: {
        username: '',
        password: '',
        password2: '',
        email: '',
        code: '',
      },
      sent: false,
      RegisterFormVisible: false,
      countdown: -1,
    }
  },
  emits: {
    changeRegister: null,
  },
  methods: {
    // 注册
    register() {
      if (!this.isPasswordTrue || !this.isEmailTrue) {
        ElMessage({
          message: '请检查输入是否正确',
          type: 'error',
        })
        return
      }
      let params = new URLSearchParams()
      let url = '/api/user/register'
      params.append('username', this.registerForm.username)
      params.append('password', this.registerForm.password)
      params.append('email', this.registerForm.email)
      params.append('code', this.registerForm.code)
      this.$http.post(url, params).then((res) => {
        if (res.data.status === 200) {
          ElMessage({
            message: '注册成功',
            type: 'success',
          })
          this.showLoginDialog()
        } else {
          ElMessage({
            message: res.data.msg,
            type: 'error',
          })
        }
      })
    },
    // 发送验证码
    getCode() {
      if (this.sent) {
        ElMessage({
          message: '请稍等',
          type: 'error',
        })
        return
      }
      let params = new URLSearchParams()
      let url = '/api/user/sendMail'
      params.append('email', this.registerForm.email)
      this.$http.post(url, params).then((res) => {
        if (res.data.status === 200) {
          ElMessage({
            message: '成功发送验证码',
            type: 'success',
          })
          this.sent = true
          this.countdown = 300
        } else {
          ElMessage({
            message: res.data.message,
            type: 'error',
          })
        }
      })
    },
    //判断两次密码是否一致
    testPassord() {
      if (this.registerForm.password != this.registerForm.password2) {
        ElMessage({
          message: '两次密码不一致，请重新输入',
          type: 'error',
        })
        this.isPasswordTrue = false
      } else {
        this.isPasswordTrue = true
      }
    },
    //判断邮箱格式是否正确
    testEmail() {
      var temp = this.registerForm.email
      //对电子邮件的验证
      var myreg =
        /^([a-zA-Z0-9]+[_|\_|\.]?)*[a-zA-Z0-9]+@([a-zA-Z0-9]+[_|\_|\.]?)*[a-zA-Z0-9]+\.[a-zA-Z]{2,3}$/
      if (!myreg.test(temp)) {
        ElMessage({
          message: '请输入有效的E_mail！',
          type: 'error',
        })
        this.isEmailTrue = false
      } else {
        this.isEmailTrue = true
      }
    },
    init() {
      console.log('init')
      this.RegisterFormVisible = true
    },
    showLoginDialog() {
      this.RegisterFormVisible = false
      this.$emit('showLoginDialog')
    },
  },
  watch: {
    countdown() {
      if (this.countdown === -1) {
        this.sent = false
      } else if (this.countdown >= 0) {
        setTimeout(() => {
          this.countdown--
        }, 1000)
      }
    },
  },
}
</script>

<style scoped>
@font-face {
  font-family: 'CNKI';
  src: url('../../assets/fonts/HGZCS_CNKI.TTF');
}

.register-dialog :deep(.el-dialog__header) {
  text-align: center;
}
.register-dialog :deep(.el-dialog) {
  background-image: url('/image/homeview/frame/background.png');
  border-radius: 15px;
}

.register-dialog:deep(.el-form-item) {
  margin-bottom: 30px;
}
.register-dialog:deep(.el-input) {
  height: 50px;
}

.register-dialog:deep(.el-input__inner) {
  font-size: 16px;
}

.register-dialog:deep(.el-dialog__headerbtn:focus) {
  outline: 0;
}

.register-form {
  display: flex;
  height: 450px;
  flex-direction: column;
  justify-content: center;
  align-items: center;
}

.form-item {
  width: 250px;
  height: 45px;
}

/* 验证码 */
#getCodeButton {
  position: absolute;
  top: 55%;
  left: 75%;
  transform: translate(-50%, -50%);
  width: 120px;
  height: 40px;
  font-size: 12px;
  font-weight: bold;
  color: rgb(255, 79, 76);
  background-color: #fff;
  border-radius: 8px;
  cursor: pointer;
  font-family: 'CNKI';
}

#getCodeButton.sent {
  color: #999;
  cursor: not-allowed;
}

/* 注册 */
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