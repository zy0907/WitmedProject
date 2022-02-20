import Cookies from 'js-cookie'
// 存储 Cookie 的 key
const TokenKey = 'witmed_token'

export function getToken() {
  return Cookies.get(TokenKey)
}

export function setToken(token) {
  return Cookies.set(TokenKey, token)
}

export function removeToken() {
  return Cookies.remove(TokenKey)
}
