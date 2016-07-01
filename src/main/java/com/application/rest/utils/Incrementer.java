/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.application.rest.utils;

/**
 *
 * @author James Loveday
 */
public class Incrementer {
    
    public static synchronized int getAndIncrement(int i) {
        return i++; 
    }
    
}
