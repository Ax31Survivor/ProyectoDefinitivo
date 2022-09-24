/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author axelf
 */
public class Manipula {
    public int pintaMenu(String mnu[])
    {
        try
        {
            System.out.println("-----M E N U------");
            for(int i=0; i<mnu.length;i++)
            {
                System.out.println((i+1)+mnu[i]);
            }
            System.out.println("Elige una opcion:");
            Lectura obj= new Lectura();
            
            return obj.leer();
        } catch (Exception ex)
        {
            System.out.println("Opcion no valida, PROFE-SOR");
        }
        return 0;
    }
}
