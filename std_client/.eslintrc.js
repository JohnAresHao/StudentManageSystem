module.exports = {
  root: true,
  env: {
    node: true
  },
  extends: [
    'plugin:vue/essential',
    '@vue/standard'
  ],
  parserOptions: {
    parser: '@babel/eslint-parser'
  },
  rules: {
    'no-console': process.env.NODE_ENV === 'production' ? 'warn' : 'off',
    'no-debugger': process.env.NODE_ENV === 'production' ? 'warn' : 'off',
    // 关闭名称校验
    'vue/multi-word-component-names': 'off',
    // 关闭2个空格缩进
    indent: ['off', 2],
    // 用于控制函数定义时括号之前的空格使用 never or always
    'space-before-function-paren': 0
  }
}
