/**
 * Created by pethe on 06-02-2017.
 */


import java.util.*;
import java.io.*;

public class Create_text_file {

    String filename,filecontent, filegenre;
    public Create_text_file(String file_name, String file_content, String file_genre)
    {
        filename=file_name;
        filecontent=file_content;
        filegenre=file_genre;
        String path=new String("D:\\Test");
        File newfile=new File (path,filename+".txt");
        newfile.setWritable(true);
        try {
            FileWriter pw = new FileWriter(newfile);
            pw.write("Genre: "+filegenre+"\n");
            pw.write(filecontent);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }


    }









}
