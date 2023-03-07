<template>
  <div class="statistics-card">
    <div class="statistics-bar">
      <p class="statistics-title">关注者</p>
      <p class="statistics-data">{{focusNum}}</p>
    </div>
    <div class="statistics-bar">
      <p class="statistics-title">文章数</p>
      <p class="statistics-data">{{articleNum}}</p>
    </div>
  </div>
</template>

<script>
export default {
  name: 'StatisticsCard',
  props: {
    focusNum: {
      type: Number,
      default: 0,
    },
    articleNum: {
      type: Number,
      default: 0,
    },
  },
}
</script>

<style scoped>
.statistics-card {
  display: flex;
  justify-content: space-around;
  padding: 20px;
  background-color: #fefbf4;
  border: #dddddd 1px solid;
  border-radius: 4px;
  box-shadow: 0 4px 8px 0 rgba(0, 0, 0, 0.05);
  font-family: 'sans-serif';
  width: 400px;
  margin-left: 15px;
  margin-bottom: 20px;
}

.statistics-bar {
  display: flex;
  flex-direction: column;
  align-items: center;
  flex: 1 1 auto;
}

.statistics-bar:hover {
  color: #ac2d23;
}

.statistics-bar:first-child {
  border-right: #dddddd 1px solid;
}

.statistics-bar > .statistics-title {
  margin-bottom: 5px;
}

.statistics-bar > .statistics-data {
  font-size: 20px;
  font-weight: bold;
}
</style>