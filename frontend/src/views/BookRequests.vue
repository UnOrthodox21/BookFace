<template>

<div class="container-fluid">
  <div class="row">
    <div class="col-12">
        <BookRequestsBanner/>
        <BookRequestsTable v-bind:bookRequests="bookRequests"/>
      </div>
    </div>
</div>

</template>

<script>
import BookRequestsBanner from '../components/book-requests/BookRequestsBanner.vue';
import BookRequestsTable from "../components/book-requests/BookRequestsTable.vue";

export default {
  name: "BookRequests",
  components: {
    BookRequestsBanner,
    BookRequestsTable
  },
  props: ["bookRequests"]
}
</script>

<style scoped>
</style>