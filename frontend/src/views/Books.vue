<template>
  <BooksBanner />
  <BooksTable v-bind:books="books" />
</template>

<script>
  import BooksBanner from "../components/books/BooksBanner.vue";
  import BooksTable from "../components/books/BooksTable.vue"

  export default {
    name: 'Books',
    components: {
      BooksBanner,
      BooksTable
    },
    props: ["books"]
  }
</script>

<style scoped>
</style>
