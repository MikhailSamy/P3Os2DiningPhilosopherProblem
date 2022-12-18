/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package OS_project;

import java.util.Date;

/**
 *
 * @author dell
 */
public class CHANGE {
    public void ChangeToSleep(String Case) throws InterruptedException 
    {
        System.out.println(Thread.currentThread().getName() + " " + Case);
        Thread.sleep((int) (Math.random() * 2000));
    }
    
    public String CurrentTime()
    {
        long milles = System.currentTimeMillis();
        Date date = new java.util.Date(milles);
        return date.toString().substring(11,20);
    }
}
