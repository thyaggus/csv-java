package br.com.tiago.csv;

import com.opencsv.CSVWriter;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

public class GeradorCSV {

    private static void gerarCSV(String filePath) {
        // first create file object for file placed at location
        // specified by filepath
        File file = new File(filePath);

        try {
            // create FileWriter object with file as parameter
            FileWriter outputfile = new FileWriter(file);

            // create CSVWriter with '|' as separator
            CSVWriter writer = new CSVWriter(outputfile, ',',
                    CSVWriter.NO_QUOTE_CHARACTER,
                    CSVWriter.DEFAULT_ESCAPE_CHARACTER,
                    CSVWriter.DEFAULT_LINE_END);

            // create a List which contains String array
            List<String[]> data = new ArrayList<String[]>();
            data.add(new String[] { "Name", "Class", "Marks" });
            data.add(new String[] { "Aman", "10", "620" });
            data.add(new String[] { "Suraj", "10", "630" });
            writer.writeAll(data);

            // closing writer connection
            writer.close();
        }
        catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    private static void gerarCSVStream(String path) {
        // first create file object for file placed at location
        // specified by filepath

        try {
            FileOutputStream fos = new FileOutputStream(path);
            // Creates an OutputStreamWriter
            OutputStreamWriter osw = new OutputStreamWriter(fos);

            CSVWriter csvWriter = new CSVWriter(osw, ',',
                    CSVWriter.NO_QUOTE_CHARACTER,
                    CSVWriter.DEFAULT_ESCAPE_CHARACTER,
                    CSVWriter.DEFAULT_LINE_END);

            List<String[]> data = new ArrayList<>();
            data.add(new String[] { "Name", "Class", "Marks" });
            data.add(new String[] { "Aman", "10", "620" });
            data.add(new String[] { "Suraj", "10", "630" });

            csvWriter.writeAll(data);
            csvWriter.close();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    public static void main(String[] args) {
        gerarCSV("csv.csv");
        gerarCSVStream("stream.csv");
    }
}
