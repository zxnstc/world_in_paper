<template>
  <div class="add-column-page">
    <div class="title-with-button">
      <h2>我的专栏</h2>
      <el-button type="primary"
                 @click="createColumn">创建专栏</el-button>
    </div>
    <div class="content">
      <my-column-list ref="list"></my-column-list>
    </div>
    <add-column ref="addColumn" @add-column="handleAddColumn"></add-column>

  </div>
</template>

<script>
import AddColumn from './AddColumn.vue'
import MyColumnList from './MyColumnList.vue'
export default {
  name: 'AddColumnPage',
  components: { MyColumnList, AddColumn },
  data() {
    return {}
  },
  methods: {
    createColumn() {
      this.$nextTick(() => {
        this.$refs.addColumn.init()
      })
    },
    handleAddColumn() {
      this.$refs.list.getColumns()
    },
  },
}
</script>

<style scoped>
.title-with-button {
  margin-top: 20px;
  margin-left: 20px;
  margin-right: 20px;
  /* font-size: 30px; */
  font-weight: bold;
  display: flex;
  justify-content: space-between;
  align-items: center;
}

.content {
  margin-top: 20px;
  margin-left: 20px;
  margin-right: 20px;
  padding: 30px;
  height: 100%;
  background-color: white;
}
</style>