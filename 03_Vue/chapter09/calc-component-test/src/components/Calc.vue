<template>
  <div>
    X : <input type="text" v-model.number="x" /><br />
    Y : <input type="text" v-model.number="y" /> <br />
  </div>
</template>

<script>
// composition API 내 함수를 사용하려면 import 필수
import { ref } from 'vue';
export default {
  name: 'Calc',
  setup() {
    // ref로 primitive 데이터를 감싸줘야 반응형으로 동작한다
    // 기존 옵션 API의 data와 같은 역할
    const x = ref(10);
    const y = ref(20);
    return { x, y };
    // return을 해줘야 template에서 사용가능
  },
};
</script>
