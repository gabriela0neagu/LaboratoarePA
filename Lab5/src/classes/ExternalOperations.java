package classes;

import java.awt.*;
import java.io.*;
import java.util.Arrays;

public class ExternalOperations {

    public static void save (Catalog catalog) throws IOException {
        try
        {
            FileOutputStream f= new FileOutputStream(catalog.getPath());
            ObjectOutputStream o = new ObjectOutputStream(f);

            o.writeObject(catalog);
        }
        catch (Exception e){
            System.out.println(Arrays.toString(e.getStackTrace()));
        }
    }

        public static Catalog load (String path) throws IOException, ClassNotFoundException {
            Catalog catalog = null;
            try
            {
                FileInputStream f= new FileInputStream(path);
                ObjectInputStream o = new ObjectInputStream(f);

                catalog = (Catalog) o.readObject();
            }
            catch (Exception e){
                System.out.println(Arrays.toString(e.getStackTrace()));
            }
            return catalog;
        }

        public static void view (Document doc) throws IOException {
            Desktop desktop = Desktop.getDesktop();
            String filePath = doc.getPath();
            File file = new File(filePath);

            desktop.open(file);
        }
    }
