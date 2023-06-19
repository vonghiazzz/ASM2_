<footer class="text-center text-lg-start bg-light text-muted">
      <!-- Section: Social media -->
      <section class="d-flex justify-content-center justify-content-lg-between p-4 border-bottom">
        <!-- Left -->
        <div class="me-5 d-none d-lg-block">
          <span>Get connected with us on social networks:</span>
        </div>
        <!-- Left -->

        <!-- Right -->
        <div>
          <a href="https://www.facebook.com/tannghia.vo.9" class="me-4 link-secondary">
            <i class="bi bi-facebook"></i>
          </a>
          <a href="https://www.facebook.com/tannghia.vo.9" class="me-4 link-secondary">
            <i class="bi bi-twitter"></i>
          </a>
          <a href="https://www.facebook.com/tannghia.vo.9" class="me-4 link-secondary">
            <i class="bi bi-instagram"></i>
          </a>
          <!-- <a href="" class="me-4 link-secondary">
          <i class="fab fa-github"></i>
        </a> -->
        </div>
        <!-- Right -->
      </section>
      <!-- Section: Social media -->

      <!-- Section: Links  -->
      <section class="">
        <div class="container text-uppercase text-md-start mt-5">
          <!-- Grid row -->
          <div class="row mt-3">
            <!-- Grid column -->
            <div class="col-md-6 col-lg-6 col-xl-6 mx-auto mb-4 text-center">
              <!-- Content -->
              <h6 class="text-uppercase fw-bold mb-4">
                <i class="fas fa-gem me-3 text-center"></i>ATN Store
              </h6>
              <p>
                ATN Store is a chain of toy stores
              </p>
              <p>
                With the mission: "<i>OCÉAN FASHION is committed to bringing the best quality products
                  and services to serve customers to enhance their own style.</i>"
              </p>

            </div>

            <!-- <div class="col-md-4 col-lg-4 col-xl-4 mx-auto mb-4 text-center">
              <h6 class="text-uppercase fw-bold mb-4">
                Products
              </h6>
              <p>
                <a href="search.php?search=women&btnSearch=" class="text-reset " style="text-decoration: none;">Car</a>
              </p>
              <p>
                <a href="search.php?search=man&btnSearch=" class="text-reset" style="text-decoration: none;">Lego</a>
              </p>
            </div> -->

            <div class="col-md-6 col-lg-6 col-xl-6 mx-auto mb-4 text-center">
              <h6 class="text-uppercase fw-bold mb-4">
                Contact
              </h6>
              <p>
                <a href="search.php?search=women&btnSearch=" class="text-reset" style="text-decoration: none;">New York,
                  NY 10012, US</a>
              </p>
              <p>
                <a href="search.php?search=man&btnSearch=" class="text-reset" style="text-decoration: none;">
                  vonghia@example.com</a>
              </p>
              <p><i class="bi bi-telephone-fill"></i> + 01 234 567 88</p>
            </div>


            <!-- Grid column -->
          </div>
          <!-- Grid row -->
        </div>
      </section>
      <!-- Section: Links  -->

      <!-- Copyright -->
      <div class="text-center p-4" style="background-color: rgba(0, 0, 0, 0.025);">
        © 2021 ATN Store joint stock company:
        <a class="text-reset fw-bold" href="https://www.facebook.com/tannghia.vo.9">ATN.com</a>
      </div>
      <!-- Copyright -->
    </footer>
    <!-- Footer -->
     <script>
  
  	function checkPassword(){
		pass = document.getElementById("pass").value;
		repass = document.getElementById("repass").value;
		element = document.getElementById('myElement');
		if(pass!=repass){
			document.getElementById("errorMatchPass").innerHTML="Error match password";
			element.style.display = 'flex';
			return false;
		}
		else{
			document.getElementById("errorMatchPass").innerHTML=null;
			element.style.display = 'none';
			return true;
		}
  	}
  	

  	
  </script>
   <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/js/bootstrap.bundle.min.js"></script>
  </body>
</html>