<template>
<BorrowPeriodsBanner/>
<BorrowPeriodsTable v-bind:borrowPeriods="borrowPeriods"/>
</template>

<script>
import BorrowPeriodsBanner from "../components/borrow-periods/BorrowPeriodsBanner.vue";
import BorrowPeriodsTable from "../components/borrow-periods/BorrowPeriodsTable.vue";

export default {
  name: "BorrowsPeriods",
  components: {
    BorrowPeriodsBanner,
    BorrowPeriodsTable
  },
  props: ["borrowPeriods"]
}
</script>

<style scoped>

</style>

