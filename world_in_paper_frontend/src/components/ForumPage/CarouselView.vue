<template>

  <div>
    <el-carousel :interval="4000"
                 type="card"
                 height="300px">
      <el-carousel-item>
        <img class="car-image"
             src="../../assets/images/examples/ChineseCut001.jpg" />

      </el-carousel-item>
      <el-carousel-item>
        <img class="car-image"
             src="../../assets/images/examples/ChineseCut002.jpg" />

      </el-carousel-item>
      <el-carousel-item>
        <img class="car-image"
             src="../../assets/images/examples/ChineseCut003.jpg" />

      </el-carousel-item>
      <el-carousel-item>
        <img class="car-image"
             src="../../assets/images/examples/ChineseCut004.jpg" />

      </el-carousel-item>
    </el-carousel>
  </div>
</template>
<script>
export default {
  name: 'CarouselView',
  data() {
    return {}
  },
}
</script>

<style scoped>
.car-image {
  width: 100%;
  height: 100%;
}
</style>