<template>
  <div class="homepage">
    <div class=blockPage>
      <transition name="animate__animated animate__bounce animate__slow"
                  appear>
        <div class="title">
          <h2>剪纸的技巧</h2>
        </div>
      </transition>
      <div class="block">
        <div class="top">
          <transition name="animate__animated animate__bounce animate__slow"
                      appear
                      enter-active-class="animate__fadeInTopLeft">
            <router-link to='/tech/intaglio'>
              <div class="topImg">
                <p>阴刻</p>
              </div>
            </router-link>
          </transition>
          <div class="l-border"></div>

          <transition name="animate__animated animate__bounce animate__slow"
                      appear
                      enter-active-class="animate__fadeInTopRight">
            <router-link to='/tech/stereoscopic'>
              <div class="rightImg">
                <p>立体剪纸</p>
              </div>
            </router-link>
          </transition>
        </div>
        <div class="c-border"></div>
        <div class="bottom">
          <transition name="animate__animated animate__bounce animate__slow"
                      appear
                      enter-active-class="animate__fadeInBottomLeft">
            <router-link to="/tech/colours">
              <div class="leftImg">
                <p>彩色剪纸</p>
              </div>
            </router-link>
          </transition>

          <div class="l-border"></div>

          <transition name="animate__animated animate__bounce animate__slow"
                      appear
                      enter-active-class="animate__fadeInBottomRight">
            <router-link to="/tech/garland">
              <div class="bottomImg">
                <p>阳刻</p>
              </div>
            </router-link>
          </transition>
        </div>

      </div>
      <div class="end-line">
      </div>
    </div>

  </div>

</template>

<script>
export default {
  name: 'blockPage',
  data() {
    return {}
  },
  methods: {},
}
</script>

<style scoped>
.blockPage {
  width: 100%;
  height: 100%;
  display: flex;
  flex-direction: column;
  align-items: center;
  position: fixed;
}
.title {
  font-size: 50px;
  font-weight: bold;
  background: url('/image/course/title0.png');
  height: 24%;
  width: 40%;
  background-size: 100% 100%;
  display: flex;
  justify-content: center;
  align-items: center;
  align-self: center;
  opacity: 0.95;
  margin-top: 1%;
}
.block {
  margin-top: 5%;
  display: flex;
  flex-direction: column;
  align-items: center;
  transform: rotate(45deg);
  width: min-content;
}
.title h2 {
  font-size: 50px;
  font-weight: 700;
  color: #8e3e1d;
}
.top {
  display: flex;
  flex-direction: row;
}

.bottom {
  display: flex;
  flex-direction: row;
}
.leftImg {
  width: 150px;
  height: 150px;
  background-color: rgb(198, 173, 114);
  border-radius: 10px;
}

.leftImg :hover {
  transform: scale(0.75) rotate(360deg);
  border-radius: 25px;
  box-shadow: 0 12px 16px 0 rgb(0 0 0 / 24%), 0 17px 50px 0 rgb(0 0 0 / 19%);
  transition: all 0.3s;
  cursor: pointer;
}

.rightImg {
  width: 150px;
  height: 150px;
  background-color: rgb(198, 173, 114);
  border-radius: 10px;
}
.rightImg :hover {
  transform: scale(0.75) rotate(-360deg);
  border-radius: 25px;
  box-shadow: 0 12px 16px 0 rgb(0 0 0 / 24%), 0 17px 50px 0 rgb(0 0 0 / 19%);
  transition: all 0.3s;
  cursor: pointer;
}
.topImg {
  width: 150px;
  height: 150px;
  background-color: rgb(200, 79, 71);
  box-shadow: 0 0 50px 0 rgba(0, 0, 0, 0.5);
  border-radius: 10px;
}
.topImg :hover {
  transform: scale(0.75) rotate(-360deg);
  border-radius: 25px;
  box-shadow: 0 12px 16px 0 rgb(0 0 0 / 24%), 0 17px 50px 0 rgb(0 0 0 / 19%);
  transition: all 0.3s;
  cursor: pointer;
}

.bottomImg {
  width: 150px;
  height: 150px;
  background-color: rgb(200, 79, 71);
  border-radius: 10px;
}
.bottomImg :hover {
  transform: scale(0.75) rotate(360deg);
  border-radius: 25px;
  box-shadow: 0 12px 16px 0 rgb(0 0 0 / 24%), 0 17px 50px 0 rgb(0 0 0 / 19%);
  transition: all 0.3s;
  cursor: pointer;
}
.block p {
  color: white;
  font-size: 30px;
  font-family: sans-serif;
  text-align: center;
  line-height: 150px;
  rotate: -45deg;
}
.c-border {
  width: 300px;
  height: 3px;
  margin-top: -1.5px;
  margin-bottom: -1.5px;
  background-image: repeating-linear-gradient(
    90deg,
    white,
    white 10px,
    transparent 10px,
    transparent 20px
  );
  z-index: 1000;
}
.l-border {
  width: 3px;
  height: 150px;
  margin-left: -1.5px;
  margin-right: -1.5px;
  background-image: repeating-linear-gradient(
    white,
    white 10px,
    transparent 10px,
    transparent 20px
  );
  z-index: 1000;
}

.end-line {
  margin-top: 62px;
  display: flex;
  width: 100%;
  height: 5px;
  background: rgb(200, 176, 119);
}
</style>