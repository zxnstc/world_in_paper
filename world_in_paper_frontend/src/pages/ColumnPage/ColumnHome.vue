<template>
  <div class="column-home">
    <div class="left-main">
      <transition class="animate__animated animate__bounce"
                  appear>
        <title-card class="title-card animate__fadeInDown"
                    :imageUrl="column.cover_img"
                    :title="column.title"
                    :subtitle="column.content"
                    :subscribe="column.is_favor"
                    @getColumnInfo="getColumnInfo"></title-card>
      </transition>
      <column-article-list class="article-list"
                           :columnId="column.id"
                           ref="articleList"
                           v-if="column.column_art_count"></column-article-list>
      <el-empty class="article-list"
                v-else
                description="暂无文章"></el-empty>

    </div>
    <transition class="animate__animated animate__bounce"
                appear>
      <div class="right-side-bar animate__fadeInRight">
        <statistics-card :focus-num="column.column_favor_count"
                         :article-num="column.column_art_count"></statistics-card>
        <article-label :labels="columnLabel"></article-label>
        <!-- <relative-column></relative-column> -->

      </div>
    </transition>
    <transition class="animate__animated animate__bounce"
                appear>
      <div @click="handleAddArticle"
           class="add-article"
           v-if="this.$global.isLogined">
        <span>发布文章</span>
      </div>
    </transition>
  </div>
</template>

<script>
import TitleCard from '../../components/ColumnPage/TitleCard.vue'
import ColumnArticleList from '../../components/ColumnPage/ColumnArticleList.vue'
import StatisticsCard from '../../components/ColumnPage/StatisticsCard.vue'
import ArticleLabel from '../../components/ColumnPage/ArticleLabel.vue'
export default {
  name: 'ColumnHome',
  components: { TitleCard, ColumnArticleList, StatisticsCard, ArticleLabel },
  data() {
    return {
      column: {
        // title: '南方剪纸',
        // subtitle:
        //   '南方的剪纸用于生活、祭祀和劳动生产中，具有更加浓郁的生活气息和原生态文化特点。其中著名的有：以文人风格著称的江苏扬州剪纸；以浙江乐清为代表的细纹刻纸和浦江戏曲剪纸；富丽鲜艳的广东佛山剪纸；既规整又灵动的泉州装饰性剪纸；以及地域风格浓郁的湖北民间雕花剪纸。',
        // imageUrl: '/image/ColumnPage/t.png',
      },
      articleList: [],
      columnLabel: [],
    }
  },
  methods: {
    getColumnInfo() {
      let url = 'api/column/getColumn'
      let params = new URLSearchParams()
      params.append('columnId', this.$route.params.id)
      params.append('userId', this.$global.userId)
      this.$http.get(url, { params }).then((res) => {
        console.log(res.data.data)
        this.column = res.data.data
      })
    },
    getColumnLabel() {
      let url = 'api/column/getColumnLabels'
      let params = new URLSearchParams()
      params.append('columnId', this.$route.params.id)
      this.$http.get(url, { params: params }).then((res) => {
        for (let i = 0; i < res.data.data.length; i++) {
          this.columnLabel.push(res.data.data[i])
        }
      })
    },
    handleAddArticle() {
      this.$router.push({
        path: '/column/' + 'editArticle/' + this.$route.params.id,
      })
    },
  },
  mounted() {
    this.getColumnInfo()
    this.getColumnLabel()
    this.$nextTick(() => {
      this.$refs.articleList.getArticleList()
    })
  },
}
</script>

<style scoped>
.column-home {
  display: flex;
  flex-direction: row;
  justify-content: space-between;
  width: 1200px;
  margin: 0 auto;
}

.left-main {
  width: 70%;
  margin-left: 15px;
}

.right-side-bar {
  width: 30%;
  margin: 0 auto;
}

.article-list {
  margin: 10px 0;
  min-height: 500px;
}

.add-article {
  position: absolute;
  right: 30px;
  bottom: 30px;
  width: 100px;
  height: 50px;
  line-height: 50px;
  border-radius: 10px;
  text-align: center;
  background-color: #ac2d23;
  color: #fff;
  font-size: 20px;
  cursor: pointer;
  /* 不随页面滚动 */
  position: fixed;
}

.add-article:hover {
  background-color: #fdfdfd;
  color: #ac2d23;
    border: 1px solid #ac2d23;
}

.no-article {
  background-color: #fefbf4;
  height: 400px;
}
</style>