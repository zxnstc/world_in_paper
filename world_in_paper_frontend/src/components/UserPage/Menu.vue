<template>
  <el-row class="tac">
    <el-col :span="24">
      <el-menu active-text-color="#ffd04b"
               background-color="#282828"
               class="el-menu-vertical-demo"
               default-active="1"
               text-color="#fff"
               @select="handleSelect">
        <el-menu-item index="1">
          <span>我的主页</span>
        </el-menu-item>
        <el-menu-item index="2">
          <span>修改个人信息</span>
        </el-menu-item>
        <el-menu-item index="3"
                      :disabled="this.$global.roleId !=='3'">

          <span>用户权限管理</span>
        </el-menu-item>
        <el-menu-item index="4"
                      :disabled="this.$global.roleId !=='2'">

          <span>专栏管理</span>
        </el-menu-item>
        <el-menu-item index="5"
                      :disabled="this.$global.roleId !=='2'">

          <span>剪纸作品管理</span>
        </el-menu-item>
      </el-menu>
    </el-col>
  </el-row>

</template>

<script>
export default {
  name: 'Menu',
  data() {
    return {
      disabled: true,
    }
  },
  methods: {
    handleSelect(key, keyPath) {
      this.$emit('changeIndex', key)
    },
  },
}
</script>

<style scoped>
:deep(.el-col-12) {
  max-width: 100%;
}
:deep(.el-menu-item) {
  height: 20%;
}
.el-row {
  height: 100%;
  width: 200px;
  display: flex;
}
:deep(.el-menu-vertical-demo) {
  height: 100%;
}
</style>