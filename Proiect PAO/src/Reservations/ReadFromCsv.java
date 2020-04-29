package Reservations;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ReadFromCsv {

    private static ReadFromCsv instance = null;

    private final static String pathHalls = "./src/IOFiles/Halls.csv";
    private final static String pathShows = "./src/IOFiles/Shows.csv";
    private final static String pathSpectators = "./src/IOFiles/Spectators.csv";

    static ReadFromCsv getInstance() {

        if (instance == null) {
            instance = new ReadFromCsv();
        }
        return instance;
    }

    public static List<Hall> readHalls() {
        List<Hall> halls = new ArrayList<>();
        try (BufferedReader buffer = new BufferedReader(new FileReader(pathHalls))){
                String line = buffer.readLine();
                while (line != null) {
                    String[] data = line.split(",");
                    Hall hall = new Hall(Integer.parseInt(data[0]), Integer.parseInt(data[1]), Integer.parseInt(data[2]), Integer.parseInt(data[3]));
                    hall.initialization();
                    halls.add(hall);
                    line = buffer.readLine();
                }
            }
            catch (IOException e) {
            e.printStackTrace();
        }
        return halls;
    }

    public static List<Show> readShows() {
        int i = 0;
        List<Show> shows = new ArrayList<>();
        try (BufferedReader buffer = new BufferedReader(new FileReader(pathShows))){
                String line = buffer.readLine();
                while (line != null) {
                    String[] data = line.split(",");
                    Hall hall = readHalls().get(i);
                    i++;
                    Show show = new Show(data[0], data[1], hall, Float.parseFloat(data[2]));
                    shows.add(show);
                    line = buffer.readLine();
                }
            }
            catch (IOException e){
            e.printStackTrace();
        }
        return shows;
    }

    public static List<Spectator> readSpectators() {
        List<Spectator> spectators = new ArrayList<>();
        try (BufferedReader buffer = new BufferedReader(new FileReader(pathSpectators))) {
                String line = buffer.readLine();
                while (line != null) {
                    String[] data = line.split(",");
                    Spectator spectator = new Spectator(data[0], Integer.parseInt(data[1]));
                    spectators.add(spectator);
                    line = buffer.readLine();
                }
            }
            catch (IOException e){
            e.printStackTrace();
        }
        return spectators;
    }
}

