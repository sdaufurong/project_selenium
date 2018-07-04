package com.w2cx.selenium.util;

import org.apache.commons.mail.EmailAttachment;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.MultiPartEmail;


public class SendEmail {
	public static void sendToEmail(String appachmentPath){
		//SimpleEmail email = new SimpleEmail();
		MultiPartEmail email = new MultiPartEmail();
		//HtmlEmail email = new HtmlEmail();
		email.setHostName("smtp.exmail.qq.com");
		email.setAuthentication("yuansr@52cx.com", "Ysr318");


		try {

			//设置附件
			EmailAttachment attachment = new EmailAttachment();
			attachment.setPath(appachmentPath);
			attachment.setDisposition(EmailAttachment.ATTACHMENT);


			//发邮件
			email.setFrom("yuansr@52cx.com");
			//email.addTo("1163276533@qq.com","yuansr@52cx.com");
			email.addTo("1163276533@qq.com");
			email.addTo( "yuansr@52cx.com");
			email.addTo( "343693130@qq.com");
			email.setSubject("W2CX_WEB_UI_自动化测试报告");
			email.setMsg("       大家好！本次UI自动化测试已完成，详情请查看附件！" +"\n"+
					"         本邮件为系统自动发送，请勿回复！");


			//email.setContent(content, "text/html;charset=utf-8");
			//发送附件
			//email.setHtmlMsg("D:/project_selenium/test-output/TestReport/index.html");
			email.attach(attachment);
			email.send();
		} catch (EmailException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println(e);
		}
	}
	/*public static void main(String[] args){

		sendToEmail("D:/project_selenium/test-output/customizeHtml-report/2018-07-04-14-12-16.html");
	}*/
}
