import { createRouter, createWebHistory } from 'vue-router';
// ../와 @/ 모두 src 폴더 내를 가리킴
import Home from '@/pages/Home.vue';
import About from '@/pages/About.vue';
import Members from '@/pages/Members.vue';
import Videos from '@/pages/Videos.vue';

const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  routes: [
    {
      path: '/',
      name: 'home', // name 속성은 필수가 아니다
      // 무조건 로딩되어야 하는 페이지기 때문에 정적으로 처리
      component: Home,
    },
    {
      path: '/about',
      // name: 'about',
      // route level code-splitting
      // this generates a separate chunk (About.[hash].js) for this route
      // which is lazy-loaded when the route is visited.
      component: About,
    },
    {
      path: '/members',
      component: Members,
    },
    {
      path: '/videos',
      component: Videos,
    },
  ],
});

// router 만든 후 내보내기
export default router;
