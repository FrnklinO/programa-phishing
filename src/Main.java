import javax.swing.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        // Seleccionar el archivo utilizando JOptionPane
        JFileChooser fileChooser = new JFileChooser();
        int result = fileChooser.showOpenDialog(null);

        if (result == JFileChooser.APPROVE_OPTION) {
            String filePath = fileChooser.getSelectedFile().getAbsolutePath(); // Obtener la ruta del archivo seleccionado
            int totalPoints = 0;
            StringBuilder resultMessage = new StringBuilder();

            // Almacena las palabras clave en un conjunto (Set)
            Set<String> palabrasClave = new HashSet<>();
            palabrasClave.add("banco popular");
            palabrasClave.add("paypal");
            palabrasClave.add("Actualice su información");
            palabrasClave.add("Verificación de cuenta");
            palabrasClave.add("Tarjeta de crédito");
            palabrasClave.add("Correo electrónico urgente");
            palabrasClave.add("Facebook");
            palabrasClave.add("Ganador del premio");
            palabrasClave.add("Apple ID");
            palabrasClave.add("Netflix");
            palabrasClave.add("Amazon");
            palabrasClave.add("Verificación de seguridad");
            palabrasClave.add("Restablecer contraseña");
            palabrasClave.add("Phishing");
            palabrasClave.add("Alerta de seguridad");
            palabrasClave.add("Actualizar su perfil");
            palabrasClave.add("Banco Santander");
            palabrasClave.add("Correo electrónico importante");
            palabrasClave.add("Banco de América");
            palabrasClave.add("Cuenta bloqueada");
            palabrasClave.add("Microsoft");
            palabrasClave.add("Verificar su identidad");
            palabrasClave.add("Información confidencial");
            palabrasClave.add("Ganar dinero rápido");
            palabrasClave.add("Comprobar actividad sospechosa");
            palabrasClave.add("Bloqueo");
            palabrasClave.add("Actualización de seguridad");
            palabrasClave.add("Restricción de acceso");
            palabrasClave.add("Descarga segura");
            palabrasClave.add("Premio en efectivo");

            try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    line = line.toLowerCase(); // Convertir a minúsculas para hacer la búsqueda no sensible a mayúsculas
                    int linePoints = countOccurrences(line, palabrasClave);

                    for (String palabraClave : palabrasClave) {
                        if (line.contains(palabraClave)) {
                            linePoints += 2; // Asignar puntos por cada ocurrencia
                        }
                    }

                    if (linePoints > 0) {
                        totalPoints += linePoints;
                        resultMessage.append(line).append(" - Ocurrencias: ").append(linePoints).append("\n");
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

            // Mostrar resultados utilizando JOptionPane
            JOptionPane.showMessageDialog(null, resultMessage.toString(), "Resultados de Análisis", JOptionPane.INFORMATION_MESSAGE);
            JOptionPane.showMessageDialog(null, "Total de puntos: " + totalPoints, "Total de Puntos", JOptionPane.INFORMATION_MESSAGE);
        } else {
            // El usuario canceló la selección de archivo
            JOptionPane.showMessageDialog(null, "No se ha seleccionado ningún archivo.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    // Método para contar las ocurrencias de una palabra clave o frase en una línea
    private static int countOccurrences(String line, Set<String> palabrasClave) {
        int count = 0;
        for (String palabraClave : palabrasClave) {
            int index = line.indexOf(palabraClave);
            while (index != -1) {
                count++;
                index = line.indexOf(palabraClave, index + 1);
            }
        }
        return count;
    }
}