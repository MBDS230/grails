<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<meta name="description" content="">
	<meta name="author" content="">
	<title>Home | E-Shopper</title>
	<asset:stylesheet src="front/bootstrap.min.css"/>
	<asset:stylesheet src="front/font-awesome.min.css"/>
	<asset:stylesheet src="front/prettyPhoto.css"/>
	<asset:stylesheet src="front/price-range.css"/>
	<asset:stylesheet src="front/animate.css"/>
	<asset:stylesheet src="front/main.css"/>
	<asset:stylesheet src="front/responsive.css"/>
	<asset:stylesheet src="front/custom.css"/>
	<asset:stylesheet src="front/pen.css"/>
	<link rel="stylesheet prefetch" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.6.2/css/font-awesome.min.css">
	<!--[if lt IE 9]>
	<asset:javascript src="admin/html5shiv.js"/>
	<asset:javascript src="admin/respond.min.js"/>
	<![endif]-->
	<asset:link rel="shortcut icon" href="/front/icone.png" />
	<link rel="apple-touch-icon-precomposed" sizes="144x144" href="images/ico/apple-touch-icon-144-precomposed.png">
	<link rel="apple-touch-icon-precomposed" sizes="114x114" href="images/ico/apple-touch-icon-114-precomposed.png">
	<link rel="apple-touch-icon-precomposed" sizes="72x72" href="images/ico/apple-touch-icon-72-precomposed.png">
	<link rel="apple-touch-icon-precomposed" href="images/ico/apple-touch-icon-57-precomposed.png">
</head><!--/head-->

<body>
<header id="header"><!--header-->
	<div class="header-middle"><!--header-middle-->
		<div class="container">
			<div class="row">
				<div class="col-sm-4">
					<div class="logo pull-left">
						<a href="index.html">
							<asset:image class="logo" src="front/logo.png" alt="Logo"/>
						</a>
					</div>
				</div>
				<div class="col-sm-8">
					<div class="shop-menu pull-right">
						<ul class="nav navbar-nav">
							<li><a href=""><i class="fa fa-user"></i> Account</a></li>
							<li><a href="/user/logout"><i class="fa fa-unlock"></i> Logout</a></li>
						</ul>
					</div>
				</div>
			</div>
		</div>
	</div><!--/header-middle-->

	<div class="header-bottom"><!--header-bottom-->
		<div class="container">
			<div class="row">
				<div class="col-sm-12">
					<div class="navbar-header">
						<button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
							<span class="sr-only">Toggle navigation</span>
							<span class="icon-bar"></span>
							<span class="icon-bar"></span>
							<span class="icon-bar"></span>
						</button>
					</div>
					<div class="mainmenu pull-left">
						<ul class="nav navbar-nav collapse navbar-collapse">
							<li><a class="active" href="index.html">Home</a></li>
						</ul>
					</div>
				</div>
			</div>
		</div>
	</div><!--/header-bottom-->
</header><!--/header-->

<section>
	<div class="container">
		<g:if test="${inscrit==true}">
			<div class="row">
				<p class="text-primary">Vous êtes inscrit avec succès ! Vous pouvez jouer tout de suite.</p>
			</div>
		</g:if>
		<div class="row">
			<div class="col-sm-12">
				<div id="frame" class="frameChat" >
					<div id="sidepanel">
						<div id="profile">
							<div class="wrap">
								<img id="profile-img" src="${joueur.photo}" class="online" alt="" />
								<p>${joueur.login}</p>
								<i class="fa fa-chevron-down expand-button" aria-hidden="true"></i>
								<div id="status-options">
									<ul>
										<li id="status-online" class="active"><span class="status-circle"></span> <p>Online</p></li>
										<li id="status-away"><span class="status-circle"></span> <p>Away</p></li>
										<li id="status-busy"><span class="status-circle"></span> <p>Busy</p></li>
										<li id="status-offline"><span class="status-circle"></span> <p>Offline</p></li>
									</ul>
								</div>
								<div id="expanded">
									<label for="twitter"><i class="fa fa-facebook fa-fw" aria-hidden="true"></i></label>
									<input name="twitter" type="text" value="mikeross" />
									<label for="twitter"><i class="fa fa-twitter fa-fw" aria-hidden="true"></i></label>
									<input name="twitter" type="text" value="ross81" />
									<label for="twitter"><i class="fa fa-instagram fa-fw" aria-hidden="true"></i></label>
									<input name="twitter" type="text" value="mike.ross" />
								</div>
							</div>
						</div>
						<div class="title title-conversation">
							<h1>Liste connectés</h1>
						</div>
						<div id="search">
							<label for=""><i class="fa fa-search" aria-hidden="true"></i></label>
							<input type="text" placeholder="Search contacts..." />
						</div>
						<div id="contacts">
							<ul>

							</ul>
						</div>
						<div id="bottom-bar">
							<button id="addcontact"><i class="fa fa-user-plus fa-fw" aria-hidden="true"></i> <span>Add contact</span></button>
							<button id="settings"><i class="fa fa-cog fa-fw" aria-hidden="true"></i> <span>Settings</span></button>
						</div>
					</div>
					<div class="content contentJouer hide">
						<h1>Jeu avec adversaire</h1>
						<a href="/user/jouer">
							<button class="btn btn-success">Jouer</button>
						</a>
					</div>
				</div>
			</div>
		</div>
		</br>
		<div class="row">
			<div class="col-sm-6">
				<section id="cart_items">
					<div class="table-responsive cart_info">
						<h2>Liste des demandes des adversaires</h2>
						<table class="table table-condensed">
							<thead>
							<tr class="cart_menu">
								<th>Id Demande</th>
								<th>Adversaire</th>
								<th>Date</th>
								<th>Acceptation</th>
							</tr>
							</thead>
							<tbody>
							<tr>
								<td>
									1
								</td>
								<td>
									Colorblock Scuba
								</td>
								<td>
									22.11.2018
								</td>
								<td>
									<button class="btn btn-primary">Accepter</button>
								</td>
							</tr>

							<tr>
								<td>
									1
								</td>
								<td>
									Colorblock Scuba
								</td>
								<td>
									22.11.2018
								</td>
								<td>
									<button class="btn btn-primary">Accepter</button>
								</td>
							</tr>

							</tbody>
						</table>
					</div>
				</section>
			</div>
			<div class="col-sm-6">
				<section id="cart_items">
					<div class="table-responsive cart_info">
						<h2>Liste de mes demandes</h2>
						<table class="table table-condensed">
							<thead>
							<tr class="cart_menu">
								<th>Id Demande</th>
								<th>Adversaire</th>
								<th>Date</th>
								<th>Annulation</th>
							</tr>
							</thead>
							<tbody>
							<tr>
								<td>
									1
								</td>
								<td>
									Colorblock Scuba
								</td>
								<td>
									22.11.2018
								</td>
								<td>
									<button class="btn btn-primary">Annuler</button>
								</td>
							</tr>

							<tr>
								<td>
									1
								</td>
								<td>
									Colorblock Scuba
								</td>
								<td>
									22.11.2018
								</td>
								<td>
									<button class="btn btn-primary">Annuler</button>
								</td>
							</tr>

							</tbody>
						</table>
					</div>
				</section>
			</div>
		</div>
	</div>
</section>


<footer id="footer"><!--Footer-->
	<div class="footer-top">
		<div class="container">
			<div class="row">
				<div class="col-sm-2">
					<div class="companyinfo">
						<h2><span>e</span>-shopper</h2>
						<p>Lorem ipsum dolor sit amet, consectetur adipisicing elit,sed do eiusmod tempor</p>
					</div>
				</div>
				<div class="col-sm-7">
					<div class="col-sm-3">
						<div class="video-gallery text-center">
							<a href="#">
								<div class="iframe-img">
									<img src="images/home/iframe1.png" alt="" />
								</div>
								<div class="overlay-icon">
									<i class="fa fa-play-circle-o"></i>
								</div>
							</a>
							<p>Circle of Hands</p>
							<h2>24 DEC 2014</h2>
						</div>
					</div>

					<div class="col-sm-3">
						<div class="video-gallery text-center">
							<a href="#">
								<div class="iframe-img">
									<img src="images/home/iframe2.png" alt="" />
								</div>
								<div class="overlay-icon">
									<i class="fa fa-play-circle-o"></i>
								</div>
							</a>
							<p>Circle of Hands</p>
							<h2>24 DEC 2014</h2>
						</div>
					</div>

					<div class="col-sm-3">
						<div class="video-gallery text-center">
							<a href="#">
								<div class="iframe-img">
									<img src="images/home/iframe3.png" alt="" />
								</div>
								<div class="overlay-icon">
									<i class="fa fa-play-circle-o"></i>
								</div>
							</a>
							<p>Circle of Hands</p>
							<h2>24 DEC 2014</h2>
						</div>
					</div>

					<div class="col-sm-3">
						<div class="video-gallery text-center">
							<a href="#">
								<div class="iframe-img">
									<img src="images/home/iframe4.png" alt="" />
								</div>
								<div class="overlay-icon">
									<i class="fa fa-play-circle-o"></i>
								</div>
							</a>
							<p>Circle of Hands</p>
							<h2>24 DEC 2014</h2>
						</div>
					</div>
				</div>
				<div class="col-sm-3">
					<div class="address">
						<img src="images/home/map.png" alt="" />
						<p>505 S Atlantic Ave Virginia Beach, VA(Virginia)</p>
					</div>
				</div>
			</div>
		</div>
	</div>

	<div class="footer-widget">
		<div class="container">
			<div class="row">
				<div class="col-sm-2">
					<div class="single-widget">
						<h2>Service</h2>
						<ul class="nav nav-pills nav-stacked">
							<li><a href="">Online Help</a></li>
							<li><a href="">Contact Us</a></li>
							<li><a href="">Order Status</a></li>
							<li><a href="">Change Location</a></li>
							<li><a href="">FAQ’s</a></li>
						</ul>
					</div>
				</div>
				<div class="col-sm-2">
					<div class="single-widget">
						<h2>Quock Shop</h2>
						<ul class="nav nav-pills nav-stacked">
							<li><a href="">T-Shirt</a></li>
							<li><a href="">Mens</a></li>
							<li><a href="">Womens</a></li>
							<li><a href="">Gift Cards</a></li>
							<li><a href="">Shoes</a></li>
						</ul>
					</div>
				</div>
				<div class="col-sm-2">
					<div class="single-widget">
						<h2>Policies</h2>
						<ul class="nav nav-pills nav-stacked">
							<li><a href="">Terms of Use</a></li>
							<li><a href="">Privecy Policy</a></li>
							<li><a href="">Refund Policy</a></li>
							<li><a href="">Billing System</a></li>
							<li><a href="">Ticket System</a></li>
						</ul>
					</div>
				</div>
				<div class="col-sm-2">
					<div class="single-widget">
						<h2>About Shopper</h2>
						<ul class="nav nav-pills nav-stacked">
							<li><a href="">Company Information</a></li>
							<li><a href="">Careers</a></li>
							<li><a href="">Store Location</a></li>
							<li><a href="">Affillate Program</a></li>
							<li><a href="">Copyright</a></li>
						</ul>
					</div>
				</div>
				<div class="col-sm-3 col-sm-offset-1">
					<div class="single-widget">
						<h2>About Shopper</h2>
						<form action="#" class="searchform">
							<input type="text" placeholder="Your email address" />
							<button type="submit" class="btn btn-default"><i class="fa fa-arrow-circle-o-right"></i></button>
							<p>Get the most recent updates from <br />our site and be updated your self...</p>
						</form>
					</div>
				</div>

			</div>
		</div>
	</div>

	<div class="footer-bottom">
		<div class="container">
			<div class="row">
				<p class="pull-left">Copyright © 2013 E-SHOPPER Inc. All rights reserved.</p>
				<p class="pull-right">Designed by <span><a target="_blank" href="http://www.themeum.com">Themeum</a></span></p>
			</div>
		</div>
	</div>

</footer><!--/Footer-->
<asset:javascript src="front/jquery.js"/>
<asset:javascript src="front/price-range.js"/>
<asset:javascript src="front/jquery.scrollUp.min.js"/>
<asset:javascript src="front/bootstrap.min.js"/>
<asset:javascript src="front/jquery.prettyPhoto.js"/>
<asset:javascript src="front/main.js"/>
<asset:javascript src="front/custom.js"/>
<asset:javascript src="front/pen.js"/>
<asset:javascript src="front/joueurs.js"/>
</body>
</html>