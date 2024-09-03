// 게시판 관련한 라우트를 정의하는 js
// 하나의 중괄호 부분을 route, 라우트를 통해 페이지 이동을 담당하는 전체 파트를 router라고 함
import { isAuthenticated } from '@/util/guards';

export default [ {
  // 게시판 리스트 페이지에 대한 라우트
  path: '/board/list',
  name: 'board/list',
  component: () => import('../pages/board/BoardListPage.vue'),
},{
  // 게시글 상세 페이지에 대한 라우트
  path: '/board/detail/:no', // :no는 라우트 변수라고 함(변수는 계속 바뀜)
  name: 'board/detail',
  component: () => import('../pages/board/BoardDetailPage.vue'),
},{
  // 게시글 작성 페이지에 대한 라우트
  path: '/board/create',
  name: 'board/create',
  component: () => import('../pages/board/BoardCreatePage.vue'),
  beforeEnter: isAuthenticated,
},{
  // 게시글 수정 페이지에 대한 라우트
  path: '/board/update/:no',
  name: 'board/update',
  component: () => import('../pages/board/BoardUpdatePage.vue'),
  beforeEnter: isAuthenticated,
},
];