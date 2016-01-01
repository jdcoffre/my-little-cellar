package org.jdcoffre.mlc.server.data;

import java.io.*;

public class FileUtils {

    private FileUtils(){
        // hide utility class constructor
    }

    public static void serialize(final File folder, final String content, final String fileName) throws IOException {
        if(!folder.exists()){
            folder.mkdirs();
        }

        final File output = new File(folder, fileName);
        FileWriter writer = null;

        try {
            writer = new FileWriter(output);
            writer.write(content);
            writer.flush();
        }
        catch (Exception e){
            throw new IOException("Failed to serialize the notification in folder " + folder.getPath(), e);
        }
        finally {
            if(writer != null){
                writer.close();
            }
        }
    }

    public static String read(final File file) throws IOException {
        final StringBuilder sb = new StringBuilder();
        BufferedReader br = null;

        try {
            String sCurrentLine;

            br = new BufferedReader(new FileReader(file));

            while ((sCurrentLine = br.readLine()) != null) {
                sb.append(sCurrentLine);
            }

        } catch (IOException e) {
            throw new IOException("Failed to read file: " + file.getAbsolutePath(), e);
        } finally {
            if (br != null){br.close();}
        }

        return sb.toString();
    }

}
