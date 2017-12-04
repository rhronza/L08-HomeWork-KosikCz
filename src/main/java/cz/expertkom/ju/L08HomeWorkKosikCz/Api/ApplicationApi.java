package cz.expertkom.ju.L08HomeWorkKosikCz.Api;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.apache.cxf.rs.security.cors.CrossOriginResourceSharing;

import cz.expertkom.ju.L08HomeWorkKosikCz.Entity.ProductDto;

@CrossOriginResourceSharing(allowAllOrigins = true)
public interface ApplicationApi {

	/* zobrazení všech položek */
	@GET
	@Path("products")
	@Consumes(MediaType.WILDCARD)
	@Produces(MediaType.APPLICATION_JSON)
	public Response productList();

	/* zobrazení seznamu produktů podle zadaného parametru*/
	/* param = 1 -> seznam produktů seřazen podle ceny od největší po nejmenší(descending) */
	@GET
	@Path("productsList/{param}")
	@Consumes(MediaType.WILDCARD)
	@Produces(MediaType.APPLICATION_JSON)
	public Response productsList(@PathParam(value="param") int typeProductList);

	/* zobrazení seznamu produktů s větší než "cenaOd" a menší než "cenaDo" */
	@GET
	@Path("productsList/{cenaOd}/{cenaDo}")
	@Consumes(MediaType.WILDCARD)
	@Produces(MediaType.APPLICATION_JSON)
	public Response productsList(@PathParam(value="cenaOd") float cenaOd, @PathParam(value="cenaDo") float cenaDo);

	/* zobrazení jedné položky */
	@GET
	@Path("productOne/{param}")
	@Consumes(MediaType.WILDCARD)
	@Produces(MediaType.APPLICATION_JSON)
	public Response productOne(@PathParam(value = "param") Long id);

	/* vložení nové hodnoty */
	@POST
	@Path("product")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response productInsert(ProductDto productDto );

	/* zrušení záznamu dle id */
	@DELETE
	@Path("product/{param}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response productDelete(@PathParam(value = "param") Long id);
	
	/* aktualizace záznamu dle id a nové hodnoty */
	@PUT
	@Path("product/{param}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response productUpdate(@PathParam(value = "param") Long id , ProductDto productDto);

}
