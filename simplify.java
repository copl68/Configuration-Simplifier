import java.io.*;

public class ConfigSimplify
{
    public static void main(String[] args) {
        update_config(args[0]);
    }

    static void update_config(String filePath){
        try{
            File file = new File(filePath);
            BufferedReader reader = new BufferedReader(new FileReader(file));
            String line = reader.readLine();
            int prevWhiteSpace = 0;
            String contents = "";
            while(line != null){
                line = line.replace("'outside_interface'", "outside");
                if((line.length() > 0) && !(line.substring(0,1).equals("!"))){
                    contents = contents + line + System.lineSeparator();
                }
                line = reader.readLine();
            }
            FileWriter writer = new FileWriter(file);
            writer.write(contents);
            writer.flush();
            writer.close();
        }catch(IOException e){
            e.printStackTrace();
        }
    }
}
