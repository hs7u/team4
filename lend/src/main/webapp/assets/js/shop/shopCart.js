
document.addEventListener("DOMContentLoaded", function (event) {
	
	let miniCart = localStorage.getItem("cart")!= null ? JSON.parse(localStorage.getItem("cart")) : [];
	var cartList, s_price = 0, total = 0;
		console.log(miniCart);
	if (miniCart != null) {
		$("span.cart-count").removeClass("-none");
		$("span.cart-count").html(miniCart.length);

		for (let i = 0; i < miniCart.length; i++) {
			s_price = miniCart[i].productPrice * miniCart[i].productQuantity;
			total += s_price
			cartList +=
				`<tr>
					<td class="thumbnail"><a href="product-details.html"><img src=${miniCart[i].productImage} alt="cart-product-1"></a></td>
					<td class="name"> <a href="product-details.html">${miniCart[i].productName}</a></td>
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
		}
		$(".AllMiniCart")
			.empty()
			.append(cartList);
		$(".amount").html(total);

	}
	
	//移除
    $(".btn_delete").off("click").on("click", function () {
        $(this).closest("tr").fadeOut(1000, function () {
			let check = $(this).closest("tr").find(".name").children("a").text();
			let cartAll = localStorage.getItem("cart") ? JSON.parse(localStorage.getItem("cart")) : [];
			for(let i = 0 ; i < cartAll.length; i++){
				if(cartAll[i].productName.match(check) != null){
					cartAll.splice(i,1)
				}
			}
			$(this).closest("tr").remove();
			localStorage.setItem("cart", JSON.stringify(cartAll));
        })
    })
})
