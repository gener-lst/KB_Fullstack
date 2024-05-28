<!-- <script setup></script> -->
<!-- vue에서 작성하는 태그법
node 기반의 표기법으로 작성 -->

<template>
  <div>
    <h2>App 컴포넌트</h2>
    <h1>
      <ul>
        <CheckboxItem />
        <CheckboxItem />
        <CheckboxItem />
        <CheckboxItem />
      </ul>
    </h1>
  </div>
</template>
<!-- html 파트 -->
<!-- pascal 표기법을 쓰는 태그? -> import 해온 component를 사용자 정의 태그로 사용중  -->
<!-- 위와 마찬가지, 이러한 컴포넌트 태그들은 컴포넌트 노드들로 이루어진 가상 DOM 아래로 들어가게 됨 -->
<!-- 가상 DOM(ex. APP > TheWelcome) / 실제 DOM(ex. HTML > Header)  -->

<script>
import CheckboxItem from './components/CheckboxItem.vue';
// 지역 컴포넌트 등록 방법 (사용할 파일에서만 명시)
export default {
  name: 'App',
  components: { CheckboxItem },
};
</script>
