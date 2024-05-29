<template>
  <div>
    <!-- 체크박스 변경시 id값과 현재 체크박스의 체크상태값을 check-changed 이벤트에 담아서 부모로 보냄 -->
    <input
      type="checkbox"
      :value="id"
      :checked="checked"
      @change="$emit('check-changed', { id, checked: $event.target.checked })"
    />
    <!-- 체크박스가 체크됐을 경우 span 태그 랜더링 // i태그는 보여질 경우 이텔릭체로 label 출력 -->
    <span
      v-if="checked === true"
      style="color: blue; text-decoration: underline"
    >
      <i>{{ label }}</i></span
    >
    <span v-else style="color: gray">{{ label }}</span>
  </div>
</template>

<script>
export default {
  name: 'CheckBox1',
  props: ['id', 'checked', 'label'],
};
</script>
