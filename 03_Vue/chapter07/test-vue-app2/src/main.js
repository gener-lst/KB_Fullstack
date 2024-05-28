import { createApp } from 'vue';
// Vue.createApp()의 기능을 가져옴
// from 'vue'로 만 명시했을 경우 프로젝트 내의 node_modules에서 가져오게 됨
import App from './App.vue';
// export default로 내보내는 것을 받아오기 때문에 중괄호 x(그냥 export는 {} 필요)
// App.vue는 root 컴포넌트임
// import CheckboxItem from './components/CheckbosItem.vue';

createApp(App).mount('#app');
// createApp(App).component('CheckboxItem', CheckboxItem).mount('#app');
// vue 인스턴스 생성.id가 app인 곳에 인스턴스를 마운스시켜라
