import Layout from "@/layout";

// 将异步获得的用户路由列表进行格式化
export default function formatRouter(routerVOList) {
  var routerList = new Array()
  for (let i in routerVOList) {
    const routerVO = routerVOList[i]
    var children = new Array()
    // 循环二级菜单
    for (let j in routerVO.children) {
      const childRouterVO = routerVO.children[j]
      const component = childRouterVO.component
      const child = {
        name: childRouterVO.name,
        path: childRouterVO.path,
        component: require('@/views' + component).default,
        meta: {
          title: childRouterVO.meta.title,
          icon: childRouterVO.meta.icon
        }
      }
      children[j] = child
    }
    const router ={
      name: routerVO.name,
      component: Layout,
      path: routerVO.path,
      meta: {
        title: routerVO.meta.title,
        icon: routerVO.meta.icon
      },
      children: children
    }
    routerList[i] = router
  }
  return routerList
}
