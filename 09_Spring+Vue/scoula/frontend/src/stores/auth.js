import { ref, computed, reactive } from 'vue';
import { defineStore } from 'pinia';
import axios from 'axios';

const initState = {
    token: '', // 접근 토큰(JWT)
    user: {
        username: '', // 사용자 ID
        email: '', // Email
        roles: [], // 권한 목록
    },
};

// 인증 관련 스토어 정의
export const useAuthStore = defineStore('auth', () => {
    const state = ref({ ...initState }); // 펼침 연산자로 위에 정의한 객체를 복사
    // computed를 통해 읽기 전용 데이터 생성
    const isLogin = computed(() => !!state.value.user.username); // 로그인 여부(!!을 붙히면 boolean 값으로 형변환 -> 값이 있으면 true가 됨)
    const username = computed(() => state.value.user.username); // 로그인 사용자 ID
    const email = computed(() => state.value.user.email); // 로그인 사용자 email

    const login = async (member) => {
        // state.value.token = 'test token';
        // state.value.user = { username: member.username, email: member.username + '@test.com' } ;

        // api 호출
        const { data } = await axios.post('/api/auth/login', member);
        state.value = { ...data };
        localStorage.setItem('auth', JSON.stringify(state.value)); // Stringfy: json 데이터를 'auth'라는 이름으로 String화시켜서 로컬 스토리지에 저장(직렬화)
    };

    // 로그아웃 함수
    const logout = () => {
        localStorage.clear(); // 로컬스토리지 비우기
        state.value = { ...initState }; // 상태 초기화
    };

    // 토큰을 가져오는 함수
    const getToken = () => state.value.token;

    // 저장된 인증 정보를 불러오는 함수
    const load = () => {
        const auth = localStorage.getItem('auth');
        if (auth != null) {
            state.value = JSON.parse(auth); // parse: String 값을 json 데이터로 변환(역직렬화)
            console.log(state.value);
        }
    };

    // 사용자의 프로필(이메일)을 변경하는 함수
    const changeProfile = (member) => {
        state.value.user.email = member.email;
        // 이미 auth 정보가 있는 경우 덮어쓴다
        localStorage.setItem('auth', JSON.stringify(state.value)); // 직렬화
    };

    load(); // 스토어가 초기화될 때 인증 정보 로드
    return { state, username, email, isLogin, changeProfile, login, logout, getToken };
});