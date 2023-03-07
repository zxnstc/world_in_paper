<template>
  <div>
    <div>
    </div>
    <div style="border: 1px solid #ccc; margin-top: 10px">
      <Toolbar :editor="editorRef"
               :defaultConfig="toolbarConfig"
               :mode="mode"
               style="border-bottom: 1px solid #ccc" />
      <Editor :defaultConfig="editorConfig"
              :mode="mode"
              v-model="valueHtml"
              style="height: 400px; overflow-y: hidden"
              @onCreated="handleCreated"
              @onChange="handleChange"
              @onDestroyed="handleDestroyed"
              @onFocus="handleFocus"
              @onBlur="handleBlur"
              @customAlert="customAlert"
              @customPaste="customPaste" />
    </div>
    <!-- <div style="margin-top: 10px">
      <textarea v-model="valueHtml"
                readonly
                style="width: 100%; height: 200px; outline: none"></textarea>
    </div> -->
  </div>
</template>
    
<script>
import '@wangeditor/editor/dist/css/style.css'
import { onBeforeUnmount, ref, shallowRef, onMounted } from 'vue'
import { Editor, Toolbar } from '@wangeditor/editor-for-vue'
import axios from 'axios'
export default {
  name: 'MyEditor',
  components: { Editor, Toolbar },
  setup() {
    // 编辑器实例，必须用 shallowRef，重要！
    const editorRef = shallowRef()

    // 内容 HTML
    const valueHtml = ref('')

    // 模拟 ajax 异步获取内容
    onMounted(() => {
      setTimeout(() => {
        valueHtml.value = ''
      }, 1500)
    })

    const toolbarConfig = {}
    const editorConfig = { placeholder: '请输入内容...', MENU_CONF: {} }

    //上传图片
    editorConfig.MENU_CONF['uploadImage'] = {
      server: '/api/forum/test',
      maxFileSize: 20 * 1024 * 1024, // 20M
      // 上传之前触发
      onBeforeUpload(file) {
        // JS 语法
        // file 选中的文件，格式如 { key: file }
        return file
      },

      // 上传进度的回调函数
      onProgress(progress) {
        // JS 语法
        // progress 是 0-100 的数字
      },

      // 单个文件上传成功之后
      onSuccess(file, res) {
        // JS 语法
      },

      // 单个文件上传失败
      onFailed(file, res) {
        // JS 语法
      },

      // 上传错误，或者触发 timeout 超时
      onError(file, err, res) {
        // JS 语法
      },
      customUpload(file, insertFn) {
        let data = new FormData()
        let url = '/myimage/api/1/upload'
        data.append('key', '4fb2110371629a961969a7ea99e3cfba')
        data.append('format', 'json')
        data.append('source', file)
        axios({
          url: url,
          method: 'post',
          headers: {
            'Content-Type': 'multipart/form-data',
          },
          data: data,
        }).then((res) => {
          console.log(res)
        let index = (res.data.image.url).indexOf('images')
        let img = (res.data.image.url).slice(index)
          let url = 'http://117.50.179.215:8070/' + img
          let alt = '加载成功'
          let href = 'http://117.50.179.215:8070/' + img
          insertFn(url, alt, href)
        })
      },
    }

    // 组件销毁时，也及时销毁编辑器，重要！
    onBeforeUnmount(() => {
      const editor = editorRef.value
      if (editor == null) return

      editor.destroy()
    })

    // 编辑器回调函数
    const handleCreated = (editor) => {
    //   console.log('created', editor)
      editorRef.value = editor // 记录 editor 实例，重要！
    }
    const handleChange = (editor) => {
    //   console.log('change:', editor.getHtml())
    }
    const handleDestroyed = (editor) => {
    //   console.log('destroyed', editor)
    }
    const handleFocus = (editor) => {
    //   console.log('focus', editor)
    }
    const handleBlur = (editor) => {
    //   console.log('blur', editor)
    }
    const customAlert = (info, type) => {
    //   alert(`【自定义提示】${type} - ${info}`)
    }
    const customPaste = (editor, event, callback) => {
    //   console.log('ClipboardEvent 粘贴事件对象', event)

      // 自定义插入内容
    //   editor.insertText('xxx')

      // 返回值（注意，vue 事件的返回值，不能用 return）
    //   callback(false) // 返回 false ，阻止默认粘贴行为
      callback(true) // 返回 true ，继续默认的粘贴行为
    }

    const insertText = () => {
      const editor = editorRef.value
      if (editor == null) return
    }

    const printHtml = () => {
      const editor = editorRef.value
      if (editor == null) return
      console.log(editor.getHtml())
    }

    const disable = () => {
      const editor = editorRef.value
      if (editor == null) return
      editor.disable()
    }

    return {
      editorRef,
      mode: 'default',
      valueHtml,
      toolbarConfig,
      editorConfig,
      handleCreated,
      handleChange:() => {
        console.log('change:', editorRef.value.getHtml())
      },
      handleDestroyed,
      handleFocus,
      handleBlur,
      customAlert,
      customPaste,
      insertText,
      printHtml,
      disable,
      getHtml: () => {
        return editorRef.value.getHtml()
      },
    }
  },
}
</script>
<style scoped>
</style>
    