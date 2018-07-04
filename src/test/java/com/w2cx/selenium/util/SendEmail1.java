package com.w2cx.selenium.util;
import org.apache.commons.mail.*;


public class SendEmail1 {
	public static void sendToEmail(){
		//SimpleEmail email = new SimpleEmail();
		MultiPartEmail email = new MultiPartEmail();
		//HtmlEmail email = new HtmlEmail();
		email.setHostName("smtp.exmail.qq.com");
		email.setAuthentication("yuansr@52cx.com", "Ysr318");
		ZipFile zipFile;

		try {

			//设置附件1
			EmailAttachment attachment = new EmailAttachment();
			zipFile = new ZipFile("D:/project_selenium/target/surefire-reports/html","W2CX_Web_UI_TestReport.zip");
			try {
				zipFile.compressZip();
			} catch (Exception e) {
				System.out.println("压缩失败！");
				e.printStackTrace();
			}
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

			attachment.setPath("D:/project_selenium/W2CX_Web_UI_TestReport.zip");
			attachment.setDisposition(EmailAttachment.ATTACHMENT);
			//attachment.setDescription("html文件");
			//attachment.setName("index.html");



			//发邮件
			email.setFrom("yuansr@52cx.com");
			//email.addTo("1163276533@qq.com","yuansr@52cx.com");
			email.addTo("1163276533@qq.com");
			email.addTo( "yuansr@52cx.com");
			email.addTo( "343693130@qq.com");
			email.setSubject("W2CX_WEB_自动化测试报告");
			//String content = "测试报告详情请下载附件进行查看";
			//email.setContent("测试报告详情请下载附件进行查看","text/html;charset=utf-8");

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
	public static void main(String[] args){

		sendToEmail();
	}
}
