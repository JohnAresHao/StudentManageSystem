import Vue from 'vue'
import VueRouter from 'vue-router'
// 默认请求页 index
import login from '../views/login/Index.vue'
// 学生管理页
import student from '@/views/student/Index.vue'
import studentHome from '@/views/student/Home.vue'
import studentSelectCourseManage from '@/views/student/selectCourse/Index.vue'
import selectCourse from '@/views/student/selectCourse/SelectCourse.vue'
import querySelectedCourse from '@/views/student/selectCourse/QuerySelectedCourse.vue'
import studentCourseGrade from '@/views/student/courseGrade/Index.vue'
import queryCourseGrade from '@/views/student/courseGrade/QueryCourseGrade.vue'
// 教师管理页
import teacher from '@/views/teacher/Index.vue'
import teacherHome from '@/views/teacher/Home.vue'
import setCourse from '@/views/teacher/SetCourse.vue'
import myOfferCourse from '@/views/teacher/MyOfferCourse.vue'
import offerCourse from '@/views/teacher/OfferCourse.vue'
import teacherGradeCourseManage from '@/views/teacher/gradeCourseManage/Index.vue'
import teacherQueryGradeCourse from '@/views/teacher/gradeCourseManage/TeacherQueryGradeCourse.vue'
import teacherEditGradeCourse from '@/views/teacher/gradeCourseManage/TeacherEditGradeCourse.vue'
// Admin 管理页
import admin from '@/views/admin/Index.vue'
import adminHome from '@/views/admin/Home.vue'
import studentManage from '@/views/admin/studentManage/Index.vue'
import addStudent from '@/views/admin/studentManage/AddStudent.vue'
import studentList from '@/views/admin/studentManage/StudentList.vue'
import editStudent from '@/views/admin/studentManage/EditStudent.vue'
import queryStudent from '@/views/admin/studentManage/QueryStudent.vue'
import teacherManage from '@/views/admin/teacherManage/Index.vue'
import addTeacher from '@/views/admin/teacherManage/AddTeacher.vue'
import editTeacher from '@/views/admin/teacherManage/EditTeacher.vue'
import queryTeacher from '@/views/admin/teacherManage/QueryTeacher.vue'
import courseManage from '@/views/admin/courseManage/Index.vue'
import addCourse from '@/views/admin/courseManage/AddCourse.vue'
import courseList from '@/views/admin/courseManage/CourseList.vue'
import editCourse from '@/views/admin/courseManage/EditCourse.vue'
import queryCourse from '@/views/admin/courseManage/QueryCourse.vue'
import courseTeacherManage from '@/views/admin/selectCourseManage/Index.vue'
import queryCourseTeacher from '@/views/admin/selectCourseManage/QueryCourseTeacher.vue'
import queryGradeCourse from '@/views/admin/gradeCourseManage/QueryGradeCourse.vue'
import editGradeCourse from '@/views/admin/gradeCourseManage/EditGradeCourse.vue'
// 更新个人信息页
import updateInfo from '@/components/update-info.vue'

Vue.use(VueRouter)

const routes = [
  // 默认请求
  {
    path: '/',
    name: 'index',
    component: login,
    redirect: '/login' // fot test???
  },
  // 登录页
  {
    path: '/login',
    name: 'login',
    component: login
  },
  // 学生管理页
  {
    path: '/student',
    name: 'student',
    component: student,
    redirect: '/studentHome',
    meta: { requireAuth: true },
    children: [
      {
        path: '/student',
        name: 'Hi! Student',
        component: studentHome,
        meta: { requireAuth: true },
        children: [
          {
            path: '/studentHome',
            name: '学生主页',
            component: studentHome,
            meta: { requireAuth: true }
          }
        ]
      },
      {
        path: '/updateInfo',
        name: '学生编辑',
        component: updateInfo,
        meta: { requireAuth: true },
        children: [
          {
            path: '/updateInfoHome',
            name: '编辑学生信息',
            component: updateInfo,
            meta: { requireAuth: true }
          }
        ]
      },
      {
        path: '/studentSelectCourseManage',
        name: '选课管理',
        component: studentSelectCourseManage,
        meta: { requireAuth: true },
        children: [
          {
            path: '/studentSelectCourse',
            name: '选课',
            component: selectCourse,
            meta: { requireAuth: true }
          },
          {
            path: '/querySelectedCourse',
            name: '查询课表',
            component: querySelectedCourse,
            meta: { requireAuth: true }
          }
        ]
      },
      {
        path: '/courseGrade',
        name: '学生成绩管理',
        component: studentCourseGrade,
        meta: { requireAuth: true },
        children: [
          {
            path: '/queryCourseGrade',
            name: '成绩查询',
            component: queryCourseGrade,
            meta: { requireAuth: true }
          }
        ]
      }
    ]
  },
  // 教师管理页
  {
    path: '/teacher',
    name: 'teacher',
    component: teacher,
    redirect: '/teacherHome',
    meta: { requireAuth: true },
    children: [
      {
        path: '/teacherHome',
        name: 'Hi! Teacher',
        meta: { requireAuth: true },
        component: teacherHome,
        children: [
          {
            path: '/teacherHome',
            name: '教师主页',
            meta: { requireAuth: true },
            component: teacherHome
          }
        ]
      },
      {
        path: '/updateInfo',
        name: '教师编辑',
        component: updateInfo,
        meta: { requireAuth: true },
        children: [
          {
            path: '/updateInfoHome',
            name: '编辑教师信息',
            component: updateInfo,
            meta: { requireAuth: true }
          }
        ]
      },
      {
        path: '/courseManage',
        name: '课程设置',
        meta: { requireAuth: true },
        component: setCourse,
        children: [
          {
            path: '/myOfferCourse',
            name: '我开设的课程',
            component: myOfferCourse,
            meta: { requireAuth: true }
          },
          {
            path: '/offerCourse',
            name: '开设课程',
            component: offerCourse,
            meta: { requireAuth: true }
          }
        ]
      },
      {
        name: '教师成绩管理',
        path: '/teacherQueryGradeCourseManage',
        component: teacherGradeCourseManage,
        meta: { requireAuth: true },
        children: [
          {
            path: '/teacherQueryGradeCourseManage',
            name: '成绩管理',
            component: teacherQueryGradeCourse,
            meta: { requireAuth: true }
          },
          {
            path: '/teacherEditGradeCourse',
            name: '编辑成绩',
            component: teacherEditGradeCourse,
            meta: { requireAuth: true }
          }
        ]
      }
    ]
  },
  // Admin管理页
  {
    path: '/admin',
    name: 'admin',
    redirect: '/adminHome',
    component: admin,
    meta: { requireAuth: true },
    children: [
      {
        path: '/adminHome',
        name: 'Hi! Admin',
        component: adminHome,
        meta: { requireAuth: true },
        children: [
          {
            path: '/adminHome',
            name: 'admin 主页',
            component: adminHome,
            meta: { requireAuth: true }
          }
        ]
      },
      {
        path: '/studentManage',
        name: '学生管理',
        component: studentManage,
        meta: { requireAuth: true },
        children: [
          {
            path: '/addStudent',
            name: '添加学生',
            component: addStudent,
            meta: { requireAuth: true }
          },
          {
            path: '/studentList',
            name: '学生列表',
            component: studentList,
            meta: { requireAuth: true }
          },
          {
            path: '/editStudent',
            name: '编辑学生',
            component: editStudent,
            meta: { requireAuth: true }
          },
          {
            path: '/queryStudent',
            name: '搜索',
            component: queryStudent,
            meta: { requireAuth: true },
            children: [
              {
                path: '/queryStudent/studentList',
                component: studentList,
                meta: { requireAuth: true }
              }
            ]
          }
        ]
      },
      {
        path: '/teacherManage',
        name: '教师管理',
        component: teacherManage,
        meta: { requireAuth: true },
        children: [
          {
            path: '/addTeacher',
            name: '添加教师',
            component: addTeacher,
            meta: { requireAuth: true }
          },
          {
            path: '/queryTeacher',
            name: '教师列表',
            component: queryTeacher,
            meta: { requireAuth: true },
            children: []
          },
          {
            path: '/editTeacher',
            name: '编辑教师',
            component: editTeacher,
            meta: { requireAuth: true }
          }
        ]
      },
      {
        path: '/courseManage',
        name: '课程管理',
        component: courseManage,
        meta: { requireAuth: true },
        children: [
          {
            path: '/addCourse',
            name: '添加课程',
            component: addCourse,
            meta: { requireAuth: true }
          },
          {
            path: '/queryCourse',
            name: '搜索课程',
            component: queryCourse,
            meta: { requireAuth: true },
            children: [
              {
                path: '/courseList',
                name: '课程列表',
                component: courseList,
                meta: { requireAuth: true }
              }
            ]
          },
          {
            path: '/editCourse',
            name: '编辑课程',
            component: editCourse,
            meta: { requireAuth: true }
          }
        ]
      },
      {
        path: '/courseTeacher',
        name: '开课表管理',
        component: courseTeacherManage,
        meta: { requireAuth: true },
        children: [
          {
            path: '/queryCourseTeacher',
            name: '开课管理',
            component: queryCourseTeacher,
            meta: { requireAuth: true }
          }
        ]
      },
      {
        name: 'Admin 学生成绩管理',
        path: '/gradeCourseManage',
        component: studentManage,
        meta: { requireAuth: true },
        children: [
          {
            path: '/queryGradeCourse',
            name: '学生成绩查询',
            component: queryGradeCourse,
            meta: { requireAuth: true }
          },
          {
            path: '/editGradeCourse',
            name: '编辑',
            component: editGradeCourse,
            meta: { requireAuth: true }
          }
        ]
      }
    ]
  }
]

const router = new VueRouter({
  routes
})

export default router
