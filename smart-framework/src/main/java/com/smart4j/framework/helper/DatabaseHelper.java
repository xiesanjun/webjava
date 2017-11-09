package com.smart4j.framework.helper;

import com.smart4j.framework.util.PropsUtil;
import org.apache.commons.dbcp2.BasicDataSource;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Properties;

/**
 * 数据库操作助手类
 */
public final class DatabaseHelper {

    private static final Logger LOGGER = LoggerFactory.getLogger(DatabaseHelper.class);

    private static final QueryRunner QUERY_RUNNER;

    private static final ThreadLocal<Connection> CONNECTION_HOLDER;

    private static final BasicDataSource DATA_SOURCE;

    private static final String DRIVER;
    private static final String URL;
    private static final String USERNAME;
    private static final String PASSWORD;

    static {

        CONNECTION_HOLDER = new ThreadLocal<>();
        QUERY_RUNNER = new QueryRunner();

        Properties conf = PropsUtil.loadProps("smart.properties");
        DRIVER = conf.getProperty("jdbc.driver");
        URL = conf.getProperty("jdbc.url");
        USERNAME = conf.getProperty("jdbc.username");
        PASSWORD = conf.getProperty("jdbc.password");

        DATA_SOURCE = new BasicDataSource();
        DATA_SOURCE.setDriverClassName(DRIVER);
        DATA_SOURCE.setUrl(URL);
        DATA_SOURCE.setUsername(USERNAME);
        DATA_SOURCE.setPassword(PASSWORD);

    }

    /**
     * 获取数据库连接
     */
    public static Connection getConnection() {
        Connection connection = CONNECTION_HOLDER.get();
        if (connection == null) {
            try {
                connection = DATA_SOURCE.getConnection();
            } catch (SQLException e) {
                LOGGER.error("get connection failure", e);
                throw new RuntimeException(e);
            } finally {
                CONNECTION_HOLDER.set(connection);
            }
        }
        return connection;
    }

    /**
     * 关闭数据库连接
     */
    public static void closeConnection() {
        Connection connection = CONNECTION_HOLDER.get();
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                LOGGER.error("close connection failure", e);
                throw new RuntimeException(e);
            }
        }
    }

    /**
     * 查询实体列表
     */
    public static <T> List<T> queryEntityList(Class<T> entityClass, Connection connection, String sql, Object... params) {
        List<T> entityList;
        try {
            entityList = QUERY_RUNNER.query(connection, sql, new BeanListHandler<T>(entityClass), params);
        } catch (Exception e) {
            LOGGER.error("query entity list failure", e);
            throw new RuntimeException(e);
        } finally {
            closeConnection();
        }
        return entityList;
    }
}
