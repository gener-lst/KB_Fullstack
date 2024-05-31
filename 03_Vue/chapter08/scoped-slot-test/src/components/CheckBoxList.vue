<template>
  <div v-for="item in items" :key="item.id">
    <slot name="icon" :checked="item.checked"></slot>
    <input
      type="checkbox"
      :value="item.id"
      :checked="item.checked"
      @change="
        $emit('check-changed', { id: item.id, checked: $event.target.checked })
      "
    />
    <!-- 체크박스가 체크됐을 경우 span 태그 랜더링 // i태그는 보여질 경우 이텔릭체로 label 출력 -->
    <slot :checked="item.checked" :label="item.label"></slot>
  </div>
</template>

<script>
export default {   
  name: 'CheckBoxList',
  props: ['items'],
};
</script>
