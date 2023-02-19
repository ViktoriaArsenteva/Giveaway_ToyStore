import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import Toys.*;


public class AddToy {
    
    public void CreateFile() {
        Scanner write = new Scanner(System.in);
        System.out.println("Введите название игрушки: ");
        String name = write.nextLine();
        String filename = "Toys/"+name + ".java";
        Path newFilePath = Paths.get(filename);
        System.out.println("Введите уникальный номер игрушки: ");
        int id = write.nextInt();
        
        try {
            Files.createFile(newFilePath);
            final char dm = (char) 34;
            String text = "package Toys;\n public class " + name + " extends Toy { \n    public " + name + "(int id, String name, int frequency) { \n     super("+ id +", "+ dm + name + dm + ", frequency);\n}\n}";
 
            try {
                Files.write(newFilePath, text.getBytes(), StandardOpenOption.APPEND);

            } catch (IOException e) {
                e.printStackTrace();
        }
        } catch (Exception e) {
            System.out.println("Игрушка с таким названием уже существует. Введите другое: ");
            CreateFile();
        }
        
        
    }
    public ArrayList<String> ToyList() {
        String rootDir = "Toys/";
        ArrayList<String> Toyslist = new ArrayList<String>();
            try {
                Files.walkFileTree(Paths.get(rootDir), new SimpleFileVisitor<Path>()
                {
                    @Override
                    public FileVisitResult visitFile(Path filePath,
                                                    BasicFileAttributes attributes)
                    {
                        String filename = filePath.getFileName().toString();
                        String name = filename.substring(0, filename.lastIndexOf('.'));
                        if (name.contains("Toy"))
                        {
                            return FileVisitResult.CONTINUE;
                            
                        }
                        else
                        {
                            Toyslist.add(name);
                            return FileVisitResult.CONTINUE;
                        }
                        
                    }
                });
            } catch (IOException e) {
                e.printStackTrace();
            }
            return Toyslist;
        }
    
    
        
    
}
