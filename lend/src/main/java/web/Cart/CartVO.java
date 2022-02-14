package web.Cart;

import web.Product.vo.ProductVO;

public class CartVO extends ProductVO {
	private int quantity;

	public CartVO() {
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
}
