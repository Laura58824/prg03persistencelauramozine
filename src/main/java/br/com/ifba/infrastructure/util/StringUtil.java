/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.ifba.infrastructure.util;

/**
 *
 * @author m
 */
public class StringUtil {

    public static boolean isNullOrEmpty(String texto) {
    // Verifica:
    // 1. se a String é null
    // 2. remove espaços com trim()
    // 3. verifica se ficou vazia com isEmpty()
         return texto == null || texto.trim().isEmpty();
    }
    
}
