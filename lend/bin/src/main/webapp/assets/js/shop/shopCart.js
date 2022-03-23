
document.addEventListener("DOMContentLoaded", function (event) {

	let miniCart = localStorage.getItem("cart") != null ? JSON.parse(localStorage.getItem("cart")) : [];
	let wishAll = localStorage.getItem("wish") ? JSON.parse(localStorage.getItem("wish")) : [];
	let cartList, s_price = 0, total = 0;
	console.log(miniCart);
	if (miniCart != null) {
		$("span.cart-count").removeClass("-none");
		$("span.cart-count").html(miniCart.length);

		showProduct();
	}
	if (miniCart != null) {
	$("span.wishlist-count").html(wishAll.length);
	}
	//移除
	$(document).off("click").on("click",".btn_delete", function () {
		$(this).closest("tr").fadeOut(0, function () {
			let check = $(this).closest("tr").find(".name").children("a").text();
			let cartAll = localStorage.getItem("cart") ? JSON.parse(localStorage.getItem("cart")) : [];
			for (let i = 0; i < cartAll.length; i++) {
				if (cartAll[i].productName.match(check) != null) {
					cartAll.splice(i, 1)
				}
			}
			$(this).closest("tr").remove();
			localStorage.setItem("cart", JSON.stringify(cartAll));
			$("span.cart-count").html(cartAll.length);
		})
		let miniCart = localStorage.getItem("cart") ? JSON.parse(localStorage.getItem("cart")) : [];
		$(".minicart-product-list").empty();
		total = 0,s_price=0;
		for(let i=0;i<miniCart.length;i++){
			s_price = miniCart[i].productPrice * miniCart[i].productQuantity;
			total += s_price
			let littleCartList =
				`<li>
					<a href="product-details.jsp" class="image"><img src=${miniCart[i].productImage} alt="Cart product Image"></a>
					<div class="content">
						<a href="product-details.jsp" class="title miniCartName">${miniCart[i].productName}</a>
						<span class="quantity-price">${miniCart[i].productQuantity} x <span>$ ${miniCart[i].productPrice}</span></span>
						<a href="#" class="remove miniRemove">×</a>
					</div>
				</li>`

				$(".minicart-product-list").append(littleCartList);
		}
		$(".amount").html(total);
	})
	
	

	//移除miniCart
	$(document).on("click",".miniRemove", function () {
		$(this).closest("li").fadeOut(0, function () {
			let check = $(this).closest("li").find(".miniCartName").text();
			let miniCart = localStorage.getItem("cart") ? JSON.parse(localStorage.getItem("cart")) : [];
			for (let i = 0; i < miniCart.length; i++) {
				if (miniCart[i].productName.match(check) != null) {
					miniCart.splice(i, 1)
				}
			}
			$(this).closest("li").remove();
			localStorage.setItem("cart", JSON.stringify(miniCart));
			$("span.cart-count").html(miniCart.length);
		})

		let miniCart = localStorage.getItem("cart") ? JSON.parse(localStorage.getItem("cart")) : [];
		$(".AllMiniCart").empty();
		total = 0,s_price=0;
		for(let i=0;i<miniCart.length;i++){
			s_price = miniCart[i].productPrice * miniCart[i].productQuantity;
			total += s_price
			cartList =
				`<tr>
					<td class="thumbnail"><a href="product-details.jsp"><img src=${miniCart[i].productImage} alt="cart-product-1"></a></td>
					<td class="name"> <a href="product-details.jsp">${miniCart[i].productName}</a></td>
					<td class="price"><span>NT ${miniCart[i].productPrice}</span></td>
					<td class="quantity">
						<div class="product-quantity">
							<span class="qty-btn minus"><i class="ti-minus"></i></span>
							<input type="text" class="input-qty" value="${miniCart[i].productQuantity}">
							<span class="qty-btn plus"><i class="ti-plus"></i></span>
						</div>
					</td>
					<td class="subtotal"><span>NT ${s_price}</span></td>
					<td><input type="file" name="customer_upload_img" id=""></td>
					<td class="remove"><a herf="#" class="btn_delete">×</a></td>
				</tr>`

				$(".AllMiniCart").append(cartList);
		}
		$(".amount").html(total);
	})

	//控制購物車加減
	$(document).on('click','.qty-btn', function () {
        var oldValue = $(this).siblings('input').val();
		console.log(oldValue);
        if ($(this).hasClass('plus')) {
            var newVal = parseInt(oldValue) + 1;
        } else {
            if (oldValue > 1) {
                var newVal = parseInt(oldValue) - 1;
            } else {
                newVal = 1;
            }
        }
		let check = $(this).closest("tr").find(".name").children("a").text();
		let miniCart = localStorage.getItem("cart") ? JSON.parse(localStorage.getItem("cart")) : [];
		for (let i = 0; i < miniCart.length; i++) {
			if (miniCart[i].productName.match(check) != null) {
				miniCart[i].productQuantity = newVal;
			}
		}
		localStorage.setItem("cart", JSON.stringify(miniCart));
		showProduct();
    });
	
})
/* <div class="product-quantity"> -->
<!--                                     <span class="qty-btn minus"><i class="ti-minus"></i></span> -->
<!--                                     <input type="text" class="input-qty" value="1"> -->
<!--                                     <span class="qty-btn plus"><i class="ti-plus"></i></span> -->
<!--                                 </div> --> */


function showProduct(){
		let miniCart = localStorage.getItem("cart") != null ? JSON.parse(localStorage.getItem("cart")) : [];
		let cartList, s_price = 0, total = 0;
		$(".minicart-product-list").empty();
		for (let i = 0; i < miniCart.length; i++) {
			s_price = miniCart[i].productPrice * miniCart[i].productQuantity;
			total += s_price
			cartList +=
				`<tr>
					<td class="thumbnail"><a href="product-details.jsp"><img src=${miniCart[i].productImage} alt="cart-product-1"></a></td>
					<td class="name"> <a href="product-details.jsp">${miniCart[i].productName}</a></td>
					<td class="price"><span>NT ${miniCart[i].productPrice}</span></td>
					<td class="quantity">
						<div class="product-quantity">
							<span class="qty-btn minus"><i class="ti-minus"></i></span>
							<input type="text" class="input-qty" value="${miniCart[i].productQuantity}">
							<span class="qty-btn plus"><i class="ti-plus"></i></span>
						</div>
					</td>
					<td class="subtotal"><span>NT ${s_price}</span></td>
					<td><input type="file" name="customer_upload_img" id=""></td>
					<td class="remove"><a herf="#" class="btn_delete">×</a></td>
				</tr>`
			let littleCartList =
				`<li>
					<a href="product-details.jsp" class="image"><img src=${miniCart[i].productImage} alt="Cart product Image"></a>
					<div class="content">
						<a href="product-details.jsp" class="title miniCartName">${miniCart[i].productName}</a>
						<span class="quantity-price">${miniCart[i].productQuantity} x <span>$ ${miniCart[i].productPrice}</span></span>
						<a href="#" class="remove miniRemove">×</a>
					</div>
				</li>`

				$(".minicart-product-list").append(littleCartList);
		}
		$(".AllMiniCart")
			.empty()
			.append(cartList);
		$(".amount").html(total);
}