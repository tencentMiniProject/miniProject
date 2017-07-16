package com;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.tls.sigcheck.tls_sigcheck;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class AuthorityInterceptor extends HandlerInterceptorAdapter {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		String username = request.getParameter("username");
		String usersig = request.getParameter("sig");
		if(username == null || usersig == null) return false;


		tls_sigcheck demo = new tls_sigcheck();

		// 使用前请修改动态库的加载路径
        //demo.loadJniLib("D:\\src\\oicq64\\tinyid\\tls_sig_api\\windows\\64\\lib\\jni\\jnisigcheck.dll");
		demo.loadJniLib("/root/webapps/ROOT/WEB-INF/jnisigcheck64.so");
		//demo.loadJniLib("C:\\inetpub\\wwwroot\\miniProject\\web\\WEB-INF\\jnisigcheck32.dll");
		String publicKey = "-----BEGIN PUBLIC KEY-----\n" +
				"MFYwEAYHKoZIzj0CAQYFK4EEAAoDQgAEwAsHaIGe40+6zyNmFCxFHp6Zb1A7ZX7M\n" +
				"qtiFs/bOVwmTCOxSDyu4jv/8popSmrONFj5qIM7bEVHnJ9VV4c0zDQ==\n" +
				"-----END PUBLIC KEY-----\n";
		//int ret = demo.tls_check_signature_ex2(userSig,publicKey,"1400034996","test");
		int ret = demo.tls_check_signature_ex2(usersig, publicKey, "1400034996", username);
		if (0 == ret) {
			return true;
		} else {
			return false;
		}

//		if(null!=request.getParameter("username"))
//			return true;
//		else{
//			System.out.println("AAAAAAAAAA");
//			return false;
//		}
	}
}
