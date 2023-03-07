<template>
  <!-- <column-article-list></column-article-list> -->
  <sidebar></sidebar>
</template>

<script>
import Sidebar from '../../components/ColumnPage/Sidebar.vue'
import ColumnArticleList from '../../components/ColumnPage/ColumnArticleList.vue'
export default {
  name: 'ColumnUserPage',
  components: {
    ColumnArticleList,
    Sidebar,
  },
}
</script>

<style>
</style>