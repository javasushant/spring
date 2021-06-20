package com.nt.beans;

import org.springframework.beans.factory.FactoryBean;

public class DeliveryBoy_ProductFactoryBean implements FactoryBean<Product> {
	
	private String prodType;
	
	
	public DeliveryBoy_ProductFactoryBean(String prodType) {
		System.out.println("DeliveryBoy_ProductFactoryBean.: 1-param-constructor");
		this.prodType = prodType;
	}

	@Override
	public Product getObject() throws Exception {
		System.out.println("DeliveryBoy_ProductFactoryBean.getObject()");
		if(prodType.equalsIgnoreCase("electronic")) {
			ElectronicProduct eprod=new ElectronicProduct("110", "5*");
			eprod.setPId(101); eprod.setPname("TV");
			
			return eprod;
		}
		else if(prodType.equalsIgnoreCase("automobile")) {
			AutomobileProduct aprod = new AutomobileProduct("Bus", 3250);
			aprod.setPId(102); aprod.setPname("Vehicle");
			return aprod;
		}
		else {
			return null;
		}
		
	}//method

	@Override
	public Class<?> getObjectType() {
		System.out.println("DeliveryBoy_ProductFactoryBean.getObjectType()");
		return Product.class;
	}
	
	@Override
	public boolean isSingleton() {
		System.out.println("DeliveryBoy_ProductFactoryBean.isSingleton()");
		return true;
	}

}
