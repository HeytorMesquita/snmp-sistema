package br.com.snmp.helpers;

public class ExistentObjectException extends Exception {
  public ExistentObjectException() {
        super();
  }

  public ExistentObjectException(String message) {
        super(message);
  }
}
