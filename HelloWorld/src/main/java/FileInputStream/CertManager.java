package FileInputStream;

import sun.misc.BASE64Encoder;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.security.PublicKey;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

/**
 * Date:     2019/2/15 14:55
 */
public class CertManager
{
    public static void showCertInfo()
    {
        try
        {
            //读取证书文件
            File file = new File("C:\\Users\\zhangjinqiu03\\Desktop\\dev.pem");
            InputStream inStream = new FileInputStream(file);
            //创建X509工厂类
            CertificateFactory cf = CertificateFactory.getInstance("X.509");

            //创建证书对象
            X509Certificate oCert = (X509Certificate)cf.generateCertificate(inStream);
            inStream.close();
            SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            dateformat.setTimeZone(TimeZone.getTimeZone("UTC"));
            String info = null;
            //获得证书版本
            info = String.valueOf(oCert.getVersion());
            System.out.println("证书版本:"+info);
            //获得证书序列号
            info = oCert.getSerialNumber().toString(16);
            System.out.println("证书序列号:"+info);
            //获得证书有效期
            Date beforedate = oCert.getNotBefore();
            info = dateformat.format(beforedate);
            System.out.println("证书生效日期:"+info);
            Date afterdate = oCert.getNotAfter();
            info = dateformat.format(afterdate);
            System.out.println("证书失效日期:"+info);
            //获得证书主体信息
            info = oCert.getSubjectDN().getName();
            System.out.println("证书拥有者:"+info);
            //获得证书颁发者信息
            info = oCert.getIssuerDN().getName();
            System.out.println("证书颁发者:"+info);
            //获得证书签名算法名称
            info = oCert.getSigAlgName();
            System.out.println("证书签名算法:"+info);

            PublicKey publicKey = oCert.getPublicKey();
            BASE64Encoder bse=new BASE64Encoder();
            System.out.println("pk:"+bse.encode(publicKey.getEncoded()));

//            byte[] byt = oCert.getExtensionValue("1.2.86.11.7.9");
//            String strExt = new String(byt);
//            System.out.println("证书扩展域:" + strExt);
//            byt = oCert.getExtensionValue("1.2.86.11.7.1.8");
//            String strExt2 = new String(byt);
//            System.out.println("证书扩展域2:" + strExt2);
        }
        catch (Exception e)
        {
            System.out.println("解析证书出错！");
        }
    }//end showCertInfo

    public static void main(String[] args) {
        CertManager.showCertInfo();
    }
}