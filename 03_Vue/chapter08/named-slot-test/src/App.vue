<template>
  <div>
    <!-- <NoSlotTest /> -->
    <SlotTest />
  </div>
</template>
<script>
// import NoSlotTest from './components/SlotTest.vue';
import SlotTest from './components/SlotTest.vue';
export default {
  name: 'App',
  components: { SlotTest },
};
</script>
