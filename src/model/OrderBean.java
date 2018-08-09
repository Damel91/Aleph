package model;

import java.util.ArrayList;

public class OrderBean {
  private String cliente, dataAcquisto;
  private Cart cart;
  private boolean valido;
  private static int id_acquisto;
  
  public OrderBean() {
	  id_acquisto = id_acquisto+1;
  }

  /**
   * @return the idAcquisto
   */
  public int getIdAcquisto() {
    return OrderBean.id_acquisto;
  }

  /**
   * @return the cliente
   */
  public String getCliente() {
    return cliente;
  }

  /**
   * @param cliente the cliente to set
   */
  public void setCliente(String cliente) {
    this.cliente = cliente;
  }

  /**
   * @return the dataAcquisto
   */
  public String getDataAcquisto() {
    return dataAcquisto;
  }

  /**
   * @param dataAcquisto the dataAcquisto to set
   */
  public void setDataAcquisto(String dataAcquisto) {
    this.dataAcquisto = dataAcquisto;
  }
  
  

  /**
 * @return the cart
 */
public Cart getCart() {
	return cart;
}

/**
 * @param cart the cart to set
 */
public void setCart(Cart cart) {
	this.cart = cart;
}

public boolean isValid() {
    return valido;
  }

  public void setValid(boolean newValido) {
    valido = newValido;
  }

}
