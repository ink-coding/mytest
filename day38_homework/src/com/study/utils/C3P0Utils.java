package com.study.utils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.sql.DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;

/**
 * C3P0������
 * 
 * @author Never Say Never
 * @date 2016��11��26��
 * @version V1.0
 */
public class C3P0Utils {
    // 1.ʹ���޲εķ���������Ĭ�ϼ���c3p0-config.xml�����<default-config>������
    // ���ָ���˲�������ô�������c3p0-config.xml�����<named-config>������
    private static ComboPooledDataSource dataSource = new ComboPooledDataSource();

    // ʹ��ThreadLocal������̰߳�ȫ(���ô���connection���������)
    private static ThreadLocal<Connection> threadLocal = new ThreadLocal<Connection>();

    /**
     * �ṩ����Դ����
     */
    public static DataSource getDataSource() {
        return dataSource;
    }

    /**
     * ������ӵķ�����ʹ���̱߳��ر����� һ��Ҫ��֤�Ǵ�threadLocal�����ȡ��conn����
     */
    public static Connection getConnnection() {
        Connection conn = threadLocal.get();
        if(conn==null){
            try {
                //ʹ������Դ���һ���µ�conn����
                conn = dataSource.getConnection();
                //�����conn����ŵ�threadLocal��ȥ�������Ժ��ȡ������һ�µ�
                threadLocal.set(conn);
                return threadLocal.get();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return conn;
    }

    /**
     * �ͷ���Դ����
     */

    public static void release(Connection conn, PreparedStatement pstmt, ResultSet rs) {
        if (rs != null)
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }

        if (pstmt != null)
            try {
                pstmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }

        if (conn != null)
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
    }

}
