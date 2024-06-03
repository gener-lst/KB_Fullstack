<template>
  <div>
    <h2>콘솔을 확인합니다.</h2>
  </div>
</template>

<script setup>
import axios from 'axios';

// await를 쓰기 위해서는 함수 앞에 async를 붙여줌
const requestAPI = async () => {
  const url = '/api/todos';
  try {
    const response = await axios.get(url, { timeout: 900 });
    console.log('# 응답객체 : ', response);
  } catch (e) {
    console.log('## 다음 오류가 발생했습니다.');
    // instanceof : e가 Error 타입인지 체크
    if (e instanceof Error) console.log(e.message);
    else console.log(e);
  }
};

requestAPI();
</script>
