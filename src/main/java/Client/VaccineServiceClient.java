package Client;

import Core.VaccineRegService;

import java.io.*;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class VaccineServiceClient
{
    public static void main(String[] args)
    {
        Socket dataSocket = null;
        try
        {
            dataSocket = new Socket("localhost", VaccineRegService.LISTENING_PORT);
            OutputStream out =dataSocket.getOutputStream();
            PrintWriter output = new PrintWriter(new OutputStreamWriter(out));
            InputStream in= dataSocket.getInputStream();
            Scanner input = new Scanner(new InputStreamReader(in));

            Scanner keyboard = new Scanner (System.in);

            String message = "";
            Scanner kb = new Scanner(System.in);

            while (!message.equals(VaccineRegService.CLOSE))
            {
                int choice = getNumber(keyboard);
                String response = "";

                if(choice >0&& choice <3)
                {
                    switch(choice)
                    {
                        case 0:
                            message=VaccineRegService.CLOSE;



                    }
                }
                else
                {
                    System.out.println("please enter a valid number");
                }
            }
        }
        catch (UnknownHostException e)
        {
            e.printStackTrace();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }
//gets valid number from user
    public static int getNumber(Scanner keyboard)
    {
        boolean numberEntered = false;
        int number = 0;
        while(!numberEntered)
        {
            try
            {
                number = keyboard.nextInt();
                numberEntered = true;
            }
            catch(InputMismatchException e)
            {
                System.out.println("Please enter a number: ");
                keyboard.nextLine();
            }
        }
        keyboard.nextLine();
        return number;
    }


}
