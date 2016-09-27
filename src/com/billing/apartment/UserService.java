package com.billing.apartment;

import java.util.Date;

import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

import org.hibernate.Session;

import com.billing.model.CommonExpenses;
import com.billing.model.ConstantValues;
import com.billing.model.User;
import com.billing.util.HibernateUtil;;

@Path("/user")
public class UserService {
	@POST
	@Path("/addMoney")
	public Response addMoney(@FormParam("name") String name, @FormParam("amount") int amount,
			@FormParam("spentby") String spentby, @FormParam("entereddate") String dateent) {
		System.out.println(name + spentby + amount + dateent);
		Session session = HibernateUtil.getSessionFactory().openSession();

		session.beginTransaction();
		CommonExpenses expenses = new CommonExpenses();

		expenses.setId(1);
		expenses.setName(name);
		expenses.setAmount(amount);
		expenses.setSpentby(spentby);
		expenses.setEnteredDate(new Date());

		session.save(expenses);
		session.getTransaction().commit();
		return Response.status(200).entity("addMoney is called,name :" + name + ", amount:" + amount + ",spentby :"
				+ spentby + ",date :" + dateent).build();

	}

	@POST
	@Path("/addConstantValue")
	public Response addConstanValue(@FormParam("name") String name, @FormParam("amount") int amount) {
		System.out.println(name + " " + amount);
		Session session = HibernateUtil.getSessionFactory().openSession();

		session.beginTransaction();
		ConstantValues expenses = new ConstantValues();

		expenses.setId(1);
		expenses.setName(name);
		expenses.setAmount(amount);

		session.save(expenses);
		session.getTransaction().commit();
		return Response.status(200).entity("addConstantValue is Called, name:" + name + ",amount:" + amount).build();
	}

	@POST
	@Path("/addUser")
	public Response addUser(@FormParam("name") String name) {
		System.out.println("Name :" + name);
		Session session = HibernateUtil.getSessionFactory().openSession();

		session.beginTransaction();
		User user = new User();

		user.setID(1);
		user.setName(name);

		session.save(user);
		session.getTransaction().commit();

		return Response.status(200).entity("addUser is Called, name:" + name).build();

	}
}
