<template>
 <el-container class="homepage">
    <el-main>
        <article-list></article-list>

    </el-main>
 </el-container>


</template>

<script>
import ArticleList from '../../components/ForumPage/ArticleList.vue';
export default {
    components: {
        ArticleList
    },

}

</script>

<style scoped>
:deep(.el-main) {
  padding: 50px 300px;
}

</style>