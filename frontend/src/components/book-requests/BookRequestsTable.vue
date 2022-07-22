<template>

 <div v-if="bookRequests !== null">
   <table class="table my-5 mx-auto">
  <thead>
    <tr>
      <th scope="col">#</th>
      <th scope="col">Customer</th>
      <th scope="col">Created at</th>
      <th scope="col">Author</th>
      <th scope="col">Title</th>
      <th scope="col">Publishing year</th>
      <th scope="col">Pages</th>
      <th scope="col">End date</th>
      <th scope="col">Status</th>
      <th scope="col">Actions</th>
    </tr>
  </thead>
  <tbody>
    <tr v-bind:key="bookRequest.id" v-for="(bookRequest, index) in bookRequests">
      <td>{{ index + 1 }}</td>
      <td v-if="bookRequest.customer !== null"> {{ bookRequest.customer.firstName }} {{ bookRequest.customer.lastName }}</td>
      <td v-if="bookRequest.customer === null"> None </td>
      <td> {{ bookRequest.creationDateAndTime }}</td>
      <td>{{ bookRequest.author}}</td>
      <td>{{ bookRequest.title }}</td>
       <td>{{ bookRequest.publishingYear }}</td>
       <td>{{ bookRequest.pages }}</td>
       <td>{{ bookRequest.endDate }}</td>
       <td>{{ bookRequest.status }}</td>
      
      <td v-if="bookRequest.status !== 'COMPLETED' && bookRequest.status !== 'REJECTED'"><button  type="button" class="btn btn-outline-info mx-2" data-toggle="modal" > Edit </button>
      <button @click="completeBookRequest(bookRequest )" to="/home" type="button" class="btn btn-outline-success mx-2"> Complete </button>
      <button @click="rejectBookRequest( bookRequest )" class="btn btn-outline-danger mx-2"> Reject </button></td>
    </tr>
  </tbody>
</table>
</div>

</template>

<script>
export default {
    name: "BookRequestsTable",
    
    created() {
      this.$parent.$parent.$parent.setBookRequests();
    },
    
     methods: {
      completeBookRequest(bookRequest){
    
        if(window.confirm("Are You sure you want to complete this book request?")) {
          this.$http.post(process.env.VUE_APP_API_URL + "/book-requests/" + bookRequest.id + "/complete")
          .then(() => this.$parent.$parent.$parent.setBookRequests())
          .catch(err => console.log(err));
        }

       },
    
      rejectBookRequest(bookRequest) {
         if(window.confirm("Are You sure you want to reject this book request?")) {
          this.$http.post(process.env.VUE_APP_API_URL + "/book-requests/" + bookRequest.id + "/reject")
          .then(() => this.$parent.$parent.$parent.setBookRequests())
          .catch(err => console.log(err));
         }
      }
     },

    props: ["bookRequests"]

}
</script>

<style scoped>
  
    .col-form-label {
      text-align: right;
      padding-right: 0em;
    }
</style>
