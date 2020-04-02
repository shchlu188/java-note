/**
 * Created with IntelliJ IDEA.
 *
 * @version v1.0.0
 * Description:
 * @package: PACKAGE_NAME
 * @author: chenglu
 * @create: 2020/4/2
 */
public class MyTestPro {
    /**
     * 干支年表对应
     */
    private static final String[] GZ = {
            "甲子 00", "乙丑 01", "丙寅 02", "丁卯 03", "戊辰 04", "己巳 05", "庚午 06", "辛未 07", "壬申 08", "癸酉 09",
            "甲戌 10", "乙亥 11", "丙子 12", "丁丑 13", "戊寅 14", "己卯 15", "庚辰 16", "辛巳 17", "壬午 18", "癸未 19",
            "甲申 20", "乙酉 21", "丙戌 22", "丁亥 23", "戊子 24", "己丑 25", "庚寅 26", "辛卯 27", "壬辰 28", "癸巳 29",
            "甲午 30", "乙未 31", "丙申 32", "丁酉 33", "戊戌 34", "己亥 35", "庚子 36", "辛丑 37", "壬寅 38", "癸卯 39",
            "甲辰 40", "乙巳 41", "丙午 42", "丁未 43", "戊申 44", "己酉 45", "庚戌 46", "辛亥 47", "壬子 48", "癸丑 49",
            "甲寅 50", "乙卯 51", "丙辰 52", "丁巳 53", "戊午 54", "己未 55", "庚申 56", "辛酉 57", "壬戌 58", "癸亥 59"
    };
    /**
     * 纪月法
     */
    private static final String[][] GZ_MONTH = {
            {"丙寅", "丁卯", "戊辰", "己巳", "庚午", "辛未", "壬申", "癸酉", "甲戌", "乙亥", "丙子", "丁丑"},
            {"戊寅", "己卯", "庚辰", "辛巳", "壬午", "癸未", "甲申", "乙酉", "丙戌", "丁亥", "戊子", "己丑"},
            {"庚寅", "辛卯", "壬辰", "癸巳", "甲午", "乙未", "丙申", "丁酉", "戊戌", "己亥", "庚子", "辛丑"},
            {"壬寅", "癸卯", "甲辰", "乙巳", "丙午", "丁未", "戊申", "己酉", "庚戌", "辛亥", "壬子", "癸丑",},
            {"甲寅", "乙卯", "丙辰", "丁巳", "戊午", "己未", "庚申", "辛酉", "壬戌", "癸亥", "甲子", "乙丑",}
    };
    private static final String[] GZ_YEAR = {"甲己", "乙庚", "丙辛", "丁壬", "戊癸"};
    /**
     * 十天干
     */
    private static final String[] TG = {"甲", "乙", "丙 ", "丁", "戊", "己", " 庚", "辛", "壬", "癸"};
    /**
     * 十二地支
     */
    private static final String[] ZHI = {"子", "丑", "寅", "卯", "辰", "巳", "午", "未", "申", "酉", "戌", "亥",};
    /**十二时辰纪日对照表*/
    private static final String[][] GH_TABLE ={
            {"甲子","丙子","戊子","庚子","壬子"},
            {"乙丑","丁丑","己丑","辛丑","癸丑"},
            {"丙寅","戊寅","庚寅","壬寅","甲寅"},
            {"丁卯","己卯","辛卯","癸卯","乙卯"},
            {"戊辰","庚辰","壬辰","甲辰","丙辰"},
            {"己巳","辛巳","癸巳","乙巳","丁巳"},
            {"庚午","壬午","甲午","丙午","戊午"},
            {"辛未","癸未","乙未","丁未","己未"},
            {"壬申","甲申","丙申","戊申","庚申"},
            {"癸酉","乙酉","丁酉","己酉","辛酉"},
            {"甲戌","丙戌","戊戌","庚戌","壬戌"},
            {"乙亥","丁亥","己亥","辛亥","癸亥"},
    };
    /***五行*/
    private static final String[] TIAN_ZHI ={"甲乙", "丙丁", "戊己", "庚辛", "壬癸"};
    private static final String[] WX_TABLE={"木", "火", "土", "金", "水"};
    private static final String[] DI_ZHI={"寅卯", "巳午", "辰丑戌未", "申酉", "亥子"};
    public static void main(String[] args) {
        int year = 2020;
        int nmonth = 1;
        int ymonth =2;
        int day = 12;
        int time=1;
        String gzStr = getYear(year);
        System.out.println(year + "年是:\t\"" + gzStr + "\"年");
        String monStr = getMonth(gzStr, nmonth);
        System.out.println(year + "年农历历" + nmonth + "月" + "是：\t\"" + monStr + "\" 月");
        String dayStr = getDay(year, ymonth, day);
        System.out.println(year + "年阳历" + ymonth + "月" + day + "日" + "是：\t\"" + dayStr + "\" 日");
        String timeStr = getTime(dayStr, time);
        System.out.println(year + "年阳历" + ymonth + "月" + day + "日"+time+"时" + "是：\t\"" + timeStr + "\" 时");


        System.out.println("你的生辰八字为\t"+gzStr+" "+monStr+" "+dayStr+" "+timeStr);

        System.out.println("你的五行：");
        wuxing(gzStr,monStr,dayStr,timeStr);
    }

    /**
     * 获取干支年
     * <p>2020 除以 60 余 40 减去 4 等于 36，对应干支为 庚子年，
     * 当 X 除以 60 的余数小于 4 时，需借干支纪年的一个周期 60 再减 4，
     * 例如 1983 除以 60 余数为 3，直接减 4 不够减，
     * 加上 60 之后再减 4 等于 59，1983 年为 癸亥年</p>
     *
     * @param year {@code int} 公元后的某一年
     * @return {@code String} 返回干支年
     */
    public static String getYear(int year) {
        int gzNum = year % 60;
        String result = "";
        if (gzNum - 4 < 0) {
            gzNum = gzNum + 60 - 4;
        } else {
            gzNum = gzNum - 4;
        }
        for (String gz : GZ) {
            if (gz.contains(gzNum + "")) {
                result = gz.split(" ")[0];
            }
        }
        return result;
    }

    /**
     * 干支月
     * <p>
     * 若遇甲或己的年份 ，正月是丙寅；
     * 遇上乙或庚之年，正月为戊寅；
     * 遇上丙或辛之年，正月为庚寅；
     * 遇上丁或壬之年，正月为壬寅；
     * 遇上戊或癸之年，正月为甲寅。
     * 依照正月之干支，其余月份按干支推算即可
     * </p>
     *
     * @param gzYear {@code String} 干支年
     * @param month  干支月
     * @return
     */
    public static String getMonth(String gzYear, int month) {
        return getString01(gzYear, month, GZ_YEAR);
    }

    /**
     *
     * @param gzYear
     * @param month
     * @param gzYear2
     * @return
     */
    static String getString01(String gzYear, int month, String[] gzYear2) {
        String gzYearStr = gzYear.substring(0, 1);
        String resultStr = "";
        for (int i = 0; i < MyTestPro.GZ_MONTH.length; i++) {
            if (gzYear2[i].contains(gzYearStr)) {
                resultStr = MyTestPro.GZ_MONTH[i][month - 1];
            }
        }
        return resultStr;
    }

    /**
     * 从已知日期计算干支纪日的公式为：
     * 天干 = (4 * C + [C / 4] + 5 * y + [y / 4] + [3 * (M + 1) / 5] + d - 3) % 10
     * 地支 = (8 * C + [C / 4] + 5 * y + [y / 4] + [3 * (M + 1) / 5] + d + 7 + i) % 12
     * <p>
     * c 为年份前两位，比如 2019 年则 c 为 20
     * y 为年份后两位，比如 2019 年则 y 为 19
     * M 为月份，1 月和 2 月按上一年的 13 月和 14 月来算
     * d 为日数
     * i
     * 奇数月为 0
     * 偶数月为 6
     * <p>
     * 比如计算 2020 年 2 月 9 日的干支日如下：
     * 天干 = (4 * 20 + 20 / 4 + 5 * 19 + 19 / 4 + 3 * (14 + 1) / 5 + 9 - 3) % 10 = 9 即 壬
     * 地支 = (8 * 20 + 20 / 4 + 5 * 19 + 19 / 4 + 3 * (14 + 1) / 5 + 9 + 7 + 6) % 12 = 7 即 午
     * </p>
     *
     * @param year  阳历年
     * @param month 阳历月
     * @param day   阳历日
     * @return 干支日
     */
    public static String getDay(int year, int month, int day) {
        /** 获取年份前两位*/
        int C = year / 100;
        /** 年份后两位*/
        int y = year % 100;
        /** 月份*/
        int M = month == 1 ? 13 : month == 2 ? 14 : month;
        int d = day;
        int i = month % 2 == 0 ? 6 : 0;
        if (M == 13 || M == 14) {
            y--;
        }
        int iGan = (4 * C + C / 4 + 5 * y + y / 4 + 3 * (M + 1) / 5 + d - 3) % 10;
        int iZhi = (8 * C + C / 4 + 5 * y + y / 4 + 3 * (M + 1) / 5 + d + 7 + i) % 12;
        return TG[iGan - 1] + ZHI[iZhi - 1];
    }

    /**
     * 干支时
     *
     * @param gzDay 干支日
     * @param time  24小时制
     * @return 干支时
     */
    public static String getTime(String gzDay, int time) {
        int zhiIndex = 0;
        int dayIndex = 0;
        if (time >= 23 | time < 1)
            zhiIndex = 0;
        else if (time >= 1 || time < 3)
            zhiIndex = 1;
        else if (time >= 3 || time < 5)
            zhiIndex = 2;
        else if (time >= 5 || time < 7)
            zhiIndex = 3;
        else if (time >= 7 || time < 9)
            zhiIndex = 4;
        else if (time >= 9 || time < 11)
            zhiIndex = 5;
        else if (time >= 11 || time < 13)
            zhiIndex = 6;
        else if (time >= 13 || time < 15)
            zhiIndex = 7;
        else if (time >= 15 || time < 17)
            zhiIndex = 8;
        else if (time >= 17 || time < 19)
            zhiIndex = 9;
        else if (time >= 19 || time < 21)
            zhiIndex = 10;
        else
            zhiIndex = 11;
        // 取干支日的第一个字
        String dayStr = gzDay.substring(0,1);
        for (int i = 0; i < GZ_YEAR.length; i++) {
            if (GZ_YEAR[i].contains(dayStr)){
                dayIndex = i;
            }

        }
        return GH_TABLE[zhiIndex][dayIndex];
    }

    /**
     *
     * @param gzYear 干支年
     * @param gzMonth 干支月
     * @param gzDay 干支天
     * @param gzHour 干支时
     */
    public static void wuxing(String gzYear,String gzMonth,String gzDay,String gzHour){
        StringBuilder result = new StringBuilder();
//        天干
        String tYear = gzYear.substring(0,1);
        String tMonth = gzMonth.substring(0,1);
        String tDay = gzDay.substring(0,1);
        String tHour = gzHour.substring(0,1);
        for (int i = 0; i < TIAN_ZHI.length; i++) {
            if (TIAN_ZHI[i].contains(tYear)){
                tYear = WX_TABLE[i];
            }
            if (TIAN_ZHI[i].contains(tMonth)){
                tMonth = WX_TABLE[i];
            }
            if (TIAN_ZHI[i].contains(tDay)){
                tDay = WX_TABLE[i];
            }
            if (TIAN_ZHI[i].contains(tHour)){
                tHour = WX_TABLE[i];
            }
        }

//        地支
        String dYear = gzYear.substring(1);
        String dMonth = gzMonth.substring(1);
        String dDay = gzDay.substring(1);
        String dHour = gzHour.substring(1);
        for (int i = 0; i < DI_ZHI.length; i++) {
           if (DI_ZHI[i].contains(dYear)){
               dYear = WX_TABLE[i];
           }
           if (DI_ZHI[i].contains(dMonth)){
               dMonth = WX_TABLE[i];
           }
           if (DI_ZHI[i].contains(dDay)){
               dDay = WX_TABLE[i];
           }
           if (DI_ZHI[i].contains(dHour)){
               dHour = WX_TABLE[i];
           }
        }
        result.append(tYear).append(dYear).append(" ")
                .append(tMonth).append(dMonth).append(" ")
                .append(tDay).append(dDay).append(" ")
                .append(tHour).append(dHour);

        System.out.println(result.toString());
    }


}
