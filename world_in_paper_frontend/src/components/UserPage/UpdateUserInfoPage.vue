<template>

  <!-- <el-upload class="cover-uploader"
                   :http-request="uploadAvatar"
                   :show-file-list="false">
          <img v-if="form.cover"
               :src="form.cover"
               class="avatar" />
          <el-icon v-else
                   class="avatar-uploader-icon">
            <Plus />
          </el-icon>
        </el-upload> -->

  <div class="update_info_box">
    <div class="update_info_title">
      <h3>😊修改个人信息:</h3>
    </div>
    <div class="update_avatar">
      <el-form-item label="请上传头像:">

        <el-upload class="cover-uploader"
                   :http-request="uploadAvatar"
                   :show-file-list="false">
          <img v-if="user_avatar"
               :src="user_avatar"
               class="avatar" />
          <el-icon v-else
                   class="avatar-uploader-icon">
            <Plus />
          </el-icon>
        </el-upload>
      </el-form-item>
    </div>

    <!-- 原生上传用户头像 -->
    <!-- <div>
        <span>修改用户头像 :   </span>
      <input type="file"
             ref="file"
             @change="uploadAvatar">
      </div> -->
    <div class="update_info">
      <el-form-item label="请修改个性签名:">
        <div>
          <el-input type="textarea"
                    :rows="3"
                    placeholder="请输入内容"
                    v-model="introduction">
          </el-input>
        </div>
      </el-form-item>
    </div>

    <el-button class="submitbutton"
               @click="updateUserInfo()">提交</el-button>

  </div>

</template>
  
<script>
export default {
  name: 'UpdateUserInfoPage',
  data() {
    return {
      user_avatar: '',
      introduction: '',
    }
  },
  methods: {
    updateUserInfo() {
      let params = new URLSearchParams()
      let url = '/api/user/updateUserInfo'
      params.append('avatar', this.user_avatar)
      console.log(this.user_avatar)
      params.append('id', this.$global.userId)
      console.log(this.$global.userId)
      params.append('introduction', this.introduction)
      console.log(this.introduction)
      this.$http.post(url, params).then((res) => {
        if (res.data.status === 200) {
          ElMessage({
            message: res.data.message,
            type: 'success',
          })
          this.$global.userAvatar = res.data.data.avatar
          this.$global.userIntroduction = res.data.data.introduction
          this.$router.go(0)
        } else {
          ElMessage({
            message: res.data.message,
            type: 'error',
          })
        }
      })
    },
    // 上传头像
    uploadAvatar(e) {
      let file = e.file
      let data = new FormData()
      let url = '/myimage/api/1/upload'
      data.append('key', '4fb2110371629a961969a7ea99e3cfba')
      data.append('format', 'json')
      data.append('source', file)
      this.$http({
        url: url,
        method: 'post',
        headers: {
          'Content-Type': 'multipart/form-data',
        },
        data: data,
      }).then((res) => {
        ElMessage({
          message: '上传成功',
          type: 'success',
        })
        let index = res.data.image.url.indexOf('images')
        let img = res.data.image.url.slice(index)
        this.user_avatar = this.$global.picBed + img
      })
    },
  },
}
</script>
     
<style scoped>
.update_info_box {
  margin: auto;
  margin-top: 100px;
  width: 40%;
  height: 500px;
  display: flex;
  flex-direction: column;
  justify-content: space-around;

  background-color: #fff;
  border-radius: 10px;
  padding: 30px;
  box-shadow: 0 0 10px #ccc;
}

.avatar-uploader .avatar {
  width: 178px;
  height: 178px;
  display: block;
}

:deep(.avatar-uploader .el-upload) {
  border: 1px dashed var(--el-border-color);
  border-radius: 6px;
  cursor: pointer;
  position: relative;
  overflow: hidden;
  transition: var(--el-transition-duration-fast);
}

:deep(.avatar-uploader .el-upload:hover) {
  border-color: var(--el-color-primary);
}

:deep(.el-icon.avatar-uploader-icon) {
  font-size: 28px;
  color: #8c939d;
  width: 178px;
  height: 178px;
  text-align: center;
}

.cover-uploader :deep(.el-upload) {
  border: 1px dashed var(--el-border-color);
  border-radius: 6px;
  cursor: pointer;
  position: relative;
  overflow: hidden;
  transition: var(--el-transition-duration-fast);
}
.submitbutton {
  margin-top: 20px;
  margin-left: 40%;
  width: 20%;
  height: 40px;
  background-color: #409eff;
  color: #fff;
  border-radius: 10px;
  border: none;
}
.update_info_title {
  margin: auto;
}
.update_avatar {
  margin-left: 35px;
}
.update_info {
  margin-left: 10px;
}
</style>