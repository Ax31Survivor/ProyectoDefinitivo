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
            String aux = "";
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
                        
                        for (int i = 0; i < p; i++) {
                            System.out.println("Ingresa el nombre de los profesores");
                            aux = sc.next();
                            
                            e.cargaProfesor(aux);
                            aux = null;
                        }
                        break;
                    case 6:
                        for (int i = 0; i < inst; i++) {
                            System.out.println("Ingresa el nombre de las instituciones");
                            aux = sc.next();
                            e.cargaInstitucion(i, aux);
                        }
                        break;
                    case 7:
                        for (int i = 0; i < mat; i++) {
                            System.out.println("Ingresa el nombre de las materias");
                            aux = sc.next();
                            e.cargaMateria(p, inst, aux);
                        }
                        break;
                    case 8:
                        for (int i = 0; i < a; i++) {
                            System.out.println("Ingresa el nombre de los alumnos");
                            aux = sc.next();
                            e.cargaAlumno(p, inst, mat, aux);
                        }
                        break;
                    case 9:
                        System.out.println(e.desp());
                        break;
                    case 10:
                        break;
                    case 11:
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
