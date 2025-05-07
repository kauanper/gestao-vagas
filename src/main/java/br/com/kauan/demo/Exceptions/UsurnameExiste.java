package br.com.kauan.demo.Exceptions;

public class UsurnameExiste extends RuntimeException {
    public UsurnameExiste() {
        super("Username ou Email já existe");
    }
}
