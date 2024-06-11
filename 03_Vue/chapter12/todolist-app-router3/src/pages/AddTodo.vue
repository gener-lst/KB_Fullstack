<template>
  <div class="row">
    <div class="col p-3">
      <h2>할일 추가</h2>
    </div>
  </div>
  <div class="row">
    <div class="col">
      <div class="form-group">
        <label htmlFor="todo">할일: </label>
        <input
          type="text"
          class="form-control"
          id="todo"
          v-model="todoItem.todo"
        />
      </div>
      <div class="form-group">
        <label htmlFor="desc">설명: </label>
        <textarea
          id="desc"
          class="form-control"
          row="3"
          v-model="todoItem.desc"
        ></textarea>
      </div>
      <div class="form-group">
        <button
          type="button"
          class="btn btn-primary m-1"
          @click="addTodoHandler"
        >
          추가
        </button>
        <button
          type="button"
          class="btn btn-primary m-1"
          @click="router.push('/todos')"
        >
          취소
        </button>
      </div>
    </div>
  </div>
</template>

<script setup>
import { inject, reactive } from 'vue';
import { useRouter } from 'vue-router';

const router = useRouter();
const { addTodo } = inject('actions');
const todoItem = reactive({ todo: '', desc: '' });

const addTodoHandler = () => {
  let { todo } = todoItem;
  // 아이템의 할일 값이 비어있으면 경고창 출력
  if (!todo || todo.trim() === '') {
    alert('할일은 반드시 입력해야 합니다.');
    // return 만나면 함수 종료
    return;
  }
  // 넣어준 정보를 가지고 목록의 맨 뒤에 추가해줌
  addTodo({ ...todoItem }, () => {
    // 리스트에 항목을 추가한 후 전체 목록 페이지로 이동
    router.push('/todos');
  });
};
</script>
