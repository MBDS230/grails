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
			<div class="col-sm-9">
				<div id="frame" class="frameChat" >
					<div id="sidepanel">
						<div id="profile">
							<div class="wrap">
								<img id="profile-img" src="http://emilcarlsson.se/assets/mikeross.png" class="online" alt="" />
								<p>Mike Ross</p>
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
					<!--<div class="content contentMessage hide">
						<div class="contact-profile">
							<img src="http://emilcarlsson.se/assets/harveyspecter.png" alt="" />
							<p>Harvey Specter</p>
							<div class="social-media">
								<i class="fa fa-facebook" aria-hidden="true"></i>
								<i class="fa fa-twitter" aria-hidden="true"></i>
								<i class="fa fa-instagram" aria-hidden="true"></i>
							</div>
						</div>
						<div class="messages">
							<ul>
								<li class="sent">
									<img src="http://emilcarlsson.se/assets/mikeross.png" alt="" />
									<p>How the hell am I supposed to get a jury to believe you when I am not even sure that I do?!</p>
								</li>
								<li class="replies">
									<img src="http://emilcarlsson.se/assets/harveyspecter.png" alt="" />
									<p>When you're backed against the wall, break the god damn thing down.</p>
								</li>
								<li class="replies">
									<img src="http://emilcarlsson.se/assets/harveyspecter.png" alt="" />
									<p>Excuses don't win championships.</p>
								</li>
								<li class="sent">
									<img src="http://emilcarlsson.se/assets/mikeross.png" alt="" />
									<p>Oh yeah, did Michael Jordan tell you that?</p>
								</li>
								<li class="replies">
									<img src="http://emilcarlsson.se/assets/harveyspecter.png" alt="" />
									<p>No, I told him that.</p>
								</li>
								<li class="replies">
									<img src="http://emilcarlsson.se/assets/harveyspecter.png" alt="" />
									<p>What are your choices when someone puts a gun to your head?</p>
								</li>
								<li class="sent">
									<img src="http://emilcarlsson.se/assets/mikeross.png" alt="" />
									<p>What are you talking about? You do what they say or they shoot you.</p>
								</li>
								<li class="replies">
									<img src="http://emilcarlsson.se/assets/harveyspecter.png" alt="" />
									<p>Wrong. You take the gun, or you pull out a bigger one. Or, you call their bluff. Or, you do any one of a hundred and forty six other things.</p>
								</li>
							</ul>
						</div>
						<div class="message-input">
							<div class="wrap">
								<input type="text" placeholder="Write your message..." />
								<i class="fa fa-paperclip attachment" aria-hidden="true"></i>
								<button class="submit"><i class="fa fa-paper-plane" aria-hidden="true"></i></button>
							</div>
						</div>
					</div>-->
				</div>
			</div>
			<div class="col-sm-3">
				<section id="cart_items">
					<div class="table-responsive cart_info">
						<table class="table table-condensed">
							<thead>
							<tr class="cart_menu">
								<td class="image">Item</td>
								<td class="description"></td>
								<td class="price">Price</td>
								<td class="quantity">Quantity</td>
								<td class="total">Total</td>
								<td></td>
							</tr>
							</thead>
							<tbody>
							<tr>
								<td class="cart_product">
									<a href=""><img src="images/cart/one.png" alt=""></a>
								</td>
								<td class="cart_description">
									<h4><a href="">Colorblock Scuba</a></h4>
									<p>Web ID: 1089772</p>
								</td>
								<td class="cart_price">
									<p>$59</p>
								</td>
								<td class="cart_quantity">
									<div class="cart_quantity_button">
										<a class="cart_quantity_up" href=""> + </a>
										<input class="cart_quantity_input" type="text" name="quantity" value="1" autocomplete="off" size="2">
										<a class="cart_quantity_down" href=""> - </a>
									</div>
								</td>
								<td class="cart_total">
									<p class="cart_total_price">$59</p>
								</td>
								<td class="cart_delete">
									<a class="cart_quantity_delete" href=""><i class="fa fa-times"></i></a>
								</td>
							</tr>

							<tr>
								<td class="cart_product">
									<a href=""><img src="images/cart/two.png" alt=""></a>
								</td>
								<td class="cart_description">
									<h4><a href="">Colorblock Scuba</a></h4>
									<p>Web ID: 1089772</p>
								</td>
								<td class="cart_price">
									<p>$59</p>
								</td>
								<td class="cart_quantity">
									<div class="cart_quantity_button">
										<a class="cart_quantity_up" href=""> + </a>
										<input class="cart_quantity_input" type="text" name="quantity" value="1" autocomplete="off" size="2">
										<a class="cart_quantity_down" href=""> - </a>
									</div>
								</td>
								<td class="cart_total">
									<p class="cart_total_price">$59</p>
								</td>
								<td class="cart_delete">
									<a class="cart_quantity_delete" href=""><i class="fa fa-times"></i></a>
								</td>
							</tr>
							<tr>
								<td class="cart_product">
									<a href=""><img src="images/cart/three.png" alt=""></a>
								</td>
								<td class="cart_description">
									<h4><a href="">Colorblock Scuba</a></h4>
									<p>Web ID: 1089772</p>
								</td>
								<td class="cart_price">
									<p>$59</p>
								</td>
								<td class="cart_quantity">
									<div class="cart_quantity_button">
										<a class="cart_quantity_up" href=""> + </a>
										<input class="cart_quantity_input" type="text" name="quantity" value="1" autocomplete="off" size="2">
										<a class="cart_quantity_down" href=""> - </a>
									</div>
								</td>
								<td class="cart_total">
									<p class="cart_total_price">$59</p>
								</td>
								<td class="cart_delete">
									<a class="cart_quantity_delete" href=""><i class="fa fa-times"></i></a>
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