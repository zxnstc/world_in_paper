<template>
  <body >
    <div  >
      <el-container class="homepage">
        <el-main>
          <ArtistContent :article="article" />
          <ArticleComment  /> 
        </el-main>

        <el-aside>
          <AuthorContent :article-author="article" />
          <!-- <ArticleDirectory/> -->
          <AuthorsList/>
          
        </el-aside>
      </el-container>
    </div>
  </body>
</template>
<script>
import ArticleComment from "../../components/ForumPage/ArticleComment.vue";
import ArtistContent from "../../components/ForumPage/ArticleContent.vue";
import AuthorsList from "../../components/ForumPage/AuthorsList.vue";
import AuthorContent from "../../components/ForumPage/AuthorContent.vue";
import ArticleDirectory from "../../components/ForumPage/ArticleDirectory.vue";

export default {
  provide(){
    return {
      topicId:this.$route.params.id
      
    }
  },
  components: {
    ArticleComment,
    ArtistContent,
    AuthorsList,
    AuthorContent,
    ArticleDirectory,
},
data(){
  return{
      article:{
        isok:false
      }
  }
},
methods:{
  getTopicDetail() {
      let params = new URLSearchParams()
      let url = '/api/forum/getTopicDetail'
      params.append('topicId', this.$route.params.id)
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

      console.log(this.article)
    },
},
mounted(){
  this.getTopicDetail()

}
};
</script>
<style scoped>
:deep(.el-aside) {
  width: 400px;
  padding-right: 50px;
  
  
}
:deep(.el-main) {
  padding-left: 50px;
  
}

.content {
  background-color: aliceblue;
}


</style>