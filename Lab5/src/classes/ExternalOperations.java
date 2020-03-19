package classes;

import java.awt.*;
import java.io.*;
import java.util.Arrays;

public class ExternalOperations {

    public static void save (Catalog catalog) throws IOException {
        try
        {
            FileOutputStream fileOutputStream = new FileOutputStream(catalog.getPath());
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);

            objectOutputStream.writeObject(catalog);
        }
        catch (Exception exception){
            System.out.println(Arrays.toString(exception.getStackTrace()));
        }
    }


        public static Catalog load (String path) {
            Catalog catalog = null;
            try
            {
                FileInputStream fileInputStream= new FileInputStream(path);
                ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);

                catalog = (Catalog) objectInputStream.readObject();
            }
            catch (Exception exception){
                System.out.println(Arrays.toString(exception.getStackTrace()));
            }
            return catalog;
        }

        public static void view (Document document) {
            try {
                Desktop desktop = Desktop.getDesktop();
                String filePath = document.getPath();
                File file = new File(filePath);

                desktop.open(file);
            } catch (Exception exception) {
                System.out.println(Arrays.toString(exception.getStackTrace()));
            }
        }
    }
