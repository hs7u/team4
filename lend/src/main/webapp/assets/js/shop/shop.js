document.addEventListener("DOMContentLoaded", function(event) { 
	let miniCart = localStorage.getItem("cart") ? JSON.parse(localStorage.getItem("cart")) : [];
	if(miniCart != null){
		$("span.cart-count").removeClass("-none");
		$("span.cart-count").html(miniCart.length);
		}
})

$("button.add").on("click", function(e){
	let target = $(this).attr("table-target");
	let cartAll = localStorage.getItem("cart") ? JSON.parse(localStorage.getItem("cart")) : [];
	let select = {};
	select.cuatomerId = $("input[name = customerId]").val();
	select.productId = $("input."+target+"[name = productId]").val();
	select.productName = $("input."+target+"[name = productName]").val();
	select.productPrice = $("input."+target+"[name = productPrice]").val();
	select.productQuantity = $("input."+target+"[name = productQuantity]").val();
	let check = 0;
	for(let i = 0 ; i < cartAll.length; i++){
		if(cartAll[i].productId != select.productId){
			check++;
		}
		if(cartAll[i].productId == select.productId){
			console.log(cartAll[i].productQuantity)
			cartAll[i].productQuantity = parseInt(cartAll[i].productQuantity, 10) + parseInt(select.productQuantity, 10);
			cartAll[i].productPrice = select.productPrice * cartAll[i].productQuantity;
		}
	}
	if(check == cartAll.length){
		cartAll.push(select);
	}
	localStorage.setItem("cart", JSON.stringify(cartAll));
	$("span.cart-count").html(cartAll.length);
})


