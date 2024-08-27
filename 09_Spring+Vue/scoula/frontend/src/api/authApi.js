import api from 'axios';

const BASE_URL = '/api/member';
const headers = { 'Content-Type': 'multipart/form-data' };
// multipart 인코딩

export default {
  // username 중복 체크, true: 중복(사용불가), false: 사용 가능
  async checkUsername(username) {
    // 주어진 username 사용해서 중복 여부 체크하는 API 호출
    const { data } = await api.get(`${BASE_URL}/checkusername/${username}`);
    console.log('AUTH GET CHECKUSERNAME', data);
    return data;
  },

  async create(member) {
    // 아바타 파일 업로드 – multipart 인코딩 필요 → FormData 객체 사용(중요!!!)
    const formData = new FormData();
    formData.append('username', member.username);
    formData.append('email', member.email);
    formData.append('password', member.password); // DTO property 명이 앞에 옴

    if (member.avatar) {
      // 아바타 이미지가 존재할 경우
      formData.append('avatar', member.avatar); // 파일 첨부
    }

    // 회원 가입 요청을 API에 보내고 응답 데이터를 반환
    const { data } = await api.post(BASE_URL, formData, headers); // data에 MemberDTO의 내용을 전달받게 됨(multipart 데이터기에 formData 포함)

    console.log('AUTH POST: ', data);
    return data;
  },
};
