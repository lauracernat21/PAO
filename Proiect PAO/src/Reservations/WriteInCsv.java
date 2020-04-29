package Reservations;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class WriteInCsv {

    private static WriteInCsv instance = null;

    private static String line;

    private final static String pathHalls = "./src/IOFiles/Halls.csv";
    private final static String pathShows = "./src/IOFiles/Shows.csv";
    private final static String pathSpectators = "./src/IOFiles/Spectators.csv";

    static WriteInCsv getInstance() {

        if (instance == null) {
            instance = new WriteInCsv();
        }
        return instance;
    }

    public void writeTextInCsv(String text, String path) {
        try ( BufferedWriter buffer = new BufferedWriter (new FileWriter (path, true))) {
            buffer.write(text);
            buffer.newLine();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}
