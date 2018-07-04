package com.w2cx.selenium.util;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.zip.CRC32;
import java.util.zip.CheckedOutputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class ZipFile {

    private String sourceFile;
    private String zipFile;
    private String base = "";
    private BufferedInputStream bi;
    private ZipOutputStream zos;
    private File zip;


    public ZipFile(String sourceFile, String zipFile) {
        this.sourceFile = sourceFile;
        this.zipFile = zipFile;
    }

    public void compressZip() throws Exception {
        zip = new File(zipFile);
        File srcFile = new File(sourceFile);
        CheckedOutputStream cos = new CheckedOutputStream(new FileOutputStream(
                zip), new CRC32());
        zos = new ZipOutputStream(cos);
        // 判断文件源文件是文件/文件夹
        if (!srcFile.isDirectory()) {
            compressFile(srcFile, base + srcFile.getName());
        } else {
            compressDir(srcFile, base + srcFile.getName() + File.separator);
        }
        zos.close();
    }

    /**
     * 压缩普通文件
     *
     * @param sourceFile
     * @throws Exception
     */
    public void compressFile(File sourceFile, String entryPath) throws Exception {
        if (!sourceFile.exists()) {
            return;
        }
       // System.out.println("压缩文件开始:" + entryPath);
        bi = new BufferedInputStream(new FileInputStream(sourceFile));
        ZipEntry entry = new ZipEntry(entryPath);
        zos.putNextEntry(entry);
        int count;
        byte data[] = new byte[1024];
        while ((count = bi.read(data, 0, 1024)) != -1) {
            zos.write(data, 0, count);
        }

       // zos.flush();
        bi.close();
        zos.closeEntry();
    }

    /**
     * 压缩文件夹
     *
     * @param dir
     * @param base
     * @throws Exception
     */
    public void compressDir(File dir, String base) throws Exception {
        if (!dir.exists()) {
            return;
        }
        File[] files = dir.listFiles();
        for (File f : files) {
            if (!f.isDirectory()) {
                compressFile(f, base + f.getName());
            } else {
                compressDir(f, base + f.getName() + File.separator);
            }
        }
    }


   /* public static void main(String[] args) {
        ZipFile zipFile = new ZipFile("D:/project_selenium/test-output/TestReport/","TestReport.zip");
        try {
            zipFile.compressZip();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }*/
}
