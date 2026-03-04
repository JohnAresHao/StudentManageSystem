<template>
  <div>
    <el-container>
      <el-main>
        <h1>Student Home</h1>
        <info-card></info-card>
        <el-card style="width: 100%; margin-top: 10px">
          <p><i class="el-icon-s-home" style="margin-right: 18px"></i>项目名：学生管理系统</p>
          <p><i class="el-icon-s-custom" style="margin-right: 18px"></i>作者：john</p>
          <p><i class="el-icon-chat-round" style="margin-right: 18px"></i>QQ: 12345678</p>
          <p><i class="el-icon-error" style="margin-right: 18px;"></i>仅供学习，版权所有</p>
        </el-card>
        <logout></logout>
      </el-main>
    </el-container>
  </div>
</template>

<script>
import InfoCard from '@/components/info-card.vue'
import Logout from '@/components/logout.vue'
export default {
  name: 'home',
  components: { InfoCard, Logout }
}
</script>

<style scoped>

</style>
