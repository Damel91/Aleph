package model;

import java.io.Serializable;

public class UserBean implements Serializable{

  private String username, password, nome, cognome, email, telefono, indirizzo, città, nazione;
  private boolean valido;

  public String getNome() {
    return nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public String getCognome() {
    return this.cognome;
  }

  public void setCognome(String cognome) {
    this.cognome = cognome;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String newPassword) {
     this.password = newPassword;
  }

  public String getUsername() {
    return username;
  }

  public void setUserName(String newUsername) {
    username = newUsername;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String newEmail) {
    email = newEmail;
  }

  public String getTelefono() {
    return telefono;
  }

  public void setTelefono(String newTelefono) {
    telefono = newTelefono;
  }

  public String getIndirizzo() {
    return indirizzo;
  }

  public void setIndirizzo(String newIndirizzo) {
    indirizzo = newIndirizzo;
  }

  public String getCittà() {
    return città;
  }

  public void setCittà(String newCittà) {
    città = newCittà;
  }

  public String getNazione() {
    return nazione;
  }

  public void setNazione(String newNazione) {
    nazione = newNazione;
  }

  public boolean isValid() {
    return valido;
  }

  public void setValid(boolean newValido) {
    valido = newValido;
  }

}
