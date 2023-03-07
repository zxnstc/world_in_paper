<template>
  <div>
    <transition-group name="animate__animated animate__bounce animate__delay-1s animate__slow"
                      appear
                      enter-active-class="animate__fadeInLeft">
      <div class="person"
           key="0">
        <img src="/image/homeview/pattern/person.png"
             width="520">
      </div>
      <div class="personshadow"
           key="1">
        <img src="/image/homeview/pattern/person_shadow.png"
             width="800">
      </div>
    </transition-group>
    <transition-group name="animate__animated animate__bounce animate__delay-1s animate__slow"
                      appear
                      enter-active-class="animate__fadeInRight">
      <div class="flower"
           key="2">
        <img src="/image/homeview/pattern/flower.png"
             width="400">

      </div>
      <div class="flowershadow"
           key="3">
        <img src="/image/homeview/pattern/flower_shadow.png"
             width="600">

      </div>
    </transition-group>
    <div class="round01">
      <img src="/image/homeview/icon/round1.png"
           width="35">
    </div>
    <div class="round02">
      <img src="/image/homeview/icon/round2.png"
           width="35">
    </div>
    <div class="round03">
      <img src="/image/homeview/icon/round3.png"
           width="35">
    </div>

    <transition name="animate__animated animate__bounce animate__slow"
                appear
                enter-active-class="animate__fadeIn">
      <div class="character">
        <div class="ch1">纸间万象</div>
        <div class="ch2">——中华剪纸文化艺术展览馆</div>
      </div>
    </transition>

  </div>
</template>

<script>
import 'animate.css'
export default {
  name: 'HomeBanner',
  data() {
    return {}
  },
}
</script>
<style scoped>
.person {
  position: absolute;
  z-index: 2;
  left: 0;
  bottom: 0;
}

.personshadow {
  position: absolute;
  z-index: 1;
  left: 2vw;
  bottom: 0vh;
}

.flower {
  position: absolute;
  z-index: 2;
  right: 0vw;
  top: 0vh;
  transform: scale(1);
}

.flowershadow {
  position: absolute;
  z-index: 1;
  right: 2vw;
  top: 0vh;
  transform: scale(1);
}

.round01 {
  position: absolute;
  right: 10vw;
  bottom: 8vh;
}

.round02 {
  position: absolute;
  right: 15vw;
  bottom: 8vh;
}

.round03 {
  position: absolute;
  right: 20vw;
  bottom: 8vh;
}

.character {
  font-family: One;
  color: #8e3e1d;
}

.animate__fadeIn {
  --animate-duration: 2s;
  --animate-delay: 0.5s;
}

.ch1 {
  position: absolute;
  top: 35vh;
  left: 30vw;
  font-size: 70px;
  z-index: 2;
  user-select: none;
}

.ch2 {
  position: absolute;
  top: 45vh;
  left: 35vw;
  font-size: 40px;
  z-index: 2;
  user-select: none;
}
</style>