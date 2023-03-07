<template>

  <SearchComponent @gettext="searchtext" />
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
                               size="small">Lv.{{ item.u_rank }}
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
              <!--删除帖子-->
              <div class="box2"
                   v-if="this.$global.roleId === '3'">
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

          <el-button round
                     text
                     @click="likeTopic(item.id, index)"
                     class="thumbupbutton">

            <div v-show="!this.isthumbups[index]">
              <img class="small-icon"
                   src="../../assets/icons/before-thumbup.png" />

            </div>
            <div v-show="this.isthumbups[index]"><img class="small-icon"
                   src="../../assets/icons/dianzan_kuai.png" />
            </div>
            {{
                this.thumbupsCounts[index]
            }}

          </el-button>
          <router-link :to="'/forum/articlePage/' + this.result[index].id">
            <el-button round
                       text
                       class="commentcount">
              <el-icon>
                <Comment />
              </el-icon>{{ item.commentCount }}
            </el-button>
          </router-link>

        </el-row>

      </el-card>
    </div>
  </el-row>
  <div style="text-align: -webkit-center">
    <div class="example-pagination-block"
         style="width: max-content">
      <el-pagination layout="prev, pager, next"
                     :total="result.length"
                     :page-size="10"
                     @current-change="getPageNum" />
    </div>
  </div>

</template>

<script>
import SearchComponent from './SearchComponent.vue'
export default {
  name: 'ArticleList',
  data() {
    return {
      result: [
        {
          //   u_rank: '0',
          //   create_time: '2022-03-10T11:19:28.000+0000',
          //   isThumbs: false,
          //   avatar: 'http://117.50.179.215:8056/123.jpg',
          //   title: '无敌啊',
          //   content: '美',
          //   commentCount: 0,
          //   thumbsCount: 0,
          //   u_id: 15,
          //   role_id: 15,
          //   id: 10,
          //   topicTotal: 25,
          //   introduction: '81W',
          //   email: 'h99@L.com',
          //   status: '0',
          //   username: 'bDD',
        },
      ],
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
          //   console.log(topicid)

          this.$http.delete(url, { params: params }).then(
            (res) => {
              if (res.data.status === 200) {
                console.log(res.data.message)
                ElMessage({
                  message: res.data.message,
                  type: 'success',
                })
                this.getTopicList()
              } else if (res.data.status === 204) {
                console.log(res.data.message)
                ElMessage({
                  message: res.data.message,
                  type: 'warning',
                })
              }
            },
            (err) => {
              console.log('error')
              console.log(err)
            }
          )
        })
        .catch(() => {
          ElMessage({
            type: 'info',
            message: '已取消删除',
          })
        })
    },
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
    getTopicList() {
      let params = new URLSearchParams()
      let url = '/api/forum/getTopicList'
      params.append('currentPage', this.topiclist.currentPage)
      params.append('pageSize', this.topiclist.pageSize)
      params.append('userId', this.$global.userId) //
      this.$http.get(url, { params: params }).then(
        //成功
        (res) => {
          // console.log(res);
          // console.log("success");
          this.result = res.data.data
          this.topiclist.topicTotal = this.result[0].topicTotal
          console.log(this.topiclist.topicTotal)
          console.log(this.topiclist.topicTotal)
          console.log(this.topiclist.topicTotal)
          console.log(this.topiclist.topicTotal)
          this.$emit('transferTopicTotal', this.topiclist.topicTotal)
          this.isthumbups.splice(0, this.isthumbups.length)
          this.thumbupsCounts.splice(0, this.thumbupsCounts.length)

          for (var i = 0; i < this.result.length; i++) {
            this.isthumbups.push(this.result[i].isThumbs)
            this.thumbupsCounts.push(this.result[i].thumbsCount)
          }

          // console.log(this.isthumbups)
          // console.log(this.thumbupsCounts)
        },
        //失败
        (err) => {
          console.log('error')
          console.log(err)
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

    searchtopic() {
      let params = new URLSearchParams()
      let url = '/api/forum/searchTopicByKeyword'
      let keyword = this.searchcontent
      params.append('keyword', keyword)
      params.append('userId', this.$global.userId)

      this.$http.get(url, { params: params }).then(
        //成功
        (res) => {
          console.log(res)
          console.log('success')
          console.log(res.data.data)
          this.result = res.data.data
          this.$emit('searchsuccessfully')
          ElMessage({
            message: '搜索成功',
            type: 'success',
          })
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
    this.getTopicList()
  },
  components: {
    SearchComponent,
  },
}
</script>

<style scoped>
.small-icon {
  width: 15px;
}

.thumbupbutton {
  width: auto;
}

.article-card-username {
  display: flex;
  justify-content: space-around;
}

.box2 {
  display: flex;
  flex-direction: row-reverse;
}

/* .delete-button{
  background-color: #d0574e;
  color: black;
  padding: 15px 32px;
  text-align: center;
  text-decoration: none;
  display: inline-block;
  font-size: 13px;
  border: None;
  width: 120px;
  height: 50px;
} */
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
  /* text-overflow: ellipsis;
	display: -webkit-box;
	-webkit-line-clamp: 3;
	-webkit-box-orient: vertical; */
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
  /* color: red; */
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