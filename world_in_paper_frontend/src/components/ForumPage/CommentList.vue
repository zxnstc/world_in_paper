<!-- <template>
  <div>
    <div v-for="item of comments">
      <div class="comment">
        <div class="comment-header">
          <div class="comment-header-left">
            <img src="http://117.50.179.215:8056/123.jpg"
                 alt="" />
          </div>
          <div class="comment-header-right">
            <div class="comment-header-right-top">
              <span>{{ item.comment_user_name }}</span>
              <span>{{ item.comment_time }}</span>
            </div>
            <div class="comment-header-right-bottom"></div>
          </div>
        </div>
        <div class="comment-content">
          <p>{{ item.content }}</p>
        </div>
      </div>
    </div>
  </div>
</template> -->

<template>
  <el-card class="box-card">
    <template #header>
      <span>评论</span>
    </template>
    <div class="comment-list">
      <div class="comment-item" 
            v-for="item in comments"
            :key="item.id">
        <el-avatar :src=item.comment_user_avatar
                    shape="square"></el-avatar>
        <div class="comment-content">
          <div class="comment-header">
            <span class="comment-name">{{ item.comment_user_name }}</span>
            <span class="comment-time">{{ item.comment_time }}</span>
          </div>
          <div class="comment-text">{{ item.content }}</div>
        </div>
      </div>
    </div>
  </el-card>



</template>



<script>
export default {
  name: 'CommentList',
  inject: ['topicId'],
  data() {
    return {
      avatarUrl: '/logo.png',
      comments: [
        {
          thumbsCount: 2,
          comment_time: '2022-07-06T23:02:05.000+0000',
          comment_user_name: '123',
          comment_user_avatar: 'www.melia-trantow.net',
          comment_topic_id: 1,
          comment_user_id: 1,
          id: 12,
          type: '1',
          content: 'Yz2C',
          floor_count: 2,
          comment_user_rank: '0',
        },
      ],
    }
  },
  methods: {
    getCommentList() {
      let params = new URLSearchParams()
      let url = '/api/comment/getCommentList'
      console.log(this.topicId)
      params.append('topic_id', this.topicId)
      this.$http.get(url, { params: params }).then(
        //成功
        (res) => {
          console.log(res)
          console.log('success')
          this.comments = res.data.data
          console.log(this.comments)
        },
        //失败
        (err) => {
          console.log('error')
          console.log(err)
        }
      )
    },
  },
  mounted() {
    this.getCommentList()
  },
}
</script>

<style scoped>
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


</style>



