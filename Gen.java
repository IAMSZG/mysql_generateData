import java.sql.*;
import java.util.Calendar;
import java.util.Random;

public class Gen {
    public static void main(String[] args) throws SQLException {
//        Long startTime = System.currentTimeMillis();
//        //生成一万条随机数据
//        int sum = 1;
//        int total = 100;
//        DatabaseConnection dc = new DatabaseConnection();
//        Connection cc = dc.getConnection();
//        Statement statement = cc.createStatement();
//        while (sum <= total) {
//            System.out.println("正在生成随机数据(" + sum + "/" + total + ")");
//            Random ran = new Random();
//            //数据库插入数据
//            //创造执行环境
//            try {
//                char a = (char) (sum + '0');
//                statement.executeUpdate("insert into st values (" +
//                        "\'" + String.valueOf(sum) + "\'"               //Sno
//                        + ",\'" + '1' + "\'"       //Sname
//                        + ",\'" + '1' + "\'"       //Sdept
//                        + ",\'" + '1' + "\'"            //Sclass
//                        + ",\'" + 15 + "\'"       //Sage
//                        + ",\'" + '1' + "\'"       //Ssex
//                        + ",\'" + genBirthday(ran) + "\'"       //Sbirth
//                        + ",\'" + genEmail(ran) + "\'"       //Email
//                        + ",\'" + '1' + "\'"       //Beizhu1
//                        + ",\'" + '1' + "\'"       //Beizhu2
//                        + ",\'" + '1' + "\'"       //Beizhu3
//                        + ",\'" + '1' + "\'"       //Beizhu4
//                        + ",\'" + '1' + "\'"       //Beizhu5
//                        + ",\'" + '1' + "\'"       //Beizhu6
//                        + ",\'" + '1' + "\'"       //Beizhu7
//                        + ",\'" + '1' + "\'"       //Beizhu8
//                        + ",\'" + '1' + "\'"       //Beizhu9
//                        + ",\'" + '1' + "\');");   //Beizhu10
//                sum++;
//            } catch (SQLException e) {
//                e.printStackTrace();
//            }
//        }
//        Long endTime = System.currentTimeMillis();
//        System.out.println("时间消耗：" + (endTime - startTime) + "毫秒");
//        平均时间3869


//        Random ran = new Random();
//        Connection conn = null;
//        PreparedStatement pstm =null;
//        ResultSet rt = null;
//        try {
//            conn = DatabaseConnection.getConnection();
//            String sql = "INSERT INTO st(Sno,Sname,Sdept,Sclass,Sage,Ssex,Sbirth,Email," +
//                    "Beizhu1,Beizhu2,Beizhu3,Beizhu4,Beizhu5,Beizhu6,Beizhu7,Beizhu8,Beizhu9,Beizhu10) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
//            pstm = conn.prepareStatement(sql);
//            Long startTime = System.currentTimeMillis();
//            int sum = 100;
//            System.out.println("开始插入...");
//            for (int i = 0; i < sum; i++){
//                System.out.println("正在生成随机数据(" + i + "/" + sum + ")");
//                pstm.setString(1, String.valueOf(i));
//                pstm.setString(2,String.valueOf(i));
//                pstm.setString(3, "1");
//                pstm.setString(4, "1");
//                pstm.setString(5, "15");
//                pstm.setString(6, "0");
//                pstm.setString(7, genBirthday(ran));
//                pstm.setString(8, genEmail(ran));
//                pstm.setString(9, "1");
//                pstm.setString(10, "1");
//                pstm.setString(11, "1");
//                pstm.setString(12, "1");
//                pstm.setString(13, "1");
//                pstm.setString(14, "1");
//                pstm.setString(15, "1");
//                pstm.setString(16, "1");
//                pstm.setString(17, "1");
//                pstm.setString(18, "1");
//                pstm.execute();
//            }
//            Long endTime = System.currentTimeMillis();
//            System.out.println("插入完成,总用时：" + (endTime - startTime)+"ms");
//        } catch (Exception e) {
//            e.printStackTrace();
//            throw new RuntimeException(e);
//        }finally{
//            if(pstm!=null){
//                try {
//                    pstm.close();
//                } catch (SQLException e) {
//                    e.printStackTrace();
//                    throw new RuntimeException(e);
//                }
//            }
//            if(conn!=null){
//                try {
//                    conn.close();
//                } catch (SQLException e) {
//                    e.printStackTrace();
//                    throw new RuntimeException(e);
//                }
//            }
//        }
        //3452ms
        Random ran = new Random();
        Connection conn = null;
        PreparedStatement pstm = null;
        ResultSet rt = null;
        try {
            conn = DatabaseConnection.getConnection();
            StringBuffer sql = new StringBuffer("INSERT INTO st(Sno,Sname,Sdept,Sclass,Sage,Ssex,Sbirth,Email,Beizhu1,Beizhu2,Beizhu3,Beizhu4,Beizhu5,Beizhu6,Beizhu7,Beizhu8,Beizhu9,Beizhu10) VALUES");
            Long startTime = System.currentTimeMillis();
            System.out.println("开始插入");
            int count = 0;
            int num = 1000000;
            for (int i = 0; i < num; i++) {
                if (count != 0) {
                    sql.append(",");
                }
                count++;
                sql.append("('" + i + "','" + i + "','" + 1 + "','" + 1 + "','" + 15 + "','" + 0 + "','" + genBirthday(ran) + "','" + genEmail(ran) + "','" + 1 + "','" + 1 + "','" + 1 + "','" + 1 + "','" + 1 + "','" + 1 + "','" + 1 +
                        "','" + 1 + "','" + 1 + "','" + 1 + "')");
                if (count == 125000) {
                    pstm = conn.prepareStatement(sql.toString());
                    pstm.execute();
                    count = 0;
                    sql = new StringBuffer("INSERT INTO st(Sno,Sname,Sdept,Sclass,Sage,Ssex,Sbirth,Email," +
                            "Beizhu1,Beizhu2,Beizhu3,Beizhu4,Beizhu5,Beizhu6,Beizhu7,Beizhu8,Beizhu9,Beizhu10) VALUES");
                }
            }
            Long endTime = System.currentTimeMillis();
            System.out.println("插入数据库总用时：" + (endTime - startTime) + "ms");
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        } finally {
            if (pstm != null) {
                try {
                    pstm.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                    throw new RuntimeException(e);
                }
            }
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                    throw new RuntimeException(e);
                }
            }
        }
    }
//280ms

    /**
     * 生成随机生日
     *
     * @param ran
     * @return
     */
    public static String genBirthday(Random ran) {
        Calendar calendar = Calendar.getInstance();
        int year = ran.nextInt(101) + (calendar.get(Calendar.YEAR) - 100);
        int month = ran.nextInt(12) + 1;
        int day = 1;
        if (month == 4 || month == 6 || month == 9 || month == 11) {
            //如果月份只有三十天的话，重新生成小于31天的day
            day = ran.nextInt(30) + 1;
        }
        if (month == 2) {
            //如果是2月，只有28天或者29天
            if (year % 4 == 0) {
                //闰年
                day = ran.nextInt(29) + 1;
            } else {
                day = ran.nextInt(28) + 1;
            }
        }
        String birthday = "" + year + "-" + month + "-" + day;
        return birthday;
    }

    /**
     * 生成随机用户名
     *
     * @param ran
     * @return
     */
    public static String genUsername(Random ran) {
        String name = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
        int flag3 = ran.nextInt(10) + 5;//生成5到14位的用户名
        String username = "";//初始化用户名
        for (int i = 0; i < flag3; i++) {
            username = username + name.charAt(ran.nextInt(62));
        }
        return username;
    }

    /**
     * 随机生成邮箱
     *
     * @param ran
     * @return
     */
    public static String genEmail(Random ran) {

        int flag = ran.nextInt(4) + 6;//生成6到9中的随机整数
        double emailPart1 = 0;//邮箱地址的第一部分(数字)
        switch (flag) {
            //根据flag的值生成对应位数的随机数值
            case 6:
                emailPart1 = ran.nextDouble() * 1000000;
                break;
            case 7:
                emailPart1 = ran.nextDouble() * 10000000;
                break;
            case 8:
                emailPart1 = ran.nextDouble() * 100000000;
                break;
            case 9:
                emailPart1 = ran.nextDouble() * 1000000000;
                break;
        }
        int emailNum = (int) emailPart1;
        int location = ran.nextInt(4);//设置邮箱地址
        String email = null;
        switch (location) {
            case 0:
                email = "" + emailNum + "@gmail.com";
                break;
            case 1:
                email = "" + emailNum + "@qq.com";
                break;
            case 2:
                email = "" + emailNum + "@163.com";
                break;
            case 3:
                email = "" + emailNum + "@aliyun.com";
                break;
            default:
                email = "" + emailNum + "@gdjyw.com";
        }
        return email;
    }
}

