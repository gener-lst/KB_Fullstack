<template>
  <div class="m-3">
    <h3>존재하지 않는 경로</h3>
    <p>요청 경로 : {{ currentRoute.path }}</p>
    <!-- 404 에러에 대한 처리 -->
  </div>
</template>

<script setup>
import { useRoute } from 'vue-router';
const currentRoute = useRoute();
</script>
