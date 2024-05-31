<template>
  <div>
    <slot name="icon"></slot>
    <input
      type="checkbox"
      :value="id"
      :checked="checked"
      @change="$emit('check-changed', { id, checked: $event.target.checked })"
    />
    <!-- 체크박스가 체크됐을 경우 span 태그 랜더링 // i태그는 보여질 경우 이텔릭체로 label 출력 -->
    <slot name="label">Item</slot>
  </div>
</template>

<script>
export default {
  name: 'CheckBox3',
  props: ['id', 'checked', 'label'],
};
</script>
