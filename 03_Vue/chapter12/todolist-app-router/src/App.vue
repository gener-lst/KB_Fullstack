<template>
  <div class="container">
    <Header />
    <!-- 계속 페이지가 바뀌는 부분이 router view -->
    <router-view />
  </div>
</template>

<script setup>
// script setup 사용 시, 컴포넌트에 따로 등록할 필요 없음
import Header from '@/components/Header.vue';
import { reactive, computed, provide } from 'vue';

const states = reactive({
  todoList: [
    { id: 1, todo: 'ES6학습', desc: '설명1', done: false },
    { id: 2, todo: 'React학습', desc: '설명2', done: false },
    { id: 3, todo: 'ContextAPI 학습', desc: '설명3', done: true },
    { id: 4, todo: '야구경기 관람', desc: '설명4', done: false },
  ],
});

// todo를 추가하는 메소드, todo와 desc가 들어있는 객체를 구조 분해 할당으로 받음
const addTodo = ({ todo, desc }) => {
  // todoList의 맨 뒤에 새로운 객체 추가
  states.todoList.push({ id: new Date().getTime(), todo, desc, done: false });
};

// todo를 수정하는 메소드, 해당 id의 todo를 찾아서 todo, desc, done 값을 업데이트
const updateTodo = ({ id, todo, desc, done }) => {
  // 받아온 id로 해당하는 todo를 찾은 후 해당 todo의 index 반환
  let index = states.todoList.findIndex((todo) => todo.id === id);
  // 찾아온 todo의 값을 그대로 펼친 후 todo, desc, done 값을 업데이트해서 다시 대입
  states.todoList[index] = { ...states.todoList[index], todo, desc, done };
};

// todo를 삭제하는 메소드, 해당 id의 todo를 찾아서 삭제
const deleteTodo = (id) => {
  // 받아온 id로 해당하는 todo를 찾은 후 해당 todo의 index 반환
  let index = states.todoList.findIndex((todo) => todo.id === id);
  // todolist에서 goekd index에 있는 객체 한개를 삭제함
  states.todoList.splice(index, 1);
};

const toggleDone = (id) => {
  // 받아온 id로 해당하는 todo를 찾은 후 해당 todo의 index 반환
  let index = states.todoList.findIndex((todo) => todo.id === id);
  // 해당 todo의 done 값을 반대로 바꿔줌
  states.todoList[index].done = !states.todoList[index].done;
};

provide(
  'todoList',
  computed(() => states.todoList)
);
provide('actions', { addTodo, deleteTodo, toggleDone, updateTodo });
</script>
