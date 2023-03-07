<template>
  <div class="acticle-label">
    <h2>文章标签</h2>
    <div class="label-list">
      <div class="label-item"
           v-for="label in labels"
           :key="label.id">
        <el-tag type="primary">{{ label.label_name }}</el-tag>
      </div>
    </div>
  </div>
</template>

<script>
export default {
  name: 'ArticleLable',
  props: {
    labels: {
      type: Array,
      default: () => [],
    },
  },
  data() {
    return {
        
    }
  }
}
</script>

<style scoped>
.acticle-label {
  display: flex;
  flex-direction: column;
  justify-content: space-around;
  padding: 20px;
  background-color: #fefbf4;
  border: #dddddd 1px solid;
  border-radius: 4px;
  box-shadow: 0 4px 8px 0 rgba(0, 0, 0, 0.05);
  font-family: 'sans-serif';
  width: 400px;
  margin: 15px;
}

.label-list {
  display: flex;
  flex-wrap: wrap;
}

.acticle-label:deep(.el-tag) {
  background-color: #fdd9d6;
  color: #c0453d;
  font-size: 14px;
  font-weight: bold;
  margin: 5px;
  height: 35px;
  border-radius: 30px;
}
</style>
