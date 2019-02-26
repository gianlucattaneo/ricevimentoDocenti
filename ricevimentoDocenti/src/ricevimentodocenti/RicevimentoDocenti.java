/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ricevimentodocenti;

import java.io.IOException;
import java.util.List;
import javax.xml.parsers.ParserConfigurationException;
import org.xml.sax.SAXException;

/**
 *
 * @author cattaneo_gianluca
 */
public class RicevimentoDocenti {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {
        ottieniInformazioni();
        
    }
    
    public static void ottieniInformazioni() throws IOException, ParserConfigurationException, SAXException{
        ParserXML parser = new ParserXML();
        List<Docente> lista = parser.parseDocument("ricevimento.xml");
        String CSV = parser.ArraytoCSV(lista);
        System.out.println(CSV);
        MioFile file = new MioFile();
        file.Sovrascrivi("docenti.csv", CSV);
        
    }
    
}
