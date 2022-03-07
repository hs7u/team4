<%@page import="org.hibernate.internal.build.AllowSysOut"%>
<%@ page contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.util.*"%>
<%@ page import="web.Product.service.ProductService"%>
<%@ page import ="org.hibernate.Session"%>
<%@ page import ="web.Product.vo.ProductVO"%>
<%@ page import ="web.Cart.CartVO"%>
<%@ page import="ProjectInterfaces.ProductInterface"%>

<!DOCTYPE html>
<html class="no-js" lang="en">

<head>
    <meta charset="utf-8">
    <meta http-equiv="x-ua-compatible" content="ie=edge">
    <title>studio4art – 商品內容</title>
    <meta name="robots" content="noindex, follow" />
    <meta name="description" content="">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <!-- Favicon -->
    <link rel="shortcut icon" type="image/x-icon" href="assets/images/favicon.webp">

    <!-- CSS
	============================================ -->

    <!-- Vendor CSS (Bootstrap & Icon Font) -->
    <link rel="stylesheet" href="assets/css/vendor/bootstrap.min.css">
    <link rel="stylesheet" href="assets/css/vendor/font-awesome-pro.min.css">
    <link rel="stylesheet" href="assets/css/vendor/themify-icons.css">
    <link rel="stylesheet" href="assets/css/vendor/customFonts.css">

    <!-- Plugins CSS (All Plugins Files) -->
    <link rel="stylesheet" href="assets/css/plugins/select2.min.css">
    <link rel="stylesheet" href="assets/css/plugins/perfect-scrollbar.css">
    <link rel="stylesheet" href="assets/css/plugins/swiper.min.css">
    <link rel="stylesheet" href="assets/css/plugins/nice-select.css">
    <link rel="stylesheet" href="assets/css/plugins/ion.rangeSlider.min.css">
    <link rel="stylesheet" href="assets/css/plugins/photoswipe.css">
    <link rel="stylesheet" href="assets/css/plugins/photoswipe-default-skin.css">
    <link rel="stylesheet" href="assets/css/plugins/magnific-popup.css">
    <link rel="stylesheet" href="assets/css/plugins/slick.css">

    <!-- Main Style CSS -->
    <!-- <link rel="stylesheet" href="assets/css/style.css"> -->

    <!-- Use the minified version files listed below for better performance and remove the files listed above -->
    <!-- <link rel="stylesheet" href="assets/css/vendor/vendor.min.css">
    <link rel="stylesheet" href="assets/css/plugins/plugins.min.css"> -->
    <link rel="stylesheet" href="assets/css/style.min.css">

</head>

<body>

    <!-- Header Section Start -->
    <div class="header-section section section-fluid bg-white d-none d-xl-block">
        <div class="container">
            <div class="row align-items-center">

                <!-- Header Logo Start -->
                <div class="col-auto">
                    <div class="header-logo">
                        <a href="index.html"><img src="assets/images/logo/logo-2.webp" alt="studio4art Logo"></a>
                    </div>
                </div>
                <!-- Header Logo End -->

                <!-- Search Start -->
                <div class="col">
                    <nav class="site-main-menu site-main-menu-left menu-height-100 justify-content-center">
                        <ul>
                              <li class="has-children"><a href="#"><span class="menu-text">商品專區</span></a>
                                  <ul class="sub-menu">
                                      <li><a href="shoptest.jsp"><span class="menu-text">全部商品</span></a></li>
                             		<li><a href="shop11.jsp"><span class="menu-text">手繪瓷盤</span></a></li>
                             		<li><a href="shop22.jsp"><span class="menu-text">電烙畫</span></a></li>
                            		<li><a href="shop33.jsp"><span class="menu-text">釉燒陶</span></a></li>
                             		<li><a href="shop44.jsp"><span class="menu-text">彩色鉛筆</span></a></li>
                             		<li><a href="shop55.jsp"><span class="menu-text">水彩</span></a></li>
                             		<li><a href="shop66.jsp"><span class="menu-text">壓克力彩繪</span></a></li>
                                  </ul>
                              </li>
                              
                              <li class="has-children"><a href="#"><span class="menu-text">手作課程</span></a>
                                  <ul class="sub-menu">
                                              <li><a href="courseList.html"><span class="menu-text">報名課程</span></a></li>
                                   </ul>
                              </li>
                              <li class="has-children"><a href="#"><span class="menu-text">關於我們</span></a>
                                  <ul class="sub-menu">
                                      <li><a href="about-us.html"><span class="menu-text">關於studio4art</span></a></li>
                                  </ul>
                              </li>
                          </ul>
                    </nav>
                </div>
                <!-- Search End -->

                <!-- Search Start -->
                <div class="col-auto d-none d-xl-block">
                    <div class="header2-search">
                        <form action="#">
                            <input type="text" placeholder="Search...">
                            <button class="btn"><i class="far fa-search"></i></button>
                        </form>
                    </div>
                </div>
                <!-- Search End -->

                <!-- Header Tools Start -->
                <div class="col-auto">
                    <div class="header-tools justify-content-end">
                        <div class="header-login">
                            <a href="my-account.html"><i class="fal fa-user"></i></a>
                        </div>
                        <div class="header-wishlist">
                            <a href="#offcanvas-wishlist" class="offcanvas-toggle"><span class="wishlist-count">3</span><i class="fal fa-heart"></i></a>
                        </div>
                        <div class="header-cart">
                            <a href="#offcanvas-cart" class="offcanvas-toggle"><span class="cart-count">3</span><i class="fal fa-shopping-cart"></i></a>
                        </div>
                    </div>
                </div>
                <!-- Header Tools End -->

            </div>
        </div>

    </div>
    <!-- Header Section End -->

    <!-- Header Section Start -->
    <div class="sticky-header section bg-white section-fluid d-none d-xl-block">
        <div class="container">
            <div class="row align-items-center">

                <!-- Header Logo Start -->
                <div class="col-xl-auto col">
                    <div class="header-logo">
                        <a href="index.html"><img src="assets/images/logo/logo-2.webp" alt="studio4art Logo"></a>
                    </div>
                </div>
                <!-- Header Logo End -->

                <!-- Search Start -->
                <div class="col d-none d-xl-block">
                    <nav class="site-main-menu justify-content-center">
                        <ul>       
                            <li class="has-children"><a href="#"><span class="menu-text">商品專區</span></a>
                                <ul class="sub-menu">
                                      <li><a href="shoptest.jsp"><span class="menu-text">全部商品</span></a></li>
                             		<li><a href="shop11.jsp"><span class="menu-text">手繪瓷盤</span></a></li>
                             		<li><a href="shop22.jsp"><span class="menu-text">電烙畫</span></a></li>
                            		<li><a href="shop33.jsp"><span class="menu-text">釉燒陶</span></a></li>
                             		<li><a href="shop44.jsp"><span class="menu-text">彩色鉛筆</span></a></li>
                             		<li><a href="shop55.jsp"><span class="menu-text">水彩</span></a></li>
                             		<li><a href="shop66.jsp"><span class="menu-text">壓克力彩繪</span></a></li>
                                    </ul>
                            <li class="has-children"><a href=""><span class="menu-text">手作課程</span></a>
                                <ul class="sub-menu">
                                            <li><a href="courseList.html"><span class="menu-text">報名課程</span></a></li>
                               </ul>
                            </li>
                              <li class="has-children"><a href="#"><span class="menu-text">關於我們</span></a>
                                <ul class="sub-menu">
                                    <li><a href="about-us.html"><span class="menu-text">關於studio4art</span></a></li>
                                </ul>
                            </li>
                        </ul>
                    </nav>
                </div>
                <!-- Search End -->

                <!-- Search Start -->
                <div class="col-auto d-none d-xl-block">
                    <div class="header2-search">
                        <form action="#">
                            <input type="text" placeholder="Search...">
                            <button class="btn"><i class="far fa-search"></i></button>
                        </form>
                    </div>
                </div>
                <!-- Search End -->

                <!-- Header Tools Start -->
                <div class="col-auto">
                    <div class="header-tools justify-content-end">
                        <div class="header-login d-none d-sm-block">
                            <a href="my-account.html"><i class="fal fa-user"></i></a>
                        </div>
                        <div class="header-search d-none d-sm-block d-xl-none">
                            <a href="#offcanvas-search" class="offcanvas-toggle"><i class="fal fa-search"></i></a>
                        </div>
                        <div class="header-wishlist d-none d-sm-block">
                            <a href="#offcanvas-wishlist" class="offcanvas-toggle"><span class="wishlist-count">3</span><i class="fal fa-heart"></i></a>
                        </div>
                        <div class="header-cart">
                            <a href="#offcanvas-cart" class="offcanvas-toggle"><span class="cart-count">3</span><i class="fal fa-shopping-cart"></i></a>
                        </div>
                        <div class="mobile-menu-toggle d-xl-none">
                            <a href="#" class="offcanvas-toggle">
                                <svg viewBox="0 0 800 600">
                                    <path d="M300,220 C300,220 520,220 540,220 C740,220 640,540 520,420 C440,340 300,200 300,200" class="top"></path>
                                    <path d="M300,320 L540,320" class="middle"></path>
                                    <path d="M300,210 C300,210 520,210 540,210 C740,210 640,530 520,410 C440,330 300,190 300,190" class="bottom" transform="translate(480, 320) scale(1, -1) translate(-480, -318) "></path>
                                </svg>
                            </a>
                        </div>
                    </div>
                </div>
                <!-- Header Tools End -->

            </div>
        </div>

    </div>
    <!-- Header Section End -->
    <!-- Mobile Header Section Start -->
    <div class="mobile-header bg-white section d-xl-none">
        <div class="container">
            <div class="row align-items-center">

                <!-- Header Logo Start -->
                <div class="col">
                    <div class="header-logo">
                        <a href="index.html"><img src="assets/images/logo/logo-2.webp" alt="studio4art Logo"></a>
                    </div>
                </div>
                <!-- Header Logo End -->

                <!-- Header Tools Start -->
                <div class="col-auto">
                    <div class="header-tools justify-content-end">
                        <div class="header-login d-none d-sm-block">
                            <a href="my-account.html"><i class="fal fa-user"></i></a>
                        </div>
                        <div class="header-search d-none d-sm-block">
                            <a href="#offcanvas-search" class="offcanvas-toggle"><i class="fal fa-search"></i></a>
                        </div>
                        <div class="header-wishlist d-none d-sm-block">
                            <a href="#offcanvas-wishlist" class="offcanvas-toggle"><span class="wishlist-count">3</span><i class="fal fa-heart"></i></a>
                        </div>
                        <div class="header-cart">
                            <a href="#offcanvas-cart" class="offcanvas-toggle"><span class="cart-count">3</span><i class="fal fa-shopping-cart"></i></a>
                        </div>
                        <div class="mobile-menu-toggle">
                            <a href="#offcanvas-mobile-menu" class="offcanvas-toggle">
                                <svg viewBox="0 0 800 600">
                                    <path d="M300,220 C300,220 520,220 540,220 C740,220 640,540 520,420 C440,340 300,200 300,200" class="top"></path>
                                    <path d="M300,320 L540,320" class="middle"></path>
                                    <path d="M300,210 C300,210 520,210 540,210 C740,210 640,530 520,410 C440,330 300,190 300,190" class="bottom" transform="translate(480, 320) scale(1, -1) translate(-480, -318) "></path>
                                </svg>
                            </a>
                        </div>
                    </div>
                </div>
                <!-- Header Tools End -->

            </div>
        </div>
    </div>
    <!-- Mobile Header Section End -->

    <!-- Mobile Header Section Start -->
    <div class="mobile-header sticky-header bg-white section d-xl-none">
        <div class="container">
            <div class="row align-items-center">

                <!-- Header Logo Start -->
                <div class="col">
                    <div class="header-logo">
                        <a href="index.html"><img src="assets/images/logo/logo-2.webp" alt="studio4art Logo"></a>
                    </div>
                </div>
                <!-- Header Logo End -->

                <!-- Header Tools Start -->
                <div class="col-auto">
                    <div class="header-tools justify-content-end">
                        <div class="header-login d-none d-sm-block">
                            <a href="my-account.html"><i class="fal fa-user"></i></a>
                        </div>
                        <div class="header-search d-none d-sm-block">
                            <a href="#offcanvas-search" class="offcanvas-toggle"><i class="fal fa-search"></i></a>
                        </div>
                        <div class="header-wishlist d-none d-sm-block">
                            <a href="#offcanvas-wishlist" class="offcanvas-toggle"><span class="wishlist-count">3</span><i class="fal fa-heart"></i></a>
                        </div>
                        <div class="header-cart">
                            <a href="#offcanvas-cart" class="offcanvas-toggle"><span class="cart-count">3</span><i class="fal fa-shopping-cart"></i></a>
                        </div>
                        <div class="mobile-menu-toggle">
                            <a href="#offcanvas-mobile-menu" class="offcanvas-toggle">
                                <svg viewBox="0 0 800 600">
                                    <path d="M300,220 C300,220 520,220 540,220 C740,220 640,540 520,420 C440,340 300,200 300,200" class="top"></path>
                                    <path d="M300,320 L540,320" class="middle"></path>
                                    <path d="M300,210 C300,210 520,210 540,210 C740,210 640,530 520,410 C440,330 300,190 300,190" class="bottom" transform="translate(480, 320) scale(1, -1) translate(-480, -318) "></path>
                                </svg>
                            </a>
                        </div>
                    </div>
                </div>
                <!-- Header Tools End -->

            </div>
        </div>
    </div>
    <!-- Mobile Header Section End -->
    <!-- OffCanvas Search Start -->
    <div id="offcanvas-search" class="offcanvas offcanvas-search">
        <div class="inner">
            <div class="offcanvas-search-form">
                <button class="offcanvas-close">×</button>
                <form action="#">
                    <div class="row mb-n3">
                        <div class="col-lg-8 col-12 mb-3"><input type="text" placeholder="Search Products..."></div>
                        <div class="col-lg-4 col-12 mb-3">
                            <select class="search-select select2-basic">
                               <option value="0">All Categories</option>
                                <option value="11">手繪瓷盤</option>
                                <option value="22">電烙; 電烙木板畫</option>
                                <option value="33">釉燒陶; 陶藝品</option>
                                <option value="44">色鉛筆; 似顏繪; 彩色鉛筆Q版畫</option>
                                <option value="55">水彩</option>
                                <option value="66">壓克力彩繪</option>
                            </select>
                        </div>
                    </div>
                </form>
            </div>
            <p class="search-description text-body-light mt-2"> <span># Type at least 1 character to search</span> <span># Hit enter to search or ESC to close</span></p>

        </div>
    </div>
    <!-- OffCanvas Search End -->

    <!-- OffCanvas Wishlist Start -->
    <div id="offcanvas-wishlist" class="offcanvas offcanvas-wishlist">
        <div class="inner">
            <div class="head">
                <span class="title">Wishlist</span>
                <button class="offcanvas-close">×</button>
            </div>
            <div class="body customScroll">
                <ul class="minicart-product-list">
                    <li>
                        <a href="product-details.jsp" class="image"><img src="assets/images/product/cart-product-1.webp" alt="Cart product Image"></a>
                        <div class="content">
                            <a href="product-details.jsp" class="title">Walnut Cutting Board</a>
                            <span class="quantity-price">1 x <span class="amount">$100.00</span></span>
                            <a href="#" class="remove">×</a>
                        </div>
                    </li>
                    <li>
                        <a href="product-details.jsp" class="image"><img src="assets/images/product/cart-product-2.webp" alt="Cart product Image"></a>
                        <div class="content">
                            <a href="product-details.jsp" class="title">Lucky Wooden Elephant</a>
                            <span class="quantity-price">1 x <span class="amount">$35.00</span></span>
                            <a href="#" class="remove">×</a>
                        </div>
                    </li>
                    <li>
                        <a href="product-details.jsp" class="image"><img src="assets/images/product/cart-product-3.webp" alt="Cart product Image"></a>
                        <div class="content">
                            <a href="product-details.jsp" class="title">Fish Cut Out Set</a>
                            <span class="quantity-price">1 x <span class="amount">$9.00</span></span>
                            <a href="#" class="remove">×</a>
                        </div>
                    </li>
                </ul>
            </div>
            <div class="foot">
                <div class="buttons">
                    <a href="wishlist.html" class="btn btn-dark btn-hover-primary">view wishlist</a>
                </div>
            </div>
        </div>
    </div>
    <!-- OffCanvas Wishlist End -->

    <!-- OffCanvas Cart Start -->
    <div id="offcanvas-cart" class="offcanvas offcanvas-cart">
        <div class="inner">
            <div class="head">
                <span class="title">購物車</span>
                <p class="minicart-message">所有商品免運費！</p>
                <button class="offcanvas-close">×</button>
            </div>
            <div class="body customScroll" style="overflow: auto !important">
                <ul class="minicart-product-list" >
                    
                </ul>
            </div>
            <div class="foot">
                <div class="sub-total">
                    <strong>小計 :</strong>
                    <span class="miniCartTotal">$144.00</span>
                </div>
                <div class="buttons">
                    <a href="shopping-cart.jsp" class="btn btn-dark btn-hover-primary">查看購物車</a>
                    <a href="checkout.html" class="btn btn-outline-dark">前往結帳</a>
                </div>   
            </div>
        </div>
    </div>
    <!-- OffCanvas Cart End -->

    <!-- OffCanvas Search Start -->
    <div id="offcanvas-mobile-menu" class="offcanvas offcanvas-mobile-menu">
        <div class="inner customScroll">
            <div class="offcanvas-menu-search-form">
                <form action="#">
                    <input type="text" placeholder="Search...">
                    <button><i class="fal fa-search"></i></button>
                </form>
            </div>
            <div class="offcanvas-menu">
                <ul>
                      <li><a href="#"><span class="menu-text">商品專區</span></a>
                        <ul class="sub-menu">
                                <li><a href="shoptest.jsp"><span class="menu-text">全部商品</span></a></li>
                             		<li><a href="shop11.jsp"><span class="menu-text">手繪瓷盤</span></a></li>
                             		<li><a href="shop22.jsp"><span class="menu-text">電烙畫</span></a></li>
                            		<li><a href="shop33.jsp"><span class="menu-text">釉燒陶</span></a></li>
                             		<li><a href="shop44.jsp"><span class="menu-text">彩色鉛筆</span></a></li>
                             		<li><a href="shop55.jsp"><span class="menu-text">水彩</span></a></li>
                             		<li><a href="shop66.jsp"><span class="menu-text">壓克力彩繪</span></a></li>
						 </ul>
                    </li>
                    <li><a href="#"><span class="menu-text">手作課程</span></a>
                        <ul class="sub-menu">
                            <li><a href="courseList.html"><span class="menu-text">報名課程</span></a></li>
                        </ul>
                    </li>
                   <li><a href="#"><span class="menu-text">關於我們</span></a>
                        <ul class="sub-menu">
                            <li><a href="about-us.html"><span class="menu-text">關於studio4art</span></a></li>
                        </ul>
                    </li>
                </ul>
            </div>
            <div class="offcanvas-buttons">
                <div class="header-tools">
                    <div class="header-login">
                        <a href="my-account.html"><i class="fal fa-user"></i></a>
                    </div>
                    <div class="header-wishlist">
                        <a href="wishlist.html"><span>3</span><i class="fal fa-heart"></i></a>
                    </div>
                    <div class="header-cart">
                        <a href="shopping-cart.jsp"><span class="cart-count">3</span><i class="fal fa-shopping-cart"></i></a>
                    </div>
                </div>
            </div>
            <div class="offcanvas-social">
                <a href="https://www.facebook.com/fany121105/photos/"><i class="fab fa-facebook-f"></i></a>
                <a href="https://www.instagram.com/studio4arttfa105/"><i class="fab fa-instagram"></i></a>
                <a href="https://youtu.be/YF5OK4_PEJM"><i class="fab fa-youtube"></i></a>
            </div>
        </div>
    </div>
    <!-- OffCanvas Search End -->

    <div class="offcanvas-overlay"></div>

    <!-- Page Title/Header Start -->
    <div class="page-title-section section" data-bg-image="assets/images/bg/login_backgrand.png">
        <div class="container">
            <div class="row">
                <div class="col">

                    <div class="page-title">
                        <h1 class="title">Shop</h1>
                        <ul class="breadcrumb">
                            <li class="breadcrumb-item"><a href="index.html">Home</a></li>
                            <li class="breadcrumb-item"><a href="shoptest.jsp">Products</a></li>
                            <li class="breadcrumb-item active">Product detail</li>
                        </ul>
                    </div>

                </div>
            </div>
        </div>
    </div>
    <!-- Page Title/Header End -->

    <!-- Single Products Section Start -->
    <div class="section section-padding border-bottom">
        <div class="container">
            <div class="row learts-mb-n40">

                <!-- Product Images Start -->
                <div class="col-lg-6 col-12 learts-mb-40">
                    <div class="product-images">
                        <div class="product-gallery-slider">
                            <div class="product-zoom" data-image="assets/images/product/single/1/55001.jpg">
                                <img src="assets/images/product/single/1/55001.jpg" alt="">
                            </div>
                        </div>
                        <div class="product-thumb-slider">
                        </div>
                    </div>
                </div>
                <!-- Product Images End -->

                <!-- Product Summery Start -->
				<div class="col-lg-6 col-12 learts-mb-40">
					<div class="product-summery">
						<div class="product-nav">
							
						</div>
						<h3 class="name" colspan="2">色鉛筆｜客製｜手繪卡通人像</h3>
						<div class="price">價格</div>
						<div class="product-description">
						 <ul>
							<li>尺寸：8吋大小（19×14cm）材質：紙張  代針筆強調人物輪廓，寫實逗趣，特色鮮明</li>
						</ul>
						<ul>
							<li>製造方式&emsp;&emsp;手工製造</li>
							<li>商品運費&emsp;&emsp;已包含在商品價格內</li>
							<li>付款方式&emsp;&emsp;支援第三方支付 / 信用卡安全加密付款</li>
							<li>本商品為「接單訂製」。付款後，從開始製作到寄出商品為 20 個工作天。（不包含假日）</li>
						</ul>
						</div>
						<div class="product-variations">
							<table>
								<tbody>
									<tr>
										<td class="label"><span>&emsp;&emsp;數量</span></td>
										<td class="value">
											<div class="product-quantity">
												<span class="qty-btn minus"><i class="ti-minus"></i></span>
												<input type="text" class="input-qty" value="1"> <span
													class="qty-btn plus"><i class="ti-plus"></i></span>
											</div>
										</td>
									</tr>
								</tbody>
							</table>
						</div>
						<div class="product-buttons">
							<a href="#" class="btn btn-icon btn-outline-body btn-hover-dark hintT-top" data-hint="加入收藏"><i class="fal fa-heart"></i></a>
							<a href="#" class="btn btn-light btn-hover-dark mr-3 mb-3"><i class="fal fa-shopping-cart"></i>&emsp;&emsp;加入購物車&emsp;&emsp;</a> 
						</div>

						
					</div>
				</div>
				<!-- Product Summery End -->

            </div>
        </div>

    </div>
    <!-- Single Products Section End -->

    <!-- Single Products Infomation Section Start -->
    <div class="section section-padding border-bottom">
          <div class="container">
      <ul class="nav product-info-tab-list">
          <li><a class="active" data-bs-toggle="tab" href="#tab-description">備註</a></li>
          <li><a data-bs-toggle="tab" href="#tab-pwb_tab">訂製流程</a></li>
          <li><a data-bs-toggle="tab" href="#tab-additional_information">注意事項</a></li>
      </ul>
      <div class="tab-content product-infor-tab-content">
          <div class="tab-pane fade show active" id="tab-description">
              <div class="row">
                  <div class="col-lg-10 col-12 mx-auto">
                      <p>1. 依照studio4art的作畫模式去描繪，多少會與照片有誤差，有任何疑問可以先透過連絡設計師來聊聊，開始繪製後就無法再做修改囉!</p>
                      <p>2. 作品會塗抹防霉產品，以達到商品最高品質，但售出後無法擔保商品能永久保存，所以盡量避免沾到水漬和放置陰暗濕冷的地方喔!</p>
                      <p>3. 作品版權歸studio4art所有，不得翻印、轉售、印刷於喜帖或任何商業用途中，若需要請來信討論報價喔</p>
                  </div>
              </div>
          </div>
          <div class="tab-pane fade" id="tab-pwb_tab">
              <div class="row learts-mb-n30">
                   <div class="row">
                  		<div class="col-lg-10 col-12 mx-auto">
								<p>1. 在下單前請先確認是否喜歡studio4art的畫風，一旦下單後不能因不像而要求退貨或換貨喔。</p>
                                <p>2. 一律付款後才繪製。</p>
                                <p>3. 本商品價格僅為繪製費，不含版權與著作權，請勿將作品用於logo、廣告、文宣等營利商業項目，若有其用途或需要請聯繫告知，會再另行報價，謝謝配合。</p>
                                <p>4. 會將作品放置studio4art的FB、IG等平台做範例參考喔。</p>
                                <p>5. 畫作會標記studio4art-Fany的簽名。</p>
                          </div>
                      </div>
                  </div>
              </div>
         
          <div class="tab-pane fade" id="tab-additional_information">
              <div class="row">
                   <div class="col-lg-10 col-12 mx-auto">
                       			<p>1.下單前請先透過studio4art的「聯絡我們」，確定沒問題後就可以直接下單，並提供1張想繪製的照片(提供照片須知 : 清晰、光線充足、姿勢明確)。</p>
                                <p>2. 在您完成付款後開始繪製，繪製時間約20個工作天(不含假日)。</p>
                                <p>3. 商品寄出後的運送時間會依照貨運的工作天數，所以studio4art無法準確告知您貨物到達時間或是任何意外，但會密切關注送貨狀況，讓商品能順利送達。</p>
                       
                      </div>
                  </div>
              </div>
      </div>
  </div>

    <!-- Single Products Infomation Section End -->

    <!-- Recommended Products Section Start 
    <div class="section section-padding">
        <div class="container">

            <!-- Section Title Start 
            <div class="section-title2 text-center">
                <h2 class="title">You Might Also Like</h2>
            </div>
            Section Title End -->

            <!-- Products Start 
            <div class="product-carousel">

                <div class="col">
                    <div class="product">
                        <div class="product-thumb">
                            <a href="product-details.jsp" class="image">
                                <span class="product-badges">
                                    <span class="onsale">-13%</span>
                                </span>
                                <img src="assets/images/product/s270/product-1.webp" alt="Product Image">
                                <img class="image-hover " src="assets/images/product/s270/product-1-hover.webp" alt="Product Image">
                            </a>
                            <a href="wishlist.html" class="add-to-wishlist hintT-left" data-hint="Add to wishlist"><i class="far fa-heart"></i></a>
                        </div>
                        <div class="product-info">
                            <h6 class="title"><a href="product-details.jsp">Boho Beard Mug</a></h6>
                            <span class="price">
                                <span class="old">$45.00</span>
                            <span class="new">$39.00</span>
                            </span>
                            <div class="product-buttons">
                                <a href="#quickViewModal" data-bs-toggle="modal" class="product-button hintT-top" data-hint="Quick View"><i class="fal fa-search"></i></a>
                                <a href="#" class="product-button hintT-top" data-hint="Add to Cart"><i class="fal fa-shopping-cart"></i></a>
                                <a href="#" class="product-button hintT-top" data-hint="Compare"><i class="fal fa-random"></i></a>
                            </div>
                        </div>
                    </div>
                </div>

                <div class="col">
                    <div class="product">
                        <div class="product-thumb">
                            <a href="product-details.jsp" class="image">
                                <img src="assets/images/product/s270/product-2.webp" alt="Product Image">
                                <img class="image-hover " src="assets/images/product/s270/product-2-hover.webp" alt="Product Image">
                            </a>
                            <a href="wishlist.html" class="add-to-wishlist hintT-left" data-hint="Add to wishlist"><i class="far fa-heart"></i></a>
                        </div>
                        <div class="product-info">
                            <h6 class="title"><a href="product-details.jsp">Motorized Tricycle</a></h6>
                            <span class="price">
                                $35.00
                            </span>
                            <div class="product-buttons">
                                <a href="#quickViewModal" data-bs-toggle="modal" class="product-button hintT-top" data-hint="Quick View"><i class="fal fa-search"></i></a>
                                <a href="#" class="product-button hintT-top" data-hint="Add to Cart"><i class="fal fa-shopping-cart"></i></a>
                                <a href="#" class="product-button hintT-top" data-hint="Compare"><i class="fal fa-random"></i></a>
                            </div>
                        </div>
                    </div>
                </div>

                <div class="col">
                    <div class="product">
                        <div class="product-thumb">
                            <span class="product-badges">
                                <span class="hot">hot</span>
                            </span>
                            <a href="product-details.jsp" class="image">
                                <img src="assets/images/product/s270/product-3.webp" alt="Product Image">
                                <img class="image-hover " src="assets/images/product/s270/product-3-hover.webp" alt="Product Image">
                            </a>
                            <a href="wishlist.html" class="add-to-wishlist hintT-left" data-hint="Add to wishlist"><i class="far fa-heart"></i></a>
                        </div>
                        <div class="product-info">
                            <h6 class="title"><a href="product-details.jsp">Walnut Cutting Board</a></h6>
                            <span class="price">
                                $100.00
                            </span>
                            <div class="product-buttons">
                                <a href="#quickViewModal" data-bs-toggle="modal" class="product-button hintT-top" data-hint="Quick View"><i class="fal fa-search"></i></a>
                                <a href="#" class="product-button hintT-top" data-hint="Add to Cart"><i class="fal fa-shopping-cart"></i></a>
                                <a href="#" class="product-button hintT-top" data-hint="Compare"><i class="fal fa-random"></i></a>
                            </div>
                        </div>
                    </div>
                </div>

                <div class="col">
                    <div class="product">
                        <div class="product-thumb">
                            <a href="product-details.jsp" class="image">
                                <span class="product-badges">
                                    <span class="onsale">-27%</span>
                                </span>
                                <img src="assets/images/product/s270/product-4.webp" alt="Product Image">
                                <img class="image-hover " src="assets/images/product/s270/product-4-hover.webp" alt="Product Image">
                            </a>
                            <a href="wishlist.html" class="add-to-wishlist hintT-left" data-hint="Add to wishlist"><i class="far fa-heart"></i></a>
                        </div>
                        <div class="product-info">
                            <h6 class="title"><a href="product-details.jsp">Pizza Plate Tray</a></h6>
                            <span class="price">
                                <span class="old">$30.00</span>
                            <span class="new">$22.00</span>
                            </span>
                            <div class="product-buttons">
                                <a href="#quickViewModal" data-bs-toggle="modal" class="product-button hintT-top" data-hint="Quick View"><i class="fal fa-search"></i></a>
                                <a href="#" class="product-button hintT-top" data-hint="Add to Cart"><i class="fal fa-shopping-cart"></i></a>
                                <a href="#" class="product-button hintT-top" data-hint="Compare"><i class="fal fa-random"></i></a>
                            </div>
                        </div>
                    </div>
                </div>

                <div class="col">
                    <div class="product">
                        <div class="product-thumb">
                            <a href="product-details.jsp" class="image">
                                <img src="assets/images/product/s270/product-5.webp" alt="Product Image">
                                <img class="image-hover " src="assets/images/product/s270/product-5-hover.webp" alt="Product Image">
                            </a>
                            <a href="wishlist.html" class="add-to-wishlist hintT-left" data-hint="Add to wishlist"><i class="far fa-heart"></i></a>
                            <div class="product-options">
                                <ul class="colors">
                                    <li style="background-color: #c2c2c2;">color one</li>
                                    <li style="background-color: #374140;">color two</li>
                                    <li style="background-color: #8ea1b2;">color three</li>
                                </ul>
                                <ul class="sizes">
                                    <li>Large</li>
                                    <li>Medium</li>
                                    <li>Small</li>
                                </ul>
                            </div>
                        </div>
                        <div class="product-info">
                            <h6 class="title"><a href="product-details.jsp">Minimalist Ceramic Pot</a></h6>
                            <span class="price">
                                $120.00
                            </span>
                            <div class="product-buttons">
                                <a href="#quickViewModal" data-bs-toggle="modal" class="product-button hintT-top" data-hint="Quick View"><i class="fal fa-search"></i></a>
                                <a href="#" class="product-button hintT-top" data-hint="Add to Cart"><i class="fal fa-shopping-cart"></i></a>
                                <a href="#" class="product-button hintT-top" data-hint="Compare"><i class="fal fa-random"></i></a>
                            </div>
                        </div>
                    </div>
                </div>

                <div class="col">
                    <div class="product">
                        <div class="product-thumb">
                            <a href="product-details.jsp" class="image">
                                <img src="assets/images/product/s270/product-6.webp" alt="Product Image">
                                <img class="image-hover " src="assets/images/product/s270/product-6-hover.webp" alt="Product Image">
                            </a>
                            <a href="wishlist.html" class="add-to-wishlist hintT-left" data-hint="Add to wishlist"><i class="far fa-heart"></i></a>
                        </div>
                        <div class="product-info">
                            <h6 class="title"><a href="product-details.jsp">Clear Silicate Teapot</a></h6>
                            <span class="price">
                                $140.00
                            </span>
                            <div class="product-buttons">
                                <a href="#quickViewModal" data-bs-toggle="modal" class="product-button hintT-top" data-hint="Quick View"><i class="fal fa-search"></i></a>
                                <a href="#" class="product-button hintT-top" data-hint="Add to Cart"><i class="fal fa-shopping-cart"></i></a>
                                <a href="#" class="product-button hintT-top" data-hint="Compare"><i class="fal fa-random"></i></a>
                            </div>
                        </div>
                    </div>
                </div>

                <div class="col">
                    <div class="product">
                        <div class="product-thumb">
                            <a href="product-details.jsp" class="image">
                                <span class="product-badges">
                                    <span class="hot">hot</span>
                                </span>
                                <img src="assets/images/product/s270/product-7.webp" alt="Product Image">
                                <img class="image-hover " src="assets/images/product/s270/product-7-hover.webp" alt="Product Image">
                            </a>
                            <a href="wishlist.html" class="add-to-wishlist hintT-left" data-hint="Add to wishlist"><i class="far fa-heart"></i></a>
                        </div>
                        <div class="product-info">
                            <h6 class="title"><a href="product-details.jsp">Lucky Wooden Elephant</a></h6>
                            <span class="price">
                                $35.00
                            </span>
                            <div class="product-buttons">
                                <a href="#quickViewModal" data-bs-toggle="modal" class="product-button hintT-top" data-hint="Quick View"><i class="fal fa-search"></i></a>
                                <a href="#" class="product-button hintT-top" data-hint="Add to Cart"><i class="fal fa-shopping-cart"></i></a>
                                <a href="#" class="product-button hintT-top" data-hint="Compare"><i class="fal fa-random"></i></a>
                            </div>
                        </div>
                    </div>
                </div>

                <div class="col">
                    <div class="product">
                        <div class="product-thumb">
                            <a href="product-details.jsp" class="image">
                                <span class="product-badges">
                                    <span class="outofstock"><i class="fal fa-frown"></i></span>
                                <span class="hot">hot</span>
                                </span>
                                <img src="assets/images/product/s270/product-8.webp" alt="Product Image">
                                <img class="image-hover " src="assets/images/product/s270/product-8-hover.webp" alt="Product Image">
                            </a>
                            <a href="wishlist.html" class="add-to-wishlist hintT-left" data-hint="Add to wishlist"><i class="far fa-heart"></i></a>
                            <div class="product-options">
                                <ul class="colors">
                                    <li style="background-color: #000000;">color one</li>
                                    <li style="background-color: #b2483c;">color two</li>
                                </ul>
                                <ul class="sizes">
                                    <li>Large</li>
                                    <li>Medium</li>
                                    <li>Small</li>
                                </ul>
                            </div>
                        </div>
                        <div class="product-info">
                            <h6 class="title"><a href="product-details.jsp">Decorative Christmas Fox</a></h6>
                            <span class="price">
                                $50.00
                            </span>
                            <div class="product-buttons">
                                <a href="#quickViewModal" data-bs-toggle="modal" class="product-button hintT-top" data-hint="Quick View"><i class="fal fa-search"></i></a>
                                <a href="#" class="product-button hintT-top" data-hint="Add to Cart"><i class="fal fa-shopping-cart"></i></a>
                                <a href="#" class="product-button hintT-top" data-hint="Compare"><i class="fal fa-random"></i></a>
                            </div>
                        </div>
                    </div>
                </div>

            </div>
            Products End -->

        </div>
    </div>
    <!-- Recommended Products Section End -->

    <div class="footer2-section section section-padding">
        <div class="container">
            <div class="row learts-mb-n40">

                <div class="col-lg-6 learts-mb-40">
                    <div class="widget-about">
                        <img src="assets/images/logo/logo-2.webp" alt="">
                         <p>為我們的生活點綴，挪出一些時間與空間相互分享創作的樂趣與想法，願能成為更好的自己</p>
                    </div>
                </div>

                <div class="col-lg-4 learts-mb-40">
                    <div class="row">
                        <div class="col">
                            <ul class="widget-list">
                                <li><a href="about-us.html">關於我們</a></li>
                                <li><a href="contact-us.html">聯絡我們</a></li>
                                <li><a href="element-termsofservice.html">服務條款</a></li>
                            </ul>
                        </div>
                        <div class="col">
                            <ul class="widget-list">
                                <li><a href="elements-faq.html">問與答</a></li>
                                <li><a href="element-return.html">退貨政策</a></li>
                                <li><a href="index.html">回到首頁</a></li>
                            </ul>
                        </div>
                    </div>
                </div>

                <div class="col-lg-2 learts-mb-40">
                    <ul class="widget-list">
                        <li> <i class="fab fa-facebook-f"></i> <a href="https://www.facebook.com/fany121105/photos/">Facebook</a></li>
                        <li> <i class="fab fa-instagram"></i> <a href="https://www.instagram.com/studio4arttfa105/">Instagram</a></li>
                        <li> <i class="fab fa-youtube"></i> <a href="https://youtu.be/YF5OK4_PEJM">Youtube</a></li>
                    </ul>
                </div>
            </div>
        </div>
    </div>

    <div class="footer2-copyright section">
        <div class="container">
            <p class="copyright text-center">&copy; 2022 studio4art All Rights Reserved</p>
        </div>
    </div>
    

    <!-- JS
============================================ -->

    <!-- Vendors JS -->
    <script src="assets/js/vendor/modernizr-3.6.0.min.js"></script>
    <script src="assets/js/vendor/jquery-3.4.1.min.js"></script>
    <script src="assets/js/vendor/jquery-migrate-3.1.0.min.js"></script>
    <script src="assets/js/vendor/bootstrap.bundle.min.js"></script>

    <!-- Plugins JS -->
    
    <script src="assets/js/shop/shop.js"></script>
    <script src="assets/js/plugins/select2.min.js"></script>
    <script src="assets/js/plugins/jquery.nice-select.min.js"></script>
    <script src="assets/js/plugins/perfect-scrollbar.min.js"></script>
    <script src="assets/js/plugins/swiper.min.js"></script>
    <script src="assets/js/plugins/slick.min.js"></script>
    <script src="assets/js/plugins/mo.min.js"></script>
    <script src="assets/js/plugins/jquery.ajaxchimp.min.js"></script>
    <script src="assets/js/plugins/jquery.countdown.min.js"></script>
    <script src="assets/js/plugins/imagesloaded.pkgd.min.js"></script>
    <script src="assets/js/plugins/isotope.pkgd.min.js"></script>
    <script src="assets/js/plugins/jquery.matchHeight-min.js"></script>
    <script src="assets/js/plugins/ion.rangeSlider.min.js"></script>
    <script src="assets/js/plugins/photoswipe.min.js"></script>
    <script src="assets/js/plugins/photoswipe-ui-default.min.js"></script>
    <script src="assets/js/plugins/jquery.zoom.min.js"></script>
    <script src="assets/js/plugins/ResizeSensor.js"></script>
    <script src="assets/js/plugins/jquery.sticky-sidebar.min.js"></script>
    <script src="assets/js/plugins/product360.js"></script>
    <script src="assets/js/plugins/jquery.magnific-popup.min.js"></script>
    <script src="assets/js/plugins/jquery.scrollUp.min.js"></script>
    <script src="assets/js/plugins/scrollax.min.js"></script>
    <script src="assets/js/plugins/instafeed.min.js"></script>

    <!-- Use the minified version files listed below for better performance and remove the files listed above -->
    <!-- <script src="assets/js/vendor/vendor.min.js"></script>
<script src="assets/js/plugins/plugins.min.js"></script> -->

    <!-- Main Activation JS -->
    <script src="assets/js/main.js"></script>

</body>

</html>