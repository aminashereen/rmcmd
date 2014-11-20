import java.io.*;
import java.net.*;
public class rmclient
{
   
  public static void main(String args[])throws IOException
  {  
      do{
      Socket s=new Socket("192.168.0.115",3033);
      DataInputStream ins=new DataInputStream(System.in);
      BufferedReader br=new BufferedReader(new InputStreamReader(s.getInputStream()));
      PrintWriter pw=new PrintWriter(s.getOutputStream(),true);
      int k=0;
   
    try{
         String comd,st=" ",err,line;
         System.out.println("\nClient Ready...\n");
         System.out.println("\nServer socket connected...\n");
         System.out.println("Enter the command to be executed ? : Press cntrl+c to exit");
         comd=ins.readLine();
         pw.println(comd);
         while ((line = br.readLine()) != null) {
              // System.out.println(line);
           if(line.contains("Error"))
           {
               k=Integer.parseInt(line.split(" ")[1]);
	   }
          else
              st+=line+"\n";
            }
         System.out.println(st);
         //err=br.readLine();
         System.out.println("Exited with error code "+k);
        } 
        catch(Exception e)
        {
          System.out.println("Error "+e);
        }
         //ins.close();
        // pw.close();
          s.close();
   } while(true);
  }
}
