<template>
  <div>
    <!-- 모든 조건이 동일할 경우 가장 마지막 요소의 스타일 적용 -> 전역 CSS 적용 -->
    <!-- 지금은 각각의 컴포넌트 스타일이 적용됨 -->
    <Child1 />
    <Child2 />
    <Child3 />
  </div>
</template>

<script>
import Child1 from './components/Childe1.vue';
import Child2 from './components/Childe2.vue';
import Child3 from './components/Childe3.vue';

export default {
  name: 'App',
  components: { Child1, Child2, Child3 },
};
</script>
