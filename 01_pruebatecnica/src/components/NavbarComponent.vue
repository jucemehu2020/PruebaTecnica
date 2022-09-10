<template>
  <div class="container-navbar">
    <div class="fixed-top" id="navbar">
      <b-navbar toggleable="md" type="dark">
        <b-container>
          <b-navbar-toggle target="nav_collapse"></b-navbar-toggle>

          <b-collapse id="nav_collapse" is-nav>
            <b-navbar-nav>
              <b-nav-item style= "margin-left: 150px;" :to="{ name: 'funcionPalindroma' }" exact>Funcion Palindroma</b-nav-item>

              <b-nav-item :to="{ name: 'funcionFibonacci' }">Funcion Fibonacci</b-nav-item>

              <b-nav-item :to="{ name: 'funcionPrimos' }">Funcion Primos</b-nav-item>

              <b-nav-item :to="{ name: 'funcionMultiplos' }">Funcion Multiplos</b-nav-item>

              <b-nav-item :to="{ name: 'funcionFactorial' }">Funcion Factorial</b-nav-item>
            </b-navbar-nav>

          </b-collapse>
        </b-container>
      </b-navbar>
    </div>
  </div>
</template>

<script>
export default {
  name: "NavbarComponent",
  data: function () {
    return {
    };
  },
  methods: {
  },
};
</script>

<style scoped>
/* Mensaje de error */
.mensajeError {
  color: rgb(230, 0, 0);
}
.container-navbar {
  margin-bottom: 75px;
}

#navbar {
  box-shadow: 0 0.25rem 0.25rem rgb(0 0 0 / 25%),
    inset 0 -1px 5px rgb(0 0 0 / 25%);
  background-color: #13293d;
}

.navbar-collapse {
  justify-content: space-between;
}

.empresa-nombre {
  color: #e8f1f2;
  display: inline;
  padding-left: 10px;
  font-size: 35px;
}

.empresa-info {
  display: flex;
  align-items: center;
}

.opciones {
  margin-top: 10px;
  margin-left: 0px;
}

.container {
  margin: 0px 0px 0px 0px;
}

.navbar-expand-md {
  justify-content: space-evenly;
}
</style>