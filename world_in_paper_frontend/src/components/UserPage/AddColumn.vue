<template>
  <el-dialog title="添加专栏"
             v-model="dialogVisible"
             width="30%"
             class="dialog">
    <div class="add-column">
      <el-form :model="form"
               :rules="rules"
               ref="form"
               label-width="80px"
               class="demo-ruleForm">
        <el-form-item label="专栏名称"
                      prop="name">
          <el-input v-model="form.name"></el-input>
        </el-form-item>
        <el-form-item label="专栏简介"
                      prop="introduction">
          <el-input type="textarea"
                    v-model="form.introduction"></el-input>
        </el-form-item>
        <!-- 专栏封面 -->
        <el-form-item label="专栏封面"
                      prop="cover">
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
        <el-form-item>
          <el-button type="primary"
                     @click="onSubmit">立即创建</el-button>
          <el-button @click="onReset">重置</el-button>
        </el-form-item>
      </el-form>
    </div>
  </el-dialog>
</template>

<script>
export default {
  name: 'AddColumn',
  data() {
    return {
      form: {
        name: '',
        introduction: '',
        cover: '',
      },
      rules: {
        name: [{ required: true, message: '请输入专栏名称', trigger: 'blur' }],
        introduction: [
          { required: true, message: '请输入专栏简介', trigger: 'blur' },
        ],
        cover: [{ required: true, message: '请上传专栏封面', trigger: 'blur' }],
      },
      dialogVisible: false,
    }
  },
  methods: {
    onSubmit() {
      this.$refs.form.validate((valid) => {
        if (valid) {
          let url = 'api/column/addColumn'
          let params = new URLSearchParams()
          params.append('userId', this.$global.userId)
          params.append('title', this.form.name)
          params.append('content', this.form.introduction)
          params.append('coverImg', this.form.cover)
          this.$http.post(url, params).then((res) => {
            if (res.data.status == 200) {
              ElMessage({
                message: '添加成功',
                type: 'success',
              })
              this.$emit('addColumn')
              this.dialogVisible = false
              this.$refs.form.resetFields()
            } else {
              ElMessage({
                message: '添加失败',
                type: 'error',
              })
            }
          })
        } else {
          ElMessage({
            message: '输入错误',
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
        let index = (res.data.image.url).indexOf('images')
        let img = (res.data.image.url).slice(index)
        this.form.cover = this.$global.picBed + img
        console.log(this.form.cover)
        console.log(res)
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
.add-column {
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