
<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0"
         xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
    <modelVersion>4.0.0</modelVersion>

    <groupId>com.zeus.software</groupId>
    <artifactId>prevent-screen-lock</artifactId>
    <version>1.0-SNAPSHOT</version>


    <dependencies>
        <dependency>
            <groupId>org.slf4j</groupId>
            <artifactId>slf4j-api</artifactId>
            <version>${slf4j-api.version}</version>
        </dependency>
        <dependency>
            <groupId>org.slf4j</groupId>
            <artifactId>slf4j-jdk14</artifactId>
            <version>${slf4j-api.version}</version>
        </dependency>
    </dependencies>
    <properties>
        <slf4j-api.version>2.0.0-alpha0</slf4j-api.version>
        <maven.compiler.target>1.8</maven.compiler.target>
        <maven.compiler.source>1.8</maven.compiler.source>
    </properties>

    <build>
        <plugins>
            <plugin>
                <groupId>org.apache.maven.plugins</groupId>
                <artifactId>maven-assembly-plugin</artifactId>
                <version>2.5.5</version>
                <configuration>
                    <archive>
                        <manifest>
                            <mainClass>com.zeus.software.preventscreenlock.App</mainClass>
                        </manifest>
                    </archive>
                    <descriptorRefs>
                        <descriptorRef>jar-with-dependencies</descriptorRef>
                    </descriptorRefs>
                </configuration>
                <executions>
                    <execution>
                        <id>make-assembly</id>
                        <phase>package</phase>
                        <goals>
                            <goal>single</goal>
                        </goals>
                    </execution>
                </executions>
            </plugin>
        </plugins>
    </build>
</project>


=========

package com.zeus.software.preventscreenlock;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.util.Random;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author Zhang Jinzhong
 * @version V1.0
 * @since 2019-10-08 14:36
 */
public class App {

    private static Logger logger = LoggerFactory.getLogger(App.class);

    public static void main(String[] args) {

        logger.info("开始执行lock");
        long begain = System.currentTimeMillis();//开始系统时间
        logger.info("开始时间 {}",begain);
        Random random = new Random();
        final int max = 800;

        long CheckTime = System.currentTimeMillis(); //判断时间
        boolean inputFlag = true;
        while (true) {

            logger.info("已经运行{}分钟",(CheckTime-begain)/1000/60);
            pressSingleKeyByNumber(KeyEvent.VK_PAUSE);
            try {
                final int millis = 60000;
                Thread.sleep(millis);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            CheckTime = System.currentTimeMillis();
            if( (CheckTime-begain)>=(11*1000*60*60) ){//判断时候到多少小时
                logger.info("结束时间 {}",CheckTime);
                break;
            }
            /*
            if( (CheckTime-begain)>=(15*1000) && inputFlag){
                pressSingleKeyByNumber(KeyEvent.VK_S);
                pressSingleKeyByNumber(KeyEvent.VK_J);
                pressSingleKeyByNumber(KeyEvent.VK_K);
                pressSingleKeyByNumber(KeyEvent.VK_M);
                pressSingleKeyByNumber(KeyEvent.VK_M);
                pressSingleKeyByNumber(KeyEvent.VK_1);
                pressSingleKeyByNumber(KeyEvent.VK_SHIFT);
                pressSingleKeyByNumber(KeyEvent.VK_R);
                pressSingleKeyByNumber(KeyEvent.VK_O);
                pressSingleKeyByNumber(KeyEvent.VK_O);
                pressSingleKeyByNumber(KeyEvent.VK_T);
                pressSingleKeyByNumber(KeyEvent.VK_ENTER);
                pressSingleKeyByNumber(KeyEvent.VK_ENTER);
                inputFlag = false;

            }
            */
        }
    }

    /**
     * 模拟按下键盘单个按键，比如文档下一页：PgDn，上一页是PgUp等
     *
     * @param keycode：按键的值,如：KeyEvent.VK_PAGE_UP
     */
    public static final void pressSingleKeyByNumber(int keycode) {
        try {
            /** 创建自动化测试对象  */
            Robot robot = new Robot();
            /**按下按键*/
            robot.keyPress(keycode);
            /**松开按键*/
            robot.keyRelease(keycode);
            /**可以稍作延时处理*/
            robot.delay(500);
        } catch (AWTException e) {
            e.printStackTrace();
        }
    }

    /**
     * 自动将鼠标移动到指定的位置
     * 如果参数x与y为null,则默认将鼠标放在屏幕右侧中间隐藏
     *
     * @param x：x坐标 ,左上角 为0----设定值超过屏幕分辨率也没关系
     * @param y：y坐标 ,左上角 为0----设定值超过屏幕分辨率也没关系
     */
    public static final void mouseMoveToXY(Integer x, Integer y) {
        try {
            /**创建工具包对象*/
            Toolkit toolkit = Toolkit.getDefaultToolkit();
            /**创建自动化对象*/
            Robot robot = new Robot();
            /**利用工具包对象获取屏幕分辨率*/
            if (x == null) {
                x = toolkit.getScreenSize().width;
            }
            if (y == null) {
                y = toolkit.getScreenSize().height / 2;
            }
            /**
             * 移动鼠标到指定位置
             *  robot.delay(100);延时100毫秒
             */
            robot.mouseMove(x, y);
            robot.delay(100);
        } catch (AWTException e) {
            e.printStackTrace();
        }
    }
}

=====

