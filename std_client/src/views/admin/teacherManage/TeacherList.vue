<template>
  <div>
    <el-table
      :data="tableData"
      border
      style="width: 100%">
      <el-table-column fixed prop="tid" label="工号" width="150">
      </el-table-column>
      <el-table-column prop="tname" label="姓名" width="150">
      </el-table-column>
      <el-table-column prop="password" label="密码" width="150">
      </el-table-column>
      <el-table-column label="操作" width="100">
        <template slot-scope="scope">
          <el-popconfirm
            confirm-button-text='删除'
            cancel-button-text='取消'
            icon="el-icon-info"
            icon-color="red"
            title="删除不可复原"
            @confirm="deleteTeacher(scope.row)">
            <el-button slot="reference" type="text" size="small">删除</el-button>
          </el-popconfirm>
          <el-button @click="edit(scope.row)" type="text" size="small">编辑</el-button>
        </template>
      </el-table-column>
    </el-table>
    <el-pagination
      background
      layout="prev, pager, next"
      :total="total"
      :page-size="pageSize"
      @current-change="changePage">
    </el-pagination>
  </div>
</template>

<script>
import axios from 'axios'
export default {
  methods: {
    deleteTeacher(row) {
      if (row.tname === 'admin') {
        this.$message({
          showClose: true,
          message: 'admin 不可删除',
          type: 'error'
        })
        return
      }
      const that = this
      axios.get('/teacher/deleteById/' + row.tid).then(function (resp) {
        if (resp.data === true) {
          that.$message({
            showClose: true,
            message: '删除成功',
            type: 'success'
          })
          window.location.reload()
        } else {
          that.$message({
            showClose: true,
            message: '删除出错，请查询数据库连接',
            type: 'error'
          })
        }
      }).catch(function (e) {
        that.$message({
          showClose: true,
          message: '删除出错，存在外键依赖',
          type: 'error'
        })
      })
    },
    changePage(page) {
      page = page - 1
      const that = this
      const start = page * that.pageSize
      const end = that.pageSize * (page + 1)
      const length = that.tmpList.length
      const ans = (end < length) ? end : length
      that.tableData = that.tmpList.slice(start, ans)
    },
    edit(row) {
      if (row.tname === 'admin') {
        this.$message({
          showClose: true,
          message: 'admin 不可编辑',
          type: 'error'
        })
        return
      }
      this.$router.push({
        path: '/editTeacher',
        query: {
          tid: row.tid
        }
      })
    }
  },
  data() {
    return {
      tableData: null,
      pageSize: 8,
      total: null,
      tmpList: null
    }
  },
  props: {
    ruleForm: Object
  },
  watch: {
    ruleForm: {
      handler(newRuleForm, oldRuleForm) {
        console.log('组件监听 form')
        const that = this
        that.tmpList = null
        that.total = null
        that.tableData = null
        axios.post('/teacher/findBySearch', newRuleForm).then(function (resp) {
          console.log('查询结果:')
          console.log(newRuleForm)
          console.log(resp)
          that.tmpList = resp.data
          that.total = resp.data.length
          const start = 0
          const end = that.pageSize
          const length = that.tmpList.length
          const ans = (end < length) ? end : length
          that.tableData = that.tmpList.slice(start, ans)
        })
      },
      deep: true,
      immediate: true
    }
  }
}
</script>s
