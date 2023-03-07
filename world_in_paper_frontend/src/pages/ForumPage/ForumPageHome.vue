<template>
  <div class="common-layout">
    <el-container class="homepage">
      <el-aside>
        <ProjectIntroduction :articletotal="this.topictotal" />
        <el-row>
          <el-col :span="40"
                  style="height: 10px" />
        </el-row>
        <AuthorsList />
      </el-aside>
      <el-main>
        <CarouselView />
        <el-row>
          <el-col :span="40"
                  style="height: 10px" />
        </el-row>
        <!-- <SearchTopic/> -->

        <ArticleList ref="articleList"
                     @transfer-topic-total="getTopicTotal" />

        <div class="go-top">
          <el-button type="danger"
                     plain
                     round
                     size="large"
                     @click="createTopic">发布<br />帖子</el-button>
        </div>
      </el-main>
    </el-container>
    <add-topic @updateList="updateList"
               ref="addTopic"></add-topic>
  </div>
</template>

<script>
import ProjectIntroduction from '../../components/ForumPage/ProjectIntroduction.vue'
import AuthorsList from '../../components/ForumPage/AuthorsList.vue'
import CarouselView from '../../components/ForumPage/CarouselView.vue'
import ArticleList from '../../components/ForumPage/ArticleList.vue'
import AddTopic from '../../components/ForumPage/AddTopic.vue'
export default {
  name: 'ForumPageHome',
  components: {
    ProjectIntroduction,
    AuthorsList,
    CarouselView,
    ArticleList,
    AddTopic,
  },
  data() {
    return {
      topictotal: 1,
    }
  },
  methods: {
    getTopicTotal(data) {
      this.topictotal = data
    },
    createTopic() {
      this.$nextTick(() => {
        this.$refs.addTopic.init()
      })
    },
    updateList() {
      this.$refs.articleList.getTopicList()
    },
  },
  mounted() {
    console.log(this.topictotal)
  },
}
</script>

<style scoped>
:deep(.el-aside) {
  width: 350px;
  padding-left: 30px;
}

:deep(.el-aside::-webkit-scrollbar) {
  display: none;
}

:deep(.el-main) {
  padding-right: 50px;
}
.go-top1 {
  position: fixed; /* 设置fixed固定定位 */
  bottom: 80px; /* 距离浏览器窗口下边框20px */
  right: 20px; /* 距离浏览器窗口右边框20px */
}
.go-top {
  position: fixed; /* 设置fixed固定定位 */
  bottom: 30px; /* 距离浏览器窗口下边框20px */
  right: 30px; /* 距离浏览器窗口右边框20px */
}
.add-article {
  color: black;
}
.submitbotton {
  color: black;
}
</style>
