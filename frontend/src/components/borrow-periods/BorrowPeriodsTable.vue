<template>
 
  <div v-if="borrowPeriods !== null">
   <table class="table my-5 mx-auto">
  <thead>
    <tr>
      <th scope="col">#</th>
      <th scope="col">Customer</th>
      <th scope="col">Book</th>
      <th scope="col">Status</th>
      <th scope="col">Creation date and Time</th>
      <th scope="col">Start date</th>
      <th scope="col">End date</th>
      <th scope="col">Actions</th>
    </tr>
  </thead>
  <tbody>
    <tr v-bind:key="borrowPeriod.id" v-for="(borrowPeriod, index) in borrowPeriods">
      <td>{{ index + 1 }}</td>
      <td> {{ borrowPeriod.customer }}</td>
      <td> {{ borrowPeriod.book }}</td>
      <td>{{ borrowPeriod.status}}</td>
      <td>{{ borrowPeriod.creationDateAndTime }}</td>
      <td>{{ borrowPeriod.startDate }}</td>
      <td>{{ borrowPeriod.endDate }}</td>
     
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
    name: "BorrowPeriodsTable",
    
    props: ["borrowPeriods"],

    created() {
      this.$parent.$parent.$parent.setBorrowPeriods();
    }
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
