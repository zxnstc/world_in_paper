<template>
  <div class="relative-column">
    <h2>相关专栏</h2>
    <div class="column-list">
      <div class="column-item"
           v-for="column in columns"
           :key="column.id">
        <router-link :to="column.url">
          <p>{{ column.title }}</p>
        </router-link>
      </div>
    </div>
  </div>
</template>

<script>
export default {
  name: 'RelativeColumn',
  data() {
    return {
      columns: [
        {
          id: 1,
          title: '南方剪纸',
          url: '/column/1',
        },
        {
          id: 1,
          title: '北方剪纸',
          url: '/column/1',
        },
      ],
    }
  },
}
</script>

<style scoped>
.relative-column {
  padding: 20px;
  background-color: #fff;
  border-radius: 4px;
  border: #dddddd 1px solid;
  box-shadow: 0 4px 8px 0 rgba(0, 0, 0, 0.05);
  font-family: 'sans-serif';
  margin: 15px;
  width: 400px;
}

.column-item p {
  color: #c6453d;
}

.column-item p:hover {
  color: #c6453d;
}

.column-item {
  margin-bottom: 5px;
}
</style>