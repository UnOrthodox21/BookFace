<template>
    <CustomersBanner/>
    <CustomersTable v-bind:customers="customers"/>
</template>

<script>
import CustomersBanner from '../components/customers/CustomersBanner.vue';
import CustomersTable from '../components/customers/CustomersTable.vue';

export default {
  name: "Customers",
  components: {
    CustomersBanner,
    CustomersTable
  },
  props: ["customers"]
}
</script>

<style scoped>

</style>

