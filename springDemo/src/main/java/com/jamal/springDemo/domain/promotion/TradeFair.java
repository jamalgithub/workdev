package com.jamal.springDemo.domain.promotion;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.jamal.springDemo.domain.product.ConsumerProduct;
import com.jamal.springDemo.domain.product.IndustrialProduct;

@Component("myfair")
public class TradeFair {
	
	@Autowired
	private IndustrialProduct industrialProduct;
	
	@Autowired
	private ConsumerProduct consumerProduct;
	
//	public TradeFair() {
//		
//	}
//	
//	@Autowired
//	public TradeFair(IndustrialProduct industrialProduct, ConsumerProduct consumerProduct) {
//		this.industrialProduct = industrialProduct;
//		this.consumerProduct = consumerProduct;
//	}

	public int declareIndustrialProductPrice(IndustrialProduct industrialProduct) {
		return industrialProduct.calculatePrice();
	}
	
	public int declareConsumerProductPrice(ConsumerProduct consumerProduct) {
		return consumerProduct.calculatePrice();
	}
	
	public String specialPromotionalPricing() {
		String priceInfo = "Industrial Product is priced at $"+ declareIndustrialProductPrice(industrialProduct) + " and " +
						   "Consumer Product is priced at $"+ declareConsumerProductPrice(consumerProduct);
		return priceInfo;
	}

//	@Autowired
//	public void setIndustrialProduct(IndustrialProduct industrialProduct) {
//		this.industrialProduct = industrialProduct;
//	}
//
//	@Autowired
//	public void setConsumerProduct(ConsumerProduct consumerProduct) {
//		this.consumerProduct = consumerProduct;
//	}
}
