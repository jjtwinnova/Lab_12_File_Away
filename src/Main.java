import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Path;
import java.util.Scanner;
import javax.swing.JFileChooser;
public class Main
{
    public static void main(String[] args)
    {
        //Declare
        JFileChooser chooser = new JFileChooser();
        Scanner inFile;
        String text;
        Path target = new File(System.getProperty("user.dir")).toPath();
        target = target.resolve("src");

        //get file and find the name
        chooser.setCurrentDirectory(target.toFile());

        try
        {
            if(chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION)
            {
                target = chooser.getSelectedFile().toPath();

                inFile = new Scanner(target);

                File textFile = new File(target.toUri());

                String fileName = textFile.getName();

                while(inFile.hasNextLine())
                {
                    //print name
                    System.out.print("File Name: " +fileName);
                    System.out.println();

                    //find number of lines and print
                    int line = 0;
                    line++;
                    System.out.print("Number of Lines: " +line);
                    System.out.println();

                    //find word total and print
                    text = inFile.nextLine();
                    String[] words = text.split(" ");
                    int wordTotal = words.length;
                    System.out.print("Total Words: " +wordTotal);
                    System.out.println();

                    //find char total and print
                    int charTotal = text.length();
                    System.out.print("Total Characters: " +charTotal);
                }

                inFile.close();
            }
            else

            //User must pick a file
            {
                System.out.println("You must select a file! Try Again!");
                System.exit(0);
            }
        }
        catch (FileNotFoundException e)
        {
            System.out.println("File Not Found Error");
            e.printStackTrace();
        }
        catch (IOException e)
        {
            System.out.println("IOException Error");
            e.printStackTrace();
        }
    }

}
