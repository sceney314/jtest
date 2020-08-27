package test;


/**
 * 2019-12-23 09:57
 */
public class ALTest {

    public static void main(String[] args) {
        int a = 14437785, end = 20_0000, start = 0;
        while (end < a){
            System.out.println("UPDATE `t_loan_info` SET last_debt_type=proto_type WHERE id > " + start + " AND id <= " + end + ";");
            start = end;
            end += 20_0000;
        }
    }

}
