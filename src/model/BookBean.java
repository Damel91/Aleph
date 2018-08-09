package model;

public class BookBean {
  private String isbn, titolo, genere, casaEditrice, immagine, dataOra, anno, autore;
  private double prezzo;
  private int numeroCopie;

  private boolean valido;

  /**
   * @return the dataOra
   */
  public String getDataOra() {
    return dataOra;
  }

  /**
   * @param dataOra the dataOra to set
   */
  public void setDataOra(String dataOra) {
    this.dataOra = dataOra;
  }

  /**
   * @return the immagine
   */
  public String getImmagine() {
    return immagine;
  }

  /**
   * @param immagine the immagine to set
   */
  public void setImmagine(String immagine) {
    this.immagine = immagine;
  }

  public void setTitolo(String titolo) {
    this.titolo = titolo;
  }

  public String getTitolo() {
    return titolo;
  }

  /**
   * @return the isbn
   */
  public String getIsbn() {
    return isbn;
  }

  /**
   * @param isbn the isbn to set
   */
  public void setIsbn(String isbn) {
    this.isbn = isbn;
  }

  /**
   * @return the genere
   */
  public String getGenere() {
    return genere;
  }

  /**
   * @param genere the genere to set
   */
  public void setGenere(String genere) {
    this.genere = genere;
  }
  
  

  /**
 * @return the autore
 */
public String getAutore() {
	return autore;
}

/**
 * @param autore the autore to set
 */
public void setAutore(String autore) {
	this.autore = autore;
}

/**
   * @return the casaEditrice
   */
  public String getCasaEditrice() {
    return casaEditrice;
  }

  /**
   * @param casaEditrice the casaEditrice to set
   */
  public void setCasaEditrice(String casaEditrice) {
    this.casaEditrice = casaEditrice;
  }

  /**
   * @return the prezzo
   */
  public double getPrezzo() {
    return prezzo;
  }

  /**
   * @param prezzo the prezzo to set
   */
  public void setPrezzo(double prezzo) {
    this.prezzo = prezzo;
  }

  /**
   * @return the numeroCopie
   */
  public int getNumeroCopie() {
    return numeroCopie;
  }

  /**
   * @param numeroCopie the numeroCopie to set
   */
  public void setNumeroCopie(int numeroCopie) {
    this.numeroCopie = numeroCopie;
  }
  

  /**
 * @return the anno
 */
public String getAnno() {
	return anno;
}

/**
 * @param anno the anno to set
 */
public void setAnno(String anno) {
	this.anno = anno;
}

public boolean isValid() {
    return valido;
  }

  public void setValid(boolean newValido) {
    valido = newValido;
  }
  
  public Object clone() {
	 BookBean b = new BookBean();
	 b.setIsbn(isbn);
	 b.setAutore(autore);
	 b.setAnno(anno);
	 b.setCasaEditrice(casaEditrice);
	 b.setDataOra(dataOra);
	 b.setImmagine(immagine);
	 b.setTitolo(titolo);
	 b.setPrezzo(prezzo);
	 b.setNumeroCopie(numeroCopie);
	 
	return b;
	  
  }
}
