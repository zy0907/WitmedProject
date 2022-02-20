import request from '@/utils/request'

export function getList(params) {
  return request({
    url: 'http://localhost:11111/system/dictionary/identity/page/1/10',
    method: 'post',
    data: params
  })
}
