<template>

  <h2 class="none"
      ref="none">无</h2>

  <el-row v-for="item, index of result">
    <div class="articlecard">
      <el-card shadow="hover">
        <template #header>

          <el-row>
            <el-col :span="2">
              <img :src=item.avatar
                   class="user-image" />
            </el-col>
            <el-col :span="20">
              <el-row>
                <div class="article-card-username">
                  <div class="username-cha">{{ item.username }}</div>
                  <div class="user-level">
                    <el-button color="#626aef"
                               disabled
                               size="small">Lv.{{ this.$global.rank}}
                    </el-button>

                  </div>
                </div>

              </el-row>
              <el-row>
                <div class="article-title">
                  {{ item.title }}
                </div>

              </el-row>
            </el-col>

            <el-col :span="2">
              <div class="box2">
                <div class="delete-article">
                  <el-button type="danger"
                             @click="deletearticle(item.id)"
                             plain>删除帖子</el-button>
                </div>
              </div>
            </el-col>

          </el-row>

        </template>
        <router-link :to="'/forum/articlePage/' + this.result[index].id">
          <div class="article-list-body">
            {{ item.content }}
          </div>
        </router-link>

        <el-row class="article-tips">

          <botton @click="likeTopic(item.id, index)">

            <div v-show="!this.isthumbups[index]">
              <img class="small-icon"
                   src="../../assets/icons/before-thumbup.png" />{{
                      this.thumbupsCounts[index]
                  }}
            </div>
            <div v-show="this.isthumbups[index]"><img class="small-icon"
                   src="../../assets/icons/dianzan_kuai.png" />{{
                  this.thumbupsCounts[index]
              }}</div>

          </botton>
          <botton class="commentcount">
            <el-icon>
              <Comment />
            </el-icon>{{ item.commentCount }}
          </botton>

        </el-row>

      </el-card>
    </div>
  </el-row>
</template>
  
  <script>
export default {
  name: 'MyPostList',
  data() {
    return {
      result: [],
      topiclist: {
        currentPage: '1',
        pageSize: '10',
        topicTotal: 20,
      },
      currentarticle: {
        articleId: 2,
        userId: 1,
      },
      isthumbups: [],
      thumbupsCounts: [],
      searchcontent: '',
    }
  },
  provide() {
    // 使用函数的形式，可以访问到 `this`
    return {
      articleId: this.currentarticle.articleId,
      userId: this.currentarticle.userId,
    }
  },
  methods: {
    transforArticleId(index) {
      console.log(this.result[index].id)
    },
    likeTopic(topicid, index) {
      let params = new URLSearchParams()
      let url = '/api/forum/likeTopic'
      params.append('topicId', topicid)
      params.append('userId', this.$global.userId)
      this.$http.post(url, params).then((res) => {
        if (res.data.status === 200) {
          this.isthumbups[index] = true
          this.thumbupsCounts[index] += 1
          console.log(res.data.message)
          ElMessage({
            message: '点赞成功',
            type: 'success',
          })
        } else if (res.data.status === 400) {
          console.log(res.data.message)
          ElMessage({
            message: res.data.message,
            type: 'warning',
          })
        } else if (res.data.status === 4) {
          console.log(res.data.message)
          ElMessage({
            message: res.data.message,
            type: 'warning',
          })
        }
      })
    },
    getPageNum(value) {
      this.topiclist.currentPage = value
      console.log(value)
      this.getTopicList()
    },
    deletearticle(topicid) {
      ElMessageBox.confirm('此操作将永久删除该帖子, 是否继续?', '提示', {
        confirmButtonText: '确定',
        cancelButtonText: '取消',
        type: 'warning',
      })
        .then(() => {
          let params = new URLSearchParams()
          let url = '/api/forum/deleteTopic'
          params.append('topicId', topicid)
          this.$http.delete(url, { params: params }).then((res) => {
            if (res.data.status === 200) {
              console.log(res.data.message)
              ElMessage({
                message: '删除成功',
                type: 'success',
              })
              this.getTopicList()
            } else if (res.data.status === 204) {
              console.log(res.data.message)
              ElMessage({
                message: res.data.message,
                type: 'warning',
              })
            } else if (res.data.status === 401) {
              console.log(res.data.message)
              ElMessage({
                message: res.data.message,
                type: 'warning',
              })
            }
          })
        })
        .catch(() => {
          ElMessage({
            type: 'info',
            message: '已取消删除',
          })
        })
    },
    getTopicList() {
      let params = new URLSearchParams()
      let url = '/api/forum/searchTopicByUserId'
      params.append('keyUserId', this.$global.userId)
      params.append('userId', this.$global.userId)
      this.$http.get(url, { params: params }).then(
        //成功
        (res) => {
          this.result = res.data.data
          //   this.topiclist.topicTotal = this.result[0].topicTotal
          this.isthumbups.splice(0, this.isthumbups.length)
          this.thumbupsCounts.splice(0, this.thumbupsCounts.length)
          for (var i = 0; i < this.result.length; i++) {
            this.result[i].avatar = this.$global.userAvater
            this.isthumbups.push(this.result[i].isThumbs)
            this.thumbupsCounts.push(this.result[i].thumbsCount)
          }
          if (this.result.length === 0) {
            this.$refs.none.style.display = 'block'
          }
        },
        //失败
        (err) => {
          console.log('error')
          console.log(err)
          if (this.result.length === 0) {
            this.$refs.none.style.display = 'block'
          }
        }
      )
    },

    updateData() {
      this.$refs.getTopicList()
    },

    searchtext(data) {
      this.searchcontent = data
      this.searchtopic()
    },
  },
  mounted() {
    this.getTopicList()
  },
}
</script>
  
<style scoped>
.none {
  height: 400px;
  margin-left: 20px;
  display: none;
}
.small-icon {
  width: 15px;
}

.article-card-username {
  display: flex;
  justify-content: space-around;
}

.box2 {
  display: flex;
  flex-direction: row-reverse;
}
.delete-article {
  padding: 14px;
  right: 100px;
}

.user-image {
  width: 50px;
  padding: 8px;
  height: 50px;
}

#header {
  height: 100%;
}

.username-cha {
  font-size: 15px;
  padding: 8px;
  color: #333;
}

.user-level {
  padding: 3px;
}

.article-list-body {
  height: 90px;
  color: black;
  text-align: left;
  overflow: hidden;
}

.article-title {
  font-size: 18px;
  padding: 0px;
  padding-left: 5px;
}

.article-tips {
  padding-top: 2px;
}

.articlecard {
  margin: 10px;
}

.commentcount {
  padding-left: 10px;
}

.articlecard :deep(.el-card__header) {
  background-color: #fefbf4;
  height: 65px;
  padding: 0;
  padding-left: 10px;
}

.el-card__body {
  background-color: #fdf9f2;
}

.articlecard {
  width: 100%;
}

.article_image {
  width: 100%;
  display: block;
}

.article_intro {
  font-size: xx-small;
}
</style>