<template>
  <div class="acticle-side-bar">
    <el-button :class="['thumbup-button',thumbed?'thumbed':'']"
               @click="handleThumbup">
      <i :class="['iconfont',thumbed?'icon-dianzan1':'icon-dianzan']"></i>
      <span>{{thumbed?'已':''}}点赞 {{likeNum}}</span>
    </el-button>

    <el-button :class="['other-button',favored?'favored':'']"
               @click="handleFavor">
      <i :class="['iconfont', favored?'icon-shoucang1':'icon-shoucang']"></i>
      <span>{{favored?'已':''}}收藏</span>
    </el-button>
  </div>
</template>

<script>
export default {
  name: 'SideBar',
  data() {
    return {
      likeNum: 0,
      thumbed: false,
      favored: false,
    }
  },
  methods: {
    handleThumbup() {
      if (this.thumbed) {
        this.likeNum--
      } else {
        this.likeNum++
      }
      this.thumbed = !this.thumbed
    },
    handleFavor() {
      this.favored = !this.favored
    },
  },
}
</script>

<style src="../../assets/iconfont/column/iconfont.css" scoped></style>

<style scoped>
.acticle-side-bar {
  display: flex;
  align-items: center;
  justify-content: space-around;
  padding: 0 20px;
  background-color: #fff;
  border-radius: 4px;
  /* box-shadow: 0 4px 8px 0 rgba(0, 0, 0, 0.05); */
  font-family: 'sans-serif';
  margin: 15px;
  flex-direction: column;
  height: 200px;
}
.el-button + .el-button {
  margin-left: 0px;
}
.acticle-side-bar :deep(.el-button) {
  border: 0;
  font-size: 15px;
}

.acticle-side-bar:deep(.el-button>span) {
  display: flex;
  flex-direction: column;
  justify-content: space-between;
  flex: 1 1 auto;
}

.thumbup-button {
  display: flex;
  justify-content: center;
  align-items: center;
  height: 90px;
  width: 90px;
  border-radius: 4px;
  border: 0;
  background-color: #fdd9d6;
  color: #ac2d23;
  font-size: 14px;
  cursor: pointer;
  border-radius: 50%;
}

.thumbup-button.thumbed {
  background-color: #ac2d23;
  color: #fff;
}
.other-button {
  display: flex;
  justify-content: center;
  align-items: center;
  height: 40px;
  width: 90px;
  border-radius: 4px;
  border: 0;
  background-color: transparent;
  color: #999;
  font-size: 14px;
  cursor: pointer;
}

.other-button:hover {
  color: #ac2d23;
}

.other-button.favored {
  color: #ac2d23;
}

:deep(.iconfont) {
  margin-right: 5px;
}
</style>