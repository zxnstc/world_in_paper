<template>
  <el-dialog title="发布帖子"
             v-model="dialogVisible"
             width="30%"
             class="dialog">
    <div class="add-column">
      <el-form :model="form"
               :rules="rules"
               ref="form"
               label-width="80px"
               class="demo-ruleForm">
        <el-form-item label="帖子标题"
                      prop="title">
          <el-input v-model="form.title"></el-input>
        </el-form-item>
        <el-form-item label="帖子内容"
                      prop="content">
          <el-input type="textarea"
                    v-model="form.content"></el-input>
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
        title: '',
        content: '',
      },
      rules: {
        title: [{ required: true, message: '请输入帖子标题', trigger: 'blur' }],
        content: [
          { required: true, message: '请输入帖子内容', trigger: 'blur' },
        ],
      },
      dialogVisible: false,
    }
  },
  methods: {
    onSubmit() {
      this.$refs.form.validate((valid) => {
        if (valid) {
          let params = new URLSearchParams()
          let url = '/api/forum/addTopic'
          params.append('content', this.form.content)
          params.append('title', this.form.title)
          params.append('userId', this.$global.userId)
          this.$http.post(url, params).then((res) => {
            if (res.data.status == 200) {
              ElMessage({
                message: '发帖成功',
                type: 'success',
              })
              this.$emit('updateList')
              this.dialogVisible = false
            } else if (res.data.status === 4) {
              console.log(res.data.message)
              ElMessage({
                message: res.data.message,
                type: 'warning',
              })
            } else {
              ElMessage({
                message: res.data.message,
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