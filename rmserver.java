import java.io.*;
import java.net.*;
public class rmserver
{
  public static void main(String args[])throws IOException
  {
     String comd,line,str=" ";
     String newcmd[]=new String[3];
     ServerSocket ss=new ServerSocket(3033);
     System.out.println("\nServer Ready...\n");
    do{
     Socket s=ss.accept();
     System.out.println("Client socket connected...\n");
     BufferedReader br=new BufferedReader(new InputStreamReader(s.getInputStream()));
     PrintWriter pw=new PrintWriter(s.getOutputStream(),true); 
     newcmd[0]="/bin/sh";
     newcmd[1]="-c";
    // DataOutputStream out=new DataOutputStream(s.getOutputStream());
     newcmd[2]=br.readLine();
     //newcmd=newcmd+comd;
  
    try{
          Runtime rt=Runtime.getRuntime();
          Process p=rt.exec(newcmd);
          System.out.println("Command "+newcmd[2]+" is executing...\n");
	    BufferedReader input = new BufferedReader(new InputStreamReader(p.getInputStream()));
            while ((line = input.readLine()) != null) {
              // System.out.println(line);
              str+=line+"\n";
            }
         
         pw.println(str);
         int exitVal = p.waitFor();
         pw.println("Error "+exitVal);
         }
      catch(Exception e)
       {
         System.out.println("Error : "+e);
       }
     pw.close();
       s.close();
   } while(true);
       
    }
}
