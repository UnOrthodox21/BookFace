<template>
<div class="content">
  <Header />
  <router-view v-bind:customers="customers" v-bind:books="books"  
  v-bind:bookRequests="bookRequests" v-bind:borrowPeriods="borrowPeriods"/>
  </div>
  <Footer/>
</template>

<script>
import Header from "./components/layout/Header.vue"
import Footer from "./components/layout/Footer.vue"
import {useRouter} from "vue-router";
export default {
    name: "app",
    components: {
      Header,
      Footer
    },
    data() {
      return {
        customers: [],
        books: [],
        bookRequests: [],
        borrowPeriods: [],
        router: useRouter()
      }
    },
  
     methods: {
      setCustomers() {
          this.$http.get(process.env.VUE_APP_API_URL + "/customers")
        .then((response) => { this.customers = response.data })
        .catch(err => console.log(err));
      },
      setBooks() {
        this.$http.get(process.env.VUE_APP_API_URL + "/books")
        .then((response) => { this.books = response.data })
        .catch(err => console.log(err));
      },
      setBookRequests() {
         this.$http.get(process.env.VUE_APP_API_URL + "/book-requests")
        .then((response) => { this.bookRequests = response.data })
        .catch(err => console.log(err));
      },
   
       setBorrowPeriods() {
          this.$http.get(process.env.VUE_APP_API_URL + "/borrow-periods")
        .then((response) => { this.borrowPeriods = response.data })
        .catch(err => console.log(err));
      }
    }
  }
</script>


<style>
html, body {
  min-height: 100%;
  background-color:  rgb(240, 240, 240);
  background-size: cover;
}
.content {
  flex: 1 0 auto;
  margin-bottom: 10rem;
}
.footer {
  flex-shrink: 0;
}

.table {
  color: rgb(220, 220, 220);
}
#app {
  /* font-family: Avenir, Helvetica, Arial, sans-serif; */
  /* font-family: 'Lato', sans-serif; */
  font-family: 'Roboto Condensed', sans-serif; 
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: rgb(248, 248, 248);
  background-image: url("assets/background.jpg");
  background-size: cover;
  background-repeat: no-repeat;
  background-position: center center;
  min-height: 100%;
  display: flex;
  flex-direction: column;
}
#nav {
  padding: 30px;
}
#nav a {
  font-weight: bold;
  color: #2c3e50;
}
#nav a.router-link-exact-active {
  color: #42b983;
}
</style>
