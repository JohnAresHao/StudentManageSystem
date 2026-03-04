<template>
  <div>
    <el-container>
      <el-header style="text-align: right; font-size: 18px; background-color: #409EFF; border-radius: 3px">
        <my-header></my-header>
      </el-header>
    </el-container>
    <el-container>
      <my-aside></my-aside>
      <el-main>
        <router-view></router-view>
      </el-main>
    </el-container>
  </div>
</template>

<script>
import MyAside from '@/components/my-aside.vue'
import MyHeader from '@/components/my-header.vue'
export default {
  name: 'index',
  components: { MyAside, MyHeader }
}
</script>

<style scoped>

</style>
