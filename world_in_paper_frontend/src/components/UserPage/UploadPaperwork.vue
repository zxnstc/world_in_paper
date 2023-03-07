<template>
  <el-dialog title="添加作品"
             v-model="dialogVisible"
             width="40%"
             class="dialog">
    <div class="upload-paperwork">

      <el-form :model="form"
               :rules="rules"
               ref="form"
               label-width="80px"
               class="demo-ruleForm">
        <el-form-item label="作品名称"
                      prop="name">
          <el-input v-model="form.name"></el-input>
        </el-form-item>
        <el-form-item label="作品简介"
                      prop="introduction">
          <el-input type="textarea"
                    v-model="form.introduction"></el-input>
        </el-form-item>
        <el-form-item label="上传设置">
          <el-select v-model="form.image"
                     placeholder="上传">
            <el-option label="图片链接"
                       value="link"></el-option>
            <el-option label="图片上传"
                       value="upload"></el-option>
          </el-select>
        </el-form-item>
        <el-collapse-transition>
          <el-form-item label="图片链接"
                        prop="cover"
                        v-if="form.image === 'link'">
            <el-input v-model="form.cover"></el-input>
          </el-form-item>
        </el-collapse-transition>
        <!-- 专栏封面 -->
        <el-collapse-transition>
          <el-form-item label="作品图片"
                        prop="cover"
                        v-if="form.image === 'upload'">
            <el-upload class="avatar-uploader"
                       :show-file-list="false"
                       :http-request="handleUpload">
              <img v-if="form.cover"
                   :src="form.cover"
                   class="avatar">
              <el-icon v-else
                       class="avatar-uploader-icon">
                <Plus />
              </el-icon>
            </el-upload>
          </el-form-item>
        </el-collapse-transition>
        <!-- <el-form-item label="背景设置">
          <el-select v-model="form.customBackground"
                     placeholder="请选择背景">
            <el-option label="默认背景"
                       value="default"></el-option>
            <el-option label="纯色背景"
                       value="color"></el-option>
            <el-option label="自定义背景"
                       value="custom"></el-option>
          </el-select>
        </el-form-item> -->
        <el-collapse-transition>
          <el-form-item v-if="form.customBackground === 'custom'"
                        label="自定义背景"
                        prop="background">
            <el-upload class="avatar-uploader"
                       :show-file-list="false"
                       :http-request="handleUpload">
              <img v-if="form.background"
                   :src="form.background"
                   class="avatar">
              <el-icon v-else
                       class="avatar-uploader-icon">
                <Plus />
              </el-icon>
            </el-upload>
          </el-form-item>
        </el-collapse-transition>
        <el-collapse-transition>
          <el-form-item v-if="form.customBackground === 'color'"
                        label="纯色背景"
                        prop="color">
            <el-color-picker v-model="form.color"></el-color-picker>
          </el-form-item>
        </el-collapse-transition>
        <el-form-item>
          <el-button type="primary"
                     @click="onSubmit">立即上传</el-button>
          <el-button @click="onReset">重置</el-button>
        </el-form-item>
      </el-form>
    </div>
  </el-dialog>
</template>

<script>
export default {
  name: 'UploadPaperwork',
  data() {
    return {
      form: {
        name: '',
        introduction: '',
        cover: '',
        customBackground: 'default',
        background: '',
        color: '',
        image: 'link'
      },
      rules: {
        name: [{ required: true, message: '请输入作品名称', trigger: 'blur' }],
        introduction: [
          { required: true, message: '请输入作品简介', trigger: 'blur' },
        ],
        cover: [{ required: true, message: '请上传作品图片', trigger: 'blur' }],
        background: [
          { required: true, message: '请上传自定义背景', trigger: 'blur' },
        ],
        color: [{ required: true, message: '请选择纯色背景', trigger: 'blur' }],
      },
      dialogVisible: false,
    }
  },
  methods: {
    onSubmit() {
      this.$refs.form.validate((valid) => {
        if (valid) {
          let url = 'api/paperwork/uploadPaperwork'
          let params = new URLSearchParams()
          params.append('backgroundCustom', this.form.customBackground)
          params.append('backgroundUrl', this.form.background)
          params.append('color', this.form.color)
          params.append('imageUrl', this.form.cover)
          params.append('content', this.form.introduction)
          params.append('title', this.form.name)
          params.append('userId', this.$global.userId)
          this.$http.post(url, params).then((res) => {
            if (res.data.status === 200) {
              ElMessage({
                message: '创建成功',
                type: 'success',
              })
              this.dialogVisible = false
              this.$refs.form.resetFields()
              this.$emit('upload-paperwork')
            } else {
              ElMessage({
                message: '创建失败',
                type: 'error',
              })
            }
          })
        } else {
          ElMessage({
            message: '创建失败',
            type: 'error',
          })
          return false
        }
      })
    },
    onReset() {
      this.$refs.form.resetFields()
    },
    handleUpload(e) {
      const file = e.file
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
        let index = res.data.image.url.indexOf('images')
        let img = res.data.image.url.slice(index)
        this.form.cover = this.$global.picBed + img
        ElMessage({
          message: '图片上传成功',
          type: 'success',
        })
      })
    },
    init() {
      this.dialogVisible = true
    },
  },
}
</script>

<style scoped>
.upload-paperwork {
  width: 100%;
  height: 100%;
  background-color: #fff;
  padding: 20px;
  /* background-image: url(/image/dialogbk.png);
  background-repeat: no-repeat;
  background-size: 100% 100%; */
}

.avatar-uploader :deep(.el-upload) {
  border: 1px dashed #d9d9d9;
  border-radius: 6px;
  cursor: pointer;
  position: relative;
  overflow: hidden;
  display: inline-block;
  height: 178px;
}

:deep(.avatar-uploader-icon) {
  font-size: 28px;
  color: #8c939d;
  width: 178px;
  height: 178px;
  line-height: 178px;
  text-align: center;
}

.avatar {
  height: 178px;
  display: block;
}
</style>