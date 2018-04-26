package com.suhang.road.util;
import java.io.IOException;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Properties;


public class DataUnixUtil {
    // 实现数据库的备份
    public  String exportSql()throws IOException{
        Properties properties = new Properties();
        properties.load(DataUnixUtil.class.getClassLoader().getResourceAsStream("jdbc.properties"));
        Runtime runtime = Runtime.getRuntime();
        String command = getExportCommand(properties)[0];
        try {
            runtime.exec(command);
            System.out.println("备份数据库成功");
        }catch (IOException e){
            System.out.println("备份数据库失败");
            e.printStackTrace();
        }
        System.out.println(getExportCommand(properties)[1]);
        return getExportCommand(properties)[1];
    }


    // 实现数据库的导入
    public  void importSql(String resourceFileName) throws IOException {
        Properties properties = new Properties();
        //  读取属性文件
        properties.load(DataUnixUtil.class.getClassLoader().getResourceAsStream("jdbc.properties"));

        Runtime runtime = Runtime.getRuntime();
        //把所执行的命令将以字符串数组的形式出现
        String cmdarray[] = getImportCommand(properties,resourceFileName);//根据属性文件的配置获取数据库导入所需的命令，组成一个数组
        Process process = runtime.exec(cmdarray[0]);

        //执行了第一条命令以后已经登录到mysql了，所以之后就是利用mysql的命令窗口

        java.io.OutputStream os = process.getOutputStream();
        OutputStreamWriter writer = new OutputStreamWriter(os);
        //命令1和命令2要放在一起执行
        // 这里会执行后面的代码， 将命令输出到mysql的命令窗口，进行执行
        writer.write(cmdarray[1] + "\r\n" + cmdarray[2]);
        writer.flush();
        writer.close();
        os.close();
        System.out.println("数据库还原成功");
    }

    // 得到 导入 数据库的命令
    //  得到 导入数据 的 命令行语句
    private static String[] getImportCommand(Properties properties, String sourceFileName ) {

        String username = properties.getProperty("jdbc.username");//用户名
        String password = properties.getProperty("jdbc.password");//密码
        String host = properties.getProperty("jdbc.host");//导入的目标数据库所在的主机
        String port = properties.getProperty("jdbc.port");//使用的端口号
        String importDatabaseName = properties.getProperty("jdbc.importDatabaseName");//导入的目标数据库的名称
        String importPath = properties.getProperty("jdbc.importPath") + sourceFileName;//导入的目标文件所在的位置
        String MysqlPath = properties.getProperty("MysqlPath"); //  路径是mysql中 bin 文件 的位置

        //第一步，获取登录命令语句
        String loginCommand = new StringBuffer().append(MysqlPath).append("mysql -h").append(host).append(" -u").append(username).append(" -p").append(password)
                .append(" -P").append(port).toString();
        System.out.println(loginCommand);
        //第二步，获取切换数据库到目标数据库的命令语句
        String switchCommand = new StringBuffer().append("use ").append(importDatabaseName).toString();
        System.out.println(switchCommand);
        //第三步，获取导入的命令语句
        String importCommand = new StringBuffer(" source ").append(importPath).toString();
        System.out.println(importCommand);
        //需要返回的命令语句数组

        String[] commands = new String[] {loginCommand, switchCommand, importCommand};

        return commands;
    }
    //  得到 导出数据 的 命令行语句

    private static String[] getExportCommand(Properties properties) {
        SimpleDateFormat date = new SimpleDateFormat("yyyyMMddHHmmss");
        String backUpName = date.format(new Date());
        StringBuffer command = new StringBuffer();
        String username = properties.getProperty("jdbc.username");//用户名
        String password = properties.getProperty("jdbc.password");//用户密码
        String exportDatabaseName = properties.getProperty("jdbc.exportDatabaseName");//需要导出的数据库名
        String host = properties.getProperty("jdbc.host");//从哪个主机导出数据库，如果没有指定这个值，则默认取localhost
        String port = properties.getProperty("jdbc.port");//使用的端口号
        String exportPath = properties.getProperty("jdbc.exportPath")
                + backUpName +".sql"
                ;
        String MysqlPath = properties.getProperty("MysqlPath"); //  路径是mysql中 bin 文件 的位置

        //注意哪些地方要空格，哪些不要空格
        command.append(MysqlPath).append("mysqldump -u").append(username).append(" -p").append(password)//密码是用的小p，而端口是用的大P。
                .append(" -h").append(host).append(" -P").append(port).append(" ").append(exportDatabaseName).append(" -r ").append(exportPath);
        String [] strings = {command.toString(),backUpName+".sql"};
        return strings;
    }

    public static void main(String[] args){
//
        try {
            new DataUnixUtil().exportSql();
        } catch (IOException e) {
            e.printStackTrace();
        }

//        try {
//            new DataUnixUtil().importSql("20180423213653.sql");
//        } catch (IOException e) {
//            e.printStackTrace();
//        }


    }
}
