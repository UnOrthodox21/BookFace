import { createApp } from 'vue'
import App from './App.vue'
import axios from 'axios'
import router from './router'

const app = createApp(App).use(router);
app.config.globalProperties.$http = axios;


app.mount('#app');

