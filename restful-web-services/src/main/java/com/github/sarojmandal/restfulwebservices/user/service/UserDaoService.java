package com.github.sarojmandal.restfulwebservices.user.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.i18n.AcceptHeaderLocaleResolver;

import com.github.sarojmandal.restfulwebservices.user.bean.JSONFilterUser;

@Component
public class UserDaoService {
	static List<JSONFilterUser> users = new ArrayList<>();
	static {
		users.add(new JSONFilterUser(1, "Saroj", new Date()));
		users.add(new JSONFilterUser(2, "Vinothini", new Date()));
		users.add(new JSONFilterUser(3, "Manoj", new Date()));
	}

	private static int userCount = 3;

	public List<JSONFilterUser> findAll() {
		return users;
	}

	public JSONFilterUser save(JSONFilterUser user) {
		if (null == user.getId() || user.getId() == 0) {
			user = new JSONFilterUser(++userCount, user.getName(), user.getBirthDate());
		}
		users.add(user);
		return user;
	}

	public JSONFilterUser findOne(int id) {
		for (JSONFilterUser user : users) {
			if (id == user.getId()) {
				return user;
			}
		}
		return null;
	}

	public JSONFilterUser deleteById(int id) {
		Iterator<JSONFilterUser> iterator = users.iterator();
		while (iterator.hasNext()) {
			JSONFilterUser user = iterator.next();
			if (id == user.getId()) {
				iterator.remove();
				return user;
			}
		}
		return null;
	}
	
	@Bean(name= {"local"})
	public LocaleResolver localeResolver() {
		AcceptHeaderLocaleResolver localeResolver = new AcceptHeaderLocaleResolver();
		localeResolver.setDefaultLocale(Locale.US);
		return localeResolver;
	}
}
