package org.cnoss.rest4guice.test;

import java.util.List;

import junit.framework.Assert;

import org.jrest4guice.client.Page;
import org.jrest4guice.guice.GuiceContext;
import org.jrest4guice.sample.contact.domain.UserManageDomain;
import org.jrest4guice.sample.contact.entity.Role;
import org.jrest4guice.sample.contact.entity.User;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * 
 * @author <a href="mailto:zhangyouqun@gmail.com">cnoss (QQ:86895156)</a>
 * 
 */
public class UserManageServiceTest {

	private static UserManageDomain domain;

	@BeforeClass
	public static void setUp() throws Exception {
		//初始化JRest4Guice
		GuiceContext.getInstance().useJPA().init();
		//获取服务
		domain = GuiceContext.getInstance().getBean(UserManageDomain.class);
	}

	@Test
	public void testAuthUser() {
		Assert.assertTrue(domain.authUser("cnoss", "123"));
	}

	@Test
	public void testGetUserRoles() {
		System.out.println("\nRoles");
		System.out.println("================================");

		List<Role> userRoles = domain
				.getUserRoles("cnoss");
		Assert.assertTrue(userRoles.size()==2);
		for (Role role : userRoles)
			System.out.println(role.getName());
	}

	@Test
	public void testGetAllUsers() {
		System.out.println("\nUsers");
		System.out.println("================================");
		Page<User> page = domain.getAllUsers(1, 100);
		List<User> users = page.getResult();
		Assert.assertTrue(users.size()==2);
		for (User user : users)
			System.out.println(user.getName());
	}
}