<!doctype html>
<html>
<head>

<meta name="viewport" content="width=device-width, initial-scale=1">

<meta charset="utf-8">
<title>aleph</title>

<link href="style/style.css" rel="stylesheet" type="text/css">
<script src="js/jquery-3.1.0.min.js"></script>

<script>
	$(document).ready(function() {
		$('#searchbutton').click(function() {
			$('#searchbox').fadeIn('slow');
		});
	});
</script>

<script>
	var slideIndex = 1;
	showSlides(slideIndex);

	function plusSlides(n) {
		showSlides(slideIndex += n);
	}

	function currentSlide(n) {
		showSlides(slideIndex = n);
	}

	function showSlides(n) {
		var i;
		var slides = document.getElementsByClassName("mySlides");
		var dots = document.getElementsByClassName("dot");
		if (n > slides.length) {
			slideIndex = 1
		}
		if (n < 1) {
			slideIndex = slides.length
		}
		for (i = 0; i < slides.length; i++) {
			slides[i].style.display = "none";
		}
		for (i = 0; i < dots.length; i++) {
			dots[i].className = dots[i].className.replace(" active", "");
		}
		slides[slideIndex - 1].style.display = "block";
		dots[slideIndex - 1].className += " active";
	}
</script>

</head>

<body>

	<div id="mainWrapper">
		<div id="slidebar">
			<ul>
				<li><img src="img/user.svg"></li>
				<li><img src="img/cart.svg"></li>

				<li><button id="searchbutton">
						<img src="img/search.svg">
					</button></li>

				<li><input id="searchbox" name="searchbox" type="text"
					placeholder="Cerca"></input></li>
			</ul>
		</div>


		<div id="header">
			<!-- This is the header content. It contains Logo and links -->

			<div id="logo">
				<!-- <img src="logoImage.png" alt="sample logo"> -->
				LOGO
			</div>

			<div id="headerLinks">
				<ul>
					<li><a href="#" title="Catalogo">Catalogo</a></li>
					<li><a href="#" title="Novità">Novità</a></li>
					<li><a href="#" title="Autori">Autori</a></li>
					<li><a href="#" title="Eventi">Eventi</a></li>
				</ul>
			</div>
		</div>


		<div class="slideshow-container">
			<div class="mySlides fade">
				<div class="numbertext">1 / 3</div>
				<img src="img/img1.jpg" style="width: 100%">
				<div class="text">Caption Text</div>
			</div>

			<div class="mySlides fade">
				<div class="numbertext">2 / 3</div>
				<img src="img/img2.jpg" style="width: 100%">
				<div class="text">Caption Two</div>
			</div>

			<div class="mySlides fade">
				<div class="numbertext">3 / 3</div>
				<img src="img3.jpg" style="width: 100%">
				<div class="text">Caption Three</div>
			</div>

			<a class="prev" onclick="plusSlides(-1)">&#10094;</a> <a class="next"
				onclick="plusSlides(1)">&#10095;</a>
		</div>
		<br>

		<div style="text-align: center">
			<span class="dot" onclick="currentSlide(1)"></span> <span class="dot"
				onclick="currentSlide(2)"></span> <span class="dot"
				onclick="currentSlide(3)"></span>
		</div>


		<div id="content">
			<section class="sidebar">
				<!-- This adds a sidebar with 1 searchbox,2 menusets, each with 4 links -->

				<div id="menubar">
					<nav class="menu">
						<h2>
							<!-- Title for menuset 1 -->
							MENU ITEM 1
						</h2>
						<hr>
						<ul>
							<!-- List of links under menuset 1 -->
							<li><a href="#" title="Link">Link 1</a></li>
							<li><a href="#" title="Link">Link 2</a></li>
							<li><a href="#" title="Link">Link 3</a></li>
							<li class="notimp">
								<!-- notimp class is applied to remove this link from the tablet and phone views -->
								<a href="#" title="Link">Link 4</a>
							</li>
						</ul>
					</nav>
					<nav class="menu">
						<h2>MENU ITEM 2</h2>
						<!-- Title for menuset 2 -->
						<hr>
						<ul>
							<!--List of links under menuset 2 -->
							<li><a href="#" title="Link">Link 1</a></li>
							<li><a href="#" title="Link">Link 2</a></li>
							<li><a href="#" title="Link">Link 3</a></li>
							<li class="notimp">
								<!-- notimp class is applied to remove this link from the tablet and phone views -->
								<a href="#" title="Link">Link 4</a>
							</li>
						</ul>
					</nav>
				</div>
			</section>
			<section class="mainContent">
				<div class="productRow">
					<!-- Each product row contains info of 3 elements -->
					<article class="productInfo">
						<!-- Each individual product description -->
						<div>
							<img alt="sample" src="eCommerceAssets/images/200x200.png">
						</div>
						<p class="price">$50</p>
						<p class="productContent">Content holder</p>
						<input type="button" name="button" value="Buy" class="buyButton">
					</article>
					<article class="productInfo">
						<!-- Each individual product description -->
						<div>
							<img alt="sample" src="eCommerceAssets/images/200x200.png">
						</div>
						<p class="price">$50</p>
						<p class="productContent">Content holder</p>
						<input type="button" name="button" value="Buy" class="buyButton">
					</article>
					<article class="productInfo">
						<!-- Each individual product description -->
						<div>
							<img alt="sample" src="eCommerceAssets/images/200x200.png">
						</div>
						<p class="price">$50</p>
						<p class="productContent">Content holder</p>
						<input type="button" name="button" value="Buy" class="buyButton">
					</article>
				</div>
				<div class="productRow">
					<!-- Each product row contains info of 3 elements -->
					<article class="productInfo">
						<!-- Each individual product description -->
						<div>
							<img alt="sample" src="eCommerceAssets/images/200x200.png">
						</div>
						<p class="price">$50</p>
						<p class="productContent">Content holder</p>
						<input type="button" name="button" value="Buy" class="buyButton">
					</article>
					<article class="productInfo">
						<!-- Each individual product description -->
						<div>
							<img alt="sample" src="eCommerceAssets/images/200x200.png">
						</div>
						<p class="price">$50</p>
						<p class="productContent">Content holder</p>
						<input type="button" name="button" value="Buy" class="buyButton">
					</article>
					<article class="productInfo">
						<!-- Each individual product description -->
						<div>
							<img alt="sample" src="eCommerceAssets/images/200x200.png">
						</div>
						<p class="price">$50</p>
						<p class="productContent">Content holder</p>
						<input type="button" name="button" value="Buy" class="buyButton">
					</article>
				</div>
				<div class="productRow">
					<article class="productInfo">
						<!-- Each individual product description -->
						<div>
							<img alt="sample" src="eCommerceAssets/images/200x200.png">
						</div>
						<p class="price">$50</p>
						<p class="productContent">Content holder</p>
						<input type="button" name="button" value="Buy" class="buyButton">
					</article>
					<article class="productInfo">
						<!-- Each individual product description -->
						<div>
							<img alt="sample" src="eCommerceAssets/images/200x200.png">
						</div>
						<p class="price">$50</p>
						<p class="productContent">Content holder</p>
						<input type="button" name="button" value="Buy" class="buyButton">
					</article>
					<article class="productInfo">
						<!-- Each individual product description -->
						<div>
							<img alt="sample" src="eCommerceAssets/images/200x200.png">
						</div>
						<p class="price">$50</p>
						<p class="productContent">Content holder</p>
						<input type="button" name="button" value="Buy" class="buyButton">
					</article>
				</div>
			</section>
		</div>
		<footer>
			<!-- This is the footer with default 3 divs -->
			<div>
				<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit.
					Etiam varius sem neque. Integer ornare.</p>
			</div>
			<div>
				<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit.
					Etiam varius sem neque. Integer ornare.</p>
			</div>
			<div class="footerlinks">
				<p>
					<a href="#" title="Link">Link 1 </a>
				</p>
				<p>
					<a href="#" title="Link">Link 2</a>
				</p>
				<p>
					<a href="#" title="Link">Link 3</a>
				</p>
			</div>
		</footer>
	</div>


</body>