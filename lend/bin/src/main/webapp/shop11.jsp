<%@page import="org.hibernate.internal.build.AllowSysOut"%>
<%@ page contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.util.*"%>
<%@ page import="web.Product.service.ProductService"%>
<%@ page import ="org.hibernate.Session"%>
<%@ page import ="web.Product.vo.ProductVO"%>
<%@ page import ="web.Cart.CartVO"%>
<%@ page import="ProjectInterfaces.ProductInterface"%>
<%@ page import="org.springframework.context.ApplicationContext"%>
<%@ page import="org.springframework.web.context.WebApplicationContext"%>
<%@ page import="java.util.stream.Collectors"%>

<%
    ApplicationContext context = (ApplicationContext)request.getServletContext().getAttribute(WebApplicationContext.ROOT_WEB_APPLICATION_CONTEXT_ATTRIBUTE);
	ProductService psc = context.getBean(ProductService.class);
    ArrayList<ProductVO> list = psc.selectProductByCategory(11, "productPrice");
    pageContext.setAttribute("list", list);
%>

<!DOCTYPE html>
<html class="no-js" lang="en">

<head>
    <meta charset="utf-8">
    <meta http-equiv="x-ua-compatible" content="ie=edge">
    <title>studio4art – 手繪瓷盤</title>
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
    
    <link rel="stylesheet" href="assets/css/shop/shop.css">
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
    
    <meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">

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
                            <a href="#offcanvas-cart " class="offcanvas-toggle"><span class="cart-count -none"></span><i class="fal fa-shopping-cart"></i></a>
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
                            <a href="#offcanvas-cart" class="offcanvas-toggle"><span class="cart-count -none"></span><i class="fal fa-shopping-cart"></i></a>
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
                <form action="servlet/DatabaseSearch" method="post">
                    <div class="row mb-n3">
                        <div class="col-lg-8 col-12 mb-3"><input type="text" placeholder="Search Products..."></div>
                        <div class="col-lg-4 col-12 mb-3"><input type="submit" value="so easy" ></div>
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

 <!-- Slider main container Start -->
      <div class="section">
          <div class="container">
              <div class="home4-slider swiper-container">
                  <div class="swiper-wrapper">
                      <div class="home4-slide-item swiper-slide" data-swiper-autoplay="5000">
                          <div class="home4-slide-image"><img src="assets/images/slider/home4/slide-1_colorpencil.jpg" alt="Home 4 Slider Image"></div>
                          <div class="home4-slide-content">
                          		<span class="category">彩色鉛筆 / 代針筆  繪圖教學</span>
                              <h2 class="title">Q版人像畫</h2>
                             	<div class="link"><a href="courseList.html" class="btn btn-black btn-outline-hover-black">MORE</a></div>
                          </div>
                      </div>
                      <div class="home4-slide-item swiper-slide" data-swiper-autoplay="5000">
                          <div class="home4-slide-image"><img src="assets/images/slider/home4/slide-1_plant.png" alt="Home 4 Slider Image"></div>
                          <div class="home4-slide-content"><br><br><br><br><br><br>
                          <div class="link"><a href="courseList.html" class="btn btn-black btn-outline-hover-black">MORE</a></div>
                          </div>
                      </div>
                      <div class="home4-slide-item swiper-slide" data-swiper-autoplay="5000">
                          <div class="home4-slide-image"><img src="assets/images/slider/home4/slide-1_woodburn.PNG" alt="Home 4 Slider Image"></div>
                          <div class="home4-slide-content">
                          </div>
                      </div>
                  </div>
                  <div class="home4-slider-prev swiper-button-prev"><i class="ti-angle-left"></i></div>
                  <div class="home4-slider-next swiper-button-next"><i class="ti-angle-right"></i></div>
                  <div class="home4-slider-pagination swiper-pagination"></div>
              </div>
          </div>
      </div>
      <!-- Slider main container End -->

    <!-- Shop Products Section Start -->
    <div class="section section-padding pt-0">

        <!-- Shop Toolbar Start -->
        <div class="shop-toolbar border-bottom">
            <div class="container">
                <div class="row learts-mb-n20">

                    <!-- Isotop Filter Start -->
                    <div class="col-md col-12 align-self-center learts-mb-20">
                        <div class="isotope-filter shop-product-filter" data-target="#shop-products">
                            &emsp;&emsp;<a href="shoptest.jsp"><span class="menu-text">全部商品</span></a>&emsp;&emsp;&emsp;
                            <a href="shop11.jsp"><span class="menu-text">手繪瓷盤</span></a>&emsp;&emsp;&emsp;
                            <a href="shop22.jsp"><span class="menu-text">電烙畫</span></a>&emsp;&emsp;&emsp;
							<a href="shop33.jsp"><span class="menu-text">釉燒陶</span></a>&emsp;&emsp;&emsp;
							<a href="shop44.jsp"><span class="menu-text">彩色鉛筆</span></a>&emsp;&emsp;&emsp;
							<a href="shop55.jsp"><span class="menu-text">水彩</span></a>&emsp;&emsp;&emsp;
							<a href="shop66.jsp"><span class="menu-text">壓克力彩繪</span></a>
                        </div>
                    </div>
                    <!-- Isotop Filter End -->

                    <div class="col-md-auto col-12 learts-mb-20">
                        <ul class="shop-toolbar-controls">
                            <li>
                                
                            </li>
                            <li>
                                <div class="product-column-toggle d-none d-xl-flex">
                                    <button class="toggle active hintT-top" data-hint="5 項顯示" data-column="5"><i class="ti-layout-grid4-alt"></i></button>
                                    <button class="toggle hintT-top" data-hint="4 項顯示" data-column="4"><i class="ti-layout-grid3-alt"></i></button>
                                    <button class="toggle hintT-top" data-hint="3 項顯示" data-column="3"><i class="ti-layout-grid2-alt"></i></button>
                                </div>
                            </li>
                        </ul>
                    </div>
                </div>
            </div>
        </div>
        </div>
        <!-- Shop Toolbar End -->

        
  <!-- Products Start -->
        <div class="section section-padding pt-0">
        <div class="container">
			<div id="shop-products" class="products isotope-grid row row-cols-xl-5 row-cols-lg-4 row-cols-md-3 row-cols-sm-2 row-cols-1">
				<div class="grid-sizer col-1"></div>
				
				
				
			</div>
		
                <input type="hidden" name="customerId" value="${session.customerId}" style="display: none;">
                <div id="shop-products" class="products isotope-grid row row-cols-xl-5 row-cols-lg-4 row-cols-md-3 row-cols-sm-2 row-cols-1">
				<c:forEach var="p" items="${list}">
                    <div class="grid-sizer col-1"></div>

                    <div class="grid-item col featured">
                        <div class="product">
                            <div class="product-thumb">
                            <c:set var="image" scope="page" value="${p.productImage}" />
                                <a href="product-details.jsp" class="image">
                                    <img class="pic" src="data:image/png;base64,<%=Base64.getEncoder().encodeToString(((byte[])pageContext.getAttribute("image"))) %>" alt="Product Image">
                                    <img class="image-hover " src="data:image/png;base64,<%=Base64.getEncoder().encodeToString(((byte[])pageContext.getAttribute("image"))) %>" alt="Product Image">
                                </a>
                                
                            </div>
                            <div class="product-info">
                                <h6 class="title"><a href="product-details.jsp">${p.productName}</a></h6>
                                <span class="price">
                                   NT  ${p.productPrice}
                                </span>
                                <div class="product-buttons">
                                    <button href="#wishlist.html" data-bs-toggle="modal" table-target="${p.productId}" class="product-button hintT-top wishadd" data-hint="加入收藏"><i class="fal fa-heart"></i></button>
                                    <button class="product-button hintT-top add" table-target="${p.productId}" data-hint="加入購物車"><i class="fal fa-shopping-cart"></i></button>
                                    <button href="#" class="product-button hintT-top" data-hint="加入比較"><i class="fal fa-random"></i></button>
                                </div>
                            </div>
                    </div>
                        <FORM style="display: none;">
                        
							<input type="hidden" class="${p.productId}" name="productId" value="${p.productId}">
							<input type="hidden" class="${p.productId}" name="productName" value="${p.productName}">
							<input type="hidden" class="${p.productId}" name="productPrice" value="${p.productPrice}">
							<input type="hidden" class="${p.productId}" name="productQuantity" value="1">
						</FORM>
                        </div>
		</c:forEach>
                    </div>
                    </div>
        
		
	</div>


	<!-- Shop Products Section End -->
    
     <!-- Separator -->
      <div class="section">
          <div class="container">
              <hr class="m-0">
          </div>
      </div>
      <!-- Separator -->
  
      <!-- Separator -->
      <div class="section">
          <div class="container">
              <hr class="m-0">
          </div>
      </div>
      <!-- Separator -->
  
  
      <!-- Separator -->
      <div class="section">
          <div class="container">
              <hr class="m-0">
          </div>
      </div>
      <!-- Separator -->
  
<!-- Gallery Section Start -->
      <div class="section section-padding pt-0">
          <div class="container">
              <div class="row row-cols-lg-2 row-cols-1 learts-mb-n50">
 
                  <div class="col align-self-center learts-mb-50 order-lg-2">
                      <div class="section-title3 text-center m-0" data-bg-image="assets/images/title/title-3.webp">
                          <h2 class="title">Follow us on Facebook</h2>
                          <p class="desc">@studio4art</p>
                      </div>
                  </div>

                 <div class="col learts-mb-50">
<!--                       <div id="instafeed" class="instafeed instafeed-carousel instafeed-carousel2"></div> -->
             </div>
              </div>
          </div>
      </div>
      <!-- Gallery Section End -->
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