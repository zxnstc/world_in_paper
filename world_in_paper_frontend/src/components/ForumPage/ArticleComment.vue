<template>
  <div id="article-comment">

    <create-comment @add-successfully="updateData"/>

    <comment-list ref="commentList"/>
  </div>

</template>
  
  
  
  
<script>
import CreateComment from './CreateComment.vue'
import CommentList from './CommentList.vue'

export default {
  name: 'ArticleComment',
  components: {
    CreateComment,
    CommentList,
  },
  methods:{
    updateData(){
      this.$refs.commentList.getCommentList()
    }
  }
}
</script>
  