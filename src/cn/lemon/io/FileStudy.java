package cn.alien95.io;

import java.io.*;
import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by llxal on 2015/11/20.
 */
public class FileStudy {

    public static void main(String[] args) {
        try {
            printfFileContent("./3.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void printfFileContent(String filename) throws IOException {
        File file = new File(filename).getAbsoluteFile();
        if(!file.exists()){
            file.createNewFile();
        }
        FileOutputStream outputStream = new FileOutputStream(file);
        byte[] bytes = new byte[1024];
        for (int i = 0; i < 10; i++) {
            bytes = "caonima".getBytes();
            outputStream.write(bytes);
        }
        outputStream.close();
        DataInputStream dataInputStream = new DataInputStream(new FileInputStream(filename));
        while (dataInputStream.read(bytes) != -1 ){

//            dataInputStream.readByte();  //一个字节的读取字符
//            System.out.print((char) dataInputStream.readByte());
            System.out.println(new String(bytes));
        }
        while (dataInputStream.available() != 0){  //返回能读的byte数量
            dataInputStream.read(bytes);
            System.out.println(new String(bytes));
        }
        dataInputStream.close();

    }

    public static void getFileFromFileReader(String filename){
        try {
            FileReader reader = new FileReader(filename);
            FileWriter writer = new FileWriter(filename);
            for (int i = 0; i < 10; i++) {
                writer.write("哈哈哈哈\n");
            }
            writer.close();  //这里必须要关闭输出流
            BufferedReader bufferedReader = new BufferedReader(reader);
            String s;
            while ( (s = bufferedReader.readLine()) != null)
            System.out.println(s);
            reader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void getFileRandom(String filename) throws IOException {
        RandomAccessFile file = null;
        try {
            file = new RandomAccessFile(filename,"r");
            String s;
            try {
                while ((s = file.readLine()) != null){
                    System.out.println(s);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        file.close();
    }

    public static void getAllFile(String fileName){
        if(getFilenames(fileName) == null){
            return;
        }else {
            for (String name : getFilenames(fileName)) {
                getAllFile(fileName+File.separator+name);   //路径问题不然会出bug
            }
            String[] sort = getFilenames(fileName);
            Arrays.sort(sort,String.CASE_INSENSITIVE_ORDER);
            System.out.println(Arrays.toString(sort));
        }
    }

    public static String[] getFilenames(String fileName){
        return new File(fileName).list((dir, name) -> {
            if(name.startsWith("java")){
                return true;
            }
            return false;
        });
    }

    public static File[] getFiles(String filename){
        return new File(filename).listFiles();
    }

    public static void getString(){
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()){
            System.out.println(scanner.next());
        }
    }
}
