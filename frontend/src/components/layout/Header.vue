<template>
<nav class="navbar navbar-expand-lg navbar-light">
      <div class="container-fluid">
        <router-link class="navbar-brand" to="/">BookFace</router-link>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNavDropdown" aria-controls="navbarNavDropdown" aria-expanded="false" aria-label="Toggle navigation">
          <span class="navbar-toggler-icon"></span>
        </button>

        <div class="collapse navbar-collapse" id="navbarNavDropdown">
          <ul class="navbar-nav w-100">
              <li class="nav-item">
              <router-link class="nav-link" tag="li" active-class="active" aria-current="page" to="/" exact>Home</router-link>
            </li>
            <li class="nav-item">
              <router-link class="nav-link" tag="li" active-class="active" to="/customers">Customers</router-link>
            </li>
            <li class="nav-item">
              <router-link class="nav-link" tag="li" active-class="active" to="/books">Books</router-link>
            </li>
             <li class="nav-item">
              <router-link class="nav-link" tag="li" active-class="active" to="/book-requests">Book Requests</router-link>
            </li>
             <li class="nav-item">
              <router-link class="nav-link" tag="li" active-class="active" to="/borrow-periods">Borrow periods</router-link>
            </li>
          </ul>
        </div>
      </div>
    </nav>

</template>


<script>

export default {
    name: "Header",
}
</script>


<style scoped>

    .navbar-brand {
      font-weight: bold;
      font-size: 1.8em;
      padding: 0.2em;
    }

    .navbar-light {
        background-color: rgb(245, 245, 245);
    }

    .nav-item {
        font-size: 1.40em;
    }

     .active {
        font-weight: bold;
    }



</style>
