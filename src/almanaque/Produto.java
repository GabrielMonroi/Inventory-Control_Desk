/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package almanaque;

/**
 *
 * @author Biel
 */
public class Produto {
    
    private int id;
    private String descricao;
    private int qtd,qtdnova;
    private String cat;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public int getQtd() {
        
        return qtd;
    }

    public void setQtd(int qtd) {
        this.qtd = qtd;
    }

    public String getCat() {
        return cat;
    }

    public void setCat(String cat) {
        this.cat = cat;
    } 

    @Override
    public String toString() {
        return getDescricao(); 
    }

    /**
     * @return the qtdnova
     */
    public int getQtdnova() {
        qtdnova=qtd-qtdnova;
        return qtdnova;
    }

    /**
     * @param qtdnova the qtdnova to set
     */
    public void setQtdnova(int qtdnova) {
        this.qtdnova = qtdnova;
    }
    
    
    
}
