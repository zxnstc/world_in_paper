<template>

  <div class="input-area">
    <div class="column-input">
      <el-avatar :src=this.$global.userAvater
                 shape="square"></el-avatar>
      <el-input type="textarea"
                resize="none"
                placeholder="发一条友善的评论见证当下~"
                v-model="comment"
                autosize
                @keyup.enter.native="submitcomment">
      </el-input>
      <el-button type="primary"
                 @click="submitcomment"
                 :disabled="!comment">发送</el-button>
    </div>

  </div>

  <!--之前的那个版本-->
  <!-- <el-input
    type="textarea"
 :rows="2"
 placeholder="请输入内容"
 v-model="comment"
>
 </el-input>
 <el-row>
          <el-col :span="40"
                  style="height: 10px;" />
        </el-row>
 <el-form-item>
 <el-button type="primary" @click="submitcomment">发表评论</el-button>
 <el-button>取消</el-button>
</el-form-item> -->
</template>


<script>
export default {
  inject: ['topicId'],
  data: function () {
    return {
      comment: '',
      userId: '',
    }
  },
  methods: {
    submitcomment() {
      let params = new URLSearchParams()
      let url = '/api/comment/addTopicComment'
      let userId = this.$global.userId
      let comment = this.comment
      params.append('comment', comment)
      params.append('topicId', this.topicId)
      params.append('userId', userId)
      this.$http.post(url, params).then((res) => {
        if (res.data.status === 200) {
          //根据CodeEnum类规定的状态码进行判断
          console.log('添加成功')
          this.$emit('addSuccessfully')
        } else if (res.data.status === 4) {
          console.log(res.data.message)
          ElMessage({
            message: '请先登录！',
            type: 'warning',
          })
        } else {
          console.log('添加失败')
        }
      })
      this.comment = ''
    },
  },
  mounted() {},
}
</script>






<style scoped>
.column-input {
  display: flex;
  align-items: center;
}

.column-input:deep(.el-avatar) {
  margin-right: 10px;
  height: 40px;
  width: 40px;
}

.column-input:deep(.el-input) {
  width: 100%;
}

.input-area {
  background-color: #fff;
  padding: 10px;
  margin-bottom: 15px;
  box-shadow: 0 0 12px rgba(0, 0, 0, 0.12);
  border-radius: 3px;
  margin-top: 15px;
}
</style>









