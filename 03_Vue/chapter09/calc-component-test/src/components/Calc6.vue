<template>
  <div>
    X : <input type="text" v-model.number="state.x" /><br />
    <div>결과 : {{ state.result }}</div>
  </div>
</template>

<script>
import { reactive, watch } from 'vue';
export default {
  name: 'Calc6',
  setup() {
    const state = reactive({ x: 0, result: 0 });
    watch(
      // state.x는 반응형 데이터가 아님 ~> 객체 안의 속성이기 때문에
      // 따라서, 화살표 함수로 state.x를 지정
      () => state.x,
      (current, old) => {
        console.log(`${old} -> ${current}`);
        state.result = current * 2;
      }
    );
    // return을 해줘야 template 쪽에서 사용 가능
    return { state };
  },
};
</script>
