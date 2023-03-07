<template>
  <div class="searchBox">
    <div class="searchinput">
      <el-input v-model="this.inputcontent" placeholder="Please input" />
    </div>

    <el-button  @click="this.get_content()" size="large"  round>
      <el-icon>
        <Search />
      </el-icon>
      Search</el-button>

    
  </div>
  
</template>

<script>

export default {
  name: 'SearchComponent',
  data() {
    return {
      inputcontent: '',
    }
  },
  methods: {
    get_content() {
      console.log(this.inputcontent)
      this.$emit('gettext', this.inputcontent)
    },
  },

  mounted() { },
}
</script>

<style scoped>
* {
  margin: 0;
  padding: 0;
  box-sizing: border-box;
  font-family: consolas;
}

.searchBox {
  margin: auto;
  width: 98%;
  height: 50px;
  background-color: #ffffff;
  display: flex;
  justify-content:space-around;
  align-items: center;
}

.searchinput {
  width: 80%;
  height: 40px;
  background-color: #fdfbf5;
  border-radius: 20px;
  display: flex;
  justify-content: center;
  align-items: center;
}

.icon {
  width: 35px;
  background-color: #fdfbf5;
  columns: #fff;
  cursor: pointer;
}
</style>