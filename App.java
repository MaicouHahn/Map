import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;

public class App {
    public static void main(String[] args) {
        String path = "C:\\Users\\Zeturiell\\Desktop\\Map\\in.txt";
        Map<String, Integer> candidatos = new LinkedHashMap<>();

        try (BufferedReader br = new BufferedReader(new FileReader(path))) {

            String line = br.readLine();
            while (line != null) {

                String[] fields = line.split(",");
                String nome = fields[0];
                Integer voto = Integer.parseInt(fields[1]);

                if (candidatos.containsKey(nome)) {
                    
                    voto += candidatos.get(nome);
                    candidatos.put(nome, voto);

                } else {
                    candidatos.put(nome, voto);
                }
                line = br.readLine();
            }

            for (String key : candidatos.keySet()) {
                System.out.println(key+": "+candidatos.get(key));
            }

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }


    }
}