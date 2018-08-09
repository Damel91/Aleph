package model;

public class AuthorBean {
  String idAutore, nome, cognome, nazione, dataDiNascita;
  private boolean valido;

  /**
   * @return the idAutore
   */
  public String getIdAutore() {
    return idAutore;
  }

  /**
   * @param idAutore the idAutore to set
   */
  public void setIdAutore(String idAutore) {
    this.idAutore = idAutore;
  }

  /**
   * @return the nome
   */
  public String getNome() {
    return nome;
  }

  /**
   * @param nome the nome to set
   */
  public void setNome(String nome) {
    this.nome = nome;
  }

  /**
   * @return the cognome
   */
  public String getCognome() {
    return cognome;
  }

  /**
   * @param cognome the cognome to set
   */
  public void setCognome(String cognome) {
    this.cognome = cognome;
  }

  /**
   * @return the nazione
   */
  public String getNazione() {
    return nazione;
  }

  /**
   * @param nazione the nazione to set
   */
  public void setNazione(String nazione) {
    this.nazione = nazione;
  }

  /**
   * @return the dataDiNascita
   */
  public String getDataDiNascita() {
    return dataDiNascita;
  }

  /**
   * @param dataDiNascita the dataDiNascita to set
   */
  public void setDataDiNascita(String dataDiNascita) {
    this.dataDiNascita = dataDiNascita;
  }

  public boolean isValid() {
    return valido;
  }

  public void setValid(boolean newValido) {
    valido = newValido;
  }

}
