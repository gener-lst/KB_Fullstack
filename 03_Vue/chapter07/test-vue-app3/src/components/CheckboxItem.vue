<template>
  <li><input type="checkbox" :checked="idol.checked" />{{ idol.name }}</li>
</template>

<script>
export default {
  name: 'CheckboxItem',
  props: ['idol'],
  //props: 부모 컴포넌트(app.vue)한테 받아온 속성
  // 받아올 속성이 많은 경우 객체를 통째로 넘겨준다
};
</script>
