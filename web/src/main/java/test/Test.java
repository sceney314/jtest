package test;

import com.alibaba.fastjson.JSON;
import lombok.Data;

import java.util.*;

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