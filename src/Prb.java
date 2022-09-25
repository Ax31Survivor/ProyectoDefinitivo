/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.util.Scanner;
/**
 *
 * @author axelf
 */
public class Prb {

    public static void main(String[] args) {
        {
            Escuela e = new Escuela();
            Manipula obj = new Manipula();
            Scanner sc = new Scanner(System.in);
            Lectura l = new Lectura();
            int x = 0;
            int p = 0, inst = 0, mat = 0, a = 0;
            String aux[];
            String mnu[] = {".- Define profesores", ".- Define instituciones", ".- Define materias", ".- Define alumnos", ".- Carga profesores ", ".- Carga instituciones ", ".- Carga Materia", ".- Carga alumno", ".- Carga muestra", ".- Mueve alumno ", ".- Elimina alumno", ".- Elimina alumnos", ".- Salir..."};
            do {
                x = obj.pintaMenu(mnu);
                switch (x) {
                    case 1:
                        int cont = 0;
                        if (cont <= 0) {
                            System.out.println("¿Cuantos profesores quieres registrar?");
                            p = sc.nextInt();
                            e.defineProfesor(p);
                            System.out.println("Se definieron de manera correcta los datos");
                        } else {
                            System.out.println("Error...Intenta de nuevo");
                        }
                        cont++;
                        break;
                    case 2:
                            if (e.validaInstitucion(p, inst)) {
                            System.out.println("¿Cuantas instituciones deseas registrar?");
                            inst = sc.nextInt();
                            e.defineInstitucion(p, inst);
                            System.out.println("Se definieron de manera correcta los datos");
                        } else {
                            System.out.println("Error...Intenta de nuevo");
                        }
                        break;
                    case 3:
                        if (e.validaMateria(p, inst, mat)) {
                            System.out.println("¿Cuantas materias quieres registrar?");
                            mat = sc.nextInt();
                            e.defineMateria(p, inst, mat);
                            System.out.println("Se definieron de manera correcta los datos");
                        } else {
                            System.out.println("Error...Intenta de nuevo");
                        }
                        break;
                    case 4:
                        if (e.validaAlumno(p, inst, mat, a)) {
                            System.out.println("¿Cuantos alumnos quieres registrar?");
                            a = sc.nextInt();
                            e.defineAlumno(p, inst, mat, a);
                            System.out.println("Se definieron de manera correcta los datos");
                        } else {
                            System.out.println("Error...Intentalo de nuevo");
                        }
                        break;
                    case 5:
                        aux = new String[p];
                        for (int i = 0; i < p; i++) {
                            System.out.println("Ingresa el nombre de los profesores");
                             
                            aux[i] = sc.next();
                            
                        }
                        e.cargaProfesor(aux);
                        break;
                    case 6:
                        aux = new String[inst];
                        for (int i = 0; i < inst; i++) {
                            System.out.println("Ingresa el nombre de las instituciones");
                            aux[i] = sc.next();  
                        }
                        e.cargaInstitucion(aux);
                        break;
                    case 7:
                        aux = new String[mat];
                        for (int i = 0; i < mat; i++) {
                            System.out.println("Ingresa el nombre de las materias");
                            
                            aux[i] = sc.next();
                            
                        }
                        e.cargaMateria(aux);
                        break;
                    case 8:
                        aux= new String[a];
                        for (int i = 0; i < a; i++) {
                            System.out.println("Ingresa el nombre de los alumnos");
                            
                            aux[i] = sc.next();
                            
                        }
                        e.cargaAlumno(aux);
                        break;
                    case 9:
                        System.out.println(e.desp());
                        break;
                    case 10:
                        
                        break;
                    case 11:
                        String Alumno;
                         System.out.println("Ingresa el nombre del alumno a eleminar\n");
                         Alumno= sc.next();
                         if(e.eliminarAlumno(Alumno)){
                             System.out.println("se ha eliminado a \n "+Alumno);
                         }
                         System.out.println("No se ha encontrado al alumno "+Alumno);
                        break;
                    case 12:
                        break;
                    case 13:
                        System.out.println("Saliendo del programa...");
                        break;
                }
            } while (x != 13);
        }
    }
}
