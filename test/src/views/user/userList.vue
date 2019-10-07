<template>
  <div>
    用户列表{{$route.params.username}},props={{username}}
  </div>
</template>

<script>
export default {
  props: ['username'],
  name: 'userList'
}
</script>

<style scoped>

</style>
