package main;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class FontFileWrite {

 /**
  * @param args
  */
 public static void main(String[] args) {
  // TODO Auto-generated method stub
  /*
   * ���� �ȿ� �ִ� ���ϵ��� �ٸ� ������ �ű�� ����
   */
  
  //�̵����� ����
  String inFolder = ".\\font";
  //�̵����� ����
  String outFolder = "C:\\Windows\\Fonts";
  
  //�̵����� ������ �ִ� ���ϵ��� �д´�.
  List<File> dirList = getDirFileList(inFolder);
  
  //������ �����ŭ ���鼭 ������ �̵���Ų��.
  for (int i=0; i<dirList.size(); i++)
  {
   //i��° ����Ǿ� �ִ� ������ �ҷ��´�.
   String fileName = dirList.get(i).getName();
   
   //���� ������ ���Ѵٸ�
   //fileDelete(inFolder+"\\"+fileName);
   
   //���� ������ ���Ѵٸ�
   //fileCopy(inFolder+"\\"+fileName, outFolder+"\\"+fileName);
   
   //���� �̵��� ���Ѵٸ�
   //fileMove(inFolder+"\\"+fileName, outFolder+"\\"+fileName);
   
   //���� ������ ���Ѵٸ�
   //fileMake("C:/Users/INTERPARK/Desktop/test.txt");
  }
  
  String makeFile = "C:/Users/INTERPARK/Desktop/test.txt";
  
  //������ ���� ���� Ȯ��
  if(fileIsLive(makeFile))
  {
   //������ �����Ҷ� ������ �ҷ��ɴϴ�.
   File f1 = new File(makeFile);
  }else
  {
   //������ ������ ������ �����մϴ�.
   fileMake(makeFile);
  }
  
  
  
 }
 
 //������ ���翩�θ� Ȯ���ϴ� �޼ҵ�
 public static Boolean fileIsLive(String isLivefile) {
  File f1 = new File(isLivefile);
  
  if(f1.exists())
  {
   return true;
  }else
  {
   return false;
  }
 }
 
 //������ �����ϴ� �޼ҵ�
 public static void fileMake(String makeFileName) {
  File f1 = new File(makeFileName);
  try {
   f1.createNewFile();
  } catch (IOException e) {
   // TODO Auto-generated catch block
   e.printStackTrace();
  }
 }
 
 //������ �����ϴ� �޼ҵ�
 public static void fileDelete(String deleteFileName) {
  File I = new File(deleteFileName);
  I.delete();
 }
 
 //������ �����ϴ� �޼ҵ�
 public static void fileCopy(String inFileName, String outFileName) {
  try {
   FileInputStream fis = new FileInputStream(inFileName);
   FileOutputStream fos = new FileOutputStream(outFileName);
   
   int data = 0;
   while((data=fis.read())!=-1) {
    fos.write(data);
   }
   fis.close();
   fos.close();
   
  } catch (IOException e) {
   // TODO Auto-generated catch block
   e.printStackTrace();
  }
 }
 
 //������ �̵��ϴ� �޼ҵ�
 public static void fileMove(String inFileName, String outFileName) {
  try {
   FileInputStream fis = new FileInputStream(inFileName);
   FileOutputStream fos = new FileOutputStream(outFileName);
   
   int data = 0;
   while((data=fis.read())!=-1) {
    fos.write(data);
   }
   fis.close();
   fos.close();
   
   //�����ѵ� ���������� ������
   fileDelete(inFileName);
   
  } catch (IOException e) {
   // TODO Auto-generated catch block
   e.printStackTrace();
  }
 }
 
 //���丮�� ���� ����Ʈ�� �д� �޼ҵ�
 public static List<File> getDirFileList(String dirPath)
 {
  // ���丮 ���� ����Ʈ
  List<File> dirFileList = null;
  
  // ���� ����� ��û�� ���丮�� ������ ���� ��ü�� ������
  File dir = new File(dirPath);
  
  // ���丮�� �����Ѵٸ�
  if (dir.exists())
  {
   // ���� ����� ����
   File[] files = dir.listFiles();
   
   // ���� �迭�� ���� ����Ʈ�� ��ȭ�� 
   dirFileList = Arrays.asList(files);
  }
  
  return dirFileList;
 }
 
}