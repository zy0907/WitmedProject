import { login, logout, getInfo } from '@/api/user'
import { getToken, setToken, removeToken } from '@/utils/auth'
import routerFormat from '@/utils/router'
import {
  constantRoutes,
  resetRouter,
  notFoundRouter
} from '@/router'

const getDefaultState = () => {
  return {
    token: getToken(),
    name: '',
    avatar: ''
  }
}

const state = getDefaultState()

const mutations = {
  RESET_STATE: (state) => {
    Object.assign(state, getDefaultState())
  },
  SET_TOKEN: (state, token) => {
    state.token = token
  },
  SET_NAME: (state, name) => {
    state.name = name
  },
  SET_AVATAR: (state, avatar) => {
    state.avatar = avatar
  },
  // 将根据用户角色所获得的路由列表添加到系统的常量状态中
  SET_ROUTERS: (state, routers) => {
    state.addRouters = routers
    // 将当前路由添加到现有路由之后
    state.routers = constantRoutes.concat(routers).concat(notFoundRouter)
  }
}

const actions = {
  // user login
  login({ commit }, userInfo) {
    const { cellphone, password } = userInfo
    return new Promise((resolve, reject) => {
      login({ cellphone: cellphone.trim(), password: password }).then(response => {
        const { data } = response
        commit('SET_TOKEN', data.token)
        setToken(data.token)
        resolve()
      }).catch(error => {
        reject(error)
      })
    })
  },

  // get user info
  getInfo({ commit, state }) {
    return new Promise((resolve, reject) => {
      getInfo(state.token).then(response => {
        const { data } = response
        // 在获得用户信息的同时，也能够获得该系统用户角色的路由列表权限
        if (!data) {
          return reject('该用户未进行系统认证，请先去登录！')
        }

        // 获得当前用户角色所对应的路由信息列表，将路由列表添加到系统常量中
        // 循环路由结果，去掉最后多余的 children 属性
        for (var index in data.routerVOList) {
          var router = data.routerVOList[index]
          // 获得该路由信息的 children 属性
          var children = router.children
          // 循环该属性，获得二级路由
          for (var i in children) {
            // 获得当前二级路由信息
            var child = children[i]
            delete child.children
          }
        }
        console.log(data.routerVOList)
        commit('SET_ROUTERS', routerFormat(data.routerVOList))
        commit('SET_NAME', data.adminVO.name)
        commit('SET_AVATAR', '')
        resolve(data)
      }).catch(error => {
        reject(error)
      })
    })
  },

  // user logout
  logout({ commit, state }) {
    return new Promise((resolve, reject) => {
      logout(state.token).then(() => {
        removeToken() // must remove  token  first
        resetRouter()
        commit('RESET_STATE')
        resolve()
      }).catch(error => {
        reject(error)
      })
    })
  },

  // remove token
  resetToken({ commit }) {
    return new Promise(resolve => {
      removeToken() // must remove  token  first
      commit('RESET_STATE')
      resolve()
    })
  }
}

export default {
  namespaced: true,
  state,
  mutations,
  actions
}

