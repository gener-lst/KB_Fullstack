<template>
  <nav class="navbar navbar-expand-md bg-dark navbar-dark mt-2"></nav>
  <span class="navbar-brand">이날치(LeeNalChi)</span>
  <!-- 버튼 클릭시 changeIsNavShow 함수 호출 -->
  <button type="button" class="navbar-toggler" @click="changeIsNavShow">
    <span class="navbar-toggler-icon"></span>
  </button>

  <!-- navClass 데이터 내에 있는 클래스 이름 바인딩 -->
  <div class="navClass">
    <ul class="navbar-nav">
      <li class="nav-i">
        <router-link class="nav-link" to="/">홈</router-link>
      </li>
      <li class="nav-item">
        <router-link class="nav-link" to="/about">소개</router-link>
      </li>
      <li class="nav-item">
        <router-link class="nav-link" to="/members">맴버</router-link>
      </li>
      <li class="nav-item">
        <router-link class="nav-link" to="/videos">영상</router-link>
      </li>
    </ul>
  </div>
</template>

<script>
import { reactive, computed } from 'vue';

export default {
  setup() {
    const state = reactive({ isNavShow: false });

    const navClass = computed(() =>
      state.isNavShow
        ? 'collapse navbar-collapse show'
        : 'collapse navbar-collapse'
    );

    const changeIsNavShow = () => {
      state.isNavShow = !state.isNavShow;
    };

    return { state, changeIsNavShow, navClass };
  },
};
</script>
