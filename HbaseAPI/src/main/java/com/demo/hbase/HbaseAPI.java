/**
 * @ClassName $申先生
 * @Description days
 * @date 2022/11/5 21:04
 * @Version 1.0
 */
package com.demo.hbase;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hbase.*;
import org.apache.hadoop.hbase.client.*;
import org.apache.hadoop.hbase.util.Bytes;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class HbaseAPI {
    //配置信息
    public static Configuration conf;
    //获取配置信息
    static {
        conf = HBaseConfiguration.create();
    }

    //①判断一张表是否存在
    public static boolean isExist(String tableName) throws IOException {
        //对表操作时需要使用HbaseAdmin
        Connection connection = ConnectionFactory.createConnection(conf);
        //管理表
        HBaseAdmin admin = (HBaseAdmin) connection.getAdmin();
        return admin.tableExists(TableName.valueOf(tableName));
    }

    //②在hbase集群上创建表
    public static void createTable(String tableName,String... columnFamily) throws IOException {
        //对表操作需要用HbaseAdmin
        Connection connection = ConnectionFactory.createConnection(conf);
        //管理表
        HBaseAdmin admin = (HBaseAdmin) connection.getAdmin();
        //(1)如果表存在，需要重新输入表名
        if(isExist(tableName)) {
            System.out.println("表已经存在，请重新输入表名");
        }else {
            //(2)创建表的话需要创建一个描述器
            HTableDescriptor htd = new HTableDescriptor(TableName.valueOf(tableName));
            //(3)创建列簇
            for (String cf : columnFamily) {
                htd.addFamily(new HColumnDescriptor(cf));
            }
            //(4)创建表
            admin.createTable(htd);
            System.out.println("表已经创建成功");
        }
    }
    //③删除表
    public static void deleteTable(String tableName) throws IOException {
        //对表操作需要用HbaseAdmin
        Connection connection = ConnectionFactory.createConnection(conf);
        //管理表
        HBaseAdmin admin = (HBaseAdmin) connection.getAdmin();
        //(1)如果表存在
        if(isExist(tableName)) {
            //（2）先指定不可用
            admin.disableTable(TableName.valueOf(tableName));
            admin.deleteTable(TableName.valueOf(tableName));
        }else {
            System.out.println("表不存在，请重新输入表名");
        }
    }
    //④添加数据put 'user' , 'rowKey'
    public static void addRow(String tableName,String rowKey,String cf,String column,String value) throws IOException {
        //对表操作需要用HbaseAdmin
        Connection connection = ConnectionFactory.createConnection(conf);
        //管理表
        Table t = connection.getTable(TableName.valueOf(tableName));
        HBaseAdmin admin = (HBaseAdmin) connection.getAdmin();
        //(1)用put方法加入数据
        Put p = new Put(Bytes.toBytes(rowKey));
        //(2)加入数据
        p.addColumn(Bytes.toBytes(cf),Bytes.toBytes(column),Bytes.toBytes(value));
        t.put(p);
    }
    //⑤删除表中一行数据
    public static void deleteRow(String tableName,String rowKey,String cf) throws IOException {
        //对表操作需要用HbaseAdmin
        Connection connection = ConnectionFactory.createConnection(conf);
        //管理表
        Table t = connection.getTable(TableName.valueOf(tableName));
        //(1)通过rowKey删除数据
        Delete d = new Delete(Bytes.toBytes(rowKey));
        //(2)删除
        t.delete(d);
    }

    //⑥删除多行数据
    public static void deleteAll(String tableName,String... rowKeys) throws IOException {
        //对表操作需要用HbaseAdmin
        Connection connection = ConnectionFactory.createConnection(conf);
        //管理表
        Table t = connection.getTable(TableName.valueOf(tableName));
        //(1)通过rowKey删除数据
        List<Delete> list = new ArrayList<>();
        for(String row : rowKeys){
            Delete d = new Delete(Bytes.toBytes(row));
            list.add(d);
        }
        //(2)删除
        t.delete(list);
    }

    //⑦扫描全表数据
    public static void scanAll(String tableName) throws IOException {
        //对表操作需要用HbaseAdmin
        Connection connection = ConnectionFactory.createConnection(conf);
        //管理表
        Table t = connection.getTable(TableName.valueOf(tableName));
        //(1)实例scan
        Scan scan = new Scan();
        //（2）拿到scanner对象
        ResultScanner rs = t.getScanner(scan);
        //(3)遍历
        for(Result r : rs){
            Cell[] cells = r.rawCells();
            //遍历具体数据
            for(Cell c : cells) {
                System.out.println("行键为"+Bytes.toString(CellUtil.cloneRow(c)));
                System.out.println("列簇为"+Bytes.toString(CellUtil.cloneFamily(c)));
                System.out.println("值为"+Bytes.toString(CellUtil.cloneValue(c)));

            }
        }
    }
    //⑧扫描指定的数据
    public static void getRow(String tableName,String rowKey) throws IOException {
        //对表操作需要用HbaseAdmin
        Connection connection = ConnectionFactory.createConnection(conf);
        //管理表
        Table t = connection.getTable(TableName.valueOf(tableName));
        Get g = new Get(Bytes.toBytes(rowKey));
        g.addFamily(Bytes.toBytes("info"));
        Result rs = t.get(g);
        Cell[] cells = rs.rawCells();
        //(3)遍历
        for(Cell c : cells) {
            System.out.println("行键为"+Bytes.toString(CellUtil.cloneRow(c)));
            System.out.println("列簇为"+Bytes.toString(CellUtil.cloneFamily(c)));
            System.out.println("值为"+Bytes.toString(CellUtil.cloneValue(c)));

        }
    }

    public static void main(String[] args) throws IOException {
        System.out.println(isExist("emp20"));
        createTable("zhaowu","hengao","henshuai");
        createTable("zhaowu","info");
        deleteTable("zhaowu");
        createTable("yangyang","info");
        addRow("yangyang","2019101","info","age","18");
        deleteRow("yangyang","2019101","info");
        deleteAll("emp","20191001","20191002");
        scanAll("yangyang");
        getRow("lili","2019102");
    }
}
