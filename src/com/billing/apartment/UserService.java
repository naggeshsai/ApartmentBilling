package com.billing.apartment;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.codehaus.jettison.json.JSONException;
import org.hibernate.Session;

import com.billing.model.CommonExpenses;
import com.billing.model.Constant;
import com.billing.model.ConstantValues;
import com.billing.model.PerMonthExpensesPerPerson;
import com.billing.model.PerPersonExpenses;
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
		session.close();
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
		session.close();
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

		session.close();
		return Response.status(200).entity("addUser is Called, name:" + name).build();

	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/getAmountPerPerson")
	public List<PerPersonExpenses> getAmountPerPerson() throws JSONException {
		Session session = HibernateUtil.getSessionFactory().openSession();
		List<PerPersonExpenses> perPersonExpensess = new ArrayList<PerPersonExpenses>();
		session.beginTransaction();
		List result = session.createQuery("SELECT " + "ce.id," + "ce.spentby,"
				+ "sum(ce.amount) AS AMOUNT  FROM CommonExpenses ce group by spentby").list();
		session.getTransaction().commit();
		PerPersonExpenses perPersonExpenses;
		for (int i = 0; i <= result.size() - 1; i++) {
			Object[] result2 = (Object[]) result.get(i);
			perPersonExpenses = new PerPersonExpenses();
			perPersonExpenses.setID((int) result2[0]);
			perPersonExpenses.setSPENTBY((String) result2[1]);
			Long x = (Long) result2[2];
			int h = x.intValue();
			perPersonExpenses.setAMOUNT((int) h);
			perPersonExpensess.add(perPersonExpenses);
		}
		session.close();
		return perPersonExpensess;
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/getTotalExpensesPerMonth")
	public List<PerMonthExpensesPerPerson> getAmountPerPersonPerMonth() {
		List<PerMonthExpensesPerPerson> perMonthExpensesPerPersons;
		List<PerPersonExpenses> perPersonExpensess = new ArrayList<PerPersonExpenses>();
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		List result1 = session.createQuery("SELECT " + "sum(cv.amount) AS AMOUNT  FROM ConstantValues cv").list();
		Long constanttemp = (Long) result1.get(0);
		int consta = constanttemp.intValue();
		Constant.CONSTANT = consta;
		session.getTransaction().commit();
		session.close();
		perMonthExpensesPerPersons=getAmountPerPersonPerMonths();
		return perMonthExpensesPerPersons;
	}
	public List<PerMonthExpensesPerPerson> getAmountPerPersonPerMonths() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		List<PerMonthExpensesPerPerson> perMonthExpensesPerPersons = new ArrayList<PerMonthExpensesPerPerson>();
		List<PerPersonExpenses> perPersonExpensess = new ArrayList<PerPersonExpenses>();
		List result = session.createQuery("SELECT " + "ce.id," + "ce.spentby,"
				+ "sum(ce.amount) AS AMOUNT  FROM CommonExpenses ce group by spentby").list();
		session.close();
		PerPersonExpenses perPersonExpenses;
		for (int i = 0; i <= result.size() - 1; i++) {
			Object[] result2 = (Object[]) result.get(i);
			perPersonExpenses = new PerPersonExpenses();
			perPersonExpenses.setID((int) result2[0]);
			perPersonExpenses.setSPENTBY((String) result2[1]);
			Long x = (Long) result2[2];
			int h = x.intValue();
			perPersonExpenses.setAMOUNT((int) h);
			perPersonExpensess.add(perPersonExpenses);
		}
		addEqualShare(perPersonExpensess);
		for (int i = 0; i <= perPersonExpensess.size() - 1; i++) {
			PerMonthExpensesPerPerson perMonthExpensesPerPerson = new PerMonthExpensesPerPerson();
			perMonthExpensesPerPerson.setID(perPersonExpensess.get(i).getID());
			perMonthExpensesPerPerson.setSPENTBY(perPersonExpensess.get(i).getSPENTBY());
			perMonthExpensesPerPerson.setAMOUNT(perPersonExpensess.get(i).getAMOUNT() + Constant.CONSTANT);
			perMonthExpensesPerPersons.add(perMonthExpensesPerPerson);
		}
		return perMonthExpensesPerPersons;
	}

	private void addEqualShare(List<PerPersonExpenses> perPersonExpensess) {
		for (int i=0;i<perPersonExpensess.size()-1;i++){
			int tempi=i;
			int shareamount;
			shareamount=perPersonExpensess.get(i).getAMOUNT()/3;
			if (tempi!=i){
				perPersonExpensess.get(i).setAMOUNT(perPersonExpensess.get(i).getAMOUNT()+shareamount);
			}
			else{
				perPersonExpensess.get(i).setAMOUNT(perPersonExpensess.get(i).getAMOUNT()-shareamount);
			}
			tempi=tempi+1;
		}
	}
}
