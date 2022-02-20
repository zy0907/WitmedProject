<template>
  <div class="login-container">
    <el-form ref="loginForm"
             :model="loginForm"
             :rules="loginRules"
             class="login-form"
             auto-complete="on"
             label-position="left">

      <div class="title-container">
        <h3 class="title">智慧医疗信息平台</h3>
      </div>

      <el-form-item prop="cellphone">
        <span class="svg-container">
          <svg-icon icon-class="user" />
        </span>
        <el-input
          ref="cellphone"
          v-model="loginForm.cellphone"
          placeholder="请填写您的登录手机号码"
          name="cellphone"
          type="text"
          tabindex="1"
          auto-complete="on"
        />
      </el-form-item>

      <el-form-item prop="password">
        <span class="svg-container">
          <svg-icon icon-class="password" />
        </span>
        <el-input
          :key="passwordType"
          ref="password"
          v-model="loginForm.password"
          :type="passwordType"
          placeholder="请填写您的登录密码"
          name="password"
          tabindex="2"
          auto-complete="on"
          @keyup.enter.native="handleLogin"
        />
        <span class="show-pwd" @click="showPwd">
          <svg-icon :icon-class="passwordType === 'password' ? 'eye' : 'eye-open'" />
        </span>
      </el-form-item>

      <el-button :loading="loading" type="primary"
                 style="width:100%;margin-bottom:30px;"
                 @click.native.prevent="handleLogin">
        登录系统
      </el-button>
    </el-form>
  </div>
</template>

<script>
export default {
  name: 'Login',
  data() {
    // 校验登录手机号码
    const validateCellphone = (rule, value, callback) => {
      // 设置手机号码校验正则表达式
      const cellphoneRegex = new RegExp('1[0-9]{10}')
      if (cellphoneRegex.test(value)) {
        // 手机号码校验通过
        callback()
      } else {
        // 手机号码校验失败
        callback(new Error('请填写正确的手机号码！'))
      }
    }
    // 校验登录密码
    const validatePassword = (rule, value, callback) => {
      // 设置登录密码正则表达式
      const passwordRegex = new RegExp('[A-Za-z0-9]{6,}')
      if (passwordRegex.test(value)) {
        // 校验成功
        callback()
      } else {
        callback(new Error('登录密码由大写字母、小写字母和数字组成，至少六位！'))
      }
    }
    return {
      loginForm: {
        cellphone: '',
        password: ''
      },
      loginRules: {
        cellphone: [{ required: true, trigger: 'blur', validator: validateCellphone }],
        password: [{ required: true, trigger: 'blur', validator: validatePassword }]
      },
      loading: false,
      passwordType: 'password',
      redirect: undefined
    }
  },
  watch: {
    $route: {
      handler: function(route) {
        this.redirect = route.query && route.query.redirect
      },
      immediate: true
    }
  },
  methods: {
    showPwd() {
      if (this.passwordType === 'password') {
        this.passwordType = ''
      } else {
        this.passwordType = 'password'
      }
      this.$nextTick(() => {
        this.$refs.password.focus()
      })
    },
    handleLogin() {
      this.$refs.loginForm.validate(valid => {
        if (valid) {
          this.loading = true
          this.$store.dispatch('user/login', this.loginForm).then(() => {
            this.$router.push({ path: this.redirect || '/' })
            this.loading = false
          }).catch(() => {
            this.loading = false
          })
        } else {
          console.log('error submit!!')
          return false
        }
      })
    }
  }
}
</script>

<style lang="scss">
/* 修复input 背景不协调 和光标变色 */
/* Detail see https://github.com/PanJiaChen/vue-element-admin/pull/927 */

$bg:#283443;
$light_gray:#fff;
$cursor: #fff;

@supports (-webkit-mask: none) and (not (cater-color: $cursor)) {
  .login-container .el-input input {
    color: $cursor;
  }
}

/* reset element-ui css */
.login-container {
  .el-input {
    display: inline-block;
    height: 47px;
    width: 85%;

    input {
      background: transparent;
      border: 0px;
      -webkit-appearance: none;
      border-radius: 0px;
      padding: 12px 5px 12px 15px;
      color: $light_gray;
      height: 47px;
      caret-color: $cursor;

      &:-webkit-autofill {
        box-shadow: 0 0 0px 1000px $bg inset !important;
        -webkit-text-fill-color: $cursor !important;
      }
    }
  }

  .el-form-item {
    border: 1px solid rgba(255, 255, 255, 0.1);
    background: rgba(0, 0, 0, 0.1);
    border-radius: 5px;
    color: #454545;
  }
}
</style>

<style lang="scss" scoped>
$bg:#2d3a4b;
$dark_gray:#889aa4;
$light_gray:#eee;

.login-container {
  min-height: 100%;
  width: 100%;
  background-color: $bg;
  overflow: hidden;

  .login-form {
    position: relative;
    width: 520px;
    max-width: 100%;
    padding: 160px 35px 0;
    margin: 0 auto;
    overflow: hidden;
  }

  .tips {
    font-size: 14px;
    color: #fff;
    margin-bottom: 10px;

    span {
      &:first-of-type {
        margin-right: 16px;
      }
    }
  }

  .svg-container {
    padding: 6px 5px 6px 15px;
    color: $dark_gray;
    vertical-align: middle;
    width: 30px;
    display: inline-block;
  }

  .title-container {
    position: relative;

    .title {
      font-size: 26px;
      color: $light_gray;
      margin: 0px auto 40px auto;
      text-align: center;
      font-weight: bold;
    }
  }

  .show-pwd {
    position: absolute;
    right: 10px;
    top: 7px;
    font-size: 16px;
    color: $dark_gray;
    cursor: pointer;
    user-select: none;
  }
}
</style>
