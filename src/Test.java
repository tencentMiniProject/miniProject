import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import java.io.*;
import java.util.*;
import com.tls.sigcheck.tls_sigcheck;

/**
 * Created by onlymzzhang on 2017-07-09.
 */
public class Test {
    public static void main(String[] args) throws IOException {
        tls_sigcheck demo = new tls_sigcheck();

        // 使用前请修改动态库的加载路径
        // demo.loadJniLib("D:\\src\\oicq64\\tinyid\\tls_sig_api\\windows\\64\\lib\\jni\\jnisigcheck.dll");
        demo.loadJniLib("D:\\JavaProject\\miniProject\\web\\WEB-INF\\jnisigcheck64.dll");

        String userSig = "eJx10E9PgzAYx-E7r6LpFeMKlElNdqhGk82K*yfLTk0D7SwqdFCi1PjeVVwiF8*-T-J98nx4AAC4ZZtzked1V1lueyMhuAQwiMgFgWd-wBhdcGF51BS-ACOEIkzIdKTku9GN5EJZ2QwqjEn47UZEF7KyWukTsLK1o7UtnvmQ*r-R6sMw3t*sruc0d3557IiV6rG6MhkL0uAt631Vl2jnMn*vpM-cWtyuJlTTOS5p7e66Y4pZb9YuUSRKFjSNd-HyieV7PFmINHl58NlhNhslrX49feXnFhROCYLep-cFwFdWqQ__";


        String publicKey = "-----BEGIN PUBLIC KEY-----\n" +
                "MFYwEAYHKoZIzj0CAQYFK4EEAAoDQgAEwAsHaIGe40+6zyNmFCxFHp6Zb1A7ZX7M\n" +
                "qtiFs/bOVwmTCOxSDyu4jv/8popSmrONFj5qIM7bEVHnJ9VV4c0zDQ==\n" +
                "-----END PUBLIC KEY-----\n";
        //int ret = demo.tls_check_signature_ex2(userSig,publicKey,"1400034996","test");
        int ret = demo.tls_check_signature_ex2(userSig,publicKey,"1400034996","test");

        if (0 != ret) {
            System.out.println("ret " + ret + " " + demo.getErrMsg());
        }
        else
        {
            System.out.println("sig123:\n" + demo.getSig());
        }

    }

    public static void main1(String[] args) {
        Map<String,String> mp = new HashMap<String,String>();
        mp.put("usersig","XXXXX");
        mp.put("identifier","admin");
        mp.put("sdkappid","1400034996");
        mp.put("random","213213");
        mp.put("contenttype","json");
        System.out.println(sendPost("https://console.tim.qq.com/v4/registration_service/register_account_v1?" +
                "usersig=xxx&" +
                "identifier=admin&" +
                "sdkappid=1400034996&" +
                "random=99999999" +
                "&contenttype=json",mp));
    }




    public static String sendPost(String url, Map<String,String> params) {
        //实例化httpClient
        CloseableHttpClient httpclient = HttpClients.createDefault();
        //实例化post方法
        HttpPost httpPost = new HttpPost(url);
        //处理参数
        List<NameValuePair> nvps = new ArrayList<NameValuePair>();
        Set<String> keySet = params.keySet();
        for(String key : keySet) {
            nvps.add(new BasicNameValuePair(key, params.get(key)));
        }
        //结果
        CloseableHttpResponse response = null;
        String content="";
        try {
            StringEntity stringEntity = new StringEntity("{}","utf-8");
            httpPost.setEntity(stringEntity);
            //httpPost.
            //执行post方法
            response = httpclient.execute(httpPost);
            if(response.getStatusLine().getStatusCode()==200){
                content = EntityUtils.toString(response.getEntity(),"utf-8");
                //System.out.println(content);
            }
            else System.out.println(response.getStatusLine().getStatusCode());
        } catch (IOException e) {
            e.printStackTrace();
        }
        //System.out.println(content);
        return content;
    }
}
