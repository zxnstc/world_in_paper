<template>
  <div class="paperwork">
    <div class="tool-bar">
      <el-switch v-model="rotation"
                 inactive-text="停止"
                 active-text="旋转"
                 active-color="#ac2d23">
      </el-switch>
      <el-button class="help"
                 @click="handleShowHelp">
        帮助
      </el-button>
    </div>
    <el-dialog title="帮助"
               v-model="helpVisible"
               width="30%"
               :close-on-click-modal="false"
               class="help-dialog">
        <ol>
          <li>鼠标左键拖动可以旋转</li>
          <li>鼠标右键拖动可以平移</li>
          <li>鼠标滚轮可以缩放</li>
          <li>点击旋转按钮可以让模型自动旋转</li>
        </ol>
    </el-dialog>
    <div ref="canvas"
         class="canvas">
    </div>
  </div>
</template>

<script>
import * as THREE from 'three'
import { OrbitControls } from 'three/examples/jsm/controls/OrbitControls'
let scene, camera, renderer, controls, circle, base
export default {
  name: 'PaperworkShow',
  data() {
    return {
      w: window.innerWidth * 0.8,
      h: window.innerHeight * 0.8,
      image_url: '',
      background_type: '',
      background: '',
      rotation: false,
      helpVisible: false,
    }
  },
  methods: {
    initCanvas() {
      //创建场景
      scene = new THREE.Scene()
      //创建一个摄像头
      camera = new THREE.PerspectiveCamera(45, this.w / this.h, 0.1, 1000)
      camera.position.set(0, 1, 6)
      camera.lookAt(0, -2, 0)
      //渲染器
      renderer = new THREE.WebGLRenderer()
      renderer.setSize(this.w, this.h)
      renderer.render(scene, camera)
      this.$refs.canvas.appendChild(renderer.domElement)
      // 设置渲染器的背景颜色
      renderer.setClearColor(new THREE.Color(0xe6e6e6))
      //创建控制器
      controls = new OrbitControls(camera, renderer.domElement)
      //创建性能插件
      // stat = new Stats()
      // document.body.appendChild(stat.dom)
    },
    createLight(x, y, z) {
      let light = new THREE.SpotLight(0x909090)
      light.position.set(x, y, z)
      light.angle = Math.PI / 2
      light.intensity = 0.5
      return light
    },
    addLight() {
      let light1 = this.createLight(0.9 * 1.2, 0.84, 1 * 1.2)
      scene.add(light1)
      let light2 = this.createLight(-0.9 * 1.2, 0.84, 1 * 1.2)
      scene.add(light2)
      scene.add(new THREE.AmbientLight(0xdddddd))
    },
    addBase() {
      //加入一个圆柱体底座
      let geometry = new THREE.CylinderGeometry(1.8 * 0.8, 2 * 0.8, 0.1, 32)
      const material = new THREE.MeshStandardMaterial({
        color: 0xffffff,
        side: THREE.DoubleSide,
        roughness: 0.7,
        metalness: 0.5,
      })
      base = new THREE.Mesh(geometry, material)
      base.position.set(0, -1.5, 0)
      base.receiveShadow = true
      scene.add(base)
    },
    addPaperWork() {
      let circleGeometry = new THREE.CircleGeometry(1, 32)
      console.log(this.image_url)
      let image = new Image()
      image.setAttribute('crossOrigin', 'anonymous')
      image.src = this.image_url + '?timestamp= ' + Date.now()
      console.log(image)
      let texture = new THREE.TextureLoader().load(this.image_url)
      let circleMaterial = new THREE.MeshStandardMaterial({
        map: texture,
        side: THREE.DoubleSide,
        transparent: true,
        roughness: 0.7,
        metalness: 0.2,
      })
      circle = new THREE.Mesh(circleGeometry, circleMaterial)
      circle.position.set(0, 0, 0)
      scene.add(circle)
    },
    handleShowHelp() {
      this.helpVisible = true
    },
    tick() {
      circle.rotation.y += 0.005 * (this.rotation?1:0)
      requestAnimationFrame(this.tick)
      renderer.render(scene, camera)
      controls.update()
    },
    start() {
      let url = 'api/paperwork/getPaperworkById'
      let params = new URLSearchParams()
      params.append('id', this.$route.params.id)
      this.$http.get(url, { params: params }).then((res) => {
        if (res.data.status === 200) {
          console.log(res.data.data)
          this.image_url = res.data.data[0].img_url
        }
        // this.image_url = require(this.image_url)
        console.log(this.image_url)
        this.initCanvas()
        this.addLight()
        this.addBase()
        this.addPaperWork()
        this.tick()
      })
    },
  },
  mounted() {
    this.start()
  },
  beforeUnmount() {
    this.rotation = false
  },
}
</script>

<style scoped>
.paperwork {
  width: 100%;
  height: 100%;
  display: flex;
  flex-direction: column;
  justify-content: center;
  align-items: center;
}

.tool-bar {
  width: 100%;
  height: 56px;
  background-color: #1d1c16;
  display: flex;
  justify-content: space-between;
  align-items: center;
  padding: 0 200px;
}

:deep(.el-switch__label) {
  color: #fff;
}

:deep(.el-switch__label.is-active) {
  color: #d54b41;
}

.paperwork {
  min-height: calc(100vh - 56px);
  width: 100%;
  background: url('/image/bg1.jpg') center 0 no-repeat;
  background-size: 100% 110%;
  background-attachment: fixed;
  animation: switch 15s infinite;
  display: flex;
}

@keyframes switch {
  25% {
    background-image: url('/image/bg2.jpg');
  }
  50% {
    background-image: url('/image/bg3.jpg');
  }
  75% {
    background-image: url('/image/bg4.jpg');
  }
  100% {
    background-image: url('/image/bg1.jpg');
  }
}

.canvas {
  width: 100%;
  height: 100%;
  display: flex;
  justify-content: center;
  align-items: center;
}

:deep(.help) {
  color: #ac2d23;
  font-size: 14px;
  font-weight: 500;
  margin-right: 20px;
}

:deep(.help:hover) {
  color: #fff;
  background-color: #ac2d23;
  border: 1px solid #ac2d23;
  cursor: pointer;
}

:deep(.help:focus) {
  color: #fff;
  background-color: #ac2d23;
  border: 1px solid #ac2d23;
}

:deep(.help-dialog ul) {
    font-size: 15px;
    text-decoration: #1d1c16;
}
</style>