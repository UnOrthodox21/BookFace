<template>

 <div v-if="customers !== null">
  <table class="table my-5 mx-auto">
  <thead>
    <tr>
      <th scope="col">#</th>
      <th scope="col">First name</th>
      <th scope="col">Last name</th>
      <th scope="col">Age</th>
      <th scope="col">Address</th>
      <th scope="col">Phone</th>
      <th scope="col">E-mail</th>
      <th scope="col">Time of registration</th>
      <th scope="col">Borrow periods</th>
      <th scope="col">Book requests</th>
      <th scope="col">Actions</th>
    </tr>
  </thead>
  <tbody>
    <tr v-bind:key="customer.id" v-for="(customer, index) in customers">
      <td>{{ index + 1 }}</td>
      <td> {{ customer.firstName }}</td>
      <td> {{ customer.lastName }}</td>
      <td>{{ customer.age }}</td>
      <td>{{ customer.address }}</td>
      <td>{{ customer.phone }}</td>
      <td>{{ customer.email }}</td>
      <td>{{ customer.dateAndTimeOfRegistration }}</td>
      <td>{{ customer.borrowPeriods }}</td>
      <td>{{ customer.bookRequests }}</td>

     <td>
     <button  type="button" class="btn btn-outline-info mx-2" data-toggle="modal" > Edit </button>
      <button  class="btn btn-outline-danger mx-2"> Delete </button></td>
    </tr>
  </tbody>
  </table>
  </div>
</template>

<script>
export default {
    name: "CustomersTable",
    

    props: ["customers"],

    created() {
      this.$parent.$parent.$parent.setCustomers();
    },


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
