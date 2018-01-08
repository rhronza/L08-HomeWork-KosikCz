 package cz.expertkom.ju.L08HomeWorkKosikCz.Api.Impl;

import java.util.List;

import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;

import cz.expertkom.ju.L08HomeWorkKosikCz.Api.ApplicationApi;
import cz.expertkom.ju.L08HomeWorkKosikCz.Entity.Product;
import cz.expertkom.ju.L08HomeWorkKosikCz.Entity.ProductDto;
import cz.expertkom.ju.L08HomeWorkKosikCz.Entity.Products;
import cz.expertkom.ju.L08HomeWorkKosikCz.interfaces.DownLoadPageService;
import cz.expertkom.ju.L08HomeWorkKosikCz.interfaces.ProductDbServices;


public class ApplicationApiImpl implements ApplicationApi {
		
	@Autowired
	ProductDbServices pDbS;
	
	@Autowired
	DownLoadPageService dwnlps;
	
	@Override
	public Response productOne(Long id) {
		ProductDto p = pDbS.getOne2(id);
		System.out.println(p);
		return Response.ok(p).build();
	}

	@Override
	public Response productList() {
		Products p = pDbS.getAll();
		return Response.ok(p).build();
	}
	
	@Override
	public Response productsList(int typeProductList) {
		Products prs = new Products();
		if (typeProductList == 1) {
			prs = pDbS.getAllOrderByprice();
		}
		return Response.ok(prs).build();
	}
	
	@Override
	public Response productsList(float priceFrom, float priceTo) {
		Products prs = pDbS.getAllBetweenPrice(priceFrom, priceTo);
		return Response.ok(prs).build();
	}
	
	@Override
	public Response productListPartText(String partProductText) {
		Products prs = pDbS.getProductsPartText(partProductText);
		return Response.ok(prs).build();
	}
	
	@Override
	public Response productInsert(ProductDto productDto) {
		System.out.println(productDto);
		pDbS.insertProduct(productDto);
		return Response.ok().build();
	}

	@Override
	public Response productDelete(Long id) {
		pDbS.deleteProduct(id);
		return Response.ok().build();
	}

	@Override
	public Response productUpdate(Long id, ProductDto productDto) {
		pDbS.updateProduct(id, productDto);
		return Response.ok().build();
	}

	@Override
	public Response kosik() {
		dwnlps.start();
		return Response.ok().build();
	}



	


	
}
