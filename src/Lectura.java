
import java.io.BufferedReader;
import java.io.InputStreamReader;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author axelf
 */
public class Lectura {
    InputStreamReader isr=new InputStreamReader(System.in);
    BufferedReader br= new BufferedReader(isr);
    public int leer() throws Exception
    {
        return Integer.parseInt(br.readLine());   
    }
}
