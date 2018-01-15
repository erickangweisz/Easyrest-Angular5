package com.jkang.technicaltest.testsuite;

import com.jkang.technicaltest.model.RoleTest;
import com.jkang.technicaltest.model.UserRole;
import com.jkang.technicaltest.model.UserTest;
import com.jkang.technicaltest.service.UserRoleService;
import com.jkang.technicaltest.service.UserService;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 *
 * @author erick
 */
@RunWith(Suite.class)

@Suite.SuiteClasses({
	UserTest.class,
	RoleTest.class,
	UserRole.class,
	UserService.class,
	UserRoleService.class
})

public class JunitTestSuite {}
