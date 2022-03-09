document.addEventListener("DOMContentLoaded", function (event) {
    let allwish = localStorage.getItem("wish") ? JSON.parse(localStorage.getItem("wish")) : [];

    for (let i = 0; i < allwish.length; i++) {

        let showWishList =
        `<tr>
            <td class="thumbnail"><a href="product-details.jsp"><img src="${allwish[i].productImage}" alt="wishlist-product-1"></a></td>
            <td class="name"> <a href="product-details.jsp">${allwish[i].productName}</a></td>
            <td class="price"><span>NT ${allwish[i].productPrice}</span></td>
            <td class="add-to-cart"><a href="#" class="btn btn-light btn-hover-dark"><i class="fal fa-shopping-cart mr-2"></i>放入購物車</a></td>
            <td class="remove wishRemove"><a href="#" class="btn">×</a></td>
        </tr>`
    $(".allWishList").append(showWishList);
    }

    //移除
	$(".wishRemove").on("click", function () {
		$(this).closest("tr").fadeOut(0, function () {
			let check = $(this).closest("tr").find(".name").children("a").text();
			let cartAll = localStorage.getItem("wish") ? JSON.parse(localStorage.getItem("wish")) : [];
			for (let i = 0; i < cartAll.length; i++) {
				if (cartAll[i].productName.match(check) != null) {
					cartAll.splice(i, 1)
				}
			}
			$(this).closest("tr").remove();
			localStorage.setItem("wish", JSON.stringify(cartAll));
			$("span.wishlist-count").html(cartAll.length);
		})
    })

    //加入購物車
	$(document).on("click",".add-to-cart", function () {
		$(this).closest("tr").fadeOut(0, function () {
			let check = $(this).closest("tr").find(".name").children("a").text();
			let wishAll = localStorage.getItem("wish") ? JSON.parse(localStorage.getItem("wish")) : [];
            let cartAll = localStorage.getItem("cart") ? JSON.parse(localStorage.getItem("cart")) : [];
            
			for (let i = 0; i < wishAll.length; i++) {
				if (wishAll[i].productName.match(check) != null) {
                    cartAll.push(wishAll[i]);
					wishAll.splice(i, 1)
				}
			}
			$(this).closest("tr").remove();
			localStorage.setItem("wish", JSON.stringify(wishAll));
            localStorage.setItem("cart", JSON.stringify(cartAll));
			$("span.wishlist-count").html(wishAll.length);
            $("span.cart-count").html(cartAll.length);
		})
        let miniCart = localStorage.getItem("cart") != null ? JSON.parse(localStorage.getItem("cart")) : [];
        let s_price = 0, total = 0;
		$(".minicart-product-list").empty();
		for (let i = 0; i < miniCart.length; i++) {
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
        $(".miniCartTotal").html(total);
    })
})