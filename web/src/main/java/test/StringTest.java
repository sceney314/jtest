package test;

import sun.misc.BASE64Decoder;

import java.nio.charset.Charset;

/**
 * 字符串比较
 *
 * @author zhengzp
 * 2019-12-09 10:32
 */
public class StringTest {
    public static void main(String[] args) {
        Charset utf8 = Charset.forName("UTF-8");
        BASE64Decoder decoder = new BASE64Decoder();
        try {
            String columnName = new String(decoder.decodeBuffer("ZjpjcmVkaXRfaWQ="), utf8);
            System.out.println(columnName.substring(columnName.indexOf(":") + 1));
            String data = new String(decoder.decodeBuffer("MTA3MDY5MDQ1Nzg3ODQ5NTY2Nw=="), utf8);
            System.out.println(data);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
