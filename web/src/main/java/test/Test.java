package test;

import com.alibaba.fastjson.JSON;
import lombok.Data;

import java.text.SimpleDateFormat;
import java.util.*;
import java.util.regex.Pattern;

/**
 * @author zhengzp
 * 2019-08-05 16:09
 */
public class Test {

    public static void main(String[] args) {
        Contract contract = new Contract();
        contract.setBeginTime(addDate(new Date(), Calendar.DAY_OF_MONTH, -1));
        contract.setEndTime(addDate(new Date(), Calendar.DAY_OF_MONTH, 4));
        contract.setVersion("3.1.5.0-*");
        String version = "3.1.6.0";
        List<Contract> contracts = new ArrayList<>();
        contracts.add(contract);

        for (int i = 0; i < 3; i++){
            try{
                Contract tmp = (Contract)contract.clone();
                contracts.add(tmp);
            }catch (Exception e){
                continue;
            }
        }

        Date date = new Date();
        String year = "yyyy";
        String month = "MM";
        String day = "dd";
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMddhhmmssSSS");
        String DATE_MM_DD_AHH_MM = "MM月dd日 ahh:mm";
        dateFormat.applyPattern(DATE_MM_DD_AHH_MM);
        System.out.println(dateFormat.format(date));


        System.out.println(dateFormat.format(new Date()));
        dateFormat.applyPattern(year);
        System.out.println(dateFormat.format(date));
        dateFormat.applyPattern(month);
        String mm = dateFormat.format(date);
        System.out.println(mm);
        dateFormat.applyPattern(day);
        System.out.println(dateFormat.format(date));
        System.out.println(Integer.valueOf(mm));

        String con = "0";
        String patten = "\\d+";
        System.out.println(Pattern.matches(patten, con));

        String sss = "backParam=好友动态推广位保证金&charset=02&ext=eyJtZXJjaGFudElkIjoiODAwMDEwMDAwMDEwMDMxIiwidHlwZSI6IjcyIn0=&merchantId=800010000010031";
        String[] keys = sss.split("&");
        Map<String, String> param = new HashMap<>();
        for (int i = 0; i < keys.length; i++){
            int first = keys[i].indexOf("=");
            String key = keys[i].substring(0, first);
            String value = keys[i].substring(++first);
            param.put(key, value);
        }

        System.out.println(param);

        System.out.println(13200L%100L);

        System.out.println(1 ^ 3);
        System.out.println(2 ^ 3);

        String cons = "08月15日 Pm04:49";
        System.out.println(cons.toUpperCase().replace("AM", "上午").replace("PM", "下午"));

    }

    public static boolean isValid(Contract contract, String version){
        // 判断是否在有效期内
        if (contract.getBeginTime().getTime() >= System.currentTimeMillis()){
            return false;
        }

        if (contract.getEndTime() != null && contract.getEndTime().getTime() <= System.currentTimeMillis()){
            return false;
        }

        // 判断是否在有效版本中
        // 1.0.0-4.0.0 有效区间、1.0.0|1.0.3|1.0.4枚举、 3.0.0-* 3.0.0版本后有效包括3.0.0、 * 所有版本有效、 *-3.0.0 3.0.0以前版本有效包括3.0.0
        // 所有都生效
        if (contract.getVersion().equals("*")){
            return true;
        }

        if (!contract.getVersion().contains("-")){
            String[] versions = contract.getVersion().split("|");
            List<String> verList = Arrays.asList(versions);
            return verList.contains(version);
        }

        // 左开
        String[] versionArr = contract.getVersion().split("-");
        if (versionArr[0].equals("*")){
            return versionArr[1].compareTo(version) >= 0;
        }

        // 右开
        if (versionArr[1].equals("*")){
            return versionArr[0].compareTo(version) <= 0;
        }

        return versionArr[0].compareTo(version) <= 0 && versionArr[1].compareTo(version) >= 0;
    }

    public static Date addDate(Date date, int field, int interval) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(field, interval);
        return cal.getTime();
    }
}


@Data
class Contract implements Cloneable{
    private Integer id;

    private String contractId;

    private String templateId;

    private String contractName;

    private String subTitle;

    private Date beginTime;

    private Date endTime;

    private String bizType;

    private String version;

    private String desc;

    private Integer isDel;

    private Date createTime;

    private Date updateTime;

    private String templateData;

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}