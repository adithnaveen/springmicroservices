package com.training;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.apache.http.HttpStatus;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import com.sun.jersey.core.util.Base64;


/*
 *  This class is for pending for complete implementation 
 */
@Component
public class ZuulLoggingFilter extends ZuulFilter{
private Logger logger = LoggerFactory.getLogger(this.getClass());
	@Override
	public Object run() throws ZuulException {
		// TODO Auto-generated method stub
		
		RequestContext ctx = RequestContext.getCurrentContext();
        HttpServletRequest request = ctx.getRequest();
        
        logger.info("Processing the URI  --->" + request.getRequestURI());
        
//
//        if (request.getAttribute("AUTH_HEADER") == null) {
//            //generate or get AUTH_TOKEN, ex from Spring Session repository
//            String sessionId = UUID.randomUUID().toString();
//            //request.setAttribute("AUTH_HEADER", sessionId);
//            ctx.addZuulRequestHeader("AUTH_HEADER", sessionId);
//        }
        
		java.util.Date d1=new java.util.Date();
		logger.info("Zuul filter intercepted @:"+d1);
		System.err.print("This is Log...");
		/*try {
		FileWriter file=new FileWriter("test.txt");
		
			file.write("Writing Some log to file...");
			file.write("Request Intercepts Here..@"+d1 );
			file.close();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		
		
		
		
		
	/*	
		try {
			byte [] encoded; 
			
			encoded = Base64.encode("fooClientIdPassword:secret".getBytes("UTF-8"));
			ctx.addZuulRequestHeader("Authorization", "Basic" + new String(encoded));
			
			if(ctx.getRequest().getHeader("Authorization") == null && !request.getContextPath().contains("login")){
				ctx.unset(); 
				ctx.setResponseStatusCode(HttpStatus.SC_UNAUTHORIZED);
			}else{
				System.out.println("Authorization done... ");
			}
			
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	*/	
		
		
		
		return null;
	}

	@Override
	public boolean shouldFilter() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public int filterOrder() {
		// TODO Auto-generated method stub
		return 1;
	}

	@Override
	public String filterType() {
		// TODO Auto-generated method stub
		return "pre";
	}

}
