<template>
  <div class="comment-card">
    <div class="input-area">
      <div class="column-input">
        <el-avatar :src="this.$global.userAvater">
          shape="square"></el-avatar>
        <el-input type="textarea"
                  resize="none"
                  placeholder="发一条友善的评论见证当下~"
                  v-model="comment"
                  autosize
                  @keyup.enter.native="handleComment">
        </el-input>
        <el-button type="primary"
                   @click="handleComment"
                   :disabled="!comment">发送</el-button>
      </div>

    </div>

    <el-card class="box-card">
      <template #header>
        <span>评论</span>
      </template>
      <div class="comment-list">
        <div class="comment-item"
             v-for="item in commentList"
             :key="item.id">
          <el-avatar :src="item.comment_user_avatar"
                     shape="square"></el-avatar>
          <div class="comment-content">
            <div class="comment-header">
              <span class="comment-name">{{ item.name }}</span>
              <span class="comment-time">{{ item.time }}</span>
            </div>
            <div class="comment-text">{{ item.text }}</div>
          </div>
        </div>

      </div>
    </el-card>

  </div>
</template>

<script>
import DiscordPicker from 'vue3-discordpicker'
export default {
  name: 'CommentCard',
  props: ['articleId'],
  components: {
    DiscordPicker,
  },
  data() {
    return {
      comment: '',
      commentList: [],
    }
  },
  methods: {
    handleComment() {
      if (this.comment === '') {
        ElMessage({
          message: '评论不能为空',
          type: 'warning',
        })
        return
      }
      if (!this.$global.isLogined) {
        ElMessage({
          message: '请先登录',
          type: 'warning',
        })
        return
      }
      let params = new URLSearchParams()
      let url = '/api/article/addArticleComment'
      params.append('userId', this.$global.userId)
      params.append('articleId', this.articleId)
      params.append('comment', this.comment)
      this.$http.post(url, params).then((res) => {
        this.comment = ''
        this.commentList = []
        this.getAllComment()
      }),
        (error) => {
          //   console.log('err')
          console.log(error)
        }
    },
    getAllComment() {
      let params = new URLSearchParams()
      let url = '/api/article/getArticleComments'
      params.append('articleId', this.articleId)
      console.log(this.articleId)
      this.$http.get(url, { params: params }).then(
        //成功
        (res) => {
          for (let i = 0; i < res.data.data.length; i++) {
            let item = res.data.data[i]
            let commentItem = {
              name: item.comment_user_name,
              time: item.comment_time,
              text: item.content,
              comment_user_avatar: item.comment_user_avatar,
            }
            console.log(commentItem.comment_user_avatar)

            this.commentList.push(commentItem)
          }
        },
        (err) => {
          console.log(err)
        }
      )
    },
  },
  mounted() {
    this.getAllComment()
  },
}
</script>

<style scoped>
.comment-card {
  margin: 15px auto;
  padding: 15px;
  background-color: transparent;
  border-radius: 4px;
  font-family: 'sans-serif';
}

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
.column-input:deep(.el-avatar--circle) {
  border-radius: 10%;
}
.input-area {
  background-color: #fefbf4;
  padding: 10px;
  margin-bottom: 15px;
  box-shadow: 0 0 12px rgba(0, 0, 0, 0.12);
  border-radius: 3px;
}

.send-area {
  display: flex;
  align-items: center;
  justify-content: space-between;
  margin-top: 10px;
}

.comment-list {
  margin-top: 15px;
}

.comment-item {
  display: flex;
  margin-bottom: 30px;
}

.comment-item:deep(.el-avatar) {
  margin-right: 10px;
  height: 40px;
  width: 40px;
}

.comment-content {
  width: 100%;
}

.comment-header {
  display: flex;
  justify-content: space-between;
  margin-bottom: 5px;
}

.comment-header .comment-name {
  font-size: 14px;
  font-weight: 700;
}

.comment-header .comment-time {
  font-size: 12px;
  color: #999;
}

.comment-content .comment-text {
  font-size: 14px;
  color: #666;
}

.comment-content:deep(.vue3-emojipicker) {
  display: flex;
}

:deep(.box-card) {
  background-color: #fefbf4;
}
</style>