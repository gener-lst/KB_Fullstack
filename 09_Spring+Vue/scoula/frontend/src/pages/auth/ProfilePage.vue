<script setup>
import authApi from '@/api/authApi';
import {useAuthStore} from '@/stores/auth';
import {computed, reactive, ref} from 'vue';
// reactive: 참조형  ref: 값형

const auth = useAuthStore();
// DOM 요소(HTML의 태그 요소)를 참조하는 기법
const avatar = ref(null);
const avatarPath = `/api/member/${auth.username}/avatar`;
const member = reactive({
  username: auth.username,
  email: auth.email,
  password: '',
  avatar: null,
});
const error = ref('');
// email과 password 란 중 하나만 입력이 되어있지 않아도 버튼 비활성화
const disableSubmit = computed(() => !member.email || !member.password);
const onSubmit = async () => {
  // 해당 창 떴을 때 '취소' 누를 경우 함수 종료
  if (!confirm('수정하시겠습니까?')) return;
  if (avatar.value.files.length > 0) {
    // 파일을 여러개 업로드했을 경우에도 첫번째 파일만 프로필에 업로드
    member.avatar = avatar.value.files[0];
  }
  try {
    // 백엔드쪽에 입력받은 데이터 전송
    await authApi.update(member);
    error.value = '';
    // 로컬 스토리지 내에 있는 사용자 정보 업데이트
    auth.changeProfile(member);
    alert('정보를 수정하였습니다.');
  } catch (e) {
    error.value = e.response.data
    ;
  }
};
</script>
<template>
  <div class="mt-5 mx-auto" style="width: 500px">
    <h1><i class="fa-solid fa-user-gear my-3"></i> 회원 정보</h1>

    <form @submit.prevent="onSubmit">
      <div class="mb-3 mt-3">
        <!-- :이나 {{ }} 등의 뷰 문법이 등장한 경우 script 쪽에서 해당 데이터 찾기 -->
        <img :src="avatarPath" class="avatar avatar-lg me-4"/> {{ member.username }}
      </div>

      <div class="mb-3 mt-3">
        <label for="avatar" class="form-label">
          <i class="fa-solid fa-user-astronaut"></i>
          아바타 이미지:
        </label>
        <!-- 해당 input이 data에 있는 avatar 값과 연결된다. -->
        <input type="file" class="form-control" ref="avatar" id="avatar" accept="image/png, image/jpeg"/>
      </div>

      <div class="mb-3 mt-3">
        <label for="email" class="form-label">
          <i class="fa-solid fa-envelope"></i>
          email
        </label>
        <input type="email" class="form-control" placeholder="Email" id="email" v-model="member.email"/>
      </div>

      <div class="mb-3">
        <label for="password" class="form-label">
          <i class="fa-solid fa-lock"></i>
          비밀번호:
        </label>
        <input type="password" class="form-control" placeholder="비밀번호" id="password" v-model="member.password"/>
      </div>
      <!-- 에러 메세지 출력란(error 값이 false일 경우 랜더링이 되지 않는다) -->
      <div v-if="error" class="text-danger">{{ error }}</div>

      <div class="text-center">
        <button type="submit" class="btn btn-primary mt-4 me-3" :disabled="disableSubmit">
          <i class="fa-solid fa-user-plus"></i>
          확인
        </button>
        <!-- router-link는 a태그와 비슷하며 클릭시 to 경로로 이동한다 -> class로 앞의 버튼과 동일한 스타일 적용 -->
        <router-link class="btn btn-primary mt-4" to="/auth/changepassword">
          <i class="fa-solid fa-lock"></i>
          비밀번호 변경
        </router-link>
      </div>
    </form>
  </div>
</template>