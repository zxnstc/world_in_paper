<template>
  <div class="homepage">
    <div class="tutorial">
      <transition name="animate__animated animate__bounce animate__slow"
                  appear>
        <div class="title">剪纸的教程</div>
      </transition>
      <div class="body_content">
        <div class="image">
          <transition name="animate__animated animate__bounce animate__slow"
                      appear
                      enter-active-class="animate__fadeInLeft">
            <router-link to="/course/folding">
              <div class="left">
                <p> 折法</p>
                <img class="l-img"
                     src="/image/tutorialview/yellow.png" />
              </div>
            </router-link>
          </transition>

          <div class="border-line"></div>
          <transition name="animate__animated animate__bounce animate__slow"
                      appear
                      enter-active-class="animate__fadeInRight">
            <router-link to="/course/patterns">
              <div class="right">
                <p>纹样</p>
                <img class="r-img"
                     src="/image/tutorialview/red.png" />
              </div>
            </router-link>
          </transition>

        </div>
        <div class="end-line"></div>
      </div>
    </div>

  </div>

</template>

<script>
export default {
  name: 'tutorialHomePage',
  data() {
    return {}
  },
  methods: {},
}
</script>

<style scoped>
.tutorial {
  display: flex;
  width: 100%;
  height: 100%;
  flex-direction: column;
}
.title {
  font-size: 50px;
  font-weight: bold;
  color: #8e3e1d;
  background: url('/image/techview/title.png');
  width: 500px;
  height: 200px;
  background-size: 100% 100%;
  display: flex;
  justify-content: center;
  align-items: center;
  align-self: center;
  margin-top: 5%;
}
.body_content {
  width: 100%;
  display: flex;
  flex-direction: column;
  margin-top: 1%;
}
.image {
  display: flex;
  justify-content: center;
  /* margin-top: 9%; */
}
.left {
  width: 200px;
  height: 327.64px;
  z-index: 1001;
}
.left p {
  position: absolute;
  font-family: sans-serif;
  text-align: center;
  line-height: 327.64px;
  font-size: 30px;
  font-weight: bold;
  margin-left: 105px;
  color: #ffffff;
  z-index: 1001;
}
.left :hover + .l-img {
  cursor: pointer;
  transform: scale(1.1) translateX(-10px);
  transition: all 0.25s;
}

.right :hover + .r-img {
  cursor: pointer;
  transform: scale(1.1) translateX(10px);
  transition: all 0.25s;
}
.right p {
  position: absolute;
  font-family: sans-serif;
  text-align: center;
  line-height: 327.64px;
  font-size: 30px;
  font-weight: bold;
  margin-left: 35px;
  color: #ffffff;
  z-index: 1001;
}
.right {
  width: 200px;
  height: 327.64px;
}
.border-line {
  width: 3px;
  height: 327.64px;
  margin-left: -1.5px;
  margin-right: -1.5px;
  align-self: center;
  background-image: repeating-linear-gradient(
    white,
    white 10px,
    transparent 10px,
    transparent 20px
  );

  z-index: 999;
}
.end-line {
  width: 100%;
  height: 5px;
  background: rgb(200, 176, 119);
}
</style>