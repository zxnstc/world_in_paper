import { createApp } from 'vue'
import './style.css'
import App from './App.vue'
import axios from 'axios'
import { createRouter, createWebHashHistory } from 'vue-router'
import global_ from './config/global'
import router from './router'
import * as ElementPlusIconsVue from '@element-plus/icons-vue'
const app = createApp(App)

for (const [key, component] of Object.entries(ElementPlusIconsVue)) {
	app.component(key, component)
}
app.config.globalProperties.$http = axios
app.config.globalProperties.$global = global_.data
app.use(router)

app.mount('#app')
