<template>
  <div class="common-layout">
    <el-container class="homepage">
      <el-aside>
        <ProjectIntro />
        <el-row>
          <el-col :span="40"
                  style="height: 10px;" />
        </el-row>
        <AuthorsList />
      </el-aside>
      <el-main>
        <Carousel />
        <ArticleList />
      </el-main>
    </el-container>
  </div>
</template>

<script >
import ProjectIntro from '../components/ForumPage/ProjectIntroduction.vue'
import AuthorsList from '../components/ForumPage/AuthorsList.vue'
import Carousel from '../components/ForumPage/CarouselView.vue'
import ArticleList from '../components/ForumPage/ArticleList.vue'

export default {
  components: {
    ProjectIntro,
    AuthorsList,
    Carousel,
    ArticleList,
  },
}
</script>
   
<style scoped>
:deep(.el-aside) {
  width: 500px;
}
</style>