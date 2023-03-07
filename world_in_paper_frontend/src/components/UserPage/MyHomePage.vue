<template>
  <div class="myHome">
    <el-scrollbar max-height="2000px">
      <div class="theHead">
        <div class="top-back"></div>
        <div class="avater"
             ref="myAvater"></div>
        <div class="bottom-back">
          <h2>{{this.$global.userName}}</h2>
          <p>{{this.$global.userIntroduction}}</p>
        </div>
      </div>

      <div class="theContent">
        <div class="theMenu">
          <el-col :span=24></el-col>
          <el-menu default-active="1"
                   class="el-menu-demo"
                   mode="horizontal"
                   @select="handleSelect">
            <el-menu-item index="1">帖子</el-menu-item>
            <el-menu-item index="2"
                          :disabled="this.$global.roleId !=='2'">专栏</el-menu-item>
            <el-menu-item index="3">文章</el-menu-item>
          </el-menu>
          <div class="post"
               v-if="this.activeIndex ==='1'">
            <MyPostList></MyPostList>
          </div>
          <div class="column"
               v-if="this.activeIndex ==='2'">
            <MyColumnList></MyColumnList>
          </div>
          <div class="article"
               v-if="this.activeIndex ==='3'">
            <my-article-list></my-article-list>
          </div>

        </div>
      </div>
    </el-scrollbar>
  </div>
</template>

<script>
import MyPostList from './MyPostList.vue'
import MyColumnList from './MyColumnList.vue'
import MyArticleList from './MyArticleList.vue'

export default {
  name: 'MyHomePage',
  components: {
    MyPostList,
    MyColumnList,
    MyArticleList,
  },
  data() {
    return {
      activeIndex: '1',
    }
  },
  methods: {
    handleSelect(key, keyPath) {
      this.activeIndex = key
    },
  },
  mounted() {
    this.$refs.myAvater.style.backgroundImage = `url(${this.$global.userAvater})`
  },
}
</script>

<style scoped>
.myHome {
  width: 80%;
  height: 100%;
  display: flex;
  flex-direction: column;
  margin-left: 10%;
}
:deep(.el-scrollbar) {
  margin-top: 1%;
}
:deep(.el-scrollbar__view) {
  height: 100%;
}
:deep(.el-scrollbar__thumb) {
  /* 透明度 */
  opacity: 1;
  background: rgb(193, 193, 193);
}
.theHead {
  height: 30%;
  width: 99%;
  margin-left: 0.5%;
  position: relative;
  box-shadow: 0 0 5px rgba(0, 0, 0, 0.5);
}
.top-back {
  width: 100%;
  height: 50%;
  display: flex;
  background-color: rgb(153, 153, 153);
}
.bottom-back {
  width: 100%;
  height: 50%;
  display: flex;
  background-color: rgb(255, 255, 255);
  flex-direction: column;
}
.bottom-back p {
  margin-top: 0px;
  margin-left: 20%;
  width: 40%;
  height: 20px;
}
.avater {
  height: 66.6%;
  aspect-ratio: 1/1;
  background-size: 100% 100%;
  border-radius: 5%;
  position: absolute;
  display: flex;
  margin-top: -5%;
  margin-left: 5%;
  box-shadow: 0 0 0 5px #fff;
}
h2 {
  margin-top: 1%;
  margin-left: 20%;
  font-family: 'sans-serif';
}
.theContent {
  width: 99%;
  height: auto;
  /* min-height: 70vh; */
  margin-top: 1.5%;
  margin-left: 0.5%;
  box-shadow: 0 0 5px rgba(0, 0, 0, 0.5);
  background: #fff;
}
:deep(.el-menu-item) {
  width: 15%;
}
</style>