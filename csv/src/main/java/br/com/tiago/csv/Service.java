package br.com.tiago.csv;

import com.opencsv.CSVWriter;

import javax.enterprise.context.RequestScoped;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

@RequestScoped
public class Service {

    public void gerarCSVStream(String path) {
        try {
            FileOutputStream fos = new FileOutputStream(path);
            OutputStreamWriter osw = new OutputStreamWriter(fos);

            CSVWriter csvWriter = new CSVWriter(osw, ',',
                    CSVWriter.NO_QUOTE_CHARACTER,
                    CSVWriter.DEFAULT_ESCAPE_CHARACTER,
                    CSVWriter.DEFAULT_LINE_END);

            List<String[]> data = new ArrayList<>();
            data.add(new String[]{"Name", "Class", "Marks"});
            data.add(new String[]{"Aman", "10", "620"});
            data.add(new String[]{"Suraj", "10", "630"});

            csvWriter.writeAll(data);
            csvWriter.close();


        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
