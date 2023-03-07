<template>
  <div class="author-list">
    <el-divider style="margin: 10px 0 0 0;" />
    <el-card>
      <header class="user-block-header">🎖️作者榜</header>
    </el-card>
    <el-row v-for="item in topAuthor">
      <el-card shadow="hover"
               class="author-card">
        <el-row>
          <el-col :span="6">
            <img :src="item.avatar"
                 class="author-image" />
          </el-col>
          <el-col :span="16">
            <el-row>
              <p style="padding: 5px">{{ item.username }}</p>
              <el-button color=""
                         disabled
                         size="small">Lv.{{ item.rank }}
              </el-button>
            </el-row>
            <el-row>
              <span style="padding: 5px">签名： {{item.introduction}} </span>
            </el-row>
          </el-col>
        </el-row>
      </el-card>
    </el-row>

  </div>
</template>
<script>
export default {
  name: 'AuthorsList',
  data() {
    return {
      topAuthor: [
        {
        //   role_id: 1,
        //   rank: '100',
        //   id: 47,
        //   avatar:
        //     'https://tse1-mm.cn.bing.net/th/id/OIP-C.ocsTpQAkdFx6xxYEe2Fn6wAAAA?w=196&h=196&c=7&r=0&o=5&dpr=2&pid=1.7',
        //   topic_count: 2,
        //   introduction: '我是天才',
        //   username: 'zyz',
        },
      ],
    }
  },
  methods: {
    getTopAuthorList() {
      let params = new URLSearchParams()
      let url = '/api/forum/getTopAuthorList'
      this.$http.get(url).then(
        //成功
        (res) => {
          console.log(res)
          console.log('success')
          this.topAuthor = res.data.data
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
    this.getTopAuthorList()
  },
}
</script>

<style scoped>
.time {
  font-size: 12px;
  color: #999;
}

.bottom {
  margin-top: 13px;
  line-height: 12px;
  display: flex;
  justify-content: space-between;
  align-items: center;
}

.button {
  padding: 0;
  min-height: auto;
}

.image {
  width: 100%;
  display: block;
}
.author-card {
  height: 100px;
  width: 100%;
}
.author-card span {
  font-size: 10px;
  color: #999;
  margin: 0;
}

.author-image {
  width: 50px;
  height: 50px;
}

.author-list :deep(.el-card) {
}
</style>