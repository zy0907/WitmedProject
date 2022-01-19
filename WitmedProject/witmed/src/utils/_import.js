// 对于后台所查询的路由列表，进行重新格式化
// 将 component 的值变为真正的 Vue 组件名
export default function(component) {
  switch (component) {
    case 'Layout':
      return require('@/layout').default
    case 'Test':
      return require('@/views/table/index').default
    default:
      return require('@/views/' + component + '/index').default
  }
}
