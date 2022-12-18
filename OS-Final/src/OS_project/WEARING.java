/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package OS_project;

/**
 *
 * @author dell
 */
import java.util.Date;

public class WEARING extends CHANGE implements Runnable 
{

    private final WEARING left_glove;
    private final WEARING right_glove;

    public WEARING (WEARING left_glove,WEARING right_glove)
    {
        this.left_glove = left_glove ;
        this.right_glove = right_glove;
    }

    public static void main(String[] args) throws Exception
    {
        
        WEARING[] people = new WEARING[5];
        WEARING[]gloves = new WEARING[people.length];
        for(int i=0; i< gloves.length; i++)
        {
            gloves[i] = new WEARING(null, null);
        }
        for(int i=0; i< people.length; i++)
        {
            WEARING left_glove= gloves[i];
            WEARING right_glove= gloves[(i+1) % gloves.length];
            if(i== people.length - 1)
            {
                people[i] = new WEARING(right_glove, left_glove);
            }
            else{
                people[i] = new WEARING(left_glove, right_glove);
            }
            Thread thread = new Thread(people[i],"person " + (i+1));
            thread.start();
        }
    }

    

     public void run()
    {
        try {
            while(true)
            {
                ChangeToSleep(CurrentTime() + " Thinking");
                synchronized(left_glove)
                {
                    ChangeToSleep(CurrentTime() + " Take left glove");
                    synchronized(right_glove)
                    {
                        ChangeToSleep(CurrentTime() + " Take right glove");
                        ChangeToSleep(CurrentTime() + " Now he is wearing gloves");
                        ChangeToSleep(CurrentTime() + " Drop right glove");
                    }
                    ChangeToSleep(CurrentTime() + " Drop left glove");
                }
            }
        } catch (InterruptedException e) {
            // TODO: handle exception
            Thread.currentThread().interrupt();
        }
    }

    
   

    public WEARING getLeft_glove() {
        return left_glove;
    }

    public WEARING getRight_glove() {
        return right_glove;
    }
   

}
