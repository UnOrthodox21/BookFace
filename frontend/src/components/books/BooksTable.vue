<template>

 <div v-if="books !== null">
  
   <table class="table my-5 mx-auto">
  <thead>
    <tr>
      <th scope="col">#</th>
      <th scope="col">Author</th>
      <th scope="col">Title</th>
      <th scope="col">Publishing year</th>
      <th scope="col">Pages</th>
       <th scope="col">Actions</th>
    </tr>
  </thead>
  <tbody>
    <tr v-bind:key="book.id" v-for="(book, index) in books">
      <td>{{ index + 1 }}</td>
      <td> {{ book.author }}</td>
      <td> {{ book.title }}</td>
      <td>{{ book.publishingYear}}</td>
      <td>{{ book.pages }}</td>
     
      <td><router-link  to="/home" type="button" class="btn btn-outline-success mx-2"> Borrow </router-link>
        <button  type="button" class="btn btn-outline-info mx-2" data-toggle="modal" > Edit </button>
      <button  class="btn btn-outline-danger mx-2"> Delete </button></td>
    </tr>
  </tbody>
</table>
</div>
</template>

<script>
export default {
    name: "BooksTable",
    
    created() {
      this.$parent.$parent.$parent.setBooks();
    },

    props: ["books"]

}
</script>

<style scoped>
    .btn-transaction {
        padding: 1em;
        height: 3.5em;
        width: 25em;
        text-align: center;
        vertical-align: center;
        box-shadow: 7px 7px 5px rgb(59, 50, 50);

    }

    .col-form-label {
      text-align: right;
      padding-right: 0em;
    }
</style>
