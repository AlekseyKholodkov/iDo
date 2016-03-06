package com.kholodkov.ido.config;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;
import org.testng.Assert;
import org.testng.annotations.Test;

import javax.sql.DataSource;

@ContextConfiguration(classes = SpringApplicationContext.class)
@EnableTransactionManagement
public class SpringApplicationContextTest extends AbstractTestNGSpringContextTests {

    @Autowired
    DataSource dataSource;

    @Autowired
    SessionFactory sessionFactory;

    @Autowired
    PlatformTransactionManager transactionManager;


    @Test
    public void dataSourceHasConnection() throws Exception {
        Assert.assertNotNull(dataSource.getConnection());
    }

    @Test
    @Transactional
    public void sessionFactoryHasSession() {
        Assert.assertNotNull(sessionFactory.openSession());
    }
}