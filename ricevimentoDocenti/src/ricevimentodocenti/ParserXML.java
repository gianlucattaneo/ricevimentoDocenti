/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ricevimentodocenti;

/**
 *
 * @author cattaneo_gianluca
 */
import java.io.IOException;
import java.util.*;
import javax.xml.parsers.*;
import org.w3c.dom.*;
import org.xml.sax.SAXException;

public class ParserXML {

    private List<Docente> docenti;

    public ParserXML() {
        docenti = new ArrayList();
    }

    public List<Docente> parseDocument(String filename)
            throws ParserConfigurationException, SAXException, IOException {
       
        Element element;
        NodeList TRlist,TDlist;
        String docente,giorno,ora,note;
        Integer id;

        TRlist = creaRoot(filename).getElementsByTagName("tr");
        if (TRlist != null && TRlist.getLength() > 0) {        // Se ha trovato qualcosa
            for (int i = 0; i < TRlist.getLength(); i++) {       // per ogni tr
                element = (Element) TRlist.item(i);              // prendo il singolo tr
                TDlist = element.getElementsByTagName("td");       // accedo alla lista di td
                if (TDlist != null && TDlist.getLength() == 5) {   // se ci sono td esattamente 5 td
                    
                    id = Integer.parseInt(TDlist.item(0).getFirstChild().getNodeValue());
                    docente = TDlist.item(1).getFirstChild().getNodeValue();             
                    giorno = TDlist.item(2).getFirstChild().getNodeValue();
                    ora = TDlist.item(3).getFirstChild().getNodeValue();
                    if (TDlist.item(4).getFirstChild() != null){
                        note = TDlist.item(4).getFirstChild().getNodeValue();
                    }else{
                        note = "";
                    }
                    
                    
                    docenti.add(new Docente(id,docente,giorno,ora,note));
                    
                }
            }
        }
        return docenti;
    }
    
   public Element creaRoot(String filename) throws ParserConfigurationException, SAXException, IOException{
       DocumentBuilderFactory factory;
        DocumentBuilder builder;
        Document document;
        Element root;
        
        // creazione dell’albero DOM dal documento XML
        factory = DocumentBuilderFactory.newInstance();
        builder = factory.newDocumentBuilder();
        document = builder.parse(filename);
        root = document.getDocumentElement();
        return root;
   }
       
    public String ArraytoCSV(List<Docente> lista){
        String s= "";      
        for(int i = 0 ; i < lista.size();i++){
            s+=lista.get(i).toCSV();
        }
        return s;
    }
    
    
}
