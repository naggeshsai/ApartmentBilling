package com.billing.apartment;

import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

@Path("/user")
public class UserService {
	@POST
	@Path("/addMoney")
	public Response addMoney(@FormParam("name") String name, @FormParam("amount") int amount,
			@FormParam("spentby") String spentby) {
		System.out.println(name + spentby + amount);
		return Response.status(200)
				.entity("addMoney is called,name :" + name + ", amount:" + amount + ",spentby :" + spentby).build();

	}
}
