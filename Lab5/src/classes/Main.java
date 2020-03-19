package classes;

import java.io.IOException;

public class Main {
    public static void main(String args[]) throws IOException, ClassNotFoundException {
        Catalog catalog = new Catalog("Java Resources", "c:/Users/gabri/OneDrive/Desktop/catalog.ser");

        Document document1 = new Document("java1", "Java Course 1", "c:/Users/gabri/OneDrive/Desktop/intro_slide_en.pdf");
        document1.addTag("type", "Slides");
        catalog.add(document1);

        ExternalOperations.save(catalog);

        Catalog catalog2 = ExternalOperations.load("c:/Users/gabri/OneDrive/Desktop/catalog.ser");
        Document document2 = catalog.findById("java1");
        ExternalOperations.view(document2);
    }
}
