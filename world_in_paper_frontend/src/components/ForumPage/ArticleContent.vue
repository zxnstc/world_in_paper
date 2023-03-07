<template>
  <div class="article">
    <el-card>
      <template #header>
        <div class="headline">
     <h2 > {{article.title}}</h2>
    </div>
        </template>
        <div class="content">
      <p>
        {{ article.content }}
      </p>
    </div>

    </el-card>
  
  </div>

</template>
<script>

export default {
  inject:['topicId'],
  props:{article:Object},
  data() {
    return {
      

    //   article: {
    //     "create_time": "2022-10-27",
    // "topic_user_introduction": "A0UuY",
    // "topic_user_rank": "0",
    // "topic_user_username": "123",
    // "topic_user_email": "Wq@e9I.com",
    // "creator_id": 1,
    // "id": 21,
    // "topic_user_id": "1",
    // "title": "你好",
    // "topic_user_avatar": "http://117.50.179.215:8056/123.jpg",
    // "content": "你好你好你好你好你好你好你好你好你好你好你好你好",
    // "status": "1"
    //   },
      
      



    };

  },
  methods: {
    getTopicDetail() {
      let params = new URLSearchParams()
      let url = '/api/forum/getTopicDetail'
      params.append('topicId', this.topicId)
      this.$http.get(url, { params: params }).then(
        //成功
        (res) => {
          this.article = res.data.data

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
    //this.getTopicDetail()
    console.log(this.article+'-----')
  
  },
}
</script>
<style scoped>

.headline {
  text-align: center;
  font-size: large;
  color: rgb(145, 108, 0);
}

.author-card {
  height: 150px;
  width: 350px;
  padding-left: 5%;
}

.author-image {
  width: 50px;
  height: 50px;
}
.content {
  padding-left: 5%;
  padding-right: 5%;
  padding-bottom: 5%;
}
</style>