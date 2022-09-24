/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author axelf
 */
public class Escuela {

    static String  profesor[];
   static String institucion[][];
    static String materias[][][];
    static String alumnos[][][][];

    public Escuela() {
        profesor = null;
        institucion = null;
        materias = null;
        alumnos = null;
    }

    public Escuela(String[] profesor, String[][] institucion, String[][][] materias, String[][][][] alumnos) {
        this.profesor = profesor;
        this.institucion = institucion;
        this.materias = materias;
        this.alumnos = alumnos;
    }

    public String[] getProfesor() {
        return profesor;
    }

    public void setProfesor(String[] profesor) {
        this.profesor = profesor;
    }

    public String[][] getInstitucion() {
        return institucion;
    }

    public void setInstitucion(String[][] institucion) {
        this.institucion = institucion;
    }

    public String[][][] getMaterias() {
        return materias;
    }

    public void setMaterias(String[][][] materias) {
        this.materias = materias;
    }

    public String[][][][] getAlumnos() {
        return alumnos;
    }

    public void setAlumnos(String[][][][] alumnos) {
        this.alumnos = alumnos;
    }

    public void defineProfesor(int p) {
        if (p <= 0) {
            System.out.println("Error...No se pueden definir los datos");
        } else {
            profesor = new String[p];
            institucion = new String[p][];
            materias = new String[p][][];
            alumnos = new String[p][][][];
        }
    }

    public void defineInstitucion(int p, int inst) {
        
        if (inst == 0) {
            System.out.println("Error...No se pueden definir los datos");
        } else {
            if (validaProfesor(p)) {
                institucion = new String [p][inst];
                materias = new String[inst][][];
                alumnos = new String[inst][][][];
            }
        }
    }

    public void defineMateria(int p, int inst, int mat) {
        if (mat <= 0) {
            System.out.println("Error...No se pueden definir los datos");
        } else {
            if (validaInstitucion(p, inst)) {
                materias[p][inst] = new String[mat];
                alumnos[p][inst] = new String[mat][];
            }
        }
    }

    public void defineAlumno(int p, int inst, int mat, int a) {
        if (a <= 0) {
            System.out.println("Error...No se pueden definir los datos");
        } else {
            if (validaMateria(p, inst, mat)) {
                alumnos[p][inst][mat] = new String[a];
            }
        }
    }
    

    public void cargaProfesor(String... aux) {
        for (int i = 0; i < aux.length; i++) {
            profesor[i] = aux[i];   
        }
          
    }

    public void cargaInstitucion(String... aux) {
        for(int i=0;i<aux.length;i++){
            institucion[0][i]= aux[i]; 
        }   
        for (int i = 0; i < profesor.length; i++) {
            institucion[1][i]=profesor[i];   
        }
    }

    public void cargaMateria(int p, int inst, String... aux) {
        if (validaInstitucion(p, inst)) {
            if (materias[p][inst] == null) {
                materias[p][inst] = aux;
            } else {
                for (int i = 0, j = 0; i < materias[p][inst].length; i++, j++) {
                    if (j >= aux.length) {
                        materias[p][inst][i] = null;
                    } else {
                        materias[p][inst][i] = aux[j];
                    }
                }
            }
        }
    }

    public void cargaAlumno(int p, int inst, int mat, String... aux) {
        if (validaMateria(p, inst, mat)) {
            if (alumnos[p][inst][mat] == null) {
                alumnos[p][inst][mat] = aux;
            } else {
                for (int i = 0, j = 0; i < alumnos[p][inst][mat].length; i++, j++) {
                    if (j >= aux.length) {
                        alumnos[p][inst][mat][i] = null;
                    } else {
                        alumnos[p][inst][mat][i] = aux[j];
                    }
                }
            }
        }
    }

    public boolean validaProfesor(int p) {
        String s=null;
        for(int i =0;i<p;i++){
            if (profesor[i] != null) {
            s=profesor[i];
                }
        }
        if(s!=null){
            return true;
        }
        System.out.println("No se encuentran datos");
        return false;
    }

    public boolean validaInstitucion(int p, int inst) {
        if (!validaProfesor(p)) {
            return false;
        }
        return true;
    }

    public boolean validaMateria(int p, int inst, int mat) {
        if (validaInstitucion(p, inst)) {
            if (materias[p][inst] != null) {
                if (mat < 0 || mat >= materias[p][inst].length) {
                    System.out.println("Error...No hay datos guardados");
                } else {
                    return true;
                }
            } else {
                System.out.println("No hay datos guardados");
            }
        }
        return false;
    }

    public boolean validaAlumno(int p, int inst, int mat, int a) {
        if (validaMateria(p, inst, mat)) {
            if (alumnos[p][inst][mat] != null) {
                if (a < 0 || a >= alumnos[p][inst][mat].length) {
                    System.out.println("Error...No hay datos guardados");
                } else {
                    return true;
                }
            } else {
                System.out.println("No hay datos guardados");
            }
        }
        return false;
    }
    
    public void ActualizaDatos(){
        for(int i=0;i<profesor.length;i++){
            profesor[i]=institucion[i][i];
            
        }
    }
    public void moverAlumno() {

    }

    public void eliminarAlumno() {

    }

    public void eliminarDatos() {

    }

    public String desp() {
        String s = " ";
        int i=0;
        int j=0;
        int k=0;
        int l=0;
        int p=0;
        
        if(profesor ==null) {
          s += "no hay profesores \n";
          return s;
        }else{
            for ( i = 0; i < profesor.length; i++) {
                s += "profesor " + profesor[i] + "\n";
            }
        }
        if(institucion ==null) {
          s += "no hay profesores \n";
          return s;
        }else{
            for ( j = 0; j < institucion.length; j++) {
                s += "instituciones " + institucion[j][j] + "\n";
            }
        }
        
        
        
        
        

        return s;
    }
    
}
