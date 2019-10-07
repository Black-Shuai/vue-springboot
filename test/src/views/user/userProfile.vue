<template>
  <div>
    用户个人信息{{$route.params.username}},props={{username}}
  </div>
</template>

<script>
export default {
  props: ['username'],
  name: 'userProfile'
}
</script>

<style scoped>

</style>
