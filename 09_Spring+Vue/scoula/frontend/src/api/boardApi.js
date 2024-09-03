import api from '@/api';

const BASE_URL = '/api/board';
// 파일 업로드를 위한 헤더
const headers = { 'Content-Type': 'multipart/form-data' };

export default {
    async getList(params) {
        // URL과 params 매개변수로 서버에 요청을 보내고 data를 받아온다
        const { data } = await api.get(BASE_URL, { params });
        console.log('BOARD GET LIST: ', data);
        return data;
    },

    // async getList(params) {
    //     try {
    //         const { data } = await api.get(BASE_URL, { params });
    //         console.log('BOARD GET LIST: ', data);
    //         return {
    //             articles: data.articles,  // 게시글 목록
    //             totalItems: data.totalItems // 총 게시글 수
    //         };
    //     } catch (error) {
    //         console.error('Error fetching list:', error);
    //         throw error;
    //     }
    // },

    // async getList(params) {
    //     try {
    //         const { data } = await api.get(BASE_URL, { params });
    //         console.log('BOARD GET LIST: ', data);
    //         return {
    //             list: data.list, // 게시글 목록
    //             totalCount: data.totalCount, // 총 게시글 수
    //             totalPage: data.totalPage, // 총 페이지 수
    //         };
    //     } catch (error) {
    //         console.error('Error fetching list:', error);
    //         throw error;
    //     }
    // },

    async create(article) {
        const formData = new FormData();
        formData.append('title', article.title);
        formData.append('writer', article.writer);
        formData.append('content', article.content);
        // 파일이 존재하는 경우, 해당 파일의 길이만큼 돌면서 각 파일을 FormData에 추가
        if (article.files) {
            for (let i = 0; i < article.files.length; i++) {
                formData.append('files', article.files[i]);
            }
        }
        const { data } = await api.post(BASE_URL, formData, { headers });
        console.log('BOARD POST: ', data);
        return data;
    },

    async get(no) {
        const { data } = await api.get(`${BASE_URL}/${no}`);
        console.log('BOARD GET: ', data);
        return data;
    },

    async delete(no) {
        const { data } = await api.delete(`${BASE_URL}/${no}`);
        console.log('BOARD DELETE: ', data);
        return data;
    },
    // 게시글 수정
    async update(article) {
        const formData = new FormData();
        formData.append('no', article.no);
        formData.append('title', article.title);
        formData.append('writer', article.writer);
        formData.append('content', article.content);
        if (article.files) { // 첨부파일이 있는 경우
            for (let i = 0; i < article.files.length; i++) {
                formData.append('files', article.files[i]);
            }
        }
        const { data } = await api.put(`${BASE_URL}/${article.no}`, formData, { headers });
        console.log('BOARD PUT: ', data);
        return data;
    },
    // 첨부파일 삭제
    async deleteAttachment(no) {
        // 첨부파일 번호에 해당하는 첨부파일 한 개를 삭제
        const { data } = await api.delete(`${BASE_URL}/deleteAttachment/${no}`);
        console.log('ATTACHMENT DELETE: ', data);
        return data;
    },
}