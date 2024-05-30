<template>
  <div>
    X : <input type="text" v-model.number="state.x" /><br />
    Y : <input type="text" v-model.number="state.y" /> <br />
    <div>결과 : {{ result }}</div>
  </div>
</template>

<script>
import { reactive, computed } from 'vue';
export default {
  name: 'Calc4',
  setup() {
    // reactive로 참조형 데이터를 감싸줘야 반응형으로 동작한다
    // 기존 옵션 API의 data와 같은 역할
    const state = reactive({ x: 10, y: 20 });
    // 참조형 데이터는 .value로 접근할 필요 없다
    const result = computed(() => {
      return state.x + state.y;
    });

    return { state, result };
  },
};
</script>
