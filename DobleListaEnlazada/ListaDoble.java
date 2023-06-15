import java.util.Scanner;
import java.util.ArrayList;
import com.panayotis.gnuplot.JavaPlot;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class ListaDoble {

    public static void main(String[] args) throws FileNotFoundException { 
        
        Scanner sc = new Scanner(System.in);
        System.out.print("Numero de arreglos: ");
        int numero = sc.nextInt(); //se refiere a la cantidad de arreglos que contendran los peores casos

        ArrayList<DoubleLinkedList> listasD = new ArrayList<DoubleLinkedList>();
        String archivo = "archivo2.txt";
        PrintWriter oS = new PrintWriter(archivo);

        for (int i = 1; i <= numero; i++) {
            DoubleLinkedList<Integer> lista = new DoubleLinkedList<Integer>();
            for (int j = 0; j < i; j++)
                lista.push(i - j);

            listasD.add(lista);
        }

        for (int i = 0; i < listasD.size(); i++)
            oS.println(String.valueOf(listasD.get(i).ordenamientoInsercion()));

        oS.close();

        JavaPlot p = new JavaPlot();
		p.addPlot("\"archivo2.txt\" with lines");
		p.plot();
    }
}

