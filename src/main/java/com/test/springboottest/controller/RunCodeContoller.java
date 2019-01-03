package com.test.springboottest.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import java.io.*;

/**
 * @ Author     ：freaxjj.
 * @ Date       ：Created in 3:49 PM 2018/10/26
 * @ Description：编译并且运行JAVA代码
 * @ Modified By：
 */
@Controller
public class RunCodeContoller {

        private static Process process ;//执行子进程

        @GetMapping("test")
        public  String getTest(){
            return "project/test";
        }

        @PostMapping("test")
        public String test(HttpServletRequest req, Model model, @RequestParam(name = "code",value = "code") String code)
                throws ServletException, IOException {

            StringBuilder msg=new StringBuilder();

            String className = null; //类名
            String classStr = null;
            BufferedWriter bw = null;
            try{
                classStr = code.substring(code.indexOf("public class"),code.indexOf("{")).toString();//获取类名字符串
                String[] classStrArray = classStr.split("\\s{1,}");//按空格分开
                if(classStrArray.length!=3){
                    req.setAttribute("msg", "编译失败：格式不符合规范，请检查类名是否正确(如：public class YouClassName{})");
                }
                else{
                    className = classStrArray[classStrArray.length-1];
                    File sourceFile = new File("code/"+className+".java");//保存源代码
                    if(sourceFile.exists()){
                        sourceFile.delete();
                    }
                    FileWriter fr = new FileWriter(sourceFile);
                    bw = new BufferedWriter(fr);
                    bw.write(code);
                    bw.close();
                    fr.close();

                    String[] cmds={"javac "+"./code/"+className+".java \n","java "+"./code/"+className+" \n"};
                    Runtime runtime = Runtime.getRuntime();
                    for(String cmd:cmds){
                        msg=new StringBuilder();
                        process = runtime.exec(cmd);

                        BufferedInputStream in = new BufferedInputStream(process.getInputStream());
                        BufferedReader inBr = new BufferedReader(new InputStreamReader(in));
                        String lineStr;
                        while ((lineStr = inBr.readLine()) != null)
                            msg.append(lineStr+" \n");
                        //检查命令是否执行失败。
                        if (process.waitFor() != 0) {
                            if (process.exitValue() == 1){//p.exitValue()==0表示正常结束，1：非正常结束
                                msg.append("命令执行失败! \n");
                                model.addAttribute("msg",msg.toString());
                                sourceFile.delete();
                                inBr.close();
                                in.close();
                                return "project/test";
                            }
                        }
                        inBr.close();
                        in.close();
                    }


                    //往控制台注入命令
//                    bw = new BufferedWriter(new OutputStreamWriter(process.getOutputStream()));
//                    bw.write("javac "+className+".java \n");
//                    bw.flush();
//                    long startFreeMemory = runtime.freeMemory();//Java 虚拟机中的空闲内存量
//                    //执行时间也是无法知道，因为dos执行java命令，程序无法知道它到底执行到那里了，两个进程，互不了解
//                    long startCurrentTime = System.currentTimeMillis();//获取系统当前时间
//                    bw.write("java "+className+" \n");
//                    bw.close();
//                    //获取控制台输出的结果
//                    Thread runtimeInput = new Thread(new RuntimeInput());
//                    runtimeInput.start();
//
//                    //获取内存信息,实际过程中，是无法得到这个程序到底多少内存，内存的分配有操作系统决定，如果
//                    //程序需要，系统会动态分配内存，如果有对象没有引用，可能会被垃圾回收器回收，所以是无法得到到底多少内存的
//                    //如果你有办法知道，可以留言,现在得到程序运行前后内存使用率，不过输出的是0，因为程序退出，不占内存了
//                    Thread.sleep(1000);
//                    long endCurrentTime = System.currentTimeMillis();
//                    long endFreeMemory = runtime.freeMemory();
//                    double useMemory = (startFreeMemory-endFreeMemory)/1024;
//                    System.out.println("开始时间:"+startCurrentTime);
//                    System.out.println("结束时间:"+endCurrentTime);
//                    long useTime = endCurrentTime-startCurrentTime;
//
                    model.addAttribute("msg",msg.toString());

                }
            }
            catch(Exception e){
                e.printStackTrace();
                model.addAttribute("msg", "格式不符合规范，请检查类名是否正确(如：public class YouClassName{}).错误信息:"+e.getMessage());
            }

            return "project/test";
        }


        public class RuntimeInput implements Runnable{

            @Override
            public void run() {
                BufferedReader br = new BufferedReader(new InputStreamReader(process.getInputStream()));
                String content = null;
                try {
                    while((content = br.readLine()) != null){
                        System.out.println(content);//如果想把结果输出到页面，直接定义变量就行
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        }

}
