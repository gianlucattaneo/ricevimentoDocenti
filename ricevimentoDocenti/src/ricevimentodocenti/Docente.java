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
public class Docente {
    private Integer id;
    private String nome;
    private String giorno;
    private String ora;
    private String note;

    public Docente(){
        this.id = -1;
        this.nome = "";
        this.giorno = "";
        this.ora = "";
        this.note = "";   
    }

    public Docente(Integer id, String nome, String giorno, String ora, String note) {
        this.id = id;
        this.nome = nome;
        this.giorno = giorno;
        this.ora = ora;
        this.note = note;
    }
    
    public String toCSV(){
        String s ="";
        s = id.toString()+";"+nome+";"+giorno+";"+ora+";"+note+"\n";
        return s;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getGiorno() {
        return giorno;
    }

    public void setGiorno(String giorno) {
        this.giorno = giorno;
    }

    public String getOra() {
        return ora;
    }

    public void setOra(String ora) {
        this.ora = ora;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    } 
}
