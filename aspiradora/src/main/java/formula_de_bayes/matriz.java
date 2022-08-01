package formula_de_bayes;

public interface Matriz {
     String a[] = {"#_inst", "Estado", "Tempe", "Humedad", "viento", "Clase"};
        

    default public void registros(String [][]b) {
        //3.- En ese método "mensajeHola" vas a imprimir un mensaje como el siguiente --> "Hola mi nombre es: Fernando Mercado"
        String[][] a = {
            {"1", "soleado", "85", "85", "No", "No jugar"}, {"2", "soleado", "80", "90", "Si", "No jugar"},
            {"3", "Nublado", "83", "78", "No", "Jugar"}, {"4", "lluvio", "70", "96", "No", "Jugar"},
            {"5", "lluvio", "68", "80", "No", "Jugar"}, {"6", "lluvio", "65", "70", "Si", "No jugar"},
            {"7", "Nublado", "64", "65", "Si", "Jugar"}, {"8", "soleado", "72", "95", "No", "No jugar"},
            {"9", "soleado", "69", "70", "No", "Jugar"}, {"10", "lluvio", "75", "80", "No", "Jugar"},
            {"11", "soleado", "75", "70", "Si", "Jugar"}, {"12", "Nublado", "72", "90", "Si", "jugar"},
            {"13", "Nublado", "81", "75", "No", "Jugar"}, {"14", "lluvio", "71", "80", "Si", "No jugar"}};
         
    }
}
