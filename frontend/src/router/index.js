import { createRouter, createWebHashHistory } from 'vue-router'
import Home from '../views/Home.vue'

const routes = [
  {
    path: '/',
    name: 'Home',
    component: Home
  },
  {
    path: '/books',
    name: 'Books',
    component: () => import('../views/Books.vue')
  },
  {
    path: '/customers',
    name: 'Customers',
    component: () => import('../views/Customers.vue')
  },
  {
    path: '/book-requests',
    name: 'BookRequests',
    component: () => import('../views/BookRequests.vue')
  },
  {
    path: '/borrow-periods',
    name: 'BorrowPeriods',
    component: () => import( '../views/BorrowPeriods.vue')
  }
]

const router = createRouter({
  history: createWebHashHistory(),
  routes
})

export default router
