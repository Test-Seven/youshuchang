package com.test.api;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.security.KeyManagementException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.UnrecoverableKeyException;
import java.security.cert.CertificateException;
import java.util.ArrayList;

import junit.framework.TestCase;

//import javax.net.ssl.SSLContext;


import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.ParseException;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.conn.scheme.Scheme;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.conn.ssl.SSLContexts;
import org.apache.http.conn.ssl.SSLSocketFactory;
import org.apache.http.conn.ssl.TrustSelfSignedStrategy;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class HttpApiTest extends TestCase {
	
	@Override
	public void setUp(){
		System.out.println("测试开始");
	}
	@Override
	public void tearDown() {
		System.out.println("测试结束");		
	}
	String resJson;
	public void getResJson(String responseJson) {
		resJson=responseJson;		
	}
	
	//get请求	
	@SuppressWarnings("deprecation")
	public void get(String geturl) throws Exception{
		 long responseLength = 0; // 响应长度  
		 String responseContent = null; // 响应内容 
		 CloseableHttpClient httpclient = HttpClients.createDefault();
		 try {		
//			KeyStore trustStore = KeyStore.getInstance(KeyStore.getDefaultType());  
//            FileInputStream fis = new FileInputStream(new File("C:\\Users\\Book\\weixin.keystore"));  
//            try {  
//                trustStore.load(fis, "123456".toCharArray()); //加载KeyStore  
//            } catch (NoSuchAlgorithmException e) {  
//                e.printStackTrace();  
//            } catch (CertificateException e) {  
//                e.printStackTrace();  
//            } catch (IOException e) {  
//                e.printStackTrace();  
//            } finally {  
//                try {  
//                    fis.close();  
//                } catch (IOException e) {  
//                    e.printStackTrace();  
//                }  
//            }  
//            SSLSocketFactory socketFactory = new SSLSocketFactory(trustStore);   //创建Socket工厂,将trustStore注入  
//            Scheme sch = new Scheme("https", 8443, socketFactory);               //创建Scheme  
//            httpclient.getConnectionManager().getSchemeRegistry().register(sch); //注册Scheme  
			// 创建 get 
			HttpGet httpGet = new HttpGet(geturl);
			
			// 执行get请求.  
			CloseableHttpResponse response = httpclient.execute(httpGet);
			try {
				// 获取响应实体  
				HttpEntity entity = response.getEntity();
				System.out.println("--------------------------------------");
				// 打印响应状态  
				System.out.println(response.getStatusLine());
				if (entity != null) {
					// 打印响应内容长度  
					responseLength = entity.getContentLength();  
					// 打印响应内容  
		            responseContent = EntityUtils.toString(entity, "UTF-8");  
		            EntityUtils.consume(entity); //Consume response content  
				}
				getResJson(responseContent);
				System.out.println("------------------------------------");
				System.out.println("请求地址: " + httpGet.getURI());  
				System.out.println("响应状态: " + response.getStatusLine());  
	            System.out.println("响应长度: " + responseLength);  
	            System.out.println("响应内容: " + responseContent);  
			} finally {
				response.close();
			}
		}
		 //catch (KeyManagementException e) {  
//            e.printStackTrace();  
//        } catch (UnrecoverableKeyException e) {  
//            e.printStackTrace();  
//        } catch (KeyStoreException e) {  
//            e.printStackTrace();  
//        } catch (FileNotFoundException e) {  
//            e.printStackTrace();  
//        } catch (NoSuchAlgorithmException e) {  
//            e.printStackTrace();   
//        } 
	catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			// 关闭连接,释放资源  
			try {
				httpclient.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
	}
	
	@SuppressWarnings({ "deprecation", "finally" })
	public String getSll(String geturl) throws Exception{
		 long responseLength = 0; // 响应长度  
		 String responseContent = null; // 响应内容 
		 CloseableHttpClient httpclient = HttpClients.createDefault();
		 try {		
			KeyStore trustStore = KeyStore.getInstance(KeyStore.getDefaultType());  
           FileInputStream fis = new FileInputStream(new File("C:\\Users\\Book\\weixin.keystore"));  
           try {  
               trustStore.load(fis, "123456".toCharArray()); //加载KeyStore  
           } catch (NoSuchAlgorithmException e) {  
               e.printStackTrace();  
           } catch (CertificateException e) {  
               e.printStackTrace();  
           } catch (IOException e) {  
               e.printStackTrace();  
           } finally {  
               try {  
                   fis.close();  
               } catch (IOException e) {  
                   e.printStackTrace();  
               }  
           }  
           SSLSocketFactory socketFactory = new SSLSocketFactory(trustStore);   //创建Socket工厂,将trustStore注入  
           Scheme sch = new Scheme("https", 8443, socketFactory);               //创建Scheme  
           httpclient.getConnectionManager().getSchemeRegistry().register(sch); //注册Scheme  
			// 创建 get 
			HttpGet httpGet = new HttpGet(geturl);
			
			// 执行get请求.  
			CloseableHttpResponse response = httpclient.execute(httpGet);
			// 获取响应实体  
			HttpEntity entity = response.getEntity();
			System.out.println("--------------------------------------");
			// 打印响应状态  
			System.out.println(response.getStatusLine());
			if (entity != null) {
				// 打印响应内容长度  
				responseLength = entity.getContentLength();  
				// 打印响应内容  
			    responseContent = EntityUtils.toString(entity, "UTF-8");  
			    EntityUtils.consume(entity); //Consume response content  
			}
			System.out.println("------------------------------------");
			System.out.println("请求地址: " + httpGet.getURI());  
			System.out.println("响应状态: " + response.getStatusLine());  
			System.out.println("响应长度: " + responseLength);  
			System.out.println("响应内容: " + responseContent);
       } catch (UnrecoverableKeyException e) {  
           e.printStackTrace();  
       } catch (KeyStoreException e) {  
           e.printStackTrace();  
       } catch (FileNotFoundException e) {  
           e.printStackTrace();  
       } catch (NoSuchAlgorithmException e) {  
           e.printStackTrace();   
       } catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}finally {  
            httpclient.getConnectionManager().shutdown(); //关闭连接,释放资源  
            return responseContent;  
            }
		 }
		
	
	//POST请求
//	public void post(String posturl) {
//		// 创建默认的httpClient实例.  
//		CloseableHttpClient httpclient = HttpClients.createDefault();
//		// 创建post  
//		HttpPost httppost = new HttpPost(posturl);
//		// 创建参数队列  
//		ArrayList<NameValuePair> nameValuePair = new ArrayList<NameValuePair>();
//        nameValuePair.add(new BasicNameValuePair("type", "house"));
//		UrlEncodedFormEntity uefEntity;
//		try {
//			uefEntity = new UrlEncodedFormEntity(nameValuePair, "UTF-8");
//			httppost.setEntity(uefEntity);
//			System.out.println("executing request " + httppost.getURI());
//			CloseableHttpResponse response = httpclient.execute(httppost);
//			try {
//				HttpEntity entity = response.getEntity();
//				if (entity != null) {
//					System.out.println("--------------------------------------");
//					System.out.println("Response content: " + EntityUtils.toString(entity, "UTF-8"));
//					System.out.println("--------------------------------------");
//				}
//			} finally {
//				response.close();
//			}
//		} catch (ClientProtocolException e) {
//			e.printStackTrace();
//		} catch (UnsupportedEncodingException e1) {
//			e1.printStackTrace();
//		} catch (IOException e) {
//			e.printStackTrace();
//		} finally {
//			// 关闭连接,释放资源  
//			try {
//				httpclient.close();
//			} catch (IOException e) {
//				e.printStackTrace();
//			}
//		}
//	}
	
	public static void main(String[] args) throws Exception {
		
		//执行get测试
		HttpApiTest myApiTest=new HttpApiTest();
		myApiTest.get("https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=wxd4856e6c46dc6292&secret=09688403bbb5754ba4101b1bcf80791d");
		JSONObject jsonObject=new JSONObject(myApiTest.resJson);
		String access_token = jsonObject.getString("access_token");
		myApiTest.get("https://api.weixin.qq.com/cgi-bin/get_current_autoreply_info?access_token="+access_token);
	}
}
